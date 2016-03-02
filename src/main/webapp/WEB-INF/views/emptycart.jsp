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
  <title>empty Cart</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</head>
<body>
<%-- <%
		HttpSession session2 = request.getSession();
 
		if(null==session2.getAttribute("customerUser")){

  		  response.sendRedirect("error");
    
  	  }
	%> --%>
<div class="container">
<%@ include file="HomeHeader.jsp" %>
<p style="padding-top:50px;"><center><h1>Your Cart is empty !!!</h1></center></p>

<p><center>Click <a href="plist" class="btn btn-primary" role="button">Here</a> to go back and shop</center></p>
<%@ include file="HomeFooter.jsp" %>
</div>
</body>
</html>