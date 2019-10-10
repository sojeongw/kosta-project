<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="test.com.*" %>
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

System.out.println(request.getParameter("id"));
System.out.println(request.getParameter("pw"));
System.out.println(request.getParameter("name"));
System.out.println(request.getParameter("tel"));

TestVO vo = new TestVO();
TestDAO dao = new TestDAOimpl();

vo.setNum(Integer.parseInt(request.getParameter("num")));
vo.setId(request.getParameter("id"));
vo.setPw(request.getParameter("pw"));
vo.setName(request.getParameter("name"));
vo.setTel(request.getParameter("tel"));

int result = dao.update(vo);

if(result == 1){
	System.out.println("Update is completed");
	response.sendRedirect("member_selectAll.jsp");
}else{
	System.out.println("Update is failed");
	response.sendRedirect("member_update.jsp");
}


%>

<button onclick="location.href='../member_home.jsp'">홈으로</button>
</body>
</html>