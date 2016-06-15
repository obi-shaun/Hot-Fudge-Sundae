package com.bubbles.hotfudge.dao.service;

import java.util.List;

import com.bubbles.hotfudge.dao.HotFudgeSundaeDAO;
import com.bubbles.hotfudge.dao.ReviewDAO;
import com.bubbles.hotfudge.model.Review;

public class ReviewService {

	private ReviewDAO reviewDAO; 
	private HotFudgeSundaeDAO sundaeDAO;
	
	public ReviewService(ReviewDAO reviewDAO, HotFudgeSundaeDAO sundaeDAO) {
		this.reviewDAO = reviewDAO;
	}
	
	public void addReview(Review review) {
		if (sundaeIdIsValid(review.getSundaeId())) {
			review.setRating(enforceRatingLimits(review.getRating()));
			review.setComment(enforceCommentLength(review.getComment()));
			reviewDAO.add(review);
		}
	}
	
	public List<Review> getReviewsForSundae(int sundaeId) {
		return reviewDAO.findAll(sundaeId);
	}
	
	private boolean sundaeIdIsValid(int sundaeId) {
		return sundaeDAO.find(sundaeId) != null;
	}
	
	private String enforceCommentLength(String comment) {
		int commentLength = comment.length();
		if (commentLength > Review.getCharacterLimit()) { 
			return comment.substring(0, Review.getCharacterLimit());
		}
		return comment;
	}
	
	private int enforceRatingLimits(int rating) {
		if (rating < Review.getMinimumRating()){
			return Review.getMinimumRating();
		}
		if (rating > Review.getMaximumRating()){
			return Review.getMaximumRating();
		}
		return rating;
	}
	
}
