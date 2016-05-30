package com.bubbles.hotfudge;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestReview {
	
	private String normalComment = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. "
			+ "Aenean massa. Cum sociis natoque penatibus et ma";

	private String longComment = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. "
			+ "Aenean massa. Cum sociis natoque penatibus et magjhgegegregreyrguywegtuoegytuoewgyteuowgytewougtewurogtewuogtewourgteo";
	
	@Test
	public void positiveTest() {
		Review goodReview = new Review(normalComment, 5);
		System.out.println("GOOD REVIEW:\n Rating" + goodReview.getRating() + "\n Comment Length" + goodReview.getComment().length());	
		assertEquals(5, goodReview.getRating());
		assertEquals(140, goodReview.getComment().length());
	}
	
	@Test
	public void negativeTest() {
		Review badReview = new Review(longComment, -5);
		System.out.println("BAD REVIEW:\n Rating:" + badReview.getRating() + "\n Comment Length:" + badReview.getComment().length());	
		assertEquals(1, badReview.getRating());
		assertEquals(140, badReview.getComment().length());
	}

}
