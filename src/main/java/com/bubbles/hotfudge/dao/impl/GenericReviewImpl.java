package com.bubbles.hotfudge.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.bubbles.hotfudge.dao.ReviewDAO;
import com.bubbles.hotfudge.model.Review;

//TODO: Swap out with a database implementation
public class GenericReviewImpl implements ReviewDAO {
	
	private List<Review> reviews;
	
	public GenericReviewImpl(List<Review> reviews) {
		this.reviews = reviews;
	}

	@Override
	public void add(Review review) {
		reviews.add(review);
		review.setId(reviews.size() - 1);
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

	@Override
	public int getCount() {
		return reviews.size();
	}
	
}
