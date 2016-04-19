package com.hanbit.web.admin;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hanbit.web.global.User;
import com.hanbit.web.member.MemberDTO;
import com.hanbit.web.member.MemberService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	@Autowired MemberDTO member; // 이 MemberController에 MemberDTO 객체를 가져와 달라는 뜻이다. (싱글톤)
	@Autowired MemberService service; 

	@RequestMapping("/login_form")
	public String login() {
		logger.info("=== login() 진입 ===");
		return "admin/login_form.admin";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST) // id 값만 공개 시킨다.
	public String login(@RequestParam("id")String id, 
						@RequestParam("password")String password, //비밀번호는 노출되지 않기 위해 RequestParam으로 바든다.
						HttpSession session, 
						Model model) { 
		logger.info("로그인 컨트롤러 파라미터 ID : {}", id);
		logger.info("로그인 컨트롤러 파라미터 PW : {}", password);
		
		MemberDTO param = new MemberDTO();
		param.setId(id);
		param.setPassword(password);
		member = service.login(param);
		member.setRole(User.valueOf(member.getCate()).toString());
		String view = "";
		
		if (member.getRole().equals("관리자")) {
			logger.info("로그인 성공");
			//session.setAttribute("user", member); // 로그인 성공 시 session에 로그인에 성공한 유저의 정보가 담긴 member 객체를 담는다.
			model.addAttribute("user", member); // 세션 객체에 member객체를 실어보낸다.
			model.addAttribute("member", member); // 로그인 성공 시 다음 페이지에 request와 같은 역할을 하는 model에 member 객체를 담아 보낸다.
			view = "admin/admin_form.admin";
		} else {
			logger.info("로그인 실패");
			view = "admin/login_form";
		}
		return view;
	}
		

}
