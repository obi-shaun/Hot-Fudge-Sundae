package com.bubbles.hotfudge.dao.impl;

import java.util.List;

import com.bubbles.hotfudge.dao.HotFudgeSundaeDAO;
import com.bubbles.hotfudge.exceptions.HotFudgeDAOException;
import com.bubbles.hotfudge.model.HotFudgeSundae;

//TODO: Swap out with a database implementation
public class GenericHotFudgeSundaeImpl implements HotFudgeSundaeDAO {
	
	private List<HotFudgeSundae> sundaes;
	
	public GenericHotFudgeSundaeImpl(List<HotFudgeSundae> sundaes) {
		this.sundaes = sundaes;
	}

	@Override
	public void add(HotFudgeSundae sundae) throws HotFudgeDAOException {
		try {
			sundaes.add(sundae);
			sundae.setId(sundaes.size() - 1);
		}
		catch(Exception e) {
			throw new HotFudgeDAOException("Failed to add sundae");
		}
	}

	@Override
	public HotFudgeSundae find(int id) {
		try {
			return sundaes.get(id);
		}
		catch(IndexOutOfBoundsException e) {
			return null;
		}
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
