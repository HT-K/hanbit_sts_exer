package com.hanbit.web.member;

import java.util.List;

// service interface에는 아무런 어노테이션을 주지 않는다.
public interface MemberService {
	//인터페이스는 추상메소드만 와야한다는 규칙이 있어서 abstract를 생략가능하다
	//그러나 추상클래스는 구상메소드 즉 {}이 포함된 메소드 존재가 가능하므로 둘을 구분하기 위해서 반드시 abstract를 붙여야한다.
	public List<MemberDTO> getMemList();
	public MemberDTO login(MemberDTO member); // 회원로그인
	public MemberDTO getMemById(String id); // 아이디로 회원 검색
	public List<MemberDTO> getMemsByName(MemberDTO member); // 이름으로 회원 검색 (중복가능)
	public boolean isMember(String id); // 회원인지 아닌지 검사	
	public int count();
	public int join(MemberDTO member); // 회원가입
	public int update(MemberDTO member); // 회원 정보 업데이트
	public int remove(MemberDTO member); // 회원탈퇴
}
