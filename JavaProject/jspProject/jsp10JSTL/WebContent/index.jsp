<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!-- c, m, fmt, sql, fn은 tag가 된다. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSTL</h1>
	<!-- 콜론을 이용해 사용	 -->
	<!-- setAttribute한 것과 같은 효과. 자바 코딩이 안 들어가도 갖다 쓸 수 있도록 만듦. -->
	<!-- scope를 설정하지 않으면 page scope이다. 즉, 이 페이지 안에서만 쓸 수 있다. -->
	<c:set var="name" value="KIM"></c:set>
	<c:set var="pw" value="hi123456" scope="session"></c:set>
	${name}
	
	<!-- 바로 출력하는 법 = out.print -->
	<c:out value="aaaa"></c:out>
	<c:out value="${name}"></c:out>
	
	<!-- if test="조건연산" -->
	<c:if test="${name=='LEE'}">
		<h1>LEE님</h1> 하이
	</c:if>
	<c:if test="${name=='KIM'}">
		<h1>KIM님</h1> 하이
	</c:if>
	
	<c:choose>
		<c:when test="${name=='KIM'}">
			<h1>KIM</h1>님 하이
		</c:when>
		<c:otherwise>
			로그인하세요
		</c:otherwise>
	</c:choose>
	
	<!-- 5을 포함해 반복 >> 6개 반복하게 됨 -->
	<c:forEach begin="0" end="5" step="1" var="i" varStatus="x">
		안녕하세요 ${i} ${x.index}
	</c:forEach>
	

</body>
</html>