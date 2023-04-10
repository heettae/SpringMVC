package com.itwillbs.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwillbs.persistence.MemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)
public class MemberDAOTest {
	
	// 테스트파일 -> JSP페이지,컨트롤러 호출,Action페이지 호출
	
	// DAO 객체 - getDbTime() 메서드 호출
	
	// DAO 객체 직접생성X -> 의존주입(DI)
	@Inject
	private MemberDAO mdao;
	
	//@Test
	public void testDAO() {
		System.out.println(mdao);
	}
	
	@Test
	public void dao_시간정보조회() {
		System.out.println( mdao.getDbTime() );		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
