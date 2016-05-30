package com.bubbles.hotfudge;

import com.bubbles.hotfudge.HotFudgeSundae;

public class Main {
	
	public static void main(String[] args) {
		HotFudgeSundae deliasSundae;
		
		//CREATE A NEW HOTFUDGESUNDAE OBJECT AND PRINT TO CONSOLE
		deliasSundae = new HotFudgeSundae("Delias", true, 5.99);
		printToConsole(deliasSundae.toString());
		
		//UPDATING THE NAME AND PRINTING TO CONSOLE
		deliasSundae.setRestaurantName("Janias");
		printToConsole(deliasSundae.toString());
		
	}
	
	public static void printToConsole(String s) {
		System.out.println(s);
	}

}
