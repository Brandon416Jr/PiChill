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
    <link rel="stylesheet" href="<%=request.getContextPath()%>/generaluser/css2/css.css">
 	
   
     <link rel="stylesheet" href="<%=request.getContextPath()%>/generaluser/CSS/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" />
    <link rel="stylesheet" href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" />

	    <link rel="stylesheet" href="<%=request.getContextPath()%>/ginquirycourt/courtinfo.css">

		<link rel="stylesheet" href="<%=request.getContextPath()%>/ginquirycourt/coutinfo_list.css">
			<link rel="stylesheet" href="<%=request.getContextPath()%>/generaluser/css2/guser.css">
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
  	Bottom: 400px;
  	left: 1030px;
	}
	aside.aside{
    width: 900px;
    height:850px;
    display: inline-block;
    vertical-align: top;
    font-size: 1rem;
    margin-right: 10px;
    /* border: 1px solid green; */
}
    
    </style>
    
    
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
                <li class="nav-item" id="head"><a href="<%=request.getContextPath()%>/homepage/main.jsp" class="nav-link">首頁</a></li>
                <li class="nav-item" id="head"><a href="<%=request.getContextPath()%>/announcement/announcementHome.jsp" class="nav-link">公告</a></li>
                <li class="nav-item" id="head"><a href="<%=request.getContextPath()%>/ginquirycourt/all_courtinfo.jsp" class="nav-link">場館資訊</a></li>
                <li class="nav-item" id="head"><a href="<%=request.getContextPath()%>/reserveorder/reserveOrder.jsp" class="nav-link">我要預約</a></li>
                <li class="nav-item" id="head"><a href="<%=request.getContextPath()%>/post/forum.html" class="nav-link">論壇</a></li>
                <li class="nav-item" id="head1"><a href="<%=request.getContextPath()%>/generaluser/guserListOne.jsp" class="nav-link">
                <img src = "<%=request.getContextPath()%>/generaluser/DBGifReader?gUserID=${generalUser.gUserID}" alt="SVG" class="rounded-circle"/> 會員中心</a></li>
                
              </ul>
              
            </header>
          </div>
    </header>
<!----------------------------------------------- aside 區 ------------------------------------------------------->
    <div class="main_content">
	    <aside class="aside">
	        <div class="info">
	            <p class="name">陽明籃球館</p>
	            <p class="name1" style="line-height: 30px">
	                營業時間: 07:00-21:00<br>
	                聯絡電話: (02)41039755<br>
	                場館地址: 臺北市北投區義理街2號<br>
	                本館使用須知:<br>
					◾使用完畢後借用單位須自行恢復場地原狀；場地及設備如有損壞，則照價賠償<br>
					◾本館禁止飲食、吸菸、喝酒、吃檳榔及嚼食口香糖。<br>
					◾禁止攜帶寵物(法令另有規定者，不在此限)及雨具進入。<br>
					◾若有以下情形之一，禁止使用本設備：（1）患有傳染性疾病者。<br>
					（2）飯後一小時內、血壓過低、酒後、嚴重睡眠不足時或其他任何身體不適者。<br>
					（3）患有高血壓、糖尿病、心臟病等，於生理或心理狀態不適宜入場使用之情形者。<br>
					◾必須穿著運動服裝及運動鞋進入場地，禁止穿著拖鞋、皮鞋、高跟鞋、<br>
					木屐或其他不合場地使用規定之鞋類進入。<br>
					◾應於場地租借時間內使用，如非租用時間禁止擅自進入使用。<br>
					◾使用館內場地時，請注意使用時間，勿超時佔用，尊重下一位使用者的權利。<br>
					◾個人貴重物品、財務請自行妥善保管，若遺失本館恕不負責。<br>
					◾未經許可，禁止照相、攝影、錄音、張貼或懸掛海報、旗幟、標語等。<br>
					◾館內插座不提供給個人使用。 如因活動或租借場地，需先付費後方能使用。<br>
					◾場內設施請愛惜使用，嚴禁攜帶刀片、利器等異物入場以免破壞場地設施，<br>
					不得隨意移動籃球框架等球場設施。如不當使用或蓄意破壞而造成設施毀損時，應負損害賠償責任。<br>
					◾本須知如有未盡事宜，得另行增列、修訂之，並以現場公告或工作人員說明為準。<br>
					若未能配合管理者，現場工作人員將有權令其離場，以維護其他使用者的安全。<br><br><br>
	            </p>
	        </div>
	       
		    <img src="<%=request.getContextPath()%>/ginquirycourt/img/4.jpg" alt="JPG" style="weight:300px;height:250px;position: relative;left: 800px;top:-650px"/>
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