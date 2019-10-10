<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="test.com.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert Page</title>
</head>
<body>
	<h1>Insert Page</h1>
	<% 
request.setCharacterEncoding("UTF-8");

System.out.println(request.getParameter("id"));
System.out.println(request.getParameter("pw"));
System.out.println(request.getParameter("name"));
System.out.println(request.getParameter("tel"));

TestVO vo = new TestVO();
vo.setId(request.getParameter("id"));
vo.setPw(request.getParameter("pw"));
vo.setName(request.getParameter("name"));
vo.setTel(request.getParameter("tel"));

TestDAO dao = new TestDAOimpl();
int result = dao.insert(vo);

if(result == 1){
	System.out.println("result : insert completed");
	response.sendRedirect("member_selectAll.jsp");
} else {
	System.out.println("result : insert failed");
	response.sendRedirect("member_insert.jsp");
}

%>

<button onclick="location.href='../home.jsp'">홈으로</button>
</body>
</html>