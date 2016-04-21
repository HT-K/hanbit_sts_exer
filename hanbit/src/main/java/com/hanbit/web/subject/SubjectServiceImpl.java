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
		// C 과목 생성
		logger.info("SubjectService - insert() 진입");
		SubjectMapper mapper = sqlSession.getMapper(SubjectMapper.class);
		return mapper.insert(subject);
	}

	@Override
	public List<SubjectDTO> getListAll() {
		// R 모든 과목 리스트 검색
		logger.info("SubjectService - getListAll() 진입");
		SubjectMapper mapper = sqlSession.getMapper(SubjectMapper.class);
		return mapper.selectListAll();
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
		// R 과목 개수 조회
		logger.info("SubjectService - getCount() 진입");
		SubjectMapper mapper = sqlSession.getMapper(SubjectMapper.class);
		return mapper.count();
	}

	@Override
	public int update(SubjectDTO subject) {
		// U 과목 업데이트
		logger.info("SubjectService - update() 진입");
		SubjectMapper mapper = sqlSession.getMapper(SubjectMapper.class);
		return mapper.update(subject);
	}

	@Override
	public int delete(SubjectDTO subject) {
		// D 과목 삭제
		logger.info("SubjectService - delete() 진입");
		SubjectMapper mapper = sqlSession.getMapper(SubjectMapper.class);
		return mapper.delete(subject);
	}

}
