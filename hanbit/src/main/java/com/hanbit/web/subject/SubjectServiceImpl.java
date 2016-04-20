package com.hanbit.web.subject;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanbit.web.mapper.SubjectMapper;


@Service
public class SubjectServiceImpl implements SubjectService{
	private static final Logger logger = LoggerFactory.getLogger(SubjectService.class);
	@Autowired SqlSession sqlSession; 
	
	@Override
	public int insert(SubjectDTO subject) {
		logger.info("SubjectService - insert() 진입");
		SubjectMapper mapper = sqlSession.getMapper(SubjectMapper.class);
		return mapper.insert(subject);
	}

	@Override
	public List<SubjectDTO> getList() {
		logger.info("SubjectService - getList() 진입");
		SubjectMapper mapper = sqlSession.getMapper(SubjectMapper.class);
		return mapper.selectList();
	}

	@Override
	public List<SubjectDTO> getByName(String name) {
		logger.info("SubjectService - getByName() 진입");
		SubjectMapper mapper = sqlSession.getMapper(SubjectMapper.class);
		return mapper.selectByName(name);
	}

	@Override
	public SubjectDTO getById(String id) {
		logger.info("SubjectService - getById() 진입");
		SubjectMapper mapper = sqlSession.getMapper(SubjectMapper.class);
		return mapper.selectById(id);
	}

	@Override
	public int getCount() {
		logger.info("SubjectService - getCount() 진입");
		SubjectMapper mapper = sqlSession.getMapper(SubjectMapper.class);
		return mapper.selectCount();
	}

	@Override
	public int update(SubjectDTO subject) {
		logger.info("SubjectService - update() 진입");
		SubjectMapper mapper = sqlSession.getMapper(SubjectMapper.class);
		return mapper.update(subject);
	}

	@Override
	public int delete(SubjectDTO subject) {
		logger.info("SubjectService - delete() 진입");
		SubjectMapper mapper = sqlSession.getMapper(SubjectMapper.class);
		return mapper.delete(subject);
	}

}
