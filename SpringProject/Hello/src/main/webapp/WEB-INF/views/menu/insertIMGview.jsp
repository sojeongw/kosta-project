<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>INSERT image view PAGE</title>
</head>
<body>
	<h1>INSERT image view PAGE ${param.img}</h1>
	<img src="resources/uploadimg/${param.img}" width="600"/>
										<!-- 공백으로 두면 원본 사이즈로 나옴 -->
</body>
</html>