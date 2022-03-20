package edu.umb.cs680.hw3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {
	
	private String[] carToStringArray(Car car) {
		String[] carStringArray = new String[3];
		carStringArray[0] = car.getMake();
		carStringArray[1] = car.getModel();
		carStringArray[2] = car.getYear() + "";
		return carStringArray;
	}
	
	@Test
	public void verifyCarEqualityWithMakeModelYear() {
		String[] expected = {"Limosine", "Metalposter", "2022"};
		Car actual = new Car("Limosine", "Metalposter", 2022);
		assertArrayEquals(expected, carToStringArray(actual));
	}
	
	@Test
	public void verifyFordEqualityWithMakeModelYear() {
		String[] expected = {"Ford", "Endeavour", "2021"};
		Car actual = new Car("Ford", "Endeavour", 2021);
		assertArrayEquals(expected, carToStringArray(actual));
	}
	
	@Test
	public void verifyDodgeEqualityWithMakeModelYear() {
		String[] expected = {"Dodge", "Challenger", "2020"};
		Car actual = new Car("Dodge", "Challenger", 2020);
		assertArrayEquals(expected, carToStringArray(actual));
	}

}
