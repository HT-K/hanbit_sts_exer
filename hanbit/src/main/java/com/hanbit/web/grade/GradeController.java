package com.hanbit.web.grade;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hanbit.web.member.MemberController;
import com.hanbit.web.member.MemberDTO;
import com.hanbit.web.member.MemberService;

@Controller
@RequestMapping("/grade")
public class GradeController {
	private static final Logger logger = LoggerFactory.getLogger(GradeController.class);
	@Autowired GradeService service;
	@Autowired MemberService mService;
	@Autowired MemberDTO member;
	
	//관리자 페이지 성적 입력 창에서 입력 버튼을 눌렀을 시 호출되는 메소드
	@RequestMapping(value="/insert", method=RequestMethod.POST) // 관리자 페이지 학생 성적 출력에서 이름을 클릭했을 시 호출되는 메소드
	public String insert(@RequestParam("id")String id, 
						 @RequestParam("name")String name,
						 @RequestParam("subj_seq")int subj_seq, 
						 @RequestParam("score")int score,
						 Model model) {
		logger.info("GradeController - insert() 진입");
		GradeDTO param = new GradeDTO(id, subj_seq, score);
		String view = "";
		
		if (service.insert(param) == 1) {
			logger.info("성적 삽입 성공");
			view =  "admin/admin_form";
		} else {
			logger.info("성적 삽입 실패");
			view =  "redirect:/grade/add/"+id; // 성적 삽입 실패시 id 값을 가지고 다시 add() 메소드 호출!
		}
		return view;
	}
	
	// 관리자 페이지에서 모든 학생의 성적을 출력해주는 메소드 (뷰로 만들어진 테이블의 모든 것을 가져온다)
	@RequestMapping("/graList") 
	public String graList(Model model) {
		logger.info("GradeController - graList() 진입");
		List<GradeDTO> list = new ArrayList<GradeDTO>();
		list = service.getList();
		model.addAttribute("grade", list);
		return "grade/grade_list";
	}
	
	// 관리자 페이지 학생 리스트에서 아이디를 클릭했을 시 호출되는 메소드
	@RequestMapping("/add/{id}") 
	public String add(@PathVariable("id")String id,
					  Model model) {
		logger.info("GradeController - add() 진입");
		logger.info("파라미터 id 값 체크 = {}", id);
		member = mService.getMemById(id);
		model.addAttribute("member", member);
		return "grade/grade_add";
	}
	
	// 모든 학생 성적 출력 창에서 한 학생의 아이디를 클릭했을 시 해당 row의 값을 수정하기 위한 페이지로 넘어감.
	@RequestMapping("/update/{id}")
	public String update(@PathVariable("id")String id,
						 Model model) {
		logger.info("GradeController - update1() 진입");
		logger.info("id 값 체크 = {}", id);
		
		MemberDTO param = new MemberDTO();
		param = mService.getMemById(id);
		model.addAttribute("member", param);
		return "grade/grade_update"; // grade_update.jsp 페이지에 id파라미터 값으로 가지고 온 학생 정보를 가지고 넘어간다.
	}
	
	// 한 학생의 성적 수정 페이지에서 수정(완료)버튼을 클릭했을 시 호출되는 메소드
	@RequestMapping(value="/update", method=RequestMethod.POST) 
	public String update(@RequestParam("id")String id, @RequestParam("name")String name,
			 			 @RequestParam("subj_seq")int subj_seq, @RequestParam("score")int score,
						 Model model) {
		logger.info("GradeController - update2() 진입");
		GradeDTO param = new GradeDTO(id, subj_seq, score);
		String view = "";
		
		if (service.update(param) == 1) {
			logger.info("성적 수정 성공");
			view =  "admin/admin_form";
		} else {
			logger.info("성적 수정 실패");
			view =  "redirect:/grade/update/"+id; // 성적 삽입 실패시 id 값을 가지고 다시 update() 메소드 호출!
		}
		return view;
	}
}
