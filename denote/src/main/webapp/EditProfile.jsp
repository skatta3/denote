<% String email=(String)session.getAttribute("email");
	
if(email==null)
{
	response.sendRedirect("Login.jsp");
}
else
{ 
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="Style.css">
</head>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
<%
Connection con= null;
PreparedStatement ps = null;
ResultSet rs = null;
String driverName = "com.mysql.cj.jdbc.Driver";
String url = "jdbc:mysql://localhost:3306/denote";
String user = "root";
String dbpsw = "ramya";
String sql = "select * from user where email=?";

try{
Class.forName(driverName);
con = DriverManager.getConnection(url,user,dbpsw);
ps = con.prepareStatement(sql);
ps.setString(1,email);
rs = ps.executeQuery();
while(rs.next())
{%>

<body>
<div class="center">
		<h1>Edit Profile</h1>
			<form name="form" action="EditServlet"  method="POST" onsubmit="return validate()">
			
			<div class="txt_field"><input type="txt_field" name="email" value="<% out.println(rs.getString(4));%>"><label>E-mail</label></div>
			<div class="txt_field"><input type="txt_field" name="name" value="<% out.println(rs.getString(2));%>"required><label>Name</label></div>
			
			<div class="txt_field"><input type="txt_field" name="phoneno" value="<% out.println(rs.getString(5));%>"required><label>phoneno</label></div>
			<div class="txt_field"><input type="txt_field" name="gender" value="<% out.println(rs.getString(6));%>"required><label>Gender</label></div>
			<div class="txt_field"><input type="date" name="dob" value="<% out.println(rs.getString(7));%>"required><label>Date Of Birth</label></div>
			
			<input type="submit" value="Edit">
	<br>
	<br>
	
	</form>
	</div>


<%
}
rs.close();
ps.close(); 
}
catch(SQLException sqe)
{
out.println(sqe);
}
} %>
</table>
</body>
</html>
