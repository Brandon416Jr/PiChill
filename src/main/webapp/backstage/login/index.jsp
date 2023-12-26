<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<%@ page import="com.pichill.manage.entity.Manage"%>
<%@ page import="com.pichill.manage.model.*"%>
<%@ page import="com.pichill.manage.service.ManageService"%>

<%-- 此頁練習採用 EL 的寫法取值 --%>


<%
response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate, max-age=0");
response.setHeader("Cache-Control", "post-check=0, pre-check=0");
response.setHeader("Pragma", "no-cache");
%>

<%
Manage manage = (Manage) session.getAttribute("manage");
// 寫死
// Integer manageID = 13000003;
// ManageService manageSvc = new ManageService();
// Manage manage = manageSvc.getOneManage(manageID);
// pageContext.setAttribute("manage",manage);
%>



<!DOCTYPE html>
<html lang="zh-Hant">

<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>後臺管理員首頁</title>

<!-- jquery連結 (一定要在datatable前面!) -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<!-- datatable連結 -->
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.13.7/css/jquery.dataTables.css" />

<script src="https://cdn.datatables.net/1.13.7/js/jquery.dataTables.js"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/backEnd-Website/vendor/bootstrap-4.1/bootstrap.min.css" />
<style type="text/css"></style>
<!-- Vendor CSS-->
<link
	href="<%=request.getContextPath()%>/backEnd-Website/vendor/animsition/animsition.min.css"
	rel="stylesheet" media="all" />
<link
	href="<%=request.getContextPath()%>/backEnd-Website/vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css"
	rel="stylesheet" media="all" />
<link
	href="<%=request.getContextPath()%>/backEnd-Website/vendor/wow/animate.css"
	rel="stylesheet" media="all" />
<link
	href="<%=request.getContextPath()%>/backEnd-Website/vendor/css-hamburgers/hamburgers.min.css"
	rel="stylesheet" media="all" />
<link
	href="<%=request.getContextPath()%>/backEnd-Website/vendor/slick/slick.css"
	rel="stylesheet" media="all" />
<link
	href="<%=request.getContextPath()%>/backEnd-Website/vendor/select2/select2.min.css"
	rel="stylesheet" media="all" />
<link
	href="<%=request.getContextPath()%>/backEnd-Website/vendor/perfect-scrollbar/perfect-scrollbar.css"
	rel="stylesheet" media="all" />
<link
	href="<%=request.getContextPath()%>/backEnd-Website/vendor/font-awesome-4.7/css/font-awesome.css"
	rel="stylesheet" media="all" />
<link
	href="<%=request.getContextPath()%>/backEnd-Website/vendor/font-awesome-4.7/css/font-awesome.min.css"
	rel="stylesheet" media="all" />
<!-- <link href="./vendor/font-awesome-5/css/fontawesome-all.min.css" rel="stylesheet" media="all"> -->
<!-- Main CSS-->
<link href="<%=request.getContextPath()%>/backEnd-Website/css/main.css"
	rel="stylesheet" media="all" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/backEnd-Website/css/all.css"
	media="all" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/backEnd-Website/css/header.css"
	media="all" />

<style>
div.dataTables_scrollHeadInner {
	width: 100% !important;
}

div.dataTables_scrollHeadInner>table.table-data3 {
	margin: 0 auto !important;
}

.account-dropdown__footer {
	display: flex;
	justify-content: flex-end;
}

.btn {
	margin-left: auto;
	width: 100%;
	box-sizing: border-box;
}

div.index {
/* border: 1px solid red; */
    width: 68vw;
    height: 97vh;
    z-index: 100;
    position: absolute;
    right: 4%;
    /* bottom: 0; */
    top: 0;
}

div.index2 {
border: 1px solid blue;
width: 68vw;
    height: 80vh;
      z-index: 100;
      margin-top: 100px;
}
</style>
</head>

