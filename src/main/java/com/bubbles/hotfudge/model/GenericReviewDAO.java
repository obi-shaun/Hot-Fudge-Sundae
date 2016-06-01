package com.bubbles.hotfudge.model;

import java.util.ArrayList;
import java.util.List;

import com.bubbles.hotfudge.Review;

//TODO: Swap out with a database implementation
//TODO: Unit tests
public class GenericReviewDAO implements ReviewDAO {
	
	ArrayList<Review> reviews = new ArrayList<Review>();

	@Override
	public void add(Review review) {
		reviews.add(review);
	}

	@Override
	public List<Review> findAll(int sundaeId) {
		ArrayList<Review> filteredReviews = new ArrayList<Review>();
		for (int i = 0; i < reviews.size(); i++) {
			if (reviews.get(i).getSundaeId() == sundaeId) {
				filteredReviews.add(reviews.get(i));
			}
		}
		return filteredReviews;
	}
	
}
