<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="com.pichill.managejdbc.entity.Manage"%>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%
   Manage manage = (Manage) request.getAttribute("manage"); //ManageServlet.java(Concroller), 存入req的manage物件
%>

<html>
<head>
<title>員工資料 - listOneManage.jsp</title>

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
		 <h3>員工資料 - listOneManage.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="../image/smallLogo.png" width="50" height="50" border="0">回首頁</a></h4>
	</td></tr>
</table>

<table>
	<tr>
			<th>管理員編號</th>
            <th>員工姓名</th>
            <th>帳號</th>
            <th>密碼</th>
            <th>生日</th>
            <th>性別</th>
            <th>手機</th>
            <th>緊急聯絡人</th>
            <th>緊急連絡人電話</th>
            <th>聯絡地址</th>
            <th>入職日期</th>
            <th>最後上線時間</th>
            <th>身分證</th>
            <th>電子信箱</th>
<!--             <th>大頭貼</th> -->
            <th>狀態</th>
	</tr>
	<tr>
		<td><%=manage.getManageID()%></td>
		<td><%=manage.getmName()%></td>
		<td><%=manage.getmUserName()%></td>
		<td><%=manage.getmPassword()%></td>
		<td><%=manage.getmBirth()%></td>
		<td><%=manage.getmGender()%></td>
		<td><%=manage.getmTelephone()%></td>
		<td><%=manage.getmEmgContact()%></td>
		<td><%=manage.getmEmgPhone()%></td>
		<td><%=manage.getmAddress()%></td>
		<td><%=manage.getmHiredate()%></td>
		<td><%=manage.getmLastLogTime()%></td>
		<td><%=manage.getmID()%></td>
		<td><%=manage.getmEmail()%></td>
<%-- 		<td><%=manage.getmProfilePic()%></td> --%>
		<td><%=manage.getmStatus()%></td>
	</tr>
</table>

</body>
</html>