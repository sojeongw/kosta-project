<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>InsertMember</title>

<link rel="stylesheet" href="resources/css/bootstrap.css">
<link rel="stylesheet" href="resources/css/base.css">
<link rel="stylesheet" href="resources/css/settings.css">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js">
	
</script>
<script>
	$(document).ready(function() {
		console.log("hi");
		$("#checkBtn").bind("click", function() {
			$.ajax({
				url : "/diet/check_id.do",
				data : {
					id : $("#id").val(),
				},
				dataType : "json",
				success : function(responseData) {
					/* $("#result").text(responseData); */
					console.log("result : " + responseData);
					if (responseData == true) {
						alert("중복된 아이디입니다");
					} else
						alert("사용할 수 있는 아이디입니다");
				}
			})
			return false;
		});
	});
</script>
<style>
#checkBtn{
position:relative;
float: center-right;
margin: 1px;

}
</style>
</head>
<body>




	<div class="container">
		<div class="row">
			<div id="profile" class="col-md-3 hidden-sm hidden-xs"></div>

			<div id="main" class="col-sm-12 col-md-6">
				<h1>회원가입</h1>

				<div class="tab-content card">
					<div role="tabpanel" class="tab-pane active" id="account-user">


						<form:form modelAttribute="mvo" action="insertMemberOK.do"
							method="POST" enctype="multipart/form-data"
							class="form-horizontal">

							<div class="form-group">
								<label class="col-sm-3 control-label">ID</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" placeholder="ID를 입력하세요"
										id="id" name="id" value="${id}">
								</div>
								<!-- <div id="result"></div> -->
								<button type="submit" id="checkBtn" class="btn btn default">중복확인</button>
							</div>

							<div class="form-group">
								<label class="col-sm-3 control-label">PW</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" name="pw" value="${pw}">
								</div>
							</div>


							<div class="form-group">
								<label class="col-sm-3 control-label">Name</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" name="name"
										value="${name}">
								</div>
							</div>



							<div class="form-group">
								<label class="col-sm-3 control-label">Age</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" name="age"
										value="${age}">
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-3 control-label">gender</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" name="gender"
										value="${gender}">
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-3 control-label">tel</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" name="tel"
										value="${tel}">
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-3 control-label">height</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" name="height"
										value="${height}">
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-3 control-label">weight</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" name="weight"
										value="${weight}">
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-3 control-label">picture</label>
								<div class="col-sm-9">
									<input type="file" name="multipartFile"><br />
								</div>
							</div>

							<div class="form-group">
								<div class="col-sm-offset-3 col-sm-9">
									<button type="submit" class="btn btn-primary">Save
										changes</button>
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>

		</div>

	</div>
</body>
</html>