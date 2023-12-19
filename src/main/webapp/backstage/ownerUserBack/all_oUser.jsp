<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<%@ page import="com.pichill.owneruser.entity.OwnerUser"%>
<%@ page import="com.pichill.backstage.owneruser.model.*"%>
<%@ page
	import="com.pichill.backstage.owneruser.service.OwnerUserServiceBack"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>
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
OwnerUserServiceBack oUserSvcB = new OwnerUserServiceBack();
List<OwnerUser> list = oUserSvcB.getAll();
pageContext.setAttribute("list", list);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>所有會員資料 (企業)</title>

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
/*       div.dataTables_scrollHeadInner { */
/*         width: 100% !important; */
/*       } */

/*       div.dataTables_scrollHeadInner > table.table-data3 { */
/*         margin: 0 auto !important; */
/*       } */

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
<body class="animsition all-employees-page">
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
								<li><a href="#">所有會員資料</a></li>	
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
							<a href="<%=request.getContextPath()%>/backstage/login/index.jsp"><img
								class="img-logo"
								src="<%=request.getContextPath()%>/image/bigLogo.png" alt="" /></a>
							<!-- 							<a href="index.html"><img class="img-logo"  -->
							<%-- 								src="<%=request.getContextPath()%>/image/bigLogo.png" alt="" /></a> --%>
						</div>
						
						<div class="welcome">
								<div class="flex">
									<div class="s-logo">
										<img src="${pageContext.request.contextPath }/backEnd-Website/pic/smallLogo.png" alt="">
									</div>
									<p class="welcome">π Chill後臺管理系統</p>
									<div class="s-logo">
										<img src="${pageContext.request.contextPath }/backEnd-Website/pic/smallLogo.png" alt="">
									</div>
								</div>
							</div>
						
						<div class="header-button">
							<div class="account-wrap">
								<div class="account-item clearfix js-item-menu">
									<div class="image">
																				<img
																					src="<%=request.getContextPath()%>/manage/DBJPGReader?manageID=${manage.manageID}"
																					alt="使用者頭像" /> 
<%-- 										<img src="<%=request.getContextPath()%>/image/Group 115.png" --%>
<!-- 											alt="使用者頭像" /> -->
									</div>
									<div class="content">
<!-- 										<a class="js-acc-btn" href="#">管理員羅裕鵬，您好</a> -->
																				<a class="js-acc-btn" href="#">管理員<%=manage.getmName() %>，您好</a>
									</div>
									<div class="account-dropdown js-dropdown">
										<div class="info clearfix">
											<div class="image">
												<a href="#"> 											<img
																							src="${pageContext.request.contextPath }/manage/DBJPGReader?manageID=${manage.manageID}"
																							alt="使用者頭像" />
<!-- 													<img -->
<%-- 													src="<%=request.getContextPath()%>/image/Group 115.png" --%>
<!-- 													alt="John Doe" /> -->
												</a>
											</div>
											<div class="content">
												<h5 class="name">
													<a href="#"><%=manage.getmName() %></a>
													<%-- 													<a href="<%=request.getContextPath()%>/manage/manage.do?action=getOne_For_Update&manageID=<%=manage.getManageID()%>"><%=manage.getmName() %></a> --%>
												</h5>
