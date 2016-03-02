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
	<div class="container">

		
		<div style="padding-top: 50px">
		<div class="alert alert-success" role="alert"><center>${catName}</center></div>
		</div>
		
			<div class="col-md-4 col-md-offset-8">
				<ul class="nav nav-pills" >
				  <li role="presentation" id="2" ><a href="plist?q=2">Rating</a></li>
				  <li role="presentation" id="3"><a href="plist?q=3">Low-High</a></li>
				  <li role="presentation" id="4"><a href="plist?q=4">High-Low</a></li>
				</ul>
			</div>
		<br/>
		<br/>
		<div style="padding: 10px">
		<div class="alert alert-info" role="alert"><center>Starter</center></div>
			
			<c:forEach items="${starter}" var="stat" varStatus="loop"> 
			
			<c:if test="${loop.index == 0}">
				<div class="row">
			</c:if>
			
			
 			 <div class="col-sm-6 col-md-3">
   				 <div class="thumbnail">
      				<img src="FileServlet?path=C:\Misc\images\\<c:out value="${stat.image}" />"  alt="Image-Starter">
      				<div class="caption">
      			  <h3>${stat.foodName}</h3>
      			  <p>${stat.foodCategory.catergoryName}</p>
      			  <p></p>
       			 <p class="glyphicon glyphicon-usd">${stat.cost}</p>
       			 
       			<p> <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
  				<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
 				  <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
  			  <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
 				    <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span></p>
       			 
       			 <form action="mycart" method="post">
       			 
				 <input name="foodid" value="${stat.f_id}" type="hidden">
				 <input name="foodName" value="${stat.foodName}" type="hidden">
				 <input name="foodUnitPrice" value="${stat.cost}" type="hidden">
		 		<input name="foodImage" value="${stat.image}" type="hidden">
		 		<input name="cartOpType" value="add" type="hidden">
				<p><a href="viewfooditem?view=${stat.f_id}" class="btn btn-default" role="button">View Item</a>
				<input name="submit" value="Add To Cart" type="submit"></p>
				
				</form>
				
       			 <%-- <p><a href="mycart?cart=${stat.f_id}" class="btn btn-primary" role="button">Add To Cart</a> <a href="viewfooditem?view=${stat.f_id}" class="btn btn-default" role="button">View Item</a></p> --%>
     			 </div>
  			  </div>
  			</div>
  			
  			<c:if test="${(loop.index!=0) && (loop.index+1)%4==0}">
  				</div>
  				<c:if test="${fn:length(starter)>(loop.index+1)}">
  					<div class="row">
  				</c:if>
  			</c:if>
  			
  			
  				<c:if test="${fn:length(starter)==(loop.index+1)}">
  					</div>
  				</c:if>
  			
  			
  			</c:forEach>
		</div>
		
		<hr class="featurette-divider">
		</div>
		
		<div style="padding: 10px">
		<div class="container">
		<div class="alert alert-info" role="alert"><center>Main Course</center></div>
		
		<c:forEach items="${maincourse}" var="mc" varStatus="loop1"> 
			
			<c:if test="${loop1.index == 0}">
				<div class="row">
			</c:if>
		
			
 			 <div class="col-sm-6 col-md-3">
   				 <div class="thumbnail">
      				<img src="FileServlet?path=C:\Misc\images\\<c:out value="${mc.image}" />"  alt="Image-Starter">
      				<div class="caption">
      			  <h3>${mc.foodName}</h3>
       			  <p>${mc.foodCategory.catergoryName}</p>
      			  <p></p>
       			 <p class="glyphicon glyphicon-usd">${mc.cost}</p>
       			 
       			 <p> <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
  <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
   <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
    <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
     <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span></p>
       			 
       			 	 <form action="mycart" method="post">
       			 
				 <input name="foodid" value="${mc.f_id}" type="hidden">
				 <input name="foodName" value="${mc.foodName}" type="hidden">
				 <input name="foodUnitPrice" value="${mc.cost}" type="hidden">
		 		<input name="foodImage" value="${mc.image}" type="hidden">
		 		<input name="cartOpType" value="add" type="hidden">
				<p><a href="viewfooditem?view=${mc.f_id}" class="btn btn-default" role="button">View Item</a>
				<input name="submit" value="Add To Cart" type="submit"></p>
				
				</form>
       			 
     			 </div>
  			  </div>
  			</div>
  			
  			<c:if test="${(loop1.index!=0) && (loop1.index+1)%4==0}">
  				</div>
  				<c:if test="${fn:length(maincourse)>(loop1.index+1)}">
  					<div class="row">
  				</c:if>
  			</c:if>
  			
  			
  				<c:if test="${fn:length(maincourse)==(loop1.index+1)}">
  					</div>
  				</c:if>
  			
  			</c:forEach>
		</div>
		</div>
		
		
		<hr class="featurette-divider">
		</div>
		
		<div style="padding: 10px">
		<div class="container">
		<div class="alert alert-info" role="alert"><center>Dessert</center></div>
		
	
			<c:forEach items="${dessert}" var="des" varStatus="loop2"> 
			
			<c:if test="${loop2.index == 0}">
				<div class="row">
			</c:if>
			
 			 <div class="col-sm-6 col-md-3">
   				 <div class="thumbnail">
      				<img src="FileServlet?path=C:\Misc\images\\<c:out value="${des.image}" />"  alt="Image-Starter">
      				<div class="caption">
      			  <h3>${des.foodName}</h3>
       			   <p>${des.foodCategory.catergoryName}</p>
      			  <p></p>
       			 <p class="glyphicon glyphicon-usd">${des.cost}</p>
       			 
       			 <p> <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
  <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
   <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
    <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
     <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span></p>
       			 
       			 	 <form action="mycart" method="post">
       			 
				 <input name="foodid" value="${des.f_id}" type="hidden">
				 <input name="foodName" value="${des.foodName}" type="hidden">
				 <input name="foodUnitPrice" value="${des.cost}" type="hidden">
		 		<input name="foodImage" value="${des.image}" type="hidden">
		 		<input name="cartOpType" value="add" type="hidden">
				<p><a href="viewfooditem?view=${des.f_id}" class="btn btn-default" role="button">View Item</a>
				<input name="submit" value="Add To Cart" type="submit"></p>
				
				</form>
       			 
     			 </div>
  			  </div>
  			</div>
  			
  			<c:if test="${(loop2.index!=0) && (loop2.index+1)%4==0}">
  				</div>
  				<c:if test="${fn:length(dessert)>(loop2.index+1)}">
  					<div class="row">
  				</c:if>
  			</c:if>
  			
  			
  				<c:if test="${fn:length(dessert)==(loop2.index+1)}">
  					</div>
  				</c:if>
  			
  			</c:forEach>
		</div>
		</div>
		
		
		<hr class="featurette-divider">
		</div>
	
	</div>

<%@ include file="HomeFooter.jsp" %>
<script>

	$( document ).ready(function() {
		var q = window.location.search;
		if(q && q.indexOf("q")!==-1)
		{
			var actId = "#" + q.split("=")[1];
			$(actId).addClass("active");
		}
		else
		{
			$("#2").addClass("active");
		}
		
	});
	

</script>
</body>
</html>