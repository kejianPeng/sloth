package com.fd.sloth.feign.config;

import org.springframework.stereotype.Component;

import com.fd.sloth.feign.service.SayHiService;

/**
 * @author FD.PENG
 * @date : 2018-07-31
 */
@Component
public class FeignServiceHystrix implements SayHiService {

	@Override
	public String sayHi() {
		return "nt-feign error.";
	}

}
