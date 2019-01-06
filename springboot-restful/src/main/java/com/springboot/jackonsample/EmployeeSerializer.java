package com.springboot.jackonsample;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class EmployeeSerializer extends StdSerializer<Employee> {

	protected EmployeeSerializer(Class<Employee> t) {
		super(t);
	}

	public void serialize(Employee emp, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
			throws IOException {

		jsonGenerator.writeStartObject();
		jsonGenerator.writeStringField("Employee Name", emp.getName());
		jsonGenerator.writeStringField("Employee Age", emp.getAge());
		jsonGenerator.writeEndObject();
	}
}