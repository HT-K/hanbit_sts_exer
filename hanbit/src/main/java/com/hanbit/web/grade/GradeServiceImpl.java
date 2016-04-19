package com.hanbit.web.grade;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanbit.web.mapper.GradeMapper;
@Service
public class GradeServiceImpl implements GradeService{
	// 멤버 필드 (속성을 모아놓은 부분) 
	private static final Logger logger = LoggerFactory.getLogger(GradeService.class);
	@Autowired SqlSession sqlSession; 
	
	// 멤버 메소드 에어리어
	@Override
	public int insert(GradeDTO grade) { // gradeBean -> 지역변수의 일종으로 매개변수 혹은 파라미터라고 부름
		// C 성적표 등록
		logger.info("gradeService - insert() 진입");
		GradeMapper mapper = sqlSession.getMapper(GradeMapper.class);
		return mapper.insert(grade);
	}

	@Override
	public List<GradeDTO> getList() { // 서비스에서 syso를 하는게 아니라 Controller로 gradeList를 던져주면 된다!
		// R 성적표 리스트 출력
		logger.info("gradeService - getList() 진입");
		GradeMapper mapper = sqlSession.getMapper(GradeMapper.class);
		return mapper.selectList();
	}

	@Override
	public List<GradeDTO> getByName(String name) {
		// R 성적표 조회(이름)
		logger.info("gradeService-input() 진입");
		GradeMapper mapper = sqlSession.getMapper(GradeMapper.class);
		return mapper.selectByName(name);
	}
	
	@Override
	public GradeDTO getById(String id) {
		// R 성적표 조회(아이디)
		logger.info("gradeService-input() 진입");
		GradeMapper mapper = sqlSession.getMapper(GradeMapper.class);
		return mapper.selectById(id);
	}

	@Override
	public int getCount() {
		// R 카운트 조회
		logger.info("gradeService-input() 진입");
		GradeMapper mapper = sqlSession.getMapper(GradeMapper.class);
		return mapper.count();
	}

	@Override
	public int update(GradeDTO grade) {
		// U 성적표 수정
		logger.info("gradeService - update() 진입");
		GradeMapper mapper = sqlSession.getMapper(GradeMapper.class);
		return mapper.update(grade);
	}

	@Override
	public int delete(GradeDTO grade) {
		// D 성적표 삭제
		logger.info("gradeService - delete() 진입");
		GradeMapper mapper = sqlSession.getMapper(GradeMapper.class);
		return mapper.delete(grade);
	}

}