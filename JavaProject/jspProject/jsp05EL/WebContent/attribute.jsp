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
		/* 항상 key, value 두 가지 형태로 표현된다 */
		request.setAttribute("key", "value");
		/* 가져오려면 key가 필요하다 */
		out.print(request.getAttribute("key"));
		/* 이렇게 get 방식 말고도 attribute를 부여해서 set한 value값을 보도록 할 수 있다. */

		/* 시스템에서 받는 방법 */
		System.out.println(request.getAttribute("key"));

		/* 	request.getAttribute("key")는 Object 타입, 즉 모든 것의 수퍼 클래스이다. */
		String test = (String) request.getAttribute("key");

		String[] names = new String[] { "aaaa", "bbbb" };
		request.setAttribute("names", names);

		Object obj = new Object();
		request.setAttribute("obj", obj);

		TestVO vo = new TestVO();
		request.setAttribute("vo", vo);

		List<String> list = new ArrayList<>();
		list.add("kim 1");
		list.add("kim 2");
		list.add("kim 3");
		request.setAttribute("list", list);

		List<TestVO> list2 = new ArrayList<>();
		list2.add(new TestVO());
		list2.add(new TestVO());
		list2.add(new TestVO());
		request.setAttribute("list2", list2);
	%>
	<a href="next.jsp">이전페이지</a>
	<a href="session.jsp">session.jsp</a>
	<h1>attribute.jsp</h1>

	<h1><%=test%></h1>
	<!-- param은 ?로 보낼 때 사용하는 것이고 attribute는 아무것도 안주고 자체에서 만든 것이므로 key만 알면 된다. -->
	<h1>${key}</h1>
	<!-- 배열 -->
	<h1>${names[0]},${names[1]}</h1>
	<!-- 객체를 불러올 때 여기서는 get 하지 않고 바로 쓴다. -->
	<h1>${vo.id},${vo.pw}</h1>
	<!-- list 배열 -->
	<h1>${list[0]},${list[1]}</h1>
	<!-- 객체를 받는 list 배열 -->
	<h1>${list2[0].id},${list2[0].pw}</h1>
	<h1>application : ${ autoLogin }</h1>

</body>
</html>