<%@page import="com.pichill.coupon.entity.Coupon"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.pichill.coupon.entity.Coupon"%>

<% //見com.emp.controller.EmpServlet.java第238行存入req的empVO物件 (此為輸入格式有錯誤時的empVO物件)
   Coupon coupon = (Coupon) request.getAttribute("coupon");
%>
<%-- --<%= manage==null %>--${manage.manageID}-- <!-- line 100 --> --%>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>優惠券資料新增 - addCoupon.jsp</title>

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
	width: 450px;
	background-color: white;
	margin-top: 1px;
	margin-bottom: 1px;
  }
  table, th, td {
    border: 0px solid #CCCCFF;
  }
  th, td {
    padding: 1px;
  }
</style>

</head>
<body bgcolor='white'>

<table id="table-1">
	<tr><td>
		 <h3>優惠券資料新增 - addCoupon.jsp</h3></td><td>
		 <h4><a href="select_page.jsp"><img src="../image/smallLogo.png" width="100" height="100" border="0">回首頁</a></h4>
	</td></tr>
</table>

<h3>資料新增:</h3>

<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<FORM METHOD="post" ACTION="coupon.do" name="form1">
<table>
	
	
	
	
	<tr>
		<td>優惠券序號:</td>
		<td><input type="TEXT" name="couponID" value="<%= (couponID==null)? "52000002" : coupon.getCouponID()%>" size="45"/></td>
	</tr>
	<tr>
		<td>序號:</td>
		<td><input type="TEXT" name="productID"   value="<%= (productID==null)? "51000002" : coupon.getProductID()%>" size="45"/></td>
	</tr>
	
	<!-- <tr>
		<td>狀態:</td>
		<td>
			<select name="mStatus">
				<option value="0">已使用</option>
				<option value="1" selected>未使用</option>
				<option value="-1" selected>作廢（過期）</option>
			</select>
		</td>
	</tr>
	 -->

<%-- 	<jsp:useBean id="deptSvc" scope="page" class="com.dept.model.DeptService" /> --%>
<!-- 	<tr> -->
<!-- 		<td>部門:<font color=red><b>*</b></font></td> -->
<!-- 		<td><select size="1" name="deptno"> -->
<%-- 			<c:forEach var="deptVO" items="${deptSvc.all}"> --%>
<%-- 				<option value="${deptVO.deptno}" ${(empVO.deptno==deptVO.deptno)? 'selected':'' } >${deptVO.dname} --%>
<%-- 			</c:forEach> --%>
<!-- 		</select></td> -->
<!-- 	</tr> -->

</table>
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" value="送出新增"></FORM>

</body>

</html>