<body class="animsition all-employees-page">
	<div class="page-wrapper">
		<!-- MENU SIDEBAR-->
		<div class="sidebar">
			<aside class="menu-sidebar d-none d-lg-block">
				<div class="menu-sidebar__content js-scrollbar1">
					<nav class="navbar-sidebar">
						<ul class="list-unstyled navbar__list expanded">
							<li class="has-sub"><a class="js-arrow" href="#"> <i
									class="fas fa-tachometer-alt"></i>員工管理
							</a>
								<ul class="list-unstyled navbar__sub-list js-sub-list">
									<li><a class="active"
										href="<%=request.getContextPath()%>/backstage/manage/all_manage.jsp"
										>所有員工資料</a></li>
									<li><a
										href="<%=request.getContextPath()%>/manage/manage.do?action=getOne_For_insert"
										onclick="return checkmStatus();">新增員工資料</a></li>

									<li><a
										href="<%=request.getContextPath()%>/manage/manage.do?action=getMyData_Update&manageID=${manage.manageID}">我的資料</a></li>

								</ul></li>
							<li class="has-sub"><a class="js-arrow" href="#"> <i
									class="fas fa-tachometer-alt"></i>一般會員管理
							</a>
								<ul class="list-unstyled navbar__sub-list js-sub-list">
									<li><a
										href="<%=request.getContextPath()%>/backstage/generalUserBack/all_gUser.jsp">所有會員資料</a></li>
								</ul></li>
							<li class="has-sub"><a class="js-arrow" href="#"> <i
									class="fas fa-tachometer-alt"></i>企業會員管理
							</a>
								<ul class="list-unstyled navbar__sub-list js-sub-list">
									<li><a
										href="<%=request.getContextPath()%>/backstage/ownerUserBack/all_oUser.jsp">所有會員資料</a></li>
								</ul></li>
							<li class="has-sub"><a class="js-arrow" href="#"> <i
									class="fas fa-tachometer-alt"></i>最新消息管理
							</a>
								<ul class="list-unstyled navbar__sub-list js-sub-list">
									<li><a
										href="<%=request.getContextPath()%>/backstage/contactUsBack/all_form.jsp">表單管理</a></li>
									<li><a
										href="<%=request.getContextPath()%>/backstage/announcementBack/all_announcement.jsp">公告管理</a></li>
									<li><a
										href="<%=request.getContextPath()%>/backstage/announcementBack/new_announcement.jsp">新增公告</a></li>
								</ul></li>
							<li class="has-sub"><a class="js-arrow" href="#"> <i
									class="fas fa-tachometer-alt"></i>論壇管理
							</a>
								<ul class="list-unstyled navbar__sub-list js-sub-list">
									<li><a
										href="<%=request.getContextPath()%>/backstage/postBack/all_post.jsp">所有文章</a></li>
									<li><a
										href="<%=request.getContextPath()%>/backstage/commentBack/all_comment.jsp">所有留言</a></li>
									<li><a
										href="<%=request.getContextPath()%>/backstage/reportBack/all_report.jsp">檢舉管理</a></li>
								</ul></li>
							<li class="has-sub"><a class="js-arrow" href="#"> <i
									class="fas fa-tachometer-alt"></i>球館管理
							</a>
								<ul class="list-unstyled navbar__sub-list js-sub-list">
									<li><a
										href="<%=request.getContextPath()%>/backstage/courtBack/all_court.jsp">所有球館</a></li>
									<li><a
										href="<%=request.getContextPath()%>/backstage/placeBack/all_place.jsp">所有場地</a></li>
								</ul></li>
							<li class="has-sub"><a class="js-arrow" href="#"> <i
									class="fas fa-tachometer-alt"></i>預約管理
							</a>
								<ul class="list-unstyled navbar__sub-list js-sub-list">
									<li><a
										href="<%=request.getContextPath()%>/backstage/reserveOrderBack/all_reserveOrder.jsp">所有預約訂單</a></li>
								</ul></li>
						</ul>
					</nav>
				</div>
			</aside>
			<!-- END MENU SIDEBAR-->
		</div>

		<!-- PAGE CONTAINER-->
		<div class="page-container">
			<!-- HEADER DESKTOP-->
			<header class="header-desktop">
				<div class="section__content section__content--p30">
					<div class="container-fluid">
						<div class="header-wrap">
							<div class="header-logo">
								<a
									href="${pageContext.request.contextPath }/backstage/login/index.jsp"><img
									class="img-logo"
									src="${pageContext.request.contextPath }/image/bigLogo.png"
									alt="" /></a>
								<!-- 							<a href="index.html"><img class="img-logo"  -->
								<%-- 								src="<%=request.getContextPath()%>/image/bigLogo.png" alt="" /></a> --%>
							</div>
							<div class="welcome">
								<div class="flex">
									<div class="s-logo">
										<img
											src="${pageContext.request.contextPath }/backEnd-Website/pic/smallLogo.png"
											alt="">
									</div>
									<p class="welcome">π Chill後臺管理系統</p>
									<div class="s-logo">
										<img
											src="${pageContext.request.contextPath }/backEnd-Website/pic/smallLogo.png"
											alt="">
									</div>
								</div>
							</div>
							<div class="header-button">
								<div class="account-wrap">
									<div class="account-item clearfix js-item-menu">
										<div class="image">
											<a href="#"> <img
												src="${pageContext.request.contextPath }/manage/DBJPGReader?manageID=${manage.manageID}"
												alt="使用者頭像" /></a>
											<!-- 											<img -->
											<%-- 												src="${pageContext.request.contextPath }/image/Group 115.png" --%>
											<!-- 												alt="John Doe" /> -->
										</div>
										<div class="content">
											<a class="js-acc-btn" href="#">管理員${manage.mName}，您好</a>
											<!-- 																					<a class="js-acc-btn" href="#">管理員，您好</a> -->
										</div>
										<div class="account-dropdown js-dropdown">
											<div class="info clearfix">
												<div class="image">
													<a href="#"> <img
														src="${pageContext.request.contextPath }/manage/DBJPGReader?manageID=${manage.manageID}"
														alt="使用者頭像" /> <%-- 														<img src="${pageContext.request.contextPath }/image/Group 115.png" alt="John Doe" /> --%>
													</a>
												</div>
												<div class="content">
													<h5 class="name">
														<a href="#">${manage.mName}</a>
														<!-- 														<a href="#">管理員</a> -->
														<!-- 														<a -->
														<%-- 															href="<%=request.getContextPath()%>/manage/manage.do?action=getOne_For_Update&manageID=<%=manage.getManageID()%>"><%=manage.getmName()%></a> --%>
													</h5>
													<!-- 																																							<span class="email">brandon416jr@gmail.com</span> -->
													<span class="email">${manage.mEmail}</span>
												</div>
											</div>
											<div class="account-dropdown__footer">
												<form method="POST"
													action="<%=request.getContextPath()%>/manage/manage.do">
													<button class="btn btn-danger">登出</button>
													<input type="hidden" name="action" value="logout">
												</form>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</header>
			<!-- END HEADER DESKTOP-->
			
		</div>
	</div>
	<div class="index">
			<div class="index2">
			</div>
			</div>
