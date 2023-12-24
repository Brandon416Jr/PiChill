<%@ page contentType="text/html; charset=UTF-8" pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.pichill.owneruser.entity.*"%>

<%
//從資料庫取出的owneruser, 也可以是輸入格式有錯誤時的owneruser物件
OwnerUser ownerUser = (OwnerUser) request.getAttribute("ownerUser");
%> 

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

	<title>ouserListOne</title>
		<link rel="stylesheet" href="<%=request.getContextPath()%>/owneruser/css1/bootstrap.min.css">
	    <link rel="stylesheet" href="<%=request.getContextPath()%>/owneruser/CSS/css.css">
	    <link rel="stylesheet" href="<%=request.getContextPath()%>/owneruser/CSS/index3.css">
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
  	</style>

</head>
<body>


<!----------------------------------------------- header 區 ------------------------------------------------------->
	<header class="header">
		<div class="container">
			<header class="d-flex flex-wrap justify-content-center py-1">
				<a href="/"
					class="d-flex align-items-center mb-1 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
					<img src="<%=request.getContextPath()%>/owneruser/pic/headerlogo.svg" alt="SVG"/>
				</a>


				<ul class="nav nav-pills">
					<li class="nav-item"><a href="<%=request.getContextPath()%>/homepage/owneruserhome.jsp" class="nav-link">首頁</a></li>
					<li class="nav-item"><a href="#" class="nav-link">通知</a></li>
					<li class="nav-item"><a href="#" class="nav-link">預約管理系統</a></li>
					<li class="nav-item"><a href="#" class="nav-link">論壇</a></li>
					<li class="nav-item"><a href="#" class="nav-link">聯絡我們</a></li>
					<img src="<%=request.getContextPath()%>/owneruser/DBGifReader?oUserID=${ownerUser.oUserID}"  alt="SVG" class="rounded-circle"/>企業會員中心</a></li>
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
								href="<%=request.getContextPath()%>/court/new_court.jsp">申請上架球館</button>
						</li>
						<li class="my-2">
							<button
								class="btn d-inline-flex align-items-center collapsed border-0"
								data-bs-toggle="collapse" aria-expanded="false"
								data-bs-target="#forms-collapse" aria-controls="forms-collapse">球館管理</button>

						</li>
						<form method="POST" action="<%=request.getContextPath()%>/logoutfo.do"> 
							<li class="my-2">
								<button class="btn btn-danger">登出</button>
								<input type="hidden" name="action" value="logout">
							</li>
						</form>
						
					</ul>
				</nav>
			</div>
		</aside>


    <!----------------------------------------------- main 區 ------------------------------------------------------->
    <main class="main">
            <h2 class="h6 pt-4 pb-3 mb-4 border-bottom">企業會員資料</h2>
            
            <%-- 錯誤表列 --%>
			<c:if test="${not empty errorMsgs}">
				<font style="color:red">請修正以下錯誤:</font>
				<ul>
					<c:forEach var="message" items="${errorMsgs}">
						<li style="color:red">${message}</li>
					</c:forEach>
				</ul>
			</c:if>


<span>企業會員編號:</span>
                <input type="text" id="ouserID" name="ouserID" value="${ownerUser.oUserID}" disabled/>
                <br><br>                            
      
                <img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" width="20" height="20"> 
                <span>帳號:</span>
                <input type="text" id="oUserName" name="oUserName" value="${ownerUser.oUserName}" disabled>
                <br><br>
                
                <img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" width="20" height="20"> 
                <span>密碼:</span>
                <input type="text" id="oPassword" name="oPassword" value="${ownerUser.oPassword}"/>
                <br><br>
                
                <img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" width="20" height="20"> 
                <span>統編:</span>
                <input type="text" id="compiled" style="position: relative; left: 17px;" name="compiled" value="${ownerUser.compiled}" required/>
                <br><br>
                
                <img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" width="20" height="20"> 
                <span>場館負責人姓名:</span>
                <input type="text" id="oName" name="oName" value="${ownerUser.oName}"/>
                <br><br>
                
    		    <img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" width="20" height="20"> 
                <span>性別:</span>
           		<input type="text" id="oGender" name="oGender" value="${ownerUser.oGender == 0 ? '男':'女'}" disabled>
