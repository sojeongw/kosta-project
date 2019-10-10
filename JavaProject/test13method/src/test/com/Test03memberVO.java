package test.com;

public class Test03memberVO {

	private int num;
	private String id;
	private String pw;
	private String name;
	private String tel;
	private String aaa;
	
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public void setNum(int num) {
		this.num = num;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAaa(String aaa) {
		this.aaa = aaa;
	}

	public int getNum() {
		return num;
	}

	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}

	public String getName() {
		return name;
	}

	public String getTel() {
		return tel;
	}

	Test03memberVO(){
		System.out.println("Test01member()");
		num = 1156789;
		id = "wang";
		pw = "1234";
		name = "박보검";
		tel = "0262152800";
	}
	
	// 인자 있는 생성자
	Test03memberVO(int num, String id, String pw, String name, String tel){
		System.out.println("Test01member(int num, String id, String pw, String name, String tel)");
		this.num = num;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.tel = tel;
	}

}
