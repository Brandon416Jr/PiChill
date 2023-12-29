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
	            <p class="name">TFK羽球館</p>
	            <p class="name1" style="line-height: 30px">
	                營業時間: 07:00-21:00<br>
	                聯絡電話: (02)27814691<br>
	                場館地址: 臺北市信義區林口街117號1樓<br>
	                使用規範:<br>
					1.患有傳染病、心臟病、急性骨骼運動傷害、惡性腫瘤及多發性硬化症、癲癇症、
					<br>意識不清及未經控制之高血壓及糖尿病者，不可從事羽球等激烈運動。<br>
					2.進入本場地地板活動者，需著運動鞋(羽球鞋)，以維護地板品質。<br>
					3.使用本場地各項器材設備時應遵守安全規定，<br>
					教練或指導員得以隨時制止使用者具有安全顧慮之行為，如不聽制止，
					<br>本館得強制使用者離開本場地之權利。<br>
					4.嚴禁吸煙、喝酒、嚼食檳榔、口香糖、攜帶寵物(法令另有規定者除外)、<br>
					雨具及攜帶任何食品進入館內。<br>
					5.公共場所私人物品須自行保管，若有遺失自行負責。<br>
					6.未經許可禁止張貼海報、旗幟、標語等。<br>
					7.未經申請核准者，不得進行私人教學。<br>
					8.違反本規範經勸導仍不改善，本場得立即中止使用權利並令其離場，不得異議，並不得要求退還已繳之費用<br>
	            </p>
	        </div>
	       
		    <img src="<%=request.getContextPath()%>/ginquirycourt/img/8.jpg" alt="JPG" style="weight:300px;height:250px;position: relative;left: 800px;top:-400px"/>
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

