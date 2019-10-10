<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insert page</title>
</head>
<body>
	<h1>Insert Page</h1>
	<jsp:include page="StudentMenu.jsp"></jsp:include>
	
	<form action="StudentInsertOK.do" method="post">
		<label>Name:</label><input type="text" name="name" value="insert name"/><br>
		<label>Kor:</label><input type="number" name="kor" value="100"/><br>
		<label>Eng:</label><input type="number" name="eng" value="100"/><br>
		<label>Math:</label><input type="number" name="math" value="100"/><br>
		<input type="submit" value="submit"/><br>
	</form>
</body>
</html>