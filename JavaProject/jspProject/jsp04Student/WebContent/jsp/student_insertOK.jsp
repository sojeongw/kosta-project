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

		studentVO vo = new studentVO();

		vo.setNum(99);
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

		studentDAO dao = new studentDAOimpl();
		int result = dao.insert(vo);

		if(result == 1){
			System.out.println("result : insert completed");
			response.sendRedirect("student_selectAll.jsp");
		} else {
			System.out.println("result : insert failed");
			response.sendRedirect("student_insert.jsp");
		}
	%>

	<button onclick="location.href='../student_home.jsp'">홈으로</button>
</body>
</html>