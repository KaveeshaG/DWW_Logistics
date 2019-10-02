<%@page import="com.wms.model.GRN"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.wms.model.Item"%>
<%@page import="com.wms.service.GoodHandlingServiceImpl"%>
<%@page import="com.wms.service.IGoodHandlingService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<%
	out.print("K");
	IGoodHandlingService goodHandlingService = new GoodHandlingServiceImpl();

	ArrayList<Item> k = goodHandlingService.getReqItemList();
	
	for(Item l : k){
		out.println(l);
		
	}
	
	out.print("\n");
	
	ArrayList<Item> l = goodHandlingService.getItemList();
	
	for(Item u : l){
		out.println(u);
		
	}
	
%>


</body>
</html>