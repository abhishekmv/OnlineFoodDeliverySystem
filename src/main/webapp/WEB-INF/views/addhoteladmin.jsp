
<!DOCTYPE html>
<html>
    <head>
    <title>Add Hotel Admin</title>
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
              
            }
        </script>
    </head>

    <body >
    <div class="container">
    <%@ include file="hoteladmin_navbar.jsp" %>
        <h1>Please enter the Hotel Admin details below</h1>
        ${d}
        <form method = 'post' action = 'hoteladminadd' name="addhadmin" id="addhadmin"  onsubmit="return validateForm()">
            
             <table class="table table-bordered">
                 <tr>
                     <td> UserName: </td><td> <input type="text"  name="username" id='username'></td>
                 </tr>
                 <tr>
            <td>Password: </td><td> <input type="text"  name="password" id="password"></td>
                 </tr>
                 <tr>
           <td> First Name: </td><td> <input type="text"  name="firstname" id="firstname"></td>
                 </tr>
                 <tr>
            <td> Last Name: </td><td> <input type="text"  name="lastname" id="lastname"></td>
                 </tr>
                 <tr>
           <td>  Email ID: </td><td> <input type="email"  name="emailid" id="emailid"></td>
                 </tr>
				 <tr>
           <td>  Contact No: </td><td> <input type="number"  name="number" id="number"></td>
                 </tr>
            </table>
            <input type="submit" value="submit">
        </form>
        </div>
    </body>
</html>