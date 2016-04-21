package com.hanbit.web.member;

import java.util.List;

// service interface에는 아무런 어노테이션을 주지 않는다.
//인터페이스는 추상메소드만 와야한다는 규칙이 있어서 abstract를 생략가능하다
//그러나 추상클래스는 구상메소드 즉 {}이 포함된 메소드 존재가 가능하므로 둘을 구분하기 위해서 반드시 abstract를 붙여야한다.
public interface MemberService {
	// C 회원 가입(등록)
	public int insert(MemberDTO member); 
	// R 모든 회원 리스트 검색
	public List<MemberDTO> getListAll();
	// R 이름으로 회원 정보 검색 (중복된 이름 허용)
	public List<MemberDTO> getByName(MemberDTO member); 
	// R 로그인 한 회원 정보 검색
	public MemberDTO login(MemberDTO member); 
	// R 아이디로 회원 정보 검색
	public MemberDTO getById(String id); 
	// R 회원인지 아닌지 검사
	public boolean isMember(String id);
	// R 회원 수 카운트
	public int count();
	// U 회원 정보 업데이트
	public int update(MemberDTO member);
	// D 회원 정보 삭제
	public int delete(MemberDTO member);
}
