<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.pichill.contactus.service.ContactUsServiceImpl"%>
<%@ page import="com.pichill.contactus.entity.ContactUs"%>


<%
ContactUsServiceImpl contactUsService = new ContactUsServiceImpl();
     /* List<ContactUs> list = contactUsService.getAllPosts();  */
    List<ContactUs> list = contactUsService.getAll();
    pageContext.setAttribute("list",list);
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>listAllContactUs</title>
<!-- JQuery 連結 -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<!-- Datatable 連結 -->
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.13.7/css/jquery.dataTables.css" />
<script src="https://cdn.datatables.net/1.13.7/js/jquery.dataTables.js"></script>

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/generaluser/CSS/bootstrap.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/generaluser/css2/css.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/generaluser/css2/guser.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/generaluser/css2/allOrder.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/generaluser/css2/index.css">
</head>
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


				<ul class="nav nav-pills">
					<li class="nav-item"><a href="<%=request.getContextPath()%>/generaluser/main.jsp" class="nav-link">首頁</a></li>
					<li class="nav-item"><a href="#" class="nav-link">公告</a></li>
					<li class="nav-item"><a href="#" class="nav-link">場館資訊</a></li>
					<li class="nav-item"><a href="<%=request.getContextPath()%>/reserveorder/reserveOrder.jsp" class="nav-link">我要預約</a></li>
					<li class="nav-item"><a href="#" class="nav-link">論壇</a></li>
					<li class="nav-item"><a href="<%=request.getContextPath()%>/generaluser/guserListOne.jsp"
						class="nav-link"><img src="<%=request.getContextPath()%>/generaluser/DBGifReader?gUserID=${generalUser.gUserID}"
						alt="SVG"  class="rounded-circle" /> 會員中心</a></li>
				</ul>

			</header>
		</div>
	</header>
<!----------------------------------------------- aside 區 ------------------------------------------------------->
	<div class="main_content">
		<aside class="aside">
			<div class="parent_container">
				<h2 class="h6 pt-4 pb-3 mb-4 border-bottom" id="ah6">會員中心</h2>
				<nav class="small" id="toc">
					<ul class="list-unstyled">
						<li class="my-2"><a class="asidearea"
							href="<%=request.getContextPath()%>/generaluser/guserListOne.jsp">會員資料</a>
						</li>
						<li>&nbsp;</li>
						<li class="my-2"><a class="asidearea"
							href="<%=request.getContextPath()%>/reserveorder/listOneOrder.jsp">球館預約紀錄</a>
						</li>
						<li>&nbsp;</li>
						<li class="my-2"><a class="asidearea" href="">聯絡我們</a></li>
						<li>&nbsp;</li>
						<li class="my-2"><a class="asidearea" href="">聯絡我們紀錄</a></li>
						<li>&nbsp;</li>
						<li class="my-2">
						  <form method="POST" action="<%=request.getContextPath()%>/logoutfg.do"> 
	        				<input type="hidden" name="action" value="logout">
	        				<button class="asidearea">登出</button>
       					  </form> 
       					</li>
					</ul>
				</nav>
			</div>
		</aside>
