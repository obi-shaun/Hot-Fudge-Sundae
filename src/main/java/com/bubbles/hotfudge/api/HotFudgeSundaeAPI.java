package com.bubbles.hotfudge.api;

import static spark.Spark.get;
import static spark.Spark.post;

import java.util.ArrayList;

import com.bubbles.hotfudge.HotFudgeSundae;
import com.bubbles.hotfudge.Review;
import com.bubbles.hotfudge.model.GenericHotFudgeSundaeDAO;
import com.bubbles.hotfudge.model.GenericReviewDAO;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HotFudgeSundaeAPI {
	
	//TODO: Create API tests
	//TODO: Set HTTP status codes
	public static void main(String[] args) {
		//TODO: Replace with database implementation
		GenericHotFudgeSundaeDAO sundaeDAO = new GenericHotFudgeSundaeDAO(new ArrayList<HotFudgeSundae>());
		GenericReviewDAO reviewDAO = new GenericReviewDAO(new ArrayList<Review>());
		////////////////////////////////////////////
		
		ObjectMapper objMapper = new ObjectMapper();
		
		get("/sundaes", (req, res) -> {
			return sundaeDAO.findAll();
		}, objMapper::writeValueAsString);
		
		post("/sundaes", (req, res) -> {
			HotFudgeSundae sundae = objMapper.readValue(req.body(), HotFudgeSundae.class);
			sundaeDAO.add(sundae);
			return sundae;
		}, objMapper::writeValueAsString);
		
		get("/sundaes/:id", (req, res) -> {
			return sundaeDAO.find(Integer.parseInt(req.params("id")));
		}, objMapper::writeValueAsString);
		
		get("/sundaes/:id/reviews", (req, res) -> {
			return reviewDAO.findAll(Integer.parseInt(req.params("id")));
		}, objMapper::writeValueAsString);
		
		post("/sundaes/:id/reviews", (req, res) -> {
			Review review = objMapper.readValue(req.body(), Review.class);
			reviewDAO.add(review);
			return review;
		}, objMapper::writeValueAsString);
		
	}
	
}
