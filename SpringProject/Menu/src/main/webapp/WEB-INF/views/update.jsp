<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset=UTF-8">
<title>menu</title>
</head>
<body>

	<header>
	<hgroup>
		<h1>메뉴 수정 페이지</h1>
	</hgroup>
	<nav>
	<jsp:include page="topMenu.jsp"></jsp:include>
	</nav>
	</header>
	
	<section>
		<form action="updateOK.do" method="post">
		<label>num : </label>${mvo.num}<input type="hidden" name="num" value="${mvo.num}"/><br>
		<label>menu </label><input type="text" name="menu" value="${mvo.menu}"/><br>
		<!-- 숫자는 number -->
		<label>price </label><input type="number" name="price" value="${mvo.price}"/><br>
		<label>store </label><input type="text" name="store" value="${mvo.store}"/><br>
		<label>kcal </label><input type="number" name="kcal" value="${mvo.kcal}"/><br>
		<input type="submit" value="submit"/>
		<input type="reset" value="cancel"/>
		</form>	</section>


</body>
</html>