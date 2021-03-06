package com.hanbit.web.member;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import com.hanbit.web.global.Constants;
import com.hanbit.web.global.User;
import com.hanbit.web.util.FileUpload;

// 어노테이션 (annotation), 첨삭의 용도, context가 얘를 controller로 판단하게 하는 역할을 한다.
@Controller
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
	
	/*@RequestMapping(value="/join", method=RequestMethod.POST) // 이건 post방식
	public String join( @RequestParam("id")String id, 
						@RequestParam("password")String password,
						@RequestParam("name")String name, 
						@RequestParam("addr")String addr,
						@RequestParam("birth")int birth, 
						@RequestParam("major")String major,
						@RequestParam(value="subject",required=true)List<String> subject, // 얘는 체크박스 값 받아오는 방법이다.
						@RequestParam("cate")int cate) {
		
		MemberDTO param = new MemberDTO();
		param.setId(id);
		param.setPassword(password);
		param.setName(name);
		param.setAddr(addr);
		param.setBirth(birth);
		param.setMajor(major);
		String res = "";
		for (String temp : subject) {
			res += temp + "/"; // 체크박스에서 클릭한 subject 들을 전부 res에 저장, (/)로 과목 나누기
		}
		param.setSubject(res);
		param.setCate(cate);
		
		String view = "";
		
		if (service.insert(param) == 1) {
			logger.info("회원가입 성공!");
			view = "member/login_form.user";
		} else {
			logger.info("회원가입 실패!");
			view = "member/join_form.user";
		}
		return view;
	}*/
	
	
	// member.js에서 JSON.stringfy(member)로 받아온 값을 처리하는 방법이다
	@RequestMapping(value="/join", method=RequestMethod.POST) // 이건 post방식
	public @ResponseBody MemberDTO join(
			@RequestBody MemberDTO param,
			Model model	) {
		logger.info("== 회원가입 성공 체크 ===");
		member.setId(param.getId());
		logger.info("id체크 {}", param.getId());
		member.setPassword(param.getPassword());
		member.setName(param.getName());
		member.setAddr(param.getAddr());
		member.setBirth(param.getBirth());
		member.setMajor(param.getMajor());
		/*String res = "";
		for (String temp : subject) {
			res += temp + "/"; // 체크박스에서 클릭한 subject 들을 전부 res에 저장, (/)로 과목 나누기
		}
		param.setSubject(res);*/
		member.setCate(param.getCate());
		
		service.insert(member);
		
		return member;
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
		member.setRole(User.valueOf(member.getCate())); // valueOf 메소드와 cate 값을 이용해서 member 객체의 role에 값 저장
		String view = "";
		
		if (member.getId() != null) {
			logger.info("로그인 성공");
			session.setAttribute("user", member); // 로그인 성공 시 session에 로그인에 성공한 유저의 정보가 담긴 member 객체를 담는다.
			model.addAttribute("member", member); // 로그인 성공 시 다음 페이지에 request와 같은 역할을 하는 model에 member 객체를 담아 보낸다.
			view = "redirect:/member/profile/"+ id; // 
		} else {
			logger.info("로그인 실패");
			view = "member/login_form.user";
		}
		
		return view;
	}
	
	@RequestMapping("/profile/{id}")
	public String getMemberProfile(@PathVariable("id")String id,
									Model model){
		logger.info("=== getMemberProfile() 진입 ===");
		if (service.isMember(id)) {
			member = service.getById(id);
			member.setRole(User.valueOf(member.getCate()));
			model.addAttribute("member",member);
		} else {
			model.addAttribute("member","");
		}
		return "member/profile.user";
	}	
	
	@RequestMapping("/update_form") // member.updateForm() 호출 시, $.getJson()에 의해 이곳으로 오게 된다.
	public @ResponseBody MemberDTO update_form(Model model,HttpSession session) {
		logger.info("=== update_form() 진입 ===");
		MemberDTO member = (MemberDTO) session.getAttribute("user");
		//model.addAttribute("member", session.getAttribute("user"));
		return member;
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public @ResponseBody MemberDTO update(
			@RequestParam(value="password",required=false)String password,
			@RequestParam(value="addr",required=false)String addr,
			@RequestParam(value="profile_img",required=false)MultipartFile profile_img,
			HttpSession session,
			Model model){
		logger.info("수정폼에서 넘어온 주소 = {}",addr);
		logger.info("수정폼에서 넘어온 비밀번호 = {}",password);
		
		MemberDTO legacy = (MemberDTO) session.getAttribute("user");
		MemberDTO param = (MemberDTO) session.getAttribute("user");
		FileUpload fileUpload = new FileUpload();
		String fileName = profile_img.getOriginalFilename();
		logger.info("수정폼에서 넘어온 파일 = {}",fileName);
		String fullPath = fileUpload.uploadFile(profile_img, 
				Constants.IMAGE_DOMAIN, fileName );
		logger.info("이미지 저장 경로 : {}",fullPath);
		param.setProfileImg(fileName);
		param.setPassword(password);	
		param.setAddr(addr);
		int result = service.update(param);
		String view = "";
		if (result == 1) {
			session.setAttribute("user", param);
			model.addAttribute("member",param);
			view = "member/detail";
		} else {
			model.addAttribute("member",legacy);
			view = "member/update_form";
		}
		logger.info("수정 후 비번 : {}",param.getProfileImg());
		return param;
	}
	
	/*//@RequestMapping(value="/update", method=RequestMethod.POST)
	//@RequestMapping("/update")
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public @ResponseBody MemberDTO update( // 호출한 ajax()에 리턴 값으로 MemberDTO 자체를 넘겨준다, (@ResponseBody를 쓰면 model에 add()해서 주지 않고 바로 객체를 리턴 시킬 수 있다.)
			@RequestParam("profile_img")String profileImg,
			@RequestParam("id")String id,
			@RequestParam("password")String password,
			@RequestParam("name")String name,
			@RequestParam("addr")String addr,
			@RequestParam("birth")int birth,
			@RequestParam("role")String role,
			HttpSession session,
			Model model){
		logger.info("=== update() 진입 ===");
		
		MemberDTO param = new MemberDTO();
		param.setProfileImg(profileImg);
		param.setId(id);
		param.setPassword(password);
		param.setName(name);
		param.setAddr(addr);
		param.setBirth(birth);
		param.setRole(role);
		
		service.update(param);
		logger.info("=== update() 디비 다녀오기 성공 ===");
		session.setAttribute("user", param); // 세션에 업데이트 된 프로필 내용 다시 저장
		model.addAttribute("member",param);

		return param;
	}*/
	
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		logger.info("=== member - logout() ===");
		session.setAttribute("user", null);
		session.invalidate();
		return "global/main.user"; // 메인으로 돌아가깃!
	}
	
	@RequestMapping("/member_list") // 모든 학생 정보를 가져옴
	public @ResponseBody List<MemberDTO> member_list(Model model) {
		logger.info("member_list 진입 ");
		return service.getListAll();
	}

	
	@RequestMapping("/name/{name}") // 이름 검색으로 회원 정보들을 가져옴(중복이름가능!)
	public String getMembersByName(@PathVariable("name")String name) {
		MemberDTO param = new MemberDTO();
		param.setName(name);
		List<MemberDTO> list = service.getByName(param);
		return "member/member_list";
	}
	
	@RequestMapping("/delete") 
	public String delete(HttpSession session,
						 SessionStatus status) {
		logger.info("=== member - delete() ===");
		
		MemberDTO param = (MemberDTO) session.getAttribute("user"); // 세션 객체에 user로 저장되어 있는 MemberDTO 객체를 가져온다. 
		int res = service.delete(param); // serviceImpl에 remove메소드 호출~
		
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
