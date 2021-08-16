package com.denote;

import java.awt.*;
import java.awt.image.*;
 
import javax.imageio.*;
 
import java.awt.font.*;
import java.awt.geom.*;
 
import java.io.*;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class ChartServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
 
 
 
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("image/jpeg");
		
		int width = 155; //the width and height of the image
		int height = 155;
		
		int x = 5;
		int y = 5;
		int ellipseWidth = 145;
		int ellipseHeight = 145;
 
		BufferedImage bi = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = (Graphics2D) bi.getGraphics();
		
		RenderingHints renderHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
			    RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHints(renderHints);
		
		g2.setBackground(Color.WHITE);
		g2.clearRect(0, 0, width, height);
		g2.setPaint(Color.BLACK);
		
		 //Circle outside the pie chart
		Ellipse2D.Double ellipse = new Ellipse2D.Double(x, y, ellipseWidth, ellipseHeight);
		g2.draw(ellipse);
		
		g2.setPaint(Color.RED);
		g2.fillArc(x, y, ellipseWidth, ellipseHeight, 0, 120);
		
		g2.setPaint(Color.GREEN);
		g2.fillArc(x, y, ellipseWidth, ellipseHeight, 120 , 120);
		
		g2.setPaint(Color.blue);
		g2.fillArc(x, y, ellipseWidth, ellipseHeight, 240, 120);
		
			
		ImageIO.write(bi, "jpg", response.getOutputStream());
		
	}
 
}