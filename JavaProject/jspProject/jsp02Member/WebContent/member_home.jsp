<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


<!-- title과 /head 사이에 CSS 정의 -->
<style type="text/css">
body {
	background-color: gray;
}
h1{
	color: white;
}
</style>

<script type="text/javascript">
	console.log("hello javascript");	// 브라우저 콘솔에서 보임
</script>

</head>
<body>
	<h1>Home Page</h1>
	
	<button onclick="location.href='./jsp/insert.jsp'">회원가입</button>
	<button onclick="location.href='./jsp/update.jsp'">정보수정</button>
	<button onclick="location.href='./jsp/delete.jsp'">정보삭제</button>
	<button onclick="location.href='./jsp/selectAll.jsp'">회원목록</button>


</body>
</html>