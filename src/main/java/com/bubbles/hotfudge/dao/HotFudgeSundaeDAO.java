package com.bubbles.hotfudge.dao;

import java.util.List;

import com.bubbles.hotfudge.model.HotFudgeSundae;

//TODO: Exception handling
public interface HotFudgeSundaeDAO {
	public void add(HotFudgeSundae sundae);
	public HotFudgeSundae find(int id);
	public List<HotFudgeSundae> findAll();
	public int getCount();
}
