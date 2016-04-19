
package com.hanbit.web.record;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hanbit.web.grade.GradeDTO;
import com.hanbit.web.mapper.GradeMapper;
import com.hanbit.web.mapper.RecordMapper;
import com.hanbit.web.util.ExamDate;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/*-context.xml") 
public class RecordServiceImplTest {
	@Autowired RecordDTO record;
	@Autowired GradeDTO grade;
	@Autowired SqlSession session;
	@Autowired RecordCommand command;
	
	@Test
	public void testInsert() { // Record의 insert는 Grade 테이블에 성적을 입력하는 것과 같다 (왜냐하면 이미 등록된 멤버에게 성적을 입력하면 Record View가 자동으로 최신화 되기 때문!)
		GradeMapper mapper = session.getMapper(GradeMapper.class);
		grade.setId("hye");
		grade.setSubj_seq(4); 
		grade.setScore(80);
		grade.setExamDate(ExamDate.getDate());
		int check = mapper.insert(grade);
		assertThat(check, is(1)); // null이면 빨간불 null아니면 초록불~
	}
	
	@Test
	public void testGetList() { // SELECT * FROM Record
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
	public void testCount() { // Record Count
		RecordMapper mapper = session.getMapper(RecordMapper.class);
		int count = mapper.countAll();
		assertThat(count, is(not(0))); // null이면 빨간불 null아니면 초록불~
	}
	
	@Test
	public void testUpdate() { // Record Update
		RecordMapper mapper = session.getMapper(RecordMapper.class);
		record.setId("kim");
		record.setExamDate("2016-03-31");
		record.setSubject("java");
		record.setScore(60);
		int check = mapper.update(record);
		assertThat(check, is(1)); // null이면 빨간불 null아니면 초록불~
	}
	
	@Test
	public void testDelete() {
		RecordMapper mapper = session.getMapper(RecordMapper.class);
		int check = mapper.delete("kim");
		assertThat(check, is(not(0))); // null이면 빨간불 null아니면 초록불~
	}
}