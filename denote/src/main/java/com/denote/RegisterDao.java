package com.denote;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDao { 
     public String registerUser(Register register)
     {
         String name = register.getName();
         String password = register.getPassword();
         String email = register.getEmail();
         String phoneno = register.getPhoneno();      
         Connection con = null;
         PreparedStatement preparedStatement = null;         
         try
         {
             con = DBConnect.createConnection();
             String query = "insert into user(name,password,email,phoneno) values (?,?,?,?)";
             preparedStatement = con.prepareStatement(query);
             preparedStatement.setString(1, name);
             preparedStatement.setString(2, password);
             preparedStatement.setString(3, email);
             preparedStatement.setString(4, phoneno);                         
             int i= preparedStatement.executeUpdate();             
             if (i!=0)  
             return "SUCCESS"; 
         }
         catch(SQLException e)
         {
            e.printStackTrace();
         }       
         return "Oops.. Something went wrong there..!"; 
     }
 
     
     public String editUser(Register edit)
     {
         String name = edit.getName();
         //String password = edit.getPassword();
         String email = edit.getEmail();
         String phoneno = edit.getPhoneno();      
         String gender = edit.getGender();
         String dob = edit.getDob();      
         Connection con = null;
         PreparedStatement preparedStatement = null;         
         try
         {
             con = DBConnect.createConnection();
             String query = "update user set email=?,name=?,phoneno=?,gender=?,dob=? where email="+email;
             preparedStatement = con.prepareStatement(query);
             preparedStatement.setString(1, email);
        
             preparedStatement.setString(2, name);
             preparedStatement.setString(3, phoneno);  
             preparedStatement.setString(4, gender); 
             preparedStatement.setString(5, dob); 
             int i= preparedStatement.executeUpdate();             
             if (i!=0)  
             return "SUCCESS"; 
         }
         catch(SQLException e)
         {
            e.printStackTrace();
         }       
         return "Oops.. Something went wrong there..!"; 
     }
 
     
}
