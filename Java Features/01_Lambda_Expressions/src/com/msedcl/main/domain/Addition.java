package com.msedcl.main.domain;

public class Addition implements Calculations {
	@Override
	public double doCalculations(double numberOne, double numberTwo) {
		return numberOne + numberTwo;
	}
}
