<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.awt.*"%>
<%@ page import="java.io.*"%>
<%@ page import="org.jfree.chart.*"%>
<%@ page import="org.jfree.chart.entity.*"%>
<%@ page import="org.jfree.data.general.*"%>

<%
    DefaultPieDataset pieDataset = new DefaultPieDataset();
    pieDataset.setValue("JavaWorld", new Integer(75));
    pieDataset.setValue("Other", new Integer(25));
    JFreeChart chart = ChartFactory.createPieChart("Sample Pie Chart",pieDataset,true,true,false);
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pie Chart</title>
</head>
<body>
    <IMG SRC="piechart.png" WIDTH="600" HEIGHT="400" BORDER="0"
        USEMAP="#chart">
</body>
</html>