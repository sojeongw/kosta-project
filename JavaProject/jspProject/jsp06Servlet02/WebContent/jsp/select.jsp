<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="test.com.model.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Select Page</title>


</head>
<body>
	<h1>select page</h1>
	<jsp:include page="../menu.html"></jsp:include>
	<!-- 컨텐츠는 섹션에 넣는다 -->
	<section>
	<table border="1">
		<thead>
			<tr>
				<th>NUM</th>
				<th>ID</th>
				<th>PW</th>
				<th>NAME</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<!-- db에 자료가 3개면 tr이 3개 생기면 된다 >>> 반복문 사용 -->
			<%
			/* 	TestDAO dao = new TestDAOimpl();
				TestVO vo = new TestVO();
				List<TestVO> list = dao.selectAll(); 
				얘네는 controller에서 하니까 여긴 필요없음. 콜만 하면 된다 >> 캐스팅 필요*/
				List<TestVO> list = (ArrayList<TestVO>)request.getAttribute("list");
				for (int i = 0; i < list.size(); i++) {
			%>
			<tr>
				<!-- body엔 td -->
				<!-- 그냥 집어넣으면 text가 되어버리기 때문에 변수로 만들어준다. -->
				<!-- 하이퍼링크 : a에 get방식 ?num=88을  update.jsp가 받는다. -->
				<td><%= list.get(i).getNum() %></td>
				<td><a href="update.do?num=<%= list.get(i).getNum() %>"><%= list.get(i).getId() %></a></td>
				<td><%= list.get(i).getPw() %></td>
				<td><%= list.get(i).getName() %></td>
				<td><%= list.get(i).getTel() %></td>
				<td><a href="deleteOK.do?num=<%= list.get(i).getNum() %>">delete</a></td>
			</tr>
			<%
				}
			%>
		</tbody>
		<tfoot>
			<tr>
				<!-- 몇 개를 합칠거냐 = colspan >> 여러 개 중복으로 쓰지 않아도 된다 -->
				<td colspan="5">tfoot</td>
			</tr>
		</tfoot>
	</table>




	</section>



	<table>

	</table>

</body>
</html>