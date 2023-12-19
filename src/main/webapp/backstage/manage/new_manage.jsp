<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.pichill.manage.entity.Manage"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>



<%
//見com.emp.controller.EmpServlet.java第238行存入req的empVO物件 (此為輸入格式有錯誤時的empVO物件)
Manage newManage = (Manage) request.getAttribute("newManage");
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
<title>新增員工資料</title>
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
	href="<%=request.getContextPath()%>/backEnd-Website/css/set.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/backEnd-Website/css/header.css"
	media="all" />
<style>

/* 錯誤提示框樣式 */
input:invalid, select:invalid {
	box-shadow: none;
}

select:invalid {
	color: red;
}

/* 自定義標題樣式 */
select:invalid+.custom-message {
	display: block;
	color: #207dca;
	font-weight: bold;
	margin-top: 5px;
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
</style>
</head>

<body class="animsition">
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
										href="<%=request.getContextPath()%>/backstage/manage/all_manage.jsp">所有員工資料</a></li>
									<li><a href="#">新增員工資料</a></li>
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
									href="<%=request.getContextPath()%>/backstage/login/index.jsp"><img
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
											<%-- 											<img src="<%=request.getContextPath()%>/image/Group 115.png" --%>
											alt="使用者頭像" />
										</div>
										<div class="content">
											<!-- 											<a class="js-acc-btn" href="#">管理員羅裕鵬，您好</a> -->
											<a class="js-acc-btn" href="#">管理員<%=manage.getmName()%>，您好
											</a>
										</div>
										<div class="account-dropdown js-dropdown">
											<div class="info clearfix">
												<div class="image">
													<a href="#"> <img
														src="<%=request.getContextPath()%>/manage/DBJPGReader?manageID=<%=manage.getManageID()%>"
														alt="使用者頭像" /> <!-- 																								<img --> <%-- 														src="<%=request.getContextPath()%>/image/Group 115.png" --%>
														<!-- 														alt="" /> -->
													</a>
												</div>
												<div class="content">
													<h5 class="name">
														<a href="#"><%=manage.getmName()%></a>
														<%-- 													<a href="<%=request.getContextPath()%>/manage/manage.do?action=getOne_For_Update&manageID=<%=manage.getManageID()%>"><%=manage.getmName() %></a> --%>
													</h5>
													<!-- 													<span class="email">brandon416jr@gmail.com</span> -->
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
							<strong>新增員工資料</strong>
							<h4>
								<a
									href="<%=request.getContextPath()%>/backstage/manage/all_manage.jsp"><img
									src="<%=request.getContextPath()%>/image/smallLogo.png"
									width="20" height="20" border="0">回所有員工</a>
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


						<FORM
							ACTION="${pageContext.request.contextPath }/manage/manage.do"
							METHOD="post" enctype="multipart/form-data">
							<div class="card-body">
								<div class="row">
									<div class="col-lg-6">
										<div class="left-card-body card-block">
											<div class="row form-group">
												<div class="col col-md-3">
													<label for="text-input" class="form-control-label">員工姓名</label>
												</div>
												<div class="col-10 col-md-8">
													<input type="text" id="text-input" name="mName"
														value="<%=(newManage == null) ? "緯育" : newManage.getmName()%>"
														placeholder="請輸入姓名" class="form-control" />
													<!-- <small class="form-text text-muted">This is a help text</small> -->
												</div>
											</div>
											<div class="row form-group">
												<div class="col col-md-3">
													<label for="text-input" class="form-control-label">帳號</label>
												</div>
												<div class="col-10 col-md-8">
													<input type="text" id="text-input" name="mUserName"
														placeholder="請輸入帳號"
														value="<%=(newManage == null) ? "TibameTHA104" : newManage.getmUserName()%>"
														class="form-control" />
													<!-- <small class="form-text text-muted">This is a help text</small> -->
												</div>
											</div>
											<div class="row form-group">
												<div class="col col-md-3">
													<label for="text-input" class="form-control-label">密碼</label>
												</div>
												<div class="col-10 col-md-8">
													<input type="text" id="text-input" name="mPassword"
														value="<%=(newManage == null) ? "32802154ya" : newManage.getmPassword()%>"
														placeholder="請輸入密碼" class="form-control" />
													<!-- <small class="form-text text-muted">This is a help text</small> -->
												</div>
											</div>
											<div class="row form-group">
												<div class="col col-md-3">
													<label for="disabled-input" class="form-control-label">生日</label>
												</div>
												<div class="col-10 col-md-8">
												
													<%
													Date today = new Date();
													SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
													String todayStr = sdf.format(today);
													%>
													<input type="date" id="f_date1" name="mBirth"
														max="<%=todayStr%>"
														value="<%=(newManage == null) ? "1982-06-01" : newManage.getmBirth()%>"
														placeholder="請輸入生日" class="form-control" />
												</div>
											</div>
											<div class="row form-group">
												<div class="col col-md-3">
													<label class="form-control-label">性別</label>
												</div>
												<div class="col col-md-9">
													<div class="form-check">
														<div class="radio">
															<select name="mGender">
																<option value="0"
																	${(newManage.mGender==0)? 'selected': ''}>男</option>
																<option value="1"
																	${(newManage.mGender==1)? 'selected': ''}>女</option>
															</select>
														</div>
													</div>
												</div>
											</div>
											<div class="row form-group">
												<div class="col col-md-3">
													<label for="text-input" class="form-control-label">手機</label>
												</div>
												<div class="col-10 col-md-8">
													<input type="text" id="text-input" name="mTelephone"
														value="<%=(newManage == null) ? "0918111387" : newManage.getmTelephone()%>"
														placeholder="請輸入手機號碼" class="form-control" />
													<!-- <small class="form-text text-muted">This is a help text</small> -->
												</div>
											</div>
											<div class="row form-group">
												<div class="col col-md-3">
													<label for="text-input" class="form-control-label">緊急連絡人</label>
												</div>
												<div class="col-10 col-md-8">
													<input type="text" id="text-input" name="mEmgContact"
														value="<%=(newManage == null) ? "陳連宏" : newManage.getmEmgContact()%>"
														placeholder="請輸入姓名" class="form-control" />
													<!-- <small class="form-text text-muted">This is a help text</small> -->
												</div>
											</div>
											<div class="row form-group">
												<div class="col col-md-3">
													<label for="text-input" class="form-control-label">緊急連絡人手機</label>
												</div>
												<div class="col-10 col-md-8">
													<input type="text" id="text-input" name="mEmgPhone"
														value="<%=(newManage == null) ? "0914562187" : newManage.getmEmgPhone()%>"
														placeholder="請輸入手機號碼" class="form-control" />
													<!-- <small class="form-text text-muted">This is a help text</small> -->
												</div>
											</div>
										</div>
									</div>
									<div class="col-lg-6">
										<div class="right-card-body card-block">

											<div class="row form-group">
												<div class="col col-md-3">
													<label for="text-input" class="form-control-label">聯絡地址</label>
												</div>
												<div class="col-10 col-md-8">
													<select id="city" name="city" required>
														<option value="">請選擇縣市</option>
													</select> <span class="custom-message">*請選擇縣市</span> <select
														id="area" name="area" required>
														<option value="">請選擇鄉鎮市區</option>
													</select> <span class="custom-message">*請選擇鄉鎮市區</span>
												</div>
											</div>
											<div class="row form-group">
												<div class="col col-md-3">
													<label for="text-input" class="form-control-label"></label>
												</div>
												<div class="col-10 col-md-8">
													<input type="text" id="text-input" name="mAddress"
														value="<%=(newManage == null) ? "環河西路587號22樓" : newManage.getmAddress()%>"
														placeholder="請輸入聯絡地址" class="form-control" />
													<!-- <small class="form-text text-muted">This is a help text</small> -->
												</div>
											</div>
											<div class="row form-group">
												<div class="col col-md-3">
													<label for="disabled-input" class="form-control-label">入職日期</label>
												</div>
												<div class="col-10 col-md-8">
													<input type="date" id="disabled-input" name="mHiredate"
														value="<%=(newManage == null) ? "" : newManage.getmHiredate()%>"
														placeholder="請輸入生日" class="form-control" />
												</div>
											</div>
											<div class="row form-group">
												<div class="col col-md-3">
													<label for="disabled-input" class="form-control-label">身份證字號</label>
												</div>
												<div class="col-10 col-md-8">
													<input type="text" id="disabled-input" name="mID"
														placeholder="請輸入身份證字號"
														value="<%=(newManage == null) ? "G109374920" : newManage.getmID()%>"
														class="form-control" />
												</div>
											</div>
											<div class="row form-group">
												<div class="col col-md-3">
													<label for="text-input" class="form-control-label">電子信箱</label>
												</div>
												<div class="col-10 col-md-8">
													<input type="text" id="text-input" name="mEmail"
														value="<%=(newManage == null) ? "brandonsssjr@gmail.com" : newManage.getmEmail()%>"
														placeholder="請輸入電子信箱" class="form-control" />
													<!-- <small class="form-text text-muted">This is a help text</small> -->
												</div>
											</div>
											<div class="row form-group">
												<div class="col col-md-3">
													<label for="file-input" class="form-control-label">上傳大頭貼</label>
												</div>
												<div class="col-10 col-md-8">
													<input type="file" value="${newManage.mProfilePic }"
														id="uploadImg" name="mProfilePic" onchange="preview()"
														class="form-control-file" />
													<div id="blob_holder">
														<img src="#" width="100px">
													</div>
												</div>
											</div>
											<div class="row form-group">
												<div class="col col-md-3">
													<label for="selectLg" class="form-control-label">狀態</label>
												</div>
												<div class="col-10 col-md-8">

													<select name="mStatus" id="selectLm"
														class="form-control-sm form-control">
														<option value="3">請選擇</option>
														<option value="0"
															${(newManage.mStatus==0)? "selected": ''}>已離職</option>
														<option value="1"
															${(newManage.mStatus==1)? "selected": ''}>在職中</option>
														<option value="2"
															${(newManage.mStatus==2)? "selected": ''}>系統管理員</option>
													</select>
												</div>
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
						</FORM>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
		$.datetimepicker.setLocale('zh'); // kr ko ja en
		$('#f_date1').datetimepicker({
			theme : '', //theme: 'dark',
			timepicker : true, //timepicker: false,
			step : 1, //step: 60 (這是timepicker的預設間隔60分鐘)
			format : 'Y-m-d',
			value : new Date(),
			//disabledDates:    ['2022/06/08','2022/06/09','2022/06/10'], // 去除特定不含
			//startDate:	        '2022/07/10',  // 起始日
			//minDate:           '-1970-01-01', // 去除今日(不含)之前
			maxDate : '+1970-01-01' // 去除今日(不含)之後
		});
	</script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script>
		$(document)
				.ready(
						function() {

							//第一層選單
							$
									.ajax({
										url : 'https://raw.githubusercontent.com/donma/TaiwanAddressCityAreaRoadChineseEnglishJSON/master/CityCountyData.json',
										type : "get",
										dataType : "json",
										success : function(data) {
											$
													.each(
															data,
															function(key, value) {
																console.log(
																		key,
																		value)
																$('#city')
																		.append(
																				'<option value="'+data[key].CityName+'">'
																						+ data[key].CityName
																						+ '</option>')
															})
										},
										error : function(data) {
											alert("fail");
										}
									});

							//第二層選單
							$("#city")
									.change(
											function() {
												cityvalue = $("#city").val(); //取值
												$("#area").empty(); //清空上次的值
												$("#area").css("display",
														"inline"); //顯現
												$
														.ajax({
															url : 'https://raw.githubusercontent.com/donma/TaiwanAddressCityAreaRoadChineseEnglishJSON/master/CityCountyData.json',
															type : "get",
															dataType : "json",
															success : function(
																	data) {

																// 																eachval = data[cityvalue].AreaList; //鄉鎮
																eachval = [];
																for (let i = 0; i < data.length; i++) {
																	if (data[i].CityName == cityvalue) {
																		eachval = data[i].AreaList;
																	}
																}

																$
																		.each(
																				eachval,
																				function(
																						key,
																						value) {
																					$(
																							'#area')
																							.append(
																									'<option value="'+eachval[key].AreaName+'">'
																											+ eachval[key].AreaName
																											+ '</option>')
																				});
															},
															error : function() {
																alert("fail");
															}
														});
											});

							//選完後跳出選擇值
							$("#area")
									.change(
											function() {
												cityvalue = $("#city").val(); //縣市
												areavalue = $("#area").val(); //鄉鎮

												$
														.ajax({
															url : 'https://raw.githubusercontent.com/donma/TaiwanAddressCityAreaRoadChineseEnglishJSON/master/CityCountyData.json',
															type : "get",
															dataType : "json",
															success : function(
																	data) {
																alert(data[cityvalue].CityName
																		+ "-"
																		+ data[cityvalue].AreaList[areavalue].AreaName);
															},
															error : function() {
																alert("fail");
															}

														});
											})

						});
	</script>

	<script>
		function preview() {

			var fileInput = document.getElementById('uploadImg');
			var file = fileInput.files[0];

			var reader = new FileReader();

			reader.onload = function() {
				document.getElementById('blob_holder').innerHTML = '<img src="' + reader.result + '" width="100px"/>';
			};

			if (file) {
				reader.readAsDataURL(file);
			}

		}
	</script>
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
