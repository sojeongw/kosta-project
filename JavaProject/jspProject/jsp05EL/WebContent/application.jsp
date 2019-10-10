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
		/* id set하기 */
		session.setAttribute("autoLogin","true");
	
		/* id 지우기 */
		// session.removeAttribute("id");
		
		/* inactive하면 session을 끝내는 sec을 설정 */
		session.setMaxInactiveInterval(10);
	%>
	<a href="next.jsp">이전페이지</a>
	<h1>application.jsp</h1>
	<h1>application : ${ autoLogin }</h1>


</body>
</html>