package com.hanbit.web.subject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/subject")
public class SubjectController {
	private static final Logger logger = LoggerFactory.getLogger(SubjectController.class);
	@Autowired SubjectDTO subject; // 이 MemberController에 MemberDTO 객체를 가져와 달라는 뜻이다. (싱글톤)
	@Autowired SubjectService service; 
	
	@RequestMapping("list") // 아무것도 쓰지 않는 즉, 디폴트는 get방식 호출이다.
	public String getList(
			Model model) {
		logger.info("=== getList() 진입 ===");
		model.addAttribute("list", service.getList());
		return "admin/subject_list.admin";
	}
}