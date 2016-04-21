package com.hanbit.web.member;

import org.springframework.stereotype.Component;

@Component
public class MemberDTO {
	private String id; 
	private String password; 
	private String name; 
	private String addr;
	private int birth;
	private String major;
	private String subject;
	private String profileImg;
	private int cate;
	
	private String role; // 디비에서 가져오는 것이 아님, 디비에서 cate 값을 가져오면 util의 User(Enum)에 있는 valueOf 메소드를 이용해 해당 회원의 role을 지정하게 된다.
	
	public MemberDTO() {
		// 기본 생성자만 있으면 된다~
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

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getProfileImg() {
		return profileImg;
	}

	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
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
