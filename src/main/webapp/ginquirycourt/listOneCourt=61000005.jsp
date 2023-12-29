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
	            <p class="name">萬華活力球館</p>
	            <p class="name1" style="line-height: 30px">
	                營業時間: 07:00-21:00<br>
	                聯絡電話: (02)41039757<br>
	                場館地址: 臺北市萬華區青年路112號1樓<br>
	                場館須知:<br>
	                本館場地為綜合型比賽場地，租借單位需自行場佈及場復，<br>
	                另為維護場地設備正常使用及提供乾淨舒適的環境。<br>
					本館禁止飲食、吸菸、喝酒、吃檳榔及嚼食口香糖。<br>
					使用者應依各場館（地）屬性，穿著合適之服裝、使用安全無虞之運動用具入場，<br>
					並評估自身狀況，如有不宜運動之相關症候或法定傳染病者謝絕使用。<br>
					使用者自身財物等應自行保管，本場不負保管責任。<br>
					如遇場館（地）無法使用等情事，本場得隨時暫停使用或另行公告。<br>
					違反本規範經勸導仍不改善，本館得立即中止使用權利並令其離場，不得異議，<br>
					並不得要求退還已繳之費用，因此衍生之損害，本場並得請求損害賠償，情節重大者，依法究辦。<br>
					本規範如有未盡事宜，本館得隨時修正之，經場長核定並報府備查後公告實施。<br>
	            </p>
	        </div>
	       
		    <img src="<%=request.getContextPath()%>/ginquirycourt/img/5.jpg" alt="JPG" style="weight:300px;height:250px;position: relative;left: 800px;top:-400px"/>
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