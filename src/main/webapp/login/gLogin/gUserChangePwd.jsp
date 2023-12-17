<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>一般會員變更密碼</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/backEnd-Website/vendor/bootstrap-4.1/bootstrap.min.css" />
<style type="text/css">
button.au-btn {
	/* border: 2px solid red; */
	background-color: #207DCA;
	margin-top: 10px;
}

.login-form {
	max-height: 360px;
	overflow-y: auto;
}

input.btn {
/* border: 1px solid red;  */
background-color: #207DCA;
width: 100%;
color: white;
}

input.btn:hover {
  background-color: orange;
}


div.input {
/* 	 border: 1px solid blue;  */
	margin-y: 10px;
}
</style>
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
<link href="<%=request.getContextPath()%>/backEnd-Website/css/login.css"
	rel="stylesheet" media="all" />
</head>
<body class="animsition">
	<div class="all">
		<!-- <img src="./pic/m_login.png" height="1000" width="1000"> -->
	</div>
	<div class="page-wrapper">
		<div class="page-content--bge5">
			<div class="container">
				<div class="login-wrap">
					<div class="login-content" id="ms-form">
						<div class="login-logo">
							<a href="#"> <img
								src="<%=request.getContextPath()%>/backEnd-Website/pic/forgot_pwd.png"
								alt="CoolAdmin" />
							</a>
						</div>
						<div class="login-form">

							<form id="changePassword" method="post"
								action="<%=request.getContextPath()%>/guser/forgotpwd">
								<div class="input">
									<label class="fs-title">更改密碼</label> <input
										class="au-input au-input--full" type="password"
										name="gPassword" value="${param.gPassword}"
										id="inputPassword" placeholder="請輸入新密碼"/>
									<div class="pwd-see">
										<input type="checkbox" id="togglePwd"> <label
											class="pwd-see2" for="togglePwd">顯示密碼</label>
									</div>
									<font id="passwordError" color=red>${errorMsgs.gPassword}</font>
									<div class="form__field">
										<label class="fs-title">再次輸入密碼</label> <input
											class="au-input au-input--full" type="password"
											name="confirmPassword" class="form__input" pattern=".{8,}"
											required id=password2 placeholder="請再次輸入新密碼"
											autocomplete="off" />
										<div class="pwd-see">
											<input type="checkbox" id="togglePwd2"> <label
												class="pwd-see2" for="togglePwd2">顯示密碼</label>
										</div>
										<font color=red>${errorMsgs.confirmPassword}</font>
									
<!-- 									<div class="input"> -->
										<input type="hidden" name="gEmail"
											value="${param.gEmail}"> <input type="hidden"
											name="action" value="changePassword"> <input
											class="btn" type="submit" name="next"
											class="next-action-button" value="送出" />
<!-- 											</div> -->
									</div>
								</div>
							</form>
							<!-- 					<form> -->
							<!--                 <button class="au-btn au-btn--block au-btn--green m-b-20" type="submit" action="" href="index.html"> -->
							<!--                   獲取驗證碼 -->
							<!--                 </button> -->
							<!--                 <button class="au-btn au-btn--block au-btn--green m-b-20" type="submit" action="" href="index.html"> -->
							<!--                   登入 -->
							<!--                 </button> -->
							<!--               </form> -->
						</div>
					</div>
					<div class="left-image">
						<img
							src="<%=request.getContextPath()%>/backEnd-Website/pic/Group 460.png" />
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
		const password = document.getElementById('inputPassword');
		const toggle = document.getElementById('togglePwd');

		toggle.addEventListener('change', function() {
			if (this.checked) {
				password.type = 'text';
			} else {
				password.type = 'password';
			}
		});
		const password2 = document.getElementById('password2');
		const toggle2 = document.getElementById('togglePwd2');

		toggle2.addEventListener('change', function() {
			if (this.checked) {
				password2.type = 'text';
			} else {
				password2.type = 'password';
			}
		});
	</script>
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