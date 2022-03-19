package com.devops.dxc.devops.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;



//@SpringBootTest
class UtilTest {
    @Test
	void contextLoads() {
	}

    @Test
	public void testDxc() throws Exception {
		assertEquals(3100000, Util.getDxc(500000, 31000000));
	}

}

