<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update page</title>

</head>
<body>
	<h1 id="title01">Update Page</h1>
	<!--  -->

	<form action = "updateOK.jsp" method="post">	<!-- post는 정보 숨길때 사용 -->
	<!--  -->
	
	<label>NUM : </label>
	<input type="text" name = "num" value = "99"> <!-- id는 키, admin은 밸류가 됨 -->
	<br>
	
	<!-- test할 때 하는 방법 >>> 값은 못 바꾸면서 num으로 넘겨줄 수는 있음 -->
	<label>NUM : </label><span>99</span>
	<input type="hidden" name="num" value="99"> <!-- id는 키, admin은 밸류가 됨 -->
	<br>
	
	<!-- 변수 받아서 처리하기 -->
	<label>NUM : </label><span><%= request.getParameter("num") %></span>
	<input type="hidden" name="num" value="<%= request.getParameter("num") %>"/> <!-- id는 키, admin은 밸류가 됨 -->
	<br>
	
	<label>ID : </label>
	<input type="text" name="id" value="admin"> <!-- id는 키, admin은 밸류가 됨 -->
	<br>
	<!-- 
	<input type="text" name = "id" id="pw" value = "admin">  
	로 하면 name은 서버용이고 id="pw"는 자바 스크립트용
	-->
	
	<label>PW : </label>
	<input type="text" name="pw" value="hi123456"> 
	<br>
	
	<label>NAME : </label>
	<input type="text" name="name" value="kim"> 
	<br>
	
	<label>TEL : </label>
	<input type="text" name="tel" value="010"> 
	
	<input type="submit" value="전송"/><br>
	
	</form>
</body>
</html>