<%-- <%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%> --%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<%-- <%@ page import="com.pichill.managejdbc.entity.Manage"%> --%>

<%-- <% //見com.emp.controller.EmpServlet.java第163行存入req的empVO物件 (此為從資料庫取出的empVO, 也可以是輸入格式有錯誤時的empVO物件) --%>
//    Manage manage = (Manage) request.getAttribute("manage");
<%-- %> --%>
<%-- <%-- --<%= manage==null %>--${empVO.deptno}-- <!-- line 100 --> --%> --%>
<!-- <html> -->
<!-- <head> -->
<!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/> -->
<!-- <title>員工資料修改 - update_manage_input.jsp</title> -->

<!-- <style> -->
/*   table#table-1 { */
/* 	background-color: #CCCCFF; */
/*     border: 2px solid black; */
/*     text-align: center; */
/*   } */
/*   table#table-1 h4 { */
/*     color: red; */
/*     display: block; */
/*     margin-bottom: 1px; */
/*   } */
/*   h4 { */
/*     color: blue; */
/*     display: inline; */
/*   } */
<!-- </style> -->

<!-- <style> -->
/*   table { */
/* 	width: 450px; */
/* 	background-color: white; */
/* 	margin-top: 1px; */
/* 	margin-bottom: 1px; */
/*   } */
/*   table, th, td { */
/*     border: 0px solid #CCCCFF; */
/*   } */
/*   th, td { */
/*     padding: 1px; */
/*   } */
<!-- </style> -->

<!-- </head> -->
<!-- <body bgcolor='white'> -->

<!-- <table id="table-1"> -->
<!-- 	<tr><td> -->
<!-- 		 <h3>員工資料修改 - update_manage_input.jsp</h3> -->
<!-- 		 <h4><a href="select_page.jsp"><img src="../image/smallLogo.png" width="100" height="32" border="0">回首頁</a></h4> -->
<!-- 	</td></tr> -->
<!-- </table> -->

<!-- <h3>資料修改:</h3> -->

<%-- <%-- 錯誤表列 --%> --%>
<%-- <c:if test="${not empty errorMsgs}"> --%>
<!-- 	<font style="color:red">請修正以下錯誤:</font> -->
<!-- 	<ul> -->
<%-- 		<c:forEach var="message" items="${errorMsgs}"> --%>
<%-- 			<li style="color:red">${message}</li> --%>
<%-- 		</c:forEach> --%>
<!-- 	</ul> -->
<%-- </c:if> --%>

