<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.pichill.owneruser.entity.OwnerUser"%> 

<%
//見com.emp.controller.EmpServlet.java第238行存入req的empVO物件 (此為輸入格式有錯誤時的empVO物件)
OwnerUser ownerUser = (OwnerUser) request.getAttribute("owneruser");
%>


<!DOCTYPE html>
<html lang="zh-Hant">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>企業會員中心 - 企業會員資料</title>

<link
	href="<%=request.getContextPath()%>/owneruser/css1/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/owneruser/CSS/index3.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.css"/>

<!-- <script> -->
<%-- 	src="<%=request.getContextPath()%>/owneruser/js/bootstrap.min.js"> --%>
<!--  </script>  -->
	<style>
	.phone1 {
		width: 200px;
		height: 200px;
		background-image: url('img_flowers.jpg');
		background-repeat: no-repeat;
		background-size: contain;
		/* border: 1px solid red; */
		position: absolute;
		right: 100px;
		/* z-index: -1; */
	}
	
	  .xdsoft_datetimepicker .xdsoft_datepicker {
           width:  300px;   /* width:  300px; */
  }
  .xdsoft_datetimepicker .xdsoft_timepicker .xdsoft_time_box {
           height: 151px;   /* height:  151px; */
  }
	</style>
</head>
<body>

<!----------------------------------------------- header 區 ------------------------------------------------------->
	<header class="header">
		<div class="container">
			<header class="d-flex flex-wrap justify-content-center py-1">
				<a href="/"
					class="d-flex align-items-center mb-1 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
					<img src="<%=request.getContextPath()%>owneruser/pic/headerlogo.svg"
					alt="SVG" />
				</a>


				<ul class="nav nav-pills">
					<li class="nav-item"><a href="#" class="nav-link">首頁</a></li>
					<li class="nav-item"><a href="#" class="nav-link">通知</a></li>
					<li class="nav-item"><a href="#" class="nav-link">預約管理系統</a></li>
					<li class="nav-item"><a href="#" class="nav-link">論壇</a></li>
					<li class="nav-item"><a href="#" class="nav-link">聯絡我們</a></li>
					<li class="nav-item"><a href="#" class="nav-link"> <img
							src="<%=request.getContextPath()%>/owneruser/pic/face.svg" alt="企業會員頭像" />會員中心
					</a></li>
				</ul>

			</header>
		</div>
	</header>

<!----------------------------------------------- aside 區 ------------------------------------------------------->
	<div class="main_content">
		<aside class="aside">
			<div class="parent_container">
				<h2 class="h6 pt-4 pb-3 mb-4 border-bottom">企業會員中心</h2>
				<nav class="small" id="toc">
					<ul class="list-unstyled">
						<li class="my-2">
							<button
								class="btn d-inline-flex align-items-center collapsed border-0"
								data-bs-toggle="collapse" aria-expanded="false"
								data-bs-target="#contents-collapse"
								aria-controls="contents-collapse">企業會員資料</button>
						</li>

						<li class="my-2">
							<button
								class="btn d-inline-flex align-items-center collapsed border-0"
								data-bs-toggle="collapse" aria-expanded="false"
								data-bs-target="#forms-collapse" aria-controls="forms-collapse"
								href="index4.html">申請上架球館</button>
						</li>
						<li class="my-2">
							<button
								class="btn d-inline-flex align-items-center collapsed border-0"
								data-bs-toggle="collapse" aria-expanded="false"
								data-bs-target="#forms-collapse" aria-controls="forms-collapse">球館管理</button>

						</li>
						<li class="my-2">
							<button
								class="btn d-inline-flex align-items-center collapsed border-0"
								data-bs-toggle="collapse" aria-expanded="false"
								data-bs-target="#forms-collapse" aria-controls="forms-collapse">登出</button>
						</li>
					</ul>
				</nav>
			</div>
		</aside>

		<!----------------------------------------------- main 區 ------------------------------------------------------->
		<main class="main">
			<h2 class="h6 pt-4 pb-3 mb-4 border-bottom">企業會員資料</h2> 
		
			<%-- 錯誤表列 --%>
			<c:if test="${not empty errorMsgs}">
				<font style="color: red">請修正以下錯誤:</font>
				<ul>
					<c:forEach var="message" items="${errorMsgs}">
						<li style="color: red">${message}</li>
					</c:forEach>
				</ul>
			</c:if>
		
			<FORM METHOD="post" ACTION="owneruser.do" name="form1">
				<br> 
				<p> 
	 			<span style="color: #FF0000;">前有<img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" 
	 			width="20" height="20" alt="">為必填項目 </span> 
	 			</p> 

 				<div class="phone1"> 
				<!-- 上傳圖片 -->
                 <div id="blob_holder"><img src="<%=request.getContextPath()%>/owneruser/DBGifReader?oUserID=${param.oUserID}" width="100px"></div>
                <input type="file" id="gProfilePic" name="gProfilePic" onclick="previewImage()" multiple="multiple" />
				</div>
