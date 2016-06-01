package com.bubbles.hotfudge.api;

import static spark.Spark.get;
import static spark.Spark.post;


public class HotfudgeAPI {
	
	public static void main(String[] args) {
		get("/sundaes", (req, res) -> {
			//TODO: retrieve all HotFudgeSundaes
			return null;
		});
		
		get("/sundaes/:id", (req, res) -> {
			//TODO: retrieve HotFudgeSundae with given id
			return null;
		});
		
		post("/sundaes", (req, res) -> {
			//TODO: create a new HotFudgeSundae
			return null;
		});
		
		get("/reviews/:sundaeId", (req, res) -> {
			//TODO: retrieve all reviews for a HotFudgeSundae with given id
			return null;
		});
		
		post("/reviews", (req, res) -> {
			//TODO: create a review for a given HotFudgeSundae
			return null;
		});
	}
	
}
