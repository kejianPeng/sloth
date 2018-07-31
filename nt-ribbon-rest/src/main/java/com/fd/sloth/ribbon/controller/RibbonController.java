package com.fd.sloth.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * @author FD.PENG
 * @date : 2018-07-30
 */
@RestController
public class RibbonController {

	@Autowired
	private RestTemplate restTemplate;

	public static final String NT_SAYHI_URL = "http://NT-SAYHI/hi";

	@HystrixCommand(fallbackMethod = "ribbonRestError")
	@GetMapping("/ribbonHi")
	public String testRibbonRest() {
		return restTemplate.getForObject(NT_SAYHI_URL, String.class);
	}

	public String ribbonRestError() {
		return "nt-ribbon-rest error.";
	}

}
