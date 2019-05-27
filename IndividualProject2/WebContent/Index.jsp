<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
<style type="text/css">
table {
	text-align: left;
	background-color: #009FCC;
	margin-bottom: 10px;
	margin-top: 6px;
}

td {
	color: #FFFFFF;
	font-family: 微軟正黑體;
}

.sub {
	text-align: center;
}

fieldset {
	background-color: #009FCC;
	width: 390px;
	border: none;
	margin: 0 auto;
	border-radius: 15px;
}
</style>

</head>
<body onload="javascript:document.insertWater_test.observatory.focus();">
	<fieldset>
		<form name="insertWater_test" action='insert.do' method="POST">
			<table>
				<tr>
					<td align="right">觀測站:</td>
					<td align="left"><input type="text" name="observatory"
						value=""> <font color="#FFDD55" size="-1">${MsgMap.errorObservatory}</font></td>
				</tr>
				<tr>
					<td align="right">河川名:</td>
					<td align="left"><input type="text" name="name" value="基隆河">
						<font color="#FFDD55" size="-1">${MsgMap.errorName}</font></td>
				</tr>
				<tr>
					<td align="right">觀測時間:</td>
					<td align="left"><input type="text" id="date1" name="testdate"
						autocomplete="off" value="2019-05-20 16:30" /><span id="idsp2"></span><font
						color="#FFDD55" size="-1">${MsgMap.errorTestdate}</font></td>
				</tr>
				<tr>
					<td align="right">汙染程度:</td>
					<td align="left"><input type="text" name="level" value="中度汙染">
						<font color="#FFDD55" size="-1">${MsgMap.errorLevel}</font></td>
				</tr>
				<tr>
					<td align="right">汙染等級:</td>
					<td align="left"><input type="text" name="rpi" value="4.23">
						<font color="#FFDD55" size="-1">${MsgMap.errorRpi}</font></td>
				</tr>
				<tr>
					<td align="right">溶氧量:</td>
					<td align="left"><input type="text" name="Do" value="8.8">
						<font color="#FFDD55" size="-1">${MsgMap.errorDo}</font></td>
				</tr>
				<tr>
					<td align="right">氨含量:</td>
					<td align="left"><input type="text" name="ammonia"
						value="3.88"> <font color="#FFDD55" size="-1">${MsgMap.errorAmmonia}</font></td>
				</tr>
				<tr>
					<td align="right">懸浮粒子:</td>
					<td align="left"><input type="text" name="ss" value="6.8">
						<font color="#FFDD55" size="-1">${MsgMap.errorSS}</font></td>
				</tr>
				<tr>
					<td align="center"><input type="submit" value="新增"></td>
				</tr>
			</table>
		</form>


		<form name="updateWater_test" action='update.do' method="POST">
			<table>
				<tr>
					<td align="right">觀測站:</td>
					<td align="left"><span id="show"></span> <font color="#FFDD55"
						size="-1">${MsgMapU.errorObservatory}</font></td>
				</tr>
				<tr>
					<td align="right">河川名:</td>
					<td align="left"><input type="text" name="name" value="">
						<font color="#FFDD55" size="-1">${MsgMapU.errorName}</font></td>
				</tr>
				<tr>
					<td align="right">觀測時間:</td>
					<td align="left"><input type="text" name="testdate"
						value="2020-05-24 17:30" /> <font color="#FFDD55" size="-1">${MsgMapU.errorTestdate}</font></td>
				</tr>
				<tr>
					<td align="right">汙染程度:</td>
					<td align="left"><input type="text" name="level" value="高度汙染">
						<font color="#FFDD55" size="-1">${MsgMapU.errorLevel}</font></td>
				</tr>
				<tr>
					<td align="right">汙染等級:</td>
					<td align="left"><input type="text" name="rpi" value="10">
						<font color="#FFDD55" size="-1">${MsgMapU.errorRpi}</font></td>
				</tr>
				<tr>
					<td align="right">溶氧量:</td>
					<td align="left"><input type="text" name="Do" value="10">
						<font color="#FFDD55" size="-1">${MsgMapU.errorDo}</font></td>
				</tr>
				<tr>
					<td align="right">氨含量:</td>
					<td align="left"><input type="text" name="ammonia" value="20">
						<font color="#FFDD55" size="-1">${MsgMapU.errorAmmonia}</font></td>
				</tr>
				<tr>
					<td align="right">懸浮粒子:</td>
					<td align="left"><input type="text" name="ss" value="10">
						<font color="#FFDD55" size="-1">${MsgMapU.errorSS}</font></td>
				</tr>
				<tr>
					<td align="center"><input type="submit" value="修改"></td>
				</tr>
			</table>
		</form>

		<form action="findByObv.do" method="GET">
			<table>
				<tr>
					<td align="right">選擇測站:</td>
					<td align="left"><span id="show1"></span><font color="#FFDD55"
						size="-1">${MsgMapF.errorObservatory}</font></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td align="center"><input type="submit" value="查詢"></td>
				</tr>
			</table>
		</form>

		<form name="deleteWater_test" action='delete.do' method="POST">
			<table>
				<tr>
					<td align="right">選擇測站:</td>
					<td align="left"><span id="show2"></span><font color="#FFDD55"
						size="-1">${MsgMapD.errorObservatory}</font></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td align="center"><input type="submit" value="刪除"></td>
				</tr>
			</table>
		</form>
	</fieldset>
	<script>
		var xhttp = new XMLHttpRequest();
		xhttp.onload = function() {
			document.getElementById("show").innerHTML = this.responseText;
			document.getElementById("show1").innerHTML = this.responseText;
			document.getElementById("show2").innerHTML = this.responseText;
		}
		xhttp.open("GET", "SelectObsv.jsp", true);
		xhttp.send();
	</script>
</body>
</html>