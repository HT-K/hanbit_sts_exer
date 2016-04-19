package com.hanbit.web.member;

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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.hanbit.web.global.User;

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
	
	@RequestMapping("/join_form")
	public String join() {
		return "member/join_form.user";
	}
	
	//@RequestParam(value="subject",required=true) List<String> subject ==> 얘는 체크박스 값 받아오는 방법이다.
	//@RequestParam("major")String major
	@RequestMapping(value="/join", method=RequestMethod.POST) // 이건 post방식
	public String join( @RequestParam("id")String id, @RequestParam("password")String password,
						@RequestParam("name")String name, @RequestParam("addr")String addr,
						@RequestParam("birth")int birth, @RequestParam("cate")int cate) {
		
		MemberDTO param = new MemberDTO();
		param.setId(id);
		param.setPassword(password);
		param.setName(name);
		param.setAddr(addr);
		param.setBirth(birth);
		param.setCate(cate);
		
		int res = service.join(param);
		String view = "";
		
		if (res == 1) {
			logger.info("회원가입 성공!");
			view = "member/login_form.user";
		} else {
			logger.info("회원가입 실패!");
			view = "member/join_form.user";
		}
		return view;
	}
	
	// /member URL 들어오고 뒤에 action 값은 이곳에 넣는다.
	@RequestMapping("/login_form") // 이건 get방식
	public String login() {
		return "member/login_form.user";
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
		String view = "";
		
		if (member != null) {
			logger.info("로그인 성공");
			//session.setAttribute("user", member); // 로그인 성공 시 session에 로그인에 성공한 유저의 정보가 담긴 member 객체를 담는다.
			model.addAttribute("member", member); // 로그인 성공 시 다음 페이지에 request와 같은 역할을 하는 model에 member 객체를 담아 보낸다.
			model.addAttribute("user", member);
			//view = "member/detail";
			view = "redirect:/member/detail/"+id; // get 방식으로 detail에 id 값 보내기, redirect는 페이지로 가라는게 아니라 서블릿 호출이라고 생가갛면된다.
		} else {
			logger.info("로그인 실패");
			view = "member/login_form";
		}
		
		return view;
	}
	
	@RequestMapping("/logout") // 모든 회원 정보를 가져옴
	public String logout(SessionStatus status) {
		logger.info("=== member - logout() ===");
		status.setComplete(); // 세션 무효화
		return "member/main.user"; // 되돌아가라, redirect:/ 는 ${context}/ 와 같다, 즉 메인으로 돌아가라는 뜻이다.
	}
		
	@RequestMapping("/memList") // 모든 회원 정보를 가져옴
	public String memList(Model model) {
		logger.info("memList 진입 ");
		List<MemberDTO> list = service.getMemList();
		model.addAttribute("list", list);
		return "member/member_list";
	}
	
	
	@RequestMapping("/name/{name}") // 이름 검색으로 회원 정보들을 가져옴(중복이름가능!)
	public String getMembersByName(@PathVariable("name")String name) {
		MemberDTO param = new MemberDTO();
		param.setName(name);
		List<MemberDTO> list = service.getMemsByName(param);
		return "member/member_list";
	}
	
	@RequestMapping("/detail/{id}") // id 검색으로 회원 정보를 가져옴
	public String getMemberById(@PathVariable("id") String id, Model model) {
		if (service.isMember(id)) {
			logger.info("회원확인 성공 = {}", id);
			// 비회원인지, 학생 교수 관리자 인지 알아내야함. 데이터베이스에는 Cate로 인트형으로 저장되어있는데 이것을 enum에 보내서 role을 알아낸다.
			member = service.getMemById(id);
			member.setRole(User.valueOf(service.getMemById(id).getCate()).toString());
			model.addAttribute("member", member);
		} else {
			model.addAttribute("member", "");
		}

		return "member/detail.user";
	}
	
	@RequestMapping("/update") // 이건 get방식, update_form.jsp로 고고!
	public String update() {
		return "member/update_form";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST) // 이건 post방식, 이렇게 method를 지정해주지 않으면 default는 get방식이다!표9
	public String update(@RequestParam("password")String password, 
						 @RequestParam("addr")String addr,
						 HttpSession session,
						 Model model) {
		logger.info("update로 진입 ");
		MemberDTO param = (MemberDTO) session.getAttribute("user"); // 세션 객체에 user로 저장되어 있는 MemberDTO 객체를 가져온다. 
		param.setPassword(password);
		param.setAddr(addr);
		
		int result = service.update(param);
		String view = "";
		
		if (result == 1) {
			logger.info("업데이트 성공");
			session.setAttribute("user", param);
			model.addAttribute("member", param);
			view = "member/detail.user";
		} else {
			logger.info("업데이트 실패");
			view = "member/update_form.user";
		}
		return view;
	}
	
	@RequestMapping("/delete") 
	public String delete(HttpSession session,
						 SessionStatus status) {
		logger.info("=== member - delete() ===");
		
		MemberDTO param = (MemberDTO) session.getAttribute("user"); // 세션 객체에 user로 저장되어 있는 MemberDTO 객체를 가져온다. 
		int res = service.remove(param); // serviceImpl에 remove메소드 호출~
		
		if (res == 1) {
			logger.info("삭제 성공 : {}", member.getId());
			session.invalidate(); // 세션 무효화
			status.setComplete();
		} else {
			logger.info("삭제 실패 : {}", member.getId());
		}
		return "redurectL/";
	}
}
