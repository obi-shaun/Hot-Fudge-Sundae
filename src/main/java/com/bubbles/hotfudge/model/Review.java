package com.bubbles.hotfudge.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Review {
	
	private int id;
	private String comment;
	private int rating;
	private int sundaeId;
	private static final int CHARACTER_LIMIT = 140;
	private static final int MINIMUM_RATING = 1;
	private static final int MAXIMUM_RATING = 5;

	@JsonCreator
	public Review(@JsonProperty("comment") String comment, 
			@JsonProperty("rating") int rating) {
		this.comment = comment;
		this.rating = rating;
	}
	
	public Review(String comment, int rating, int sundaeId) {
		this.comment = comment;
		this.rating = rating;
		this.sundaeId = sundaeId;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	public void setSundaeId(int sundaeId) {
		this.sundaeId = sundaeId;
	}
	
	public int getId() {
		return id;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + rating;
		result = prime * result + sundaeId;
		return result;
	}

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



