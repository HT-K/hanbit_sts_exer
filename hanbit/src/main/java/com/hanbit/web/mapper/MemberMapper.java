package com.hanbit.web.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.hanbit.web.member.MemberDTO;

@Repository
public interface MemberMapper { // void 타입이 존재하지 않는다. 
	// C 회원 가입(등록)
		public int insert(MemberDTO member); 
		// R 모든 회원 리스트 검색
		public List<MemberDTO> selectListAll();
		// R 이름으로 회원 정보 검색 (중복된 이름 허용)
		public List<MemberDTO> selectByName(MemberDTO member); 
		// R 로그인 한 회원 정보 검색
		public MemberDTO login(MemberDTO member); 
		// R 아이디로 회원 정보 검색
		public MemberDTO selectById(String id); 
		// R 회원인지 아닌지 검사
		public boolean isMember(String id);
		// R 회원 수 카운트
		public int count();
		// U 회원 정보 업데이트
		public int update(MemberDTO member);
		// D 회원 정보 삭제
		public int delete(MemberDTO member);
}
