package com.bubbles.hotfudge.dao.service;

import java.util.List;

import com.bubbles.hotfudge.dao.HotFudgeSundaeDAO;
import com.bubbles.hotfudge.model.HotFudgeSundae;

public class HotFudgeSundaeService {
	
	private HotFudgeSundaeDAO sundaeDAO; 
	
	public HotFudgeSundaeService(HotFudgeSundaeDAO sundaeDAO) {
		this.sundaeDAO = sundaeDAO;
	}
	
	public HotFudgeSundae addNewSundae(HotFudgeSundae sundae) {
		sundae.setId(sundaeDAO.add(sundae));
		return sundae;
	}
	
	public List<HotFudgeSundae> getSundaes() {
		return sundaeDAO.findAll();
	}
	
	public HotFudgeSundae getSundae(int id) {
		if (validateId(id)) {
			return sundaeDAO.find(id);
		}
		return null;
	}

	private boolean validateId(int id) {
		return id >= 0 && id < sundaeDAO.getCount();
	}
	
}
