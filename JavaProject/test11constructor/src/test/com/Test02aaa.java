package test.com;

public class Test02aaa {

	int num;
	String name;
	String tel;

	Test02aaa() {
		System.out.println("Test02aaa");
		num = 1;
		name = "kim";
		tel = "010";
	}
	
	Test02aaa(int num, String name, String tel) {
		this.num = num;
		this.name = name;
		this.tel = tel;
	}

} // end of class
