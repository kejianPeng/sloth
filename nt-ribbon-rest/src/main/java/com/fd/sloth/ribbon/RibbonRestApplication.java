package com.fd.sloth.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @author FD.PENG 
 * @date : 2018-07-27
 */
@SpringBootApplication
@EnableHystrix
public class RibbonRestApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(RibbonRestApplication.class, args);
	}
	
}
