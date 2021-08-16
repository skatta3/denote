package com.denote;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset; 
public class BarChartJDBCExample {  
        
        public static void main(String[] args) throws Exception{
                
                Class.forName ("com.mysql.jdbc.Driver"); 
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jayesh", "root", "admin");
                DefaultCategoryDataset my_bar_chart_dataset = new DefaultCategoryDataset();
                Statement stmt = conn.createStatement();
                try {
                        ResultSet query_set = stmt.executeQuery("select category,marks from chart_data");
                        while (query_set.next()) {
                                String category = query_set.getString("CATEGORY");
                                int marks = query_set.getInt("MARKS");
                                my_bar_chart_dataset.addValue(marks,"Mark",category);
                                }
                JFreeChart BarChartObject=ChartFactory.createBarChart("Subject Vs Marks - Bar Chart","Subject","Marks",my_bar_chart_dataset,PlotOrientation.VERTICAL,true,true,false);                  
                query_set.close();
                stmt.close(); 
                conn.close();
                int width=640; /* Width of the image */
                int height=480; /* Height of the image */                
                File BarChart=new File("bar-chart_chart.png");    
                System.out.println("Bar Chart is Craeted");
                ChartUtilities.saveChartAsPNG(BarChart,BarChartObject,width,height); 
                }
                 catch (Exception i)
                 {
            System.out.println(i);
                 }
   
        }
}  