<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home Page</title>
<style type = "text/css">
body{
background-color : yellow;
}

/* #title01{ */
/* background-color : black; */
/* } */
</style>
</head>
<body>

<header><hgroup>
<h1 id="title01" class="title">Home Page</h1>
<nav>
</nav>
</hgroup></header>

<section>
<button onclick="location.href='./jsp/student_insert.jsp'">성적입력</button>
<button onclick="location.href='./jsp/student_update.jsp'">성적수정</button>
<button onclick="location.href='./jsp/student_delete.jsp'">성적삭제</button>
<button onclick="location.href='./jsp/student_selectAll.jsp'">성적목록</button>
</section>


</body>
</html>