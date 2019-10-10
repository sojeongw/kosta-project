<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>next.jsp</h1>
	<a href="index.jsp">이전페이지</a>
	<a href="attribute.jsp">attribute</a>
	
	<%-- <%= %> : expression tag. 반드시 이걸 써야할 경우가 있다. 굳이 쓸 일이 없으면 EL 사용 --%>
	<%= request.getParameter("name") %>
	<% System.out.println(request.getParameter("name")); %>
	<% out.print(request.getParameter("name")); %>
	
	<!-- 더 간단한 방법. 에러 아님. null이라면 비어있는 텍스트로 받는다. -->
	<!-- null 때문에 에러가 나는 코딩이어도 얘는 자동으로 빈 텍스트로 나오니까 에러가 발생하지 않는다 -->
	${param.name}	
	${param.tel}
	
	<!-- request는 딱 그때 값을 받지 않으면 나오지 않는다. 이 문제를 해결하는데 session과 application이 사용된다. -->
	<h1>${key}</h1>
	<!-- session에 저장되었기 때문에 session.jsp에서 만든 것도 출력이 된다. -->
	<h1>session : ${ id }</h1>
	<h1>application : ${ autoLogin }</h1>
	
</body>
</html>