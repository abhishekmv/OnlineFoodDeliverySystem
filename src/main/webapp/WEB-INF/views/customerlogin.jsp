<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix = "form" %>

<html>
<head>

  <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate"/>
     <meta http-equiv="Pragma" content="no-cache"/>
     <meta http-equiv="Expires" content="0"/>
  <title> Cutomer Login Page</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
  <script src="https://www.google.com/recaptcha/api.js"></script>
  <style type="text/css">
  body {
  padding-top: 40px;
  padding-bottom: 40px;
  background-color: #ffffff;
}

.form-signin {
  max-width: 330px;
  padding: 15px;
  margin: 0 auto;
}
.form-signin .form-signin-heading,
.form-signin .checkbox {
  margin-bottom: 10px;
}
.form-signin .checkbox {
  font-weight: normal;
}
.form-signin .form-control {
  position: relative;
  height: auto;
  -webkit-box-sizing: border-box;
     -moz-box-sizing: border-box;
          box-sizing: border-box;
  padding: 10px;
  font-size: 16px;
}
.form-signin .form-control:focus {
  z-index: 2;
}
.form-signin input[type="email"] {
  margin-bottom: -1px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}
.form-signin input[type="password"] {
  margin-bottom: 10px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}
  </style>

</head>
<body>
<div class="container">

<%@ include file="HomeHeader.jsp" %>
	${staterror}
		
	<h1><center>Welcome,  Customer !!!!</center></h1>
	

	
	<p style="padding-top:30px;"><h4><center>Sign in to check out your food cart !!</center></h4></p>
      <form:form class="form-signin" action="checkout" method = "POST" commandName="customer">
        <h2 class="form-signin-heading">Please sign in</h2>
        ${d}
        ${a}
		
        <label for="inputEmail" class="sr-only">User Name</label>    
        <form:input type="text" path="userName" name="username" id="inputEmail" class="form-control" placeholder="User Name" />
        <form:errors path="userName" cssStyle="color:#ff0000"></form:errors>
        
        <label for="inputPassword" class="sr-only">Password</label>
        <form:input type="password" path="password" name="password" id="inputPassword" class="form-control" placeholder="Password" />
        <form:errors path="password" cssStyle="color:#ff0000"/>
        
         
      	 <div class="checkbox">
          <label>
            <input type="checkbox" name="remember-me" id="remember-me" value="remember-me"> Remember me
          </label>
        </div>
        <br>
        
        <div class="g-recaptcha"  style="padding-top:15px;" data-sitekey="6LdMAgMTAAAAAGYY5PEQeW7b3L3tqACmUcU6alQf"></div>
         ${c}
         <br>
        
        <br>
        <button class="btn btn-lg btn-primary btn-block" type="submit" >Sign in</button>
      </form:form>
      
      <p><center><h4>New Customer Please Click <a href="addnewcustomer" class="btn btn-primary" role="button">Here</a> To Check Out Your Cart !!</h4></center></p>
<%@ include file="HomeFooter.jsp" %>
    </div> <!-- /container -->


</body>
</html>

