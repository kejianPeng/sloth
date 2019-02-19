package com.fd.sloth.sayhi.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author FD.PENG
 * @date : 2018-08-10
 */
@Configuration
public class RestTemplateConfig {

	private static final Integer READ_TIMEOUT = 30000;
	private static final Integer CONNECT_TIMEOUT = 3000;

	/**
	 * 添加 @LoadBalanced， 说明 开启负载均衡的功能
	 * @param factory
	 * @return
	 */
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(ClientHttpRequestFactory factory) {
		return new RestTemplate(factory);
	}

	@Bean
	public ClientHttpRequestFactory simpleClientHttpRequestFactory() {
		SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
		factory.setReadTimeout(READ_TIMEOUT);
		factory.setConnectTimeout(CONNECT_TIMEOUT);
		return factory;
	}
}
