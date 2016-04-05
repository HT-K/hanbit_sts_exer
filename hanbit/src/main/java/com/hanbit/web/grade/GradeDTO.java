package com.hanbit.web.grade;

public class GradeDTO {
	private String id;
	private int score_seq,java,sql,jsp,spring;
	
	public GradeDTO() {} //디폴트 생성자 , 생성자 오버로딩
	
	public GradeDTO(int score_seq, String id,int java,int sql,int jsp,int spring) {
		this.score_seq = score_seq;
		this.id = id;
		this.java = java;
		this.sql = sql;
		this.jsp = jsp;
		this.spring = spring;
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

	public int getJava() {
		return java;
	}
	public void setJava(int java) {
		this.java = java;
	}
	public int getSql() {
		return sql;
	}
	public void setSql(int sql) {
		this.sql = sql;
	}
	public int getJsp() {
		return jsp;
	}
	public void setJsp(int jsp) {
		this.jsp = jsp;
	}
	public int getSpring() {
		return spring;
	}
	public void setSpring(int spring) {
		this.spring = spring;
	}

	@Override
	public String toString() {
		return "성적표 [시험번호=" + score_seq + ", 아이디=" + id + ", 자바=" + java + ", SQL=" + sql + ", JSP=" + jsp
				+ ", 스프링=" + spring + "]";
	}
} 