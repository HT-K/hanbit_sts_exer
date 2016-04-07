package com.hanbit.web.member;

import java.util.Enumeration;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

// 어노테이션 (annotation), 첨삭의 용도, context가 얘를 controller로 판단하게 하는 역할을 한다.
@Controller
// 세션 값을 설정하는 어노테이션, user라는 이름을 가진 세션 객체를 생성한다.
@SessionAttributes("user")
// @Webservlet의 발전형 /member(directory)URL로 접근하면 모두 이 MemberController로 넘어오게 된다.
@RequestMapping("/member")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Autowired MemberDTO member; // 이 MemberController에 MemberDTO 객체를 가져와 달라는 뜻이다. (싱글톤)
	@Autowired MemberService service;
	
	// /member URL 들어오고 뒤에 action 값은 이곳에 넣는다.
	@RequestMapping("/login") // 이건 get방식
	public String login() {
		return "member/login_form";
	}
	@RequestMapping(value="/login", method=RequestMethod.POST) // 이건 포스트 방식
	public String login(@RequestParam("id")String id, 
						@RequestParam("password")String password, 
						HttpSession session, 
						Model model) { 
		logger.info("로그인 컨트롤러 파라미터 ID : {}", id);
		logger.info("로그인 컨트롤러 파라미터 PW : {}", password);
		
		MemberDTO param = new MemberDTO();
		param.setId(id);
		param.setPassword(password);
		member = service.login(param);
		String view = "";
		
		if (member.getId() != null) {
			logger.info("로그인 성공");
			session.setAttribute("user", member); // 로그인 성공 시 session에 로그인에 성공한 유저의 정보가 담긴 member 객체를 담는다.
			//model.addAttribute("member", member); // 로그인 성공 시 다음 페이지에 request와 같은 역할을 하는 model에 member 객체를 담아 보낸다.
			view = "member/detail";
		} else {
			logger.info("로그인 실패");
			view = "member/login_form";
		}
		
		return view;
	}
	
	@RequestMapping("/update") // 이건 get방식
	public String update() {
		return "member/update_form";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST) // 이건 post방식
	public String update(@RequestParam("password")String password, 
						 @RequestParam("addr")String addr,
						 HttpSession session,
						 Model model) {
		logger.info("update로 진입 ");
		MemberDTO param = (MemberDTO) session.getAttribute("user"); // user 세션에 저장된 MemberDTO 객체를 받아온다. 
		param.setPassword(password);
		param.setAddr(addr);
		
		int result = service.update(param);
		String view = "";
		
		if (result == 1) {
			
			logger.info("업데이트 성공");
			session.setAttribute("user", param);
			view = "member/detail";
		} else {
			logger.info("업데이트 실패");
			view = "member/update_form";
		}
		
		return view;
	}
}
