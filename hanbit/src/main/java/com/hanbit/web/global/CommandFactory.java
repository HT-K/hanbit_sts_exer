package com.hanbit.web.global;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommandFactory { // Factory Pattern , new라는 생성자를 쓰는 것을 감춰라, 팩토리 패턴에서 Factory는 객체를 만드는 공장이다
	public static Command getCommand(HttpServletRequest request, HttpServletResponse response) { // 공장은 어느 곳에 있는 사람들이나 공장에서 만든 것을 쓸 수 있어야 하므로 static으로 만들어야한다.
		String path = request.getServletPath(); // /member/login_form.do ==> 이것을 받아온다.
		String[] tmp = path.split("/"); // /member/login_form.do을 "/"로 구분해서 문자열들을 저장

		// tmp[0]에는 null이 들어간다.
		String directory = tmp[1]; // == path.split("/")[1]; // member 를 저장
		String action = tmp[2].substring(0, tmp[2].indexOf(".")); // login_form 을 저장

		System.out.println("디렉토리 :" + directory);
		System.out.println("액션 :" + action);
		
		return new Command(directory, action); // 이곳에서 Command 객체를 생성한 후 return 시킨다. (팩토리 패턴의 핵심)
	}
}
