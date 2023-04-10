package com.itwillbs.web;

import java.io.UnsupportedEncodingException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.service.MemberService;
import com.mysql.cj.Session;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	// Service 객체 필요(DAO 접근을 위해서)
	// private MemberService service = new MemberServiceImpl();(x)
	@Inject
	private MemberService service; // 객체 의존 주입
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	// http://localhost:8080/web/insertForm (x)
	// http://localhost:8080/web/member/insertForm
	// -> 서버의 시작주소(프로젝트명) '/web' => '/' 으로 변경 (톰캣서버 끄고 더블클릭해서 변경했음)
	// http://localhost:8080/member/insertForm
	// 회원가입 - 정보 입력
	@RequestMapping("/insertForm")
	public void memberinsert() {
		logger.debug(" memberInsert() 실행 ");
		logger.debug(" 주소에 해당하는 view페이지 연결 ");
		
	}
	
	
	// 회원가입 - 정보 처리
	@RequestMapping(value = "/insertPro")
	public void memberInsertPro(MemberVO vo) {
		logger.debug(" memberInsertPro() 호출!! ");
//		try {
//			// 기존의 MVC 패턴
//			// 한글처리 => 필터
//				request.setCharacterEncoding("UTF-8");
//			// 전달정보(파라메터) 저장(회원가입정보)
//				//String userid = request.getParameter("userid");
//				//logger.info(userid);
				
			// 스프링 - 메서드 전달인자를 통해서 자동으로 파라메터 수집
		
				logger.info(vo+"");
			
				
				// DB에 저장 =>> 서비스 객체를 주입
				// MVC : MemberDAO 객체 생성 => 강한결합 
				// 스프링 : MemberDAO 객체 주입 => 약한결합 (DI)
				// =>> Controller - 서비스 - DAO 직접연결
				
				logger.info(service+"");
				service.memberJoin(vo); //vo는 매개변수로 받아옴
			// 페이지 이동(login)
				
				
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
	}
	
	
	/////////////////////////////////////////////////////////// 위에는 기존에 배웠던 방식대로, 아래는 스트링으로 
	// 회원가입
	
	// http://localhost:8080/member/insert
	// 회원가입 - 정보입력
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insertGET() {
		logger.info(" insertGet() 호출 ");
		logger.info(" /insert 주소에 연결된 view페이지(./member/insert.jsp)로 이동 ");
		
		return "/member/insertForm";
	} // 기존 mvc 패턴에서 패턴1번과 같음. void : 따로 return값 입력하지 않아도 됨 , String : view 페이지 이름이 달라도 사용 가능
	
	
	
	// 회원가입 - 정보처리
	@RequestMapping(value = "/insert", method = RequestMethod.POST) // 똑같은 주소(/insert)로 두가지 동작(회원가입 정보입력,처리)을 함. 전달방식(get,post)을 달리해서 처리함. (장점:주소를 하나하나 기억하지 않아도 됨)
	public String insertPOST(MemberVO vo) {
		logger.info(" insertPOST() 호출 "); 
		// 1. 한글처리 (web.xml 필터 설정)
		
		// 2. 전달정보 - 파라메터 저장 (컨트롤러 파라메터 자동수집) *매개변수에 MemberVO 작성하였음
		logger.info(vo.toString()); // INFO : com.itwillbs.web.MemberController - MemberVO [userid=itwill12, userpw=1234, username=사용자, useremail=itwill12@itwill.com, regdate=null, updatedate=null]
		
		// 3. 전달정보 저장 -> service -> DB(DAO)
		service.memberJoin(vo); // service -> impl -> 
		
		// 4. 페이지 이동 - 로그인 페이지
		return "redirect:/member/login";
	}
	
	
	// http://localhost:8080/member/login
	// 로그인 - 정보입력
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginGET() {
		logger.info(" loginGet() 호출 ");
		logger.info(" /login -> login.jsp 페이지 이동 ");
		return "/member/login";
	}

	// 쌤이 한 것
//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	public void loginGET() {
//		logger.info(" loginGet() 호출 ");
//		logger.info(" /login -> login.jsp 페이지 이동 ");
//	}
	
	// 로그인 - 정보처리
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPOST(MemberVO vo, HttpSession session /*, @ModelAttribute("userid") String userid */) { 
		// MemberVO 하나만 받는 것이 좋음, 전달인자가 많을 수록 성능 저하
		// HttpSession session은 jsp 페이지에서 값을 받아옴
		
		String result;
		logger.info(" loginPOST() 호출 ");
		
		// 전달정보 저장
		logger.info(vo.toString());
		
		// 서비스 -> DAO -> 로그인 판단
		MemberVO loginResultVO = service.memberLogin(vo);
		if(loginResultVO!=null) { 
			// 로그인 성공
			logger.info(" 로그인 성공! ");
			// 아이디 정보를 세션에 저장
			//session 내장 객체 없음. login.jsp에 session 내장객체 있음 (매개변수 자리에 HttpSession 필요)
			session.setAttribute("id", loginResultVO.getUserid());
			// main페이지로 이동
			result = "redirect:/member/main"; // 쌤은 이 자리에 바로 return 작성했음~!
		} else {
			// 로그인 실패
			logger.info(" 로그인 실패! ");
			// 로그인 페이지로 이동
			result = "redirect:/member/login";
		}
		return result;
	}
	
	// http://localhost:8080/member/main
	// 메인페이지
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public void mainGET() {
		logger.info(" mainGET() 호출! ");
		logger.info(" /main -> /main.jsp 페이지 이동 ");
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutGET(HttpSession session) {
		
		logger.info(" logoutGET() 호출"); 
		// 로그아웃 => 세션정보 초기화
		session.invalidate();
		
		//페이지이동
		return "redirect:/member/main";
	}
	
	//http://localhost:8080/member/info
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public String infoGET(MemberVO vo,HttpSession session, Model model) {
	
		logger.info(" infoGET() 호출 ");
		// 회원 아이디(PK) => session
		String id = (String) session.getAttribute("id");
		if(id == null) {
			return "redirect:/member/login";
		}
		// 회원정보 조회 => 서비스 => DAO
		vo = service.memberInfo(id);
		// DB에서 가져온 데이터를 view 페이지로 전달
		model.addAttribute(vo);
		
		
		
		logger.info(" /info -> info.jsp 페이지 이동 ");
		
		return "/member/info";
	}
	
}
