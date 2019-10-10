package semi.com.user.model;

import java.util.Date;

public class CheckOutVO {

	private int checkout_num;
	private int book_num;
	private String user_id;
	private String checkout_start;
	private String checkout_end;
	private String book_name;
	private String book_writer;
	
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
	public int getCheckout_num() {
		return checkout_num;
	}
	public void setCheckout_num(int checkout_num) {
		this.checkout_num = checkout_num;
	}
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
	public String getCheckout_start() {
		return checkout_start;
	}
	public void setCheckout_start(String checkout_start) {
		this.checkout_start = checkout_start;
	}
	public String getCheckout_end() {
		return checkout_end;
	}
	public void setCheckout_end(String checkout_end) {
		this.checkout_end = checkout_end;
	}
}
