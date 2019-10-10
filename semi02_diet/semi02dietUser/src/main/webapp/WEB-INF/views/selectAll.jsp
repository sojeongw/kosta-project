<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>select all</title>
<style type="text/css">
table {
	background-color: black;
	
}
/* tr: table row */
tr {
	background-color: white;
	 
}
/* th:table header, td: table data */
th,td {
	text-align: center;
}
</style>
</head>
<body>
	<header>
		<hgroup>
			<h1>Select All</h1>
		</hgroup>
	</header>
	
	<section>
	<table>
		<thead>
			<tr>
				<th>날짜</th>
				<th>소모 kcal</th>
				
			</tr>	
		</thead>
		<tbody>
		<%
		
		System.out.println("넘어왔냐");
		System.out.println(request.getParameter("list"));
		
		%>
				<c:forEach items="${list}" var="kvo" >
					<tr>
						<td>${kvo.day}</td>
						<td>${kvo.totalkcal}</td>
<%-- 						<td>${vo.writer}</td> --%>        
<%-- 						<td>${vo.regDate}</td> --%>
<%-- 						<td><a href="deleteOK.do?num=${vo.num}">삭제</a></td> --%>
					</tr>
				</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="3">1 2 3 4 5</td>
			</tr>
		</tfoot>
	</table>
	
	<form action="backToMainOK.do" method="post">
		<input type="submit" value="메인화면으로"/>
	</form>
	</section>

</body>
</html>