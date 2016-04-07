package com.hanbit.web.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.hanbit.web.member.MemberDTO;

@Repository
public interface MemberMapper { // void 타입이 존재하지 않는다. 
	public List<MemberDTO> selectList(); // 모든 학생을 리스트에 담아야한다. (관리자 페이지에 보여주기 위함)
	public MemberDTO login(MemberDTO member); // 로그인 체크
	public MemberDTO selectById(MemberDTO member); // 회원 상세 정보 출력을 위함 (id 이용)
	public boolean isMember(MemberDTO member); //회원인지 아닌지 검사
	public int insert(MemberDTO member); // 회원가입 시 내용 데이터베이스에 저장
	public int update(MemberDTO member); // 업데이트로 내용 변경 시 데이터베이스 내용도 변경
	public int delete(MemberDTO member); // 회원 탈퇴
}
