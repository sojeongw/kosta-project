<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        
 <!DOCTYPE html>
<% 
	 String id = (String)session.getAttribute("login");
	if(id == null){
		//<script>alert("로그인 정보가 없습니다. \n로그인 화면으로 이동합니다.");</script>;
		System.out.print("로그인 정보가 없습니다. \n로그인 화면으로 이동합니다.");
		response.sendRedirect("login.do");
	} 
%>    
<html>
<head>
	<title>testPage</title>
</head>
<body>
	<h1>
	Simulate on this Page!  
	</h1>
	<section>
		<form action="testOK.do" method="post">
			<h3>  목표생산량을 입력하세요   </h3>
			<label>목표생산량</label><input type="number" name="goal" value="10" ></br>
			<h3>  우선순위를 선택해주세요   </h3>
			<dd>
				<input name="priority" type="radio" value=time>최소시간
				<input name="priority" type="radio" value=money>최소비용</br></br>
			</dd>
			<input type="submit" value="제출">
		</form>
		<a href="/kmw">이전페이지</a><br>
		<a href="selectAll.do">시뮬레이션 결과 기록 보기</a><br>
		<button onclick="location.href='logoutOK.do'">로그아웃</button>
		
	</section>
</body>
</html>
