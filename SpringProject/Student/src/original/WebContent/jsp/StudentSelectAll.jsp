<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
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
	<jsp:include page="../StudentMenu.html"></jsp:include>
	<!-- 컨텐츠는 섹션에 넣는다 -->
	<section>
	<table border="1">
		<thead>
			<tr>
				<th>Num</th>
				<th>Name</th>
				<th>Kor</th>
				<th>Eng</th>
				<th>Math</th>
				<th>Total</th>
				<th>Avg</th>
				<th>Grade</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<%
				List<StudentVO> list = (ArrayList<StudentVO>)request.getAttribute("list");
				for (int i = 0; i < list.size(); i++) {
				
				%>
				<td><%= list.get(i).getNum() %></td>
				<td><a href="StudentUpdate.do?num=<%= list.get(i).getNum() %>"><%= list.get(i).getName() %></a></td>
				<td><%= list.get(i).getKor() %></td>
				<td><%= list.get(i).getEng() %></td>
				<td><%= list.get(i).getMath() %></td>
				<td><%= list.get(i).getTotal() %></td>
				<td><%= list.get(i).getAvg() %></td>
				<td><%= list.get(i).getGrade() %></td>
				<td><a href="StudentDeleteOK.do?num=<%= list.get(i).getNum() %>">delete</a></td>
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
</html> --%>