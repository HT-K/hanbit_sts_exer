package com.hanbit.web.board;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hanbit.web.admin.AdminController;

@Controller
@RequestMapping("/article")
public class ArticleController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	@Autowired ArticleDTO article;
	@Autowired ArticleService service;
	
	@RequestMapping("/write")
	public String write() {
		return "";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(Model model) {
		return "";
	}
	
	//${context}/article/list URL로 호출되는 메소드다.
	@RequestMapping("/list")
	public String list() {
		return "board/list";
	}
	
	@RequestMapping("/name")
	public String findByName() {
		return "";
	}
	
	@RequestMapping("/id")
	public String findById() {
		return "";
	}
	
	@RequestMapping("/count")
	public String count() {
		return "";
	}
	
	@RequestMapping("/update")
	public String update() {
		return "";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(Model model) {
		return "";
	}
	
	@RequestMapping("/delete")
	public String delete() {
		return "";
	}

}
