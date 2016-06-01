package com.bubbles.hotfudge.model;

import java.util.ArrayList;
import java.util.List;

import com.bubbles.hotfudge.HotFudgeSundae;

//TODO: Swap out with a database implementation
//TODO: Unit tests
public class GenericHotFudgeSundaeDAO implements HotFudgeSundaeDAO {
	
	ArrayList<HotFudgeSundae> sundaes = new ArrayList<HotFudgeSundae>();

	@Override
	public void add(HotFudgeSundae sundae) {
		sundaes.add(sundae);
	}

	@Override
	public HotFudgeSundae find(int id) {
		return sundaes.get(id);
	}

	@Override
	public List<HotFudgeSundae> findAll() {
		return sundaes;
	}
	
}
