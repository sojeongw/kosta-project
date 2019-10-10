<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.text.*"%>

<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Dashboard</title>

<link rel="stylesheet" href="resources/css/bootstrap.css">
<link rel="stylesheet" href="resources/css/switchery.min.css">
<link rel="stylesheet" href="resources/css/base.css">
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
#submit{
background:#337ab7;
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
	background: #1b1e24;
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
	background: -webkit-linear-gradient(right, #1b1e24, #1b1e24);
	background: -moz-linear-gradient(right, #1b1e24, #1b1e24);
	background: -o-linear-gradient(right, #1b1e24, #1b1e24);
	background: linear-gradient(to left, #1b1e24, #1b1e24);
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
<nav class="navbar navbar-fixed-top">
		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-3 top-left-menu">
					<div class="navbar-header">
						<a class="navbar-brand">
							<h1>BOARD</h1>
						</a>

						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse" data-target="#nav-menu"
							aria-expanded="false">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
					</div>
					<a href="#" data-toggle="tooltip" data-placement="bottom"
						data-delay="500" title="Refresh data"
						class="header-refresh pull-right"> <span
						class="glyphicon glyphicon-repeat" aria-hidden="true"></span>
					</a>
				</div>

				<div id="nav-menu" class="collapse navbar-collapse pull-right">

				</div>
			</div>
		</div>
	</nav>

	<div class="container-fluid">
		<div class="row">
			<div id="side-menu" class="col-sm-3 hidden-xs" data-spy="affix"
				data-offset-top="0">
				<div class="profile-block">
					<img src="resources/uploadimg/${profile_pic}" width="100"
						class="img-circle">
					<h4 class="profile-title">
						${name} <small> @ ${id}</small>
					</h4>
				</div>



				<ul class="nav nav-pills nav-stacked">

					<li><a href="main.do" class="transition"> <span
							class="glyphicon glyphicon-home" aria-hidden="true"></span> Home
					</a></li>

					<li><a href="#finances-opts" class="transition" role="button"
						data-toggle="collapse" aria-expanded="false"
						aria-controls="finances-opts"> <span
							class="glyphicon glyphicon-user" aria-hidden="true"></span>
							Updates <span
							class="glyphicon glyphicon-menu-left pull-right transition"
							aria-hidden="true"></span>
					</a>
						<ul class="collapse list-unstyled" id="finances-opts">
							<c:if test="${se_id=='admin'}">
								<li><a href="MemberList.do?cpage=1" class="transition">
										Member List </a></li>

							</c:if>

							<li><a href="GradeList.do" class="transition"> Grade
									List </a></li>
						</ul></li>


					<li><a href='BoardList.do?cpage=1' class="transition"> <span
							class="glyphicon glyphicon-list-alt" aria-hidden="true"></span>
							Board
					</a></li>

					<li class="nav-divider"></li>
					<li><a href="logout.do" class="transition"> <span
							class="glyphicon glyphicon-user" aria-hidden="true"></span>
							Log-out <span class="badge pull-right"></span>
					</a></li>
				</ul>
			</div>
<div class="login-page">
	<div class="form">
	<form action="UpdateMemberOK.do" method="post">
	
		<label>ID<%--  : ${bvo.id} --%> </label><input type="text" name="id" value="${bvo.id}" /><br>
		<label>PW</label><input type="text" name="pw" value="${bvo.pw}" /><br>
		<label>AGE</label><input type="text" name="age" value="${bvo.age}" /><br>
		<label>GENDER</label><input type="text" name="gender" value="${bvo.gender}" /><br>
		<label>NAME</label><input type="text" name="name" value="${bvo.name}" /><br> 
		<label>TEL</label><input type="text" name="tel" value="${bvo.tel}" /><p> 
		<input type="submit" value="전송"><br>
	</form>
	</div>
	</div>





				<script src="resources/js/jquery-1.11.3.js"></script>
				<script src="resources/js/bootstrap.js"></script>
				<script src="resources/js/jquery.easypiechart.min.js"></script>
				<script src="https://code.highcharts.com/highcharts.js"></script>
				<script src="https://code.highcharts.com/highcharts-more.js"></script>
				<script src="resources/js/switchery.min.js"></script>
	
</body>
</html>
