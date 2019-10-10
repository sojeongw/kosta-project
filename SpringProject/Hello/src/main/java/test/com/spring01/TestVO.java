package test.com.spring01;


import org.springframework.web.multipart.MultipartFile;

public class TestVO {

	private int num;
	private String name;
	private String tel;
	
	private String imgName; // db에 한 column 더 추가한다
	private MultipartFile multipartFile;
	//private List<MultipartFile> multipartFiles;

	public TestVO() {
		num = 99;
		name = "Yang";
		tel = "000";
	}

	public TestVO(String name, String tel) {
		this.num = 1;
		this.name = name;
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

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

}
