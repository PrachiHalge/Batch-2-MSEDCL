package com.msedcl.main;

import java.util.Arrays;
import java.util.List;

import com.msedcl.main.domain.Person;

public class StreamsMain {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("Vivek", "Bahubali", "Trupti", "Samarth");

		// Print all except Bahubali
		for (String name : names) {
			if (!name.equals("Bahubali"))
				System.out.println(name);
		}

		System.out.println();

		// Using Streams - filter
		names.stream().filter((name) -> !name.equals("Bahubali")).forEach((name) -> System.out.println(name));

		// Creating person class objects
		Person person1 = new Person("Vivek", "Gohil", 36);
		Person person2 = new Person("Trupti", "Acharekar", 38);
		Person person3 = new Person("Samarth", "Patil", 10);
		Person person4 = new Person("Gurubux", "Gill", 30);

		// Storing person objects into List
		List<Person> people = Arrays.asList(person1, person2, person3, person4);

		// Print first name and last name of a person from list
		// except Samarth
		people.stream()
			.filter((p) -> !p.getFirstName().equals("Samarth"))
			.forEach((p) -> System.out.println(p.getFirstName() 
										+ " " + p.getLastName()));
	}
}
