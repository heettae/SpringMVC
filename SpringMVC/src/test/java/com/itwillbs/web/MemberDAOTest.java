package com.itwillbs.web;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.persistence.MemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)
public class MemberDAOTest {
	
	// 로거 객체 생성 (로거:로그를 실행하는 객체)
	private static final Logger logger = LoggerFactory.getLogger(MemberDAOTest.class); //org.slf4j
	
	
	// 테스트파일 -> JSP페이지,컨트롤러 호출,Action페이지 호출
	// DAO 객체 - getDbTime() 메서드 호출
	// DAO 객체 직접생성X -> 의존주입(DI)
	@Inject
	private MemberDAO mdao;
	
	//@Test
	public void testDAO() {
		System.out.println(mdao);
	}
	
	//@Test
	public void dao_시간정보조회() {
		System.out.println( mdao.getDBTime() );		
	}
	
	//@Test
	public void dao_회원가입() {
		// tbl_member 테이블에 회원정보 저장
		
		// 회원정보 생성(view X)
//		MemberVO vo = new MemberVO();
//		vo.setUserid("itwill04");
//		vo.setUserpw("1234");
//		vo.setUsername("사용자");
//		vo.setUseremail("itwill04@itwill.com");

		
		// DAO 객체 생성 -> 의존주입된 객체정보를 사용
		// 회원가입 메서드
		//mdao.insertMember(vo);

		// 회원 대량 가입ㅋㅋ
		for(int i=3; i<=10; i++) {
			MemberVO vo = new MemberVO();
			vo.setUserid("itwill0"+i);
			vo.setUserpw("1234");
			vo.setUsername("사용자");
			vo.setUseremail("itwill0"+i+"@itwill.com");
		
			mdao.insertMember(vo);
		}
		
		System.out.println("TEST : 회원가입 성공! ");
		logger.debug("디버그 레벨 로그!");
		logger.info("인포레벨 로그!");
		logger.warn("워닝 레벨 로그!");
	}
	
	//@Test
	public void dao_로그인() {
		MemberVO vo = new MemberVO();
		vo.setUserid("admin");
		vo.setUserpw("1234");
		
		//MemberVO resultVO = mdao.loginMember(vo);
		MemberVO resultVO = mdao.loginMember(vo.getUserid(),vo.getUserpw());
		
		if(resultVO == null) {
			logger.debug("로그인 실패!");
		} else {
			logger.debug("로그인 성공!");
		}
	
	}
	
	//@Test
	public void dao_회원정보수정() {
	 
		// 수정할 회원정보
		MemberVO uvo = new MemberVO();
		uvo.setUsername("수정할 이름");
		uvo.setUserid("itwill03");
		
		// 디비 접근 객체
		mdao.updateVO(uvo);
		
		logger.debug(" 회원정보 수정 완료! ");
		
	}
	//@Test
	public void dao_회원정보삭제() {
		
		// 삭제회원 정보
		MemberVO delVO = new MemberVO();
		delVO.setUserid("itwill03");
		delVO.setUserpw("1234");
		
		mdao.deleteMember(delVO);
		logger.debug(" 회원정보 삭제 완료! ");
		
	}
	
	// 회원목록 조회
	@Test
	public void dao_회원목록조회() {
		List<MemberVO> memberList = mdao.getMemberList();
		for(MemberVO vo :memberList) {
			logger.debug(vo.getUserid()+" : "+vo.getUserpw());
		}
	}

}
