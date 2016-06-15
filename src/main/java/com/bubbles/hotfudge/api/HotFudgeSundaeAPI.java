package com.bubbles.hotfudge.api;

import static spark.Spark.after;
import static spark.Spark.get;
import static spark.Spark.post;

import java.util.ArrayList;

import com.bubbles.hotfudge.dao.impl.GenericHotFudgeSundaeImpl;
import com.bubbles.hotfudge.dao.impl.GenericReviewImpl;
import com.bubbles.hotfudge.dao.service.HotFudgeSundaeService;
import com.bubbles.hotfudge.dao.service.ReviewService;
import com.bubbles.hotfudge.model.HotFudgeSundae;
import com.bubbles.hotfudge.model.Review;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HotFudgeSundaeAPI {
		
	//TODO: Create API tests
	//TODO: Return errors wrapped in json
	//TODO: Create enum for status codes to be used
	//TODO: Create enum for content types to be used
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
				
		get("/sundaes", "application/json", (req, res) -> {
			return sundaeService.getSundaes();
		}, objMapper::writeValueAsString);
		
		post("/sundaes", "application/json", (req, res) -> {
			HotFudgeSundae sundae = objMapper.readValue(req.body(), HotFudgeSundae.class);
			sundaeService.addNewSundae(sundae);
			return sundae;
		}, objMapper::writeValueAsString);
		
		get("/sundaes/:id", "application/json", (req, res) -> {
			return sundaeService.getSundae(Integer.parseInt(req.params("id")));
		}, objMapper::writeValueAsString);
		
		get("/sundaes/:id/reviews", "application/json", (req, res) -> {
			return reviewService.getReviewsForSundae(Integer.parseInt(req.params("id")));
		}, objMapper::writeValueAsString);
		
		post("/sundaes/:id/reviews", "application/json", (req, res) -> {
			Review review = objMapper.readValue(req.body(), Review.class);
			System.out.println(review);
			System.out.println(review.getComment());
			reviewService.addReview(review);
			System.out.println("FUCK! ");
			return review;
		}, objMapper::writeValueAsString);
		
		after((req, res) -> {
			res.type("application/json");
		});

	}
	
}
