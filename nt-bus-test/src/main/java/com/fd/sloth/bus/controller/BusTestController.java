package com.fd.sloth.bus.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author FD.PENG
 * @date : 2018-08-09
 */
@RestController
@RefreshScope
public class BusTestController {

	@Value("${test.name}")
	private String showName;

	@GetMapping("/bus")
	public String getBusName() {
		return showName;
	}
}
