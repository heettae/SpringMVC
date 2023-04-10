package com.itwillbs.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.persistence.MemberDAO;

// @Service : 스프링에서 서비스 객체로 인식
@Service
public class MemberServiceImpl implements MemberService{

	// MemberDAO 객체 필요(객체 주입)
	// root-context에서 연결이 되어있음
	@Autowired //inject도 사용 가능. 지금 수준에서 크게 차이없음
	private MemberDAO mdao;

	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
	
	@Override
	public void memberJoin(MemberVO vo) {
		// 회원가입 동작 수행 (DAO 객체 - 회원가입 메서드 호출)
		// => DAO 객체 주입 - 필요한 메서드 호출
		mdao.insertMember(vo);
		
		
	}

	@Override
	public MemberVO memberLogin(MemberVO vo) {
		logger.info(" C -> S : memberLogin(MemberVO vo) 호출 "); //컨트롤러 -> 서비스 호출
		
		// DAO - 로그인 체크 메서드 호출
		MemberVO loginResultVO = mdao.loginMember(vo); //return된 값이 호출되고, loginResultVO에 담음
		logger.info(" 로그인 결과 : "+loginResultVO);
		
		logger.info(" S -> C : memberLoign(vo) 결과를 리턴 "); // 서비스 -> 컨트롤러
		
		return loginResultVO;
	}

	@Override
	public MemberVO memberInfo(String userid) {
		
		// 전달정보 저장
		
		// DAO - 회원정보 조회 호출
		MemberVO memberResultVO = mdao.getMember(userid);
		logger.info("회원정보:"+memberResultVO);
		
		
		return memberResultVO;
	} 

	
	
	
	
}
