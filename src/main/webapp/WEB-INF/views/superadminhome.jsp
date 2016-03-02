<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix = "form" %>
<%@ page session="true" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate"/>
     <meta http-equiv="Pragma" content="no-cache"/>
     <meta http-equiv="Expires" content="0"/>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Super Admin</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="superadmin_navbar.jsp" %>
<div class="container">

<h1>Welcome  ${adminUser.firstName} ${adminUser.lastName}, </h1>

<form method ="get" action="hoteladminadd">

<input type="submit" value="Add New Hotel Admin"/>
</form>

<form method ="post" action="hoteladmindelete">
	<table class="table table-bordered">
	<tr>
		<th>UserName</th>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Email ID</th>
		<th>Role Type</th>
		<th>Email Hotel Admin Details</th>
		<th>User Status</th>
		
	</tr>
	
	<c:forEach items="${allHotelAdmin}" var="had"> 
 	 <tr>
   		 <td>${had.userName}</td>
  		  <td>${had.firstName}</td>
  		  <td>${had.lastName}</td>
  		  <td>${had.emailID}</td>
   		 <td>${had.roleType}</td>
   		 
   		 <td><a href="emaildetails?em=${had.pid}" class="glyphicon glyphicon-send"></a></td>
		<td><a href="userstatus?stat=${had.pid}">${had.enable_disable}</a></td>
 	 </tr>
	</c:forEach>
	
	
	<tr><td colspan="8"><center>There are totally ${fn:length(allHotelAdmin)} Hotel Admins</center></td></tr>
	
<%-- 	<tr><td colspan="8"><center>
		
  		  <input type="submit" value="Delete selected messages">
  		 
	
	 </center>
	</td>
	</tr> --%>

</table>
</form>
</div>
</body>
</html>