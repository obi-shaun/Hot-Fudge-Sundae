package com.bubbles.hotfudge.model;

import java.util.ArrayList;
import java.util.List;

import com.bubbles.hotfudge.HotFudgeSundae;

public class HotFudgeSundaeDB implements HotFudgeSundaeDAO {
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
