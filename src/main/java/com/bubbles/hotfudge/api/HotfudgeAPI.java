package com.bubbles.hotfudge.api;

import static spark.Spark.get;
import static spark.Spark.post;


public class HotfudgeAPI {
	
	public static void main(String[] args) {
		
		get("/sundaes", (req, res) -> {
			//TODO: retrieve all HotFudgeSundaes
			return null;
		});
		
		post("/sundaes", (req, res) -> {
			//TODO: create a new HotFudgeSundae
			return null;
		});
		
		get("/sundaes/:id", (req, res) -> {
			//TODO: retrieve HotFudgeSundae with given id
			return null;
		});
		
		get("/sundaes/:id/reviews", (req, res) -> {
			//TODO: retrieve all reviews for a HotFudgeSundae with given id
			return null;
		});
		
		post("/sundaes/:id/reviews", (req, res) -> {
			//TODO: create a review for a HotFudgeSundae with given id
			return null;
		});
		
	}
	
}
