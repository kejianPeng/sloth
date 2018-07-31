package com.fd.sloth.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author FD.PENG 
 * @date : 2018-07-31
 */
@FeignClient(value = "nt-sayhi")
public interface SayHiService {

	@GetMapping("/hi")
	public String sayHi();

}
