<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login member</title>
</head>
<body>
	<header>
		<hgroup>
			<h1>회원 로그인</h1>
		</hgroup>
		<nav>
			<jsp:include page="topMenu.jsp"></jsp:include>
		</nav>
	</header>
	<section>
	<form action="loginOK.do" method="post">
	<label>id: </label><input type="text" name="id" value="1"/><br/>
	<label>pw: </label><input type="text" name="pw" value="1"/><br/>
	<input type="submit" value="OK"/>
	</form>
	</section>
</body>
</html>