package com.denote;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			//PrintWriter out = response.getWriter();
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			System.out.println("Form Input: " +email + password);
			try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/denote","root","admin");
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("select email,password from user where email='"+email+"' and password='"+password+"'");
					
					if(rs.next()) {
						System.out.println("Found the match");
						response.sendRedirect("HomePage.jsp");
						String Email = rs.getString("email");
						HttpSession session = request.getSession();
						session.setAttribute("email", Email);
					}else {
						response.sendRedirect("LoginError.jsp");
					}

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}