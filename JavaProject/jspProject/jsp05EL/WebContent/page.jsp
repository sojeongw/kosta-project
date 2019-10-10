<%@page import="test.com.TestVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="test.com.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		pageContext.setAttribute("title", "EL test");
	%>
	<a href="next.jsp">이전페이지</a>
	<h1>page.jsp</h1>
	이 페이지를 넘어가면 안 나오는, 가장 좁은 범위
	<h1>pageContext : ${ title }</h1>


</body>
</html>