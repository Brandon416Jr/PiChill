<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.pichill.announcement.*"%>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>



<html>
<head>
<title>搜尋公告結果 - listAnnouncement.jsp</title>

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

	<h4>此頁暫練習採用 Script 的寫法取值:</h4>
	<table id="table-1">
		<tr>
			<td>
				<h3>公告搜尋結果 - listAnnouncement.jsp</h3>
				<h4>
					<a href="announcement.jsp"><img src="images/back1.gif" width="100"
						height="32" border="0">回首頁</a>
				</h4>
			</td>
		</tr>
	</table>

	<table>
		<tr>
		<tr>
			<th>公告編號</th>
			<th>管理員編號</th>
			<th>表單編號</th>
			<th>標題</th>
			<th>內文</th>
			<th>內文圖片</th>
			<th>發文時間</th>
			<th>公告狀態</th>
			<th>修改</th>
			<th>刪除</th>
		</tr>
		<c:forEach var="announcement" items="${list}">
			<!-- 暫稱list之後再改 -->
			<tr>
				<td>${announcement.announceID}</td>
				<td>${contactUs.manageID}</td>
				<td>${contactUs.formID}</td>
				<td>${contactUs.annoTitle}</td>
				<td>${contactUs.annoContent}</td>
				<td>${contactUs.annoPic}</td>
				<td>${contactUs.annoTime}</td>
				<td>${contactUs.annoStatus}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>