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
<title>Final Order Summery</title>
</head>
<body>
<div class="container">
<%@ include file="customerheader.jsp" %>
<h2>Final Order Summery</h2>
<div style="padding-top:20px">
<ol class="breadcrumb" >
  <li><a href="customerhome">Home</a></li>
   <li class="#">Shipping Address</li>
  <li class="#">Payment</li>
  <li class="#">Final Order Summery</li>
</ol>
</div>
<div class="progress" style="padding-top:15px" >
  <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100" style="width: 75%">
    75% 
  </div>
</div>

<form action="orderplacement" method="get">

<div class="row">
  

  <div class="col-xs-6 col-md-3">
    <div class="thumbnail">
    <h4>Shipping Address</h4>
      <p>Customer Name: sachin</p>
      <p>Street name:75 saint alphonsus</p>
      <p>City:Boston</p>
      <p>State:MA</p>
      <p>Zipcode:02120</p>
    </div>
  </div>

  <div class="col-xs-6 col-md-3">
    <div class="thumbnail">
    <h4>Payment Details</h4>
      <p>Card Type: MasterCard</p>
      <p>Card Number: 00112233445566</p>
      <p>Cvv:000</p>
      <p>Expiry Date:04/10/2016</p>
    </div>
  </div>
</div>

<div class="row" style="padding-bottom:50px">
  <p> <a href="plist" class="btn btn-primary" role="button">Cancel</a> 
  <input type="submit" class="btn btn-primary pull-right" role="button" value="Place Order"></p>
  <table class="table table-bordered">
  <tr>
    <td>Food Image</td>
    <td>Food Name</td>
    <td>Unit Price</td>
    <td>Total Price</td>
    <td>Count</td>
    </tr>
  
    <tr>
      <td><img src="FileServlet?path=C:\Misc\images\dahipuri.jpg" height="100" width="100"></td>
      <td>Dahi Puri</td>
      <td ><p class="glyphicon glyphicon-usd">10</p></td>
      <td ><p class="glyphicon glyphicon-usd">20</p></td>
      <td>
      <p>2</p>
      </td>
    </tr>

        <tr>
      <td><img src="FileServlet?path=C:\Misc\images\mixed vegetable rice.jpg" height="100" width="100"></td>
      <td>Mixican rice</td>
      <td ><p class="glyphicon glyphicon-usd">14</p></td>
      <td ><p class="glyphicon glyphicon-usd">14</p></td>
      <td>
      <p>1</p>
      </td>
    </tr>
  
    <tr>
    <td/>
    <td/>
    <td><b>Total Price</b></td>
    <td><b class="glyphicon glyphicon-usd">34 </b></td>
    </tr>
    
    </table>

</div>

</form>
</div>
 <%@ include file="HomeFooter.jsp" %>
</body>
</html>