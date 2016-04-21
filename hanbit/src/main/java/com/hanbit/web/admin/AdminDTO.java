package com.hanbit.web.admin;

import org.springframework.stereotype.Component;

@Component
public class AdminDTO{
	private String id;
	private String password;
	private String name;
	private String addr;
	private int birth;
	private int cate;
	
	// Admin 테이블에는 없는 컬럼들이다.
	// subjName는 Subject 테이블의 id와 비교해서 같은 값에 해당하는 과목명을 받아와서 set하고
	// role은 cate와 util패키지에 있는 User(Enum)의 ValueOf() 메소드를 이용해서 set한다.
	private String subjName;
	private String role;
	
	public AdminDTO() {
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
	public int getCate() {
		return cate;
	}
	public void setCate(int cate) {
		this.cate = cate;
	}
	public String getSubjName() {
		return subjName;
	}
	public void setSubjName(String subjName) {
		this.subjName = subjName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
