<%@ page contentType="text/html; charset=UTF-8" pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.pichill.owneruser.entity.*"%>
<%@ page import="com.pichill.court.*"%>
<%@ page import="com.pichill.place.*"%>
    
<%
//從資料庫取出的court, 也可以是輸入格式有錯誤時的court物件
Court court = (Court) request.getAttribute("court");

%>  
    
    
    
    
    
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <title>球館管理</title>
    
    <link rel="stylesheet" href="<%=request.getContextPath()%>/owneruser/css1/bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/owneruser/CSS/css.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/owneruser/CSS/index3.css">
  
  <!----------------匯入jquery ------------------------>
    <script src="<%=request.getContextPath()%>https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous">
    </script>
    
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
	input[type="courtAddress"] {
  	cursor: pointer;
  	width: 450px;
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
					<li class="nav-item"><a href="<%=request.getContextPath()%>/owneruser/ouserListOne.jsp" class="nav-link"> 
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
            <h2 class="h6 pt-4 pb-3 mb-4 border-bottom">球館管理</h2>
            
            <%-- 錯誤表列 --%>
			<c:if test="${not empty errorMsgs}">
				<font style="color:red">請修正以下錯誤:</font>
				<ul>
					<c:forEach var="message" items="${errorMsgs}">
						<li style="color:red">${message}</li>
					</c:forEach>
				</ul>
			</c:if>

		<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/court/court.do" enctype="multipart/form-data" class="bararea">
<!-- 			<span>球館編號:</span> -->
<%-- 				<input type="text" id="courtID" name="courtID" value="<%=court.getCourtID()%>" disabled/> --%>
<!-- 				<br><br> -->
<!-- 			<span>企業會員編號:</span> -->
<%-- 				<input type="text" id="ouserID" name="ouserID" value="<%=court.getoUserID()%>" disabled/> --%>
<!-- 				<br><br> -->
<!-- 			<span>管理員編號編號:</span> -->
<%-- 				<input type="text" id="manageID" name="manageID" value="<%=court.getmanageID()%>" disabled/> --%>
<!-- 				<br><br> -->
		    <span>上架時間:</span>
                <input type="text" id="oPassword" name="courtOnTime" value="<%=court.getCourtOnTime()%>" disabled/>
                <br><br>
		 	<span>申請上架時間:</span>
                <input type="text" id="courtApplyTime" name="courtApplyTime" value="<%=court.getCourtApplyTime()%>" disabled/>
                <br><br>
		
		 	<img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" width="20" height="20"> 
                <span>球館名稱:</span>
                <input type="text" id="courtName" style="position: relative; left: 17px;" name="courtName" value="<%= (court == null) ? "飛龍運動館" : court.getCourtName()%> " required/>
                <br><br>
		
			<img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" width="20" height="20"> 
                <span>球館電話:</span>
                <input type="text" id="courtTelephone" style="position: relative; left: 17px;" name="courtTelephone" value="<%= (court == null) ? "022562622" : court.getCourtTelephone()%> " required/>
                <br><br>
		
			<img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" width="20" height="20"> 
                <span>球館地址:</span>
                <input type="text" id="courtAddress" style="position: relative; left: 17px;" name="courtAddress" value="<%= (court == null) ? "臺北市大安區通化街11巷95號1樓" : court.getCourtAddress()%> " required/>
                <br><br>
                
            <img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" width="20" height="20"> 
                <span>開館時間:</span>
                <input type="text" id="courtOpenTime" style="position: relative; left: 17px;" name="courtOpenTime" value="<%= (court == null) ? "07:00:00" : court.getCourtOpenTime()%> " required/>
                <br><br>	
		
			<img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" width="20" height="20"> 
                <span>開館時間:</span>
                <input type="text" id="courtOpenTime" style="position: relative; left: 17px;" name="courtCloseTime" value="<%= (court == null) ? "21:00:00" : court.getCourtCloseTime()%> " required/>
                <br><br>		
		
			<img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" width="20" height="20"> 
                <span>球館須知:</span>
                <input type="text" id="courtRule" style="width:400px ; height:300px ;position: relative; left: 17px;" name="courtRule" 
                value="<%= (court == null) ? "本場館禁止吸菸、飲食、喝酒，不可私下教學。 <br>禁止燃放鞭炮、酗酒、鬥毆、夜宿及任何妨礙公共安全秩序、違反公序良俗或妨害風化之行為。 個人貴重物品、財物請自行妥善保管，若遺失本館恕不負責。 禁止攜帶雨具及寵物進入中心，輔助盲人同胞的導盲犬不在此限。 患有高血壓、糖尿病、心臟病、傳染病、飯後一小時內、血壓過低、酒後、嚴重睡眠不足時或其他任何身體不適者，禁止使用本設備。 若因使用不當造成設備/器材毀損，本中心有權要求損壞賠償。 未經同意禁止使用館內插座，如因活動或租借場地，需先付費後方能使用。 本須知如有未盡事宜，得另行增列、修訂之，並以現場公告或服務人員說明為準。" 
                		: court.getCourtRule()%> " required/>
                <br><br>
		
			<img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" width="20" height="20"> 
                <span>地區:</span>
                <input type="text" id="loc" style="position: relative; left: 50px;" name="loc" value="<%= (court == null) ? "大安區" : court.getLoc()%> " required/>
                <br><br>		
		
				
		
		
		        <span>申請狀態:</span>
                <% int courtAS = court.getCourtApplyStatus(); %>
				<select name="courtApplyStatus" disabled="disabled">
					<option value="0" <%=courtAS == 0 ? "selected" : ""%>>審核中</option>
					<option value="1" <%=courtAS == 1 ? "selected" : ""%>>審核通過</option>
					<option value="1" <%=courtAS == 1 ? "selected" : ""%>>審核未通過</option>
				</select>
                <br><br>
                
                <span>球館圖片:</span><br>
                <div id="blob_holder">
                <img src="<%=request.getContextPath()%>/court/DBGifReader?oUserID=${param.courtID}" width="200px">
                </div>
                <input type="file" id="courtPic" name="courtPic" onclick="previewImage()" multiple="multiple" />
                <br>
                <br>
                


                <br><br><br>
                <input type="hidden" name="action" value="update">
				<input type="hidden" name="courtID" value="<%=court.getCourtID()%>">
                <input type="submit" id="next" value="送出修改" style="width:150px; height:44px;">
                <br><br><br>
                <br><br>
		
		</FORM>
       
   </main>
  </div>

  <!----------------------------------------------- footer 區 ------------------------------------------------------->
    <footer class="footer">
      
        <div class="container">
          <header class="d-flex flex-wrap justify-content-center py-3">
            <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
              <img src = "<%=request.getContextPath()%>/generaluser/pic/footerlogo.svg" alt="SVG"/>     
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
			var cProfilePic1 = document.getElementById("courtPic");
			cProfilePic1.addEventListener("change", function(event) {
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


<!--======================================= 新增場地 / 編輯 / 預覽 =======================================-->

           <script>
                $(document).ready(function () {
                    $("#addButton").click(function () {
                        var ball = $("#ball").val();
                        var itemName = $("#placeName").val();
                        var placeFee = $("#placeFee").val();

                        if (ball && itemName && price) {
                            var newRow = "<tr>" +
                                "<td>" + ball + "</td>" +
                                "<td>" + placeName + "</td>" +
                                "<td>" + placeFee + "</td>" +
                                "<td><button class='deleteButton'>刪除</button></td>" +
                                "</tr>";

                            $("#itemTable tbody").append(newRow);

                            // 清空輸入欄位
                            $("#itemName, #placeFee").val("");
                        } else {
                            alert("請填寫完整資訊");
                        }
                    });
                    // 刪除按鈕的點擊事件處理
                    $(document).on("click", ".deleteButton", function () {
                        $(this).closest("tr").remove();
                    });
                });
            </script>



</body>
</html>