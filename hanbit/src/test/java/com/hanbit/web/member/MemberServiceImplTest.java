package com.hanbit.web.member;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/*-context.xml")
public class MemberServiceImplTest {
	@Autowired 
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testLogin() {
		fail("Not yet implemented");
	}

}
