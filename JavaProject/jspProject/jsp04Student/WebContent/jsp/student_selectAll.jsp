<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="test.com.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SelectAll Page</title>

<style type="text/css">
body {
	background-color: yellow;
}
</style>
</head>
<body>
	<header> <hgroup>
	<h1 id="title01" class="title">SelectAll Page</h1>
	<nav>
	<button onclick="location.href='../student_index.jsp'">INDEX</button>
	<button onclick="location.href='../student_home.jsp'">HOME</button>
	<button onclick="location.href='student_insert.jsp'">성적등록</button>
	</nav> </hgroup> </header>

	<section>
	<table border="1">
		<thead>
			<tr>
				<th>NUM</th>
				<th>NAME</th>
				<th>KOR</th>
				<th>ENG</th>
				<th>MATH</th>
				<th>TOTAL</th>
				<th>AVG</th>
				<th>GRADE</th>
			</tr>
		</thead>
		<tbody>
			<% studentDAO dao = new studentDAOimpl();
			List<studentVO> list = dao.selectAll();
	
			for(int i=0; i<list.size() ; i++){	%> 

			<tr>
				<br>
				<td><%= list.get(i).getNum() %></td>
				<td><a href="student_update.jsp?num=<%= list.get(i).getNum() %>"><%= list.get(i).getName() %></a></td>
				<td><%= list.get(i).getKor() %></td>
				<td><%= list.get(i).getEng() %></td>
				<td><%= list.get(i).getMath() %></td>
				<td><%= list.get(i).getTotal() %></td>
				<td><%= list.get(i).getAvg() %></td>
				<td><%= list.get(i).getGrade() %></td>
				<td><a href="student_delete.jsp?num=<%= list.get(i).getNum() %>">삭제</a></td> 
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