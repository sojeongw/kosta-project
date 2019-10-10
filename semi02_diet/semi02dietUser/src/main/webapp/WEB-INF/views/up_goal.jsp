<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>up_goal</title>
</head>
<body>
	<header>
		<hgroup>
			<h1>목표 수정</h1>
		</hgroup>
	</header>
	<section>
	<form action="up_goalOK.do" method="post">
	<label>목표kcal: </label><input type="text" name="goal" value="2000"/><br/>
	<input type="submit" value="OK"/>
	</form>
	</section>
</body>
</html>