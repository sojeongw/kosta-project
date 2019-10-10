package test.com;

public class Test02Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Test02Main");
		
		Test02Notebook notebook = new Test02Notebook();
		System.out.println(notebook);
		//null이 아니게 하려면 new를 하면 된다.
		
		System.out.println(notebook.num);
		System.out.println(notebook.model);
		System.out.println(notebook.size);
		System.out.println(notebook.price);
		
		System.out.println();
		
		Test02Notebook notebook2= new Test02Notebook();
		System.out.println(notebook2);
		
		// 값을 바꾸고 싶을 때
		notebook2.num = 2;	
		notebook2.model = "hp002";
		notebook2.size = 17.0;
		notebook2.price = 1600000;
		
		System.out.println(notebook2.num);
		System.out.println(notebook2.model);
		System.out.println(notebook2.size);
		System.out.println(notebook2.price);
		
		
		// 자동차
		Test02Car car = new Test02Car();
		System.out.println(car.wheel);
		System.out.println(car.door);
		System.out.println(car.price);
		System.out.println(car.color);
		
		Test02Car car2 = new Test02Car();
		car2.wheel = 4;
		car2.door = 2;
		car2.price = 10;
		car2.color = "white";
		System.out.println(car2.wheel);
		System.out.println(car2.door);
		System.out.println(car2.price);
		System.out.println(car2.color);
		
		Test02Car car3 = new Test02Car();
		car3.wheel = 2;
		car3.door = 2;
		car3.price = 5;
		car3.color = "red";
		System.out.println(car3.wheel);
		System.out.println(car3.door);
		System.out.println(car3.price);
		System.out.println(car3.color);
		

	}	// end of main

}	// end of class
	