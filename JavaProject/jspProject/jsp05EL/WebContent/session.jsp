<%@page import="test.com.TestVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="test.com.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		/* 버튼이나 링크에 담아 줘야 그 정보를 얻어낼 수 있었다. 즉 요청이 있어야 할 수 있었다.
		그런데 요청하지 않았는데도 다른 곳에서 저장한 값을 가져오고 싶은 경우가 있다.
		그럴 때는 조금 더 범위가 넓은 곳에 저장을 한다. = scope
		적용할 수 있는 범위를 지정해주는데 가장 협소한 범위는 잘 쓰진 않지만 page라는 것이 있다. 이 페이지에서만 쓰는 것.
		그 다음이 이 페이지와 요청한 페이지에서 쓸 수 있는 게 request
		근데 다른 곳에서도 쓰고 싶다면 범위가 더 넓어야 한다. 그건 browser에 저장한다.
		닫았다가 열면 저장한게 없어지지만 browser를 닫지 않으면 그 정보를 계속 유지시켜주는 것.
		마치 로그인 한 번 해놓으면 닫기 전까지는 유지 되는 것. 이게 session을 이용한 것이다.
		application은 창을 닫아도 정보를 저장할 수 있게끔 해주는 것. 자주 쓰이지는 않는다.
		자주 쓰이는 것은 request와 session이다.
		*/
		/* id set하기 */
		session.setAttribute("id","admin");
	
		/* id 지우기 */
		// session.removeAttribute("id");
		
		/* inactive하면 session을 끝내는 sec을 설정 */
		session.setMaxInactiveInterval(5);
		
		out.println("session : "+session.getAttribute("id")+"	");
		out.println("application : "+application.getAttribute("autoLogin"));
		
		%>
	<a href="next.jsp">이전페이지</a>
	<h1>session.jsp</h1>
	<!-- session에 저장되었기 때문에 session.jsp에서 만든 것도 출력이 된다. -->
	<h1>session : ${ id }</h1>
	<h1>application : ${ autoLogin }</h1>
	
<!-- 	session과 application은 자기가 잘 구분해서 만들어야 한다. 이름에서 표시를 해주면 쉽다. -->


</body>
</html>