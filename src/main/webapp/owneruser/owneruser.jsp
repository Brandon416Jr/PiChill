<%@ page contentType="text/html; charset=UTF-8" pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.pichill.owneruser.entity.OwnerUser"%>
    
<%
//從資料庫取出的owneruser, 也可以是輸入格式有錯誤時的owneruser物件
OwnerUser ownerUser = (OwnerUser) session.getAttribute("ownerUser");
%>  
    
    
<!DOCTYPE html>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <title>ownerUser</title>
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
					<li class="nav-item"><a href="<%=request.getContextPath()%>/ownerusernotify/notify.jsp" class="nav-link">通知</a></li>
					<li class="nav-item"><a href="<%=request.getContextPath()%>/post/forumowner.html" class="nav-link">論壇</a></li>
					<li class="nav-item"><a href="<%=request.getContextPath()%>/contactus/addContactUs.jsp" class="nav-link">聯絡我們</a></li>
					<li class="nav-item"><a href="<%=request.getContextPath()%>/owneruser/owneruser.jsp" class="nav-link"> 
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
                         	<form method="POST" action="<%=request.getContextPath()%>/owneruser/owneruser.jsp"> 
                            	<button class="btn d-inline-flex align-items-center collapsed border-0">企業會員資料</button>
                        	</form>
                        </li>
                        <li class="my-2">
                        	<form method="POST" action="<%=request.getContextPath()%>/court/new_court.jsp"> 
                            	<button class="btn d-inline-flex align-items-center collapsed border-0">申請上架球館</button>
                        	</form>
                        </li>
                        <li class="my-2">
                        	<form method="POST" action="<%=request.getContextPath()%>/place/new_place.jsp">
                        		<button class="btn d-inline-flex align-items-center collapsed border-0">申請上架場地</button>
                            </form> 
                        </li>                        
                        <li class="my-2">
                            <form method="POST" action="<%=request.getContextPath()%>/court/all_court.jsp"> 
                            	<button class="btn d-inline-flex align-items-center collapsed border-0">球館管理</button>
                        	</form>
                        </li>
                        <br>
						<li class="my-2">
							<form method="POST" action="<%=request.getContextPath()%>/logoutfo.do"> 
								<button class="btn btn-danger">登出</button>
								<input type="hidden" name="action" value="logout">
							</form>
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
				<font style="color:red">請修正以下錯誤:</font>
				<ul>
					<c:forEach var="message" items="${errorMsgs}">
						<li style="color:red">${message}</li>
					</c:forEach>
				</ul>
			</c:if>


		<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/owneruser/owneruser.do" enctype="multipart/form-data" class="bararea">
          		<span>企業會員編號:</span>
                <input type="text" id="ouserID" name="ouserID" value="<%=ownerUser.getoUserID()%>" disabled/>
                <br><br>                            
      
                <img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" width="20" height="20"> 
                <span>帳號:</span>
                <input type="text" id="oUserName" name="oUserName" style = "width:250px;" value="<%= (ownerUser == null) ? "yehshaa0106" : ownerUser.getoUserName()%>" />
                <br><br>
                
                <img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" width="20" height="20"> 
                <span>密碼:</span>
                <input type="text" id="oPassword" name="oPassword" value="<%= (ownerUser == null) ? "LtaS845r" : ownerUser.getoPassword()%>"/>
                <br><br>
                
                <img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" width="20" height="20"> 
                <span>統編:</span>
                <input type="text" id="compiled" style="position: relative; left: 17px;" name="compiled" value="<%= (ownerUser == null) ? "09071688" : ownerUser.getcompiled()%> " required/>
                <br><br>
                
                <img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" width="20" height="20"> 
                <span>場館負責人姓名:</span>
                <input type="text" id="oName" name="oName" value="<%= (ownerUser==null)? "葉夢華" : ownerUser.getoName()%>"/>
                <br><br>
                
    		    <img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" width="20" height="20"> 
                <span>性別:</span>
                <input type="text" id="oGender" name="oGender" value="<%= (ownerUser==null)? 0 : ownerUser.getoGender()%>"/>

                <br><br>
                
                <img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" width="20" height="20"> 
                <span>場館負責人身分證字號:</span>
                <input type="text" id="oIDNum" name=oIDNum"  value="<%= (ownerUser==null)? "H212810987" : ownerUser.getoIDNum()%>"/>
                <br><br>
                
                <img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" width="20" height="20">                  
                <span>出生年月日:</span>
                <input type="text" id="oBirth" name="oBirth" value="<%= (ownerUser==null)? "1990-01-06" : ownerUser.getoBirth()%>"/>
                <br><br>
                
                <img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" width="20px" height="20">   
                <span>連絡電話:</span>
                <input type="text" id="oTelephone" name="oTelephone" value="<%= (ownerUser == null) ? "0934862754" : ownerUser.getoTelephone()%>"/>
                <font color="#FF0000" size="-1" nowrap="">如:0912345678。</font> 
                <br><br>
                
                <img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" width="20" height="20">    
                <span>聯絡地址:</span>
                 <input type="text" id="oAddress" style = "width:250px;" name="oAddress" placeholder="請輸入聯絡地址" 
                value="<%= (ownerUser == null) ? "新北市新店區民權路98號6樓" : ownerUser.getoAddress()%>"/>
               <br><br>
                
                <img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" width="20" height="20">    
                <span>銀行代號：</span> 
 				<input type="text" id="oBankCode" name="oBankCode" value="<%=(ownerUser == null) ? "808" : ownerUser.getoBankCode()%>"  placeholder="如:012" required> 
 				<br> 
 				<br>
 				
 				<img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" width="20" height="20" alt="">  
				<span>銀行帳號：</span> 
 				<input type="text" id="bank_account" name="oBankAccount"  value="<%=(ownerUser == null) ? "95301246813579" : ownerUser.getoBankAccount()%>" required>
				<br>  
				<br>  
                
                
               <img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" width="20" height="20" alt="">  
 			   <span>電子信箱：</span>  
 			   <input type="text" id="oEmail" name="oEmail" style = "width:250px;"
 				value="<%=(ownerUser == null) ? "yehshaa0106@gmail.com" : ownerUser.getoEmail()%>" required>  
 			   <font color="#FF0000" size="-1" nowrap="">電子信箱格式範例:abc@yahoo.com.tw</font> 
               <br>  
				<br> 
                
                <span>大頭貼:</span><br>
                <div id="blob_holder"><img src="<%=request.getContextPath()%>/owneruser/DBGifReader?oUserID=${param.oUserID}" width="300px"></div>
                <input type="file" id="oProfilePic" name="oProfilePic" onclick="previewImage()" multiple="multiple" />
                <br>
                
                <input type="hidden" name="action" value="update">
				<input type="hidden" name="oUserID" value="<%=ownerUser.getoUserID()%>">
                <input type="submit" id="next" value="送出修改" style="width:150px; height:44px;">
                <br><br><br>
                <br><br>
         </FORM>      
       </div>
   </main>
