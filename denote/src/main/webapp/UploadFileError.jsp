<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Add Category</title>
<link rel="stylesheet" href="Style.css">
</head>
<body>
<div class="center">
<h1>Add Category</h1>
<form action="UploadFile" method="post" enctype="multipart/form-data">
        <div class="txt_field">
          <input type="text" name="title" required>        
          <label>Enter Title</label>
        </div>
        <div class="txt_field">
          <input type="file" name="uploadicon" required>
          
          <label> Upload icon</label>
        </div>
<input type="submit" value="create">

</form>
<div class="right">
    <div class="alert" >
    
  <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span> 
  <strong></strong> File Size is too large.
</div></div>
</div>

</body>
</html>