package com.bubbles.hotfudge.dao.service;

import com.bubbles.hotfudge.dao.ReviewDAO;

//TODO: incomplete
public class ReviewService {

private ReviewDAO reviewDAO; 
	
	public ReviewService(ReviewDAO reviewDAO) {
		this.reviewDAO = reviewDAO;
	}
	
	//TODO: verify that the review that is added is using a valid sundae id (one that exists/null check).
	
}
