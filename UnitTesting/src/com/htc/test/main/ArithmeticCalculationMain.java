package com.htc.test.main;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.htc.testing.entity.ArithmeticCalculation;

public class ArithmeticCalculationMain {
ArithmeticCalculation aco=new ArithmeticCalculation();
	
	@Before
	 public void setup()
	 {
		System.out.println("Premilinary setup in running");
	 }
	@After
	public void tearDown()
	{
		System.out.println("Cleaning Up the resources");
	}
	@Test(timeout=500)
	public void testDoAdd() throws InterruptedException
	{
	System.out.println("Testing do add Method");
		/*System.out.println(aco.doAdd());
		System.out.println("Testing complets");*/
	//Thread.sleep(3000);
		assertEquals(3,aco.doAdd());
	}
	@Test
	public void doSub()
	{System.out.println("Testing do sub Method");
		assertEquals(4,aco.doSubract(9, 5));
	}
	@Test
	public void testArrays()
	{
		System.out.println("Testing do test array Method");
		int expected[]= {1,2,3};
		assertArrayEquals(expected, aco.getNumbers());
	}
	@Test(expected=ArithmeticException.class)
	public void testDivisionException()
	{
		System.out.println("Testing do division Method");
		aco.doDivision(10, 2);
	}
}
