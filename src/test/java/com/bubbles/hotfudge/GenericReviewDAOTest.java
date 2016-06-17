package com.bubbles.hotfudge;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.bubbles.hotfudge.dao.impl.GenericHotFudgeSundaeImpl;
import com.bubbles.hotfudge.dao.impl.GenericReviewImpl;
import com.bubbles.hotfudge.model.HotFudgeSundae;
import com.bubbles.hotfudge.model.Review;

//TODO: Update Tests
public class GenericReviewDAOTest {
	
	private ArrayList<HotFudgeSundae> sundaes;
	private ArrayList<Review> reviews;
	
	private GenericHotFudgeSundaeImpl sundaeDAO;
	private GenericReviewImpl reviewDAO;
	
	private HotFudgeSundae deliaSundae;
	private HotFudgeSundae rubySundae;
	private HotFudgeSundae mcdonaldsSundae;
	
	Review deliaReview;
	Review rubyReview;

	@Before
	public void initialize() {
		//create and populate sundaes
		sundaes = new ArrayList<HotFudgeSundae>();
		sundaeDAO = new GenericHotFudgeSundaeImpl(sundaes);
		deliaSundae = new HotFudgeSundae("Delia's",true,5.99);
		rubySundae = new HotFudgeSundae("Ruby Tuesday",true,4.99);
		mcdonaldsSundae = new HotFudgeSundae("Mcdonald's",false,1.00);
		sundaeDAO.add(deliaSundae);
		sundaeDAO.add(rubySundae);
		sundaeDAO.add(mcdonaldsSundae);

		//create and populate reviews
		reviews = new ArrayList<Review>();
		reviewDAO = new GenericReviewImpl(reviews);
		deliaReview = new Review("Delia's is okay.", 3, deliaSundae.getId());
		rubyReview = new Review("Ruby Tuesday's is great", 4, rubySundae.getId());
		reviewDAO.add(deliaReview);
		reviewDAO.add(rubyReview);
	}
	
	@Test
	public void add() {
		int originalNumOfReviews = reviews.size();
		Review mcdonaldsReview = new Review("Mcdonald's is amazing!", 5, mcdonaldsSundae.getId());
		reviewDAO.add(mcdonaldsReview);
		assertTrue(reviews.size() == originalNumOfReviews + 1);
		assertTrue(reviews.get(reviews.size() - 1).equals(mcdonaldsReview));
	}
	
	@Test
	public void findAll() {
		assertTrue(deliaReview.equals(reviewDAO.findAll(deliaSundae.getId()).get(0)));
		assertTrue(rubyReview.equals(reviewDAO.findAll(rubySundae.getId()).get(0)));
	}

}
