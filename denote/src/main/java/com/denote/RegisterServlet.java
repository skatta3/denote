package com.denote;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 

 
public class RegisterServlet extends HttpServlet 
{ 
     public RegisterServlet() 
     {
     }
     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
     { 
         Register register = new Register();       
         register.setName(request.getParameter("name"));
         register.setPassword(request.getParameter("password")); 
         register.setEmail(request.getParameter("email"));              
         register.setPhoneno(request.getParameter("phoneno"));         
         RegisterDao registerDao = new RegisterDao();
         String userRegistered = registerDao.registerUser(register);         
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
