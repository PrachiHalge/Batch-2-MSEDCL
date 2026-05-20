package com.msedcl.main;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.msedcl.main.domain.Condition;
import com.msedcl.main.domain.Person;

public class PersonMainLambda {
	public static void main(String[] args) {
		// Creating person class objects
		Person person1 = new Person("Vivek", "Gohil", 36);
		Person person2 = new Person("Trupti", "Acharekar", 38);
		Person person3 = new Person("Samarth", "Patil", 10);
		Person person4 = new Person("Gurubux", "Gill", 30);

		// Storing person objects into List
		List<Person> people = Arrays.asList(person1, person2, person3, person4);

		// Printing All persons from list
		for (Person person : people) {
			System.out.println(person);
		}

//		Comparator<Person> sortByLastName = (p1, p2) 
//				-> p1.getLastName().compareTo(p2.getLastName());
//		people.sort(sortByLastName);

		people.sort((p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));
		System.out.println("Done sorting by last name");

		printConditionally(people, 
				(p) -> true,
				(p) -> System.out.println(p));

		System.out.println("Printing people last name starts with G ");
		printConditionally(people, 
				(p) -> p.getLastName().startsWith("G") , 
				(p) -> System.out.println(p.getLastName()));

		System.out.println("Printing people last name ends with l");
		printConditionally(people, 
				(p) -> p.getLastName().endsWith("l") , 
				(p) -> System.out.println(p.getFirstName() + " " + p.getLastName()));

	}

	public static void printConditionally(List<Person> people, 
			Predicate<Person> condition,
			Consumer<Person> consumer) {
		for (Person person : people) {
			if (condition.test(person))
				consumer.accept(person);
		}
	}

}
