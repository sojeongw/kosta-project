<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<!-- jQuery ��ġ 2 : CDN -->
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js">

</script>
<script>
	$(document).ready(function() {
		$("button").click(function() {
			$("#result").load("resources/jsp/check.jsp", {
				userid : $("#userid").val()
			});
		});
	});
</script>
</head>
<body>
	���̵�
	<input type="text" name="userid" id="userid">
	<button>�ߺ�üũ</button>
	<span id="result"></span>
</body>
</html>

</html>