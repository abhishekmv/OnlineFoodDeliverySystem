<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate"/>
     <meta http-equiv="Pragma" content="no-cache"/>
     <meta http-equiv="Expires" content="0"/>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Home Page</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</head>
<body>
  <div class="container">
  <%@ include file="HomeHeader.jsp" %>
<h2><center> <b><u> CUSTOM FOOD FILTER </u></b></center></h2>

<!-- cuisine start --> 
<h4 style="padding-top: 30px"><b>Cuisine</b></h4>
<div class="row" style="border: solid 2px">
  <div class="col-md-3">
  <div class="checkbox">
  <label>
    <input type="checkbox" value=""> Indian
  </label>
</div>
</div>

<div class="col-md-3">
 <div class="checkbox">
  <label>
    <input type="checkbox" value=""> Mediterranean
  </label>
</div>
</div>

<div class="col-md-3">
 <div class="checkbox">
  <label>
    <input type="checkbox" value=""> Chinese
  </label>
</div>
</div>

<div class="col-md-3">
 <div class="checkbox">
  <label>
    <input type="checkbox" value=""> Mexican
  </label>
</div>
</div>
</div>

<!-- cuisine end  -->

<!-- course start --> 
<h4 style="padding-top: 30px"><b>Course</b></h4>
<div class="row" style="border: solid 2px">

<div class="col-md-4">
 <div class="checkbox">
  <label>
    <input type="checkbox" value=""> Starter
  </label>
</div>
</div>

<div class="col-md-4">
 <div class="checkbox">
  <label>
    <input type="checkbox" value=""> Main Course
  </label>
</div>
</div>

<div class="col-md-4">
 <div class="checkbox">
  <label>
    <input type="checkbox" value=""> Desserts
  </label>
</div>
</div>
</div>

<!-- course end -->

<!-- ingredients start -->

<h4 style="padding-top: 30px"><b>Ingredients</b></h4>

<div class="row" style="border: solid 2px">
<div class="container">
<div class="row" style="padding-top: 10px;">

  <div class="col-md-3">
   <div class="btn-group">
   <button type="button" class="btn btn-danger">Meat</button>
  <button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    <span class="caret"></span>
    <span class="sr-only">Toggle Dropdown</span>
  </button>
  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
  <li><a href="#">None</a></li>
    <li><a href="#">Chicken</a></li>
    <li><a href="#">Pork</a></li>
    <li><a href="#">Beef</a></li>
  </ul>
</div>
</div>

  <div class="col-md-3">
   <div class="btn-group">
   <button type="button" class="btn btn-default">Bean</button>
  <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    <span class="caret"></span>
    <span class="sr-only">Toggle Dropdown</span>
  </button>
  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
  <li><a href="#">None</a></li>
    <li><a href="#">Black Bean</a></li>
    <li><a href="#">Brown Bean</a></li>
  </ul>
</div>
</div>

  <div class="col-md-3">
  <div class="btn-group">
   <button type="button" class="btn btn-default">Spicy Level</button>
  <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    <span class="caret"></span>
    <span class="sr-only">Toggle Dropdown</span>
  </button>
  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
   <li><a href="#">None</a></li>
    <li><a href="#">Mild</a></li>
    <li><a href="#">Medium</a></li>
    <li><a href="#">Spicy</a></li>
  </ul>
</div>
</div>

  <div class="col-md-3">
 <div class="btn-group">
   <button type="button" class="btn btn-default">Rice</button>
  <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    <span class="caret"></span>
    <span class="sr-only">Toggle Dropdown</span>
  </button>
  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
  <li><a href="#">None</a></li>
       <li><a href="#">White Rice</a></li>
    <li><a href="#">Brown Rice</a></li>
  </ul>
</div>
</div>
</div>

<div class="row" > 
<div class="col-md-2">
 <div class="checkbox">
  <label>
    <input type="checkbox" value=""> Corn
  </label>
</div>
</div>

<div class="col-md-2">
 <div class="checkbox">
  <label>
    <input type="checkbox" value=""> Lettice
  </label>
</div>
</div>

<div class="col-md-2">
 <div class="checkbox">
  <label>
    <input type="checkbox" value=""> Guacamole
  </label>
</div>
</div>

<div class="col-md-2">
 <div class="checkbox">
  <label>
    <input type="checkbox" value=""> Veggies
  </label>
</div>
</div>

<div class="col-md-2">
 <div class="checkbox">
  <label>
    <input type="checkbox" value=""> Salsa
  </label>
</div>
</div>

<div class="col-md-2">
 <div class="checkbox">
  <label>
    <input type="checkbox" value=""> Carrot
  </label>
</div>
</div>

</div>

<div class="row" > 
<div class="col-md-2">
 <div class="checkbox">
  <label>
    <input type="checkbox" value=""> Corn
  </label>
</div>
</div>

<div class="col-md-2">
 <div class="checkbox">
  <label>
    <input type="checkbox" value=""> Lettice
  </label>
</div>
</div>

<div class="col-md-2">
 <div class="checkbox">
  <label>
    <input type="checkbox" value=""> Guacamole
  </label>
</div>
</div>

<div class="col-md-2">
 <div class="checkbox">
  <label>
    <input type="checkbox" value=""> Veggies
  </label>
</div>
</div>

<div class="col-md-2">
 <div class="checkbox">
  <label>
    <input type="checkbox" value=""> Salsa
  </label>
</div>
</div>

<div class="col-md-2">
 <div class="checkbox">
  <label>
    <input type="checkbox" value=""> Carrot
  </label>
</div>
</div>

</div>

<div class="row" > 
<div class="col-md-2">
 <div class="checkbox">
  <label>
    <input type="checkbox" value=""> Corn
  </label>
</div>
</div>

<div class="col-md-2">
 <div class="checkbox">
  <label>
    <input type="checkbox" value=""> Lettice
  </label>
</div>
</div>

<div class="col-md-2">
 <div class="checkbox">
  <label>
    <input type="checkbox" value=""> Guacamole
  </label>
</div>
</div>

<div class="col-md-2">
 <div class="checkbox">
  <label>
    <input type="checkbox" value=""> Veggies
  </label>
</div>
</div>

<div class="col-md-2">
 <div class="checkbox">
  <label>
    <input type="checkbox" value=""> Salsa
  </label>
</div>
</div>

<div class="col-md-2">
 <div class="checkbox">
  <label>
    <input type="checkbox" value=""> Carrot
  </label>
</div>
</div>

</div>

<div class="row" > 
<div class="col-md-2">
 <div class="checkbox">
  <label>
    <input type="checkbox" value=""> Corn
  </label>
</div>
</div>

<div class="col-md-2">
 <div class="checkbox">
  <label>
    <input type="checkbox" value=""> Lettice
  </label>
</div>
</div>

<div class="col-md-2">
 <div class="checkbox">
  <label>
    <input type="checkbox" value=""> Guacamole
  </label>
</div>
</div>

<div class="col-md-2">
 <div class="checkbox">
  <label>
    <input type="checkbox" value=""> Veggies
  </label>
</div>
</div>

<div class="col-md-2">
 <div class="checkbox">
  <label>
    <input type="checkbox" value=""> Salsa
  </label>
</div>
</div>

<div class="col-md-2">
 <div class="checkbox">
  <label>
    <input type="checkbox" value=""> Carrot
  </label>
</div>
</div>

</div>

</div>
</div>
</div>

<!-- ingredients end -->

<p>
<center> <b> <a class="btn btn-default" role="button" href="customfilterpost">Search  »</a></b> </center> 
</p>
<%@ include file="HomeFooter.jsp" %>
</body>
</html>