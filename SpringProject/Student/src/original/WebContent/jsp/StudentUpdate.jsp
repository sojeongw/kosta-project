<%-- 
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="test.com.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update page</title>
</head>
<body>
	<h1>Update Page</h1>
	<jsp:include page="../StudentMenu.html"></jsp:include>

	<!-- 	이제 model에서 new하는 건 다 controller로 가져간다 -->
	<%
		// MemberVO mvo = (MemberVO)request.getAttribute("mvo"); 
		/* 컨트롤러에서 주기만 하면 이거 필요없이 사용 가능*/
	%>

	<form action="StudentUpdateOK.do" method="get">
		<!-- EL 방식으로 수정 -->
		<label>Num: </label><span>${param.num}</span> <input type="hidden"
			name="num" value="${param.num}" /><br> 
		<label>Name: </label><span>${svo.name}</span>
		<input type="hidden" name="name" value="${svo.name}" /><br>
		<label>Name:</label><input type="text" name="name" value="${svo.name}"/><br>
		<label>Kor: </label><input type="text" name="kor" value="${svo.kor}" /><br>
		<label>Eng: </label><input type="text" name="eng" value="${svo.eng}" /><br>
		<label>Math: </label><input type="text" name="math" value="${svo.math}" /><br>
		<input type="submit" value="submit" /><br>
	</form>
</body>
</html> --%>