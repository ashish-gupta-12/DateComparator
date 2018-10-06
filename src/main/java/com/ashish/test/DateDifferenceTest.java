package com.ashish.test;

import java.util.ArrayList;

import com.ashish.pojo.myDate;
import com.ashish.service.DateDifferenceProvider;

public class DateDifferenceTest {

	public static void main(String[] args) {
		
		ArrayList<MyDateTestRecord> testData = new ArrayList<MyDateTestRecord>();
		
		testData.add(new MyDateTestRecord(new myDate(6, 4, 2011), new myDate(6, 4, 2011), 0)); //case1
		testData.add(new MyDateTestRecord(new myDate(6, 4, 2011), new myDate(18, 4, 2011), 12)); //case2
		testData.add(new MyDateTestRecord(new myDate(6, 4, 2011), new myDate(18, 5, 2011), 42)); //case3
		testData.add(new MyDateTestRecord(new myDate(6, 4, 2011), new myDate(18, 6, 2011), 73)); //case4
		testData.add(new MyDateTestRecord(new myDate(6, 4, 2011), new myDate(18, 12, 2011), 256)); //case5
		testData.add(new MyDateTestRecord(new myDate(6, 4, 2011), new myDate(18, 12, 2012), 622)); //case6
		testData.add(new MyDateTestRecord(new myDate(6, 4, 2011), new myDate(18, 12, 2013), 987)); //case7
		testData.add(new MyDateTestRecord(new myDate(6, 4, 2011), new myDate(18, 12, 2113), 37511)); //case8
		testData.add(new MyDateTestRecord(new myDate(6, 4, 2011), new myDate(18, 12, 2413), 147084)); //case9
		testData.add(new MyDateTestRecord(new myDate(6, 4, 2011), new myDate(18, 12, 2813), 293181)); //case10
		testData.add(new MyDateTestRecord(new myDate(6, 1, 2011), new myDate(6, 3, 2011), 59)); //case11
		testData.add(new MyDateTestRecord(new myDate(6, 1, 2012), new myDate(6, 3, 2012), 60)); //case12
		testData.add(new MyDateTestRecord(new myDate(6, 2, 2012), new myDate(6, 3, 2012), 29)); //case13
		testData.add(new MyDateTestRecord(new myDate(22, 1, 2012), new myDate(15, 11, 2012), 298)); //case14
		testData.add(new MyDateTestRecord(new myDate(6, 2, 2012), new myDate(6, 12, 2012), 304)); //case15
	
		for(MyDateTestRecord testCase : testData) {
			
			myDate startDate = testCase.startDate;
			myDate endDate = testCase.endDate;
			long expectedResult = testCase.expectedResult;
			long obtainedResult = DateDifferenceProvider.getDateDifference(startDate, endDate);
			
			if(expectedResult == obtainedResult)
				System.out.println("Test "+(1 + testData.lastIndexOf(testCase) + " Passed " + obtainedResult + "= obtainedReslt "+ expectedResult + "= expectedResult"));
			else
				System.err.println("Test "+(1 + testData.lastIndexOf(testCase) + " Failed " + obtainedResult + "= obtainedReslt "+ expectedResult + "= expectedResult"));
		}
		
	}
}
