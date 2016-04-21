package com.hanbit.web.grade;

import org.springframework.stereotype.Component;

import com.hanbit.web.util.ExamDate;

@Component
public class GradeDTO {
	private int scoreSeq;
	private String id;
	private int subjSeq;
	private int score;
	private String examDate;

	public GradeDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public GradeDTO(String id, int subjSeq, int score, String examDate) { // 기본 생성자를 만들어줘야 오류가 생기지 않는다... 왜지??
		this.id = id;
		this.subjSeq = subjSeq;
		this.score = score;
		this.examDate = examDate; // util 패키지의 ExamDate 클래스에 있는 getDate() 메소드를 이용해서 현재 달의 말일을 구해온다.
	}

	public int getScoreSeq() {
		return scoreSeq;
	}

	public void setScoreSeq(int scoreSeq) {
		this.scoreSeq = scoreSeq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getSubjSeq() {
		return subjSeq;
	}

	public void setSubjSeq(int subjSeq) {
		this.subjSeq = subjSeq;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getExamDate() {
		return examDate;
	}

	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}
	
	
} 