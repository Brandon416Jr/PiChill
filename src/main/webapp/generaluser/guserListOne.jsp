<%@ page contentType="text/html; charset=UTF-8" pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.pichill.generaluser.entity.*"%>
<%@ page import="com.pichill.generaluser.service.*"%>
<%@ page import="com.pichill.reserveorder.entity.*"%>
<%@ page import="com.pichill.reserveorder.service.*"%>

<%--<% 
//從資料庫取出的generaluser, 也可以是輸入格式有錯誤時的generaluser物件
GeneralUser generalUser = (GeneralUser) request.getAttribute("generalUser");
%> --%>

<%
GeneralUser gUser = (GeneralUser) session.getAttribute("generalUser");
%>
<%-- <%
 Integer gUserID = 11000001;
 GeneralUserService generalUserSvc = new GeneralUserService();
 GeneralUser generalUser = generalUserSvc.getOneGeneralUser(gUserID);
 pageContext.setAttribute("generaluser",generalUser);
%>--%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<title>guserListOne</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/generaluser/CSS/bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/generaluser/css2/css.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/generaluser/css2/guser.css">
	
</head>
<!----------------------------------------------- header 區 ------------------------------------------------------->
    <header class="header">
        <div class="container">
            <header class="d-flex flex-wrap justify-content-center py-1">
              <a href="/" class="d-flex align-items-center mb-1 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
                <img src = "<%=request.getContextPath()%>/generaluser/pic/headerlogo.svg" alt="SVG"/>     
              </a>
              
            
              <ul class="nav nav-pills">
                <li class="nav-item"><a href="main.jsp" class="nav-link" id="head">首頁</a></li>
                <li class="nav-item"><a href="#" class="nav-link" id="head">公告</a></li>
                <li class="nav-item"><a href="#" class="nav-link" id="head">場館資訊</a></li>
                <li class="nav-item"><a href="<%=request.getContextPath()%>/reserveorder/reserveOrder.jsp" class="nav-link" id="head">我要預約</a></li>
                <li class="nav-item"><a href="#" class="nav-link" id="head">論壇</a></li>
                <li class="nav-item"><a href="<%=request.getContextPath()%>/generaluser/select_page.jsp" class="nav-link" id="heads"><img src = "<%=request.getContextPath()%>/generaluser/DBGifReader?gUserID=${generalUser.gUserID}" alt="SVG" class="rounded-circle"/> 會員中心</a></li>
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
                        <li>&nbsp</li>
                        <li class="my-2">
                          <a class="asidearea" href="<%=request.getContextPath()%>/reserveorder/listOneOrder.jsp">球館預約紀錄</a>                         
                        </li>
                        <li>&nbsp</li>
                        <li class="my-2">
                          <a class="asidearea" href="">聯絡我們</a>                         
                        </li>
                        <li>&nbsp</li>
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

            
                <span>會員編號:</span>
                <input type="text" id="guserID" name="guserID" value="${generalUser.gUserID}" disabled>
                <br><br>
                <span>姓名:</span>
                <input type="text" id="gName" name="gName" value="${generalUser.gName}" disabled>
                <br><br>
                <span>帳號:</span>
                <input type="text" id="gUsername" name="gUsername" value="${generalUser.gUsername}" disabled>
                <br><br>
                <span>密碼:</span>
                <input type="text" id="gPassword" name="gPassword" value="${generalUser.gPassword}" disabled>
                <br><br>
                <span>暱稱:</span>
                <input type="text" id="nicknameID" name="nicknameID" value="${generalUser.nicknameID}" disabled>
                <br><br>
                <span>電子信箱:</span>
                <input type="email" id="gEmail" name="gEmail" value="${generalUser.gEmail}" disabled>
                <br><br>
                <span>身分證字號:</span>
                <input type="text" id="gIDNum" name="gIDNum" value="${generalUser.gIDNum}" disabled>
                <br><br>
                <span>性別:</span>
                <input type="text" id="gGender" name="gGender" value="${generalUser.gGender == 0 ? '男':'女'}" disabled>
                <br><br>
                <span>出生年月日:</span>
                <input type="text" id="gBirth" name="gBirth" value="${generalUser.gBirth}" disabled>
                <br><br>
                <span>手機號碼:</span>
                <input type="text" id="gTelephone" name="gTelephone" value="${generalUser.gTelephone}" disabled>
                <br><br>
                <span>聯絡地址:</span>
                <input type="text" id="gAddress1" name="gAddress" value="${generalUser.gAddress}" disabled>
                <br><br>
                <span hidden>帳號狀態:</span>
                <input type="hidden" id="status" name="status" value="${generalUser.status == 0 ? 'normal' : '討論版停權'}" disabled>
                
                <span>大頭貼:</span><br>
                <input type="file" id="gProfilePic" name="gProfilePic" previewImage() multiple="multiple" hidden/>
                <img src="<%=request.getContextPath()%>/generaluser/DBGifReader?gUserID=${generalUser.gUserID}" width="100px">
                <br>
                
            <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/generaluser/generaluser.do" enctype="multipart/form-data" class="bararea">  
                <input type="hidden" name="action" value="getOne_For_Update">
				<input type="hidden" name="gUserID" value="${generalUser.gUserID}">
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
			var gProfilePic1 = document.getElementById("gProfilePic");
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