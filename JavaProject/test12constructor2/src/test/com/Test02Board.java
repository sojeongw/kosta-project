package test.com;

public class Test02Board {
	
	// ��ȣ, ����, ����, �ۼ���, �ۼ�����
	// public : ���� ���� ����. �ٸ� ��Ű���� ��� ���� ���� ����
	// default : �����ڰ� ������ ���. ���� package������ ����
	// protected : ��Ű���� �޶� ��� �����̸� ���� ����
	// private : �� Ŭ������ ���� ����
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
	
	// ������� ���� ������, ���ο��� ���
	
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
