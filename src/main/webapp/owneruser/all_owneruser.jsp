<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<%@ page import="com.pichill.owneruser.entity.OwnerUser"%>
<%@ page import="com.pichill.owneruser.model.*"%>
<%@ page import="com.pichill.owneruser.service.OwnerUserService"%>
    
 <%
 OwnerUserService ownerUserSvc = new OwnerUserService();
    List<OwnerUser> list = ownerUserSvc.getAll();
    pageContext.setAttribute("list",list);
%>   
   <!DOCTYPE html>
    <html>
   
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>所有企業會員資料 - listAllGeneralUser.jsp</title>
    
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
	   table {
		width: 1450px;
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
    
    <body bgcolor='white'>
<!--     <h4>此頁練習採用 EL 的寫法取值:</h4> -->
   <table id="table-1">
	<tr><td>
		 <h3>所有一般會員資料 - listAllOwnerUser.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="<%=request.getContextPath()%>/image/logo.png" width="200" height="80" border="0">  回首頁</a></h4>
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
		<th>電子信箱</th>
		<th>大頭貼</th>
		<th>修改</th>
<!-- 		<th>刪除</th> -->
	</tr>
	
	<c:forEach var="ownerUser" items="${list}" >
		
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
			<td>${ownerUser.oEmail}</td>
			<td>${ownerUser.oProfilePic}</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/owneruser/owneruser.do" style="margin-bottom: 0px;">
			     <input type="submit" value="修改">
			     <input type="hidden" name="oUserID"  value="${ownerUser.oUserID}">
			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
			</td>
		</tr>
	</c:forEach>
</table>
<%-- <%@ include file="page2.file" %> --%>
	<script>
		var script = document.createElement("script");

		script.src = "https://code.jquery.com/jquery-3.4.1.min.js";

		script.type = "text/javascript";

// 		document.getElementsByTagName("head")[0].appendChild(script);
	</script>
</body>
</html>