package com.hanbit.web.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.smartcardio.Card;

import sun.java2d.pipe.SpanShapeRenderer.Simple;

/**
 *@file : ExamDate.java
 *@author KimHeeTae
 *@date 2016. 4. 18.
 *@story : 해당 학교의 시험일은 항상 그 달의 말일이다.
 * 문제는 2월달이 유동적인 사실이다.
 * 윤년이면 2월29일이고, 아니면 2월28일 말일이다.
 * 해당 연도와 월을 입력하면 말일(시험일)이 자동으로 추출되는 유틸 클래스를 완성하라.
 */
public class ExamDate_By_TaeHyun {
	public static void main(String[] args) {
		ExamDate_By_TaeHyun e = new ExamDate_By_TaeHyun();
		
		System.out.println(e.getEndOfMonth());
	}
	public String getEndOfMonth() {
		// SimpleDateFormat 을 사용하여
		// year와 month를 추출하고
		// 이 값을 사용하여 2000-02-29이 시험일로 등록되는 메소드를 완성하라.
		// 리턴 값은 해당 년도 - 해당 월 - 말일 로 한다
		
		Calendar examDay = Calendar.getInstance();
		int lastday = 0;
		
		switch (examDay.get(Calendar.MONTH)) {
		case Calendar.APRIL: case Calendar.JUNE: case Calendar.SEPTEMBER : case Calendar.NOVEMBER:
			lastday = 30; // 4,6,9,11 월은 말일이 30일
			break;
		case Calendar.FEBRUARY: // 2월일 때
			int year = examDay.get(Calendar.YEAR);
			
			if (year % 4 == 0 && year % 100 != 0) { // 윤년 조건
				lastday = 29; 
			} else if (year % 4 == 0 && year % 100 == 0 && year % 400 == 0) { // 윤년 조건
				lastday = 29;
			} else { // 위에 둘다 아니면 평년
				lastday = 28;
			}
			break;
		default: // 나머지 월은 말일이 31일
			lastday = 31;
		}
		
		examDay.set(Calendar.DATE, lastday); // Calendar 의 DATE 부분만 위에서 구해진 lastDay로 set한다!
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); // 리턴 할 연-월-일 형태의 SimpleDateFormat 설정
		String date = format.format(examDay.getTime()); // SimpleDateFormat을 이용해 String 값으로 변경
		
		return date; // String 으로 된 연-월-일 리턴
	}
}
