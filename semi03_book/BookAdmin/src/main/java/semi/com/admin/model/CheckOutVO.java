package semi.com.admin.model;

import java.sql.Date;

public class CheckOutVO {
	private int book_num;
	private String book_name;
	private String book_writer;
	private String book_company;
	private String user_id;
	private String user_name; // 클래스 다이어그램과 다름
	private String user_tel; // 클래스 다이어그램과 다름
	private Date checkout_start; // 클래스 다이어그램과 다름
	private Date checkout_end; // 클래스 다이어그램과 다름
	
	public int getBook_num() {
		return book_num;
	}
	public void setBook_num(int book_num) {
		this.book_num = book_num;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_tel() {
		return user_tel;
	}
	public void setUser_tel(String user_tel) {
		this.user_tel = user_tel;
	}
	public Date getCheckout_start() {
		return checkout_start;
	}
	public void setCheckout_start(Date checkout_start) {
		this.checkout_start = checkout_start;
	}
	public Date getCheckout_end() {
		return checkout_end;
	}
	public void setCheckout_end(Date checkout_end) {
		this.checkout_end = checkout_end;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getBook_writer() {
		return book_writer;
	}
	public void setBook_writer(String book_writer) {
		this.book_writer = book_writer;
	}
	public String getBook_company() {
		return book_company;
	}
	public void setBook_company(String book_company) {
		this.book_company = book_company;
	}
}
