package com.hanbit.web.grade;

import org.springframework.stereotype.Component;

@Component
public class MemberGradeDTO {
	private String id;
	private int score_seq,java,sql,jsp,spring;
	private String password, name, addr;
	private int birth;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public int getScore_seq() {
		return score_seq;
	}
	public void setScore_seq(int score_seq) {
		this.score_seq = score_seq;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getBirth() {
		return birth;
	}
	public void setBirth(int birth) {
		this.birth = birth;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "개인정보 [학번=" + score_seq + ", 이름=" + name + ", 아이디=" + id + ", 비밀번호=" + password + ", 생년월일=" + birth + ", 주소=" + addr + ", 자바=" + java + ", SQL=" + sql + ", JSP=" + jsp
				+ ", 스프링=" + spring + "]" + "\n";
	}
}
