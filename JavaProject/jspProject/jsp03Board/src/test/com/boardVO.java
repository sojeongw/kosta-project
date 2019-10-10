package test.com;

import java.util.Date;

public class boardVO {
	
	private int num;
	private String title;
	private String content;
	private String writer;
	private Date Reg_Date;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getReg_Date() {
		return Reg_Date;
	}
	public void setReg_Date(Date reg_Date) {
		Reg_Date = reg_Date;
	}

	
}
