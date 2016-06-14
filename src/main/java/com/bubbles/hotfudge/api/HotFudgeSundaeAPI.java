package com.bubbles.hotfudge.api;

import static spark.Spark.after;
import static spark.Spark.exception;
import static spark.Spark.get;
import static spark.Spark.post;

import java.util.ArrayList;

import com.bubbles.hotfudge.dao.impl.GenericHotFudgeSundaeImpl;
import com.bubbles.hotfudge.dao.impl.GenericReviewImpl;
import com.bubbles.hotfudge.dao.service.HotFudgeSundaeService;
import com.bubbles.hotfudge.dao.service.ReviewService;
import com.bubbles.hotfudge.model.HotFudgeError;
import com.bubbles.hotfudge.model.HotFudgeSundae;
import com.bubbles.hotfudge.model.Review;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

public class HotFudgeSundaeAPI {
		
	//TODO: Create API tests
	//TODO: Create enum for status codes
	//TODO: Create enum for content types
	//TODO: Use gson for all json concerns
	//TODO: Swap generic impls with database impls
	public static void main(String[] args) {
		
		HotFudgeSundaeService sundaeService = 
				new HotFudgeSundaeService(
						new GenericHotFudgeSundaeImpl(
								new ArrayList<HotFudgeSundae>()));
		
		ReviewService reviewService = 
				new ReviewService(
						new GenericReviewImpl(
								new ArrayList<Review>()));
		
		ObjectMapper objMapper = new ObjectMapper();
				
		get("/sundaes", "application/json", (req, res) -> {
			return sundaeService.getSundaes();
		}, objMapper::writeValueAsString);
		
		post("/sundaes", "application/json", (req, res) -> {
			HotFudgeSundae sundae = objMapper.readValue(req.body(), HotFudgeSundae.class);
			sundaeService.addNewSundae(sundae);
			return sundae;
		}, objMapper::writeValueAsString);
		
		get("/sundaes/:id", "application/json", (req, res) -> {
			int id = Integer.parseInt(req.params("id"));
			HotFudgeSundae sundae = sundaeService.getSundae(id);
			if (sundae != null) {
				return sundae;
			}
			return new HotFudgeError("Unable to locate sundae with id = " + id, 400);
		}, objMapper::writeValueAsString);
		
		get("/sundaes/:id/reviews", "application/json", (req, res) -> {
			//TODO: retrieve all reviews for sundae with given id
			return null;
		}, objMapper::writeValueAsString);
		
		post("/sundaes/:id/reviews", "application/json", (req, res) -> {
			//TODO: create review for sundae with given id
			return null;
		}, objMapper::writeValueAsString);
		
		after((req, res) -> {
			res.type("application/json");
		});
		
		exception(Exception.class, (exc, req, res) -> {
				Gson gson = new Gson();
		    res.status(500);
		    res.type("application/json");
				res.body(gson.toJson((new HotFudgeError("Oops... did I do that?", 500))));
		});
		
	}
	
}
