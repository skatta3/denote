package com.denote;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 

 
public class EditServlet extends HttpServlet 
{ 
     public EditServlet() 
     {
     }
     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
     { 
         Register register = new Register();       
         register.setEmail(request.getParameter("email"));
         
         register.setName(request.getParameter("name"));              
         register.setPhoneno(request.getParameter("phoneno"));    
         register.setGender(request.getParameter("gender")); 
         register.setDob(request.getParameter("dob")); 
         RegisterDao registerDao = new RegisterDao();
         String userRegistered = registerDao.editUser(register);         
         if(userRegistered.equals("SUCCESS"))  
         {
            request.getRequestDispatcher("RegisterSuccess.jsp").forward(request, response);
         }
         else  
         {
            request.setAttribute("errMessage", userRegistered);
            request.getRequestDispatcher("/RegisterError.jsp").forward(request, response);
         }
     }
    
}