<!--     </div> -->

    
    <!----------------------------------------------- footer 區 ------------------------------------------------------->
    <footer class="footer">
      
        <div class="container">
          <header class="d-flex flex-wrap justify-content-center py-3">
            <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
              <img src = "<%=request.getContextPath()%>/owneruser/pic/footerlogo.svg" alt="SVG"/>     
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
    
<!--======================================= 照片上傳 / 預覽 =======================================-->
    <script type="text/javascript">
		//清除提示信息
		function hideContent(d) {
		     document.getElementById(d).style.display = "none";
		}
		
		//照片上傳-預覽用
		var filereader_support = typeof FileReader != 'undefined';
		if (!filereader_support) {
			alert("No FileReader support");
		}
		acceptedTypes = {
				'image/png' : true,
				'image/jpeg' : true,
				'image/gif' : true
		};
		function previewImage() {
			var oProfilePic1 = document.getElementById("oProfilePic");
			oProfilePic1.addEventListener("change", function(event) {
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
				document.getElementById('submit').disabled = false;
			} else {
				blob_holder.innerHTML = "<div  style='text-align: left;'>" + "● filename: " + file.name
						+ "<br>" + "● ContentTyp: " + file.type
						+ "<br>" + "● size: " + file.size + "bytes"
						+ "<br>" + "● 上傳ContentType限制: <b> <font color=red>image/png、image/jpeg、image/gif </font></b></div>";
				document.getElementById('submit').disabled = true;
			}
		}
	</script>
	

   
    
</body>
</html>

























</body>
</html>