<!-- <FORM METHOD="post" ACTION="manage.do" name="form1"> -->
<!-- <table> -->
<!-- 	<tr> -->
<!-- 		<td>管理員編號:<font color=red><b>*</b></font></td> -->
<%-- 		<td><%=manage.getManageID()%></td> --%>
<!-- 	</tr> -->
<!-- 	<tr> -->
<!-- 		<td>員工姓名:</td> -->
<%-- 		<td><input type="TEXT" name="mName" value="<%= (manage==null)? "陳金鋒" : manage.getmName()%>" size="45"/></td> --%>
<!-- 	</tr> -->
<!-- 	<tr> -->
<!-- 		<td>帳號:</td> -->
<%-- 		<td><input type="TEXT" name="mUserName"   value="<%= (manage==null)? "Chen52" : manage.getmUserName()%>" size="45"/></td> --%>
<!-- 	</tr> -->
<!-- 	<tr> -->
<!-- 		<td>密碼:</td> -->
<%-- 		<td><input type="password" name="mPassword" value="<%= (manage==null)? "525252" : manage.getmPassword()%>" size="45"/></td> --%>
<!-- 	</tr> -->
<!-- 	<tr> -->
<!-- 		<td>生日:</td> -->
<%-- 		<td><input name="mBirth" type="date" value="<%= (manage==null)? "1982-06-01" : manage.getmBirth()%>" size="45"></td> --%>
<!-- 	</tr> -->
<!-- 	<tr> -->
<!-- 		<td>性別:</td> -->
<!-- 		<td><select name="mGender"> -->
<!-- 			<option value="0" selected>男</option> -->
<!-- 			<option value="1">女</option> -->
<!-- 			</select> -->
<!-- 		</td> -->
<!-- 	</tr> -->
<!-- 	<tr> -->
<!-- 		<td>手機:</td> -->
<%-- 		<td><input type="TEXT" name="mTelephone" value="<%= (manage==null)? "0918324387" : manage.getmTelephone()%>" size="45"/></td> --%>
<!-- 	</tr> -->
<!-- 	<tr> -->
<!-- 		<td>緊急聯絡人:</td> -->
<%-- 		<td><input type="TEXT" name="mEmgContact" value="<%= (manage==null)? "陳連宏" : manage.getmEmgContact()%>" size="45"/></td> --%>
<!-- 	</tr> -->
<!-- 	<tr> -->
<!-- 		<td>緊急聯絡人手機:</td> -->
<%-- 		<td><input type="TEXT" name="mEmgPhone" value="<%= (manage==null)? "0914562187" : manage.getmEmgPhone()%>" size="45"/></td> --%>
<!-- 	</tr> -->
<!-- 	<tr> -->
<!-- 		<td>聯絡地址:</td> -->
<%-- 		<td><input type="TEXT" name="mAddress" value="<%= (manage==null)? "新北市永和區環河西路587號22樓" : manage.getmAddress()%>" size="45"/></td> --%>
<!-- 	</tr> -->
<!-- 	<tr> -->
<!-- 		<td>入職日期:</td> -->
<!-- 		<td><input name="mHiredate" type="date" ></td> -->
<!-- 	</tr> -->
<!-- 	<tr> -->
<!-- 		<td>最後上線時間:</td> -->
<!-- 		<td><input name="mLastLogTime" type="text" ></td> -->
<!-- 	</tr> -->
<!-- 	<tr> -->
<!-- 		<td>身份證:</td> -->
<%-- 		<td><input type="TEXT" name="mID" value="<%= (manage==null)? "Z984029391" : manage.getmID()%>" size="45"/></td> --%>
<!-- 	</tr> -->
<!-- 	<tr> -->
<!-- 		<td>電子信箱:</td> -->
<%-- 		<td><input type="TEXT" name="mEmail" value="<%= (manage==null)? "brandon416jr@gmail.com" : manage.getmEmail()%>" size="45"/></td> --%>
<!-- 	</tr> -->
<!-- <!-- 	<tr> --> -->
<!-- <!-- 		<FORM action="uploadServlet3_simple.do" method=post enctype="multipart/form-data"> --> -->
<!-- <!--         	<input type="file" name="upfile1"> --> -->
<!-- <!--         	<input type="submit" value="上傳"> --> -->
<!-- <!--   		</FORM> --> -->
<!-- <!-- 	</tr> --> -->
<!-- 	<tr> -->
<!-- 		<td>狀態:</td> -->
<!-- 		<td> -->
<!-- 			<select name="mStatus"> -->
<!-- 				<option value="0">已離職</option> -->
<!-- 				<option value="1" selected>在職中</option> -->
<!-- 			</select> -->
<!-- 		</td> -->
<!-- 	</tr> -->

<%-- <%-- 	<jsp:useBean id="deptSvc" scope="page" class="com.dept.model.DeptService" /> --%> --%>
<!-- <!-- 	<tr> --> -->
<!-- <!-- 		<td>部門:<font color=red><b>*</b></font></td> --> -->
<!-- <!-- 		<td><select size="1" name="deptno"> --> -->
<%-- <%-- 			<c:forEach var="deptVO" items="${deptSvc.all}"> --%> --%>
<%-- <%-- 				<option value="${deptVO.deptno}" ${(empVO.deptno==deptVO.deptno)?'selected':'' } >${deptVO.dname} --%> --%>
<%-- <%-- 			</c:forEach> --%> --%>
<!-- <!-- 		</select></td> --> -->
<!-- <!-- 	</tr> --> -->

<!-- </table> -->
<!-- <br> -->
<!-- <input type="hidden" name="action" value="update"> -->
<%-- <input type="hidden" name="manageID" value="<%=manage.getManageID()%>"> --%>
<!-- <input type="submit" value="送出修改"></FORM> -->
<!-- </body> -->

<!-- </html> -->