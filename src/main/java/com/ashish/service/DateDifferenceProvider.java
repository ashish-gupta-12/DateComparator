package com.ashish.service;

import com.ashish.pojo.myDate;

public class DateDifferenceProvider {
	private static int daysinJAN = 31;
	private static int daysinFEB = 28;
	private static int daysinMARCH = 31;
	private static int daysinAPRIL = 30;
	private static int daysinMAY = 31;
	private static int daysinJUNE = 30;
	private static int daysinJULY = 31;
	private static int daysinAUG = 31;
	private static int daysinSEPT = 30;
	private static int daysinOCT = 31;
	private static int daysinNOV = 30;
	private static int daysinDEC = 31;
	public static int daysinMONTH[] = {0, daysinJAN, daysinFEB, daysinMARCH, daysinAPRIL, daysinMAY, daysinJUNE,
			daysinJULY, daysinAUG, daysinSEPT, daysinOCT, daysinNOV, daysinDEC };

	public static int getDateDifference(myDate startDate, myDate endDate) {
		
		/*int daysDd= endDate.getDd()-startDate.getDd();
		int monthDays[]= {31,28,31,30,31,30,31,31,30,31,30,31};
		int m1=startDate.getMm();
		int m2=endDate.getMm();
		int daysMm=0;
		for(int index=m2; index>=m1+1; index++) {
			daysMm+=monthDays[index];
		}
		int expectedResult=daysDd+daysMm;
		return expectedResult;*/
		if(sameDate(startDate, endDate) && sameMonth(startDate, endDate) && sameYear(startDate, endDate)) {
			return 0;
		}
		else if(sameYear(startDate, endDate) && sameMonth(startDate, endDate)) {
			return endDate.getDd() - startDate.getDd();
		}
		else if(sameYear(startDate, endDate) && !sameMonth(startDate, endDate)) {
			return remainigDaysInMonth(startDate)+daysInIntervingMonth(startDate,endDate)+daysInLeadingMonth(endDate);
		}
		else {
			return remianingDaysInYear(startDate)+daysInInterviningYear(startDate,endDate)+daysInLeadingYear(endDate);
		}
	}

	private static int daysInLeadingYear(myDate endDate) {
		checkLeapYear(endDate.getYyyy());
		myDate yearStartDate=new myDate(1, 1, endDate.getYyyy());
		return remainigDaysInMonth(yearStartDate)+daysInIntervingMonth(yearStartDate,endDate)+daysInLeadingMonth(endDate)+1;
	}

	private static int daysInInterviningYear(myDate startDate, myDate endDate) {
		int currentYear=startDate.getYyyy()+1;
		int leadingYear=endDate.getYyyy()-1;
		int days=0;
		for(int index=currentYear; index<=leadingYear; index++) {
			int leapYear=checkLeapYear(index);
			if(leapYear==1) {
				days+=366;
			}
			else {
				days+=365;
			}
		}
		return days;
	}

	private static int remianingDaysInYear(myDate startDate) {
		
		checkLeapYear(startDate.getYyyy());
		myDate yearEndDate=new myDate(31, 12, startDate.getYyyy());
		return remainigDaysInMonth(startDate)+daysInIntervingMonth(startDate,yearEndDate)+daysInLeadingMonth(yearEndDate);
	}

	private static int daysInLeadingMonth(myDate endDate) {
		//System.out.println(endDate.getDd());
		return endDate.getDd();
	}

	private static int daysInIntervingMonth(myDate startDate, myDate endDate) {
		checkLeapYear(startDate.getYyyy());
		int remaingMonth=startDate.getMm()+1;
		int leadingMonth=endDate.getMm()-1;
		int days=0;
		for(int index=remaingMonth; index<=leadingMonth; index++) {
			days+=daysinMONTH[index];
		}
		//System.out.println(days);
		return days;
	}

	private static int remainigDaysInMonth(myDate startDate) {
		//System.out.println(daysinMONTH[startDate.getMm()]-startDate.getDd());
		checkLeapYear(startDate.getYyyy());
		return daysinMONTH[startDate.getMm()]-startDate.getDd();
	}

	private static int checkLeapYear(int yyyy) {
		// TODO Auto-generated method stub
		if (( yyyy%400 == 0)|| (( yyyy%4 == 0 ) &&( yyyy%100 != 0))) {
			daysinMONTH[2]=29;
			return 1;
		}
		else {
			daysinMONTH[2]=28;
			return 0;
		}
		
	}

	private static boolean sameYear(myDate startDate, myDate endDate) {
		if(startDate.getYyyy()==endDate.getYyyy()) {
			return true;
		}
		return false;
	}

	private static boolean sameMonth(myDate startDate, myDate endDate) {
		if(startDate.getMm()==endDate.getMm()) {
			return true;
		}
		return false;
	}

	private static boolean sameDate(myDate startDate, myDate endDate) {
		if(startDate.getDd()==endDate.getDd()) {
			return true;
		}
		return false;
	}

}
