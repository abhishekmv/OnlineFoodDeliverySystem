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
  <title>Header</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</head>
<body>
		<%@ include file="HomeHeader.jsp" %>
	<div class="container marketing" style="padding-top:70px">
	
		<div class="row featurette">
		<div class="col-md-7 col-md-push-5">
		<h2 class="featurette-heading">
		
		${fooditem.foodName}
		<!-- <span class="text-muted"></span> -->
		</h2>
		<p class="lead">${fooditem.description}</p>
		
		<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
  		<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
   		<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
        <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
        <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
     
		<p>Category: ${fooditem.foodCategory.catergoryName}</p>
		<p>Type:     ${fooditem.foodType.foodTypeName}</p>
		<p>Spicy Level: ${fooditem.spicyLevel}</p>
		<p class="glyphicon glyphicon-usd">${fooditem.cost}</p>
		
		
		<form action="mycart" method="post">
		 <input name="foodid" value="${fooditem.f_id}" type="hidden">
		 <input name="foodName" value="${fooditem.foodName}" type="hidden">
		 <input name="foodUnitPrice" value="${fooditem.cost}" type="hidden">
		 <input name="foodImage" value="${fooditem.image}" type="hidden">
		 <input name="cartOpType" value="add" type="hidden">
		<!-- <p><a href="#" class="btn btn-primary" role="button">Add To Cart</a></p> -->
		<input name="submit" value="Add To Cart" type="submit">
		</form>
		
		
		</div>
		<div class="col-md-5 col-md-pull-7">
		<img class="featurette-image img-responsive center-block" alt="500x500" data-src="holder.js/500x500/auto" src="FileServlet?path=C:\Misc\images\\<c:out value="${fooditem.image}" />" data-holder-rendered="true">
		</div>
		
		</div>
	<hr class="featurette-divider">
	
	</div>
	
	<div class="container">
	
	<table class="table table-bordered">
  	<thead>
  	<tr>
  	<th><center><b>Nutrition</b></center></th>
  	<th><center><b>Allergen</b></center></th>
  	</tr>
  	</thead>
  	
  	<tbody>
  		<tr>
  		<td><p>The beauty of pizza - and virtually everything else on our menu - is that it is a made-to-order product, 
  		made just as you request it. In fact, there are 34 million different combinations available in ordering just one
  		 Domino's pizza.</p></td>
  		<td><p>The beauty of pizza - and virtually everything else on our menu - is that it is a made-to-order product, 
  		made just as you request it. In fact, there are 34 million different combinations available in ordering just one
  		 Domino's pizza.
  		</p></td>
  		</tr>
  	</tbody>
	</table>
	</div>
	
	<div class="container">
	<div class="row" style="margin-top: 10px">
		<h4><b>Customer Reviews</b></h4>
	</div>
	<div class="row">
		<div class="col-sm-1 col-md-1">
		<div class="thumbnail">
			<img alt="customer review" src="FileServlet?path=C:\Misc\images\customer.jpg">
			</div>
		</div>
		<div class="col-sm-8 col-md-8">
		<div class="row" style="border: solid 1px; padding-bottom: 30px;">This is the best food, I ever had !</div>
		</div>
	</div>
	<p style="padding-bottom: 50px;">
 <b> <a class="btn btn-default" role="button" href="#">Write customer review »</a></b> 
</p>
	</div>
	
	<%@ include file="HomeFooter.jsp" %>
	</body>
	</html>