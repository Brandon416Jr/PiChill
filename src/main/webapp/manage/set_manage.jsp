<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.pichill.manage.entity.Manage"%>

<%
//見com.emp.controller.EmpServlet.java第238行存入req的empVO物件 (此為輸入格式有錯誤時的empVO物件)
Manage manage = (Manage) request.getAttribute("manage");
%>

<!DOCTYPE html>
<html lang="zh-Hant">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>修改員工資料</title>
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
</style>
</head>

<body class="animsition">
	<div class="page-wrapper">
		<!-- HEADER MOBILE-->
		<header class="header-mobile d-block d-lg-none">
			<div class="header-mobile__bar" style="background-color: #207dca">
				<div class="container-fluid">
					<div class="header-mobile-inner">
						<a class="logo" href="index.html"> <img
							src="./pic/pi_chill_text.png" alt="chill" style="height: 80px" />
						</a>
						<button class="hamburger hamburger--slider" type="button">
							<span class="hamburger-box"> <span class="hamburger-inner"></span>
							</span>
						</button>
					</div>
				</div>
			</div>
			<nav class="navbar-mobile">
				<div class="container-fluid">
					<ul class="navbar-mobile__list list-unstyled">
						<li class="has-sub"><a class="js-arrow" href="#"> <i
								class="fas fa-tachometer-alt"></i>員工管理
						</a>
							<ul class="list-styled navbar__sub-list js-sub-list">
								<li><a href="all_manage.html">所有員工資料</a></li>
								<li><a href="#">新增員工資料</a></li>
							</ul></li>
						<li class="has-sub"><a class="js-arrow" href="#"> <i
								class="fas fa-tachometer-alt"></i>一般會員管理
						</a>
							<ul class="list-styled navbar__sub-list js-sub-list">
								<li><a href="all_gUser.html">所有會員資料</a></li>
								<li><a href="new_gUser.html">新增會員資料</a></li>
							</ul></li>
						<li class="has-sub"><a class="js-arrow" href="#"> <i
								class="fas fa-tachometer-alt"></i>企業會員管理
						</a>
							<ul class="list-styled navbar__sub-list js-sub-list">
								<li><a href="all_oUser.html">所有會員資料</a></li>
								<li><a href="new_oUser.html">新增會員資料</a></li>
							</ul></li>
						<li class="has-sub"><a class="js-arrow" href="#"> <i
								class="fas fa-tachometer-alt"></i>最新消息管理
						</a>
							<ul class="list-styled navbar__sub-list js-sub-list">
								<li><a href="form.html">表單管理</a></li>
								<li><a href="all_announce.html">公告管理</a></li>
								<li><a href="new_announce.html">新增公告</a></li>
							</ul></li>
						<li class="has-sub"><a class="js-arrow" href="#"> <i
								class="fas fa-tachometer-alt"></i>論壇管理
						</a>
							<ul class="list-styled navbar__sub-list js-sub-list">
								<li><a href="all_post.html">所有文章</a></li>
								<li><a href="all_comment.html">所有留言</a></li>
								<li><a href="report.html">檢舉管理</a></li>
							</ul></li>
						<li class="has-sub"><a class="js-arrow" href="#"> <i
								class="fas fa-tachometer-alt"></i>球館管理
						</a>
							<ul class="list-styled navbar__sub-list js-sub-list">
								<li><a href="all_court.html">所有球館</a></li>
								<li><a href="all_place.html">所有場地</a></li>
							</ul></li>
						<li class="has-sub"><a href="order.html"> <i
								class="fas fa-tachometer-alt"></i>預約管理
						</a></li>
						<li class="has-sub"><a class="js-arrow" href="#"> <i
								class="fas fa-tachometer-alt"></i>商城管理
						</a>
							<ul class="list-styled navbar__sub-list js-sub-list">
								<li><a href="product.html">商品管理</a></li>
								<li><a href="new_product.html">新增商品</a></li>
								<li><a href="product_order.html">訂單管理</a></li>
							</ul></li>
					</ul>
				</div>
			</nav>
		</header>
		<!-- END HEADER MOBILE-->

		<!-- MENU SIDEBAR-->
		<aside class="menu-sidebar d-none d-lg-block">
			<!-- <div class="logo">
                <a href="#">
                    <img class="logo_l" src="./pic/pi_chill_text.png"/>
                </a>
            </div> -->
			<div class="menu-sidebar__content js-scrollbar1">
				<nav class="navbar-sidebar">
					<ul class="list-unstyled navbar__list">
						<li class="has-sub"><a class="js-arrow" href="#"> <i
								class="fas fa-tachometer-alt"></i>員工管理
						</a>
							<ul class="list-unstyled navbar__sub-list js-sub-list">
								<li><a href="all_manage.jsp">所有員工資料</a></li>
								<li><a href="new_manage.jsp">新增員工資料</a></li>
							</ul></li>
						<li class="has-sub"><a class="js-arrow" href="#"> <i
								class="fas fa-tachometer-alt"></i>一般會員管理
						</a>
							<ul class="list-unstyled navbar__sub-list js-sub-list">
								<li><a href="all_gUser.html">所有會員資料</a></li>
								<li><a href="new_gUser.html">新增會員資料</a></li>
							</ul></li>
						<li class="has-sub"><a class="js-arrow" href="#"> <i
								class="fas fa-tachometer-alt"></i>企業會員管理
						</a>
							<ul class="list-unstyled navbar__sub-list js-sub-list">
								<li><a href="all_oUser.html">所有會員資料</a></li>
								<li><a href="new_oUser.html">新增會員資料</a></li>
							</ul></li>
						<li class="has-sub"><a class="js-arrow" href="#"> <i
								class="fas fa-tachometer-alt"></i>最新消息管理
						</a>
							<ul class="list-unstyled navbar__sub-list js-sub-list">
								<li><a href="form.html">表單管理</a></li>
								<li><a href="all_announce.html">公告管理</a></li>
								<li><a href="new_announce.html">新增公告</a></li>
							</ul></li>
						<li class="has-sub"><a class="js-arrow" href="#"> <i
								class="fas fa-tachometer-alt"></i>論壇管理
						</a>
							<ul class="list-unstyled navbar__sub-list js-sub-list">
								<li><a href="all_post.html">所有文章</a></li>
								<li><a href="all_comment.html">所有留言</a></li>
								<li><a href="report.html">檢舉管理</a></li>
							</ul></li>
						<li class="has-sub"><a class="js-arrow" href="#"> <i
								class="fas fa-tachometer-alt"></i>球館管理
						</a>
							<ul class="list-unstyled navbar__sub-list js-sub-list">
								<li><a href="all_court.html">所有球館</a></li>
								<li><a href="all_place.html">所有場地</a></li>
							</ul></li>
						<li class="has-sub"><a href="order.html"> <i
								class="fas fa-tachometer-alt"></i>預約管理
						</a></li>
						<li class="has-sub"><a class="js-arrow" href="#"> <i
								class="fas fa-tachometer-alt"></i>商城管理
						</a>
							<ul class="list-unstyled navbar__sub-list js-sub-list">
								<li><a href="product.html">商品管理</a></li>
								<li><a href="new_product.html">新增商品</a></li>
								<li><a href="product_order.html">訂單管理</a></li>
							</ul></li>
					</ul>
				</nav>
			</div>
		</aside>
		<!-- END MENU SIDEBAR-->

		<!-- PAGE CONTAINER-->
		<div class="page-container">
			<!-- HEADER DESKTOP-->
			<header class="header-desktop">
				<div class="section__content section__content--p30">
					<div class="container-fluid">
						<div class="header-wrap">
							<div class="header-logo">
								<a href="index.html"><img class="img-logo" href="index.html"
									src="<%=request.getContextPath()%>/image/bigLogo.png" alt="" /></a>
							</div>
							<form class="form-header" action="#" method="POST">
								<input class="au-input au-input--xl" type="text" name="search"
									placeholder="搜尋" />
								<button class="au-btn--submit" type="submit">
									<i class="zmdi zmdi-search" style="font-size: 15px">送出</i>
								</button>
							</form>
							<div class="header-button">
								<div class="account-wrap">
									<div class="account-item clearfix js-item-menu">
										<div class="image">
											<img src="<%=request.getContextPath()%>/image/Group 115.png"
												alt="使用者頭像" />
										</div>
										<div class="content">
											<a class="js-acc-btn" href="#">管理員羅裕鵬，您好</a>
										</div>
										<div class="account-dropdown js-dropdown">
											<div class="info clearfix">
												<div class="image">
													<a href="#"> <img
														src="<%=request.getContextPath()%>/image/Group 115.png"
														alt="John Doe" />
													</a>
												</div>
												<div class="content">
													<h5 class="name">
														<a href="my_data.html">羅裕鵬</a>
													</h5>
													<span class="email">brandon416jr@gmail.com</span>
												</div>
											</div>
											<div class="account-dropdown__footer">
												<a href="#"> <i class="zmdi zmdi-power"></i>登出
												</a>
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
							<strong>修改 ${manage.mName} 員工資料</strong>
							<h4>
								<a href="all_manage.jsp"><img src="../image/smallLogo.png"
									width="20" height="20" border="0">回所有員工</a>
							</h4>
						</div>

						<%-- 錯誤表列 --%>
						<c:if test="${not empty errorMsgs}">
							<font style="color: red">請修正以下錯誤:</font>
							<ul style="list-style-type: none">
								<c:forEach var="message" items="${errorMsgs}">
									<li style="color: red">${message}</li>
								</c:forEach>
							</ul>
						</c:if>

						<form action="<%=request.getContextPath()%>/manage/manage.do" method="post" enctype="multipart/form-data">
							<div class="card-body">
								<div class="row">
									<div class="col-lg-6">
										<div class="left-card-body card-block">
											<div class="row form-group">
												<div class="col col-md-3">
													<label for="text-input" class="form-control-label">員工編號</label>
												</div>
												<div class="col-10 col-md-8">
													<input type="text" id="text-input" name="manageID"
														value="<%=manage.getManageID()%>" disabled="disabled"
														class="form-control" />
													<!-- <small class="form-text text-muted">This is a help text</small> -->
												</div>
											</div>
											<div class="row form-group">
												<div class="col col-md-3">
													<label for="text-input" class="form-control-label">員工姓名</label>
												</div>
												<div class="col-10 col-md-8">
													<input type="text" id="text-input" name="mName"
														value="<%=(manage == null) ? "陳金鋒" : manage.getmName()%>"
														class="form-control" />
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
														value="<%=(manage == null) ? "Chen5252" : manage.getmUserName()%>"
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
														value="<%=(manage == null) ? "52552252" : manage.getmPassword()%>"
														placeholder="請輸入密碼" class="form-control" />
													<!-- <small class="form-text text-muted">This is a help text</small> -->
												</div>
											</div>
											<div class="row form-group">
												<div class="col col-md-3">
													<label for="disabled-input" class="form-control-label">生日</label>
												</div>
												<div class="col-10 col-md-8">
													<input type="date" id="disabled-input" name="mBirth"
														value="<%=(manage == null) ? "1982-06-01" : manage.getmBirth()%>"
														placeholder="請輸入生日" class="form-control" />
												</div>
											</div>
											<div class="row form-group">
												<div class="col col-md-3">
													<label class="form-control-label">性別</label>
												</div>
												<div class="col col-md-8">
													<div class="form-check">
														<div class="radio">
															<select name="mGender">
																<option value="0">男</option>
																<option value="1">女</option>
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
														value="<%=(manage == null) ? "0918324387" : manage.getmTelephone()%>"
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
														value="<%=(manage == null) ? "陳連宏" : manage.getmEmgContact()%>"
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
														value="<%=(manage == null) ? "0914562187" : manage.getmEmgPhone()%>"
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
														value="<%=(manage == null) ? "環河西路587號22樓" : manage.getmAddress()%>"
														placeholder="請輸入聯絡地址" class="form-control" />
													<!-- <small class="form-text text-muted">This is a help text</small> -->
												</div>
											</div>
											<!-- 										<div class="row form-group"> -->
											<!-- 											<div class="col col-md-3"> -->
											<!-- 												<label for="disabled-input" class="form-control-label">入職日期</label> -->
											<!-- 											</div> -->
											<!-- 											<div class="col-10 col-md-8"> -->
											<!-- 												<input type="date" id="disabled-input" name="mHiredate" -->
											<%-- 													value="<%=(manage == null) ? "2022-01-01" : manage.getmHiredate()%>" --%>
											<!-- 													placeholder="請輸入生日" class="form-control" /> -->
											<!-- 											</div> -->
											<!-- 										</div> -->
											<!-- 										<div class="row form-group"> -->
											<!-- 											<div class="col col-md-3"> -->
											<!-- 												<label for="disabled-input" class="form-control-label">最後上線時間</label> -->
											<!-- 											</div> -->
											<!-- 											<div class="col-10 col-md-8"> -->
											<!-- 												<input type="text" id="disabled-input" name="mLastLogTime" -->
											<!-- 													placeholder="最後上線時間" -->
											<%-- 													value="<%=(manage == null) ? "1911-01-01 00:00:00" : manage.getmLastLogTime()%>" --%>
											<!-- 													class="form-control" /> -->
											<!-- 											</div> -->
											<!-- 										</div> -->
											<div class="row form-group">
												<div class="col col-md-3">
													<label for="disabled-input" class="form-control-label">身份證字號</label>
												</div>
												<div class="col-10 col-md-8">
													<input type="text" id="disabled-input" name="mID"
														placeholder="請輸入身份證字號"
														value="<%=(manage == null) ? "A123456678" : manage.getmID()%>"
														class="form-control" />
												</div>
											</div>
											<div class="row form-group">
												<div class="col col-md-3">
													<label for="text-input" class="form-control-label">電子信箱</label>
												</div>
												<div class="col-10 col-md-8">
													<input type="text" id="text-input" name="mEmail"
														value="<%=(manage == null) ? "brandon416jr@gmail.com" : manage.getmEmail()%>"
														placeholder="請輸入電子信箱" class="form-control" />
													<!-- <small class="form-text text-muted">This is a help text</small> -->
												</div>
											</div>
											<div class="row form-group">
												<div class="col col-md-3">
													<label for="file-input" class="form-control-label">上傳大頭貼</label>
												</div>
												<div class="col-10 col-md-8">
													<input type="file" id="file-input" name="mProfilePic"
														multiple="multiple" onclick="previewImage()"
														class="form-control-file" /> <img id="imagePreview"
														src="#" alt="Preview" width="100px" />
<!-- 													<div id="blob_holder"> -->
<!-- 														<img -->
<%-- 															src="<%=request.getContextPath()%>/manage/DBGifReader?manageID=${param.manageID}" --%>
<!-- 															width="100px"> -->
<!-- 													</div> -->
												</div>
											</div>
<!-- 										</div> -->
										<div class="row form-group">
											<div class="col col-md-3">
												<label for="selectLg" class="form-control-label">狀態</label>
											</div>
											<div class="col-10 col-md-8">
												<select name="mStatus" id="selectLm"
													class="form-control-sm form-control">
													<!-- 													<option value="0">請選擇</option> -->
													<option value="0">已離職</option>
													<option value="1">在職中</option>
												</select>
											</div>
										</div>

									</div>
									<div class="row form-group">
										<div class="col-12 col-md-8">
											<input type="hidden" name="action" value="update"> <input
												type="hidden" name="manageID"
												value="<%=manage.getManageID()%>"> <input
												type="submit" class="btn btn-primary btn-sm" value="送出修改">
											<i class="fa fa-dot-circle-o"></i>
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
	</div>
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
