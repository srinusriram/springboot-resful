package com.springboot.jacksonsample2;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class EmployeeDeserializer extends StdDeserializer<Employee> {

	public EmployeeDeserializer(Class<?> vc) {
		super(vc);
	}

	@Override
	public Employee deserialize(JsonParser parser, DeserializationContext deserializer) throws IOException {
		Employee emp = new Employee();

		String deptName = null;
		while (!parser.isClosed()) {
			System.out.println("parser -" + parser.toString());
			// System.out.println("Looping 1..........!");
			JsonToken jsonToken = parser.nextToken();
			if (JsonToken.FIELD_NAME.equals(jsonToken)) {
				// System.out.println("Looping 2..........!");
				String fieldName = parser.getCurrentName();
				// System.out.println(fieldName);
				// System.out.println("Looping 3..........!");
				jsonToken = parser.nextToken();
				// System.out.println("Looping 4..........!");

				if ("name".equals(fieldName)) {
					// System.out.println("Looping 5..........!");
					emp.setName(parser.getValueAsString());
				} else if ("age".equals(fieldName)) {
					// System.out.println("Looping 6..........!");
					emp.setAge(parser.getValueAsString());
				} else if ("deptName".equals(fieldName)) {
					// System.out.println("Looping 7..........!");
					emp.setDeptName(parser.getValueAsString());
					deptName = parser.getValueAsString();
				}
				else if ("department".equals(fieldName)) {
					System.out.println("Looping 8..........!" + parser.getValueAsString());
					// emp.setDept(dept);Dept(parser.getValueAsString());
				}
			}
		}
		System.out.println("deserialize DeptName -" + deptName);
		return emp;
	}

}
