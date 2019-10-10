<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<meta charset="UTF-8">
	<title>Home</title>
</head>
<body>
<h1>test</h1>

<P>  The time on the server is ${serverTime}. </P>
<c:out value="spring"></c:out>
<c:out value="${serverTime}"></c:out>
</body>
</html>
