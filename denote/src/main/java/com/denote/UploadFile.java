package com.denote;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/UploadFile")
@MultipartConfig
public class UploadFile extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,  HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html;charset=UTF-8");
	    String category= request.getParameter("title");
	    final Part filePart = request.getPart("uploadicon");   
	    InputStream pdfFileBytes = null;
	    final PrintWriter writer = response.getWriter();
	    try
	    {
	    	
	    	
     	    if (filePart.getSize()>1048576 ) 
     	    { 
     		   {
     			   response.sendRedirect("UploadFileError.jsp");
     			   writer.println("<br/> File size too big");
     			   return;
     		   }
     	   }
     	    
	        pdfFileBytes = filePart.getInputStream(); 
	        final byte[] bytes = new byte[pdfFileBytes.available()];
	        pdfFileBytes.read(bytes); 
	        Connection  con=null;
	        Statement stmt=null;
		    try
		    {
		    	  Class.forName("com.mysql.cj.jdbc.Driver");
		    	  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/denote","root","ramya");
		     } 
		    catch (Exception e) 
		    {
		    	  System.out.println(e);
		          System.exit(0);
		    }       		       
			int success=0;
		    PreparedStatement pstmt = con.prepareStatement("insert into category(categoryname,categoryicon) values (?,?)");
		    pstmt.setString(1, category);
		    pstmt.setBytes(2,bytes);    //Storing binary data in blob field.
		    success = pstmt.executeUpdate();
		    if(success>=1)  System.out.println("File Stored");
		    con.close(); 
		    response.sendRedirect("HomePage.jsp");
		        // writer.println("<br/> File Stored Successfully");
	    } 
	    catch (FileNotFoundException fnf)
	    {
	      
	        writer.println("<br/> ERROR: " + fnf.getMessage());

	    } 
	    catch (SQLException e) 
	    {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	    finally 
	    {

	        if (pdfFileBytes != null) 
	        {
	        	pdfFileBytes.close();
	        }
	        if (writer != null)
	        {
	            writer.close();
	        }
	    }

	}

} 