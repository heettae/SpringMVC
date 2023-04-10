package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller : 해당 클래스가 컨트롤러의 동작을 수행하도록 선언. (선언시 파일에 S모양이 뜸.spring이 관리한다는 뜻)
@Controller
public class SampleController1 {


	private static final Logger logger = LoggerFactory.getLogger(SampleController1.class);
	
	// 기존의 if-else 주소비교 => 메서드로 동작을 구현
	// http://localhost:8080/web/doA
	// http://localhost:8080/web/doA.me
	
	// *메서드의 리턴타입이 void일 때, 메핑되는 주소 이름의 페이지(jsp)를 자동으로 연결한다.
	// /WEB-INF/views/doA.jsp
	@RequestMapping("/doA")
	public void doA() {
		logger.info("doA() 실행!!!!!!!!");
		
	}
	
	
	// doB 주소를 사용해서 페이지 연결
	// http://localhost:8080/web/doB
	@RequestMapping("/doB")
	public void doB() {
		logger.info("doB() 실행!!!!!!!!");
		
	}
	
	
}
