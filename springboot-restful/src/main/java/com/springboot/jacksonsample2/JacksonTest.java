package com.springboot.jacksonsample2;

import java.io.IOException;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class JacksonTest {

	public static void main(String[] args) {
		JacksonTest test = new JacksonTest();
		// test.jsonCarDeserialization();
		// test.jsonCarSerialization();
		// test.jsonEmpDeserialization();
		// test.jsonEmpSerialization();
		// test.jsonNodeEmpDeserialization();
	}

/*	public void jsonNodeEmpDeserialization() {
		String empJson = "{\"name\":\"Saibaba\", \"age\":\"Six\", \"deptName\":\"Finance\", \"dept\":{\"name\":\"finance\",\"financeDegree\":\"MBA\"}}";
		try {
			JsonFactory jsonFactory = new JsonFactory();
			JsonParser jsonParser = jsonFactory.createParser(empJson);
			while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
				String fieldname = jsonParser.getCurrentName();
				if ("name".equals(fieldname)) {
					jsonParser.nextToken();
					System.out.println(jsonParser.getText());
				}
				if ("age".equals(fieldname)) {
					jsonParser.nextToken();
					System.out.println(jsonParser.getText());
				}
				if ("deptName".equals(fieldname)) {
					jsonParser.nextToken();
					System.out.println(jsonParser.getText());
				}
				if ("dept".equals(fieldname)) {
					for (JsonNode node : contactNode) {
						String type = node.path("type").asText();
						String ref = node.path("ref").asText();
						System.out.println("type : " + type);
						System.out.println("ref : " + ref);

					}
					jsonParser.nextToken();
					System.out.println(jsonParser.getText());
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/*
	 * public void jsonNodeEmpDeserialization() { String empJson =
	 * "{\"name\":\"Saibaba\", \"age\":\"Six\", \"deptName\":\"Finance\", \"dept\":{\"name\":\"finance\",\"financeDegree\":\"MBA\"}}"
	 * ;
	 * 
	 * try { ObjectMapper objectMapper = new ObjectMapper(); JsonNode root =
	 * objectMapper.readValue(empJson, JsonNode.class);
	 * 
	 * Iterator<JsonNode> iterator = root.elements(); while (iterator.hasNext()) {
	 * JsonNode node = iterator.next(); if(node.equals("dept")) { JsonNode childNode
	 * = childNode.get("name"); String field = childField.asText();
	 * System.out.println("field = " + field); }
	 * System.out.print("nodeName = "node.toString()+node.asText()); }
	 * 
	 * 
	 * JsonNode array = node.get("owners"); JsonNode jsonNode = array.get(0); String
	 * john = jsonNode.asText(); System.out.println("john  = " + john);
	 * 
	 * JsonNode child = node.get("nestedObject"); JsonNode childField =
	 * child.get("field"); String field = childField.asText();
	 * System.out.println("field = " + field);
	 * 
	 * System.out.println("Emp Name = " + emp.getName());
	 * System.out.println("Emp Age = " + emp.getAge());
	 * System.out.println("Emp DeptName = " + emp.getDeptName());
	 * System.out.println("Emp Dept = " + emp.getDept());
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } }
	 */

	public void jsonEmpDeserialization() {
		String empJson = "{\"name\":\"Saibaba\", \"age\":\"Six\", \"deptName\":\"Finance\", \"dept\":{\"name\":\"finance\",\"financeDegree\":\"MBA\"}}";

		// ObjectMapper objectMapper = new ObjectMapper();
		// objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
		// false);
		// objectMapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES,
		// true);
		try {
			// SimpleModule module = new SimpleModule("EmployeeDeserializer", new Version(3,
			// 1, 8, null, null, null));
			// module.addDeserializer(Employee.class, new
			// EmployeeDeserializer(Employee.class));

			ObjectMapper objectMapper = new ObjectMapper();

			// SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			// objectMapper.setDateFormat(dateFormat);

			// objectMapper.registerModule(module);

			Employee emp = objectMapper.readValue(empJson, Employee.class);
			System.out.println("Emp Name = " + emp.getName());
			System.out.println("Emp Age = " + emp.getAge());
			System.out.println("Emp DeptName = " + emp.getDeptName());
			System.out.println("Emp Dept = " + emp.getDept());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void jsonEmpSerialization() {

		try {
			SimpleModule module = new SimpleModule("EmployeeSerializer", new Version(2, 1, 3, null, null, null));
			EmployeeSerializer empSerializer = new EmployeeSerializer(Employee.class);
			module.addSerializer(Employee.class, empSerializer);

			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.registerModule(module);

			Employee emp = new Employee();
			emp.setName("Venkat");
			emp.setAge("seven");

			String empJson = objectMapper.writeValueAsString(emp);
			System.out.println("empJSON -" + empJson);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
