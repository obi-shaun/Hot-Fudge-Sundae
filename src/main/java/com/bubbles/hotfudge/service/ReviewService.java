package com.bubbles.hotfudge.service;

import java.util.List;

import com.bubbles.hotfudge.dao.HotFudgeSundaeDAO;
import com.bubbles.hotfudge.dao.ReviewDAO;
import com.bubbles.hotfudge.exceptions.HotFudgeDAOException;
import com.bubbles.hotfudge.exceptions.HotFudgeServiceException;
import com.bubbles.hotfudge.model.Review;
import com.bubbles.hotfudge.utils.HotFudgeSanitizer;
import com.bubbles.hotfudge.utils.HotFudgeValidator;

public class ReviewService {

	private ReviewDAO reviewDAO; 
	private HotFudgeSundaeDAO sundaeDAO;
	
	public ReviewService(ReviewDAO reviewDAO, HotFudgeSundaeDAO sundaeDAO) {
		this.reviewDAO = reviewDAO;
		this.sundaeDAO = sundaeDAO;
	}
	
	public void addReview(Review review, int sundaeId) throws HotFudgeServiceException {
		if (reviewIsValid(review, sundaeId)) {
			review.setId(sundaeId);
			review.setRating(enforceRatingLimits(review.getRating()));
			review.setComment(enforceCommentLength(review.getComment()));
		}
		else {
			throw new HotFudgeServiceException("Invalid review data!");
		}
		try {
			reviewDAO.add(review);
		} catch (HotFudgeDAOException e) {
			throw new HotFudgeServiceException("Failed to add review");
		}
	}

	public List<Review> getReviewsForSundae(int sundaeId) {
		return reviewDAO.findAll(sundaeId);
	}
	
	private boolean reviewIsValid(Review review, int sundaeId) {
		return sundaeIdIsValid(sundaeId) &&
				HotFudgeValidator.userStringIsNotEmpty(review.getComment());
	}
	
	private boolean sundaeIdIsValid(int sundaeId) {
		return sundaeDAO.find(sundaeId) != null;
	}
	
	private String enforceCommentLength(String comment) {
		return HotFudgeSanitizer.enforceCharacterLimit(comment, Review.getCharacterLimit());
	} 
	
	private int enforceRatingLimits(int rating) {
		return HotFudgeSanitizer.enforceRange(rating, Review.getMinimumRating(), Review.getMaximumRating());
	}
	
}
