package com.denote;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DownloadImage")
public class DownloadImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
@Override
protected void service(HttpServletRequest req,HttpServletResponse res) throws  ServletException,IOException{
	byte[] img=null;
	ServletOutputStream sos=null;
	Connection con = null;
    PreparedStatement preparedStatement = null;  
	
	try
	{
		 con = DBConnect.createConnection();
		 String sqlQuery="select categoryicon from category";
		PreparedStatement ps=con.prepareStatement(sqlQuery);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			img=rs.getBytes(1);
		}
		sos=res.getOutputStream();
		sos.write(img);
	}catch(Exception e)
	{
		e.printStackTrace();
	}
			
}
}
