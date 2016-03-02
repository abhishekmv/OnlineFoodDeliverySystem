<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
    <head>
    <title>Add New Dishes</title>
    <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate"/>
     <meta http-equiv="Pragma" content="no-cache"/>
     <meta http-equiv="Expires" content="0"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <meta http-equiv="X-UA-Compatible" content="IE=edge">
  		<meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        
        <script type="text/javascript">
            function validateForm() { 
                var u = document.forms["addfood"]["foodname"].value;
				var v = document.forms["addfood"]["description"].value;
				var w = document.forms["addfood"]["cost"].value;
				
				if(u==null || u=="")
  			{
  				alert("Food Name must be filled");
  				return false;
  			}
				else if(v==null || v=="")
  			{
				alert("description must be filled");
				return false;
  			}
				else if(w==null || w=="")
  			{
				alert("Cost must be filled");
				return false;
  			}
			
              
            }
        </script>
    </head>

    <body >
    <%@ include file="hoteladmin_navbar.jsp" %>
    <div class="container">
        <h1>Update the dish details</h1>
        <form method="POST" action="updatefood" enctype="multipart/form-data" name="addfood" id="addfood" onsubmit="return validateForm()">
            <input type="hidden" name ="fid" value="${foodmenu.f_id}">
             <table class="table table-bordered">
                 <tr>
                     <td> Food Name: </td>
                     <td> <input type="text"  name="foodname" id='foodname' value="${foodmenu.foodName}"></td>
                 </tr>
                 <tr>
            <td>Food Description: </td>
            <td> <TEXTAREA name="description" id="description" value="${foodmenu.description}" COLS=60 ROWS=8></TEXTAREA></td>
                 </tr>
               <tr>
            <td> Cost: </td>
            <td> <input type="number"  value="${foodmenu.cost}"  step="0.01" name="cost" id="cost"></td>
                 </tr>
                 <tr>
           <td> Spicy Level: </td>
           		<td> 
           		<select name="spicylevel" id="spicylevel">
  					<option value="mild">Mild</option>
  					<option value="medium">Medium</option>
 					 <option value="spicy">spicy</option>
				</select>
				</td>
                 </tr>

                 
                 <tr>
                  <td> Food Category: </td>
                 <td>
                 <select name="category" id="category">
          			<c:forEach items="${fcat}" var="fcat1"> 
          			<option value="${fcat1.cat_id}">${fcat1.catergoryName}</option>
          			</c:forEach>
          		</select>
          		</td>
                 </tr>
                 
                  <tr>
                   <td> Food Type: </td>
                  <td>
                 <select name="type" id="type">
          			<c:forEach items="${fType}" var="fType1"> 
          			<option value="${fType1.ftype_id}">${fType1.foodTypeName}</option>
          			</c:forEach>
          		</select>
          		</td>
                 </tr>
                 
            </table>
            <input type="submit" value="submit">
        </form>
        </div>
    </body>
</html>