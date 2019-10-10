package test.com;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test02SimpleDateFormat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("DateFormat...");
		
		// 패턴대로 집어넣을 수 있음
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
		System.out.println(sdf.format(new Date()));
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss.SSS초");
		System.out.println(sdf2.format(new Date()));
		
		
	}

}
