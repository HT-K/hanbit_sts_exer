package com.hanbit.web.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hanbit.web.subject.SubjectDTO;

@Repository
public interface SubjectMapper {
	// C 과목 생성
	public int insert(SubjectDTO subject);
	// R 모든 과목 리스트 검색
	public List<SubjectDTO> selectListAll();
	public List<SubjectDTO> selectByName(String name);
	public SubjectDTO selectById(String id);
	// R 과목 개수 조회
	public int count();
	// U 과목 업데이트
	public int update(SubjectDTO subject);
	// D 과목 삭제
	public int delete(SubjectDTO subject);
}
