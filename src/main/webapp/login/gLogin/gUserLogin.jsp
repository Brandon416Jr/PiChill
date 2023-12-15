<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>一般會員登入</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/backEnd-Website/vendor/bootstrap-4.1/bootstrap.min.css" />
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
<style type="text/css">
button.au-btn {
	/* border: 2px solid red; */
	background-color: #207DCA;
	/* margin: 5px; */
}

div.pwd-see {
	display: flex;
	align-items: center;
}

label.pwd-see2 {
	margin-left: 5px;
}

.login-form {
  height: 360px;
  overflow: auto;
}
</style>
</head>
<body class="animsition">
	<div class="all">
		<!-- <img src="./pic/m_login.png" height="1000" width="1000"> -->
	</div>
	<div class="page-wrapper">
		<div class="page-content--bge5">
			<div class="container">
				<div class="login-wrap">
					<div class="login-content">
						<div class="login-logo">
							<a href="#"> <img
								src="<%=request.getContextPath()%>/backEnd-Website/pic/g_login.png"
								alt="CoolAdmin" />
							</a>
						</div>
						<div class="login-form">
							<form action="<%=request.getContextPath()%>/gloginhandler" method="post" id="loginForm">
								<div class="form-group">
									<label>帳號</label><font color=red>${requestScope.errorMsgs.gUsername}</font>
									<input class="au-input au-input--full"
										type="text" name="gUsername" placeholder="請輸入帳號" value="${param.gUsername}"/>
								</div>
								<div class="form-group">
									<label>密碼</label><font color=red>${requestScope.errorMsgs.gPassword}</font>
									<input class="au-input au-input--full"
										type="password" id="password" name="gPassword"
										placeholder="請輸入密碼" />
									<div class="pwd-see">
										<input type="checkbox" id="togglePwd"> <label
											class="pwd-see2" for="togglePwd">顯示密碼</label>
									</div>
								</div>
								<div class="form-group">
									<label>驗證碼</label> <input class="au-input au-input--full"
										type="text" name="checkCode" placeholder="請輸入驗證碼" /> <img
										id="yzm_img" src="${pageContext.request.contextPath}/valistr"
										style="cursor: pointer" onclick="changeYZM(this)" /> <span
										id="valistr_msg"></span>
								</div>
								<div class="login-checkbox">
									<label> <input type="checkbox" name="remember" />記住我的帳號
									</label> <label> <a href="#">忘記密碼?</a>
									</label>
								</div>
								<button class="au-btn au-btn--block au-btn--green m-b-20"
									type="submit">登入</button>
							</form>
							<div class="register-link">
								<p>
									你尚未有帳號? <a
										href="${pageContext.request.contextPath }/login/gLogin/gUserRegist.jsp">我要註冊</a>
								</p>
							</div>
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
		/**
		 * 校驗欄位是否為空
		 */
		function checkNull(name, msg) {
			setMsg(name, "")
			var v = document.getElementsByName(name)[0].value;
			if (v == "") {
				setMsg(name, msg)
				return false;
			}
			return true;
		}
		/**
		 * 為輸入項設定提示訊息
		 */
		function setMsg(name, msg) {
			var span = document.getElementById(name + "_msg");
			span.innerHTML = "<font color='red'>" + msg + "</font>";
		}
		/**
		 * 點選更換驗證碼
		 */
		function changeYZM(imgObj) {
			imgObj.src = "${pageContext.request.contextPath}/valistr?time="
					+ new Date().getTime();
		}
	</script>
	<script>
		$('form').submit(function(e) {
			e.preventDefault();

			// 驗證代碼
		})

		var code = $('input[name=checkCode]').val();

		$.ajax({
			url : '/checkCode',
			data : {
				code : code
			},
			 success: function (res) {
		            if (res.success) {
		                // Validation passed, submit the form
		                $('#loginForm').submit();
		            } else {
		                // Validation failed, show an error message
		                alert('驗證碼錯誤!');
		            }
		        }
		});
	</script>
	<script>
		history.pushState(null, null, document.URL);
		window.addEventListener('popstate', function() {
			history.pushState(null, null, document.URL);
		});

		function ajaxLogoutCallback() {
			// 登出操作
			history.pushState(null, null, document.URL);
			window.addEventListener('popstate', function() {
				history.pushState(null, null, document.URL);
			});
		}
	</script>
	<script>
		const password = document.getElementById('password');
		const toggle = document.getElementById('togglePwd');

		toggle.addEventListener('change', function() {
			if (this.checked) {
				password.type = 'text';
			} else {
				password.type = 'password';
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