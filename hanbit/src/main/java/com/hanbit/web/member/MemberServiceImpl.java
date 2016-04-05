package com.hanbit.web.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class MemberServiceImpl implements MemberService {
	private static MemberService instance = new MemberServiceImpl(); // 싱글톤 패턴으로 객체를 사용하기 위함.	
	
	public static MemberService getInstance() {
		return instance;
	}

	@Override
	public MemberDTO login(String id, String password) {
		// 로그인
		return null; // 해당 id와 password를 가진 사용자의 모든 정보를 가져와서 bean 객체에 넣는다.
	}
		
	@Override
	public int join(MemberDTO member) {
		// 회원가입
		return 0; // 입력받은 회원양식의 값들을 MemberBean 객체인 member에 set 한 후 이곳으로 가져와서 다시 dao에 넘긴다.
	}
	
	@Override
	public MemberDTO detail(String id) {
		// 내 정보보기
		return null; // MemberDAOImpl 클래스에 구현한 selectMember 메소드를 호출하여 데이터베이스에서 MemberBean 객체에 내용을 넣어서 받아온다.
	}

	@Override
	public int update(MemberDTO member) {
		// 수정
		return 0;
	}

	@Override
	public int remove(String id) {
		// 삭제
		return 0;
	}

	@Override
	public boolean isMember(String id) {
		// 회원인지 아닌지 검사
		return false;
	}

	@Override
	public List<MemberDTO> getMemList() {
		// 모든 회원 리스트
		return null;
	}
}
