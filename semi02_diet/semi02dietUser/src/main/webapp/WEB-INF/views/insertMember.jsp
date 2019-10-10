<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insert member</title>
</head>
<body>
	<header>
		<hgroup>
			<h1>회원정보입력</h1>
		</hgroup>
		<nav>
			<jsp:include page="topMenu.jsp"></jsp:include>
			
		</nav>
	</header>
	<section>
	<form action="insertMemberOK.do" method="post">
	<label>id: </label><input type="text" name="id" value="dong1123"/><br/>
	<label>pw: </label><input type="text" name="pw" value="hi123456"/><br/>
	<label>name: </label><input type="text" name="name" value="kim"/><br/>
	<label>age: </label><input type="text" name="age" value="25"/><br/>
	<label>gender: </label><input type="text" name="gender" value="man"/><br/>
	<label>tel: </label><input type="text" name="tel" value="010"/><br/>
	<label>height: </label><input type="text" name="height" value="175"/><br/>
	<label>weight: </label><input type="text" name="weight" value="75"/><br/>
	<label>goal: </label><input type="text" name="goal" value="2500"/><br/>
	<input type="submit" value="OK"/>
	</form>
	</section>
</body>
</html>