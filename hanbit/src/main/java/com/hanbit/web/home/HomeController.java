package com.hanbit.web.home;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.SessionScope;

import com.hanbit.web.member.MemberDTO;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes("user") // 세션 생성
public class HomeController {
	
	//syso과 같은 역할, 디버깅을 위한 용도
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired MemberDTO member;
	
	// 맨 처음 프로젝트를 실행하면 이곳으로 들어온다 ("/" 의 영향때문!)
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpSession session) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		//model.addAttribute("user", member); // 위에 방법도 세션에 객체를 담는거고 이 방법도 세션에 객체를 담는 거다~
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "global/main.user";
	}
}
