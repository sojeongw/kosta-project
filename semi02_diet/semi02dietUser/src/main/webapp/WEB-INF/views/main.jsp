<%@page import="test.semi.diet.UserController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
</head>
<body>
	<header>
		<hgroup>
			<h1>Select One</h1>
		</hgroup>
	</header>
	<label>달리기: </label><br/>${run_kcal} <input type="hidden" name="run_kcal" value="${run_kcal}"/>kcal <br/>
	<br/><label>자전거: </label><br/>${bycicle_kcal}<input type="hidden" name="bycicle_kcal" value="${bycicle_kcal}"/>kcal <br/>
	<br/><label>줄넘기: </label><br/>${rope_kcal}<input type="hidden" name="rope_kcal" value="${rope_kcal}"/>kcal <br/><br/>
	<label>총 kcal: </label><br/>${run_kcal+bycicle_kcal+rope_kcal}kcal<br/><br/>
	<form action="selectAll.do" method="GET">
		<input type="submit" value="기록 조회"/>
	</form>
	<form action="selectSportsOK.do" method="post">
		<input type="submit" value="update kcal"/>
	</form>
	<form action="up_goal.do" method="post">
		<input type="submit" value="목표 수정"/>
	</form>
	<form action="BoardList.do" method="GET">
		<input type="submit" value="QnA 게시판"/>
	</form>
	<form action="up_info.do" method="post">
		<input type="submit" value="정보 수정"/>
	</form>

</body>
</html>