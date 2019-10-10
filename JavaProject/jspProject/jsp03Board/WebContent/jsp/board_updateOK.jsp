<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="test.com.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Page</title>
</head>
<body>

	<h1>Update Page</h1>
	<%
		request.setCharacterEncoding("UTF-8");

		System.out.println(request.getParameter("num"));
		System.out.println(request.getParameter("title"));
		System.out.println(request.getParameter("content"));
		System.out.println(request.getParameter("writer"));
		// System.out.println(request.getParameter("reg_date"));

		boardVO vo = new boardVO();
		boardDAO dao = new boardDAOimpl();

		vo.setNum(Integer.parseInt(request.getParameter("num")));
		vo.setTitle(request.getParameter("title"));
		vo.setContent(request.getParameter("content"));
		vo.setWriter(request.getParameter("writer"));
		vo.setReg_Date(new Date());

		int result = dao.update(vo);

		if(result == 1){
			System.out.println("Update is completed");
			response.sendRedirect("board_selectAll.jsp");
		}else{
			System.out.println("Update is failed");
			response.sendRedirect("board_update.jsp");
		}
	%>

	<button onclick="location.href='../board_home.jsp'">홈으로</button>
</body>
</html>