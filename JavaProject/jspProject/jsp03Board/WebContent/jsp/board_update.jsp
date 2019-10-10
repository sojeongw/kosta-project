<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="test.com.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Page</title>
</head>
<body>
	<h1>Update Page</h1>

<% 
		boardVO vo = new boardVO();
		vo.setNum(Integer.parseInt(request.getParameter("num")));

		boardDAO dao = new boardDAOimpl();
		// 번호만 받았으니까 이 vo를 받아서 새로운 vo에 해당 값을 넣어주는 것
		boardVO bvo = dao.selectOne(vo);
	%> 


	<form action="board_updateOK.jsp" method="post">
	
	<label>NUM : </label><span><%= request.getParameter("num") %></span>
	<input type="hidden" name="num" value ="<%= request.getParameter("num") %>"><br>
	
	<label>TITLE : </label>
	<input type="text" name="title" value ="<%= bvo.getTitle() %>"><br>	
	
	<label>CONTENT : </label>
	<input type="text" name="content" value ="<%= bvo.getContent() %>"><br>	

	<label>WRITER : </label>
	<input type="text" name="writer" value ="<%= bvo.getWriter() %>"><br>
	

		<br>
		<input type="submit" value="글수정" />

	</form>





</body>
</html>