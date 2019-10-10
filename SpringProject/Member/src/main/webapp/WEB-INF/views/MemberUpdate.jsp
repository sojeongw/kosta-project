
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="test.com.spring04Member.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update page</title>
</head>
<body>
	<h1>Update Page</h1>
	<jsp:include page="MemberMenu.jsp"></jsp:include>
	
	<form action="MemberUpdateOK.do" method="get">
		<!-- EL 방식으로 수정 -->
		<label>NUM:</label><span>${param.num}</span>
						<input type="hidden" name="num" value="${param.num}"/><br>
		<label>ID:</label><input type="text" name="id" value="${mvo.id}"/><br>
		<label>PW:</label><input type="text" name="pw" value="${mvo.pw}"/><br>
		<label>NAME:</label><input type="text" name="name" value="${mvo.name}"/><br>
		<label>TEL:</label><input type="text" name="tel" value="${mvo.tel}"/><br>
		<input type="submit" value="submit"/><br>
	</form>
</body>
</html>