package com.msedcl.main;

import com.msedcl.main.domain.Calculations;

public class CalculationsMainV2 {
	public static void main(String[] args) {
		printResult((x, y) -> x + y, 10, 20);
		printResult((x, y) -> x - y, 10, 5);
		printResult((x, y) -> x * y, 2, 20);
		printResult((x, y) -> x / y, 10, 2);
	}

	public static void printResult(Calculations calculations,
			double numberOne, double numberTwo) {
		System.out.println("Result of "
				+ numberOne + " and " + numberTwo + " is "
				+ calculations.doCalculations(numberOne, numberTwo));

	}
}
