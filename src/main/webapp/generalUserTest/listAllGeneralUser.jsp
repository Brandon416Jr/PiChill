<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.pichill.test.entity.GeneralUser"%>
<%@ page import="com.pichill.test.model.*"%>
<%@ page import="com.pichill.test.service.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
	GeneralUserService generalUserSvc = new GeneralUserService();
    List<GeneralUser> list = generalUserSvc.getAll();
    pageContext.setAttribute("list",list);
%>


<html>
<head>
<title>所有一般會員資料 - listAllGeneralUser.jsp</title>

<style>
  table#table-1 {
	background-color: #207DCA;
/*     border: 2px solid black; */
    text-align: center;
  }
  table#table-1 h4 {
    color: red;
    display: block;
    margin-bottom: 1px;
  }
  h3 {
    color: white;
  }
  h4 {
    color: blue;
    display: inline;
  }
</style>

<style>
  table {
	width: 1250px;
	background-color: white;
	margin-top: 5px;
	margin-bottom: 5px;
  }
  table, th, td {
    border: 1px solid #207DCA;
  }
  th, td {
    padding: 5px;
    text-align: center;
  }
</style>

</head>
<body bgcolor='white'>

<h4>此頁練習採用 EL 的寫法取值:</h4>
<table id="table-1">
	<tr><td>
		 <h3>所有一般會員資料 - listAllGeneralUser.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="images/logo.png" width="200" height="80" border="0">  回首頁</a></h4>
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
		<th>修改</th>
<!-- 		<th>刪除</th> -->
	</tr>
	
	<c:forEach var="generalUser" items="${list}" >
		
		<tr>
			<td>${generalUser.gUserID}</td>
			<td>${generalUser.gName}</td>
			<td>${generalUser.gEmail}</td>
			<td>${generalUser.gPassword}</td>
			<td>${generalUser.gIDNum}</td>
			<td>${generalUser.gGender}</td>
			<td>${generalUser.gBirth}</td>
			<td>${generalUser.gTelephone}</td>
			<td>${generalUser.gAddress}</td>
			<td>${generalUser.status}</td> 
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/generalUser/generalUser.do" style="margin-bottom: 0px;">
			     <input type="submit" value="修改">
			     <input type="hidden" name="gUserID"  value="${generalUser.gUserID}">
			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
			</td>
<!-- 			<td> -->
<%-- 			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/generaluser/generalUser.do" style="margin-bottom: 0px;"> --%>
<!-- 			     <input type="submit" value="刪除"> -->
<%-- 			     <input type="hidden" name="gUserID"  value="${generalUser.gUserID}"> --%>
<!-- 			     <input type="hidden" name="action" value="delete"></FORM> -->
<!-- 			</td> -->
		</tr>
	</c:forEach>
</table>
<%-- <%@ include file="page2.file" %> --%>

</body>
</html>