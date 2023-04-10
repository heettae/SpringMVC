package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.ProductVO;

@Controller
public class SampleController3 {

	

	private static final Logger logger = LoggerFactory.getLogger(SampleController3.class);
	// http://localhost:8080/web/doD
	// http://localhost:8080/web/doD?name=itwill
	@RequestMapping(value = "/doD", method = RequestMethod.GET)
	public String doD(Model model) {
		
		logger.info(" doD() 실행 !!! ");
		
		// 객체를 전달 -> 연결된 view 페이지
		
		ProductVO vo = new ProductVO();
		vo.setName("컴퓨터");
		vo.setPrice(300);
		
		// Model 객체(스프링 기본제공)
		// => 원하는 뷰페이지까지 정보를 전달하는 데이터 컨테이너
		//model.addAttribute("vo", vo);
		model.addAttribute(vo);
		//				  (객체)
		// => model.addAttribute 전달되는 객체의 이름이 없는 경우
		// 전달되는 객체의 클래스 타입명을 첫글자를 소문자로 변경 후 전달되는 이름으로 사용 (ex.${productVO.name })
		
		return "product";
	}
	
}
