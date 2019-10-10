<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<style>
#wrap{
	width: 971px;
	margin:0;
	margin-left: auto;
	margin-right: auto;
}
table{	
	width: 100%;
	border-collapse: collapse;
	font-size: 12px;
	line-height: 24px;
	text-align: left;
}
table td, th{
	border: #d3d3d3 solid 1px;
	padding: 5px;
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
</style>
</head>
<body>
	<h1>테스트용 게시글 작성 페이지</h1>

	<section>
		<table>
			<thead>
				<tr>
					<th>작성자 : ${bvo.writer}</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<form action="InsertBoardOK.do" method="POST">
					<td><textarea cols="80" rows="10" name="content"> </textarea></td>
				</tr>
			</tbody>
			<tfoot>
			</tfoot>
		</table>
		<br>
			<input type="submit" value="등록">
			<input type="reset"	value="다시 작성">
		</form>
	</section>

</body>
</html>
