package test.com;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Test01Date {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// java.util 패키지
		Date d = new Date();
		// java.sql 패키지에 들어가 있는 date. DB와 친화적인 구조.
		java.sql.Date d2 = new java.sql.Date(System.currentTimeMillis());
		System.out.println("sql get time : " + d2.getTime());
		java.sql.Timestamp tt = new java.sql.Timestamp(System.currentTimeMillis());
		System.out.println("sql time stamp : " + tt);	// 시:분:초.밀리세컨
		
		System.out.println(d);
		System.out.println(d2);
		
		// new를 쓰지 않고 객체 생성하는 법 : getInstance()
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.getTimeInMillis());
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH));	// 0월부터 11월까지만 있음
		System.out.println(cal.get(Calendar.MONTH)+1);
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
		System.out.println(cal.get(Calendar.HOUR));
		System.out.println(cal.get(Calendar.AM_PM)+ ":" + cal.get(Calendar.HOUR));	// 1이면 PM
		System.out.println(cal.get(Calendar.HOUR_OF_DAY));
		System.out.println(cal.get(Calendar.MINUTE));
		System.out.println(cal.get(Calendar.SECOND));
		
		
		Calendar cal_2 = new GregorianCalendar();
		cal_2 = new GregorianCalendar(2002, 5, 5, 17, 5, 30);
		System.out.println();
		System.out.println(cal_2.getTimeInMillis());
		System.out.println(cal_2.get(Calendar.YEAR));
		System.out.println(cal_2.get(Calendar.MONTH));	// 0월부터 11월까지만 있음
		System.out.println(cal_2.get(Calendar.MONTH)+1);
		System.out.println(cal_2.get(Calendar.DAY_OF_MONTH));
		System.out.println(cal_2.get(Calendar.HOUR));
		System.out.println(cal_2.get(Calendar.AM_PM)+ ":" + cal_2.get(Calendar.HOUR));	// 1이면 PM
		System.out.println(cal_2.get(Calendar.HOUR_OF_DAY));
		System.out.println(cal_2.get(Calendar.MINUTE));
		System.out.println(cal_2.get(Calendar.SECOND));
		
		// static : 클래스 이름.blah
		
	
		
	}

}
