package com.bubbles.hotfudge.model;

import java.util.List;

import com.bubbles.hotfudge.HotFudgeSundae;

//TODO: Swap out with a database implementation
public class GenericHotFudgeSundaeDAO implements HotFudgeSundaeDAO {
	
	private List<HotFudgeSundae> sundaes;
	
	public GenericHotFudgeSundaeDAO(List<HotFudgeSundae> sundaes) {
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
	
}
