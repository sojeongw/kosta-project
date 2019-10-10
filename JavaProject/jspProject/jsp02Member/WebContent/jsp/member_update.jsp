<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="test.com.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Update Page</h1>

	<%
		TestVO vo = new TestVO();
		vo.setNum(Integer.parseInt(request.getParameter("num")));

		TestDAO dao = new TestDAOimpl();
		// 번호만 받았으니까 이 vo를 받아서 새로운 vo에 해당 값을 넣어주는 것
		TestVO tvo = dao.selectOne(vo);
	%>


	<form action="member_updateOK.jsp" method="post">
		<!-- post는 정보 숨길때 사용 -->
		<!--  -->

		<!-- 변수 받아서 처리하기 -->
		<label>NUM : </label><span><%=request.getParameter("num")%></span> <input
			type="hidden" name="num" value="<%=request.getParameter("num")%>" />
		<!-- id는 키, admin은 밸류가 됨 -->
		<br> <label>ID : </label> <input type="text" name="id"
			value="<%=tvo.getId()%>">
		<!-- id는 키, admin은 밸류가 됨 -->
		<br> <label>PW : </label> <input type="text" name="pw"
			value="<%=tvo.getPw()%>"> <br> <label>NAME : </label>
		<input type="text" name="name" value="<%=tvo.getName()%>"> <br>
		<label>TEL : </label> <input type="text" name="tel" value="<%= tvo.getTel() %>">
		<input type="submit" value="전송" /><br>

	</form>





</body>
</html>