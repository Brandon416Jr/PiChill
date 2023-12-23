<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.pichill.announcementgetone.model.*"%>
<%@ page
	import="com.pichill.announcementgetone.service.AnnouncementGetOneService"%>
<%@ page
	import="com.pichill.announcementgetone.entity.AnnouncementGetOne"%>
<!-- 用來搜公告的頁面 -->
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Pichill公告查詢</title>
<link rel="stylesheet" href="./CSS1/bootstrap.min.css">
<link rel="stylesheet" href="./CSS/index3.css">
<link rel="stylesheet" href="./CSS/table.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/generaluser/CSS/bootstrap.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/generaluser/css2/css.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/generaluser/css2/main.css">

<!----------------匯入jquery ------------------------>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
</head>
<header class="header">
	<div class="container">
		<header class="d-flex flex-wrap justify-content-center py-1">
			<a href="/"
				class="d-flex align-items-center mb-1 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
				<img
				src="<%=request.getContextPath()%>/generaluser/pic/headerlogo.svg"
				alt="SVG" />
			</a>


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
		<h3>公告查詢:</h3>

		<%-- 錯誤表列 --%>
		<c:if test="${not empty errorMsgs}">
			<font style="color: red">請修正以下錯誤:</font>
			<ul>
				<c:forEach var="message" items="${errorMsgs}">
					<li style="color: red">${message}</li>
				</c:forEach>
			</ul>
		</c:if>

		<ul>
			<li><a href='<%=request.getContextPath()%>/announcement/listAnnouncement.jsp'>查全部公告</a><br>
				<br></li>


			<li>
				<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/announcement/announcement.do">
					<!-- 送出成功後回到列表 -->
					<b>輸入欲查詢的關鍵字:</b> <input type="text" name="annoTitle"> <input
						type="hidden" name="action" value="getOneForDisplay"> <input
						type="submit" value="送出">
				</FORM>
			</li>

			<jsp:useBean id="announcement" scope="page"
				class="com.pichill.announcementgetone.service.AnnouncementGetOneService" />

			<li>
				<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/announcement/announcement_single.jsp">
					<b>請輸入要查詢之公告:</b> <input type="text" name="announceID">
					<!-- <select size="1" name="announceID"> -->
						<c:forEach var="announcement" items="${announcementGetOneService.getAll}">
							<option value="${announcementGetOne.annoTitle}">${announcementGetOne.annoTitle}
						</c:forEach>
					</select> <input type="hidden" name="action" value="getOneForDisplay">
					<input type="submit" value="送出">
				</FORM>
			</li>

		</ul>
	</main>
</div>
<!----------------------------------------------- footer 區 ------------------------------------------------------->
<footer class="footer">

	<div class="container">
		<header class="d-flex flex-wrap justify-content-center py-3">
			<%-- <a href="/"
				class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
				<img
				src="<%=request.getContextPath()%>/generaluser/
			go.svg"
				alt="SVG" />
			</a>
 --%>
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