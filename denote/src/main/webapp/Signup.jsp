<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Form</title>
<link rel="stylesheet" href="Style.css">
<script> 
function validate()
{ 
     var name = document.form.name.value;     
     var email = document.form.email.value;
     var password = document.form.password.value;
     var phoneno = document.form.phoneno.value; 
     
     var conpassword= document.form.conpassword.value;
     
     
     
 	var validemail =/^([a-zA-Z0-9_\-\.]+)@([a-zA-Z0-9_\-\.]+)\.([a-zA-Z]{2,5})$/;
 	if(!(validemail.test(email)))
 	{
 		alert("Invalid email address");
 		document.forms["form"]["email"].focus();
 		return false;
 	}
     
     if (name==null || name=="")
     { 
     alert("Full Name can't be blank"); 
     return false; 
     }
     else if (email==null || email=="")
     { 
     alert("Email can't be blank"); 
     return false; 
     }
     else if (password==null || password=="")
     { 
     alert("Username can't be blank"); 
     return false; 
     }
     else if(password.length<6)
     { 
     alert("Password must be at least 6 characters long."); 
     return false; 
     } 
     else if (password!=conpassword)
     { 
     alert("Confirm Password should match with the Password"); 
     return false; 
     } 
     
}
</script> 

</head>
<body>

<div class="center">
		<h1>Sign Up</h1>
			<form name="form" action="RegisterServlet"  method="POST" onsubmit="return validate()">
			<div class="txt_field"><input type="text" name="name" required>	<label>Full Name</label></div>
			<div class="txt_field"><input type="text" name="email" required>	<label>E-mail</label></div>
			<div class="txt_field"><input type="password" name="password" required><label>Password</label></div>
			<div class="txt_field"><input type="password" name="conpassword" required><label>Confirm Password</label></div>
			<div class="txt_field"><input type="txt_field" name="phoneno" required><label>phoneno</label></div>
			<input type="submit" value="Register">
			
	<br>
	<br>
	
	</form>
	</div>
</body>
</html>
