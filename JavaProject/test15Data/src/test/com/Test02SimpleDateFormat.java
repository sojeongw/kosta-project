package test.com;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test02SimpleDateFormat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("DateFormat...");
		
		// ���ϴ�� ������� �� ����
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
		System.out.println(sdf.format(new Date()));
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy�� MM�� dd�� HH�� mm�� ss.SSS��");
		System.out.println(sdf2.format(new Date()));
		
		
	}

}
