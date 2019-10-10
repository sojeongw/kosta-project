<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="test.com.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Delete Page</title>
</head>
<body>

	<h1>Delete Page</h1>
	<%
		System.out.println(request.getParameter("num"));

		boardVO vo = new boardVO();
		boardDAO dao = new boardDAOimpl();
		
		vo.setNum(Integer.parseInt(request.getParameter("num")));
		int result = dao.delete(vo);
		
		if(result == 1){
			System.out.println("delete is completed");
			response.sendRedirect("board_selectAll.jsp");
		}else{
			System.out.println("delete is failed");
			response.sendRedirect("board_delete.jsp");
		}
		
	%>
	<button onclick="location.href='../board_home.jsp'">홈으로</button>
</body>
</html>