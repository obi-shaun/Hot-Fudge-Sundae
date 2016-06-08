package com.bubbles.hotfudge.api;

import static spark.Spark.get;
import static spark.Spark.post;

import java.util.ArrayList;

import com.bubbles.hotfudge.HotFudgeSundae;
import com.bubbles.hotfudge.Review;
import com.bubbles.hotfudge.model.GenericHotFudgeSundaeDAO;
import com.bubbles.hotfudge.model.GenericReviewDAO;
import com.google.gson.Gson;


public class HotFudgeSundaeAPI {
	
	//TODO: Create API tests
	//TODO: Set HTTP status codes
	//TODO: Switch to Jackson implementation for marshalling
	public static void main(String[] args) {
		//TODO: Replace with database implementation
		GenericHotFudgeSundaeDAO sundaeDAO = new GenericHotFudgeSundaeDAO(sundaes);
		GenericReviewDAO reviewDAO = new GenericReviewDAO(reviews);
		////////////////////////////////////////////
		
		Gson gson = new Gson();
		
		get("/sundaes", (req, res) -> {
			return sundaeDAO.findAll();
		}, gson::toJson);
		
		post("/sundaes", (req, res) -> {
			HotFudgeSundae sundae = gson.fromJson(req.body(), HotFudgeSundae.class);
			sundaeDAO.add(sundae);
			return sundae;
		}, gson::toJson);
		
		get("/sundaes/:id", (req, res) -> {
			return sundaeDAO.find(Integer.parseInt(req.params("id")));
		}, gson::toJson);
		
		get("/sundaes/:id/reviews", (req, res) -> {
			return reviewDAO.findAll(Integer.parseInt(req.params("id")));
		}, gson::toJson);
		
		post("/sundaes/:id/reviews", (req, res) -> {
			Review review = gson.fromJson(req.body(), Review.class);
			reviewDAO.add(review);
			return review;
		}, gson::toJson);
		
	}
	
}
