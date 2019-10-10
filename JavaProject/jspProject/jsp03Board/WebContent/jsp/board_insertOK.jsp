<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="test.com.*"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert Page</title>
</head>
<body>
	<h1>InsertOK Page</h1>
	<%
		request.setCharacterEncoding("UTF-8");

		// System.out.println(request.getParameter("num"));
		// System.out.println(request.getParameter("title"));
		// System.out.println(request.getParameter("content"));
		// System.out.println(request.getParameter("writer"));
		// System.out.println(request.getParameter("reg_date"));

		boardVO vo = new boardVO();

		vo.setNum(99);
		vo.setTitle(request.getParameter("title"));
		vo.setContent(request.getParameter("content"));
		vo.setWriter(request.getParameter("writer"));
		//vo.setReg_Date(request.getParameter("insert_regDate"));
		vo.setReg_Date(new Date());

		boardDAO dao = new boardDAOimpl();
		int result = dao.insert(vo);

		if(result == 1){
			System.out.println("result : insert completed");
			response.sendRedirect("board_selectAll.jsp");
		} else {
			System.out.println("result : insert failed");
			response.sendRedirect("board_insert.jsp");
		}
	%>

	<button onclick="location.href='../board_home.jsp'">홈으로</button>
</body>
</html>