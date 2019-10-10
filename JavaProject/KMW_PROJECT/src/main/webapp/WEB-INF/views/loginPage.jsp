<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false" %>
<html>
<head>
	<title>Log-in Page</title>
</head>
<body>
	<h1>
	Hello programmer! Log-in here '0'
	</h1>
	
	<section>
		<form action="loginOK.do" method="post">
			<label>ID</label><input type="text" name="id" value="kmw" ></br>
			<label>PW</label><input type="text" name="pw" value="123" ></br></br>
			<input type="submit" value="로그인" >
			<input type="reset" value="reset" ></br>
		
		
		</form>
	</section>


</body>
</html>
