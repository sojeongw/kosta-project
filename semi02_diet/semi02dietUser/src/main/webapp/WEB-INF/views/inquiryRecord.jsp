<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
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
			<h1>inquiryRecord</h1>
		</hgroup>
	</header>
	<section>
	<table>
		<thead>
			<tr>

			</tr>	
		</thead>
		<tbody>
		
	<label>날짜 </label><br/>${day} <br/><input type="hidden" name="day" value="${day}"/>
	<label>소모 칼로리 </label><br/>${total_kcal}<br/><input type="hidden" name="total_kcal" value="${total_kcal}"/>

		

<%-- 				<c:forEach items="${total_kcal }" var="vo" > --%>
<!-- 					<tr> -->
<%-- 						<td><a href="update.do?num=${vo.num}">${vo.num}</a></td> --%>
<%-- 						<td>${vo.title}</td> --%>
<%-- 						<td>${vo.content}</td> --%>
<%-- 						<td>${vo.writer}</td> --%>        
<%-- 						<td>${vo.regDate}</td> --%>
<%-- 						<td><a href="deleteOK.do?num=${vo.num}">삭제</a></td> --%>
<!-- 					</tr> -->
<%-- 				</c:forEach> --%>
		</tbody>
<!-- 		<tfoot> -->
<!-- 			<tr> -->
<!-- 				<td colspan="3">1 2 3 4 5</td> -->
<!-- 			</tr> -->
<!-- 		</tfoot> -->
	</table>

	<form action="main.do" method="get">
		<input type="submit" value="메인화면으로"/>
	</form>
	</section>

</body>
</html>