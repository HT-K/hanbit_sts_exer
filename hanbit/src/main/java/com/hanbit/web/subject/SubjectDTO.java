package com.hanbit.web.subject;

import org.springframework.stereotype.Component;

@Component
public class SubjectDTO {
	private int sunjSeq;
	private String subName;
	
	public int getSunjSeq() {
		return sunjSeq;
	}
	public void setSunjSeq(int sunjSeq) {
		this.sunjSeq = sunjSeq;
	}
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}
}
