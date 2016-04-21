package com.hanbit.web.record;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanbit.web.global.Command;
import com.hanbit.web.mapper.RecordMapper;

@Service
public class RecordServiceImpl implements RecordService {
	private static final Logger logger = LoggerFactory.getLogger(RecordService.class);
	@Autowired SqlSession sqlSession;
	
	/*@Override
	public int insert(GradeDTO grade) {
		logger.info("== insert() 진입 ==");
		GradeMapper mapper = sqlSession.getMapper(GradeMapper.class);
		return mapper.insert(grade);
	}*/
	
	@Override
	public List<RecordDTO> getList(Command command) {
		logger.info("== getList() 진입 ==");
		RecordMapper mapper = sqlSession.getMapper(RecordMapper.class);
		return mapper.selectList(command);
	}
	@Override
	public List<RecordDTO> getByName(Command command) {
		logger.info("== getByName() 진입 ==");
		RecordMapper mapper = sqlSession.getMapper(RecordMapper.class);
		return mapper.selectByName(command);
	}
	@Override
	public List<RecordDTO> getById(Command command) {
		logger.info("== getById() 진입 ==");
		RecordMapper mapper = sqlSession.getMapper(RecordMapper.class);
		return mapper.selectById(command);
	}
	@Override
	public List<RecordDTO> getByIdWithExamDate(Command command) {
		logger.info("== getById() 진입 ==");
		RecordMapper mapper = sqlSession.getMapper(RecordMapper.class);
		return mapper.selectByIdWithExamDate(command);
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
	
	/*@Override
	public int delete(GradeDTO grade) {
		logger.info("== delete() 진입 ==");
		RecordMapper mapper = sqlSession.getMapper(RecordMapper.class);
		return mapper.delete(grade);
	}*/
}
