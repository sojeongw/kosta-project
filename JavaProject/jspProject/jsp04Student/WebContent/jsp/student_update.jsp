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
		studentVO vo = new studentVO();
		vo.setNum(Integer.parseInt(request.getParameter("num")));

		studentDAO dao = new studentDAOimpl();
		// 번호만 받았으니까 이 vo를 받아서 새로운 vo에 해당 값을 넣어주는 것
		studentVO svo = dao.selectOne(vo);
	%> 


	<form action="student_updateOK.jsp" method="post">
	
	<label>Num : </label><span><%= request.getParameter("num") %></span>
	<input type="hidden" name="num" value ="<%= request.getParameter("num") %>"><br>
	<br>
	<label>Name : </label>
	<input type="text" name="name" value ="<%= svo.getName() %>"><br>	
	<br>
	<label>Kor : </label>
	<input type="text" name="kor" value ="<%= svo.getKor() %>"><br>	
	<br>
	<label>Eng : </label>
	<input type="text" name="eng" value ="<%= svo.getEng() %>"><br>
	<br>
	<label>Math : </label>
	<input type="text" name="math" value ="<%= svo.getMath() %>"><br>
	<br>
	
	

		<br>
		<input type="submit" value="글수정" />

	</form>





</body>
</html>