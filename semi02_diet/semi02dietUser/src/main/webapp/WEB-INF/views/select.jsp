<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>menu</title>
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
			<h1>메뉴 목록페이지</h1>
		</hgroup>
		<nav>
			<jsp:include page="topMenu.jsp"></jsp:include>
			
		</nav>
	</header>
	<section>
	<table>
		<thead>
			<tr>
				<th>NUM</th>
				<th>MENU</th>
				<th>PRICE</th>
				<th>STORE</th>
				<th>KCAL</th>
				<th>IMG</th>
				<th></th>
			</tr>	
		</thead>
		<tbody>
				<c:forEach items="${list}" var="vo" >
					<tr>
						<td><a href="update.do?num=${vo.num}">${vo.num}</a></td>
						<td>${vo.menu}</td>
						<td>${vo.price}</td>
						<td>${vo.store}</td>
						<td>${vo.kcal}</td>
						<td><img src="resources/uploadimg/${vo.imgName}" width="50"/></td>
						<td><a href="deleteOK.do?num=${vo.num}">삭제</a></td>
					</tr>
				</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="7">1 2 3 4 5 6</td>
			</tr>
		</tfoot>
	</table>
	
	</section>

</body>
</html>