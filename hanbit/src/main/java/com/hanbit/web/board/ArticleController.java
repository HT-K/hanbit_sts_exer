package com.hanbit.web.board;

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

import com.hanbit.web.admin.AdminController;
import com.hanbit.web.global.Command;
import com.hanbit.web.global.CommandFactory;

@Controller
@RequestMapping("/article")
public class ArticleController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	@Autowired ArticleDTO article;
	@Autowired ArticleService service;
	@Autowired Command command;
	
	@RequestMapping("/list/{pageNo}/{keyField}/{keyword}") // get방식으로 ${context}/article/list/${pageNo}/${keyField}/${keyworkd} URL로 호출되는 메소드다.
	public String list(@PathVariable("pageNo")String pageNo,
					   @PathVariable("keyField")String keyField,
					   @PathVariable("keyword")String keyword,
					   Model model) {
		// 모든 게시글 수를 데이터베이스에서 구해서 command객체에 set해줌 (service.count()) 
		command = CommandFactory.createCommand("article", "list", pageNo, keyField, keyword, service.count());

		logger.info("현재 페이지 = {}", command.getPageNo());
		logger.info("현재 startPage = {}", command.getStartPage());
		logger.info("현재 endPage = {}", command.getPageNo());
		logger.info("현재 startRow = {}", command.getStartRow());
		logger.info("현재 endRow = {}", command.getEndRow());

		// 데이터베이스에서 모든 게시글을 가져오는게 아니라 해당 페이지에 보여줄 만큼만 게시글을 리스트로 뽑아오기 위해 command를 파라미터로 보낸다!
		List<ArticleDTO> list = service.getList(command); 
		//ArticleDTO param = service.getById("123");
		logger.info("리스트 체크 = {}", list.size());
		model.addAttribute("article", list);
		model.addAttribute("command", command);
		return "board/list";
	}
	
	//${context}/article/write URL로 호출되는 메소드다.
	@RequestMapping("/write")
	public String write() {
		return "board/writeForm";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(@RequestParam("title")String title, 
						@RequestParam("writerName")String writerName,
						@RequestParam("password")String password, 
						Model model) {
		
		ArticleDTO param = new ArticleDTO();
		param.setTitle(title);
		param.setWriterName(writerName);
		param.setPassword(password);
		
		service.insert(param);
		
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
