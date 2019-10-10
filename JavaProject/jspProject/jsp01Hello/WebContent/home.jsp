<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//scriptlet Tag : JSP의 필수 아이템. 이제 자바 코딩 가능

	System.out.println("home.jsp"); // 서버 콘솔창에서만 찍힌다.
	out.println("home.jsp"); // 창에서 찍힌다. ln은 의미가 없다. 테스트용이라 별 의미 없다.
	out.println("<h1>home jsp</h1>"); // 태그 자체 출력 가능
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- DTD : html 버전 4.01에 맞추겠다. -->

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 안에 내용이 없으면(=단독이면) /로 닫아주지 않는다. 적게된다면 charset=UTF-8"/> -->

<title>Insert title here</title>

<!-- title과 /head 사이에 CSS 정의 -->
<style type="text/css">
body {
	background-color: pink;
}
h1{
	color: red;
}
</style>

<script type="text/javascript">
	console.log("hello javascript");	// 브라우저 콘솔에서 보임
</script>

</head>
<body>
	<h1>home jsp</h1>
	
	<!-- ./은 현재 이 문서가 있는 현재 경로를 상대적으로 의미하고 ../는 위에 있는 parent 경로 -->
	<!-- ../../는 위에 위에 있는 경로 -->
	<button onclick="location.href='./jsp/insert.jsp'">회원가입</button>
	<button onclick="location.href='./jsp/delete.jsp'">정보삭제</button>
	<button onclick="location.href='./jsp/update.jsp'">정보수정</button>
	<button onclick="location.href='./jsp/select.jsp'">회원목록</button>
     yangssem
	<!-- out.println("home.jsp");과 같은 효과 -->

	<label>이름 : </label>
	<span>yangssem</span>
	<!-- 띄어쓰기는 아무리 많이 해도 하나만 인식한다. -->
</body>
</html>