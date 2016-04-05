package com.hanbit.web.member;

import java.util.List;

public interface MemberService {
	//인터페이스는 추상메소드만 와야한다는 규칙이 있어서 abstract를 생략가능하다
	//그러나 추상클래스는 구상메소드 즉 {}이 포함된 메소드 존재가 가능하므로 둘을 구분하기 위해서 반드시 abstract를 붙여야한다.
	public MemberDTO login(String id, String password); // 회원로그인
	public MemberDTO detail(String id); // 회원 상세정보
	public int join(MemberDTO member); // 회원가입
	public int update(MemberDTO member); // 회원 정보 업데이트
	public int remove(String id); // 회원탈퇴
	public boolean isMember(String id); //
	public List<MemberDTO> getMemList();
}
