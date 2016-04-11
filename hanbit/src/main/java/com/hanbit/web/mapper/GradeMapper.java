package com.hanbit.web.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hanbit.web.grade.GradeDTO;

@Repository
public interface GradeMapper {
		// C 성적표 등록 
		public int insert(GradeDTO grade); // 추상 메소드
		// R 성적표 리스트 출력
		public List<GradeDTO> selectList();
		// R 성적표 조회(이름)
		public List<GradeDTO> selectByName(String name);
		// R 성적표 조회(아이디)
		public GradeDTO selectById(String id);
		// R 카운트 조회
		public int count();
		// U 성적표 수정
		public int update(GradeDTO grade);
		// D 성적표 삭제
		public int delete(GradeDTO grade);
	
}
