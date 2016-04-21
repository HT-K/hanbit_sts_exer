package com.hanbit.web.subject;

import java.util.List;

public interface SubjectService {
	// C 과목 생성
	public int insert(SubjectDTO subject);
	// R 모든 과목 리스트 검색
	public List<SubjectDTO> getListAll();
	public List<SubjectDTO> getByName(String name);
	public SubjectDTO getById(String id);
	// R 과목 개수 조회
	public int getCount();
	// U 과목 업데이트
	public int update(SubjectDTO subject);
	// D 과목 삭제
	public int delete(SubjectDTO subject);
}
