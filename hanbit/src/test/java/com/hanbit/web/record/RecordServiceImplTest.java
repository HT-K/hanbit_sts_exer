
package com.hanbit.web.record;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hanbit.web.mapper.RecordMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/*-context.xml") 
public class RecordServiceImplTest {
	@Autowired RecordDTO record;
	@Autowired SqlSession session;
	@Autowired RecordCommand command;
	
	@Test
	public void testGetList() {
		RecordMapper mapper = session.getMapper(RecordMapper.class);
		List<RecordDTO> list = new ArrayList<RecordDTO>();
		list = mapper.selectList(command);
		assertThat(list.size(), is(not(0))); // null이면 빨간불 null아니면 초록불~
	}
	
	@Test
	public void testGetByName() {
		RecordMapper mapper = session.getMapper(RecordMapper.class);
		List<RecordDTO> list = new ArrayList<RecordDTO>();
		command.setName("홍길동");
		list = mapper.selectByName(command);
		assertThat(list.get(0).getName(), is(equalTo("홍길동"))); // null이면 빨간불 null아니면 초록불~
	}
	
	@Test
	public void testGetById() { // 학생 id로 Record 테이블의 내용 가져오기 체크
		RecordMapper mapper = session.getMapper(RecordMapper.class);
		List<RecordDTO> list = new ArrayList<RecordDTO>();
		command.setId("hong");
		list = mapper.selectById(command);
		assertThat(list.size(), is(not(0))); // null이면 빨간불 null아니면 초록불~
	}
	
	@Test
	public void testGetByIdWithExamDate() { // 학생 id와 ExamDate 로 테이블의 내용 가져오기 체크
		RecordMapper mapper = session.getMapper(RecordMapper.class);
		List<RecordDTO> list = new ArrayList<RecordDTO>();
		command.setId("hong");
		command.setExamDate("2016-03-31");
		list = mapper.selectByIdWithExamDate(command);
		assertThat(list.size(), is(not(0))); // null이면 빨간불 null아니면 초록불~
	}
	
	@Test
	public void testCount() {
		RecordMapper mapper = session.getMapper(RecordMapper.class);
		int count = mapper.countAll();
		assertThat(count, is(not(0))); // null이면 빨간불 null아니면 초록불~
	}
	
	@Test
	public void testUpdate() {
		RecordMapper mapper = session.getMapper(RecordMapper.class);
		record.setId("kim");
		record.setExamDate("2016-03-31");
		record.setSubject("java");
		record.setScore(50);
		int count = mapper.update(record);
		assertThat(count, is(not(0))); // null이면 빨간불 null아니면 초록불~
	}
	
	@Test
	public void testDelete() {
		RecordMapper mapper = session.getMapper(RecordMapper.class);
		int count = mapper.delete("kim");
		assertThat(count, is(not(0))); // null이면 빨간불 null아니면 초록불~
	}
}