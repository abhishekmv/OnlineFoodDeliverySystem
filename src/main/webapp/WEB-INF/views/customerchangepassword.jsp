<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix = "form" %>
<%@ page session="true" %>

<html>
<head>
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate"/>
     <meta http-equiv="Pragma" content="no-cache"/>
     <meta http-equiv="Expires" content="0"/>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
  <script type="text/javascript">
  	function validateForm()
  	{
  		var x = document.forms["passwordForm"]["password0"].value;
  		var y = document.forms["passwordForm"]["password1"].value;
  		var z = document.forms["passwordForm"]["password2"].value;
  		var p = document.getElementById("password0").innerHTML = '${pass}';
  		//console.log('${pass}');
  		//var s = ${currentUser.userPassword};
  		//alert(p);
  		if(x==null || x=="")
  			{
  				alert("old password must be filled");
  				return false;
  			}
  		else if(y==null || y=="")
  			{
  			alert("new password must be filled");
				return false;
  			}
  		else if(z==null || z=="")
  			{
  				alert("re-type new password must be filled");
  				return false;
  			}
  		else if(p!=x)
			{
				alert("old password doesnt match with the old password entered... try again");
				return false;
			}
  		else if(y!=z)
  			{
  				alert("new and retyped password doesnt match ... try again");
				return false;
  			}
  		
  	}
  
  </script>
  
</head>
</head>
<body>


<div class="container">
<%@ include file="customerheader.jsp" %>
	<div class="row">
	<div class="col-sm-12">
	<h1><center>Customer Change Password Form</center></h1>
	</div>
</div>

<div class="row">
<div class="col-sm-6 col-sm-offset-3">
${passerror}
<form method="post" name="passwordForm" id="passwordForm" action="customerChangePassword" onsubmit="return validateForm()">
Enter old Password: <input type="password" class="input-lg form-control" name="password0" id="password0" placeholder="Old Password" autocomplete="off">
<div class="row">
<div class="col-sm-12">
<span id="oldpass" class="glyphicon glyphicon-remove" style="color:#FF0004;"></span> Old Passwords Match
</div>
</div>


Enter New Password: <input type="password" class="input-lg form-control" name="password1" id="password1" placeholder="New Password" autocomplete="off">
<div class="row">
<div class="col-sm-6">
<span id="8char" class="glyphicon glyphicon-remove" style="color:#FF0004;"></span> 8 Characters Long<br>
<span id="ucase" class="glyphicon glyphicon-remove" style="color:#FF0004;"></span> One Uppercase Letter
</div>
<div class="col-sm-6">
<span id="lcase" class="glyphicon glyphicon-remove" style="color:#FF0004;"></span> One Lowercase Letter<br>
<span id="num" class="glyphicon glyphicon-remove" style="color:#FF0004;"></span> One Number
</div>
</div>

Enter New Password again:<input type="password" class="input-lg form-control" name="password2" id="password2" placeholder="Repeat Password" autocomplete="off">
<div class="row">
<div class="col-sm-12">
<span id="pwmatch" class="glyphicon glyphicon-remove" style="color:#FF0004;"></span>New Passwords Match
</div>
</div>
<input type="submit" class="col-xs-12 btn btn-primary btn-load btn-lg" data-loading-text="Changing Password..." value="Change Password">
</form>
</div><!--/col-sm-6-->
</div><!--/row-->
</div>

  <script type="text/javascript">
  
  $("input[type=password]").keyup(function(){
	    var ucase = new RegExp("[A-Z]+");
		var lcase = new RegExp("[a-z]+");
		var num = new RegExp("[0-9]+");
		//alert('${pass}');
		if($("#password0").val() == '${pass}'){
			$("#oldpass").removeClass("glyphicon-remove");
			$("#oldpass").addClass("glyphicon-ok");
			$("#oldpass").css("color","#00A41E");
		}else{
			$("#oldpass").removeClass("glyphicon-ok");
			$("#oldpass").addClass("glyphicon-remove");
			$("#oldpass").css("color","#FF0004");
		}
		
		if($("#password1").val().length >= 8){
			$("#8char").removeClass("glyphicon-remove");
			$("#8char").addClass("glyphicon-ok");
			$("#8char").css("color","#00A41E");
		}else{
			$("#8char").removeClass("glyphicon-ok");
			$("#8char").addClass("glyphicon-remove");
			$("#8char").css("color","#FF0004");
		}
		
		if(ucase.test($("#password1").val())){
			$("#ucase").removeClass("glyphicon-remove");
			$("#ucase").addClass("glyphicon-ok");
			$("#ucase").css("color","#00A41E");
		}else{
			$("#ucase").removeClass("glyphicon-ok");
			$("#ucase").addClass("glyphicon-remove");
			$("#ucase").css("color","#FF0004");
		}
		
		if(lcase.test($("#password1").val())){
			$("#lcase").removeClass("glyphicon-remove");
			$("#lcase").addClass("glyphicon-ok");
			$("#lcase").css("color","#00A41E");
		}else{
			$("#lcase").removeClass("glyphicon-ok");
			$("#lcase").addClass("glyphicon-remove");
			$("#lcase").css("color","#FF0004");
		}
		
		if(num.test($("#password1").val())){
			$("#num").removeClass("glyphicon-remove");
			$("#num").addClass("glyphicon-ok");
			$("#num").css("color","#00A41E");
		}else{
			$("#num").removeClass("glyphicon-ok");
			$("#num").addClass("glyphicon-remove");
			$("#num").css("color","#FF0004");
		}

		if($("#password1").val() == $("#password2").val()){
			$("#pwmatch").removeClass("glyphicon-remove");
			$("#pwmatch").addClass("glyphicon-ok");
			$("#pwmatch").css("color","#00A41E");
		}else{
			$("#pwmatch").removeClass("glyphicon-ok");
			$("#pwmatch").addClass("glyphicon-remove");
			$("#pwmatch").css("color","#FF0004");
		}
	});
  
  </script>
<%@ include file="HomeFooter.jsp" %>
</body>
</html>