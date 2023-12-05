<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="com.pichill.test.entity.*"%>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%
GeneralUser generalUser = (GeneralUser) request.getAttribute("generalUser"); //GeneralUserServlet.java(Concroller), 存入req的generalUser物件
%>

<html>
<head>
<title>會員資料 - listOneGeneralUser.jsp</title>

<style>
  table#table-1 {
	background-color: #CCCCFF;
    border: 2px solid black;
    text-align: center;
  }
  table#table-1 h4 {
    color: red;
    display: block;
    margin-bottom: 1px;
  }
  h4 {
    color: blue;
    display: inline;
  }
</style>

<style>
  table {
	width: 600px;
	background-color: white;
	margin-top: 5px;
	margin-bottom: 5px;
  }
  table, th, td {
    border: 1px solid #CCCCFF;
  }
  th, td {
    padding: 5px;
    text-align: center;
  }
</style>

</head>
<body bgcolor='white'>

<h4>此頁暫練習採用 Script 的寫法取值:</h4>
<table id="table-1">
	<tr><td>
		 <h3>會員資料 - listOneGeneralUser.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>會員編號</th>
		<th>會員姓名</th>
		<th>帳號(電子信箱)</th>
		<th>密碼</th>
		<th>身分證字號</th>
		<th>性別</th>
		<th>出生年月日</th>
		<th>聯絡電話</th>
		<th>聯絡地址</th>
		<th>帳號狀態</th>
	</tr>
	<tr>
		<td><%=generalUser.getgUserID()%></td>
		<td><%=generalUser.getgName()%></td>
		<td><%=generalUser.getgEmail()%></td>
		<td><%=generalUser.getgPassword()%></td>
		<td><%=generalUser.getgIDNum()%></td>
		<td><%=generalUser.getgGender()%></td>
		<td><%=generalUser.getgBirth()%></td>
		<td><%=generalUser.getgTelephone()%></td>
		<td><%=generalUser.getgAddress()%></td>
		<td><%=generalUser.getStatus()%></td>
		
		
	</tr>
</table>

</body>
</html>