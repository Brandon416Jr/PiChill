<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.pichill.contactus.model.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.pichill.contactus.service.ContactUsServiceImpl"%>
<%@ page import="com.pichill.contactus.entity.ContactUs"%>
<%
//見com.emp.controller.EmpServlet.java第238行存入req的empVO物件 (此為輸入格式有錯誤時的empVO物件)
ContactUs contactUs = (ContactUs) request.getAttribute("contactUs");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

</head>
<title>PiChill 聯絡我們</title>
<link rel="stylesheet" href="../generalUser/CSS/bootstrap.min.css">
<!--<link rel="stylesheet" href="./CSS/index3.css">
<link rel="stylesheet" href="./CSS/table.css"> -->
<link rel="stylesheet" href="./style.css">
<link rel="stylesheet" href="./index3.css">
<link rel="stylesheet" href="./table.css">
<link rel="shortcut icon" href="../image/smallLogo.png">
<!----------------匯入jquery ------------------------>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous">
</script>
</head>
<body>
	<!----------------------------------------------- header 區 ------------------------------------------------------->
	<header class="header">
		<div class="container">
			<header class="d-flex flex-wrap justify-content-center py-1">
				<a href="/"
					class="d-flex align-items-center mb-1 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
					<img src="../image/headerlogo.svg" alt="SVG" />
				</a>


				<ul class="nav nav-pills">
					<li class="nav-item"><a href="#" class="nav-link">首頁</a></li>
					<li class="nav-item"><a href="#" class="nav-link">通知</a></li>
					<li class="nav-item"><a href="#" class="nav-link">預約管理系統</a></li>
					<li class="nav-item"><a href="#" class="nav-link">論壇</a></li>
					<li class="nav-item"><a href="#" class="nav-link">聯絡我們</a></li>
					<li class="nav-item"><a href="#" class="nav-link">會員中心</a></li>
					<li class="nav-item"><a href="#" class="nav-link"><img
							src="../image/face.svg" alt="SVG" /> 會員中心</a></li>
				</ul>

				<!-- <label for="burger">☰</label>
              <input type="hidden" id="burger"> -->
		</div>
	</header>
	</header>

	<!----------------------------------------------- aside 區 ------------------------------------------------------->
	<div class="main_content">
		<aside class="aside">
			<div class="parent_container">
				<h2 class="h6 pt-4 pb-3 mb-4 border-bottom">聯絡我們</h2>
				<nav class="small" id="toc">
					<ul class="list-unstyled">
						<li class="my-2">
							<button
								class="btn d-inline-flex align-items-center collapsed border-0"
								data-bs-toggle="collapse" aria-expanded="false"
								data-bs-target="#contents-collapse"
								aria-controls="contents-collapse">聯絡我們</button>
						</li>
						<!-- <li class="my-2">
							<button
								class="btn d-inline-flex align-items-center collapsed border-0"
								data-bs-toggle="collapse" aria-expanded="false"
								data-bs-target="#forms-collapse" aria-controls="forms-collapse">通知信件</button>
						</li> -->

					</ul>
				</nav>
			</div>
		</aside>

		<!----------------------------------------------- main 區 ------------------------------------------------------->
		<main class="main">
			<br>
			<!--<br>
            <br> -->
			<h2>聯絡我們</h2>
			<br>
			<%-- <c:if test="${not empty errorMsgs}">
				<font style="color: red">請修正以下錯誤:</font>
				<ul>
					<c:forEach var="message" items="${errorMsgs}">
						<li style="color: red">${message}</li>
					</c:forEach> 
				</ul>
			</c:if>--%>
			<jsp:useBean id="contactus" scope="page"
				class="com.pichill.contactus.service.ContactUsServiceImpl" />
			<form id="contactForm" enctype="multipart/form-data" method="post"
				action="contactus.do">

				<div>
					<label for="formType">問題類別</label><br>
					<!-- <input type="radio"
						id="announcement" name="questionType" value="公告" required>
					<label for="announcement">公告</label> -->
					<input type="radio" id="other" name="questionType" value="其他"
						checked required> <label for="other">一般問題</label>
				</div>
				<br>

				<div>
					<label for="subject">主旨</label> <input type="text" id="subject"
						name="subject" required>
				</div>
				<br>

				<div>
					<label for="imageUpload">上傳圖片</label> <input type="file"
						id="imageUpload" name="imageUpload[]" accept="image/*" multiple>
				</div>

				<div id="imagePreviews"></div>

				<br> <br>

				<div>
					<label for="problemDescription">請大致敘述問題內容</label><br>
					<textarea id="problemDescription" name="problemDescription"
						rows="6" style="height: 300px; width: 500px" required></textarea>
				</div>

			</form>




			<!-------- 送出按鈕  ------->
			<input type="button" value="getOne_For_Display" name="查詢"
				style="width: 150px; height: 44px;"> <input type="submit"
				value="取消" name="按鈕名稱" style="width: 150px; height: 44px;">

		</main>
	</div>

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
							$('#contactForm').button(function(e) {
								e.preventDefault();
								// 在此處處理表單提交的程式碼，您可以使用 AJAX 或其他方式進行後續處理
								// 例如，您可以使用 jQuery 的 $.ajax() 方法來發送表單數據到伺服器
								// 獲取表單數據：$(this).serialize()
								// 獲取圖片數據：使用 FormData

								// 示範：
								/* 			var formData = new FormData(this);
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
											}); */
							});
						});
	</script>

	<!----------------------------------------------- footer 區 ------------------------------------------------------->
	<footer class="footer">

		<div class="container">
			<header class="d-flex flex-wrap justify-content-center py-3">
				<a href="/"
					class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
					<img src="../image/footerlogo.svg" alt="SVG" />
				</a>

				<ul class="nav nav-pills">
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

	<script src="./JS/bootstrap.min.js"></script>
</body>

</body>
</html>