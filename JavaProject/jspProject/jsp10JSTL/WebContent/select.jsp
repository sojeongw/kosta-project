<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- c, m, fmt, sql, fn은 tag가 된다. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">
table {
	background-color: black;
}

tr {
	background-color: white;
}
</style>

</head>
<body>
	<h1>select.jsp</h1>

	<table>
		<thead>
			<tr>
				<th>num</th>
				<th>name</th>
				<th>tel</th>
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
				<td><a href="update.do?num=${vo.num}">${vo.num}</td>
				<td>${vo.name}</td>
				<td>${vo.tel}</td>
			</tr>
		</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="3">aaa@aaa.com</td>
			</tr>
		</tfoot>
	</table>

</body>
</html>