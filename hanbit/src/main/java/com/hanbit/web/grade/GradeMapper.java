package com.hanbit.web.grade;

import java.util.ArrayList;
import java.util.List;

public interface GradeMapper {
		// C 성적표 등록 
		public void insert(GradeDTO gradeBean); // 추상 메소드
		// R 성적표 리스트 출력
		public List<GradeDTO> selectAll();
		// R 성적표 조회(학번)
		public MemberGradeDTO selectGradeByHak(int hak);
		// R 성적표 조회(이름)
		public ArrayList<MemberGradeDTO> selectGradesByName(String name);
		// R 성적표 조회(아이디)
		public GradeDTO selectGradesById(String id);
		// R 카운트 조회
		public int count();
		// U 성적표 수정
		public String update(GradeDTO grade);
		// D 성적표 삭제
		public String delete(int hak);
	
}
