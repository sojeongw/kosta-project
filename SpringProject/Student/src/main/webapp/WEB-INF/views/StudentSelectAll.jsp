<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Select Page</title>
<style>
table {
	background-color: black;
	text-align:center;
}

th, td {
	background-color: white;
}
</style>

</head>
<body>
	<h1>select page</h1>
	<jsp:include page="StudentMenu.jsp"></jsp:include>
	<!-- 컨텐츠는 섹션에 넣는다 -->
	<section>
	<table>
		<thead>
			<tr>
				<th>Num</th>
				<th>Name</th>
				<th>Kor</th>
				<th>Eng</th>
				<th>Math</th>
				<th>Total</th>
				<th>Avg</th>
				<th>Grade</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="vo">
				<tr>

					<td><a href="StudentUpdate.do?num=${vo.num}">${vo.num}</a></td>
					<td>${vo.name}</td>
					<td>${vo.kor}</td>
					<td>${vo.eng}</td>
					<td>${vo.math}</td>
					<td>${vo.total}</td>
					<td>${vo.avg}</td>	
					<td>${vo.grade}</td>
					<td><a href="StudentDeleteOK.do?num=${vo.num}">delete</a></td>

				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<!-- 몇 개를 합칠거냐 = colspan >> 여러 개 중복으로 쓰지 않아도 된다 -->
				<td colspan="9">1 2 3 4 5</td>
			</tr>
		</tfoot>
	</table>




	</section>



	<table>

	</table>

</body>
</html>
