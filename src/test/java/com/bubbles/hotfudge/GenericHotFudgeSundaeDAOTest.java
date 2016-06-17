package com.bubbles.hotfudge;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.bubbles.hotfudge.dao.impl.GenericHotFudgeSundaeImpl;
import com.bubbles.hotfudge.model.HotFudgeSundae;


//TODO: Update tests
public class GenericHotFudgeSundaeDAOTest {
	
	private ArrayList<HotFudgeSundae> sundaes;
	private GenericHotFudgeSundaeImpl sundaeDAO;
	private HotFudgeSundae deliaSundae;
	private HotFudgeSundae rubySundae;

	@Before
	public void initialize() {
		sundaes = new ArrayList<HotFudgeSundae>();
		sundaeDAO = new GenericHotFudgeSundaeImpl(sundaes);
		deliaSundae = new HotFudgeSundae("Delia's",true,5.99);
		rubySundae = new HotFudgeSundae("Ruby Tuesday",true,4.99);
		sundaeDAO.add(deliaSundae);
		sundaeDAO.add(rubySundae);
	}

	@Test
	public void add() {
		int originalNumOfSundaes = sundaes.size();
		HotFudgeSundae mcdonaldsSundae = new HotFudgeSundae("Mcdonald's",false,1.00);
		sundaeDAO.add(mcdonaldsSundae);
		assertTrue(sundaes.size() == originalNumOfSundaes + 1);
		assertTrue(sundaes.get(mcdonaldsSundae.getId()).getRestaurantName().equals(mcdonaldsSundae.getRestaurantName()));
	}
	
	@Test
	public void find() {
		assertTrue(sundaeDAO.find(rubySundae.getId()).equals(rubySundae));
	}
	
	@Test
	public void findAll() {
		assertTrue(sundaeDAO.findAll().size() == sundaes.size());
	}
	
}
