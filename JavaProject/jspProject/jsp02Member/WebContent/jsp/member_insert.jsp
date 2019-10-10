<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert page</title>
</head>
<body>
	<h1>Insert Page</h1>
	
	<form action = "member_insertOK.jsp" method="post">	<!-- post는 정보 숨길때 사용 -->
	<!--  -->
	
	<label>ID : </label>
	<input type="text" name = "id" value = ""> <!-- id는 키, admin은 밸류가 됨 -->
	<br>
	
	<label>PW : </label>
	<input type="text" name = "pw" value = ""> 
	<br>
	
	<label>NAME : </label>
	<input type="text" name = "name" value = ""> 
	<br>
	
	<label>TEL : </label>
	<input type="text" name = "tel" value = ""> 
	
	<input type = "submit" value = "전송"/><br>
	
	</form>
	
<button onclick="location.href='../member_home.jsp'">홈으로</button>
</body>
</html>