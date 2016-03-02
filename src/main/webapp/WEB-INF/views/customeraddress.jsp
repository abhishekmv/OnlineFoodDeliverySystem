<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix = "form" %>
<%@ page session="true" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate"/>
     <meta http-equiv="Pragma" content="no-cache"/>
     <meta http-equiv="Expires" content="0"/>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<title>Customer Address</title>
</head>
<body>
<div class="container">
<%@ include file="customerheader.jsp"%>
<div style="padding-top:50px">
<ol class="breadcrumb" >
  <li><a href="customerhome">Home</a></li>
  <li class="active">Shipping Address</li>
</ol>
</div>
<div class="progress" style="padding-top:15px" >
  <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100" style="width: 25%">
    25% 
  </div>
</div>
<p ><a href="addnewaddress" class="btn btn-primary" role="button">Add New Shipping Address</a></p>
<div class="row">

<c:forEach items="${cusAddress}" var="add"> 
<form action="continuecheckout" method="post">

  <div class="col-xs-6 col-md-3">
    <div class="thumbnail">
      <p>Street name:${add.streetName}</p>
      <p>City:${add.city}</p>
      <p>State:${add.state}</p>
      <p>Zipcode:${add.zipCode}</p>
      <input type="hidden" name="addid" value="${add.add_id}">
    <input type="submit" class="btn btn-primary" role="button" value="Select Shipping Address">
    </div>
  </div>
  </form>
  </c:forEach>
</div>
</div>
 <%@ include file="HomeFooter.jsp" %>
</body>
</html>