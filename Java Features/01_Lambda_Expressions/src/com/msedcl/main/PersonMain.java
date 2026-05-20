package com.msedcl.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.msedcl.main.domain.Condition;
import com.msedcl.main.domain.LastNameStartWithG;
import com.msedcl.main.domain.Person;
import com.msedcl.main.domain.SortByLastName;

public class PersonMain {
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

		// Without Lambda Expression
		// 1. Sort this list by last name - using comparator
		SortByLastName byLastName = new SortByLastName();
		people.sort(byLastName);
		System.out.println("Done sorting by last name");

		// 2 Create a method to print all elements from the list
		printAll(people);

		// 3. Create a method that prints
		// all people having last name beginning with G
		System.out.println("People last name beginning with G");
		Condition condition = new LastNameStartWithG();
		printStartWithG(people, condition);

		// 4. Create a method that prints
		// all people having lastName ending with l
		System.out.println("People last name ending with l");
		printEndsWithL(people);

	}

	public static void printStartWithG(List<Person> people, Condition condition) 
	{
		for (Person person : people) {
			if (condition.test(person))
				System.out.println(person);
		}
	}

	public static void printEndsWithL(List<Person> people) {
		for (Person person : people) {
			if (person.getLastName().endsWith("l"))
				System.out.println(person);
		}
	}

	public static void printAll(List<Person> people) {
		for (Person person : people) {
			System.out.println(person);
		}
	}
}
