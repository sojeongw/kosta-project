package javaStudy;

public class B extends A{
	
	public void test01(String str) {
		super.test01("String");
		System.out.println("B test01 : " + str);
	}
	
	public void test02(int a) {
		System.out.println("B test02 : " + a);
	}

}
