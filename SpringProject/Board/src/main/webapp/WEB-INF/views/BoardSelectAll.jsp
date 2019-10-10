<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="test.com.spring05Board.model.*"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset=UTF-8">
<title>Select Page</title>
<style>
table{
	background-color:black;
}
tr{
	background-color:white;
}
th,td{
	text-align:center;
}
</style>

</head>
<body>
	<h1>select page</h1>
	<jsp:include page="BoardMenu.jsp"></jsp:include>
	
	<table>
		<thead>
			<tr>
				<th>Num</th>
				<th>Title</th>
				<th>Content</th>
				<th>Writer</th>
				<th>Reg_Date</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
		<%-- ${list} --%>
		<c:forEach items="${list}" var="vo">
					<tr>
						<td><a href="BoardUpdate.do?num=${vo.num}">${vo.num}</a></td>
						<td>${vo.title}</td>
						<td>${vo.content}</td>
						<td>${vo.writer}</td>
						<td>${vo.reg_date}</td>
						<td><a href="BoardDeleteOK.do?num=${vo.num}">삭제</a></td>
					</tr>
				</c:forEach> 
		</tbody>
		<tfoot>
			<tr>
				<!-- 몇 개를 합칠거냐 = colspan >> 여러 개 중복으로 쓰지 않아도 된다 -->
				<td colspan="6">1 2 3 4 5</td>
			</tr>
		</tfoot>
	</table>




	</section>



	<table>

	</table>

</body>
</html>