package com.fd.sloth.sayhi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author FD.PENG
 * @date : 2018-07-26
 */
@SpringBootApplication
@EnableEurekaClient
public class SayHiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SayHiApplication.class, args);
	}

}
