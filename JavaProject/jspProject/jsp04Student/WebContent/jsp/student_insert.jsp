<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert page</title>


</head>
<body>
<header><hgroup>
	<h1>Insert Page</h1>
	<nav><button onclick="location.href='../student_home.jsp'">home</button>
<button onclick="location.href='../student_index.jsp'">index</button></nav>
<br>
</hgroup></header>
	
	<form action = "student_insertOK.jsp" method="post">	<!-- post는 정보 숨길때 사용 -->
	<!--  -->
	
<!-- 	<label>Num : </label> -->
<!-- 	<input type="text" name = "num" value = "99"/>  -->
	
	<label>Name : </label>
	<input type="text" name = "name" value = "kim"/> <!-- id는 키, admin은 밸류가 됨 -->
	<br>
	<label>Kor : </label>
	<input type="text" name = "kor" value = "100"/> 
	<br>
	<label>Eng : </label>
	<input type="text" name = "eng" value = "100"/> 
	<br>
	<label>Math : </label>
	<input type="text" name = "math" value = "100"/> 
	<br>
	
	<input type = "submit" value = "등록"/><br>
	
	</form>
	

</body>
</html>