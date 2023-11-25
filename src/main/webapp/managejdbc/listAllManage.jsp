<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<%@ page import="com.pichill.managejdbc.entity.Manage"%>
<%@ page import="com.pichill.managejdbc.model.*"%>
<%@ page import="com.pichill.managejdbc.service.ManageService"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
    ManageService manageSvc = new ManageService();
    List<Manage> list = manageSvc.getAll();
    pageContext.setAttribute("list",list);
%>


<html>
<head>
<title>所有員工資料 - listAllManage.jsp</title>

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
	width: 800px;
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

<h4>此頁練習採用 EL 的寫法取值:</h4>
<table id="table-1">
	<tr><td>
		 <h3>所有員工資料 - listAllManage.jsp</h3>
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
<%-- 	<%@ include file="page1.file" %>  --%>
<%-- 	<c:forEach var="empVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>"> --%>
		    <c:forEach var="manage" items="${list}">
		    
		<tr>
			<td>${manage.manageID}</td>
			<td>${manage.mName}</td>
			<td>${manage.mUserName}</td>
			<td>${manage.mPassword}</td>
			<td>${manage.mBirth}</td>
			<td>${manage.mGender == 0 ? '男' : '女'}</td>
			<td>${manage.mTelephone}</td>
			<td>${manage.mEmgContact}</td>
			<td>${manage.mEmgPhone}</td>
			<td>${manage.mAddress}</td>
			<td>${manage.mHiredate}</td>
			<td>${manage.mLastLogTime}</td>
			<td>${manage.mID}</td>
			<td>${manage.mEmail}</td>
<%-- 			<td>${manage.mProfilePic}</td> --%>
			<td>${manage.mStatus == 0 ? '已離職':'在職中'}</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/managejdbc/manage.do" style="margin-bottom: 0px;">
			     <input type="submit" value="修改">
			     <input type="hidden" name="manageID"  value="${manage.manageID}">
			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
			</td>
<!-- 			<td> -->
<%-- 			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/managejdbc/manage.do" style="margin-bottom: 0px;"> --%>
<!-- 			     <input type="submit" value="刪除"> -->
<%-- 			     <input type="hidden" name="manageID"  value="${manage.manageID}"> --%>
<!-- 			     <input type="hidden" name="action" value="delete"></FORM> -->
<!-- 			</td> -->
		</tr>
	</c:forEach>
</table>
<%-- <%@ include file="page2.file" %> --%>

</body>
</html>