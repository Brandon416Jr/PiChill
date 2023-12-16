<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.pichill.generaluser.entity.GeneralUser"%>

<%
//見com.emp.controller.EmpServlet.java第238行存入req的empVO物件 (此為輸入格式有錯誤時的empVO物件)
GeneralUser generalUser = (GeneralUser) request.getAttribute("generalUser");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>一般會員註冊</title>
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

div.register {
	border: 1.5px solid red;
	height: auto;
}

.login-form {
	max-height: 360px;
	overflow-y: auto;
}

.city-select, .area-select {
	display: block;
}

.area-select {
	margin-top: 10px;
	margin-bottom: 10px;
	padding-top: 10px;
	border-top: 1px solid #ddd;
}

div.row div.col-1 input.btn {
	/* 	border: 1px solid red; */
	width: 150%;
	height: 40px;
	margin-bottom: 1px;
}

div.register-link {
	/* border: 1px solid green; */
	margin-top: 0;
}

div.pwd-see {
	display: flex;
	align-items: center;
}

label.pwd-see2 {
	margin-left: 5px;
}

input.btn {
/* border: 1px solid red; */
background-color: #207DCA;
width: 100%;
color: white;
}

input.btn:hover {
  background-color: orange;
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
								src="<%=request.getContextPath()%>/backEnd-Website/pic/g_register.png"
								alt="CoolAdmin">
							</a>
						</div>
						<div class="login-form">
							<form
								action="${pageContext.request.contextPath }/generaluser/generaluserf.do"
								method="post" enctype="multipart/form-data">
								<div class="form-group">
									<label for="gUsername">帳號</label><font color=red>${errorMsgs.gUsername}</font>
									<input class="au-input au-input--full" type="text"
										name="gUsername" placeholder="請輸入帳號" id="gUsername"
										value="<%=(generalUser == null) ? "" : generalUser.getgUsername()%>">
								</div>
								<div class="form-group">
									<label>信箱</label><font color=red>${errorMsgs.gEmail}</font> <input
										class="au-input au-input--full" type="text" name="gEmail"
										placeholder="請輸入信箱"
										value="<%=(generalUser == null) ? "" : generalUser.getgEmail()%>">
								</div>
								<div class="form-group">
									<label>密碼</label><font color=red>${errorMsgs.gPassword}</font>
									<input class="au-input au-input--full" type="password"
										id="password" name="gPassword" placeholder="請輸入密碼"
										value="<%=(generalUser == null) ? "" : generalUser.getgPassword()%>">
									<div class="pwd-see">
										<input type="checkbox" id="togglePwd"> <label
											class="pwd-see2" for="togglePwd">顯示密碼</label>
									</div>
								</div>
								<div class="form-group">
									<label>再次確認密碼</label><font color=red>${errorMsgs.gPaaword2}</font>
									<input class="au-input au-input--full" type="password"
										id="password2" name="gPassword2" placeholder="請再次輸入密碼">
									<div class="pwd-see">
										<input type="checkbox" id="togglePwd2"> <label
											class="pwd-see2" for="togglePwd2">顯示密碼</label>
									</div>
								</div>
								<div class="form-group">
									<label>姓名</label><font color=red>${errorMsgs.gName}</font> <input
										class="au-input au-input--full" type="text" name="gName"
										placeholder="請輸入姓名"
										value="<%=(generalUser == null) ? "" : generalUser.getgName()%>">
								</div>
								<div class="form-group">
									<label>匿稱ID</label><font color=red>${errorMsgs.nicknameID}</font>
									<input class="au-input au-input--full" type="text"
										name="nicknameID" placeholder="請輸入暱稱ID"
										value="<%=(generalUser == null) ? "" : generalUser.getNicknameID()%>">
								</div>
								<div class="form-group">
									<label>電話</label><font color=red>${errorMsgs.gTelephone}</font>
									<input class="au-input au-input--full" type="text"
										name="gTelephone" placeholder="請輸入電話"
										value="<%=(generalUser == null) ? "" : generalUser.getgTelephone()%>">
								</div>
								<div class="form-group">
									<label>性別</label><font color=red>${errorMsgs.gGender}</font> <select
										class="au-input au-input--full" name="gGender">
																				<option value="3">請選擇性別</option>
										<option value="0">男</option>
										<option value="1">女</option>
									</select>
								</div>
								<div class="form-group">
									<label>生日</label><font color=red>${errorMsgs.gBirth}</font> <input
										class="au-input au-input--full" placeholder="請輸入生日"
										type="date" name="gBirth"
										value="<%=(generalUser == null) ? "" : generalUser.getgBirth()%>">

								</div>
								<div class=" form-group">

									<label for="text-input">聯絡地址</label><font color=red>${errorMsgs.gAddress}</font>

									<div class="city-select">
										<select class="au-input au-input--full" id="city" name="city"
											required>
											<option value="">請選擇縣市</option>
										</select>
									</div>
									<div class="area-select">
										<select class="au-input au-input--full" id="area" name="area"
											required>
											<option value="">請選擇鄉鎮市區</option>
										</select>
									</div>
									<input type="text" id="text-input" name="gAddress"
										placeholder="請輸入聯絡地址" class="form-control" />
								</div>
								<div class="form-group">
									<label>身分證</label><font color=red>${errorMsgs.gIDNum}</font> <input
										class="au-input au-input--full" type="text" name="gIDNum"
										placeholder="請輸入身分證"
										value="<%=(generalUser == null) ? "" : generalUser.getgIDNum()%>">
								</div>
								<div class="form-group">

									<label>註冊日期</label> <input class="au-input au-input--full"
										type="date" name="gRegistDate"
										value="<%=(generalUser == null) ? "" : generalUser.getgRegistDate()%>">

								</div>
								<div class="form-group">
									<label for="file-input">上傳大頭貼</label><font color=red>${errorMsgs.gProfilePic}</font>
									<input type="file" name="gProfilePic" onclick="previewImage()"
										multiple="multiple" onchange="hideContent('upFiles.errors');"
										class="form-control-file"><img id="imagePreview"
										src="#" alt="Preview" />
								</div>
								<div class="login-checkbox">
									<label> <input type="checkbox" name="agree">是否同意使用者條款
									</label><font color=red>${errorMsgs.agree}</font>
								</div>
								<div class="row form-group">
									<div class="col-1 col-md-8">
										<input class="btn" type="hidden" name="action" value="insert"><input
											type="submit" class="btn btn-primary btn-sm" value="註冊">
										<i class="fa fa-dot-circle-o"></i>
									</div>
								</div>
							</form>
							<div class="register-link">
								<p>
									已經有帳號了嗎? <a
										href="${pageContext.request.contextPath }/frontstage/generalUserFront/gUserLogin.jsp">登入</a>
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
	<%
	java.sql.Date gRegistDate = null;
	try {
		gRegistDate = java.sql.Date.valueOf(request.getParameter("gRegistDate").trim());
	} catch (Exception e) {
		gRegistDate = new java.sql.Date(System.currentTimeMillis());
	}
	%>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script>
// 	$(document).ready(function() {

		
// 		var timeout;
// 		$('#gUsername').on('input', function() {
// 		    clearTimeout(timeout);
// 		    timeout = setTimeout(function() {
// 		        var gUsername = $('#gUsername').val();
// 		        var gUsernameReg = "^[a-zA-Z0-9]{8,12}$";
// 		        if (gUsername !== "") {
// 		        	if (!gUsername.trim().match(gUsernameReg)) {
// 		                $("#accountExistsMessage").text("不符合帳號格式");
// 		                $("#accountExistsMessage").css("color", "red");
// 		            } else {
// 				            $.ajax({
<%-- 				                url: "<%=request.getContextPath()%>/generaluser/generaluserf.do?action=checkAccount", --%>
// 				                method: "POST",
// 				                data: { "gUsername": gUsername },
// 				                success: function(data) {
// 				                    console.log("ttt");
// 				                    if (data.exists) {
// 				                        $("#accountExistsMessage").text("此帳號已存在");
// 				                        $("#accountExistsMessage").css("color", "red");
// 				                    } else {
// 				                        $("#accountExistsMessage").text("此帳號可使用");
// 				                        $("#accountExistsMessage").css("color", "blue");
// 				                    }
// 				                },
// 				                error: function() {
// 				                    $("#accountExistsMessage").text("檢查帳號有錯誤");
// 				                }
// 				            });
// 		              }      
// 		        } else {
// 		            $("#accountExistsMessage").text('');
// 		        }
// 		    }, 500); // 500毫秒延遲
// 		});
		
// 		var memberemailInput = $("#memberemail");
// 	    var errorMsgMemberEmail = $("font[color='red']");

// 	     // 監聽輸入框的輸入事件
// 	     gUsernameInput.on('input', function() {
// 	        // 獲取輸入框的值
// 	        var inputValue = gUsernameInput.val();

// 	        // 如果輸入框中有文字，清除錯誤訊息
// 	        if (inputValue.trim() !== "") {
// 	            errorMsggUsername.text('');
// 	        }
// 	    });
	</script>
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
		var registerDate = document.getElementsByName("registerDate")[0];

		// 構建當前日期,格式為 yyyy-mm-dd
		var today = new Date().toISOString().slice(0, 10);

		// 為註冊日期欄位賦值  
		registerDate.value = today;
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