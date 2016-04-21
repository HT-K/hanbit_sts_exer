package com.hanbit.web.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hanbit.web.subject.SubjectDTO;

@Repository
public interface SubjectMapper {
	public int insert(SubjectDTO subject);
	public List<SubjectDTO> selectList();
	public List<SubjectDTO> selectByName(String name);
	public SubjectDTO selectById(String id);
	public int selectCount();
	public int update(SubjectDTO subject);
	public int delete(SubjectDTO subject);
}
