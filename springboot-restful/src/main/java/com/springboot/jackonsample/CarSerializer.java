package com.springboot.jackonsample;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class CarSerializer extends StdSerializer<Car> {

	protected CarSerializer(Class<Car> t) {
		super(t);
	}

	public void serialize(Car car, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
			throws IOException {

		jsonGenerator.writeStartObject();
		jsonGenerator.writeStringField("producer", car.getBrand());
		jsonGenerator.writeNumberField("doorCount", car.getDoors());
		jsonGenerator.writeEndObject();
	}
}