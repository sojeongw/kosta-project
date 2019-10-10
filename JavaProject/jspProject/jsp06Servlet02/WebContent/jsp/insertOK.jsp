<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- TestVO를 쓰기 위해 body 외부에서 import 시킨다 -->
<%@ page import="test.com.*"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <%
 	/* 
	insert.jsp에서 insertOK.jsp로 request할 때 처리에는 두 가지 방법이 있다
	get 방식 : ?id=admin
	post 방식 : no view. method = "post"라고 적으면 post 방식. 안 적거나 "get"이라고 쓰면 get방식.
			    그냥 눈으로 느끼는 것. get과는 달리 주소 뒤에 내용이 붙지 않는다.
	*/

 	// post 방식에서는 한글을 인식할 수 없어서 인식할 수 있는 코드를 넣어준다.
 	request.setCharacterEncoding("UTF-8");
 
 	
	// ?id=admin&pw=hi123456 >>> id, pw는 key  =옆에 나오는 건 value
	System.out.println(request.getParameter("id"));		// 괄호 안이 key가 된다.
	System.out.println(request.getParameter("pw"));		
	System.out.println(request.getParameter("name"));
	System.out.println(request.getParameter("tel"));
	
	TestVO vo = new TestVO();	// 자바 코딩하는 데에 집어 넣는다 : java resources
	vo.setId(request.getParameter("id")); // >> admin이 들어있는 애를 ID로 set
	
	TestDAO dao = new TestDAOimpl();
	int result = dao.insert(vo);
	if(result == 1){
		System.out.println("complete. move to select");
		// 응답 보내기
		response.sendRedirect("select.jsp");
	} else {
		System.out.println("fail. go back");
		response.sendRedirect("insert.jsp");
	}
	
	%>
</body>
</html> --%>