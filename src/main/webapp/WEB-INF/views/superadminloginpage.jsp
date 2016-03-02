<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix = "form" %>

<html>
<head>

  <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate"/>
     <meta http-equiv="Pragma" content="no-cache"/>
     <meta http-equiv="Expires" content="0"/>
  <title> Admin Page</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
  <script src="https://www.google.com/recaptcha/api.js"></script>
  <style type="text/css">
  body {
  padding-top: 40px;
  padding-bottom: 40px;
  background-color: #eee;
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
	<center>${staterror}</center>
	<h1><center>Welcome,  Admin !!!!</center></h1>
	<center>${a}</center>
	
      <form:form class="form-signin" action="sadmin" method = "POST" commandName="person">
        <h2 class="form-signin-heading">Please sign in</h2>
        
        <label for="inputEmail" class="sr-only">User Name</label>    
        <form:input type="text" path="userName" id="inputEmail" class="form-control" placeholder="User Name" />
        <form:errors path="userName" cssStyle="color:#ff0000"></form:errors>
        
        <label for="inputPassword" class="sr-only">Password</label>
        <form:input type="password" path="password" id="inputPassword" class="form-control" placeholder="Password" />
        <form:errors path="password" cssStyle="color:#ff0000"/>
         <br>
         
         <select name="admintype" id="admintype">
  					<option value="SuperAdmin">Super Admin</option>
  					<option value="HotelAdmin">Hotel Admin</option>
 					
		</select>
		 
		<div class="g-recaptcha"  style="padding-top:15px;" data-sitekey="6LdMAgMTAAAAAGYY5PEQeW7b3L3tqACmUcU6alQf"></div>
         ${c}
         <br>
      
        <br>
        <button class="btn btn-lg btn-primary btn-block" type="submit" >Sign in</button>
      </form:form>

    </div> <!-- /container -->


</body>
</html>


