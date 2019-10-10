<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<style>
#wrap{
	width: 971;
	margin:0;
	margin-left: auto;
	margin-right: auto;
}
table{	
	width: 60%;
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
</style>
</head>
<body>
	<header>
		<h1>Q&A 게시판</h1>
	</header>
	
	 <p>
	<section>
		<table>
			<thead>
				<tr>
					<th>번호</th>
					<th>내용</th>
					<th>등록일</th>
					<th>작성자</th>
					<th>삭제</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${list}" var="vo">
					<tr>
						<td><%-- <a href="UpdateBoard.do?num=${vo.num}"> --%>${vo.num}<!-- </a> --></td>
						<td><a href="BoardContent.do?num=${vo.num}">${vo.content}</a></td>
						<td>${vo.reg_date}</td>
						<td>${vo.writer}</td>
						<td><a href="DeleteBoard.do?num=${vo.num}">삭제</a></td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
			<tr>
			<td colspan="5">1&nbsp; &nbsp;2&nbsp; &nbsp;3&nbsp; &nbsp;4&nbsp; &nbsp;5</td>
			</tr>
			</tfoot>
		</table>
		<br>
		 <button onclick="location.href='Home.do'">HOME</button>
		  <button onclick="location.href='logout.do'">로그아웃</button>
	</section>

</body>
</html>
