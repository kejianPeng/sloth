package com.fd.sloth.ribbon;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RibbonRestApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RibbonRestApplicationTest {

	private static Logger logger = LoggerFactory.getLogger(RibbonRestApplicationTest.class);
	
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext context;

	@Autowired
	private RestTemplate restTemplate;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}
	
	@Test
	public void testRibbon() {
		
	}
}