<!-- 			<form class="bararea" enctype="multipart/form-data">  -->

				<span>會員編號:</span>
	            <input type="text" id="ouserID" name="ouserID" value="<%=ownerUser.getoUserID()%>" disabled/>
	            <br><br>
			
				<img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" width="20" height="20">  
				<label for="username">帳號：</label> 
				<input type="text" id="username" name="oUserName"  
					value="<%=(ownerUser == null) ? "yehshaa0106" : ownerUser.getoUserName()%>" size="45" 
		 			style="position: relative; left: 17px;" required> 
				 <br> 
				 <br> 
	
				<img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" width="20" height="20"> 
	 			<label for="password">密碼：</label> 
	 			<input type="password" id="password" name="oPassword" 
	 					value="<%=(ownerUser == null) ? "LtaS845r" : ownerUser.getoPassword()%>" 
	 					style="position: relative; left: 17px;" required> 
	 			<font color="#FF0000" size="-1"	style="position: relative; left: 17px;">請輸入8~12字，須包含數字、大小寫英文字母</font>
	 			<br> 
	 			<br> 
	
				<img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" width="20" height="20">  
				<label for="tax_id">統編：</label> 
	 			<input type="text" id="tax_id"	name="compiled"  
	 				   value="<%=(ownerUser == null) ? "09071688" : ownerUser.getcompiled()%>" style="position: relative; left: 17px;" required> 
	 			<br>
	 			<br> 
	 			
	 			<img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" width="20" height="20">  
	 			<label for="phone">場館負責人姓名:</label> 
	 			<input type="text" id="name" name="oName" 
	 				   value="<%=(ownerUser == null) ? "葉夢華" : ownerUser.getoName()%>" required> 
	 			<br> 
	 			<br> 
				<img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png"  height="20"> 
	 			<label for="gender">性別：</label> 
	 				<%--	name 需相同，表示同一組單選，checked 為預設勾選選項--%>
	 					<div class="radio"> 
	 					 <%int gender = 1 ;%>
		 				  <%--  <%int oGender = ownerUser.getoGender();%> --%>
		 					<select name="oGender"> 
		 						<option value="0" <%=gender == 0 ? "selected" : ""%>>男</option> 
		 						<option value="1" <%=gender == 1 ? "selected" : ""%>>女</option> 
		 					</select>
	 					</div>	 
					<br> 
					<br> 
					<img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" width="20" height="20" alt=""> 
						<label for="phone">場館負責人身分證字號:</label> 
	 					<input type="text" id="oIDNum" name="oIDNum" 
	 					value="<%=(ownerUser == null) ? "H212810987" : ownerUser.getoIDNum()%>" 
	 					placeholder="A123456789" required> 
	 				<br>  
					<br> 
					
					<img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" width="20" height="20" alt="">  
					<label for="obirth">出生年月日:</label>
					<input name="oBirth" id="f_date1" type="text">
					
					<br> 
					<br> 	 
					
					<img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" width="20" height="20" alt="">  
	 				<label for="oTelephone">連絡電話：</label> 
	 				<input type="text" id="oTelephone" name="oTelephone" value="<%=(ownerUser == null) ? "0934862754" : ownerUser.getoTelephone()%>" required> 
	 				<font color="#FF0000" size="-1" >如:0912345678。</font> 
	 				<br> 
	 				<br>
					
					<img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" width="20" height="20" alt="">  
						<label for="oAddress">連絡地址：</label>  
	 					<input type="text" id="oAddress" name="oAddress" value="<%=(ownerUser == null) ? "新北市新店區民權路98號6樓" : ownerUser.getoAddress()%>" required>  
	 					<br> 
						<br> 
						
	 				<img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" width="20" height="20" alt="">  
	 					<label for="oBankCode">銀行代號：</label>  
	 					<input type="text" id="bank_branch" name="oBankCode" value="<%=(ownerUser == null) ? "808" : ownerUser.getoBankCode()%>"  placeholder="如:012" required> 
	 					<br> 
	 					<br>  
	 					
					<img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" width="20" height="20" alt="">  
						<label for="oBankAccount">銀行帳號：</label> 
	 					<input type="text" id="bank_account" name="oBankAccount"  value="<%=(ownerUser == null) ? "95301246813579" : ownerUser.getoBankAccount()%>" required>
						<br>  
						<br> 
						
	 				<img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" width="20" height="20" alt="">  
	 					<label for="oBankAccount">電子信箱：</label> 
	 					<input type="text" id="oEmail" name="oEmail" 
	 					style = "width:250px;"
	 					value="<%=(ownerUser == null) ? "yehshaa0106@gmail.com" : ownerUser.getoEmail()%>" required>  
	 					<font color="#FF0000" size="-1" >電子信箱格式範例:abc@yahoo.com.tw</font> 
			</form>

				<br> <br>

 			<!-------- 送出按鈕  -------> 
				<input type="hidden" name="action" value="update">
				<input type="hidden" name="oUserID" value="<%=ownerUser.getoUserID()%>">
				<input type="submit" value="送出修改" style="width: 150px; height: 44px;"> 

 			</div>
	
	</main>





