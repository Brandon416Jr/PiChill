<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.pichill.generaluser.entity.GeneralUser"%>

<% //��com.emp.controller.EmpServlet.java��163��s�Jreq��empVO���� (�����q��Ʈw���X��empVO, �]�i�H�O��J�榡�����~�ɪ�empVO����)
	GeneralUser generalUser = (GeneralUser) request.getAttribute("generalUser");
%>
<%-- --<%= generalUser==null %>--${generalUser.gUserID}-- <!-- line 100 --> --%>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>�|����ƭק� - update_generalUser_input.jsp</title>

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
		 <h3>�|����ƭק� - update_generalUser_input.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">�^����</a></h4>
	</td></tr>
</table>

<h3>��ƭק�:</h3>

<%-- ���~���C --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">�Эץ��H�U���~:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<FORM METHOD="post" ACTION="generaluser.do" name="form1">
<table>
	<tr>
		<td>�|���s��:<font color=red><b>*</b></font></td>
		<td><%=generalUser.getgUserID()%></td>
	</tr>
<tr>
		<td>�|���m�W:</td>
		<td><input type="TEXT" name="gName" value="<%= (generalUser==null)? "�B����" : generalUser.getgName()%>" size="45"/></td>
	</tr>
	<tr>
		<td>�b��(�q�l�H�c):</td>
		<td><input type="TEXT" name="gEmail"   value="<%= (generalUser==null)? "carlisle1306@gmail.com" : generalUser.getgEmail()%>" size="45"/></td>
	</tr>
	<tr>
		<td>�K�X:</td>
		<td><input type="TEXT" name="gPassword"   value="<%= (generalUser==null)? "v3PBw9Rs" : generalUser.getgPassword()%>" size="45"/></td>
	</tr>
	<tr>
		<td>�����Ҧr��:</td>
		<td><input type="TEXT" name="gIDNum"   value="<%= (generalUser==null)? "P130192176" : generalUser.getgIDNum()%>" size="45"/></td>
	</tr>
	<tr>
		<td>�ʧO:<font color=red><b>*</b></font></td>
		<td><select name="gGender">
<!-- 			<option value="">����ʧO</option> -->
			<option value="0">male</option>
			<option value="1">female</option>
		</select></td>
	</tr>
	<tr>
		<td>�X�ͦ~���:</td>
		<td><input name="gBirth" id="f_date1" type="text" ></td>
	</tr>
	<tr>
		<td>�p���q��:</td>
		<td><input type="TEXT" name="gTelephone"   value="<%= (generalUser==null)? "0988059202" : generalUser.getgTelephone()%>" size="45"/></td>
	</tr>
	<tr>
		<td>�p���a�}:</td>
		<td><input type="TEXT" name="gAddress"  value="<%= (generalUser==null)? "�O�_�����s�Ϸs�ͥ_��3�q40��6��" : generalUser.getgAddress()%>" size="45"/></td>
	</tr>
	<tr>
		<td>�b�����A:<font color=red><b>*</b></font></td>
		<td><select name="status">
<!-- 			<option value="">������A</option> -->
			<option value="0">normal</option>
			<option value="1">�Q�ת����v</option>
		</select></td>
	</tr>

</table>
<br>
<input type="hidden" name="action" value="update">
<input type="hidden" name="gUserID" value="<%=generalUser.getgUserID()%>">
<input type="submit" value="�e�X�ק�"></FORM>
</body>



<!-- =========================================�H�U�� datetimepicker �������]�w========================================== -->

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
 	       step: 1,                //step: 60 (�o�Otimepicker���w�]���j60����)
 	       format:'Y-m-d',         //format:'Y-m-d H:i:s',
 		   value: '<%=generalUser.getgBirth()%>', // value:   new Date(),
           //disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // �h���S�w���t
           //startDate:	            '2017/07/10',  // �_�l��
           //minDate:               '-1970-01-01', // �h������(���t)���e
           //maxDate:               '+1970-01-01'  // �h������(���t)����
        });
        
        
   
        // ----------------------------------------------------------�H�U�ΨӱƩw�L�k��ܪ����-----------------------------------------------------------

        //      1.�H�U���Y�@�Ѥ��e������L�k���
        //      var somedate1 = new Date('2017-06-15');
        //      $('#f_date1').datetimepicker({
        //          beforeShowDay: function(date) {
        //        	  if (  date.getYear() <  somedate1.getYear() || 
        //		           (date.getYear() == somedate1.getYear() && date.getMonth() <  somedate1.getMonth()) || 
        //		           (date.getYear() == somedate1.getYear() && date.getMonth() == somedate1.getMonth() && date.getDate() < somedate1.getDate())
        //              ) {
        //                   return [false, ""]
        //              }
        //              return [true, ""];
        //      }});

        
        //      2.�H�U���Y�@�Ѥ��᪺����L�k���
        //      var somedate2 = new Date('2017-06-15');
        //      $('#f_date1').datetimepicker({
        //          beforeShowDay: function(date) {
        //        	  if (  date.getYear() >  somedate2.getYear() || 
        //		           (date.getYear() == somedate2.getYear() && date.getMonth() >  somedate2.getMonth()) || 
        //		           (date.getYear() == somedate2.getYear() && date.getMonth() == somedate2.getMonth() && date.getDate() > somedate2.getDate())
        //              ) {
        //                   return [false, ""]
        //              }
        //              return [true, ""];
        //      }});


        //      3.�H�U����Ӥ�����~������L�k��� (�]�i���ݭn������L���)
        //      var somedate1 = new Date('2017-06-15');
        //      var somedate2 = new Date('2017-06-25');
        //      $('#f_date1').datetimepicker({
        //          beforeShowDay: function(date) {
        //        	  if (  date.getYear() <  somedate1.getYear() || 
        //		           (date.getYear() == somedate1.getYear() && date.getMonth() <  somedate1.getMonth()) || 
        //		           (date.getYear() == somedate1.getYear() && date.getMonth() == somedate1.getMonth() && date.getDate() < somedate1.getDate())
        //		             ||
        //		            date.getYear() >  somedate2.getYear() || 
        //		           (date.getYear() == somedate2.getYear() && date.getMonth() >  somedate2.getMonth()) || 
        //		           (date.getYear() == somedate2.getYear() && date.getMonth() == somedate2.getMonth() && date.getDate() > somedate2.getDate())
        //              ) {
        //                   return [false, ""]
        //              }
        //              return [true, ""];
        //      }});
        
</script>
</html>