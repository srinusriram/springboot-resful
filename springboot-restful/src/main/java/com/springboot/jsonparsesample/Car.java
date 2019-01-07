package com.springboot.jsonparsesample;

import static java.util.Objects.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Car implements Vehicle {
	String name;

	@JsonCreator
	public Car(@JsonProperty("name") final String name) {
		this.name = requireNonNull(name);
	}

	public String getName() {
		return this.name;
	}
}
