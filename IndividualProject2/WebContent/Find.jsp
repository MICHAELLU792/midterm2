<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Find</title>
<style type="text/css">
table {
	text-align: left;
	background-color: #009FCC;
	border: 1.5px solid #FFFFFF;
	border-collapse: collapse;
	margin-bottom: 10px;
	margin-top: 6px;
}

td {
	text-align: left;
	border-right: 1.5px solid #FFFFFF;
	color: #FFFFFF;
	padding: 6px;
	font-family: 微軟正黑體;
}

.sub {
	text-align: center;
}

fieldset {
	background-color: #009FCC;
	width: 660px;
	border: none;
	margin: 0 auto;
	border-radius: 15px;
}

fieldset legend {
	color: #FFAA33;
	font-size: 20px;
	margin-left: 10px;
	font-family: 標楷體
}
</style>
</head>
<body>
	<fieldset>
		<legend>查詢結果</legend>
		<table border="1">
			<tr>
				<td>河川名</td>
				<td>觀測站</td>
				<td>觀測時間</td>
				<td>汙染程度</td>
				<td>汙染等級</td>
				<td>溶氧量</td>
				<td>氨含量</td>
				<td>懸浮粒子</td>
			</tr>
			<tr>
				<td>${findbyObvKey.name}</td>
				<td>${findbyObvKey.observatory}</td>
				<td>${findbyObvKey.testdate}</td>
				<td>${findbyObvKey.level}</td>
				<td>${findbyObvKey.RPI}</td>
				<td>${findbyObvKey.DO}</td>
				<td>${findbyObvKey.ammonia}</td>
				<td>${findbyObvKey.SS}</td>
			</tr>
		</table>
		<div class="sub">
			<input type="button" onclick="location.href='Index.jsp'" value="BACK">
		</div>
	</fieldset>
</body>
</html>