<!----------------------------------------------- footer 區 ------------------------------------------------------->
	<footer class="footer">

		<div class="container">
			<header class="d-flex flex-wrap justify-content-center py-3">
				<a href="/"
					class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
					<img src="./pic/footerlogo.svg" alt="SVG" />
				</a>

				<ul class="nav nav-pills">
                    <li class="nav-item"><a href="<%=request.getContextPath()%>/homepage/termOfUse/termOfUse.html" class="nav-link">使用者條款</a></li>
                    <li class="nav-item"><a href="#" class="nav-link"></a></li>
                    <li class="nav-item"><a href="<%=request.getContextPath()%>/homepage/privacyPolicy/privacyPolicy.html" class="nav-link">隱私權政策</a></li>
                    <li class="nav-item"><a href="#" class="nav-link"></a></li>
                    <li class="nav-item"><a href="<%=request.getContextPath()%>/homepage/disclaimer/disclaimer.html" class="nav-link">免責條款</a></li>
                    <li class="nav-item"><a href="#" class="nav-link"></a></li>
                    <li class="nav-item"><a href="#" class="nav-link"></a></li>
                </ul>
			</header>
		</div>
	</footer>

<!-- =========================================以下為 datetimepicker 之相關設定========================================== -->


<script src="<%=request.getContextPath()%>owneruser/datetimepicker/jquery.js"></script>
<script src="<%=request.getContextPath()%>owneruser/datetimepicker/jquery.datetimepicker.full.js"></script>


<script>
        $.datetimepicker.setLocale('zh');
        $('#f_date1').datetimepicker({
           theme: '',              //theme: 'dark',
 	       timepicker:false,       //timepicker:true,
 	       step: 1,                //step: 60 (這是timepicker的預設間隔60分鐘)
 	       format:'Y-m-d',         //format:'Y-m-d H:i:s',
 		   value: '<%=ownerUser.getoBirth()%>', // value:   new Date(),
           //disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // 去除特定不含
           //startDate:	            '2017/07/10',  // 起始日
           //minDate:               '-1970-01-01', // 去除今日(不含)之前
           //maxDate:               '+1970-01-01'  // 去除今日(不含)之後
        });
        
        
   
        // ----------------------------------------------------------以下用來排定無法選擇的日期-----------------------------------------------------------

        //      1.以下為某一天之前的日期無法選擇
        //      var somedate1 = new Date('2017-06-15');
        //      $('#f_date1').datetimepicker({
        //          beforeShowDay: function(date) {
        //        	  if (  date.getYear() <  somedate1.getYear() || 
        //		           (date.getYear() == somedate1.getYear() && date.getMonth() <  somedate1.getMonth()) || 
        //		           (date.getYear() == somedate1.getYear() && date.getMonth() == somedate1.getMonth() && date.getDate() < somedate1.getDate())
        //              ) {
        //                   return [false, ""]
        //              }
        //              return [true, ""];
        //      }});

        
        //      2.以下為某一天之後的日期無法選擇
        //      var somedate2 = new Date('2017-06-15');
        //      $('#f_date1').datetimepicker({
        //          beforeShowDay: function(date) {
        //        	  if (  date.getYear() >  somedate2.getYear() || 
        //		           (date.getYear() == somedate2.getYear() && date.getMonth() >  somedate2.getMonth()) || 
        //		           (date.getYear() == somedate2.getYear() && date.getMonth() == somedate2.getMonth() && date.getDate() > somedate2.getDate())
        //              ) {
        //                   return [false, ""]
        //              }
        //              return [true, ""];
        //      }});


        //      3.以下為兩個日期之外的日期無法選擇 (也可按需要換成其他日期)
        //      var somedate1 = new Date('2017-06-15');
        //      var somedate2 = new Date('2017-06-25');
        //      $('#f_date1').datetimepicker({
        //          beforeShowDay: function(date) {
        //        	  if (  date.getYear() <  somedate1.getYear() || 
        //		           (date.getYear() == somedate1.getYear() && date.getMonth() <  somedate1.getMonth()) || 
        //		           (date.getYear() == somedate1.getYear() && date.getMonth() == somedate1.getMonth() && date.getDate() < somedate1.getDate())
        //		             ||
        //		            date.getYear() >  somedate2.getYear() || 
        //		           (date.getYear() == somedate2.getYear() && date.getMonth() >  somedate2.getMonth()) || 
        //		           (date.getYear() == somedate2.getYear() && date.getMonth() == somedate2.getMonth() && date.getDate() > somedate2.getDate())
        //              ) {
        //                   return [false, ""]
        //              }
        //              return [true, ""];
        //      }});
</script>

<%-- <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script> --%>

</body>
</html>