package com.skilldistillery.app;

public class FoodTruck {
	private String truckName;
	private String foodType;
	private double rating; 
	private static int counter;
	private int uniqueID;
	
	
	public FoodTruck() {
		this.uniqueID = counter;
		counter++;
	}
	public FoodTruck(String truckName, String foodType, double rating) {
		this.truckName = truckName;
		this.foodType = foodType;
		this.rating = rating;
		this.uniqueID = counter;
		counter++;
		
	}


	public String getTruckName() {
		return truckName;
	}


	public void setTruckName(String truckName) {
		this.truckName = truckName;
	}


	public String getFoodType() {
		return foodType;
	}


	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}


	public double getRating() {
		return rating;
	}


	public void setRating(double rating) {
		this.rating = rating;
	}
	


	@Override
	public String toString() {
		return "Truck Name = " + truckName + ", Food Type = " + foodType + ", Rating = " + rating +" stars, uniqueID = "
				+ uniqueID;
	}


	
	
	
}
