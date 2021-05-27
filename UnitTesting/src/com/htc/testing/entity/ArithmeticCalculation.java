package com.htc.testing.entity;

public class ArithmeticCalculation {
	public int doAdd()
	{
		return 1+2;
	}
	public int doSubract(int num1,int num2)
	{
		return num1-num2;
	}
	public int []getNumbers()
	{
		int [] numbers= {1,2,3};
		return numbers;
	}
	public int doDivision(int num,int denom)
	{
		return num/denom;
	}
}
