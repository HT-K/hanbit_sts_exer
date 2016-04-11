package com.hanbit.web.global;

public enum UserByTaeHyun {
	// 다른 클래스에서 User.valueOf(); 이런 식으로 호출하게 되면 자동으로 이 생성자들이 생성되게 된다.
	NON(0, "비회원"), STU(1, "학생"), TEA(2, "교수"), ADM(3,"관리자"); 
	
	private final int value;
	private final String role;


	UserByTaeHyun(int value, String role) {
		this.value = value;
		this.role = role;
	}
	
	public int getValue() {
		return value;
	}
	
	public String getRole() {
		return role;
	}
	
	public static UserByTaeHyun valueOf(int value) {
		switch (value) {
			case 0: return NON;
			case 1: return STU;
			case 2: return TEA;
			case 3: return ADM;
			default: throw new AssertionError("알 수 없는 값 : " + value);
		}
	}
}
