package com.bubbles.hotfudge;

import static org.junit.Assert.*;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;

public class ReviewTest {	
	
	private HotFudgeSundae sundae;
	
	@Before
	public void initialize() {
		sundae = new HotFudgeSundae("Delia's", true, 5.99);
		sundae.setId(0);
	}
		
	@Test
	public void createAReviewWithValidArguments() {
		int validCommentLength = 50;
		int validRating = 5;
		Review validReview = new Review(RandomStringUtils.random(validCommentLength), validRating, sundae.getId());
		assertEquals(validRating, validReview.getRating());
		assertEquals(validCommentLength, validReview.getComment().length());
	}
	
	@Test
	public void createAReviewWithInvalidArguments() {
		int invalidCommentLength = 200;
		int invalidRating = -5;
		Review invalidReview = new Review(RandomStringUtils.random(invalidCommentLength), invalidRating, sundae.getId());
		assertEquals(Review.getMinimumRating(), invalidReview.getRating());
		assertEquals(Review.getCharacterLimit(), invalidReview.getComment().length());
	}

}
