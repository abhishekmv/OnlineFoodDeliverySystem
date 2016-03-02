
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
                
                var b = document.forms["addhadmin"]["cardtype"].value;
                var c = document.forms["addhadmin"]["cardno"].value;
                var d = document.forms["addhadmin"]["cvv"].value;
                var e = document.forms["addhadmin"]["expiry"].value;
            
				
			
			
				 if(b==null || b=="")
	  			{
					alert("card type must be filled");
					return false;
	  			}
				
				else if(c==null || c=="")
	  			{
					alert("card no must be filled");
					return false;
	  			}
				else if(d==null || d=="")
	  			{
					alert("cvv must be filled");
					return false;
	  			}
				else if(e==null || e=="")
	  			{
					alert("expiry date must be filled");
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
        <form method = 'post' action = 'addnewpayment' name="addhadmin" id="addhadmin"  onsubmit="return validateForm()">
            
             <table class="table table-bordered">
                
                  <tr>
           <td> Card Type: </td><td> <input type="text"  name="cardtype" id="cardtype"></td>
                 </tr>
                  <tr>
           <td> Card Number: </td><td> <input type="number"  name="cardno" id="cardno" min="1111111111" max="9999999999"></td>
                 </tr>
                 <tr>
           <td> Cvv: </td><td> <input type="number"  name="cvv" id="cvv" min="111" max="999"></td>
                 </tr>
                  <tr>
           <td> Expiry Date: </td><td> <input type="date"  name="expiry" id="expiry"></td>
                 </tr>
                 
            </table>
            <input type="submit" value="submit">
        </form>
        </div>
    </body>
</html>