package test.com;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Test01Date {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// java.util ��Ű��
		Date d = new Date();
		// java.sql ��Ű���� �� �ִ� date. DB�� ģȭ���� ����.
		java.sql.Date d2 = new java.sql.Date(System.currentTimeMillis());
		System.out.println("sql get time : " + d2.getTime());
		java.sql.Timestamp tt = new java.sql.Timestamp(System.currentTimeMillis());
		System.out.println("sql time stamp : " + tt);	// ��:��:��.�и�����
		
		System.out.println(d);
		System.out.println(d2);
		
		// new�� ���� �ʰ� ��ü �����ϴ� �� : getInstance()
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.getTimeInMillis());
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH));	// 0������ 11�������� ����
		System.out.println(cal.get(Calendar.MONTH)+1);
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
		System.out.println(cal.get(Calendar.HOUR));
		System.out.println(cal.get(Calendar.AM_PM)+ ":" + cal.get(Calendar.HOUR));	// 1�̸� PM
		System.out.println(cal.get(Calendar.HOUR_OF_DAY));
		System.out.println(cal.get(Calendar.MINUTE));
		System.out.println(cal.get(Calendar.SECOND));
		
		
		Calendar cal_2 = new GregorianCalendar();
		cal_2 = new GregorianCalendar(2002, 5, 5, 17, 5, 30);
		System.out.println();
		System.out.println(cal_2.getTimeInMillis());
		System.out.println(cal_2.get(Calendar.YEAR));
		System.out.println(cal_2.get(Calendar.MONTH));	// 0������ 11�������� ����
		System.out.println(cal_2.get(Calendar.MONTH)+1);
		System.out.println(cal_2.get(Calendar.DAY_OF_MONTH));
		System.out.println(cal_2.get(Calendar.HOUR));
		System.out.println(cal_2.get(Calendar.AM_PM)+ ":" + cal_2.get(Calendar.HOUR));	// 1�̸� PM
		System.out.println(cal_2.get(Calendar.HOUR_OF_DAY));
		System.out.println(cal_2.get(Calendar.MINUTE));
		System.out.println(cal_2.get(Calendar.SECOND));
		
		// static : Ŭ���� �̸�.blah
		
	
		
	}

}
