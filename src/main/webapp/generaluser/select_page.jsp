<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>PiChill GeneralUser: Home</title>

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
   <tr><td><h3>PiChill GeneralUser: Home</h3><h4>( 大吳老師是神~ )</h4></td></tr>
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
  <li><a href='listAllGeneralUser.jsp'>List</a> all GeneralUsers.  <br><br></li>
  
  
  <li>
    <FORM METHOD="post" ACTION="generaluser.do" >
        <b>輸入會員編號 (如11000001):</b>
        <input type="text" name="gUserID">
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="送出">
    </FORM>
  </li>

  <jsp:useBean id="generalUserSvc" scope="page" class="com.pichill.generaluser.service.GeneralUserService" />
   
  <li>
     <FORM METHOD="post" ACTION="generaluser.do" >
       <b>選擇會員編號:</b>
       <select size="1" name="gUserID">
         <c:forEach var="generalUser" items="${generalUserSvc.all}" > 
          <option value="${generalUser.gUserID}">${generalUser.gUserID}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
    </FORM>
  </li>
  
  <li>
     <FORM METHOD="post" ACTION="generaluser.do" >
       <b>選擇會員姓名:</b>
       <select size="1" name="gUserID">
         <c:forEach var="generalUser" items="${generalUserSvc.all}" > 
          <option value="${generalUser.gUserID}">${generalUser.gName}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
     </FORM>
  </li>
</ul>


<h3>會員管理</h3>

<ul>
  <li><a href='addGeneralUser.jsp'>Add</a> a new GeneralUser.</li>
</ul>

</body>
</html>