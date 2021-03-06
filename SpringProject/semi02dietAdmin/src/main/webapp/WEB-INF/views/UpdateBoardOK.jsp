<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.text.*"%>

<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Board Content</title>

<link rel="stylesheet" href="resources/css/bootstrap.css">
<link rel="stylesheet" href="resources/css/switchery.min.css">
<link rel="stylesheet" href="resources/css/base.css">
<style>
#wrap {
	/* width: 971px; */
	margin: 0;
	margin-left: auto;
	margin-right: auto;
}

table {
	width: 700px;
	border-collapse: collapse;
	font-size: 12px;
	line-height: 24px;
	text-align: left;
}

table td, th {
	border: #d3d3d3 solid 1px;
	padding: 5px;
}

table th {
	background-color: #f8f8f8;
}

tfoot {
	text-align: center;
}

a {
	text-decoration: none;
}

#reg, #re, #submit, button {
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

			<div id="main" class="col-sm-offset-3 col-sm-9">
				<header>
					<h2>Q&A 게시판</h2>
				</header>
			</div>
			<div id="main" class="col-sm-offset-3 col-sm-5">

				<section>
					<table>
						<thead>
							<tr>
								<th>글번호 : ${avo.board_num}</th>
								<th>작성자 : ${avo.id}</th>
								<th>${avo.board_date}</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td colspan="3">${avo.content}</td>
							</tr>
						</tbody>
						<tfoot>
						</tfoot>
					</table>
					<br></br>
					<table>
						<thead>
							<tr>
								<th colspan="3">관리자</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>${avo.reply}</td>
							</tr>
							<tr>
								<td>
									<form action="UpdateBoardOK.do?board_num=${avo.board_num}"
										method="POST">
										<textarea cols="80" rows="10" name="reply"> </textarea>
										<br> <input type="submit" id="reg" value="등록"> <input
											type="reset" id="re" value="다시 작성">
									</form>
								</td>
							</tr>
						</tbody>
						<tfoot>

						</tfoot>

					</table>

					<br>


				</section>
			</div>
		</div>
	</div>

	<script src="resources/js/jquery-1.11.3.js"></script>
	<script src="resources/js/bootstrap.js"></script>
	<script src="resources/js/jquery.easypiechart.min.js"></script>
	<script src="https://code.highcharts.com/highcharts.js"></script>
	<script src="https://code.highcharts.com/highcharts-more.js"></script>
	<script src="resources/js/switchery.min.js"></script>
	<script src="resources/js/main.js"></script>
</body>
</html>
