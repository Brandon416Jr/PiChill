<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.pichill.backstage.announcement.entity.Announcement"%>
<%@ page import="com.pichill.manage.entity.Manage"%>
<%
Manage manage = (Manage) session.getAttribute("manage");
// 寫死
// Integer manageID = 13000003;
// ManageService manageSvc = new ManageService();
// Manage manage = manageSvc.getOneManage(manageID);
// pageContext.setAttribute("manage",manage);
%>
<%
//見com.emp.controller.EmpServlet.java第238行存入req的empVO物件 (此為輸入格式有錯誤時的empVO物件)
Announcement announcement = (Announcement) request.getAttribute("announcement");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>新增公告</title>
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
<!-- Main CSS-->
<link href="<%=request.getContextPath()%>/backEnd-Website/css/main.css"
	rel="stylesheet" media="all" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/backEnd-Website/css/set.css"
	media="all" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/backEnd-Website/css/set_form.css"
	media="all" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/backEnd-Website/css/header.css"
	media="all" />
<style>
.account-dropdown__footer {
	display: flex;
	justify-content: flex-end;
}

.btn {
	margin-left: auto;
	width: 100%;
	box-sizing: border-box;
}
</style>
</head>
<body class="animsition">
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
									href="<%=request.getContextPath()%>/backstage/manage/all_manage.jsp">所有員工資料</a></li>
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
								<li><a href="#">新增公告</a></li>
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
							<a href="<%=request.getContextPath()%>/backstage/login/index.jsp"><img
								class="img-logo"
								src="<%=request.getContextPath()%>/image/bigLogo.png" alt="" /></a>
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
										<img
											src="<%=request.getContextPath()%>/manage/DBJPGReader?manageID=<%=manage.getManageID()%>"
											alt="使用者頭像" />
										<!-- 											<img -->
										<%-- 											src="<%=request.getContextPath()%>/image/Group 115.png" --%>
										<!-- 											alt="使用者頭像" /> -->
									</div>
									<div class="content">
										<!-- 										<a class="js-acc-btn" href="#">管理員羅裕鵬，您好</a> -->
										<a class="js-acc-btn" href="#">管理員<%=manage.getmName()%>，您好
										</a>
									</div>
									<div class="account-dropdown js-dropdown">
										<div class="info clearfix">
											<div class="image">
												<a href="#"> <img
													src="<%=request.getContextPath()%>/manage/DBJPGReader?manageID=<%=manage.getManageID()%>"
													alt="使用者頭像" /> <!-- 												<img --> <%-- 													src="<%=request.getContextPath()%>/image/Group 115.png" --%>
													<!-- 													alt="John Doe" /> -->
												</a>
											</div>
											<div class="content">
												<h5 class="name">
													<a href="#"><%=manage.getmName()%></a>
													<%-- 													<a href="<%=request.getContextPath()%>/manage/manage.do?action=getOne_For_Update&manageID=<%=manage.getManageID()%>"><%=manage.getmName() %></a> --%>
												</h5>
												<!-- 												<span class="email">brandon416jr@gmail.com</span> -->
												<span class="email"><%=manage.getmEmail()%></span>
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

	<div class="main-content">
		<div class="section__content2 section__content--p30">
			<div class="container-fluid2">
				<div class="card">
					<div class="card-header">
						<strong>新增公告</strong>
						<h4>
							<a
								href="<%=request.getContextPath()%>/backstage/announcementBack/all_announcement.jsp"><img
								src="<%=request.getContextPath()%>/image/smallLogo.png"
								width="20" height="20" border="0">回所有公告</a>
						</h4>
					</div>

					<div class="error">
						<%-- 錯誤表列 --%>
						<c:if test="${not empty errorMsgs}">
							<font style="color: red">請修正以下錯誤:</font>
							<ul style="list-style-type: none">
								<c:forEach var="message" items="${errorMsgs}">
									<li style="color: red">${message}</li>
								</c:forEach>
							</ul>
						</c:if>
					</div>
					<form
						action="${pageContext.request.contextPath }/announcement/announcementb.do"
						method="post" enctype="multipart/form-data"
						class="form-horizontal">
						<div class="card-body">
							<div class="row">
								<div class="col-lg-12">
									<div class="card-body card-block">
										<div class="row form-group">
											<div class="col col-md-3">
												<label for="text-input" class="form-control-label">管理員編號</label>
											</div>
											<div class="col-10 col-md-8">
												<input type="text" id="text-input" name="manageID"
													placeholder="請輸入管理員編號"
													value="<%=(announcement == null) ? "13000001" : announcement.getManage().getManageID()%>"
													class="form-control" />
												<!-- <small class="form-text text-muted">This is a help text</small> -->
											</div>
										</div>
										<div class="row form-group">
											<div class="col col-md-3">
												<label for="text-input" class="form-control-label">表單編號</label>
											</div>
											<div class="col-10 col-md-8">
												<input type="text" id="text-input" name="formID"
													placeholder="請輸入表單編號"
													value="<%=(announcement == null) ? "22000001" : announcement.getFormID()%>"
													class="form-control" />
												<!-- <small class="form-text text-muted">This is a help text</small> -->
											</div>
										</div>
										<div class="row form-group">
											<div class="col col-md-3">
												<label for="text-input" class="form-control-label">標題</label>
											</div>
											<div class="col-10 col-md-8">
												<input type="text" id="text-input" name="annoTitle"
													placeholder="請輸入標題"
													value="<%=(announcement == null) ? "請輸入標題" : announcement.getAnnoTitle()%>"
													class="form-control" />
												<!-- <small class="form-text text-muted">This is a help text</small> -->
											</div>
										</div>
										<div class="row form-group">
											<div class="col col-md-3">
												<label for="text-input" class="form-control-label">內文</label>
											</div>
											<div class="textbox col-10 col-md-8">
												<textarea name="annoContent" id="textarea-input" rows="9"
													placeholder="請輸入內文" class="form-control"><%=(announcement == null) ? "請輸入內文" : announcement.getAnnoContent()%></textarea>
											</div>
										</div>
										<div class="row form-group">
											<div class="col col-md-3">
												<label for="file-input" class="form-control-label">圖片</label>
											</div>
											<div class="col-10 col-md-8">
												<input type="file" id="uploadImg" name="annoPic" value="${announcement.annoPic }"
													onclick="previewImage()" multiple="multiple"
													onchange="preview()"
													class="form-control-file" /><div id="blob_holder">
														<img
															src="#"
															width="100px">
													</div>
											</div>
										</div>
										<div class="row form-group">
											<div class="col col-md-3">
												<label for="text-input" class="form-control-label">時間</label>
											</div>
											<div class="col-10 col-md-8">
												<input type="text" id="text-input" name="annoTime"
													placeholder="時間"
													value="<%=(announcement == null) ? "請輸入時間" : announcement.getAnnoTime()%>"
													class="form-control" />
												<!-- <small class="form-text text-muted">This is a help text</small> -->
											</div>
										</div>
										<div class="row form-group">
											<div class="col col-md-3">
												<label for="selectLg" class="form-control-label">公告狀態</label>
											</div>
											<div class="col-10 col-md-8">
												<select name="annoStatus" id="selectLm"
													class="form-control-sm form-control">
													<option value="0">未公告</option>
													<option value="1">已公告</option>
												</select>
											</div>
										</div>
										<div class="row form-group">
											<div class="col-1 col-md-8">
												<input type="hidden" name="action" value="insert"> <input
													type="submit" class="btn btn-primary btn-sm" value="送出新增">
												<i class="fa fa-dot-circle-o"></i>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script>
		function preview() {

			var fileInput = document.getElementById('uploadImg');
			var file = fileInput.files[0];

			var reader = new FileReader();

			reader.onload = function() {
				document.getElementById('blob_holder').innerHTML = '<img src="' + reader.result + '" width="400px"/>';
			};

			if (file) {
				reader.readAsDataURL(file);
			}

		}
	</script>
	<script>
		function checkmStatus() {
			let mStatus =
	<%=session.getAttribute("mStatus")%>
		;
			console.log(mStatus);
			if (mStatus === 1) {
				Swal.fire({
					icon : 'error',
					title : '權限不足!!',
					text : '請聯繫系統管理員',
					showConfirmButton : false,
					timer : 50000000
				})
				return false;
			}
			return true;
		}
	</script>

	<!-- <script>
      const textbox = document.querySelector('.textbox .form-control');
        textbox.addEventListener('input', (e) => {
        e.target.style.height = 'auto';
        e.target.style.height = e.target.scrollHeight + 'px';
      });
    </script> -->
	<script
		src="<%=request.getContextPath()%>/backEnd-Website/js/pic_uplaod.js"></script>
	<!-- Jquery JS-->
	<script
		src="<%=request.getContextPath()%>/backEnd-Website/vendor/jquery-3.2.1.min.js"></script>
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