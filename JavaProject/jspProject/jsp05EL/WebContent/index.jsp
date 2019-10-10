<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>index.jsp</h1>
	<h1>EL(Expression Language)</h1>
	<div>$중괄호블럭 HTML안에서 스크립트릿테그없이 사용</div>
	<div>각종 내장객체를 좀더 편리하게 사용할 수 있고</div>
	<div>연산식도 사용할수 있으며</div>
	<div>JSTL(Java Standard Tag Library) 과도 호환된다.</div>
	<div>JSP 내장객체는 객체를 생성하지 않고 바로 쓸수있도록 정의된 객체</div>
	<div>JSP 내장객체의 예 : request,response,session,out...</div>
	
	<a href="next.jsp?name=kim&tel=010">다음페이지</a>
	<!-- session에 저장되었기 때문에 session.jsp에서 만든 것도 출력이 된다. -->
	<h1>session : ${ id }</h1>
	<h1>application : ${ autoLogin }</h1>
</body>
</html>
