<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*" %>
<%
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	String connUrl = "jdbc:sqlserver://localhost:1433;databaseName=DB01";
 	Connection conn=DriverManager.getConnection(connUrl,"sa","passw0rd");

	
	String qryStmt="SELECT observatory FROM water_testing";
	PreparedStatement stmt = conn.prepareStatement(qryStmt);
	ResultSet rs = stmt.executeQuery();
	
	String str = "<select name='observatory'>";
	String observatory;
	while(rs.next()){
		observatory=rs.getString("observatory");
		str += "<option value='"+ observatory +"'>"+ observatory;
		
	}
	str += "</select>";
	out.print(str);
	conn.close();



%>