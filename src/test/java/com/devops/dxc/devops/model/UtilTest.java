package com.devops.dxc.devops.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
class UtilTest {
    @Test
	public void testDxc() throws Exception {
		assertEquals(0, Util.getDxc(-40000000,-31700));
		assertEquals(0, Util.getDxc(-40000000,31600));
		assertEquals(0, Util.getDxc(31000000,-1));
		assertEquals(0, Util.getDxc(0,31700));
		assertEquals(0, Util.getDxc(31000000,0));
		assertEquals(700000, Util.getDxc(700000,31700));
		assertEquals(1000000, Util.getDxc(1000000,31700));
		assertEquals(1000000, Util.getDxc(9999999,31700));
		assertEquals(1100000, Util.getDxc(11000000,31700));
		assertEquals(4755000, Util.getDxc(47550000,31700));
		assertEquals(4755000, Util.getDxc(50000000,31700));
	}

	@Test
	public void testSaldoRestante() throws Exception {
		assertEquals(0, Util.getSaldoRestante(-40000000,-4000000));
		assertEquals(0, Util.getSaldoRestante(-40000000,4000000));
		assertEquals(0, Util.getSaldoRestante(40000000,-4000000));
		assertEquals(0, Util.getSaldoRestante(0,123456));
		assertEquals(0, Util.getSaldoRestante(700000,700000));
		assertEquals(8999999, Util.getSaldoRestante(9999999,1000000));
		assertEquals(42795000, Util.getSaldoRestante(47550000,4755000));
	}

	@Test
	public void testImpuesto() throws Exception {
		assertEquals(0, Util.getImpuesto(-40000000,-55704));
		assertEquals(0, Util.getImpuesto(-40000000,55704));
		assertEquals(0, Util.getImpuesto(40000000,-55704));
		assertEquals(0, Util.getImpuesto(0,55704));
		assertEquals(0, Util.getImpuesto(700000,55704));
		assertEquals(36765, Util.getImpuesto(1671120,55704));
		assertEquals(125891, Util.getImpuesto(2785200,55704));
		assertEquals(276292, Util.getImpuesto(3899280,55704));
		assertEquals(532530, Util.getImpuesto(5013360,55704));
		assertEquals(1040551, Util.getImpuesto(6684480,55704));
		assertEquals(1150983, Util.getImpuesto(7000000,55704));
	}

}

