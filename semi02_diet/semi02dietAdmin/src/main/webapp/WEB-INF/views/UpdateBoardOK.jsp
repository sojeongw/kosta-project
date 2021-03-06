<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<style>
#wrap {
	width: 971px;
	margin: 0;
	margin-left: auto;
	margin-right: auto;
}

table {
	width: 100%;
	border-collapse: collapse;
	font-size: 12px;
	line-height: 24px;
	text-align: left;
}

table td, th {
	border: #d3d3d3 solid 1px;
	padding: 5px;
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
	<h1>지대 옙흔 게시물-_-^</h1>

	<section>
		<table>
			<thead>
				<tr>
					<th>글번호 : ${avo.num}</th>
					<th>작성자 : ${avo.writer}</th>
					<th>${avo.reg_date}</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td colspan="3">${avo.content}</td>
				</tr>
			</tbody>
			<tfoot>
			</tfoot>
		</table>
		<br></br>
		<table>
			<thead>
				<tr>
					<th colspan="3">관리자</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${avo.reply}</td>
				</tr>
				<tr>
					<td>
						<form action="UpdateBoardOK.do?num=${avo.num}" method="POST">
							<textarea cols="80" rows="10" name="reply"> </textarea>
							<br> <input type="submit" value="등록"> <input
								type="reset" value="다시 작성">
						</form>
					</td>
				</tr>
			</tbody>
			<tfoot>

			</tfoot>

		</table>

		<br> 
		<form action="BoardList.do" method="get">
			<input type="submit" value="글목록">
		</form>


	</section>

</body>
</html>
