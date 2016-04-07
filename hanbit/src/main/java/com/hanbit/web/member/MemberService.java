package com.hanbit.web.member;

import java.util.List;

// service interface에는 아무런 어노테이션을 주지 않는다.
public interface MemberService {
	//인터페이스는 추상메소드만 와야한다는 규칙이 있어서 abstract를 생략가능하다
	//그러나 추상클래스는 구상메소드 즉 {}이 포함된 메소드 존재가 가능하므로 둘을 구분하기 위해서 반드시 abstract를 붙여야한다.
	public List<MemberDTO> getMemList();
	public MemberDTO login(MemberDTO member); // 회원로그인
	public MemberDTO detail(MemberDTO member); // 회원 상세정보
	public boolean isMember(MemberDTO member); //
	public int join(MemberDTO member); // 회원가입
	public int update(MemberDTO member); // 회원 정보 업데이트
	public int remove(MemberDTO member); // 회원탈퇴
}
