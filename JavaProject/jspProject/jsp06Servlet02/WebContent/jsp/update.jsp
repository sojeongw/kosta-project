
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update page</title>
</head>
<body>
	<h1>Update Page</h1>
	<jsp:include page="../menu.html"></jsp:include>
	
	<!-- 	이제 model에서 new하는 건 다 controller로 가져간다 -->
	<%
		/* TestVO tvo = (TestVO)request.getAttribute("tvo"); 
		컨트롤러에서 주기만 하면 이거 필요없이 사용 가능*/
	%>
	
	<form action="updateOK.do" method="get">
		<!-- EL 방식으로 수정 -->
		<label>NUM:</label><span>${param.num}</span>
						<input type="hidden" name="num" value="${param.num}"/><br>
		<label>ID:</label><input type="text" name="id" value="${tvo.id}"/><br>
		<label>PW:</label><input type="text" name="pw" value="${tvo.pw}"/><br>
		<label>NAME:</label><input type="text" name="name" value="${tvo.name}"/><br>
		<label>TEL:</label><input type="text" name="tel" value="${tvo.tel}"/><br>
		<input type="submit" value="submit"/><br>
	</form>
</body>
</html>