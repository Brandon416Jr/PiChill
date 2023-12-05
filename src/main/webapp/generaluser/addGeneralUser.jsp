<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.pichill.generaluser.entity.*"%>

<% //見com.emp.controller.EmpServlet.java第238行存入req的empVO物件 (此為輸入格式有錯誤時的empVO物件)
	GeneralUser generalUser = (GeneralUser) request.getAttribute("generalUser");
%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>會員資料新增 - addGeneralUser.jsp</title>

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
		 <h3>會員資料新增 - addGeneralUser.jsp</h3></td><td>
		 <h4><a href="select_page.jsp"><img src="images/tomcat.png" width="100" height="100" border="0">回首頁</a></h4>
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

<FORM METHOD="post" ACTION="generaluser.do" name="form1">
<table>
	
	
	
	
	<tr>
		<td>會員姓名:</td>
		<td><input type="TEXT" name="gName" value="<%= (generalUser==null)? "劉晉歆" : generalUser.getgName()%>" size="45"/></td>
	</tr>
	<tr>
		<td>帳號(電子信箱):</td>
		<td><input type="TEXT" name="gEmail"   value="<%= (generalUser==null)? "carlisle1306@gmail.com" : generalUser.getgEmail()%>" size="45"/></td>
	</tr>
	<tr>
		<td>密碼:</td>
		<td><input type="TEXT" name="gPassword"   value="<%= (generalUser==null)? "v3PBw9Rs" : generalUser.getgPassword()%>" size="45"/></td>
	</tr>
	<tr>
		<td>身分證字號:</td>
		<td><input type="TEXT" name="gIDNum"   value="<%= (generalUser==null)? "P130192176" : generalUser.getgIDNum()%>" size="45"/></td>
	</tr>
	<tr>
		<td>性別:<font color=red><b>*</b></font></td>
		<td><select name="gGender">
<!-- 			<option value="">選取性別</option> -->
			<option value="0">male</option>
			<option value="1">female</option>
		</select></td>
	</tr>
	<tr>
		<td>出生年月日:</td>
		<td><input name="gBirth" id="f_date1" type="text" ></td>
	</tr>
	<tr>
		<td>聯絡電話:</td>
		<td><input type="TEXT" name="gTelephone"   value="<%= (generalUser==null)? "0988059202" : generalUser.getgTelephone()%>" size="45"/></td>
	</tr>
	<tr>
		<td>聯絡地址:</td>
		<td><input type="TEXT" name="gAddress"  value="<%= (generalUser==null)? "臺北市中山區新生北路3段40號6樓" : generalUser.getgAddress()%>" size="45"/></td>
	</tr>
	<tr>
		<td>帳號狀態:<font color=red><b>*</b></font></td>
		<td><select name="status">
<!-- 			<option value="">選取狀態</option> -->
			<option value="0">normal</option>
			<option value="1">討論版停權</option>
		</select></td>
	</tr>

</table>
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" value="送出新增"></FORM>

</body>



<!-- =========================================以下為 datetimepicker 之相關設定========================================== -->

<% 
  java.sql.Date gBirth = null;
  try {
	  gBirth = generalUser.getgBirth();
   } catch (Exception e) {
	   gBirth = new java.sql.Date(System.currentTimeMillis());
   }
%>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.css" />
<script src="<%=request.getContextPath()%>/datetimepicker/jquery.js"></script>
<script src="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.full.js"></script>

<style>
  .xdsoft_datetimepicker .xdsoft_datepicker {
           width:  300px;   /* width:  300px; */
  }
  .xdsoft_datetimepicker .xdsoft_timepicker .xdsoft_time_box {
           height: 151px;   /* height:  151px; */
  }
</style>

<script>
$.datetimepicker.setLocale('zh');
$('#f_date1').datetimepicker({
   theme: '',              //theme: 'dark',
   timepicker:false,       //timepicker:true,
   step: 1,                //step: 60 (這是timepicker的預設間隔60分鐘)
   format:'Y-m-d',         //format:'Y-m-d H:i:s',
   value: '<%=gBirth%>', // value:   new Date(),
   //disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // 去除特定不含
   //startDate:	            '2017/07/10',  // 起始日
   //minDate:               '-1970-01-01', // 去除今日(不含)之前
   //maxDate:               '+1970-01-01'  // 去除今日(不含)之後
});  
</script>
</html>