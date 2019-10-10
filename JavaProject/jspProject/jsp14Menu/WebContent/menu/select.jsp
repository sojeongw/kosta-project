<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset=UTF-8">
<title>menu</title>

<style type="text/css">
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

	<header> <hgroup>
	<h1>메뉴 목록 페이지</h1>
	</hgroup> <nav> <jsp:include page="topMenu.html"></jsp:include> </nav> </header>

	<section>
	<table>
		<thead>
			<tr>
				<th>num</th>
				<th>menu</th>
				<th>price</th>
				<th>store</th>
				<th>kcal</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<%-- ${list}<br>
		
		${list[0].num}, ${list[0].name}, ${list[0].tel}<br>
		${list[1].num}, ${list[1].name}, ${list[1].tel}<br>
		${list[2].num}, ${list[2].name}, ${list[2].tel}<br> --%>
			<%-- <c:forEach begin="0" end="2" step="1" var="i"> --%>
			<c:forEach items="${list}" var="vo">
				<tr>
					<td><a href="update.do?num=${vo.num}">${vo.num}</a></td>
					<td>${vo.menu}</td>
					<td>${vo.price}</td>
					<td>${vo.store}</td>
					<td>${vo.kcal}</td>
					<td><a href="deleteOK.do?num=${vo.num}">삭제</a></td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="6">1	2	3	4	5</td>
			</tr>
		</tfoot>
	</table>
	</section>


</body>
</html>