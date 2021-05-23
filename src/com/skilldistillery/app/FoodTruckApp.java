package com.skilldistillery.app;

import java.util.Scanner;

public class FoodTruckApp {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("How many food trucks reviews would you" + " like to enter? (Up to 5)");
		int numTrucks = input.nextInt();
		input.nextLine();
		// Require # of trucks to be between 0 and 5
		if (numTrucks > 5 || numTrucks <= 0) {
			System.out.println("Invalid Input.");
			System.out.println("Exiting...");
			System.exit(1);
		}

		// Create array of truck objects and get user input
		FoodTruck[] truckArr = getUserInput(numTrucks, input);
		// User Menu
		menu(truckArr, input);
		// Close Scanner
		input.close();
	}

	public static FoodTruck[] getUserInput(int numTrucks, Scanner input) {

		FoodTruck[] truckArr = new FoodTruck[numTrucks];
		for (int i = 0; i < numTrucks; i++) {
			System.out.println("Enter the name of the food truck or quit to exit input: ");
			String name = input.nextLine();
			if (name.equalsIgnoreCase("quit")) {
				System.out.println("Exiting Input");
				numTrucks = i;
				break;
			}

			System.out.println("Enter the type of food for the truck: ");
			String foodType = input.nextLine();
			
			double rating = ratingCheck(input);

			truckArr[i] = new FoodTruck(name, foodType, rating);
//			System.out.println(truckArr[i].toString());

		}

		return truckArr;

	}

	public static void menu(FoodTruck[] truckArr, Scanner input) {
		while (true) {
			int selection;
			double sum = 0;
			double max = 0;
			int highestRate = 0;
			int numTrucks = notNullLength(truckArr);
//			System.out.println("numTrucks: " + numTrucks);

			System.out.println();
			System.out.println("_____Menu_____");
			System.out.println("1: List all exisiting food trucks");
			System.out.println("2: Average rating of all food trucks");
			System.out.println("3: Display highest rated food truck");
			System.out.println("4: Quit");
			System.out.println();

			System.out.println("Enter a menu option: ");
			selection = input.nextInt();

			if (selection == 1) {
				for (int j = 0; j < numTrucks; j++) {

					System.out.println(truckArr[j].toString());
				}
			} else if (selection == 2) {
				for (int j = 0; j < numTrucks; j++) {

					sum += truckArr[j].getRating();
				}
				double avg = (sum / numTrucks);
				System.out.println("The average rating is " + avg);

			} else if (selection == 3) {
				for (int j = 0; j < numTrucks; j++) {
					double temp = truckArr[j].getRating();
					if (temp > max) {
						highestRate = j;
						max = temp;
					}
				}
				System.out.println("The highest rated truck is: " + truckArr[highestRate].toString());

			} else if (selection == 4) {
				System.out.println("Goodbye!");
				break;
			} else {
				System.out.println("Not an option. Try again.");
			}

		}

	}

	public static double ratingCheck(Scanner input) {
		System.out.println("How many stars would you give the food truck? ");
		System.out.println("Stars must be between 0.0 and 5.0: ");
		double rating = input.nextDouble();
		input.nextLine();
		if (rating > 5 || rating < 0) {
			System.out.println("Rating must be between 0 and 5 stars.");
			System.out.println("Please try again.");
			return ratingCheck(input);

		} else {
			return rating;
		}
	}

	public static int notNullLength(FoodTruck[] myArray) {
		int count = 0;
		for (FoodTruck obj : myArray) {
			if (obj != null)
				count++;
		}
		return count;
	}

}
