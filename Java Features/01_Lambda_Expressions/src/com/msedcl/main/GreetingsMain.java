package com.msedcl.main;

import com.msedcl.main.domain.GoodAfternoon;
import com.msedcl.main.domain.GoodMorning;
import com.msedcl.main.domain.Greetings;

public class GreetingsMain {
	public static void main(String[] args) {
//		GoodMorning goodMorning = new GoodMorning();
//		goodMorning.greet();

		Greetings greetings = null;

		greetings = new GoodMorning();
		greetings.greet();

		System.out.println();

		greetings = new GoodAfternoon();
		greetings.greet();

		greetings = () -> {
			System.out.println("Good Evening All");
		};
		greetings.greet();

		greetings = () -> {
			System.out.println("Good Night All");
		};
		greetings.greet();

	}

}
