
<!DOCTYPE html>
<html>
    <head>
    <title>Add Customer</title>
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
                
                var b = document.forms["addhadmin"]["streetname"].value;
                var c = document.forms["addhadmin"]["city"].value;
                var d = document.forms["addhadmin"]["state"].value;
                var e = document.forms["addhadmin"]["country"].value;
                var f = document.forms["addhadmin"]["zipcode"].value;
				
			
			
				 if(b==null || b=="")
	  			{
					alert("StreetName must be filled");
					return false;
	  			}
				
				else if(c==null || c=="")
	  			{
					alert("City must be filled");
					return false;
	  			}
				else if(d==null || d=="")
	  			{
					alert("State must be filled");
					return false;
	  			}
				else if(e==null || e=="")
	  			{
					alert("Country must be filled");
					return false;
	  			}
				else if(f==null || f=="")
	  			{
					alert("ZipCode must be filled");
					return false;
	  			}
				
              
            }
        </script>
    </head>

    <body >
    <div class="container">
    <%@ include file="customerheader.jsp" %>
        <h1 style="padding-top:50px;">Please enter your new address below</h1>
        ${d}
        <form method = 'post' action = 'addnewaddress' name="addhadmin" id="addhadmin"  onsubmit="return validateForm()">
            
             <table class="table table-bordered">
                
                  <tr>
           <td> Street Name: </td><td> <input type="text"  name="streetname" id="streetname"></td>
                 </tr>
                  <tr>
           <td> City: </td><td> <input type="text"  name="city" id="city"></td>
                 </tr>
                 <tr>
           <td> State: </td><td> <input type="text"  name="state" id="state"></td>
                 </tr>
                  <tr>
           <td> Country: </td><td> <input type="text"  name="country" id="country"></td>
                 </tr>
                  <tr>
           <td> Zip Code: </td><td> <input type="number"  name="zipcode" id="zipcode" min="00000"  max="99999"></td>
                 </tr>
            </table>
            <input type="submit" value="submit">
        </form>
        </div>
    </body>
</html>