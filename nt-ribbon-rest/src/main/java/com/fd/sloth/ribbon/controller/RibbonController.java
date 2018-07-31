package com.fd.sloth.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author FD.PENG 
 * @date : 2018-07-30
 */
@RestController
public class RibbonController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/ribbonHi")
	public String testRibbonRest() {
		String url = "http://NT-SAYHI/hi";
		return restTemplate.getForObject(url, String.class);
	}

}
