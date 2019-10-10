<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="test.com.spring03.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insert page</title>
</head>
<body>
	<h1>Insert Page</h1>
	<jsp:include page="BoardMenu.jsp"></jsp:include>
	
	<form action="BoardInsertOK.do" method="post">
		<label>Title:</label><input type="text" name="title" value="insert title"/><br>
		<label>Content:</label><input type="text" name="content" value="insert content"/><br>
		<label>Writer:</label><input type="text" name="writer" value="insert writer"/><br>
		<input type="submit" value="submit"/><br>
	</form>
</body>
</html>