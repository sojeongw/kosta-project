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

		studentVO vo = new studentVO();
		studentDAO dao = new studentDAOimpl();

		vo.setNum(Integer.parseInt(request.getParameter("num")));
		vo.setName(request.getParameter("name"));
		vo.setKor(Integer.parseInt(request.getParameter("kor")));
		vo.setEng(Integer.parseInt(request.getParameter("eng")));
		vo.setMath(Integer.parseInt(request.getParameter("math")));
		vo.setTotal(vo.getKor() + vo.getEng() + vo.getMath());
		vo.setAvg((double) vo.getTotal() / 3);

		String grade = "";
		if (vo.getAvg() >= 90) {
			grade = "A";
		} else if (vo.getAvg() >= 80) {
			grade = "B";
		} else if (vo.getAvg() >= 70) {
			grade = "C";
		} else {
			grade = "D";
		}
		vo.setGrade(grade);

		int result = dao.update(vo);

		if(result == 1){
			System.out.println("Update is completed");
			response.sendRedirect("student_selectAll.jsp");
		}else{
			System.out.println("Update is failed");
			response.sendRedirect("student_update.jsp");
		}
	%>

	<button onclick="location.href='../student_home.jsp'">홈으로</button>
</body>
</html>