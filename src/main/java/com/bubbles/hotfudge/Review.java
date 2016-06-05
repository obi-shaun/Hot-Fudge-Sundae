package com.bubbles.hotfudge;

public class Review {
	
	private String comment;
	private int rating;
	private int sundaeId;
	private static final int CHARACTER_LIMIT = 140;
	private static final int MINIMUM_RATING = 1;
	private static final int MAXIMUM_RATING = 5;

	public Review(String comment, int rating, int sundaeId) {
		this.comment = validateComment(comment);
		this.rating = validateRating(rating);
		this.sundaeId = sundaeId;
	}
	
	public void setComment(String comment) {
		this.comment = validateComment(comment);
	}
	
	public void setRating(int rating) {
		this.rating = validateRating(rating);
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

	public static int getCharacterLimit() {
		return CHARACTER_LIMIT;
	}
	
	public static int getMaximumRating() {
		return MAXIMUM_RATING;
	}
	
	public static int getMinimumRating() {
		return MINIMUM_RATING;
	}

	private String validateComment(String comment) {
		int commentLength = comment.length();
		if (commentLength > CHARACTER_LIMIT) { 
			return comment.substring(0, CHARACTER_LIMIT);
		}
		return comment;
	}
	
	private int validateRating(int rating) {
		if (rating < MINIMUM_RATING){
			return MINIMUM_RATING;
		}
		if (rating > MAXIMUM_RATING){
			return MAXIMUM_RATING;
		}
		return rating;
	}
	
	private boolean validateSundaeId(int sundaeId) {
		//TODO: implement validation of sundaeId
		return false;
	}

	//TODO: review Eclipse auto generated hashCode()
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + rating;
		result = prime * result + sundaeId;
		return result;
	}

	//TODO: review Eclipse auto generated equals()
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Review other = (Review) obj;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (rating != other.rating)
			return false;
		if (sundaeId != other.sundaeId)
			return false;
		return true;
	}
	
	//TODO: override toString()
	
}



