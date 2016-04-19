package com.hanbit.web.grade;

import org.springframework.stereotype.Component;

import com.hanbit.web.util.ExamDate;

@Component
public class GradeDTO {
	private int score_seq;
	private String id;
	private int subj_seq;
	private int score;
	private String examDate;

	public GradeDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public GradeDTO(String id, int subj_seq, int score) { // 기본 생성자를 만들어줘야 오류가 생기지 않는다... 왜지??
		this.id = id;
		this.subj_seq = subj_seq;
		this.score = score;
		this.examDate = ExamDate.getDate(); // util 패키지의 ExamDate 클래스에 있는 getDate() 메소드를 이용해서 현재 달의 말일을 구해온다.
	}
	
	public int getScore_seq() {
		return score_seq;
	}

	public void setScore_seq(int score_seq) {
		this.score_seq = score_seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getSubj_seq() {
		return subj_seq;
	}

	public void setSubj_seq(int subj_seq) {
		this.subj_seq = subj_seq;
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