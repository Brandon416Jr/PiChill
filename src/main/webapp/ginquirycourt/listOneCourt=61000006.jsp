<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.pichill.generaluser.entity.GeneralUser"%>

<%
GeneralUser gUser = (GeneralUser) session.getAttribute("generalUser");
%>

<!DOCTYPE html>
<html lang="zh-Hant">

<head>
<meta charset="UTF-8" />

<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>球館訊息</title>

	<!-- JQuery 連結 -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

    <link rel="stylesheet" href="<%=request.getContextPath()%>/generaluser/CSS/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" />
    <link rel="stylesheet" href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" />
	<link rel="stylesheet" href="<%=request.getContextPath()%>/ginquirycourt/coutinfo_list.css">
    <script src="<%=request.getContextPath()%>/JS/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
	
<%--     <link rel="stylesheet" href="<%=request.getContextPath()%>/ginquirycourt/courtinfo.css"> --%>
    
    <style>
    input{
  	border:0;
  	background-color:#FF9F1B;
  	color:#fff;
  	border-radius:8px;
  	cursor:pointer;
  	position: relative;
  	top: -310px;
  	left: 1030px;
	}
    
    </style>
    
    
</head>
<body>
<!----------------------------------------------- header 區 ------------------------------------------------------->
    <header class="header">
        <div class="container">
            <header class="d-flex flex-wrap justify-content-center py-1">
              <a href="/" class="d-flex align-items-center mb-1 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
                <img src="<%=request.getContextPath()%>/owneruser/pic/headerlogo.svg" alt="SVG" style="width: 180px;"/>     
              </a>
              
              <ul class="nav nav-pills">
                <li class="nav-item"><a href="<%=request.getContextPath()%>/homepage/main.jsp" class="nav-link">首頁</a></li>
                <li class="nav-item"><a href="<%=request.getContextPath()%>/announcement/announcementHome.jsp" class="nav-link">公告</a></li>
                <li class="nav-item"><a href="<%=request.getContextPath()%>/ginquirycourt/all_courtinfo.jsp" class="nav-link">場館資訊</a></li>
                <li class="nav-item"><a href="<%=request.getContextPath()%>/reserveorder/reserveOrder.jsp" class="nav-link">我要預約</a></li>
				<li class="nav-item"><a href="<%=request.getContextPath()%>/post/forum.html" class="nav-link">論壇</a></li>
                <li class="nav-item"><a href="#" class="nav-link"><img src = "<%=request.getContextPath()%>/generaluser/DBGifReader?gUserID=${generalUser.gUserID}" alt="<%=request.getContextPath()%>/NoData/defaultpic.png" class="rounded-circle"/> 會員中心</a></li>
              </ul>

              
            </header>
          </div>
    </header>
<!----------------------------------------------- aside 區 ------------------------------------------------------->
    <div class="main_content">
	    <aside class="aside">
	        <div class="info">
	            <p class="name">新生排球場</p>
	            <p class="name1" style="line-height: 30px">
	                營業時間: 07:00-21:00<br>
	                聯絡電話: (02)2596-6608<br>
	                場館地址: 臺北市中山區復興北路344號3樓<br>
	                球場使用須知:<br>
					（一） 嚴禁攜帶寵物、吸菸、飲酒、嚼食檳榔、口香糖及隨地丟棄垃圾或其他廢棄物。<br>
					（二） 嚴禁使用明火、燃放爆竹煙火等易損傷場地及火災之行為。<br>
					（三） 禁止各種車輛及損壞場地之器材入場。<br>
					（四） 嚴禁具危險性及妨礙他人活動之行為。<br>
					（五） 私人物品應自行保管，本所不負保管之責。<br>
					（六） 非經本所許可，不得於場內設置廣告及設攤。<br>
					（七） 如有違反上述規定，本所得禁止其使用並言詞勸導，<br>
					若不服勸導者，必要時請警察機關協助處理。<br>
	        </div>
	       
		    <img src="<%=request.getContextPath()%>/ginquirycourt/img/6.jpg" alt="JPG" style="weight:300px;height:250px;position: relative;left: 800px;top:-400px"/>
			<br>
			
	        <a href="<%=request.getContextPath()%>/reserveorder/reserveOrder.jsp">
	        	<input type="button" value="我要預約" name="按鈕名稱" style="width:150px; height:44px;" >
	        </a>
	    </aside>
    <!----------------------------------------------- main 區 ------------------------------------------------------->
    <main class="main">
            
        
            
        </div>    
    </main>  
    
    
    
    
    
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
</body>
</html>