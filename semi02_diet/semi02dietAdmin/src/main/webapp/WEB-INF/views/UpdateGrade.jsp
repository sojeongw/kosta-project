<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<style type="text/css">
.form
input {
	font-family: "Roboto", sans-serif;
	outline: 0;
	background: #f2f2f2;
	width: 100%;
	border: 0;
	margin: 0 0 15px;
	padding: 15px;
	box-sizing: border-box;
	font-size: 14px;
}

.login-page {
	width: 360px;
	padding: 8% 0 0;
	margin: auto;
}

.form {
	position: relative;
	z-index: 1;
	background: #FFFFFF;
	max-width: 360px;
	margin: 0 auto 100px;
	padding: 45px;
	text-align: left;
	box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0
		rgba(0, 0, 0, 0.24);
}

button {
	font-family: "Roboto", sans-serif;
	outline: 0;
	background: #f2f2f2;
	width: 100%;
	border: 0;
	margin: 0 0 0px;
	padding: 15px;
	box-sizing: border-box;
	font-size: 14px;
}

.form submit {
	font-family: "Roboto", sans-serif;
	text-transform: uppercase;
	outline: 0;
	background: #4CAF50;
	width: 100%;
	border: 0;
	padding: 15px;
	color: #FFFFFF;
	font-size: 14px;
	-webkit-transition: all 0.3 ease;
	transition: all 0.3 ease;
	cursor: pointer;
}

.form button:hover, .form button:active, .form
button:focus {
	background: #dadada;
}

.form .message {
	margin: 15px 0 0;
	color: #b3b3b3;
	font-size: 12px;
}

.form .message a {
	color: #4CAF50;
	text-decoration: none;
}

.form .register-form {
	display: none;
}

.container {
	position: relative;
	z-index: 1;
	max-width: 300px;
	margin: 0 auto;
}

.container:before, .container:after {
	content: "";
	display: block;
	clear: both;
}

.container .info {
	margin: 50px auto;
	text-align: left;
}

.container .info h1 {
	margin: 0 0 15px;
	padding: 0;
	font-size: 36px;
	font-weight: 300;
	color: #1a1a1a;
}

.container .info span {
	color: #4d4d4d;
	font-size: 12px;
}

.container .info span a {
	color: #000000;
	text-decoration: none;
}

.container .info span .fa {
	color: #EF3B3A;
}

body {
	background: #76b852; /* fallback for old browsers */
	background: -webkit-linear-gradient(right, #76b852, #8DC26F);
	background: -moz-linear-gradient(right, #76b852, #8DC26F);
	background: -o-linear-gradient(right, #76b852, #8DC26F);
	background: linear-gradient(to left, #76b852, #8DC26F);
	font-family: "Roboto", sans-serif;
	-webkit-font-smoothing: antialiased;
	-moz-osx-font-smoothing: grayscale;
}

button {
	font-family: "Roboto", sans-serif;
	outline: 0;
	background: #f2f2f2;
	width: 70px;
	border: 0;
	margin: auto;
	padding: 5px;
	box-sizing: border-box;
	font-size: 11px;
}

input[type=submit] {
	font-family: "Roboto", sans-serif;
	outline: 0;
	background: #7dbb5a;
	width: 100%;
	border: 0;
	margin: 0 0 0px;
	padding: 15px;
	box-sizing: border-box;
	font-size: 14px;
}
</style>
</head>
<body>

	<!-- <h1>Update Grade</h1> -->
	<div class="login-page">
		<div class="form">
			<button onclick="location.href='Home.do'">HOME</button>
			<p>
			<form action="UpdateGradeOK.do" method="post">
				<label>ID </label><span><%-- ${mvo.id} --%></span> <input type="text"
					name="id" value="${mvo.id}" /><br> <label>Grade </label><input
					type="text" name="grade" value="${mvo.grade}" />
				<p>
					<input type="submit" value="전송"><br>
			</form>
			</form>
		</div>
</body>

</html>
