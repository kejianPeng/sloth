package com.fd.sloth.feign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fd.sloth.feign.service.SayHiService;

/**
 * @author FD.PENG
 * @date : 2018-07-31
 */
@RestController
public class FeignController {

	@Autowired
	private SayHiService sayHiService;

	@GetMapping("/feignHi")
	public String sayHi() {
		return sayHiService.sayHi();
	}
}
