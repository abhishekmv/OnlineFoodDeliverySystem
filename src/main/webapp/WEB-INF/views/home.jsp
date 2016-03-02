
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

<div id="myCarousel" class="carousel slide" data-ride="carousel" style="padding-top:50px;">
		<ol class="carousel-indicators">
		<li class="active" data-slide-to="0" data-target="#myCarousel"></li>
		<li class="" data-slide-to="1" data-target="#myCarousel"></li>
		<li class="" data-slide-to="2" data-target="#myCarousel"></li>
		</ol>
	<div class="carousel-inner" role="listbox">
	<div class="item active">
	
	<img class="first-slide" alt="First slide"  src="FileServlet?path=C:\Misc\images\chinese-food-recipes-chicken.jpg" alt="Image-Starter"/>
	</div>
	
	<div class="item">
	
	<img class="second-slide" alt="Second slide" src="FileServlet?path=C:\Misc\images\typical-greek-food.jpg" alt="Image-Starter"/>


</div>
<div class="item">
	<img class="third-slide" alt="Third slide" src="FileServlet?path=C:\Misc\images\healthy-food-guide.jpg"  alt="Image-Starter"/>
</div>
</div>
</div>

<div class="container marketing" style="padding:50px">
<div class="row">
<div class="col-lg-3">
<img class="img-circle" width="140" height="140" alt="Generic placeholder image" src="FileServlet?path=C:\Misc\images\gulab-jamun-article.jpg">
<h2>Indian Cuisine</h2>
<p>Indian cuisine encompasses a wide variety of regional cuisines native to India. Given the range of diversity in soil type, climate and occupations, these cuisines vary significantly from each other and use locally available spices, herbs, vegetables and fruits. Indian food is also heavily influenced by religious and cultural choices and traditions.</p>
<p>
<a class="btn btn-default" role="button" href="filter?catno=1">View Food Item  »</a>
</p>
</div>
<div class="col-lg-3">
<img class="img-circle" width="140" height="140" alt="Generic placeholder image" src="FileServlet?path=C:\Misc\images\mediterranean-tarts.jpg">
<h2>Mediterranean Cuisine</h2>
<p>Mediterranean cuisine is the food from the cultures adjacent to the Mediterranean Sea. Although this region spans a wide variety of cultures, the historical connections of the region, as well as the impact of the Mediterranean Sea on the region's climate and economy.</p>
<p>
<a class="btn btn-default" role="button" href="filter?catno=2">View Food Item  »</a>
</p>
</div>
<div class="col-lg-3">
<img class="img-circle" width="140" height="140" alt="Generic placeholder image" src="FileServlet?path=C:\Misc\images\Noodles.jpg">
<h2>Chinese Cuisine</h2>
<p>Chinese cuisine includes styles originating from the diverse regions of China, as well as from Chinese people in other parts of the world. The history of Chinese cuisine in China stretches back for thousands of years and has changed from period to period and in each region according to climate, imperial fashions, and local preferences. </p>
<p>
<a class="btn btn-default" role="button" href="filter?catno=3">View Food Item  »</a>
</p>
</div>
<div class="col-lg-3">
<img class="img-circle" width="140" height="140" alt="Generic placeholder image" src="FileServlet?path=C:\Misc\images\enchilada.jpg">
<h2>Mexican Cuisine</h2>
<p>Mexican cuisine is primarily a fusion of indigenous Mesoamerican cooking with European, especially Spanish, elements added after the Spanish conquest of the Aztec Empire in the 16th century. The basic staples remain native foods such as corn, beans and chili peppers, but the Europeans introduced a large number of other foods.</p>
<p>
<a class="btn btn-default" role="button" href="filter?catno=4">View Food Item »</a>
</p>
</div>
</div>
</div>

<!-- recomendtion -->
<h3 style="padding-top: 30px; margin-top: 10px;"><b>Our Recomendation based on your previous order !</b></h3>
<div class="row" style="border: solid 2px;   margin-bottom: 60px; padding-top:10px">

 <div class="col-sm-6 col-md-3">
           <div class="thumbnail">
              <img src="FileServlet?path=C:\Misc\images\dahipuri.jpg"  alt="Image-Starter">
              <div class="caption">
              <h3>Dahi Puri</h3>
              <p>Indian</p>
              <p></p>
             <p class="glyphicon glyphicon-usd">10.0</p>
             
            <p> <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
          <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
          <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
          <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
            <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span></p>        
           </div>
          </div>
        </div>
        
         <div class="col-sm-6 col-md-3">
           <div class="thumbnail">
              <img src="FileServlet?path=C:\Misc\images\mixed vegetable rice.jpg"  alt="Image-Starter">
              <div class="caption">
              <h3>Mixed vegetable rice</h3>
              <p>Chinese</p>
              <p></p>
             <p class="glyphicon glyphicon-usd">10.0</p>
             
            <p> <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
          <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
          <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
          <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
            <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span></p>        
           </div>
          </div>
        </div>
        
         <div class="col-sm-6 col-md-3">
           <div class="thumbnail">
              <img src="FileServlet?path=C:\Misc\images\gulab-jamun-article.jpg"  alt="Image-Starter">
              <div class="caption">
              <h3>Gulab Jamun</h3>
              <p>Indian</p>
              <p></p>
             <p class="glyphicon glyphicon-usd">5.0</p>
             
            <p> <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
          <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
          <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
          <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
            <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span></p>        
           </div>
          </div>
        </div>
        
         <div class="col-sm-6 col-md-3">
           <div class="thumbnail">
              <img src="FileServlet?path=C:\Misc\images\enchilada.jpg"  alt="Image-Starter">
              <div class="caption">
              <h3>Enchilada</h3>
              <p>Mexican</p>
              <p></p>
             <p class="glyphicon glyphicon-usd">10.0</p>
             
            <p> <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
          <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
          <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
          <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
            <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span></p>        
           </div>
          </div>
        </div>
</div>

<%@ include file="HomeFooter.jsp" %>
</div>
</body>
</html>