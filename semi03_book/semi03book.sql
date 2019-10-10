select c.checkout_num, c.book_num, u.USER_ID, b.book_name, b.book_writer, c.checkout_start, c.CHECKOUT_END
	from book_info b, user_info u, checkout c
	where u.user_id = c.user_id and b.book_num=c.book_num;