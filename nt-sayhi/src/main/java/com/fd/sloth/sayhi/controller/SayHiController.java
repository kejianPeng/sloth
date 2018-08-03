package com.fd.sloth.sayhi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author FD.PENG
 * @date : 2018-07-26
 */
@RestController
@RefreshScope
public class SayHiController {

	@Value("${server.port}")
	private String port;

	@Value("${test.name}")
	private String showName;

	@GetMapping("/hi")
	public String sayHi() {
		return "Hi, " + showName + ", port = " + port;
	}
}
