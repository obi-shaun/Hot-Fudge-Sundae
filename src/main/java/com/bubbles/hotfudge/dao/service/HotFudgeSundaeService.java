package com.bubbles.hotfudge.dao.service;

import java.util.List;

import com.bubbles.hotfudge.dao.HotFudgeSundaeDAO;
import com.bubbles.hotfudge.model.HotFudgeSundae;

//TODO: enforce constraints and business logic
public class HotFudgeSundaeService {
	
	private HotFudgeSundaeDAO sundaeDAO; 

	public HotFudgeSundaeService(HotFudgeSundaeDAO sundaeDAO) {
		this.sundaeDAO = sundaeDAO;
	}
	
	public HotFudgeSundaeDAO getSundaeDAO() {
		return sundaeDAO;
	}
	
	public void addNewSundae(HotFudgeSundae sundae) {
		sundaeDAO.add(sundae);
	}
	
	public List<HotFudgeSundae> getSundaes() {
		return sundaeDAO.findAll();
	}
	
	public HotFudgeSundae getSundae(int id) {
			return sundaeDAO.find(id);
	}
	
}
