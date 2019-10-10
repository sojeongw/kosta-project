package semi.com.user.model;

public class BookInfoVO {

	private int book_num;
	private String book_name;
	private String book_writer;
	private String book_company;
	private String book_content;
	private String book_checkout;
	
	
	
	public String getBook_checkout() {
		return book_checkout;
	}
	public void setBook_checkout(String book_checkout) {
		this.book_checkout = book_checkout;
	}
	public String getBook_content() {
		return book_content;
	}
	public void setBook_content(String book_content) {
		this.book_content = book_content;
	}

	
	
	
	public int getBook_num() {
		return book_num;
	}
	public void setBook_num(int book_num) {
		this.book_num = book_num;
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
