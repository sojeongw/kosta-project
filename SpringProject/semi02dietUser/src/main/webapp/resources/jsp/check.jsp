<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%
	String id = request.getParameter("id");
	System.out.println("check.jsp : " + id);
	if ("admin".equals(id)) {
		out.print("중복된 아이디 입니다.");
	} else {
		out.print("사용할 수 있는 아이디 입니다.");
	}
%>
