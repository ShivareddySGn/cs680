package edu.umb.cs680.hw3;

public class Car {
	private String make, model;
	private int mileage, year;
	private float price;
	
	public Car(String make, String model, int year) {
		super();
		this.make = make;
		this.model = model;
		this.year = year;
	}

	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}

	public int getYear() {
		return year;
	}
	
}