package com.bubbles.hotfudge.api;

import static spark.Spark.after;
import static spark.Spark.exception;
import static spark.Spark.get;
import static spark.Spark.post;

import java.util.ArrayList;

import com.bubbles.hotfudge.constants.ContentType;
import com.bubbles.hotfudge.constants.HttpStatusCode;
import com.bubbles.hotfudge.dao.impl.GenericHotFudgeSundaeImpl;
import com.bubbles.hotfudge.dao.impl.GenericReviewImpl;
import com.bubbles.hotfudge.exceptions.HotFudgeException;
import com.bubbles.hotfudge.exceptions.HotFudgeServiceException;
import com.bubbles.hotfudge.model.HotFudgeError;
import com.bubbles.hotfudge.model.HotFudgeSundae;
import com.bubbles.hotfudge.model.Review;
import com.bubbles.hotfudge.service.HotFudgeSundaeService;
import com.bubbles.hotfudge.service.ReviewService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import spark.Request;


public class HotFudgeSundaeAPI {
		
	//TODO: Create API tests
	//TODO: Implement exception handling
	//TODO: Return errors wrapped in json
	//TODO: Swap generic impls with database impls
	public static void main(String[] args) {
		
		HotFudgeSundaeService sundaeService = 
				new HotFudgeSundaeService(
						new GenericHotFudgeSundaeImpl(
								new ArrayList<HotFudgeSundae>()));
		
		ReviewService reviewService = 
				new ReviewService(
						new GenericReviewImpl(
								new ArrayList<Review>()), sundaeService.getSundaeDAO());
		
		ObjectMapper objMapper = new ObjectMapper();
												
		get("/sundaes", ContentType.APPLICATION_JSON, (req, res) -> {
			return sundaeService.getSundaes();
		}, objMapper::writeValueAsString);
		
		post("/sundaes", ContentType.APPLICATION_JSON, (req, res) -> {
			HotFudgeSundae sundae = objMapper.readValue(req.body(), HotFudgeSundae.class);
			try {
				sundaeService.addNewSundae(sundae);
			}
			catch (HotFudgeServiceException e) {
				throw new HotFudgeException(e.getMessage(), HttpStatusCode.INTERNAL_ERROR);
			}
			return sundae;
		}, objMapper::writeValueAsString);
		
		get("/sundaes/:id", ContentType.APPLICATION_JSON, (req, res) -> {
			int id = getIdFromPath(req);
			HotFudgeSundae sundae = sundaeService.getSundae(id);
			if (sundae != null) {
				return sundae;
			}
			throw new HotFudgeException("Sundae with id: " + id + " not found", HttpStatusCode.RESOURCE_NOT_FOUND);
		}, objMapper::writeValueAsString);
		
		get("/sundaes/:id/reviews", ContentType.APPLICATION_JSON, (req, res) -> {
			return reviewService.getReviewsForSundae(getIdFromPath(req));
		}, objMapper::writeValueAsString);
		
		post("/sundaes/:id/reviews", ContentType.APPLICATION_JSON, (req, res) -> {
			Review review = objMapper.readValue(req.body(), Review.class);
			reviewService.addReview(review, getIdFromPath(req));
			return review;
		}, objMapper::writeValueAsString);
		
		exception(HotFudgeException.class, (exc, req, res) -> {
			HotFudgeException hfexc = (HotFudgeException) exc;
			HotFudgeError err = new HotFudgeError(hfexc.getMessage(), hfexc.getStatusCode());
			res.body(mapToJSON(err, objMapper));
		});
		
		after((req, res) -> {
			res.type(ContentType.APPLICATION_JSON);
		});

	}
	
	private static String mapToJSON(Object obj, ObjectMapper mapper) {
		try {
			return mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			return "Oops, something went wrong.";
		}
	}
	
	private static int getIdFromPath(Request req) {
		return Integer.parseInt(req.params("id"));
	}
	
}