<!----------------------------------------------- main 區 ------------------------------------------------------->
		<main class="main">
			<h2 class="h6 pt-4 pb-3 mb-4 border-bottom">聯絡我們紀錄</h2>
			
			<c:if test="${not empty errorMsgs}">
				<font style="color:red">請修正以下錯誤:</font>
				<ul>
					<c:forEach var="message" items="${errorMsgs}">
						<li style="color:red">${message}</li>
					</c:forEach>
				</ul>
			</c:if>
			
			<div class="container" id="datatable">
				<table id="table_id"
					class="display hover cell-border stripe responsive nowrap">
					<thead>
						<tr>
                            <th>表單編號</th>
                            <th>企業會員編號</th>
                            <th>主旨</th>
                            <th>內文</th>
                            <th>圖片</th>
                            <th>發文時間</th>
                            <th>狀態</th>
                            <th>類型</th>
                            <th id="th">查看</th>
                        </tr>
					</thead>

					<tbody>
					<c:forEach var="contactUs" items="${list}"	>
						<tr>
							<td>${contactUs.formID}</td>
							<td>${contactUs.ownerUser.oUserID}</td>
							<td>${contactUs.formPurpose}</td>
							<td>${contactUs.formContent}</td>
							<td>${contactUs.formPic}</td> 
							<td>${contactUs.formTime}</td>
							<td>${contactUs.formStatus}</td>
							<td>${contactUs.formType}</td>
							<td>
								<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/contactUs/contactUs.do">
									<input type="hidden" name="action"	value="getOne_For_Display">
									<input type="hidden" name="formID" value="${contactUs.formID}">
									<input type="submit" id="cancel" value="查看" >
								</FORM>
							</td>
						</tr>
						</c:forEach>
					</tbody>

				</table>
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
<script>
		$(document)
				.ready(
						function() {
							$('#table_id')
									.DataTable(
											{
												"language" : {
													"processing" : "處理中...",
													"loadingRecords" : "載入中...",
													"paginate" : {
														"first" : "第一頁",
														"previous" : "上一頁",
														"next" : "下一頁",
														"last" : "最後一頁"
													},
													"emptyTable" : "目前沒有資料",
													"datetime" : {
														"previous" : "上一頁",
														"next" : "下一頁",
														"hours" : "時",
														"minutes" : "分",
														"seconds" : "秒",
														"amPm" : [ "上午", "下午" ],
														"unknown" : "未知",
														"weekdays" : [ "週日",
																"週一", "週二",
																"週三", "週四",
																"週五", "週六" ],
														"months" : [ "一月",
																"二月", "三月",
																"四月", "五月",
																"六月", "七月",
																"八月", "九月",
																"十月", "十一月",
																"十二月" ]
													},
													"searchBuilder" : {
														"add" : "新增條件",
														"condition" : "條件",
														"deleteTitle" : "刪除過濾條件",
														"button" : {
															"_" : "複合查詢 (%d)",
															"0" : "複合查詢"
														},
														"clearAll" : "清空",
														"conditions" : {
															"array" : {
																"contains" : "含有",
																"equals" : "等於",
																"empty" : "空值",
																"not" : "不等於",
																"notEmpty" : "非空值",
																"without" : "不含"
															},
															"date" : {
																"after" : "大於",
																"before" : "小於",
																"between" : "在其中",
																"empty" : "為空",
																"equals" : "等於",
																"not" : "不為",
																"notBetween" : "不在其中",
																"notEmpty" : "不為空"
															},
															"number" : {
																"between" : "在其中",
																"empty" : "為空",
																"equals" : "等於",
																"gt" : "大於",
																"gte" : "大於等於",
																"lt" : "小於",
																"lte" : "小於等於",
																"not" : "不為",
																"notBetween" : "不在其中",
																"notEmpty" : "不為空"
															},
															"string" : {
																"contains" : "含有",
																"empty" : "為空",
																"endsWith" : "字尾為",
																"equals" : "等於",
																"not" : "不為",
																"notEmpty" : "不為空",
																"startsWith" : "字首為",
																"notContains" : "不含",
																"notStartsWith" : "開頭不是",
																"notEndsWith" : "結尾不是"
															}
														},
														"data" : "欄位",
														"leftTitle" : "群組條件",
														"logicAnd" : "且",
														"logicOr" : "或",
														"rightTitle" : "取消群組",
														"title" : {
															"_" : "複合查詢 (%d)",
															"0" : "複合查詢"
														},
														"value" : "內容"
													},
													"editor" : {
														"close" : "關閉",
														"create" : {
															"button" : "新增",
															"title" : "新增資料",
															"submit" : "送出新增"
														},
														"remove" : {
															"button" : "刪除",
															"title" : "刪除資料",
															"submit" : "送出刪除",
															"confirm" : {
																"_" : "您確定要刪除您所選取的 %d 筆資料嗎？",
																"1" : "您確定要刪除您所選取的 1 筆資料嗎？"
															}
														},
														"error" : {
															"system" : "系統發生錯誤(更多資訊)"
														},
														"edit" : {
															"button" : "修改",
															"title" : "修改資料",
															"submit" : "送出修改"
														},
														"multi" : {
															"title" : "多重值",
															"info" : "您所選擇的多筆資料中，此欄位包含了不同的值。若您想要將它們都改為同一個值，可以在此輸入，要不然它們會保留各自原本的值。",
															"restore" : "復原",
															"noMulti" : "此輸入欄需單獨輸入，不容許多筆資料一起修改"
														}
													},
													"autoFill" : {
														"cancel" : "取消"
													},
													"buttons" : {
														"copySuccess" : {
															"_" : "複製了 %d 筆資料",
															"1" : "複製了 1 筆資料"
														},
														"copyTitle" : "已經複製到剪貼簿",
														"excel" : "Excel",
														"pdf" : "PDF",
														"print" : "列印",
														"copy" : "複製",
														"colvis" : "欄位顯示",
														"colvisRestore" : "重置欄位顯示",
														"csv" : "CSV",
														"pageLength" : {
															"-1" : "顯示全部",
															"_" : "顯示 %d 筆"
														},
														"createState" : "建立狀態",
														"removeAllStates" : "移除所有狀態",
														"removeState" : "移除",
														"renameState" : "重新命名",
														"savedStates" : "儲存狀態",
														"stateRestore" : "狀態 %d",
														"updateState" : "更新"
													},
													"searchPanes" : {
														"collapse" : {
															"_" : "搜尋面版 (%d)",
															"0" : "搜尋面版"
														},
														"emptyPanes" : "沒搜尋面版",
														"loadMessage" : "載入搜尋面版中...",
														"clearMessage" : "清空",
														"count" : "{total}",
														"countFiltered" : "{shown} ({total})",
														"title" : "過濾條件 - %d",
														"showMessage" : "顯示全部",
														"collapseMessage" : "摺疊全部"
													},
													"stateRestore" : {
														"emptyError" : "名稱不能空白。",
														"creationModal" : {
															"button" : "建立",
															"columns" : {
																"search" : "欄位搜尋",
																"visible" : "欄位顯示"
															},
															"name" : "名稱：",
															"order" : "排序",
															"paging" : "分頁",
															"scroller" : "卷軸位置",
															"search" : "搜尋",
															"searchBuilder" : "複合查詢",
															"select" : "選擇",
															"title" : "建立新狀態",
															"toggleLabel" : "包含："
														},
														"duplicateError" : "此狀態名稱已經存在。",
														"emptyStates" : "名稱不可空白。",
														"removeConfirm" : "確定要移除 %s 嗎？",
														"removeError" : "移除狀態失敗。",
														"removeJoiner" : "和",
														"removeSubmit" : "移除",
														"removeTitle" : "移除狀態",
														"renameButton" : "重新命名",
														"renameLabel" : "%s 的新名稱：",
														"renameTitle" : "重新命名狀態"
													},
													"select" : {
														"columns" : {
															"_" : "選擇了 %d 欄資料",
															"1" : "選擇了 1 欄資料"
														},
														"rows" : {
															"1" : "選擇了 1 筆資料",
															"_" : "選擇了 %d 筆資料"
														},
														"cells" : {
															"1" : "選擇了 1 格資料",
															"_" : "選擇了 %d 格資料"
														}
													},
													"zeroRecords" : "沒有符合的資料",
													"aria" : {
														"sortAscending" : "：升冪排列",
														"sortDescending" : "：降冪排列"
													},
													"info" : "顯示第 _START_ 至 _END_ 筆結果，共 _TOTAL_ 筆",
													"infoEmpty" : "顯示第 0 至 0 筆結果，共 0 筆",
													"infoFiltered" : "(從 _MAX_ 筆結果中過濾)",
													"infoThousands" : ",",
													"lengthMenu" : "顯示 _MENU_ 筆結果",
													"search" : "搜尋：",
													"searchPlaceholder" : "請輸入關鍵字",
													"thousands" : ","
												},

											});
						});
	</script>
</body>
</html>