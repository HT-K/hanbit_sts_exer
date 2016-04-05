package com.hanbit.web.admin;

import com.hanbit.web.member.MemberDTO;

public class AdminDTO extends MemberDTO{
	private String role;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
