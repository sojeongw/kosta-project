<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <!DOCTYPE html>
<% 
	 String id = (String)session.getAttribute("login");
	if(id == null){
		//<script>alert("로그인 정보가 없습니다. \n로그인 화면으로 이동합니다.");</script>;
		System.out.print("로그인 정보가 없습니다. \n로그인 화면으로 이동합니다.");
		response.sendRedirect("login.do");
	} 
%>
<html>
<head>
	<title>resultPage</title>
</head>
<body>
	<h1>
	Our recommendation for you!
	</h1>
	
	
	<a href="test.do">이전페이지</a><br>
	<button onclick="location.href='logoutOK.do'">로그아웃</button>
</body>
</html>
