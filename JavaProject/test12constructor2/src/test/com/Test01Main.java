package test.com;

public class Test01Main {

	public static void main(String[] args) {
				
		System.out.println("main");
		
		Test01member tm = new Test01member(1198057, "sojeong", "1234", "wang", "01046557478");
		System.out.println(tm);
		System.out.println(tm.id);
		System.out.println(tm.name);
		System.out.println(tm.num);
		System.out.println(tm.pw);
		System.out.println(tm.tel);
		
		System.out.println();
		
		Test02Board tb = new Test02Board(99, "�ȳ��ϼ���", "�氡�氡",
				"�ռ���", "2017-07-20");
		System.out.println(tb.num);
		System.out.println(tb.title);
		System.out.println(tb.content);
		System.out.println(tb.name);
		System.out.println(tb.date);
		
		System.out.println();
		
		Test02Board tb2 = new Test02Board(100, "�ڹ�", "��",
				"�ľ���", "2017-07-21");
		System.out.println(tb2.num);
		System.out.println(tb2.title);
		System.out.println(tb2.content);
		System.out.println(tb2.name);
		System.out.println(tb2.date);
		
		
		
		
	}	//end of main

}	// end of class
