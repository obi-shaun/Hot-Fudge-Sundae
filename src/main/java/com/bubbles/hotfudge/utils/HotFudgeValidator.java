package com.bubbles.hotfudge.utils;

public class HotFudgeValidator {

	public static boolean priceIsValid(double price) {
		return price >= 0.00;
	}
	
	public static boolean userStringIsNotEmpty(String s) {
		return s != null
				&& s.trim() != "";
	}
	
}
