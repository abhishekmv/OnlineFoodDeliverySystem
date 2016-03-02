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
<title>Customer Payment</title>
</head>
<body>
<div class="container">
<%@ include file="customerheader.jsp"%>
<div style="padding-top:50px">
<ol class="breadcrumb" >
  <li><a href="customerhome">Home</a></li>
   <li class="#">Shipping Address</li>
  <li class="active">Payment</li>
</ol>
</div>
<div class="progress" style="padding-top:15px" >
  <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" style="width: 50%">
    50% 
  </div>
</div>

<div class="row">


<form action="continuepayment" method="post">

  <div class="col-xs-6 col-md-3">
    <div class="thumbnail">
      <p>Card Type:${cuspayment.cardType}</p>
      <p>Card Number:${cuspayment.cardNumber}</p>
      <p>Cvv:${cuspayment.cvvNumber}</p>
      <p>Expiry Date:${cuspayment.expiryDate}</p>
      <input type="hidden" name="payid" value="${cuspayment.p_id}">
     <p> <a href="#" class="btn btn-primary" role="button">Update Payment Details</a>
    <input type="submit" class="btn btn-primary" role="button" value="Select Payment"></p>
    </div>
  </div>
  </form>

</div>
</div>
 <%@ include file="HomeFooter.jsp" %>
</body>
</html>