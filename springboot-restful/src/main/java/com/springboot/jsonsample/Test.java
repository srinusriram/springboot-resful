package com.springboot.jsonsample;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Let's initialize our sample array of cars
		// Car cars[] = new Car[] { new Lexus("Lexus Is", 260, "Sedan", 3), new
		// Acura("Acura Mdx", 193, "Suv") };
		// Car car = new Lexus("Lexus Is", 260, "Sedan", 3);
		Car car = new Acura("Acura Mdx", 193, "Suv");

		// Create our gson instance
		// Gson gson = new Gson();

		// Create our gson instance
		GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(Car.class, new InterfaceAdapter());
		Gson gson = builder.create();

		// Let's serialize our array
		// String carsJsonFormat = gson.toJson(cars, Car[].class);
		String carsJsonFormat = gson.toJson(car, Car.class);

		// Let's Print our serialized arrya
		System.out.println("Cars in Json Format: " + carsJsonFormat);

		// Car[] carJsonArray = gson.fromJson(carsJsonFormat, Car[].class);
		Car carJsonArray = gson.fromJson(carsJsonFormat, Car.class);

		// Let's print our car objects to verify
		System.out.println("\n**********************************************************************");
		System.out.println("My favorite Cars of 2015");
		System.out.println("Cars in Json Format: " + carJsonArray.toString());
		/*
		 * for (Car aCar : carJsonArray) { System.out.println(aCar); }
		 */
		System.out.println("**********************************************************************");

	}
}
