<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate"/>
     <meta http-equiv="Pragma" content="no-cache"/>
     <meta http-equiv="Expires" content="0"/>
 <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Nav Bar</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</head>
<body>
        
        <nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="home">Delivery.com</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="customerhome">My Food Cart<span class="sr-only">(current)</span></a></li>
        <li><a href="orderhistory">Order History</a></li>
		<li class="dropdown">
		<a class="dropdown-toggle" aria-expanded="true" role="button" data-toggle="dropdown" href="#">
		My Account
		<span class="caret"></span>
		</a>
		<ul class="dropdown-menu" role="menu">
		 <li>
		<a href="customerChangePassword">Change Password</a>
		</li> 
		<li>
		<a href="#">Update Personal Details</a>
		</li>
		<li>
		<a href="#">Update Payment Details</a>
		</li>
		</ul>
		</li>
        <!-- <li><a href="customerChangePassword">Change Password</a></li> -->
        <!-- <li><a href="#">Update Personal Details</a></li>
         <li><a href="#">Update Payment Details</a></li> -->
        <li><a href="customerLogout" class="glyphicon glyphicon-off">Logout</a></li>
      </ul>
 
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
        
</body>
</html>