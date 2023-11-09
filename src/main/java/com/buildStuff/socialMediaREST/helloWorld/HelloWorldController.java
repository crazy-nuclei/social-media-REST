package com.buildStuff.socialMediaREST.helloWorld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping("/hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	
	@GetMapping("/hello-world-bean")
	public HelloWorldBean helloWorldUsingBean() {
		return new HelloWorldBean("Hello World Bean");
	}
	
	@GetMapping("/hello-world/pathVariable/{name}")
	public String helloWorldPathVariable(@PathVariable String name) {
		return "Hello World, " + name;
	}
}

