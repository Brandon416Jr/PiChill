<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="com.pichill.generaluser.entity.*"%>
<%-- �����Ƚm�߱ĥ� Script ���g�k���� --%>

<%
GeneralUser generalUser = (GeneralUser) request.getAttribute("generalUser"); //GeneralUserServlet.java(Concroller), �s�Jreq��generalUser����
%>

<html>
<head>
<title>�|����� - listOneGeneralUser.jsp</title>

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
	width: 600px;
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

<h4>�����Ƚm�߱ĥ� Script ���g�k����:</h4>
<table id="table-1">
	<tr><td>
		 <h3>�|����� - listOneGeneralUser.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">�^����</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>�|���s��</th>
		<th>�|���m�W</th>
		<th>�b��(�q�l�H�c)</th>
		<th>�K�X</th>
		<th>�����Ҧr��</th>
		<th>�ʧO</th>
		<th>�X�ͦ~���</th>
		<th>�p���q��</th>
		<th>�p���a�}</th>
		<th>�b�����A</th>
	</tr>
	<tr>
		<td><%=generalUser.getgUserID()%></td>
		<td><%=generalUser.getgName()%></td>
		<td><%=generalUser.getgEmail()%></td>
		<td><%=generalUser.getgPassword()%></td>
		<td><%=generalUser.getgIDNum()%></td>
		<td><%=generalUser.getgGender()%></td>
		<td><%=generalUser.getgBirth()%></td>
		<td><%=generalUser.getgTelephone()%></td>
		<td><%=generalUser.getgAddress()%></td>
		<td><%=generalUser.getStatus()%></td>
		
		
	</tr>
</table>

</body>
</html>