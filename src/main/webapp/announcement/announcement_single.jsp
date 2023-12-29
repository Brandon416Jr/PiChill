<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.pichill.announcementgetone.model.*"%>
    <%@ page import="java.util.*"%>
<%@ page
	import="com.pichill.announcementgetone.service.AnnouncementGetOneService"%>
<%@ page
	import="com.pichill.announcementgetone.entity.AnnouncementGetOne"%>
	
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <title>generalUser</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/generaluser/CSS/bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/generaluser/css2/css.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/generaluser/css2/main.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/generaluser/css2/announcement.css">
  
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
                <li class="nav-item"><a href="#" class="nav-link"><img src = "<%=request.getContextPath()%>/generaluser/DBGifReader?gUserID=${generalUser.gUserID}" alt="SVG" class="rounded-circle"/> 會員中心</a></li>
              </ul>

              
            </header>
          </div>
    </header>
     <!----------------------------------------------- main 區 ------------------------------------------------------->
	  <main class="main">
	        <div class="news">
	            <div class="newbor">
	            <p class="fresh">公告</p>
	                <div class="texts">
	                    <br>
	                    <div class="words">
	                    <span class="text" id="title1">羽球場地費用調整價格,使用者反映失衡</span>
	                    <br>
	                    <span class="text" id="content">根據政府最新公布的消費者物價指數資料,
	                        近期羽毛球賽用品價格持續飆漲,因此Multiple羽球館經理表示,
	                        他們有計畫在下個月對場地使用收費進行調漲,每小時費用將提高約15%。
	                        消息一出立刻遭到球友的抗議,大家反映漲幅太高,使用意願將大減。</span>  
	                    </div>
	                    <input type="submit" id="next" value="返回" style="width:150px; height:44px;">
	                </div>
	            </div>
	        </div>
	        <br><br>
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
</html>