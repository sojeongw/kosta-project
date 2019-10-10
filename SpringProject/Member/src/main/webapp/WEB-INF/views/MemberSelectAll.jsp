<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="test.com.spring04Member.model.*"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
	<jsp:include page="MemberMenu.jsp"></jsp:include><br><br>
	<!-- 컨텐츠는 섹션에 넣는다 -->
	<section>
	<table>
		<thead>
			<tr>
				<th>Num</th>
				<th>ID</th>
				<th>Password</th>
				<th>Name</th>
				<th>Tel</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
		<%-- ${list} --%>
		<c:forEach items="${list}" var="vo">
			<tr>
				<td><a href="MemberUpdate.do?num=${vo.num}">${vo.num}</a></td>
				<td>${vo.id}</td>
				<td>${vo.pw}</td>
				<td>${vo.name}</td>
				<td>${vo.tel}</td>
				<td><a href="MemberDeleteOK.do?num=${vo.num}">delete</a></td>
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


</body>
</html>