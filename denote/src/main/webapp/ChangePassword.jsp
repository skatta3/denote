<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>Change Password</title>
    <link rel="stylesheet" href="Style.css">
    <script language="javascript">
function fncSubmit()
            {
                if(document.ChangePasswordForm.currentpwd.value=="")
                {
                    alert('Please input old password');
                    document.ChangePasswordForm.newpwd.focus();  //To focus the cursor in the old password text box
                    return false;
                     
                }
                if(document.ChangePasswordForm.confirm.value=="")
                {
                    alert('Please input confirm password');
                    document.ChangePasswordForm.confirm.focus(); //to focus the cursor in the new password text box
                    return false;
                     
                }
                 
                if(document.ChangePasswordForm.newpwd.value != document.ChangePasswordForm.confirm.value)
                {//checking whether the newpassword and confirm password entered by the user is a match or not
                    alert('Confirm password does not match with the new password');
                    document.ChangePasswordForm.confirm.focus(); //if doest not match focusing the cursor in the confirm pssword text box
                    return false;
                     
                }
                 
                document.ChangePasswordForm.submit();
                 
            }
            </script>
  </head>
  <body>
   <form name="ChangePasswordForm" action="ChangePasswordServlet" method="POST" onsubmit="return fncSubmit();">
    <div class="center">
      <h1>Change Password</h1>
      
        <div class="txt_field">
          <input type="password" name="currentpwd"required>
        
          <label>Enter Current Password</label>
        </div>
        <div class="txt_field">
          <input type="password" name="newpwd" required>
          
          <label> Enter New Password</label>
        </div>
        <div class="txt_field">
          <input type="password" name="confirmpwd" required>
          
          <label> Enter Confirm Password</label>
        </div>
        <input type="submit" value="Change">
        
      </form>
    </div>
</body>
</html>
