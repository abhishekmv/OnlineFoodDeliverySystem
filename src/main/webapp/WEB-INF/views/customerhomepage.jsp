
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix = "form" %>
<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Customer Home Page</title>
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate"/>
     <meta http-equiv="Pragma" content="no-cache"/>
     <meta http-equiv="Expires" content="0"/>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</head>
<body>

	
	<div class="container">
	<%@ include file="customerheader.jsp" %>
	<h1>Welcome ${customerUser.userName},</h1>
	<h3 style="padding-top:0px;">Food Cart Items :</h3>
	<p> <a href="plist" class="btn btn-primary" role="button">Continue Shopping</a> <a href="continuecheckout" class="btn btn-primary pull-right" role="button">Check Out</a></p>
	<%-- <a href="<c:url value='/flows/flow1'/>" class="btn btn-primary pull-right" role="button">Check Out</a> --%>
	<table class="table table-bordered">
	<tr>
		<td>Food Image</td>
		<td>Food Name</td>
		<td>Unit Price</td>
		<td>Total Price</td>
		<td>Count</td>
		<td></td>
		</tr>
		
		<c:forEach items="${customercart}" var="item"> 
		<tr>
			<td><img src="FileServlet?path=C:\Misc\images\\<c:out value="${item.image}" />" height="100" width="100"></td>
			<td>${item.foodName}</td>
			<td ><p class="glyphicon glyphicon-usd">${item.unitPrice}</p></td>
			<td ><p class="glyphicon glyphicon-usd">${item.totalperitem}</p></td>
			<td>
			<form action="mycart" method="post">
			<input name="foodid" value="${item.foodid}" type="hidden"/>
			<input name="foodunitcost" value="${item.unitPrice}" type="hidden"/>
			<input name="fooditemCount" value="${item.count}" type="text"/>
			<input name="cartOpType" value="update" type="hidden"/>
			<input name="Update" value="update cart" type="submit"/>
			</form>
			</td>
			<td>
			<a href="mycartdelete?productId=${item.foodid}&cartOpType=delete" class="btn btn-primary" role="button">Delete</a>
			<%-- <a href="ShoppingCartUpdates?productId=${item.foodid}&cartOpType=delete">Delete</a> --%>
			</td>
		</tr>
		</c:forEach>
		<tr>
		<td/>
		<td/>
		<td><b>Total Price</b></td>
		<td><b class="glyphicon glyphicon-usd">${sum}</b></td>
		</tr>
		
		</table>
		<p> <a href="plist" class="btn btn-primary " role="button">Continue Shopping</a> <a href="continuecheckout" class="btn btn-primary pull-right" role="button">Check Out</a></p>
		</div>
		<%@ include file="HomeFooter.jsp" %>
</body>
</html>