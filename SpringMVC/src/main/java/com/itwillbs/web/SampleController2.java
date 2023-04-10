package com.itwillbs.web;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwillbs.domain.MemberVO;



@Controller
public class SampleController2 {
	

	private static final Logger logger = LoggerFactory.getLogger(SampleController2.class);
	
	// 사용불가 리턴 : int, double
	
	// 메서드의 리턴타입이 String일때, 리턴되는 문자열.jsp 페이지로 이동
	// http://localhost:8080/web/doC
	// @RequestMapping(value = "/doC")
	// @RequestMapping(value = "/doC", method = RequestMethod.GET) get방식일때 실행
	@GetMapping(value = "/doC")
	public String doC() {
		logger.info(" doC() 호출!!!!! ");
		return "itwill";
	}
	
	
	
	
	//@RequestParam("name") String name
	// => "name" 이름의 파라메터 정보를 name(String) 변수에 저장
	// =>> key-value 1:1 관계
	
	// http://localhost:8080/web/doC1?name=itwill
	@GetMapping(value = "/doC1")
	public String doC1(@RequestParam("name") String name) {
		logger.info(" doC1() 호출!!!!! ");
		//request.getparamater("name") (X) request 내장객체 없음
		logger.info("name : "+name);
		
		return "itwill";
	}
	
	
	
	
	
	// @ModelAttribute("name") String name
	// => key-value 1:N 관계
	// 				bean/collection
	// =>> @RequestParam 동작 수행 => Model 객체에 저장 => 사용
	
	// http://localhost:8080/web/doC2?name=itwill
	// http://localhost:8080/web/doC2?name=itwill&age=20
	// http://localhost:8080/web/doC2?userid=itwill01&userpw=1234
	
	@GetMapping(value = "/doC2")
	//public String doC2(@ModelAttribute("name") String name) { 아래처럼 줄일 수 있음
	//public String doC2(String name, int age) {
	public String doC2(MemberVO vo) {
		logger.info(" doC2() 호출!!!!! ");
		//request.getparamater("name") (X) request 내장객체 없음
//		logger.info("name : "+name);
//		logger.info("age : "+age);
		logger.info(vo+"");
		//model.addAttribute("memberVO", vo)가 생략된 것과 같음
		// 자동으로 vo안에 저장시킴
		
		return "itwill";
	}
}
