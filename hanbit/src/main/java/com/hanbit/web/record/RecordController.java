package com.hanbit.web.record;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hanbit.web.global.Command;
import com.hanbit.web.global.CommandFactory;


@Controller
@RequestMapping("/record")
public class RecordController {
	private static final Logger logger = LoggerFactory.getLogger(RecordController.class);
	@Autowired RecordDTO record; // 이 MemberController에 MemberDTO 객체를 가져와 달라는 뜻이다. (싱글톤)
	@Autowired RecordService recordService; 
	@Autowired Command command;
	
	@RequestMapping("/record_list")
	public String record_list(@RequestParam(value="pageNo",defaultValue="1")String pageNo,
			   @RequestParam(value="keyField",defaultValue ="none")String keyField,
			   @RequestParam(value="keyword",defaultValue ="none")String keyword,
			   Model model){		
		logger.info("pageNo 체크 {}", pageNo);
		logger.info("keyField 체크 {}", keyField);
		
		command = CommandFactory.createCommand("record", "record_list", pageNo, keyField, keyword, recordService.count());
		
		logger.info("총 레코드 수 = {}", command.getTotalArticle());
		logger.info("현재 페이지 = {}", command.getPageNo());
		logger.info("현재 startPage = {}", command.getStartPage());
		logger.info("현재 endPage = {}", command.getEndPage());
		logger.info("현재 startRow = {}", command.getStartRow());
		logger.info("현재 endRow = {}", command.getEndRow());
		logger.info("현재 totalPages = {}", command.getTotalPages());
			
		model.addAttribute("record", recordService.getListAll(command));
		model.addAttribute("command", command);
		
		return "record/record_list.admin";
	}
}
