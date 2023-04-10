package com.itwillbs.service;

import com.itwillbs.domain.MemberVO;

public interface MemberService {
	// 서비스의 형태를 선언
	
	// 회원가입 - memberJoin
	public void memberJoin(MemberVO vo);
	
	// 회원로그인 - memberLogin
	public MemberVO memberLogin(MemberVO vo);
	
	// 회원정보조회 - memberInfo()
	public MemberVO memberInfo(String userid);
	
}
