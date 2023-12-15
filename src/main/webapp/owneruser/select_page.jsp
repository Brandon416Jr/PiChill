<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>PiChill OwnerUser: Home</title>

<style>
  table#table-1 {
	width: 450px;
	background-color: #CCCCFF;
	margin-top: 5px;
	margin-bottom: 10px;
    border: 3px ridge Gray;
    height: 80px;
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

</head>
<body bgcolor='white'>

<table id="table-1">
   <tr><td><h3>PiChill OwnerUser: Home</h3><h4>( 測試版~ )</h4></td></tr>
</table>

<p>This is the Home page for PiChill GeneralUser: Home</p>

<h3>資料查詢:</h3>
	
<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
	    <c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<ul>
  <li><a href='all_owneruser.jsp'>List</a> all OwnerUsers.  <br><br></li>
  
  
  <li>
    <FORM METHOD="post" ACTION="owneruser.do" >
        <b>輸入會員編號 (如12000001):</b>
        <input type="text" name="oUserID">
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="送出">
    </FORM>
  </li>

  <jsp:useBean id="ownerUserSvc" scope="page" class="com.pichill.owneruser.service.OwnerUserService" />
   
  <li>
     <FORM METHOD="post" ACTION="ownerluser.do" >
       <b>選擇會員編號:</b>
       <select size="1" name="oUserID">
         <c:forEach var="ownerUser" items="${ownerUserSvc.all}" > 
          <option value="${ownerUser.oUserID}">${ownerUser.oUserID}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
    </FORM>
  </li>
  
  <li>
     <FORM METHOD="post" ACTION="owneruser.do" >
       <b>選擇會員姓名:</b>
       <select size="1" name="oUserID">
         <c:forEach var="ownerUser" items="${ownerUserSvc.all}" > 
          <option value="${ownerUser.oUserID}">${ownerUser.oName}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
     </FORM>
  </li>
</ul>


<h3>會員管理</h3>

<ul>
  <li><a href='all_OwnerUser.jsp'>Add</a> a new OwnerUser.</li>
</ul>

</body>
</html>