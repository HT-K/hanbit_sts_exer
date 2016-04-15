package com.hanbit.web.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

public class CalculatorTest {
	Calculator c = new Calculator();
	
	
	@Test
	public void testSum() {
		assertEquals(7, c.sum(3, 7));
	}

}
