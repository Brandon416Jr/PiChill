<%@ page language="java" contentType="text/html; charset=UTF-8"　pageEncoding="UTF-8"%>
<%@ page import="com.pichill.owneruser.entity.*"%>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%
OwnerUser ownerUser = (OwnerUser) request.getAttribute("ownerUser"); //OwnerUserServlet.java(Concroller), 存入req的generalUser物件
%>

<!DOCTYPE html>
<html>


<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>企業會員資料 - listOneOwnerUser.jsp</title>
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
		 <h3>會員資料 - listOneOwnerUser.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a></h4>
	</td></tr>
</table>
<table>
	<tr>
		<th>企業會員編號</th>
		<th>帳號</th>
		<th>密碼</th>
		<th>身分證字號</th>
		<th>統編</th>
		<th>場館負責人姓名</th>
		<th>性別</th>
		<th>出生年月日</th>
		<th>聯絡電話</th>
		<th>聯絡地址</th>
		<th>銀行代號</th>
		<th>銀行帳號</th>
		<th>大頭貼</th>
		<th>電子信箱</th>
		<th>修改</th>
<!-- 		<th>刪除</th> -->s
	</tr>

		
		<tr>
			<td>${ownerUser.oUserID}</td>
			<td>${ownerUser.oUserName}</td>
			<td>${ownerUser.oPassword}</td>
			<td>${ownerUser.oIDNum}</td>
			<td>${ownerUser.compiled}</td>
			<td>${ownerUser.oName}</td>
			<td>${ownerUser.oGender == 0 ? '男':'女'}</td>
			<td>${ownerUser.oBirth}</td>
			<td>${ownerUser.oTelephone}</td>
			<td>${ownerUser.oAddress}</td>
			<td>${ownerUser.oBankCode}</td>
			<td>${ownerUser.oBankAccount}</td>
			<td>${ownerUser.oProfilePic}</td>
			<td>${ownerUser.oEmail}</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/owneruser/owneruser.do" style="margin-bottom: 0px;">
			     <input type="submit" value="修改">
			     <input type="hidden" name="oUserID"  value="${ownerUser.oUserID}">
			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
			</td>


		</tr>

</table>


</body>
</html>