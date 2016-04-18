package com.hanbit.web.record;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanbit.web.mapper.RecordMapper;

@Service
public class RecordServiceImpl implements RecordService {
	private static final Logger logger = LoggerFactory.getLogger(RecordService.class);
	@Autowired SqlSession sqlSession;
	@Override
	public int insert(RecordDTO record) {
		logger.info("== insert() 진입 ==");
		RecordMapper mapper = sqlSession.getMapper(RecordMapper.class);
		return mapper.insert(record);
	}
	@Override
	public List<RecordDTO> getList() {
		logger.info("== getList() 진입 ==");
		RecordMapper mapper = sqlSession.getMapper(RecordMapper.class);
		return mapper.selectList();
	}
	@Override
	public List<RecordDTO> getByName(String name) {
		logger.info("== getByName() 진입 ==");
		RecordMapper mapper = sqlSession.getMapper(RecordMapper.class);
		return mapper.selectByName(name);
	}
	@Override
	public RecordDTO getById(int id) {
		logger.info("== getById() 진입 ==");
		RecordMapper mapper = sqlSession.getMapper(RecordMapper.class);
		return mapper.selectById(id);
	}
	@Override
	public int countAll() {
		logger.info("== countAll() 진입 ==");
		RecordMapper mapper = sqlSession.getMapper(RecordMapper.class);
		return mapper.countAll();
	}
	@Override
	public int update(RecordDTO record) {
		logger.info("== RecordDTO() 진입 ==");
		RecordMapper mapper = sqlSession.getMapper(RecordMapper.class);
		return mapper.update(record);
	}
	@Override
	public int delete(int id) {
		logger.info("== delete() 진입 ==");
		RecordMapper mapper = sqlSession.getMapper(RecordMapper.class);
		return mapper.delete(id);
	} 
}
