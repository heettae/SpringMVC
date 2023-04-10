package com.itwillbs.web;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

//@WebAppConfiguration : 스프링MVC로 테스트하겠다
//@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"}) : spring 폴더 밑에있는 .xml 다 쓴다는 뜻
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class SampleControllerTest {
	//컨트롤러를 테스트하는 객체
	

	private static final Logger logger = LoggerFactory.getLogger(SampleControllerTest.class);
	
	@Inject
	private WebApplicationContext wac;
	
	private MockMvc mockMVC;
	// 테스트전용 request, response
	
	
	// @Before(org.junit) : @Test 어노테이션이 실행되기 전에 먼저 실행되는 코드(사전준비동작)
	@Before //org.junit test하기 전 설치할 것들 정리
	public void setUp() {
		this.mockMVC = MockMvcBuilders.webAppContextSetup(this.wac).build();
		
		logger.info(" 기본 설치 준비 완료! ");
		
		
	}
	
	@Test
	public void testDoA() throws Exception{
		logger.info(" SampleController의 메서드 호출!! ");
		
		mockMVC.perform(MockMvcRequestBuilders.get("/doE"));
	}
	
}
