package com.bubbles.hotfudge.service;

import java.util.List;

import com.bubbles.hotfudge.dao.HotFudgeSundaeDAO;
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

	public void addNewSundae(HotFudgeSundae sundae) {
		String restaurant = sundae.getRestaurantName();
		double price = sundae.getPrice();
		if (restaurantNameIsValid(restaurant) && priceIsValid(price)) {
			sundae.setRestaurantName(
					enforceRestaurantNameLength(restaurant, HotFudgeSundae.getRestaurantNameCharLimit()));
			sundaeDAO.add(sundae);
		}
		else {
			System.out.println("Invalid name or price...replace me with a custom exception!");
		}
	}

	public List<HotFudgeSundae> getSundaes() {
		return sundaeDAO.findAll();
	}

	public HotFudgeSundae getSundae(int id) {
		return sundaeDAO.find(id);
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
