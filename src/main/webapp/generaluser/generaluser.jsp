<%@ page contentType="text/html; charset=UTF-8" pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.pichill.generaluser.entity.GeneralUser"%>


<%
	//從資料庫取出的generaluser, 也可以是輸入格式有錯誤時的generaluser物件
    GeneralUser generalUser = (GeneralUser) request.getAttribute("generalUser");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <title>generalUser</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/generaluser/CSS/bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/generaluser/css2/css.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/generaluser/css2/guser.css">
  
</head>
<body>
    <!----------------------------------------------- header 區 ------------------------------------------------------->
    <header class="header">
        <div class="container">
            <header class="d-flex flex-wrap justify-content-center py-1">
              <a href="/" class="d-flex align-items-center mb-1 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
                <img src = "<%=request.getContextPath()%>/generaluser/pic/headerlogo.svg" alt="SVG"/>     
              </a>
              
            
              <ul class="nav nav-pills">
                <li class="nav-item"><a href="main.html" class="nav-link">首頁</a></li>
                <li class="nav-item"><a href="#" class="nav-link">公告</a></li>
                <li class="nav-item"><a href="#" class="nav-link">場館資訊</a></li>
                <li class="nav-item"><a href="#" class="nav-link">我要預約</a></li>
                <li class="nav-item"><a href="#" class="nav-link">論壇</a></li>
                <li class="nav-item"><a href="#" class="nav-link"><img src = "<%=request.getContextPath()%>/generaluser/pic/face.svg" alt="SVG"/> 會員中心</a></li>
              </ul>

              
            </header>
          </div>
    </header>
      
      
    <!----------------------------------------------- aside 區 ------------------------------------------------------->
    <div class="main_content">
    <aside class="aside">
        <div class="parent_container">
            <h2 class="h6 pt-4 pb-3 mb-4 border-bottom" id="ah6">會員中心</h2>
                <nav class="small" id="toc">
                    <ul class="list-unstyled">
                        <li class="my-2">
                          <a class="asidearea" href="<%=request.getContextPath()%>/generaluser/guserListOne.jsp">會員資料</a> 
                        </li>
                        <li class="my-2">
                          <a class="asidearea" href="">球館預約紀錄</a>                         
                        </li>
                        <li class="my-2">
                          <a class="asidearea" href="">聯絡我們</a>                         
                        </li>
                        <li class="my-2">
                          <a class="asidearea" href="">登出</a>                           
                        </li>
                    </ul>
                </nav>
        </div>
    </aside>

    <!----------------------------------------------- main 區 ------------------------------------------------------->
    <main class="main">
            <h2 class="h6 pt-4 pb-3 mb-4 border-bottom">會員資料</h2>
            
            <%-- 錯誤表列 --%>
			<c:if test="${not empty errorMsgs}">
				<font style="color:red">請修正以下錯誤:</font>
				<ul>
					<c:forEach var="message" items="${errorMsgs}">
						<li style="color:red">${message}</li>
					</c:forEach>
				</ul>
			</c:if>
            

			<FORM METHOD="post" ACTION="generaluser.do" enctype="multipart/form-data" class="bararea">
                <span>會員編號:</span>
                <input type="text" id="guserID" name="guserID" value="<%=generalUser.getgUserID()%>"/>
                <br><br>
                <span>姓名:</span>
                <input type="text" id="gName" name="gName" value="<%= (generalUser==null)? "劉晉歆" : generalUser.getgName()%>"/>
                <br><br>
                <span>帳號:</span>
                <input type="text" id="gUsername" name="gUsername" value="<%= (generalUser==null)? "jiojilellee" : generalUser.getgUsername()%>"/>
                <br><br>
                <span>密碼:</span>
                <input type="text" id="gPassword" name="gPassword" value="<%= (generalUser==null)? "v3PBw9Rs" : generalUser.getgPassword()%>"/>
                <br><br>
                <span>暱稱:</span>
                <input type="text" id="nicknameID" name="nicknameID" value="<%= (generalUser==null)? "bibibibibi" : generalUser.getNicknameID()%>"/>
                <br><br>
                <span>電子信箱:</span>
                <input type="email" id="gEmail" name="gEmail" value="<%= (generalUser==null)? "carlisle1306@gmail.com" : generalUser.getgEmail()%>"/>
                <br><br>
                <span>身分證字號:</span>
                <input type="text" id="gIDNum" name="gIDNum" value="<%= (generalUser==null)? "P130192176" : generalUser.getgIDNum()%>"/>
                <br><br>
                <span>性別:</span>
                <input type="text" id="gGender" name="gGender" value="<%= (generalUser==null)? "0" : generalUser.getgGender()%>"/>
                <br><br>
                <span>出生年月日:</span>
                <input type="text" id="gBirth" name="gBirth" value="<%= (generalUser==null)? "1983-07-26" : generalUser.getgBirth()%>"/>
                <br><br>
                <span>手機號碼:</span>
                <input type="text" id="gTelephone" name="gTelephone" value="<%= (generalUser==null)? "0988059202" : generalUser.getgTelephone()%>"/>
                <br><br>
                <span>聯絡地址:</span>
                <input type="text" id="gAddress" name="gAddress" value="<%= (generalUser==null)? "臺北市中山區新生北路3段40號6樓" : generalUser.getgAddress()%>"/>
                <br><br>
                <span hidden>帳號狀態:</span>
                <input type="hidden" id="status" name="status" value="<%= (generalUser==null)? "0" : generalUser.getStatus()%>"/>
                
                <input type="file" id="gProfilePic" name="gProfilePic" onclick="previewImage()" multiple="multiple" />
                <div id="blob_holder"><img src="<%=request.getContextPath()%>/generaluser/DBGifReader?gUserID=${param.gUserID}" width="100px"></div>
                <br>
                
                
                <input type="hidden" name="action" value="update">
				<input type="hidden" name="gUserID" value="<%=generalUser.getgUserID()%>">
                <input type="submit" id="next" value="送出修改" style="width:150px; height:44px;">
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
			var gProfilePic1 = document.getElementById("gProfilePic");
			gProfilePic1.addEventListener("change", function(event) {
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