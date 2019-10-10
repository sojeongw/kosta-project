package test.com.spring04;

import org.springframework.web.multipart.MultipartFile;

public class TestVO {
	
	private int num;
	private String id = "sojeong";
	private String pw;
	private String tel;
	
	private String imgName; // db에 한 column 더 추가한다
	private MultipartFile multipartFile;
	//private List<MultipartFile> multipartFiles;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getImgName() {
		return imgName;
	}
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	public MultipartFile getMultipartFile() {
		return multipartFile;
	}
	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}
	
	
	

}
