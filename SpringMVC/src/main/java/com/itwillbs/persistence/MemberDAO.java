package com.itwillbs.persistence;

import java.util.List;

import com.itwillbs.domain.MemberVO;

public interface MemberDAO {
	
	// 디비서버 시간 조회
	public String getDBTime();
	
	// 회원가입()
	public void insertMember(MemberVO vo); // 회원가입은 return 없음
	
	// 로그인()
	public MemberVO loginMember(MemberVO vo);
	public MemberVO loginMember(String id, String pw); // 아이디, 비밀번호 각각 전달하는 것도 가능
	
	// 회원 정보 수정()
	public void updateVO(MemberVO uvo);

	// 회원 정보 삭제()
	public void deleteMember(MemberVO delVO);

	// 회원 목록 조회()
	public List<MemberVO> getMemberList();
	
	// 회원 정보 조회()
	public MemberVO getMember(String id);
	
}