<%--                 <% int gender = ownerUser.getoGender(); %> --%>
<!-- 				<select name="oGender" disabled="disabled"> -->
<%-- 				<option value="0" <%=gender == 0 ? "selected" : ""%>>男</option> --%>
<%-- 				<option value="1" <%=gender == 1 ? "selected" : ""%>>女</option> --%>
<!-- 				</select> -->
                <br><br>
                
                <img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" width="20" height="20"> 
                <span>場館負責人身分證字號:</span>
                <input type="text" id="oIDNum" name=oIDNum"  value="${ownerUser.oIDNum}"/>
                <br><br>
                
                <img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" width="20" height="20">                  
                <span>出生年月日:</span>
                <input type="text" id="oBirth" name="oBirth" value="${ownerUser.oBirth}" disabled>
                <br><br>
                
                <img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" width="20" height="20">   
                <span>連絡電話:</span>
                <input type="text" id="oTelephone" name="oTelephone" value="${ownerUser.oTelephone}"/>
                <font color="#FF0000" size="-1" nowrap="">如:0912345678。</font> 
                <br><br>
                
                <img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" width="20" height="20">    
                <span>聯絡地址:</span>
                 <input type="text" id="oAddress" style = "width:250px;" name="oAddress" placeholder="請輸入聯絡地址" 
                value="${ownerUser.oAddress}"/>
               <br><br>
                
                <img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" width="20" height="20">    
                <span>銀行代號：</span> 
 				<input type="text" id="oBankCode" name="oBankCode" value="${ownerUser.oBankCode}"  placeholder="如:012" required> 
 				<br> 
 				<br>
 				
 				<img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" width="20" height="20" alt="">  
				<span>銀行帳號：</span> 
 				<input type="text" id="bank_account" name="oBankAccount"  value="${ownerUser.getoBankAccount}" required>
				<br>  
				<br>  
                
                
               <img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" width="20" height="20" alt="">  
 			   <span>電子信箱：</span>  
 			   <input type="text" id="oEmail" name="oEmail" style = "width:250px;"
 				value="${ownerUser.oEmail}" required>  
 			   <font color="#FF0000" size="-1" nowrap="">電子信箱格式範例:abc@yahoo.com.tw</font> 
               <br>  
				<br> 
                
                <span>大頭貼:</span><br>
                <input type="file" id="oProfilePic" name="oProfilePic" previewImage() multiple="multiple" hidden/>
                <img src="<%=request.getContextPath()%>/owneruser/DBGifReader?oUserID=${ownerUser.oUserID}" width="100px">
                <br>
 	 			<br>

 			<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/owneruser/owneruser.do" enctype="multipart/form-data" class="bararea">  
                <input type="hidden" name="action" value="getOne_For_Update">
				<input type="hidden" name="oUserID" value="${ownerUser.oUserID}">
                <input type="submit" id="next" value="修改" style="width:150px; height:44px;">
                <br><br><br>
                <br><br>
            </form>


  </main>
    </div>  

<!----------------------------------------------- footer 區 ------------------------------------------------------->
    <footer class="footer">
      
        <div class="container">
          <header class="d-flex flex-wrap justify-content-center py-3">
            <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
              <img src = "<%=request.getContextPath()%>/generaluser/pic/footerlogo.svg" alt="SVG"/>     
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
      
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    
    <!--======================================= 顯示預覽圖 =======================================-->
    <script>
	    function previewImage() {
			var oProfilePic1 = document.getElementById("oProfilePic");
			gProfilePic1.addEventListener("show", function(event) {
				var files = event.target.files || event.dataTransfer.files;
				for (var i = 0; i < files.length; i++) {
					previewfile(files[i])
				}
			}, false);
		}
		function previewfile(file) {
			if (filereader_support === true && acceptedTypes[file.type] === true) {
				var reader = new FileReader();
				reader.onload = function(event) {
					var image = new Image();
					image.src = event.target.result;
					image.width = 130;
					image.height = 150;
					image.border = 0;
					if (blob_holder.hasChildNodes()) {
						blob_holder.removeChild(blob_holder.childNodes[0]);
					}
					blob_holder.appendChild(image);
				};
				reader.readAsDataURL(file);
			} 
		}
      </script>

</body>
</html>