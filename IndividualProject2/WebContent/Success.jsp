<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success</title>
<style type="text/css">

table {
	text-align: left;
	background-color:#009FCC;

	border-collapse: collapse;
 	margin-bottom: 6px; 
 	margin-top: 6px; 
}

td {
	text-align: left;

	color: #FFFFFF;
	padding: 6px;
	font-family: 微軟正黑體;
}

fieldset {
	background-color:#009FCC;
	width: 630px;
	border: 1px solid #FFFFFF;
	margin: 0 auto;
	border-radius: 15px;
}
</style>
</head>
<body>
<fieldset>
<table>
	<tr>
		<td><Font color='#FFFFFF' >您對於測站
		<font color="#00FFFF" >${userIdKey}</font>
		的操作已成功
		<font color="#00FF00" >${userIdKey2}</font>
		<font color="#FFDD55" >${userIdKey3}</font>
		<font color="#FF0000" >${userIdKey4}</font></font></td>
	</tr>
	<tr>
		<td>
			<input type="button" onclick="location.href='Index.jsp'" value="BACK">
		</td>
	</tr>
</table>	
</fieldset>	
</body>
</html>