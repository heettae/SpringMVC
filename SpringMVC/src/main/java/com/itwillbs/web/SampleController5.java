package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itwillbs.domain.ProductVO;

@Controller
public class SampleController5 {

	

	private static final Logger logger = LoggerFactory.getLogger(SampleController5.class);
	
	//http://localhost:8080/web/doG
	@RequestMapping(value= "/doG")
	@ResponseBody
	public /* @ResponseBody */ ProductVO doG() {
		logger.info(" doG() 호출!! ");
		ProductVO vo = new ProductVO();
		vo.setName("우산");
		vo.setPrice(5000);
		
		return vo;
	}
	
	//http://localhost:8080/web/doH
	@RequestMapping(value= "/doH")
	@ResponseBody
	public /* @ResponseBody */ double doH() {
		logger.info(" doH() 호출!! ");
		
		// JSON 타입의 데이터로 전달
		return 10000;
	}
	
}
