package com.bubbles.hotfudge;

import static org.junit.Assert.*;

import org.apache.commons.lang3.RandomStringUtils;

import org.junit.Test;

public class ReviewTest {	
	
	@Test
	public void positiveTest() {
		int validCommentLength = 50;
		int validRating = 5;
		Review validReview = new Review(RandomStringUtils.random(validCommentLength), validRating);
		assertEquals(validRating, validReview.getRating());
		assertEquals(validCommentLength, validReview.getComment().length());
	}
	
	@Test
	public void negativeTest() {
		int invalidCommentLength = 200;
		int invalidRating = -5;
		Review invalidReview = new Review(RandomStringUtils.random(invalidCommentLength), invalidRating);
		assertEquals(Review.getMinimumRating(), invalidReview.getRating());
		assertEquals(Review.getCharacterLimit(), invalidReview.getComment().length());
	}

}
