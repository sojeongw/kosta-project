<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Dashboard</title>
<link rel="stylesheet" href="resources/css/bootstrap.css">
<link rel="stylesheet" href="resources/css/switchery.min.css">
<link rel="stylesheet" href="resources/css/base.css">
<!--  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css"> -->
<link rel="stylesheet" href="resources/demos/style.css">
<link rel="stylesheet" href="resources/css/tab.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	$(function() {
		$("#tabs").tabs();
	});
</script>
</head>
<body>
	<!--     <div class="loading"> -->
	<!--     </div> -->
	<nav class="navbar navbar-fixed-top">
		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-3 top-left-menu">
					<div class="navbar-header">
						<a class="navbar-brand">
							<h1>Add</h1>
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
	
	        <div id="side-menu" class="col-sm-3 hidden-xs" data-spy="affix" data-offset-top="0">
          <div class="profile-block">
            <img src="resources/uploadimg/${profile_pic}" width="100" class="img-circle">
            <h4 class="profile-title"> ${name} <small> @ ${id}</small></h4>
          </div>

          <ul class="nav nav-pills nav-stacked">
        
            <li>
              <a href="main.do" class="transition">
                <span class="glyphicon glyphicon-home" aria-hidden="true"></span>
                Home
              </a>
            </li>
            
            <li>
              <a href="#finances-opts" class="transition" role="button" data-toggle="collapse" aria-expanded="false" aria-controls="finances-opts">
                <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                Updates 
                <span class="glyphicon glyphicon-menu-left pull-right transition" aria-hidden="true"></span>
              </a>
              <ul class="collapse list-unstyled" id="finances-opts">
                <li>
                  <a href="up_info.do" class="transition">
                    Profile 
                  </a>
                </li>
                <li>
                  <a href="up_goal.do" class="transition">
                    Goal
                  </a>
                </li>
              </ul>
            </li>
            <li>
              <a href="#projects-opts" class="transition" role="button" data-toggle="collapse" aria-expanded="false" aria-controls="projects-opts">
                <span class="glyphicon glyphicon-road" aria-hidden="true"></span>
                Sports
                <span class="glyphicon glyphicon-menu-left pull-right transition" aria-hidden="true"></span>
              </a>
              <ul class="collapse list-unstyled" id="projects-opts">
                <li>
                  <a href="selectSports.do" class="transition">
                    Add
                  </a>
                </li>
                <li>
                  <a href="selectAll.do" class="transition">
                    Records
                  </a>
                </li>
              </ul>
            </li>

            <li><a href='BoardList.do?cpage=1' class="transition">
                <span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span>
							Board
					</a></li>

           
            <li class="nav-divider"></li>
                        <li>
              <a href="logout.do" class="transition">
                <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                Log-out
                <span class="badge pull-right"></span>
              </a>
            </li>
          </ul>
        </div>
	
	
	<div id="main" class="col-sm-offset-3 col-sm-9">
		<div id="tabs">
			<ul>
				<li><a href="updateRunning.do">달리기</a><br></li>
				<li><a href="updateBicycle.do">자전거</a><br></li>
				<li><a href="updateRope.do">줄넘기</a></li>
			</ul>
			<div id="tabs-1">
				<p></p>
			</div>
			<div id="tabs-2">
				<p></p>
			</div>
			<div id="tabs-3">
				<p></p>
			</div>
		</div>



</div>
</div>
	</div>
	
<!--     <script src="resources/js/jquery-1.11.3.js"></script> -->
    <script src="resources/js/bootstrap.js"></script>

    <!-- Bootstrap 4 CDN JS -->
    <!-- <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha/js/bootstrap.min.js" integrity="sha256-+h0g0j7qusP72OZaLPCSZ5wjZLnoUUicoxbvrl14WxM= sha512-0z9zJIjxQaDVzlysxlaqkZ8L9jh8jZ2d54F3Dn36Y0a8C6eI/RFOME/tLCFJ42hfOxdclfa29lPSNCmX5ekxnw==" crossorigin="anonymous"></script> -->

    <script src="resources/js/main.js"></script>
</body>
</html>