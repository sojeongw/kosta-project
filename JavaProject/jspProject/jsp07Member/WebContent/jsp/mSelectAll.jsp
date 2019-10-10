<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="test.com.model.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Select Page</title>

</style>

</head>
<body>
	<h1>select page</h1>
	<jsp:include page="../mMenu.html"></jsp:include>
	<!-- 컨텐츠는 섹션에 넣는다 -->
	<section>
	<table border="1">
		<thead>
			<tr>
				<th>Num</th>
				<th>ID</th>
				<th>Password</th>
				<th>Name</th>
				<th>Tel</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<%
				List<MemberVO> list = (ArrayList<MemberVO>)request.getAttribute("list");
				for (int i = 0; i < list.size(); i++) {
				
				%>
				<td><%= list.get(i).getNum() %></td>
				<td><a href="mUpdate.do?num=<%= list.get(i).getNum() %>"><%= list.get(i).getId() %></a></td>
				<td><%= list.get(i).getPw() %></td>
				<td><%= list.get(i).getName() %></td>
				<td><%= list.get(i).getTel() %></td>
				<td><a href="mDeleteOK.do?num=<%= list.get(i).getNum() %>">delete</a></td>
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