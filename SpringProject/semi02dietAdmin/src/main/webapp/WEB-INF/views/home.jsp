<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Landing page</title>

<script src="resources/home/js/jquery-1.11.3.js"></script>
<script src="resources/home/js/bootstrap.js"></script>
<!-- <script src="resources/home/js/main.js"></script> -->

<script type="text/javascript">
	$(document).ready(function() {
		console.log("ddddd");

		$('#sign-btn').on('click', function(e) {
			console.log("ddddd1");
			$(e.currentTarget).closest('ul').hide();
			$('form#signin_user').fadeIn('fast');
		});

		$('#admin-btn').on('click', function(e) {
			console.log("ddddd2");
			$(e.currentTarget).closest('ul').hide();
			$('form#signin_admin').fadeIn('fast');
		});
	});
</script>

<style type="text/css">
label {
	color: white;
}
</style>

<link rel="stylesheet" href="resources/home/css/bootstrap.css">
<link rel="stylesheet" href="resources/home/css/base.css">

<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>
	<!-- <header>
		<div class="container">
			row 1
			<div class="row">
				<a class="brand pull-left" href="landing_page.html">Company name</a>
				<ul class="list-inline list-unstyled pull-right">
					<li><a href="#about">About</a></li>
					<li><a href="#features">Features</a></li>
					<li><a href="#pricing">Pricing</a></li>
					<li><a href="contact.html">Contact</a></li>
				</ul>
			</div>
		</div>
	</header> -->

	<section id="intro-header">
		<div class="container">
			<!-- row 2 -->
			<div class="row">
				<div class="wrap-headline">
					<h1 class="text-center">Diet Management Program</h1>
					<!--  <h2 class="text-center">Tagline message</h2> -->
					<hr>
					<ul class="list-inline list-unstyled text-center">
						<li><a id="sign-btn" class="btn btn-default btn-lg" href="#"
							role="button">USER</a></li>
						<li><a id="admin-btn" class="btn btn-primary btn-lg" href="#"
							role="button">ADMIN</a></li>
					</ul>

					<!-- USER sign in form -->
					<form action="http://localhost:8090/diet/loginOK.do" method="post" id="signin_user"
						class="form-inline text-center hidden-element">
						<!-- <input type="radio" name="radio01" id="radio_user" value="radio_user" checked> <label
							for="radio-1">USER</label>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" name="radio01" id="radio_admin" value="radio_admin"> <label
							for="radio-2">ADMIN</label>
						<p> -->
						<h2 class="text-center">User Page</h2>
						<div class="form-group">
							<div class="input-group">
								<div class="input-group-addon">ID</div>
								<input type="text" class="form-control" id="id" name="id" placeholder="id">
							</div>
						</div>
						<div class="form-group">
							<div class="input-group">
								<div class="input-group-addon">PW</div>
								<input type="password" class="form-control" id="pw" name="pw"
									placeholder="pw">
							</div>
						</div>
						<button type="submit" value="OK" class="btn btn-default">Sign
							in</button>
					</form>

					<!-- ADMIN sign in form -->
					<form id="signin_admin" action="http://localhost:8090/admin/loginOK.do" method="post" 
						class="form-inline text-center hidden-element">
						<h2 class="text-center">Admin Page</h2>
						<div class="form-group">
							<div class="input-group">
								<div class="input-group-addon">ID</div>
								<input type="text" class="form-control" id="id" placeholder="id" name="id">
							</div>
						</div>
						<div class="form-group">
							<div class="input-group">
								<div class="input-group-addon">PW</div>
								<input type="password" class="form-control" id="pw" name="pw"
									placeholder="pw">
							</div>
						</div>
						<button type="submit" value="OK" class="btn btn-default">Sign
							in</button>
						</form>

				</div>
			</div>
		</div>
	</section>

</body>
</html>
