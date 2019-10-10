package test.com;

public class Test02Board {
	
	// 번호, 제목, 내용, 작성자, 작성일자
	// public : 가장 넓은 범위. 다른 패키지와 상속 관계 접근 가능
	// default : 제한자가 생략된 경우. 같은 package에서만 가능
	// protected : 패키지가 달라도 상속 관계이면 접근 가능
	// private : 내 클래스만 접근 가능
	public int num;
	public String title;
	public String content;
	public String name;
	public String date;
	
	Test02Board(){
		System.out.println("Test02Board");
		num = 1;
		title = "";
		content = "";
		name = "";
		date = "";
	}
	
	// 멤버값을 갖는 생성자, 메인에서 출력
	
	Test02Board(int num, String title, String content,
				String name, String date){
		System.out.println("Test02Board(int num, String title, String content, String name, String date)");
		this.num = num;
		this.title = title;
		this.content = content;
		this.name = name;
		this.date = date;
	
	}

}
