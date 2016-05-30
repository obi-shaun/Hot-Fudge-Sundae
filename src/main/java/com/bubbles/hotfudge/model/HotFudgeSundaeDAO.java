package com.bubbles.hotfudge.model;

import java.util.List;
import com.bubbles.hotfudge.HotFudgeSundae;

public interface HotFudgeSundaeDAO {
	public void add(HotFudgeSundae sundae);
	public HotFudgeSundae find(int id);
	public List<HotFudgeSundae> findAll();
}
