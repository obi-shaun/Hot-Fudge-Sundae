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
	public static void main(String[] args) {
		//TODO: Replace with database implementation
		GenericHotFudgeSundaeDAO sundaeDAO = new GenericHotFudgeSundaeDAO(new ArrayList<HotFudgeSundae>());
		GenericReviewDAO reviewDAO = new GenericReviewDAO(new ArrayList<Review>());
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
			//TODO: retrieve HotFudgeSundae with given id
			return null;
		});
		
		get("/sundaes/:id/reviews", (req, res) -> {
			//TODO: retrieve all reviews for a HotFudgeSundae with given id
			return null;
		});
		
		post("/sundaes/:id/reviews", (req, res) -> {
			//TODO: create a new review for a HotFudgeSundae with given id
			return null;
		});
		
	}
	
}
