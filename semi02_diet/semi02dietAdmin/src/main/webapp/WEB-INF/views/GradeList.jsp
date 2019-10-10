
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<style>
button {
	font-family: "Roboto", sans-serif;
	outline: 0;
	background: #f2f2f2;
	width: 70px;
	border: 0;
	margin: auto;
	padding: 5px;
	box-sizing: border-box;
	font-size: 11px;
}

#wrap {
	width: 971px;
	margin: 0;
	margin-left: auto;
	margin-right: auto;
}

table {
	width: 50%;
	border-collapse: collapse;
	font-size: 12px;
	line-height: 24px;
}

table td, th {
	border: #d3d3d3 solid 1px;
	padding: 5px;
	text-align: center;
}

table th {
	background-color: #f8f8f8;
}

tfoot {
	text-align: center;
}

a {
	text-decoration: none;
}
</style>
</head>
<body>
	<header>
		<hgroup>
			<h1>사용자 목록</h1>
		</hgroup>
		<nav>

			<p>
		</nav>
	</header>

	<section>
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>GRADE</th>
					<th>수정</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="vo">
					<tr>
						<td>${vo.id}</td>
						<td>${vo.grade}</td>
						<td><a href="UpdateGrade.do?id=${vo.id}">수정</a></td>

					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="5">1&nbsp; &nbsp;2&nbsp; &nbsp;3&nbsp; &nbsp;4&nbsp; &nbsp;5</td>
				</tr>
			</tfoot>
		</table>
	</section>
	<p>
		<button onclick="location.href='Home.do'">HOME</button>
		<button onclick="location.href='logout.do'">로그아웃</button>
</body>
</html>
