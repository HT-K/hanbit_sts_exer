package com.hanbit.web.board;

import org.springframework.stereotype.Component;

import com.hanbit.web.member.MemberDTO;
@Component
public class BoardDTO{
	private String role;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
