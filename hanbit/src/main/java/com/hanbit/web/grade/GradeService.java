package com.hanbit.web.grade;

import java.util.ArrayList;
import java.util.List;

/**
 * CRUD 인터페이스를 만들 때 이 기준으로 만든다고 생각하면 된다.
 * C : create 생성
 * R : read 조회
 * U : update 수정
 * D : delete 삭제
 * 
 * */
public interface GradeService {
	// C 성적표 등록 
	public int insert(GradeDTO grade); // 추상 메소드
	// R 성적표 리스트 출력
	public List<GradeDTO> getListAll();
	// R 성적표 조회(이름)
	public List<GradeDTO> getByName(String name);
	// R 성적표 조회(아이디)
	public GradeDTO getById(String id);
	// R 성적 테이블 카운트 조회
	public int count();
	// U 성적표 수정
	public int update(GradeDTO grade);
	// D 성적표 삭제
	public int delete(GradeDTO grade);
}