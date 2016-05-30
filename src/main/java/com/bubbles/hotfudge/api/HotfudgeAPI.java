package com.bubbles.hotfudge.api;

import static spark.Spark.get;
import static spark.Spark.post;


public class HotfudgeAPI {
	
	public static void main(String[] args) {
		get("/home", (req, res) -> {
			return "Hot Fudge Sundae under construction";
		});
		
		post("/hotfudgesundaes", (req, res) -> {
			return null;
		});
	}
	
}
