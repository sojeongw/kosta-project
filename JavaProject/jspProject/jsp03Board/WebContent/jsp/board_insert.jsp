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
	<nav><button onclick="location.href='../board_home.jsp'">home</button>
<button onclick="location.href='../board_index.jsp'">index</button></nav>
<br>
</hgroup></header>
	
	<form action = "board_insertOK.jsp" method="post">	<!-- post는 정보 숨길때 사용 -->
	<!--  -->
	
<!-- 	<label>Num : </label> -->
<!-- 	<input type="text" name = "num" value = "99"/>  -->
	
	<label>Title : </label>
	<input type="text" name = "title" value = "hello"/> <!-- id는 키, admin은 밸류가 됨 -->
	
	<label>Content : </label>
	<input type="text" name = "content" value = "what's up"/> 
	
	<label>Writer : </label>
	<input type="text" name = "writer" value = "kim"/> 
	
<!-- 	<label>Reg_Date : </label> -->
<!-- 	<input type="text" name = "reg_date" value = "2017-08-09"> -->
	
	<input type = "submit" value = "등록"/><br>
	
	</form>
	

</body>
</html>