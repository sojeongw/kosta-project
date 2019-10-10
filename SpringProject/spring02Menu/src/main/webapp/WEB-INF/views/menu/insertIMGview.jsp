<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>INSERT image view PAGE</title>
</head>
<body>
	<h1>INSERT image view PAGE ${param.img}</h1>
	<img src="resources/uploadimg/${param.img}" width="600" />
	<!-- 공백으로 두면 원본 사이즈로 나옴 -->

	</hgroup>
	<nav> <jsp:include page="topMenu.jsp"></jsp:include> </nav>
	</header>

	<section>
	<table>
		<thead>
			<tr>
				<th>num</th>
				<th>menu</th>
				<th>price</th>
				<th>store</th>
				<th>kcal</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="vo">
				<tr>
					<td><a href="update.do?num=${vo.num}">${vo.num}</a></td>
					<td>${vo.menu}</td>
					<td>${vo.price}</td>
					<td>${vo.store}</td>
					<td>${vo.kcal}</td>
					<td><a href="deleteOK.do?num=${vo.num}">삭제</a></td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="6">1 2 3 4 5</td>
			</tr>
		</tfoot>
	</table>
	</section>
</body>
</html>