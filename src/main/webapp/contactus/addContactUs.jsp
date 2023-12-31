<%@page import="com.pichill.contactus.service.ContactUsServiceImpl"%>
<%@page import="com.pichill.contactus.service.ContactUsService"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.pichill.contactus.entity.ContactUs"%>
<%@ page import="com.pichill.contactus.*"%>
<%@ page import="com.pichill.owneruser.entity.*"%>
<%@ page import="java.util.*"%>

<%
//見com.emp.controller.EmpServlet.java第238行存入req的empVO物件 (此為輸入格式有錯誤時的empVO物件)
ContactUs contactUs = (ContactUs) request.getAttribute("contactUs");
OwnerUser ownerUser = (OwnerUser) session.getAttribute("ownerUser");
System.out.println("ownerUser is " + ownerUser);
Integer oUserID = ownerUser.getoUserID();
System.out.println("oUser is " + oUserID);
ContactUsService contactUsSvc = new ContactUsServiceImpl();
List<ContactUs> list = contactUsSvc.getByOID(ownerUser.getoUserID());
pageContext.setAttribute("list", list);
pageContext.setAttribute("oUserID", oUserID);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>generalUser</title>
<!----------------匯入jquery ------------------------>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/generaluser/CSS/bootstrap.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/generaluser/css2/css.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/generaluser/css2/index3.css">

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
					<li class="nav-item"><a href="#" class="nav-link">首頁</a></li>
					<li class="nav-item"><a href="#" class="nav-link">通知</a></li>
					<li class="nav-item"><a href="#" class="nav-link">論壇</a></li>
					<li class="nav-item"><a href="#" class="nav-link">聯絡我們</a></li>
					<li class="nav-item"><a href="#" class="nav-link"><img
							src="/pic/face.svg" alt="SVG" /> 會員中心</a></li>
				</ul>
			</header>
		</div>
	</header>

	<!----------------------------------------------- aside 區 ------------------------------------------------------->
	<div class="main_content">
		<aside class="aside">
			<div class="parent_container">
				<h2 class="h6 pt-4 pb-3 mb-4 border-bottom" id="ah6">聯絡我們</h2>
				<nav class="small" id="toc">
					<ul class="list-unstyled">
						<li class="my-2"><a class="asidearea" href="">聯絡我們</a></li>
						<li class="my-2"><a class="asidearea" href="">查看聯絡我們紀錄</a></li>
					</ul>
				</nav>
			</div>
		</aside>

		<!----------------------------------------------- main 區 ------------------------------------------------------->
		<main class="main">
			<br>
			<h2 class="h6 pt-4 pb-3 mb-4 border-bottom" id="h2">CONTACT US</h2>
			<%-- 錯誤表列 --%>
			<c:if test="${not empty errorMsgs}">
				<font style="color: red">請修正以下錯誤:</font>
				<ul>
					<c:forEach var="message" items="${errorMsgs}">
						<li style="color: red">${message}</li>
					</c:forEach>
				</ul>
			</c:if>
			<br>

			<form method="post"
				action="<%=request.getContextPath()%>/contactUs.do" name="action"
				enctype="multipart/form-data">

				<div>
					<label for="formType" class="questiontype">問題類別 : </label><br>
					<input type="radio" id="announcement" name="questionType"
						value="公告" required> <label for="announcement"
						class="announcement">公告</label>&nbsp&nbsp&nbsp <input type="radio"
						id="other" name="questionType" value="其他" checked required>
					<label for="other" class="question">一般問題</label>
				</div>
				<br>

				<div>
					<label for="subject" class="title">主旨 : </label> <input type="text"
						id="subject" name="getformPurpose"
						value="<%=(contactUs == null) ? "廁所的燈壞了" : contactUs.getformPurpose()%>"
						size="45" required>
				</div>
				<br>

				<div>
					<label for="imageUpload" class="imageUpload">上傳圖片 : </label><br>
					<input type="file" id="imageUpload" name="imageUpload[]"
						accept="image/*" multiple>
				</div>

				<div id="imagePreviews"></div>

				<br> <br>

				<div>
					<label for="problemDescription" id="content">請大致敘述問題內容 : </label><br>
					<textarea id="problemDescription" name="getformContent">
                    <%=(contactUs == null) ? "教室裡有人嗎？" : contactUs.getformContent()%></textarea>
				</div>

				<!-------- 送出按鈕  ------->
				<input type="hidden" name="action" value="insert"> <input
					type="submit" name="action" value="送出"
					style="width: 150px; height: 44px; border: 0; background-color: #FF9F1B; color: #fff; border-radius: 8px; cursor: pointer; margin-top: 50px; margin-bottom: 130px;">

			</form>

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
	<script>
		$(document)
				.ready(
						function() {
							// 預覽上傳的圖片
							$('#imageUpload')
									.on(
											'change',
											function(e) {
												$('#imagePreviews').empty();
												var files = e.target.files;
												for (var i = 0; i < files.length; i++) {
													var reader = new FileReader();
													reader.onload = function(
															event) {
														$('#imagePreviews')
																.append(
																		'<div class="image-preview"><img src="' + event.target.result + '"><button class="delete-image">刪除</button></div>');
													}
													reader
															.readAsDataURL(files[i]);
												}
											});

							// 刪除圖片預覽
							$(document).on(
									'click',
									'.delete-image',
									function() {
										$(this).parent('.image-preview')
												.remove();
									});

							// 表單提交
							$('#contactForm').button(
									function(e) {
										e.preventDefault();
										// 在此處處理表單提交的程式碼，您可以使用 AJAX 或其他方式進行後續處理
										// 例如，您可以使用 jQuery 的 $.ajax() 方法來發送表單數據到伺服器
										// 獲取表單數據：$(this).serialize()
										// 獲取圖片數據：使用 FormData

										// 示範：
										var formData = new FormData(this);
										$.ajax({
											url : 'your_backend_endpoint', // 更改為您的後端端點
											type : 'POST',
											data : formData,
											processData : false,
											contentType : false,
											success : function(response) {
												console.log('表單已成功提交！伺服器回應：',
														response);
												// 在此處添加成功提交後的處理方式，例如顯示成功訊息或重置表單
											},
											error : function(error) {
												console.error('表單提交失敗！錯誤訊息：',
														error);
												// 在此處添加失敗提交後的處理方式，例如顯示錯誤訊息或提供重新嘗試
											}
										});
									});
						});
	</script>
</body>
</html>