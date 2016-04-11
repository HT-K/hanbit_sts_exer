package com.hanbit.web.member;

import org.springframework.stereotype.Component;

@Component
public class MemberDTO {
	private String id, password, name, addr, role;

	private int birth,cate;
	
	public MemberDTO() {}
	
	public MemberDTO(String id, String password, String name, String addr, int birth, int cate, String role) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.addr = addr;
		this.birth = birth;
		this.cate = cate;
		this.role = role;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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

	public int getCate() {
		return cate;
	}

	public void setCate(int cate) {
		this.cate = cate;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "회원정보 [아이디=" + id + ", 비밀번호=" + password + ", 이름=" + name + ", 주소=" + addr + ", 생년월일="
				+ birth + "]";
	}
}
