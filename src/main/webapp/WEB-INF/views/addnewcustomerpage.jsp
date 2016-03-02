
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
                var u = document.forms["addhadmin"]["username"].value;
				var v = document.forms["addhadmin"]["password"].value;
				var w = document.forms["addhadmin"]["firstname"].value;
				var x = document.forms["addhadmin"]["lastname"].value;
				var y = document.forms["addhadmin"]["emailid"].value;
                var z = document.forms["addhadmin"]["number"].value;
                
                var a = document.forms["addhadmin"]["confirmpassword"].value;
                var b = document.forms["addhadmin"]["streetname"].value;
                var c = document.forms["addhadmin"]["city"].value;
                var d = document.forms["addhadmin"]["state"].value;
                var e = document.forms["addhadmin"]["country"].value;
                var f = document.forms["addhadmin"]["zipcode"].value;
				
				if(u==null || u=="")
  			{
  				alert("UserName must be filled");
  				return false;
  			}
				else if(v==null || v=="")
  			{
				alert("Password must be filled");
				return false;
  			}
			else if(a==null || a=="")
	  		{
				alert("Confirm Password must be filled");
				return false;
  			}
				else if(w==null || w=="")
  			{
				alert("FirstName must be filled");
				return false;
  			}
				else if(x==null || x=="")
  			{
				alert("LastName must be filled");
				return false;
  			}
				else if(y==null || y=="")
  			{
				alert(" Email ID must be filled");
				return false;
  			}
				else if(z==null || z=="")
  			{
				alert("Number must be filled");
				return false;
  			}
			
				else if(b==null || b=="")
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
				else if(v!=a)
				{
					alert("New and confirm password entered doesn't match");
					return false;
				}
              
            }
        </script>
    </head>

    <body >
    <div class="container">
    <%@ include file="HomeHeader.jsp" %>
        <h1 style="padding-top:50px;">Please enter your complete details below</h1>
        ${d}
        <form method = 'post' action = 'addnewcustomer' name="addhadmin" id="addhadmin"  onsubmit="return validateForm()">
            
             <table class="table table-bordered">
                 <tr>
                     <td> UserName: </td><td> <input type="text"  name="username" id='username'></td>
                 </tr>
                 <tr>
            <td>Password: </td><td> <input type="password"  name="password" id="password"></td>
                 </tr>
                 <tr>
            <td>Confirm Password: </td><td> <input type="password"  name="confirmpassword" id="confirmpassword"></td>
                 </tr>
                 <tr>
           <td> First Name: </td><td> <input type="text"  name="firstname" id="firstname"></td>
                 </tr>
                 <tr>
            <td> Last Name: </td><td> <input type="text"  name="lastname" id="lastname"></td>
                 </tr>
                 
                 <tr>
                 <td>
                 	Gender : <input type="radio" name = "gender" value="Male" checked/>Male
						     <input type="radio" name = "gender" value="Female"/>Female
                 </td>
                 
                 </tr>
                 <tr>
           <td>  Email ID: </td><td> <input type="email"  name="emailid" id="emailid"></td>
                 </tr>
				 <tr>
           <td>  Contact No: </td><td> <input type="number"  name="number" id="number" min="000000000" max="9999999999"></td>
                 </tr>
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