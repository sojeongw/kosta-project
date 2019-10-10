
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="test.com.spring03.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update page</title>
</head>
<body>
	<h1>Update Page</h1>
	<jsp:include page="BoardMenu.jsp"></jsp:include>
	
	<!-- 	이제 model에서 new하는 건 다 controller로 가져간다 -->
	<%
		// MemberVO mvo = (MemberVO)request.getAttribute("mvo"); 
		/* 컨트롤러에서 주기만 하면 이거 필요없이 사용 가능*/
	%>
	
	<form action="BoardUpdateOK.do" method="get">
		<!-- EL 방식으로 수정 -->
		<label>NUM:</label><span>${param.num}</span>
						<input type="hidden" name="num" value="${param.num}"/><br>
		<label>Title:</label><input type="text" name="title" value="${bvo.title}"/><br>
		<label>Content:</label><input type="text" name="content" value="${bvo.content}"/><br>
		<label>Writer:</label><input type="text" name="writer" value="${bvo.writer}"/><br>
		<input type="submit" value="submit"/><br>
	</form>
</body>
</html>