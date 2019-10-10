<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update walking</title>
</head>
<body>
	<header>
		<hgroup>
			<h1>달리기</h1>
		</hgroup>
	</header>
	<section>
	<form action="updateRunningOK.do" method="post">
	<input type="text" name="minute" value="30"/><label>분 </label><br/>
	<input type="text" name="meter" value="100"/><label>m </label><br/>
	<input type="submit" value="OK"/>
	</form>
	</section>
</body>
</html>