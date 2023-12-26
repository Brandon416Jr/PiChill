<%@ page contentType="text/html; charset=UTF-8" pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.pichill.reserveorder.entity.ReserveOrder"%>
<%@ page import="com.pichill.generaluser.entity.*"%>
<%@ page import="com.pichill.owneruser.entity.*"%>
<%@ page import="com.pichill.time.*"%>
<%@ page import="com.pichill.place.*"%>
<%@ page import="com.pichill.court.*"%>


<%
//從資料庫取出的reserveorder, 也可以是輸入格式有錯誤時的reserveorder物件
ReserveOrder reserveOrder = (ReserveOrder) request.getAttribute("reserveOrder");
%>
<%
GeneralUser gUser = (GeneralUser) session.getAttribute("generalUser");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
	<title>reserveOrderList</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/generaluser/CSS/bootstrap.min.css">
  	<link rel="stylesheet" href="<%=request.getContextPath()%>/generaluser/css2/css.css">
  	<link rel="stylesheet" href="<%=request.getContextPath()%>/generaluser/css2/reserve.css">
  	
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
                <li class="nav-item"><a href="<%=request.getContextPath()%>/generaluser/main.jsp" class="nav-link">首頁</a></li>
                <li class="nav-item"><a href="#" class="nav-link">公告</a></li>
                <li class="nav-item"><a href="#" class="nav-link">場館資訊</a></li>
                <li class="nav-item"><a href="<%=request.getContextPath()%>/reserveorder/reserveOrder.jsp" class="nav-link">我要預約</a></li>
                <li class="nav-item"><a href="#" class="nav-link">論壇</a></li>
                <li class="nav-item"><a href="<%=request.getContextPath()%>/generaluser/guserListOne.jsp" class="nav-link"><img src = "<%=request.getContextPath()%>/generaluser/DBGifReader?gUserID=${generalUser.gUserID}" alt="SVG" class="rounded-circle"/> 會員中心</a></li>
              </ul>

            </header>
          </div>
    </header>
    
    
    <!----------------------------------------------- aside 區 ------------------------------------------------------->
    <div class="main_content">
    <aside class="aside">
        <div class="parent_container">
            <h2 class="h6 pt-4 pb-3 mb-4 border-bottom">我要預約</h2>
                <nav class="small" id="toc">
                    <ul class="list-unstyled">
                        <li class="my-2">
                          <a class="step1" href="">Step 1 : 預約</a>
                        </li>
                        <li>&nbsp;</li>
                        <li class="my-2">
                          <a class="step1" href="">Step 2 : 確認預約明細</a>
                        </li>
                        <li>&nbsp;</li>
                        <li class="my-2">
                          <a class="step2" href="">Step 3 : 前往付款</a>
                        </li>
                    </ul>
                </nav>
        </div>
    </aside>
    
    <!----------------------------------------------- main 區 ------------------------------------------------------->
    <main class="main">
        <div class="list">
            <p id="title">ReserveOrder<br>List</p>
            <p id="line"></p>
            <p id="titles">預約明細</p>
            <p id="line2"></p>
            <form class="bararea" enctype="multipart/form-data">
            	<span>預約訂單編號:</span><span id="loc" name="loc" value="${reserveOrder.reserveOrderID}"></span>
                <br><br>
                <span>一般會員編號:</span><span id="loc" name="loc" value="${reserveOrder.generalUser.gUserID}"></span>
                <br><br>
                <span>一般會員姓名:</span><span id="loc" name="loc" value="${reserveOrder.generalUser.gName}"></span>
                <br><br>
                <span>球類:</span><span id="ball" name="ball" value="${reserveOrder.place.ball}"></span>
                <br><br>
                <span>地區:</span><span id="loc" name="loc" value="${reserveOrder.court.loc}"></span>
                <br><br>
                <span>球館:</span><span id="court" name="court" value="${reserveOrder.court.courtName}"></span>
                <br><br>
                <span>場地:</span><span id="place" name="place" value="${reserveOrder.place.placeName}"></span>
                <br><br>
                <span>預約日期:</span><span id="reserveDate" name="reserveDate" value="${reserveOrder.reserveDate}"></span>
                <br><br>
                <span>預約時段:</span><span id="time" name="time" value="${reserveOrder.time.reserveTime}"></span>
                <br><br>
                <span>人數:</span><span id="orderNum" name="orderNum" value="${reserveOrder.orderNum}"></span>
                <p id="line3"></p>
                <span id="total">總金額:</span><span id="totalCost" name="totalCost" value="${reserveOrder.totalCost == reserveOrder.place.placeFee}">&nbsp;&nbsp;元</span>
                <br><br>
                <div class="next1">
                	<input type="hidden" name="action" value="getOneDisplay">
                    <input type="submit" id="next" value="前往付款" style="width:150px; height:44px;">&nbsp;
                    <input type="reset" id="next" value="取消" style="width:150px; height:44px;">
                </div>
            </form>
            
        </div>
        <br><br><br>
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
</body>
</html>