package com.ashish.test;

import com.ashish.pojo.myDate;

public class MyDateTestRecord {

	public myDate startDate;
	public myDate endDate;
	public long expectedResult;
	
	public MyDateTestRecord(myDate startDate, myDate endDate, long expectedResult) {
		
		this.startDate = startDate;
		this.endDate = endDate;
		this.expectedResult = expectedResult;
	}
	
}
