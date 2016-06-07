package com.bubbles.hotfudge.model;

import java.util.List;

import com.bubbles.hotfudge.Review;

//TODO: Exception handling
public interface ReviewDAO {
	public void add(Review review);
	public List<Review> findAll(int sundaeId);
}
