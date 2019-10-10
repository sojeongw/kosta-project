<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update bycicle</title>
</head>
<body>
	<header>
		<hgroup>
			<h1>자전거</h1>
		</hgroup>
	</header>
	<section>
	<form action="updateBycicleOK.do" method="post">
	<input type="text" name="minute" value="60"/><label>분 </label><br/>
	<input type="text" name="meter" value="300"/><label>m </label><br/>
	<input type="submit" value="OK"/>
	</form>
	</section>
</body>
</html>