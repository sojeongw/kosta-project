<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Web App</title>

    <link rel="stylesheet" href="resources/css/bootstrap.css">
    <link rel="stylesheet" href="resources/css/base.css">
    <link rel="stylesheet" href="resources/css/settings.css">
  </head>
  <body>
   
   
       <!-- navigation bar -->
    <nav class="navbar navbar-fixed-top">
      <div class="container-fluid">
        <div class="row">
          <div class="col-sm-3 top-left-menu">
            <div class="navbar-header">
              <a class="navbar-brand">
                <h1>Update</h1>
              </a>

              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#nav-menu" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
            </div>
            <a href="#" data-toggle="tooltip" data-placement="bottom" data-delay="500" title="Refresh data" class="header-refresh pull-right">
              <span class="glyphicon glyphicon-repeat" aria-hidden="true"></span>
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

            <li>
             <li><a href='BoardList.do?cpage=1' class="transition">
                <span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span>
							Board
					</a></li>

            </li>
           
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
   
   
  
   

    <div class="container">
      <div class="row">
        <div id="profile" class="col-md-3 hidden-sm hidden-xs">

        </div>

        <div id="main" class="col-sm-12 col-md-6">


        <div class="tab-content card">
          <div role="tabpanel" class="tab-pane active" id="account-user">
       
       
            <form:form modelAttribute="mvo" action="up_infoOK.do" method="POST"
 		enctype="multipart/form-data" class="form-horizontal">
              
               <div class="form-group">
                <label class="col-sm-3 control-label">ID</label>
                <div class="col-sm-9">${id}
                  <input type="hidden" class="form-control" name="id" value="${id}">
                </div>
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
                  <input type="text" class="form-control" name="name" value="${name}">
                </div>
              </div>
              
              
              
              <div class="form-group">
                <label class="col-sm-3 control-label">Age</label>
                    <div class="col-sm-9">
                    <input type="text" class="form-control" name="age" value="${age}">
                  </div>    
                </div>
     
              <div class="form-group">
                <label class="col-sm-3 control-label">gender</label>
                <div class="col-sm-9">
                  <input type="text" class="form-control" name ="gender" value="${gender}">
                </div>
              </div>
     
              <div class="form-group">
                <label class="col-sm-3 control-label">tel</label>
                <div class="col-sm-9">
                  <input type="text" class="form-control" name="tel" value="${tel}">
                </div>
              </div>
     
                <div class="form-group">
                <label class="col-sm-3 control-label">height</label>
                <div class="col-sm-9">
                  <input type="text" class="form-control" name="height" value="${height}">
                </div>
              </div>
     
               <div class="form-group">
                <label class="col-sm-3 control-label">weight</label>
                <div class="col-sm-9">
                  <input type="text" class="form-control" name="weight" value="${weight}">
                </div>
              </div>
     
              <div class="form-group">
                <label class="col-sm-3 control-label">picture</label>
                <div class="col-sm-9">
                 <input type="file" name="multipartFile"><br/>
                </div>
              </div>
 
              <div class="form-group">
                <div class="col-sm-offset-3 col-sm-9">
                  <button type="submit" class="btn btn-primary">
                    Save changes
                  </button>
                </div>
              </div>
            </form:form> 
          </div>
	</div>
        </div>

        </div>

      </div>
  

    <script src="resources/js/jquery-1.11.3.js"></script>
    <script src="resources/js/bootstrap.js"></script>

    <!-- Bootstrap 4 CDN JS -->
    <!-- <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha/js/bootstrap.min.js" integrity="sha256-+h0g0j7qusP72OZaLPCSZ5wjZLnoUUicoxbvrl14WxM= sha512-0z9zJIjxQaDVzlysxlaqkZ8L9jh8jZ2d54F3Dn36Y0a8C6eI/RFOME/tLCFJ42hfOxdclfa29lPSNCmX5ekxnw==" crossorigin="anonymous"></script> -->

    <script src="resources/js/main.js"></script>
  </body>
</html>