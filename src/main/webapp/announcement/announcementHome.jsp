<%@page import="com.pichill.announcementgetone.service.AnnouncementGetOneService"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.pichill.announcementgetone.model.*"%>
<%@ page import="com.pichill.backstage.announcement.entity.Announcement"%>
<%@ page import="com.pichill.backstage.announcement.*"%>
<%@ page import="com.pichill.backstage.announcement.service.*"%>
<%--  <%@ page --%>
<%-- 	import="com.pichill.announcementgetone.service.AnnouncementGetOneService"%> --%>
<%-- <%@ page --%>
<%-- 	import="com.pichill.announcementgetone.entity.AnnouncementGetOne"%>  --%>

<%
AnnouncementServiceBack annoSvcB = new AnnouncementServiceBack();
List<Announcement> list = annoSvcB.getAll();
pageContext.setAttribute("list", list);
%>


<html>
<head>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/generaluser/CSS/bootstrap.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/generaluser/css2/css.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/generaluser/css2/main.css">
	<link rel="stylesheet" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<title>最新消息</title>
</head>
<body>
<body>
	<!----------------------------------------------- header 區 ------------------------------------------------------->
	<header class="header">
		<div class="container">
			<header class="d-flex flex-wrap justify-content-center py-1">
				<a href="/"
					class="d-flex align-items-center mb-1 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
					<img
					src="<%=request.getContextPath()%>/generaluser/pic/headerlogo.svg"
					alt="SVG" />
				</a>
				<jsp:useBean id="announcement" scope="page"
					class="com.pichill.announcementgetone.service.AnnouncementGetOneService" />



				<ul class="nav nav-pills">
					<li class="nav-item"><a
						href="<%=request.getContextPath()%>/homepage/main.jsp"
						class="nav-link">首頁</a></li>
					<li class="nav-item"><a href="#" class="nav-link">公告</a></li>
					<li class="nav-item"><a href="#" class="nav-link">場館資訊</a></li>
					<li class="nav-item"><a
						href="<%=request.getContextPath()%>/reserveorder/reserveOrder.jsp"
						class="nav-link">我要預約</a></li>
					<li class="nav-item"><a href="#" class="nav-link">論壇</a></li>
					<li class="nav-item"><a
						href="<%=request.getContextPath()%>/generaluser/guserListOne.jsp"
						class="nav-link"><img
							src="<%=request.getContextPath()%>/generaluser/DBGifReader?gUserID=${generalUser.gUserID}"
							alt="SVG" class="rounded-circle" /> 會員中心</a></li>
				</ul>

			</header>
		</div>
	</header>

	<!----------------------------------------------- aside 區 ------------------------------------------------------->
	<div class="main_content">
		<aside class="aside">
			<div class="row row-cols-1 row-cols-md-1 g-1" id="card">
				<div class="col">
					<div class="card h-100">
						 <img src="<%=request.getContextPath()%>/generaluser/pic/31000009.jpg" class="card-img-top" alt="jpg">
                    <div class="card-body">
                      <h6 class="card-title"><font style="vertical-align: inherit; font-weight: bold;"><font style="vertical-align: inherit;">揪團文章</font></font></h6>
                      <p class="card-text"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"></font><font style="vertical-align: inherit;"></font></font></p>
                      <a href="http://localhost:8081/PiChill/post/forum.html?postID=31000009" class="btn1 btn-primary"><font style="vertical-align: inherit;"><font style="vertical-align: inherit; font-weight: bold; font-size: 14px;">揪Me!</font></font></a>
                    </div>
                  </div>
				</div>
				<div></div>
				<div></div>
				<div></div>
				<div class="col">
					<div class="card h-100">
						<img src="<%=request.getContextPath()%>/generaluser/pic/31000006.jpg" class="card-img-top" alt="jpg">
                    <div class="card-body">
                        <h6 class="card-title"><font style="vertical-align: inherit; font-weight: bold;"><font style="vertical-align: inherit;">揪團文章</font></font></h6>
                      <p class="card-text"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"></font></font></p>
                      <a href="http://localhost:8081/PiChill/post/forum.html?postID=31000006" class="btn1 btn-primary"><font style="vertical-align: inherit;"><font style="vertical-align: inherit; font-weight: bold; font-size: 14px;">揪Me!</font></font></a>
                    </div>
                  </div>
				</div>
			</div>
		</aside>

		<!----------------------------------------------- main 區 ------------------------------------------------------->
		<main class="main">
			<table id="table-1">
				<tr>
					<td>
						<h3>最新消息與公告</h3>
						 <h4>
							<a
								href="<%=request.getContextPath()%>/announcement/announcement_search.jsp">查詢其他公告</a>
						</h4> 
					</td>
				</tr>
			</table>
			<div class="news">
				<div class="newbor">
					<p class="fresh">公告</p>
					<div class="texts">
						<br>
						<table>
							<tr>
								<th>公告編號</th>
								<th>管理員姓名</th>
								<th>表單編號</th>
								<th>標題</th>
								<th>內文</th>
								<th>內文圖片</th>
								<th>發文時間</th>
							</tr>
							<c:forEach var="announcement" items="${list}">
								<!-- 暫稱list之後再改 -->
								<tr>
									<td>${announcement.announceID}</td>
									<td>${announcement.manage.mName}</td>
									<td>${announcement.formID}</td>
									<td>${announcement.annoTitle}</td>
									<td>${announcement.annoContent}</td>
<%-- 									<td>${announcement.annoPic}</td> --%>
<td><img
								src="<%=request.getContextPath()%>/announcement/DBJPGReader?announceID=${announcement.announceID}"
								width="400px"></td>
									<td>${announcement.annoTime}</td>
									<td>
										<FORM METHOD="post"
											ACTION="<%=request.getContextPath()%>/announcement/announcement_single.jsp"
											style="margin-bottom: 0px;">
											<input type="submit" value="查看詳情"> <input
												type="hidden" name="formID" value="${announceGetOne.formID}">
											<input type="hidden" name="action" value="getOneForDisplay">
										</FORM>
									</td>
								</tr>
							</c:forEach>
						</table>
						<br>
						<br> <input type="submit" id="more" value="查看更多"
							style="width: 150px; height: 44px;">
					</div>
				</div>
				<br>
				<br>
			</div>



		</main>
	</div>

	<!----------------------------------------------- footer 區 ------------------------------------------------------->
	<footer class="footer">

		<div class="container">
			<header class="d-flex flex-wrap justify-content-center py-3">
				<a href="/"
					class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
					<img
					src="<%=request.getContextPath()%>/generaluser/pic/footerlogo.svg"
					alt="SVG" />
				</a>

				<ul class="nav nav-pillss">
					<li class="nav-item"><a href="#" class="nav-link">使用者條款</a></li>
					<li class="nav-item"><a href="#" class="nav-link"></a></li>
					<li class="nav-item"><a href="#" class="nav-link">隱私權政策</a></li>
					<li class="nav-item"><a href="#" class="nav-link"></a></li>
					<li class="nav-item"><a href="#" class="nav-link">免責條款</a></li>
					<li class="nav-item"><a href="#" class="nav-link"></a></li>
					<li class="nav-item"><a href="#" class="nav-link"></a></li>

				</ul>
			</header>
		</div>
	</footer>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>