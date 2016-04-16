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
	@Autowired ReplyDTO reply;
	@Autowired ArticleService service;
	@Autowired Command command;
	
	@RequestMapping("/article_home")
	public String list(@RequestParam(value="pageNo",defaultValue="1")String pageNo,
					   @RequestParam(value="keyField",defaultValue ="none")String keyField,
					   @RequestParam(value="keyword",defaultValue ="none")String keyword,
					   Model model){		
		logger.info("pageNo 체크 {}", pageNo);
		logger.info("keyField 체크 {}", keyField);

		logger.info("현재 페이지 = {}", command.getPageNo());
		logger.info("현재 startPage = {}", command.getStartPage());
		logger.info("현재 endPage = {}", command.getPageNo());
		logger.info("현재 startRow = {}", command.getStartRow());
		logger.info("현재 endRow = {}", command.getEndRow());

		//keyField 값에 따라 모델로 보내야할 것이 나눠진다.
		if (keyField.equals("none")) {
			// 모든 게시글 수를 데이터베이스에서 구해서 command객체에 set해줌 (service.countAll()) 
			command = CommandFactory.createCommand("article", "list", pageNo, keyField, keyword, service.countAll());
			model.addAttribute("article", service.getList(command));
		} else {
			// keyword의 내용을 포함하는 게시물의 수를 데이터베이스에서 구해서 command 객체에 set해줌
			command.setKeyField(keyField);
			command.setKeyword(keyword);
			int totalArticle = service.countBySearch(command);
			command = CommandFactory.createCommand("article", "list", pageNo, keyField, keyword, totalArticle);
			model.addAttribute("article", service.getBySearch(command));
		}
		model.addAttribute("command", command);
		return "article/article_home";
	}
	
	@RequestMapping("/writeForm")
	public String writeForm() {
		return "article/article_write";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(@RequestParam("title")String title, 
						@RequestParam("writerName")String writerName,
						@RequestParam("password")String password,
						@RequestParam("content")String content,
						Model model) {
		
		ArticleDTO param = new ArticleDTO();
		
		param.setTitle(title);
		param.setWriterName(writerName);
		param.setPassword(password);
		param.setContent(content);
		
		service.insert(param);
		logger.info("인서트 확인");
		return "redirect:/article/list"; // 글 등록이 성공하면 다시 controller에 /article -> /list 로 호출되는 메소드를 호출한다.
	}
	
	@RequestMapping("/search/{articleId}")
	public void findById( // ajax를 쓰기 때문에 return 값에 굳이 이동할 페이지가 없어도 된다 (해당 페이지에서 어느 부분을 지우고 그 부분에 원하는 결과를 띄우는게 ajax이기 때문!)
			@PathVariable("articleId")int articleId,
			Model model) {
		logger.info("findById() 진입 체크");
		model.addAttribute("article",service.getById(articleId));
	}
	
	@RequestMapping("/count")
	public String count() {
		return "";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public void update(
			@RequestParam("articleId")int articleId,
			@RequestParam("title")String title, 
			@RequestParam("writerName")String writerName,
			@RequestParam("password")String password,
			@RequestParam("content")String content,
			Model model) {
		logger.info("=== update() 진입 체크 ===");
		article.setArticleId(articleId);
		article.setTitle(title);
		article.setPassword(password);
		article.setWriterName(writerName);
		article.setContent(content);
		
		int result = service.update(article);
		if (result == 1) {
			logger.info("=== update 성공 ===");
			model.addAttribute("id", articleId);
		} else {
			logger.info("=== update 실패 ===");
		}
	}
	
	@RequestMapping("/delete")
	public String delete(
			@RequestParam("articleId")int articleId,
			Model model) {
		int result = service.delete(articleId);
		if (result == 1) {
			model.addAttribute("message", "삭제성공!");
		} else {
			model.addAttribute("message", "삭제실패!");
		}
		return "";
	}
	
	@RequestMapping("/reply") // ajax로 이 URL을 호출해서 리턴 페이지가 필요없다!
	public void reply( 
			@RequestParam("articleId")int articleId,
			@RequestParam("writerName")String writerName,
			@RequestParam("reply_content")String reply_content,
			Model model) {
		reply.setArticleId(articleId);
		reply.setWriterName(writerName);
		reply.setReply_content(reply_content);
		
		int res = service.replyInsert(reply);
				
		if (res == 1) {
			logger.info("=== replyInsert 성공 ===");
			model.addAttribute("reply", service.getReply(reply)); // JSON 형태로 $.ajax()의 success에 값이 보내진다.
		} else {
			logger.info("=== replyInsert 실패 ===");
		}
	}
}
