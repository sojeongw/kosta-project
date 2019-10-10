<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update rope</title>
</head>
<body>
	<header>
		<hgroup>
			<h1></h1>
		</hgroup>
	</header>
	<section>
	<form action="updateRopeOK.do" method="post">
	<input type="text" name="minute" value="30"/><label>분</label><br/>
	<input type="text" name="count" value="200"/><label>횟수</label><br/>
	<input type="submit" value="OK"/>
	</form>
	</section>
</body>
</html>