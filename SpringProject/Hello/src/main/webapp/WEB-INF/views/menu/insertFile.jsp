<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>menu</title>
</head>
<body>
	<header>
		<hgroup>
			<h1>메뉴입력페이지</h1>
		</hgroup>
		<nav>
			<jsp:include page="topMenu.jsp"></jsp:include>
		</nav>
	</header>
	<section>
		<!-- 이걸 쓰면 더 편리하게 사용할 수 있음 -->
		<h2>uploadForm.jsp</h2>
		<!-- 전송해서 보낼 때 이 타입을 통째로 어떤 오브젝트에 보낼 건데 그 이름을 tvo로 하겠다. 반드시 메소드는 post -->
		<form:form modelAttribute="tvo" action="insertFileOK.do" method="post"
			enctype="multipart/form-data">
		<!-- 파일 전송할 때는 꼭 이걸로 설정해줘야 한다 --!>
		<!-- 이렇게 해줘야 이미지와 텍스트가 같이 온다. -->
		
		comment<input type="text" name="name" value="yangssem">
			<br />
		comment<input type="text" name="tel" value="010">
		<!-- multipartFile이라는 파일 전송 >> VO에 넣어준다. -->
			<br /> file<input type="file" name="multipartFile">
			<br />
			<!-- 전송 버튼 생성 -->
			<input type="submit" value="전송">
		</form:form>
	</section>

</body>
</html>