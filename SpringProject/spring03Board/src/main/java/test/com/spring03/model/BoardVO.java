package test.com.spring03.model;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class BoardVO {
	
	private int num=1;
	private String title="title";
	private String content="content";
	private String writer="writer";
	private Date reg_date;
	
	private String imgname; // db에 한 column 더 추가한다
	private MultipartFile multipartFile;
	//private List<MultipartFile> multipartFiles;
	
	
	public int getNum() {
		return num;
	}
	public String getImgname() {
		return imgname;
	}
	public void setImgname(String imgname) {
		this.imgname = imgname;
	}
	public MultipartFile getMultipartFile() {
		return multipartFile;
	}
	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
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
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}


}
