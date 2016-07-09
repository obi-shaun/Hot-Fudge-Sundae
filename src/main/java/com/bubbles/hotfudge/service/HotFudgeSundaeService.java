package com.bubbles.hotfudge.service;

import java.util.List;

import com.bubbles.hotfudge.dao.HotFudgeSundaeDAO;
import com.bubbles.hotfudge.exceptions.HotFudgeDAOException;
import com.bubbles.hotfudge.exceptions.HotFudgeServiceException;
import com.bubbles.hotfudge.model.HotFudgeSundae;
import com.bubbles.hotfudge.utils.HotFudgeSanitizer;
import com.bubbles.hotfudge.utils.HotFudgeValidator;

public class HotFudgeSundaeService {

	private HotFudgeSundaeDAO sundaeDAO;

	public HotFudgeSundaeService(HotFudgeSundaeDAO sundaeDAO) {
		this.sundaeDAO = sundaeDAO;
	}

	public HotFudgeSundaeDAO getSundaeDAO() {
		return sundaeDAO;
	}

	public void addNewSundae(HotFudgeSundae sundae) throws HotFudgeServiceException {
		try {
			if (sundaeIsValid(sundae)) {
				sundae.setRestaurantName(enforceRestaurantNameLength(sundae.getRestaurantName(), HotFudgeSundae.getRestaurantNameCharLimit()));
				sundaeDAO.add(sundae);
			}
			else {
				throw new HotFudgeServiceException("Invalid data");
			}
		} 
		catch (HotFudgeDAOException e) {
			throw new HotFudgeServiceException("Failed to add sundae");
		}
	}

	public List<HotFudgeSundae> getSundaes() {
		return sundaeDAO.findAll();
	}

	public HotFudgeSundae getSundae(int id) throws HotFudgeServiceException {
			return sundaeDAO.find(id);
	}
	
	private boolean sundaeIsValid(HotFudgeSundae sundae) {
		return restaurantNameIsValid(sundae.getRestaurantName()) 
				&& priceIsValid(sundae.getPrice());
	}
	
	private boolean restaurantNameIsValid(String restaurantName) {
		return HotFudgeValidator.userStringIsNotEmpty(restaurantName);
	}
	
	private boolean priceIsValid(double price) {
		return HotFudgeValidator.priceIsValid(price);
	}
	
	private String enforceRestaurantNameLength(String restaurant, int restaurantNameCharLimit) {
		return HotFudgeSanitizer.enforceCharacterLimit(restaurant, restaurantNameCharLimit);
	}

}
