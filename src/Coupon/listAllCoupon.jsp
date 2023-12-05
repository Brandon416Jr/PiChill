<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<%@ page import="com.pichill.coupon.entity.Coupon"%>
<%@ page import="com.pichill.coupon.model.*"%>
<%@ page import="com.pichill.coupon.service.CouponService"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
    CouponService manageSvc = new CouponService();
    List<Coupon> list = CouponService.getAll();
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
            <th>狀態</th>
	</tr>
		    <c:forEach var="manage" items="${list}">
		    
		<tr>
			<td>${manage.manageID}</td>
			<td>${manage.mName}</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/coupon/coupon.do" style="margin-bottom: 0px;">
			     <input type="submit" value="修改">
			     <input type="hidden" name="manageID"  value="${coupon.couponID}">
			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
			</td>
		</tr>
	</c:forEach>
</table>
<%-- <%@ include file="page2.file" %> --%>

</body>
</html>