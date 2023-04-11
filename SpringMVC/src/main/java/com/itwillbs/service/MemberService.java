package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.MemberVO;

public interface MemberService {
	// 서비스의 형태를 선언
	
	// 회원가입 - memberJoin
	public void memberJoin(MemberVO vo);
	
	// 회원로그인 - memberLogin
	public MemberVO memberLogin(MemberVO vo);
	
	// 회원정보조회 - memberInfo
	public MemberVO memberInfo(String userid);
	
	// 회원정보수정 - memberUpdate
	public void memberUpdate(MemberVO vo);
	
	// 회원탈퇴 - memberDelete
	public void memberDelete(MemberVO vo);
	
	// 회원정보(목록정보) 조회
	public List<MemberVO> memberList();
	// 들고오는 값이 고정되어 있기때문에 <MemberVO> 작성
}
