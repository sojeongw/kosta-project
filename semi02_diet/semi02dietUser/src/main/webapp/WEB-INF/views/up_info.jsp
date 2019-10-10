<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update member</title>
</head>
<body>
	<header>
		<hgroup>
			<h1>회원정보수정</h1>
		</hgroup>
		<nav>
			<jsp:include page="topMenu.jsp"></jsp:include>
			
		</nav>
	</header>
	<section>
	<form action="up_infoOK.do" method="post">
	<label>id: </label>${id}<input type="hidden" name="id" value="${id}" /><br/>
	<label>pw: </label><input type="text" name="pw" value="${pw}"/><br/>
	<label>name: </label><input type="text" name="name" value="${name}"/><br/>
	<label>age: </label><input type="text" name="age" value="${age}"/><br/>
	<label>gender: </label><input type="text" name="gender" value="${gender}"/><br/>
	<label>tel: </label><input type="text" name="tel" value="${tel}"/><br/>
	<label>height: </label><input type="text" name="height" value="${height}"/><br/>
	<label>weight: </label><input type="text" name="weight" value="${weight}"/><br/>
	<input type="submit" value="OK"/>
	</form>
	</section>
</body>
</html>