<!-- 												<span class="email">brandon416jr@gmail.com</span> -->
																								<span class="email"><%=manage.getmEmail() %></span>
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

	<div class="page-container2">
		<div class="table-responsive m-b-40">
			<table id="myTable" class="table table-borderless table-data3"
				style="overflow-x: auto">
				<thead>
					<tr>
						<th>會員編號</th>
						<th>帳號</th>
						<th>密碼</th>
						<th>身份證字號</th>
						<th>統編</th>
						<th>姓名</th>
						<th>性別</th>
						<th>生日</th>
						<th>連絡電話</th>
						<th>地址</th>
						<th>銀行代號</th>
						<th>銀行帳號</th>
						<th>大頭貼</th>
						<th>註冊日期</th>
						<th>討論版文章數</th>
						<th>被檢舉數</th>
						<th>上架球館次數</th>
						<th>被預約次數</th>
						<th>電子信箱</th>
						<th>查看</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="ownerUser" items="${list}">
						<tr>
							<td>${ownerUser.oUserID}</td>
							<td>${ownerUser.oUserName}</td>
							<td>${ownerUser.oPassword}</td>
							<td>${ownerUser.oIDNum}</td>
							<td>${ownerUser.compiled}</td>
							<td>${ownerUser.oName}</td>
							<td>${ownerUser.oGender}</td>
							<td>${ownerUser.oBirth}</td>
							<td>${ownerUser.oTelephone}</td>
							<td>${ownerUser.oAddress}</td>
							<td>${ownerUser.oBankCode}</td>
							<td>${ownerUser.oBankAccount}</td>
							<%--               <td>${ownerUser.oProfilePic}</td> --%>
							<td><img
								src="<%=request.getContextPath()%>/owneruser/DBJPGReader?oUserID=${ownerUser.oUserID}"
								width="100px"></td>
							<td>${ownerUser.oRegisterDate}</td>
							<td>${ownerUser.oPostAmount}</td>
							<td>${ownerUser.oReportCnt}</td>
							<td>${ownerUser.courtArriveCnt}</td>
							<td>${ownerUser.rsvdCnts}</td>
							<td>${ownerUser.oEmail}</td>
							<td>
								<FORM METHOD="post"
									ACTION="<%=request.getContextPath()%>/owneruser/owneruserb.do"
									style="margin-bottom: 0px;">
									<input class="modify-button" type="submit" value="查看"
										style="background-color: #207DCA; color: white; width: 50px; border-radius: 10px;">
									<input type="hidden" name="oUserID"
										value="${ownerUser.oUserID}"> <input type="hidden"
										name="action" value="getOne_For_Update">
								</FORM>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<script>
		var script = document.createElement("script");

		script.src = "https://code.jquery.com/jquery-3.4.1.min.js";

		script.type = "text/javascript";

		document.getElementsByTagName("head")[0].appendChild(script);
	</script>
	<script>
		$(document)
				.ready(
						function() {
							$("#myTable")
									.DataTable(
											{
												// paging: true, 
												// searching: true, 

												// 中文化
												language : {
													processing : "處理中...",
													loadingRecords : "載入中...",
													paginate : {
														first : "第一頁",
														previous : "上一頁",
														next : "下一頁",
														last : "最後一頁",
													},
													emptyTable : "目前沒有資料",
													datetime : {
														previous : "上一頁",
														next : "下一頁",
														hours : "時",
														minutes : "分",
														seconds : "秒",
														amPm : [ "上午", "下午" ],
														unknown : "未知",
														weekdays : [ "週日",
																"週一", "週二",
																"週三", "週四",
																"週五", "週六", ],
														months : [ "一月", "二月",
																"三月", "四月",
																"五月", "六月",
																"七月", "八月",
																"九月", "十月",
																"十一月", "十二月", ],
													},
													searchBuilder : {
														add : "新增條件",
														condition : "條件",
														deleteTitle : "刪除過濾條件",
														button : {
															_ : "複合查詢 (%d)",
															0 : "複合查詢",
														},
														clearAll : "清空",
														conditions : {
															array : {
																contains : "含有",
																equals : "等於",
																empty : "空值",
																not : "不等於",
																notEmpty : "非空值",
																without : "不含",
															},
															date : {
																after : "大於",
																before : "小於",
																between : "在其中",
																empty : "為空",
																equals : "等於",
																not : "不為",
																notBetween : "不在其中",
																notEmpty : "不為空",
															},
															number : {
																between : "在其中",
																empty : "為空",
																equals : "等於",
																gt : "大於",
																gte : "大於等於",
																lt : "小於",
																lte : "小於等於",
																not : "不為",
																notBetween : "不在其中",
																notEmpty : "不為空",
															},
															string : {
																contains : "含有",
																empty : "為空",
																endsWith : "字尾為",
																equals : "等於",
																not : "不為",
																notEmpty : "不為空",
																startsWith : "字首為",
																notContains : "不含",
																notStartsWith : "開頭不是",
																notEndsWith : "結尾不是",
															},
														},
														data : "欄位",
														leftTitle : "群組條件",
														logicAnd : "且",
														logicOr : "或",
														rightTitle : "取消群組",
														title : {
															_ : "複合查詢 (%d)",
															0 : "複合查詢",
														},
														value : "內容",
													},
													editor : {
														close : "關閉",
														create : {
															button : "新增",
															title : "新增資料",
															submit : "送出新增",
														},
														remove : {
															button : "刪除",
															title : "刪除資料",
															submit : "送出刪除",
															confirm : {
																_ : "您確定要刪除您所選取的 %d 筆資料嗎？",
																1 : "您確定要刪除您所選取的 1 筆資料嗎？",
															},
														},
														error : {
															system : "系統發生錯誤(更多資訊)",
														},
														edit : {
															button : "修改",
															title : "修改資料",
															submit : "送出修改",
														},
														multi : {
															title : "多重值",
															info : "您所選擇的多筆資料中，此欄位包含了不同的值。若您想要將它們都改為同一個值，可以在此輸入，要不然它們會保留各自原本的值。",
															restore : "復原",
															noMulti : "此輸入欄需單獨輸入，不容許多筆資料一起修改",
														},
													},
													autoFill : {
														cancel : "取消",
													},
													buttons : {
														copySuccess : {
															_ : "複製了 %d 筆資料",
															1 : "複製了 1 筆資料",
														},
														copyTitle : "已經複製到剪貼簿",
														excel : "Excel",
														pdf : "PDF",
														print : "列印",
														copy : "複製",
														colvis : "欄位顯示",
														colvisRestore : "重置欄位顯示",
														csv : "CSV",
														pageLength : {
															"-1" : "顯示全部",
															_ : "顯示 %d 筆",
														},
														createState : "建立狀態",
														removeAllStates : "移除所有狀態",
														removeState : "移除",
														renameState : "重新命名",
														savedStates : "儲存狀態",
														stateRestore : "狀態 %d",
														updateState : "更新",
													},
													searchPanes : {
														collapse : {
															_ : "搜尋面版 (%d)",
															0 : "搜尋面版",
														},
														emptyPanes : "沒搜尋面版",
														loadMessage : "載入搜尋面版中...",
														clearMessage : "清空",
														count : "{total}",
														countFiltered : "{shown} ({total})",
														title : "過濾條件 - %d",
														showMessage : "顯示全部",
														collapseMessage : "摺疊全部",
													},
													stateRestore : {
														emptyError : "名稱不能空白。",
														creationModal : {
															button : "建立",
															columns : {
																search : "欄位搜尋",
																visible : "欄位顯示",
															},
															name : "名稱：",
															order : "排序",
															paging : "分頁",
															scroller : "卷軸位置",
															search : "搜尋",
															searchBuilder : "複合查詢",
															select : "選擇",
															title : "建立新狀態",
															toggleLabel : "包含：",
														},
														duplicateError : "此狀態名稱已經存在。",
														emptyStates : "名稱不可空白。",
														removeConfirm : "確定要移除 %s 嗎？",
														removeError : "移除狀態失敗。",
														removeJoiner : "和",
														removeSubmit : "移除",
														removeTitle : "移除狀態",
														renameButton : "重新命名",
														renameLabel : "%s 的新名稱：",
														renameTitle : "重新命名狀態",
													},
													select : {
														columns : {
															_ : "選擇了 %d 欄資料",
															1 : "選擇了 1 欄資料",
														},
														rows : {
															1 : "選擇了 1 筆資料",
															_ : "選擇了 %d 筆資料",
														},
														cells : {
															1 : "選擇了 1 格資料",
															_ : "選擇了 %d 格資料",
														},
													},
													zeroRecords : "沒有符合的資料",
													aria : {
														sortAscending : "：升冪排列",
														sortDescending : "：降冪排列",
													},
													info : "顯示第 _START_ 至 _END_ 筆結果，共 _TOTAL_ 筆",
													infoEmpty : "顯示第 0 至 0 筆結果，共 0 筆",
													infoFiltered : "(從 _MAX_ 筆結果中過濾)",
													infoThousands : ",",
													lengthMenu : "顯示 _MENU_ 筆結果",
													search : "搜尋：",
													searchPlaceholder : "請輸入關鍵字",
													thousands : ",",
												},
											});
						});

		console.log({
			paging : true,
			ordering : false,
			info : false,
		});

		$("#example").DataTable({
			paging : true,
			ordering : false,
			info : false,
		});

		new DataTable("#myTable", {
			scrollX : true,
		});
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