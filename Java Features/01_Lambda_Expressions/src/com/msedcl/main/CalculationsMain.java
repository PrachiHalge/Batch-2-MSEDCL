package com.msedcl.main;

import com.msedcl.main.domain.Addition;
import com.msedcl.main.domain.Calculations;

public class CalculationsMain {
	public static void main(String[] args) {
		Calculations calculations = null;

		calculations = new Addition();
		double additionResult = calculations.doCalculations(10, 20);
		System.out.println("Addition is :: " + additionResult);
		
		calculations = new Calculations() {
			
			@Override
			public double doCalculations(double numberOne, double numberTwo) {
				return numberOne - numberTwo;
			}
		};
		
		double result = calculations.doCalculations(10, 20);

		calculations = (double numberOne, double numberTwo) -> {
			return numberOne - numberTwo;
		};

		double subtractionResult = calculations.doCalculations(20, 10);
		System.out.println("Subtraction is :: " + subtractionResult);

		calculations = (n1, n2) -> n1 * n2;
		System.out.println("Multiplication is :: " + calculations.doCalculations(10, 2));
		
		calculations = (n1, n2) -> n1 / n2;
		System.out.println("Division is :: " + calculations.doCalculations(10, 2));
		
		
		

	}
}
