package com.bubbles.hotfudge.model;

import java.util.ArrayList;
import java.util.List;

import com.bubbles.hotfudge.Review;

//TODO: Swap out with a database implementation
public class GenericReviewDAO implements ReviewDAO {
	
	private List<Review> reviews;
	
	public GenericReviewDAO(List<Review> reviews) {
		this.reviews = reviews;
	}

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
