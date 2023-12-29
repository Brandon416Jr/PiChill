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
	            <p class="name">BOS運動館</p>
	            <p class="name1" style="line-height: 30px">
	                營業時間: 07:00-21:00<br>
	                聯絡電話: (02)2362-3776<br>
	                場館地址: 臺北市內湖區港墘路221巷39之1號<br>
	                使用規定：<br>
					1、 進入本球場運動，須穿著運動服及膠底運動鞋，鞋底必須乾淨。<br>
					2、 禁止穿著硬底皮鞋或高跟鞋等，會損壞地板之鞋類進入。<br>
					3、 球場內禁止穿著拖鞋及打赤膊，以維護球場禮節及乾淨，<br>
					並嚴禁攜帶動物及違禁品進入球場。<br>
					4、 本球場除飲用水外，禁止攜帶任何食物及飲料進入，<br>
					並嚴禁嚼食口香糖、檳榔，以維護場內清潔。<br>
					5、 飲用水須用運動水壺或寶特瓶盛裝，並注意飲用，避免大量濺濕地板造成危險。<br>
					6、 本球場嚴禁止燭火，或燃放鞭炮、燃仙女棒、施放煙火等違反公共安全之行為。<br>
					7、 借用本球場辦理活動須鋪設防護地墊，並注意音量不得影響教學，<br>
					如有違反情事，借用單位（人）應負相關責任。<br>
					8、 借用本球場如需其他設施及器材設備（含照明、影音視訊及空調等）<br>
					須事先按規定借用。並於使用後回復原狀，如有損壞須照價賠償。<br>
					9、 本球場禁止塗鴉、劃線，未經許可不得增設標誌、擺設攤位、張貼或懸掛宣傳物品。<br>
					10、 嚴禁在體育館舞台上打球、對牆拍球。<br>
	            </p>
	        </div>
	       
		    <img src="<%=request.getContextPath()%>/ginquirycourt/img/9.jpg" alt="JPG" style="weight:300px;height:250px;position: relative;left: 800px;top:-400px"/>
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