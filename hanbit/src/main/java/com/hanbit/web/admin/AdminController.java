package com.hanbit.web.admin;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

import com.hanbit.web.global.User;
import com.hanbit.web.member.MemberDTO;
import com.hanbit.web.member.MemberService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	@Autowired AdminDTO admin;
	@Autowired AdminService adminService;
	@Autowired MemberDTO member; // 이 MemberController에 MemberDTO 객체를 가져와 달라는 뜻이다. (싱글톤)
	@Autowired MemberService memberService; 

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
		
		AdminDTO param = new AdminDTO();
		param.setId(id);
		param.setPassword(password);
		admin = adminService.login(param);
		logger.info("=== 디비 다녀오기 성공 ===");
		admin.setRole(User.valueOf(admin.getCate())); // 데이터베이스에서 가져온 cate 값에 따른 role 지정 (global -> user 이넘에 구현해놓음)
		String view = "";
		
		if (admin.getRole().equals("관리자") || admin.getRole().equals("교수")) { // role이 관리자나 교수여야 로그인 성공
			logger.info("=== 관리자 로그인 성공 ===");
			session.setAttribute("user", admin); // 로그인 성공 시 session에 로그인에 성공한 관리자의 정보가 담긴 member 객체를 담는다.
			//model.addAttribute("user", admin); // 위 세션("user")에 admin을 담는 것과 동일하다. model로 세션에 접근이 가능하다. 단 @SessionAttributes("user") 이렇게 어노테이션으로 세션이 생성되어 있어야한다.
			view = "admin/subject_list.admin";
		} else {
			logger.info("=== 관리자 로그인 실패 ===");
			view = "admin/login_form.admin";
		}
		return view;
	}
	
	@RequestMapping("/logout") // 관리자가 로그아웃 했을 시
	public String logout(
			SessionStatus status,
			Model model,
			HttpSession session){
		logger.info("=== admin-logout() ===");
		session.setAttribute("user", null);
		//model.addAttribute("user", null); // 자바에서 객체 소멸은 가바지 컬렉터에 의해 이루어진다. 따라서 로그아웃시 로그아웃버튼이 사라지게하려면 빈 member객체를 세션 객체에 저장하는 방법이 좋다!
		status.setComplete(); // 세션 사용 중지
		return "redirect:/admin/login_form.admin"; // 다시 관리자 로그인 폼으로~
	}		
	
	@RequestMapping("/member/profile/{id}") // 학생 개인 신상명세 보기 (admin.js와 연결되어있다~)
	public @ResponseBody MemberDTO getMemberProfile(
			@PathVariable("id")String id){
		logger.info("=== getMemberProfile() ===");
		return memberService.getById(id);
	}
	
	@RequestMapping("/admin_list") // admin 테이블 내용 전부 보기
	public @ResponseBody List<AdminDTO> admin_list(
			Model model){
		logger.info("=== admin_list() ===");
		List<AdminDTO> list = adminService.getListAll(); // admin 테이블에 저장된 모든 admin을 리스트에 담아 가져온다
		for (AdminDTO temp : list) {
			temp.setRole(User.valueOf(temp.getCate())); // 가져온 관리자 리스트의 내용 중 role을 셋하기 위해 for-each문으로 하나씩 꺼내 cate와 User(enum)를 이용해 role 값을 세팅한다.
		}
		return list; // role 값까지 모두 셋팅한 관리자 리스트를 리턴값으로 보낸다. (admin.js의 admin.list()로!)
	}
}
