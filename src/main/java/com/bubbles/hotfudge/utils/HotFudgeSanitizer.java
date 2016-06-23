package com.bubbles.hotfudge.utils;

public class HotFudgeSanitizer {
	
	public static String enforceCharacterLimit(String s, int limit) {
		if (s.length() > limit) {
			return s.substring(0, limit);
		}
		return s;
	}
	
	public static int enforceRange(int num, int lowerLimit, int upperLimit) {
		return (int) enforceRange((double) num, (double) lowerLimit, (double) upperLimit);
	}
	
	public static double enforceRange(double num, double lowerLimit, double upperLimit) {
		if (num < lowerLimit){
			return lowerLimit;
		}
		if (num > upperLimit){
			return upperLimit;
		}
		return num;
	}

}
