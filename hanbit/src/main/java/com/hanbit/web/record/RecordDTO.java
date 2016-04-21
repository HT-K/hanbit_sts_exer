package com.hanbit.web.record;

import org.springframework.stereotype.Component;

@Component
public class RecordDTO{
	private int recordSeq;
	private String id;
	private String name;
	private String subject;
	private int score;
	private String examDate;
	private String profId;
	private String profName;

	public int getRecordSeq() {
		return recordSeq;
	}
	public void setRecordSeq(int recordSeq) {
		this.recordSeq = recordSeq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
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
	public String getProfId() {
		return profId;
	}
	public void setProfId(String profId) {
		this.profId = profId;
	}
	public String getProfName() {
		return profName;
	}
	public void setProfName(String profName) {
		this.profName = profName;
	}
}
