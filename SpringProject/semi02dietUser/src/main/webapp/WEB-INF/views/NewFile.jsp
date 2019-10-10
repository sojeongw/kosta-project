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
	<a href="http://unicorn-ui.com/" class="button button-tiny">Go</a>
  <a href="http://unicorn-ui.com/" class="button button-rounded button-tiny">Go</a>
  <a href="http://unicorn-ui.com/" class="button button-pill button-tiny">Go</a>
  <button class="button button-square button-tiny"><i class="fa fa-plus"></i></button>
  <button class="button button-box button-tiny"><i class="fa fa-plus"></i></button>
  <button class="button button-circle button-tiny"><i class="fa fa-plus"></i></button>
  
  <a href="http://unicorn-ui.com/" class="button button-primary button-small">Go</a>
  <a href="http://unicorn-ui.com/" class="button button-primary button-rounded button-small">Go</a>
  <a href="http://unicorn-ui.com/" class="button button-primary button-pill button-small">Go</a>
  <button class="button button-primary button-square button-small"><i class="fa fa-plus"></i></button>
  <button class="button button-primary button-box button-small"><i class="fa fa-plus"></i></button>
  <button class="button button-primary button-circle button-small"><i class="fa fa-plus"></i></button>
  
  <a href="http://unicorn-ui.com/" class="button button-action">Go</a>
  <a href="http://unicorn-ui.com/" class="button button-action button-rounded">Go</a>
  <a href="http://unicorn-ui.com/" class="button button-action button-pill">Go</a>
  <button class="button button-action button-square"><i class="fa fa-plus"></i></button>
  <button class="button button-action button-box"><i class="fa fa-plus"></i></button>
  <button class="button button-action button-circle"><i class="fa fa-plus"></i></button>
  
  <a href="http://unicorn-ui.com/" class="button button-highlight button-large">Go</a>
  <a href="http://unicorn-ui.com/" class="button button-highlight button-rounded button-large">Go</a>
  <a href="http://unicorn-ui.com/" class="button button-highlight button-pill button-large">Go</a>
  <button class="button button-highlight button-square button-large"><i class="fa fa-plus"></i></button>
  <button class="button button-highlight button-box button-large"><i class="fa fa-plus"></i></button>
  <button class="button button-highlight button-circle button-large"><i class="fa fa-plus"></i></button>
  
  <a href="http://unicorn-ui.com/" class="button button-caution button-jumbo">Go</a>
  <a href="http://unicorn-ui.com/" class="button button-caution button-rounded button-jumbo">Go</a>
  <a href="http://unicorn-ui.com/" class="button button-caution button-pill button-jumbo">Go</a>
  <button class="button button-caution button-square button-jumbo"><i class="fa fa-plus"></i></button>
  <button class="button button-caution button-box button-jumbo"><i class="fa fa-plus"></i></button>
  <button class="button button-caution button-circle button-jumbo"><i class="fa fa-plus"></i></button>
  
  <a href="http://unicorn-ui.com/" class="button button-royal button-giant">Go</a>
  <a href="http://unicorn-ui.com/" class="button button-royal button-rounded button-giant">Go</a>
  <a href="http://unicorn-ui.com/" class="button button-royal button-pill button-giant">Go</a>
  <button class="button button-royal button-square button-giant"><i class="fa fa-plus"></i></button>
  <button class="button button-royal button-box button-giant"><i class="fa fa-plus"></i></button>
  <button class="button button-royal button-circle button-giant"><i class="fa fa-plus"></i></button>



</body>
</html>
