<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>Login Page</title>
    <link rel="stylesheet" href="Style.css">
  </head>
  <body>
    <div class="center">
      <h1>Login</h1>
      <form action="Login" method="post">
        <div class="txt_field">
          <input type="text" name="email"required><label>Enter Email</label>
        </div>
        <div class="txt_field">
          <input type="password" name="password" required><label> Enter Password</label>
        </div>
        <div class="pass"><a href="ForgotPassword.jsp">Forgot Password?</div>
        <input type="submit" value="Login">
        <div class="signup_link">
          Not a member? <a href="Signup.jsp">Signup</a>
        </div>
      </form>
      
    
    <div class="right">
    <div class="alert" >
    
  <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span> 
  <strong></strong> Invalid Email id and Password.
</div></div></div>
</body>
</html>
