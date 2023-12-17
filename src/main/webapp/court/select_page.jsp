<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>PiChill Court: Home</title>
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
   <tr><td><h3>PiChill Court: Home</h3><h4>( 測試版~ )</h4></td></tr>
</table>

<p>This is the Home page for PiChill Court: Home</p>

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
  <li><a href='all_court.jsp'>List</a> all Court.  <br><br></li>
  
  
  <li>
    <FORM METHOD="post" ACTION="court.do" >
        <b>輸入球館編號 (如61000001):</b>
        <input type="text" name="courtID">
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="送出">
    </FORM>
  </li>

  <jsp:useBean id="courtSvc" scope="page" class="com.pichill.court.CourtService" />
   
  <li>
     <FORM METHOD="post" ACTION="court.do" >
       <b>選擇會員編號:</b>
       <select size="1" name="courtID">
         <c:forEach var="court" items="${courtSvc.all}" > 
          <option value="${court.courtID}">${court.courtID}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
    </FORM>
  </li>
  
  <li>
     <FORM METHOD="post" ACTION="court.do" >
       <b>選擇球館名稱:</b>
       <select size="1" name="courtID">
         <c:forEach var="court" items="${courtSvc.all}" > 
          <option value="${court.courtID}">${court.courtName}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
     </FORM>
  </li>
</ul>


<h3>球館管理</h3>

<ul>
  <li><a href='new_court.jsp'>Add</a> a new Court.</li>
</ul>

</body>
</html>
















</body>
</html>