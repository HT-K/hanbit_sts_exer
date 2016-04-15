package com.hanbit.web.member;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hanbit.web.mapper.MemberMapper;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/*-context.xml") 
public class MemberServiceImplTest {
	// 이 AutoWired를 쓰려면 servlet-context.xml을 인식하게 해야한다. 그래서 위에 contetConfiguration을 쓰고 servlet-context.xml을 META-INF밑으로 옮겨온다.
	@Autowired MemberDTO member;
	@Autowired SqlSession session;

	@Test
	public void testLogin() {
		MemberMapper mapper = session.getMapper(MemberMapper.class);
		member.setId("hong");
		member.setPassword("1");
		member = mapper.login(member);
		assertEquals("홍길동", member.getName());
	}

}
