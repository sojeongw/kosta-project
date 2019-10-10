package test.com;

public class Test03Student {
	
	String name;
	int num;
	int age;
	Test03Student[] stArr = new Test03Student[3];
	
	Test03Student(){
		System.out.println("Test03Student()");
		name = "¿Õ¼ÒÁ¤";
		age = 28;
		num = 1198057;
	}
	
	Test03Student(String name, int num, int age){
		System.out.println("Test03Student(String name, int num, int age)");
		this.name = name;
		this.num = num;
		this.age = age;
	}

}
