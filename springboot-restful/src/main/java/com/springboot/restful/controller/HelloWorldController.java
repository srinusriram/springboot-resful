/**
 * 
 */
package com.springboot.restful.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.restful.model.HelloWorldBean;

/**
 * @author W520
 *
 */

@RestController
public class HelloWorldController {

	// @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Came to HelloWorld !!!";
	}

	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("HelloWorld Bean");
	}

	@GetMapping(path = "/hello-world-path/{message}")
	public HelloWorldBean helloWorldPath(@PathVariable String message) {
		return new HelloWorldBean(String.format("HelloWorld %s", message));
	}
}
