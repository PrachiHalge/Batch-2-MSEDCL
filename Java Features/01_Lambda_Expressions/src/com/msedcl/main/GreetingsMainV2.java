package com.msedcl.main;

import com.msedcl.main.domain.GoodMorning;
import com.msedcl.main.domain.Greetings;

public class GreetingsMainV2 {

	public static void main(String[] args) {
//		Greetings greetings = null;
//		
//		greetings = new GoodMorning();
//		printMessage(greetings);

		// Passing object of a class which
		// implements Greetings interface
		printMessage(new GoodMorning());

		// We can also pass lambda expression instead of
		// object of a class
		printMessage(() -> System.out.println("Have a good day"));

	}

	public static void printMessage(Greetings greetings) {
		greetings.greet();
	}

}
