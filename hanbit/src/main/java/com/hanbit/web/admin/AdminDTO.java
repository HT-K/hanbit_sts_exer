package com.hanbit.web.admin;

import org.springframework.stereotype.Component;

@Component
public class AdminDTO{
	private String role;

	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
