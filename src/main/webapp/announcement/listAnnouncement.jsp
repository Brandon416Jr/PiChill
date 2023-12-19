<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.pichill.announcementgetone.model.*"%>
<%@ page
	import="com.pichill.announcementgetone.service.AnnouncementGetOneService"%>
<%@ page
	import="com.pichill.announcementgetone.entity.AnnouncementGetOne"%>
<%
AnnouncementGetOneService annoGetOneSvc = new AnnouncementGetOneService();
List<AnnouncementGetOne> list = annoGetOneSvc.getAll();
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
<title>搜尋公告結果</title>
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
						href="<%=request.getContextPath()%>/generaluser/main.jsp"
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
						<svg class="bd-placeholder-img card-img-top" width="100%"
							height="140" xmlns="http://www.w3.org/2000/svg" role="img"
							aria-label="佔位符：影像上限" preserveAspectRatio="xMidYMid slice"
							focusable="false">
							<title>Placeholder</title><rect width="100%" height="100%"
								fill="#868e96"></rect>
							<text x="50%" y="50%" fill="#dee2e6" dy=".3em">Image cap</text></svg>
						<div class="card-body">
							<h6 class="card-title">
								<font style="vertical-align: inherit; font-weight: bold;"><font
									style="vertical-align: inherit;">揪團文章</font></font>
							</h6>
							<p class="card-text">
								<font style="vertical-align: inherit;"><font
									style="vertical-align: inherit;"></font><font
									style="vertical-align: inherit;"></font></font>
							</p>
							<a href="#" class="btn1 btn-primary"><font
								style="vertical-align: inherit;"><font
									style="vertical-align: inherit; font-weight: bold; font-size: 14px;">揪Me!</font></font></a>
						</div>
					</div>
				</div>
				<div></div>
				<div></div>
				<div></div>
				<div class="col">
					<div class="card h-100">
						<svg class="bd-placeholder-img card-img-top" width="100%"
							height="140" xmlns="http://www.w3.org/2000/svg" role="img"
							aria-label="佔位符：影像上限" preserveAspectRatio="xMidYMid slice"
							focusable="false">
							<title>Placeholder</title><rect width="100%" height="100%"
								fill="#868e96"></rect>
							<text x="50%" y="50%" fill="#dee2e6" dy=".3em">Image cap</text></svg>
						<div class="card-body">
							<h6 class="card-title">
								<font style="vertical-align: inherit; font-weight: bold;"><font
									style="vertical-align: inherit;">揪團文章</font></font>
							</h6>
							<p class="card-text">
								<font style="vertical-align: inherit;"><font
									style="vertical-align: inherit;"></font></font>
							</p>
							<a href="#" class="btn1 btn-primary"><font
								style="vertical-align: inherit;"><font
									style="vertical-align: inherit; font-weight: bold; font-size: 14px;">揪Me!</font></font></a>
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
						<h3>公告搜尋結果</h3>
						<h4>
							<a
								href="<%=request.getContextPath()%>/announcement/announcement_select.jsp">回首頁</a>
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
								<th>管理員編號</th>
								<th>表單編號</th>
								<th>標題</th>
								<th>內文</th>
								<th>內文圖片</th>
								<th>發文時間</th>
							</tr>
							<c:forEach var="announcementGetOne" items="${list}">
								<!-- 暫稱list之後再改 -->
								<tr>
									<td>${announcementGetOne.announceID}</td>
									<td>${announcementGetOne.manageID}</td>
									<td>${announcementGetOne.formID}</td>
									<td>${announcementGetOne.annoTitle}</td>
									<td>${announcementGetOne.annoContent}</td>
									<td>${announcementGetOne.annoPic}</td>
									<td>${announcementGetOne.annoTime}</td>
									<td>
										<FORM METHOD="post"
											ACTION="<%=request.getContextPath()%>/announcementGetOne/announcementGetOne.do"
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