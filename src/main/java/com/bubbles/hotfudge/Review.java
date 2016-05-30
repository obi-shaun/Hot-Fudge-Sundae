package com.bubbles.hotfudge;

public class Review {
	private String comment;
	private int rating;
	private final int CHARACTER_LIMIT = 140;
	private final int MINIMUM_RATING = 1;
	private final int MAXIMUM_RATING = 5;
	private int sundaeId;

	public Review(String comment, int rating) {
		this.comment = enforceCharacterLimit(comment);
		this.rating = enforceRatingLimit(rating);	
	}
	
	public void setComment(String comment) {
		this.comment = enforceCharacterLimit(comment);
	}
	
	public void setRating(int rating) {
		this.rating = enforceRatingLimit(rating);
	}
	
	public void setSundaeId(int sundaeId) {
		this.sundaeId = sundaeId;
	}
	
	public String getComment() {
		return comment;
	}
	
	public int getRating() {
		return rating;
	}
	
	public int getSundaeId() {
		return sundaeId;
	}

	private String enforceCharacterLimit(String comment) {
		int commentLength = comment.length();
		if (commentLength > CHARACTER_LIMIT) { 
			return comment.substring(0, CHARACTER_LIMIT);
		}
		return comment;
	}
	
	private int enforceRatingLimit(int rating) {
		if (rating < MINIMUM_RATING){
			return MINIMUM_RATING;
		}
		if (rating > MAXIMUM_RATING){
			return MAXIMUM_RATING;
		}
		return rating;
	}
	
}



