package com.fd.sloth.sayhi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author FD.PENG
 * @date : 2018-07-26
 */
@RestController
@RefreshScope
public class SayHiController {

	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${server.port}")
	private String port;

	@Value("${test.name}")
	private String showName;
	
	public static final String NT_RIBBON_HI_URL = "http://NT-RIBBON-REST/ribbonHi";

	@GetMapping("/hi")
	public String sayHi() {
		return "Hi, " + showName + ", port = " + port;
	}
	
	@GetMapping("/acceptReq")
	public String acceptReq() {
		return restTemplate.getForObject(NT_RIBBON_HI_URL, String.class);
	}
}
