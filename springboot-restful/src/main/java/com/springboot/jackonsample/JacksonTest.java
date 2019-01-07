package com.springboot.jackonsample;

import java.io.IOException;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class JacksonTest {

	public static void main(String[] args) {
		JacksonTest test = new JacksonTest();
		test.jsonCarDeserialization();
		test.jsonCarSerialization();
	}

	public void jsonCarDeserialization() {
		String carJson = "{ \"brand\" : \"Mercedes\", \"doors\" : 6 , \"date\":1516442298301 }";

		// ObjectMapper objectMapper = new ObjectMapper();
		// objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
		// false);
		// objectMapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES,
		// true);
		try {
			SimpleModule module = new SimpleModule("CarDeserializer", new Version(3, 1, 8, null, null, null));
			module.addDeserializer(Car.class, new CarDeserializer(Car.class));

			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.setDateFormat(dateFormat);
			objectMapper.registerModule(module);

			Car car = objectMapper.readValue(carJson, Car.class);
			System.out.println("car brand = " + car.getBrand());
			System.out.println("car doors = " + car.getDoors());
			System.out.println("car date = " + car.getManufacturedate());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void jsonCarSerialization() {

		try {
		SimpleModule module = new SimpleModule("CarSerializer", new Version(2, 1, 3, null, null, null));
		CarSerializer carSerializer = new CarSerializer(Car.class);
		module.addSerializer(Car.class, carSerializer);

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(module);

		Car car = new Car();
		car.setBrand("Mercedes");
		car.setDoors(5);

		String carJson = objectMapper.writeValueAsString(car);
		System.out.println("carJSON -" + carJson);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
