
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
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

#wrap{
	width: 971px;
	margin:0;
	margin-left: auto;
	margin-right: auto;
}
table{	
	width: 70%;
	border-collapse: collapse;
	font-size: 12px;
	line-height: 24px;
}
table td, th{
	border: #d3d3d3 solid 1px;
	padding: 5px;
	text-align: center;
}
table th{
	background-color: #f8f8f8;
}
tfoot{
	text-align: center;
}
a{
	text-decoration:none;
}
h1{
font-family: "Roboto", sans-serif;
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
				<th>PW</th>
				<th>NAME</th>
				<th>AGE</th>
				<th>GENDER</th>
				<th>TEL</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="vo">
				<tr>
					<td><a href="UpdateMember.do?id=${vo.id}">${vo.id}</a></td>
					<td>${vo.pw}</td>
					<td>${vo.name}</td>
					<td>${vo.age}</td>
					<td>${vo.gender}</td>
					<td>${vo.tel}</td>
					<td><a href="DeleteMemberOK.do?id=${vo.id}">삭제</a></td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="7">목록</td>
			</tr>
		</tfoot>
	</table>
	<p>
		<button onclick="location.href='./AdminHome.do'">BACK</button>
			 <button onclick="location.href='logout.do'">로그아웃</button>
	</section>
</body>
</html>