<c:if test="${not empty requestScope.noAuth}">
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
  <script>
    Swal.fire({
      icon: 'error',
      title: '權限不足',
      text: '請聯繫系統管理員',
      timer: 5000,
     
      
    });
    alert('權限不足,請聯系系統管理員!');
  </script>
</c:if>
	<script>
		// 		history.pushState(null, null, document.URL);
		// 		window.addEventListener('popstate', function() {
		// 			history.pushState(null, null, document.URL);
		// 		});

		// 		function ajaxLogoutCallback() {
		// 			// 登出操作
		// 			history.pushState(null, null, document.URL);
		// 			window.addEventListener('popstate', function() {
		// 				history.pushState(null, null, document.URL);
		// 			});
		// 		}
	</script>
	<!-- <script src="./vendor/jquery/jquery-3.7.1.min.js"></script>
    <script src="./database/datatables.min.js"></script> -->
	<!-- <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script> -->

	<!-- proper.min.js first, then bootstrap.min.js -->
	<script
		src="<%=request.getContextPath()%>/backEnd-Website/vendor/bootstrap-4.1/popper.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/backEnd-Website/vendor/bootstrap-4.1/bootstrap.min.js"></script>
	<!-- Vendor JS       -->
	<script
		src="<%=request.getContextPath()%>/backEnd-Website/vendor/slick/slick.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/backEnd-Website/vendor/wow/wow.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/backEnd-Website/vendor/animsition/animsition.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/backEnd-Website/vendor/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/backEnd-Website/vendor/counter-up/jquery.waypoints.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/backEnd-Website/vendor/counter-up/jquery.counterup.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/backEnd-Website/vendor/circle-progress/circle-progress.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/backEnd-Website/vendor/perfect-scrollbar/perfect-scrollbar.js"></script>
	<script
		src="<%=request.getContextPath()%>/backEnd-Website/vendor/chartjs/Chart.bundle.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/backEnd-Website/vendor/select2/select2.min.js"></script>
	<!-- Main JS-->
	<script src="<%=request.getContextPath()%>/backEnd-Website/js/main.js"></script>
</body>
</html>