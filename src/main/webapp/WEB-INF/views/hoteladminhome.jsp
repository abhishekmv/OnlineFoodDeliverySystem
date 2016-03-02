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
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Home Admin</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="hoteladmin_navbar.jsp" %>
<div class="container">

<h1>Welcome  ${adminUser.firstName} ${adminUser.lastName}, </h1>


<form method ="post" action="fooditemdelete">
	<table class="table table-bordered">
	<tr>
		<th>Food Image</th>
		<th>Food Name</th>
		<th>Description</th>
		<th>Food Category</th>
		<th>Food Type</th>
		<th>Spicy Level</th>
		<th>Cost</th>
		<th>Update Password</th>
		<th>Delete</th>
		
	</tr>
	
	<c:forEach items="${allHotelAdmin}" var="fmenu"> 
 	 <tr>
 	 	 
 	 	 <td><img src="FileServlet?path=/Users/Muddassar/Documents/CSYE7280/FinalProject_OnlineFoodOrdering/images/\<c:out value="${fmenu.image}" />" height="100" width="100"></td>
   		 <td>${fmenu.foodName}</td>
  		  <td>${fmenu.description}</td>
  		  <td>${fmenu.foodCategory.catergoryName}</td>
  		  <td>${fmenu.foodType.foodTypeName}</td>
   		 <td>${fmenu.spicyLevel}</td>
   		 <td>${fmenu.cost}</td>
   		 <td><a href="updatefood?name=${fmenu.f_id}">Update</a></td>
		<td><a href="foodstatus?enable=${fmenu.f_id}">${fmenu.enable_disable}</a></td>
 	 </tr>
	</c:forEach>
	
	
	<tr><td colspan="9"><center>There are totally ${fn:length(allHotelAdmin)} Hotel Admins</center></td></tr>
	
<%-- 	<tr><td colspan="9"><center>
		
  		  <input type="submit" value="Delete selected messages">
  		 
	
	 </center>
	</td>
	</tr> --%>

</table>
</form>
</div>
<%@ include file="HomeFooter.jsp" %>
</body>
</html>