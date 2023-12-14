<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.pichill.owneruser.entity.OwnerUser"%>

<%
//見com.emp.controller.EmpServlet.java第238行存入req的empVO物件 (此為輸入格式有錯誤時的empVO物件)
OwnerUser ownerUser = (OwnerUser) request.getAttribute("ownerUser");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>企業會員註冊</title>
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

div.pwd-see {
	display: flex;
	align-items: center;
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

label.pwd-see2 {
	margin-left: 5px;
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
								src="<%=request.getContextPath()%>/backEnd-Website/pic/o_register.png"
								alt="CoolAdmin">
							</a>
						</div>
						<div class="login-form">
<!-- 							<div class="error"> -->
<%-- 								錯誤表列 --%>
<%-- 								<c:if test="${not empty errorMsgs}"> --%>
<!-- 									<font style="color: red">請修正以下錯誤:</font> -->
<!-- 									<ul style="list-style-type: none"> -->
<%-- 										<c:forEach var="message" items="${errorMsgs}"> --%>
<%-- 											<li style="color: red">${message}</li> --%>
<%-- 										</c:forEach> --%>
<!-- 									</ul> -->
<%-- 								</c:if> --%>
<!-- 							</div> -->
							<form
								action="${pageContext.request.contextPath }/owneruser/owneruserf.do"
								method="post" enctype="multipart/form-data">
								<div class="form-group">
									<label>帳號</label><font color=red>${errorMsgs.oUserName}</font>
									 <input class="au-input au-input--full"
										type="text" name="oUserName" placeholder="請輸入帳號"
										value="<%=(ownerUser == null) ? "" : ownerUser.getoUserName()%>">
								</div>
								<div class="form-group">
									<label>信箱</label><font color=red>${errorMsgs.oEmail}</font>
									 <input class="au-input au-input--full"
										type="text" name="oEmail" placeholder="請輸入信箱"
										value="<%=(ownerUser == null) ? "" : ownerUser.getoEmail()%>">
								</div>
								<div class="form-group">
									<label>密碼</label><font color=red>${errorMsgs.oPassword}</font>
									 <input class="au-input au-input--full"
										id="password" type="password" name="oPassword"
										placeholder="請輸入密碼"
										value="<%=(ownerUser == null) ? "" : ownerUser.getoPassword()%>">
									<div class="pwd-see">
										<input type="checkbox" id="togglePwd"> <label
											class="pwd-see2" for="togglePwd">顯示密碼</label>
									</div>
								</div>
								<div class="form-group">
									<label>再次確認密碼</label><font color=red>${errorMsgs.oPassword2}</font>
									 <input class="au-input au-input--full"
										id="password2" type="password" name="oPassword2"
										placeholder="請再次輸入密碼">
									<div class="pwd-see">
										<input type="checkbox" id="togglePwd2"> <label
											class="pwd-see2" for="togglePwd2">顯示密碼</label>
									</div>
								</div>
								<div class="form-group">
									<label>姓名</label><font color=red>${errorMsgs.oName}</font>
									 <input class="au-input au-input--full"
										type="text" name="oName" placeholder="請輸入姓名"
										value="<%=(ownerUser == null) ? "" : ownerUser.getoName()%>">
								</div>
								<div class="form-group">
									<label>電話</label><font color=red>${errorMsgs.oTelephone}</font>
									 <input class="au-input au-input--full"
										type="text" name="oTelephone" placeholder="請輸入電話號碼"
										value="<%=(ownerUser == null) ? "" : ownerUser.getoTelephone()%>">
								</div>
								<div class="form-group">
									<label>性別</label>
									 <select class="au-input au-input--full"
										name="oGender">
										<option value="0">男</option>
										<option value="1">女</option>
									</select>
								</div>
								<div class="form-group">
									<label>生日</label><font color=red>${errorMsgs.oBirth}</font>
									 <input class="au-input au-input--full"
										placeholder="請輸入生日" type="date" name="oBirth"
										value="<%=(ownerUser == null) ? "" : ownerUser.getoBirth()%>">

								</div>
								<div class=" form-group">

									<label for="text-input">聯絡地址</label><font color=red>${errorMsgs.oAddress}</font>

									<div class="city-select">
										<select class="au-input au-input--full" id="city" name="city"
											required>
											<option value="">請選擇縣市</option>
										</select>
										<!-- <span class="custom-message">*請選擇縣市</span> -->
									</div>
									<div class="area-select">
										<select class="au-input au-input--full" id="area" name="area"
											required>
											<option value="">請選擇鄉鎮市區</option>
										</select>
										<!-- <span class="custom-message">*請選擇鄉鎮市區</span> -->
									</div>
									<input type="text" id="text-input" name="oAddress"
										placeholder="請輸入聯絡地址" class="form-control" />
									<!-- <small class="form-text text-muted">This is a help text</small> -->
								</div>
								<div class="form-group">
									<label>身分證</label><font color=red>${errorMsgs.oIDNum}</font>
									 <input class="au-input au-input--full"
										type="text" name="oIDNum" placeholder="請輸入身分證"
										value="<%=(ownerUser == null) ? "" : ownerUser.getoIDNum()%>">
								</div>
								<div class="form-group">
									<label>統編</label><font color=red>${errorMsgs.compiled}</font>
									 <input class="au-input au-input--full"
										type="text" name="compiled" placeholder="請輸入統編"
										value="<%=(ownerUser == null) ? "" : ownerUser.getcompiled()%>">
								</div>
								<div class="form-group">
									<label>銀行代號</label><font color=red>${errorMsgs.oBankCode}</font>
									 <select class="au-input au-input--full"
										id="myBank" name="oBankCode">
										<option value="">請選擇銀行代號</option>
										<option value="004">004臺灣銀行</option>
										<option value="005">005土地銀行</option>
										<option value="006">006合作商銀</option>
										<option value="007">007第一銀行</option>
										<option value="008">008華南銀行</option>
										<option value="009">009彰化銀行</option>
										<option value="011">011上海商業儲蓄銀行</option>
										<option value="012">012台北富邦銀行</option>
										<option value="013">013國泰世華銀行</option>
										<option value="016">016高雄銀行</option>
										<option value="017">017兆豐國際商業銀行</option>
										<option value="018">018農業金庫</option>
										<option value="021">021花旗(台灣)商業銀行</option>
										<option value="025">025首都銀行</option>
										<option value="039">039澳商澳盛銀行</option>
										<option value="040">040中華開發工業銀行</option>
										<option value="050">050臺灣企銀</option>
										<option value="052">052渣打國際商業銀行</option>
										<option value="053">053台中商業銀行</option>
										<option value="054">054京城商業銀行</option>
										<option value="072">072德意志銀行</option>
										<option value="075">075東亞銀行</option>
										<option value="081">081匯豐(台灣)商業銀行</option>
										<option value="085">085新加坡商新加坡華僑銀行</option>
										<option value="101">101大台北銀行</option>
										<option value="102">102華泰銀行</option>
										<option value="103">103臺灣新光商銀</option>
										<option value="104">104台北五信</option>
										<option value="106">106台北九信</option>
										<option value="108">108陽信商業銀行</option>
										<option value="114">114基隆一信</option>
										<option value="115">115基隆二信</option>
										<option value="118">118板信商業銀行</option>
										<option value="119">119淡水一信</option>
										<option value="120">120淡水信合社</option>
										<option value="124">124宜蘭信合社</option>
										<option value="127">127桃園信合社</option>
										<option value="130">130新竹一信</option>
										<option value="132">132新竹三信</option>
										<option value="146">146台中二信</option>
										<option value="147">147三信商業銀行</option>
										<option value="158">158彰化一信</option>
										<option value="161">161彰化五信</option>
										<option value="162">162彰化六信</option>
										<option value="163">163彰化十信</option>
										<option value="165">165鹿港信合社</option>
										<option value="178">178嘉義三信</option>
										<option value="179">179嘉義四信</option>
										<option value="188">188台南三信</option>
										<option value="204">204高雄三信</option>
										<option value="215">215花蓮一信</option>
										<option value="216">216花蓮二信</option>
										<option value="222">222澎湖一信</option>
										<option value="223">223澎湖二信</option>
										<option value="224">224金門信合社</option>
										<option value="512">512雲林區漁會</option>
										<option value="515">515嘉義區漁會</option>
										<option value="517">517南市區漁會</option>
										<option value="518">518南縣區漁會</option>
										<option value="520">520小港區漁會;高雄區漁會</option>
										<option value="521">521彌陀區漁會;永安區漁會;興達港區漁會;林園區漁會</option>
										<option value="523">523東港漁會;琉球區漁會;林邊區漁會</option>
										<option value="524">524新港區漁會</option>
										<option value="525">525澎湖區漁會</option>
										<option value="605">605高雄市農會</option>
										<option value="612">612豐原市農會;神岡鄉農會</option>
										<option value="613">613名間農會</option>
										<option value="614">614彰化地區農會</option>
										<option value="616">616雲林地區農會</option>
										<option value="617">617嘉義地區農會</option>
										<option value="618">618台南地區農會</option>
										<option value="619">619高雄地區農會</option>
										<option value="620">620屏東地區農會</option>
										<option value="621">621花蓮地區農會</option>
										<option value="622">622台東地區農會</option>
										<option value="624">624澎湖農會</option>
										<option value="625">625台中市農會</option>
										<option value="627">627連江縣農會</option>
										<option value="700">700中華郵政</option>
										<option value="803">803聯邦商業銀行</option>
										<option value="805">805遠東銀行</option>
										<option value="806">806元大銀行</option>
										<option value="807">807永豐銀行</option>
										<option value="808">808玉山銀行</option>
										<option value="809">809萬泰銀行</option>
										<option value="810">810星展銀行</option>
										<option value="812">812台新銀行</option>
										<option value="814">814大眾銀行</option>
										<option value="815">815日盛銀行</option>
										<option value="816">816安泰銀行</option>
										<option value="822">822中國信託</option>
										<option value="901">901大里市農會</option>
										<option value="903">903汐止農會</option>
										<option value="904">904新莊農會</option>
										<option value="910">910財團法人農漁會聯合資訊中心</option>
										<option value="912">912冬山農會</option>
										<option value="916">916草屯農會</option>
										<option value="922">922台南市農會</option>
										<option value="928">928板橋農會</option>
										<option value="951">951北農中心</option>
										<option value="954">954中南部地區農漁會</option>
									</select>

									<!-- 									<input class="au-input au-input--full" -->
									<!-- 										type="text" name="oBankCode" placeholder="請輸入銀行代號"> -->
								</div>
								<div class="form-group">
									<label>銀行帳號</label><font color=red>${errorMsgs.oBankAcccount}</font>
									 <input class="au-input au-input--full"
										type="text" name="oBankAccount" placeholder="請輸入銀行帳號"
										value="<%=(ownerUser == null) ? "" : ownerUser.getoBankAccount()%>">
								</div>
								<div class="form-group">

									<label>註冊日期</label> <input class="au-input au-input--full"
										type="date" name="oRegisterDate"
										value="<%=(ownerUser == null) ? "" : ownerUser.getoRegisterDate()%>">

								</div>
								<div class="form-group">
									<label for="file-input">上傳大頭貼</label><font color=red>${errorMsgs.oProfilePic}</font>
									 <input type="file"
										name="oProfilePic" onclick="previewImage()"
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
										<input type="hidden" name="action" value="insert"> <input
											type="submit" class="btn btn-primary btn-sm" value="註冊">
										<i class="fa fa-dot-circle-o"></i>
									</div>
								</div>
							</form>
							<div class="register-link">
								<p>
									已經有帳號了嗎? <a href="${pageContext.request.contextPath }/login/oLogin/oUserLogin.jsp">登入</a>
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
	java.sql.Date oRegistDate = null;
	try {
		oRegistDate = java.sql.Date.valueOf(request.getParameter("oRegistDate").trim());
	} catch (Exception e) {
		oRegistDate = new java.sql.Date(System.currentTimeMillis());
	}
	%>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://unpkg.com/taiwan-bank@1.1.0/dist/taiwan-bank.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script>
		$("#myBank").taiwanBank();
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