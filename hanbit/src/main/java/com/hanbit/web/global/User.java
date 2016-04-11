package com.hanbit.web.global;

public enum User {
	// 다른 클래스에서 User.valueOf(); 이런 식으로 호출하게 되면 자동으로 이 생성자들이 생성되게 된다.
	// 데이터베이스에서 숫자 값을 가지고 오면 (예를 들어 cate 컬럼에서 3값을 체크한다고 치자) 이 enum의 valueof 메소드를 호출하여 해당 숫자가 어떤 등급인지 체크하는 역할을 하게 된다!
	비회원(0), 학생(1), 교수(2), 관리자(3);
	
	private final int value;

	User(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	
	public static User valueOf(int value) {
		switch (value) {
			case 0: return 비회원;
			case 1: return 학생;
			case 2: return 교수;
			case 3: return 관리자;
			default: throw new AssertionError("알 수 없는 값 : " + value);
		}
	}
}
