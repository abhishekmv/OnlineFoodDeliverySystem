<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate"/>
     <meta http-equiv="Pragma" content="no-cache"/>
     <meta http-equiv="Expires" content="0"/>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Order History</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</head>
<body>

 <div class="container">
   <%@ include file="customerheader.jsp" %>
<h2><center> <b><u> ORDER HISTORY </u></b></center></h2>

<table class="table table-bordered">
<tr>
    <td>Sl. No</td>
    <td>Order Number</td>
    <td>Order Details</td>
    <td>Total Price</td>
    <td></td>
    </tr>
<tr>
      <td><center>1</center></td>
      <td><center>0012344466</center></td>
      <td ><p> Dahi Puri * 2 = $20</p><p>Mexican rice * 1 = $14</p></td>
      <td ><p class="glyphicon glyphicon-usd">34</p></td>
      <td>
      <a href="reorder" class="btn btn-primary" role="button">One Click Re-Order</a>
      </td>
    </tr>
    <tr>
      <td><center>2</center></td>
      <td><center>0034678934</center></td>
      <td ><p> Pani Puri * 2 = $20</p><p>Chinese rice * 1 = $12</p></td>
      <td ><p class="glyphicon glyphicon-usd">32</p></td>
      <td>
      <a href="reorder" class="btn btn-primary" role="button">One Click Re-Order</a>
      </td>
    </tr>
    <tr>
      <td><center>3</center></td>
      <td><center>0016738543</center></td>
      <td ><p> Behl Puri * 2 = $25</p><p>Mexican rice * 1 = $14</p></td>
      <td ><p class="glyphicon glyphicon-usd">39</p></td>
      <td>
      <a href="reorder" class="btn btn-primary" role="button">One Click Re-Order</a>
      </td>
    </tr>
    <tr>
      <td><center>4</center></td>
      <td><center>0056385665</center></td>
      <td ><p> Dahi Puri * 2 = $20</p><p>Mexican rice * 1 = $14</p></td>
      <td ><p class="glyphicon glyphicon-usd">34</p></td>
      <td>
      <a href="reorder" class="btn btn-primary" role="button">One Click Re-Order</a>
      </td>
    </tr>

</table>
  </div>
  <%@ include file="HomeFooter.jsp" %>
  </body>
 </html>