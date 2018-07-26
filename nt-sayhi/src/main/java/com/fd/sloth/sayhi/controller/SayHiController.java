package com.fd.sloth.sayhi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SayHiController {

	@Value("${server.port}")
	private String port;

	@GetMapping("/hi")
	public String sayHi(@RequestParam("name") String name) {
		return "Hi " + name + ", port = " + port;
	}
}
