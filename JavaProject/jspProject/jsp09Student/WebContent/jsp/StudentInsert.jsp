<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="test.com.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insert page</title>
</head>
<body>
	<h1>Insert Page</h1>
	<jsp:include page="../StudentMenu.html"></jsp:include>
	
	<form action="StudentInsertOK.do" method="post">
		<label>Name:</label><input type="text" name="name" value="insert name"/><br>
		<label>Kor:</label><input type="text" name="kor" value="insert kor"/><br>
		<label>Eng:</label><input type="text" name="eng" value="insert eng"/><br>
		<label>Math:</label><input type="text" name="math" value="insert math"/><br>
		<input type="submit" value="submit"/><br>
	</form>
</body>
</html>