package com.bubbles.hotfudge.dao.impl;

import java.util.List;

import com.bubbles.hotfudge.dao.HotFudgeSundaeDAO;
import com.bubbles.hotfudge.model.HotFudgeSundae;

//TODO: Swap out with a database implementation
public class GenericHotFudgeSundaeImpl implements HotFudgeSundaeDAO {
	
	private List<HotFudgeSundae> sundaes;
	
	public GenericHotFudgeSundaeImpl(List<HotFudgeSundae> sundaes) {
		this.sundaes = sundaes;
	}

	@Override
	public void add(HotFudgeSundae sundae) {
		sundaes.add(sundae);
		sundae.setId(sundaes.size() - 1);
	}

	@Override
	public HotFudgeSundae find(int id) {
		return sundaes.get(id);
	}

	@Override
	public List<HotFudgeSundae> findAll() {
		return sundaes;
	}
	
	@Override
	public int getCount() {
		return sundaes.size();
	}
	
}
