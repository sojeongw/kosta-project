<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="test.com.*"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Select Page</title>

<style type="text/css">
body {
	background-color: #ffff55;
}
/* title이라는 클래스를 가진 모든 애들에 적용 */
.title {
	color: #00ff00;
}

/* 각자 적용 */

/* #title01{
color: #ff0000;
}
#title02{
color: #0000ff;
} */

/* 이렇게 hgroup을 이용해 정확히 명시해서 지정해줄 수도 있다. hgroup안에 있는 title이라는 의미 >> 굳이 id가 없어도 다르게 분류할 수 있게 됨. */
hgroup.title {
	
}

/* select1이 여러 개 있는데 특정 클래스의 select1을 바꾸고 싶을 때 */
.title.select1 {
	color: #00ffff;
}

/* 주석을 풀면 밑에 있는 게 우선이 된다. */
/* id는 #, class는 .으로 표현된다 */
</style>

</head>
<body>
	<!-- header가 hgroup안에 들어가면 header들만 모아놨다고 명시적으로 써주는 것. 안 적어도 문제없지만 적는 걸 권장한다. -->
	<header> <hgroup>
	<h1 id="title01" class="title">Select Page 1</h1>
	</hgroup> <!-- title select1 이렇게 띄어쓰기로 구분해줘야 한다 -->
	<h3 id="title02" class="title select1">Select Page 2</h3>
	<!-- 동일한 id 존재 불가. class는 굳이 동일하지 않아도 된다. 클래스로는 묶여도 아이디는 별도일 수 있다. -->

	<!-- 버튼은 내비게이션 기능을 하기 때문에 헤더에서 nav 안에 집어 넣는다. --> <nav> <!-- 버튼 같은 걸 태그 또는 element라고 부른다. -->
	<button onclick="location.href='../index.jsp'">INDEX</button>
	<!-- 사이에 내용이 있다 = 바디가 있다 -->
	<button onclick="location.href='./insert.jsp'">회원가입</button>
	</nav> </header>

	<!-- 컨텐츠는 섹션에 넣는다 -->
	<section>
	<table border="1">
		<thead>
			<!-- tr은 row을 뜻하며 무조건 들어간다 -->
			<tr>
				<!-- header엔 th -->
				<th>NUM</th>
				<th>ID</th>
				<th>PW</th>
				<th>NAME</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<!-- db에 자료가 3개면 tr이 3개 생기면 된다 >>> 반복문 사용 -->
			<%
				TestDAO dao = new TestDAOimpl();
				TestVO vo = new TestVO();
				List<TestVO> list = dao.selectAll();

				for (int i = 0; i < list.size(); i++) {
			%>
			<tr>
				<!-- body엔 td -->
				<!-- 그냥 집어넣으면 text가 되어버리기 때문에 변수로 만들어준다. -->
				<!-- 하이퍼링크 : a에 get방식 ?num=88을  update.jsp가 받는다. -->
				<td><%= list.get(i).getNum() %></td>
				<td><a href="update.jsp?num=<%= list.get(i).getNum() %>"><%= list.get(i).getId() %></a></td>
				<td><%= list.get(i).getPw() %></td>
				<td><%= list.get(i).getName() %></td>
				<td><%= list.get(i).getTel() %></td>
				<td><a href="deleteOK.jsp?num=<%= list.get(i).getNum() %>">삭제</a></td>
			</tr>
			<%
				}
			%>
			<!-- 반복문이 필요한 부분까지 표시 >>> 블럭이 여기서 끝나야 한다. -->
		</tbody>
		<tfoot>
			<tr>
				<!-- 몇 개를 합칠거냐 = colspan >> 여러 개 중복으로 쓰지 않아도 된다 -->
				<td colspan="5">tfoot</td>
			</tr>
		</tfoot>
	</table>




	</section>



	<table>

	</table>

</body>
</html>