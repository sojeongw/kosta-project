<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Delete Page</h1>
<form action = "member_deleteOK.jsp" method="post">	<!-- post는 정보 숨길때 사용 -->
	<!--  -->
	
	
<label>NUM : </label><span><%= request.getParameter("num") %></span>
	<input type="hidden" name="num" value="<%= request.getParameter("num") %>"/> <!-- id는 키, admin은 밸류가 됨 -->
	<br>
	
	<input type = "submit" value = "삭제"/><br>
	
	</form>
	
</body>
</html>