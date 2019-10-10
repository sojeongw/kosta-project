<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="test.com.*" %>
	<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SelectAll Page</title>

<style type="text/css">
body {
	background-color: red;
}

#title01 {
	color: blue;
}
</style>
</head>
<body>
	<header> <hgroup>
	<h1 id="title01" class="title">SelectAll Page</h1>
	<nav>
	<button onclick="location.href='../member_index.jsp'">INDEX</button>
	<button onclick="location.href='member_insert.jsp'">회원가입</button>
	</nav> </hgroup> </header>

	<section>
	<table border="1">
		<thead>
			<tr>
				<th>NUM</th>
				<th>ID</th>
				<th>PW</th>
				<th>NAME</th>
				<th>TEL</th>
			</tr>
		</thead>
		<tbody>
			<% 
			TestDAO dao = new TestDAOimpl();
			List<TestVO> list = dao.selectAll();
			
			for(int i=0; i<list.size() ; i++){	%>
			<tr>
				<td><%= list.get(i).getNum() %></td>
				<td><a href="member_update.jsp?num=<%= list.get(i).getNum() %>"><%= list.get(i).getId() %></a></td>
				<td><%= list.get(i).getPw() %></td>
				<td><%= list.get(i).getName() %></td>
				<td><%= list.get(i).getTel() %></td>
				<td><a href="member_delete.jsp?num=<%= list.get(i).getNum() %>">삭제</a></td>
			</tr>
			<% } %>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="5">tfoot</td>
			</tr>
		</tfoot>
	</table>
	</section>




</body>
</html>