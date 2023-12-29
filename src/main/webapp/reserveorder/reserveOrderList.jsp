<%@ page contentType="text/html; charset=UTF-8" pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<%@ page import="com.pichill.reserveorder.entity.ReserveOrder"%>
<%@ page import="com.pichill.reserveorder.model.*"%>
<%@ page import="com.pichill.reserveorder.service.ReserveOrderService"%>
<%@ page import="com.pichill.generaluser.entity.*"%>
<%@ page import="com.pichill.generaluser.model.*"%>
<%@ page import="com.pichill.generaluser.service.*"%>
<%@ page import="com.pichill.owneruser.entity.*"%>
<%@ page import="com.pichill.time.*"%>
<%@ page import="com.pichill.place.*"%>

<%
GeneralUser gUser = (GeneralUser) session.getAttribute("generalUser");
Integer gUserID = gUser.getgUserID();
pageContext.setAttribute("gUserID",gUserID);
System.out.println(gUserID);
%>

<%
ReserveOrder reserveOrder = (ReserveOrder)session.getAttribute("newReserveOrder");
Integer reserveOrderID = reserveOrder.getReserveOrderID();
ReserveOrderService reserveOrderSvc = new ReserveOrderService();
ReserveOrder reserve = reserveOrderSvc.getOneReserveOrder(reserveOrderID);
pageContext.setAttribute("reserveOrder",reserve);
System.out.println(reserveOrderID);
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
           	<div class="orderlist"> 
            <table>
                <tbody>
                    <tr id="reserveOrderID">
                        <td>預約訂單編號：</td>
                        <td>${reserveOrder.reserveOrderID}</td>
                    </tr>
                    <tr id="gUserID">
                        <td>會員編號：</td>
                        <td>${reserveOrder.generalUser.gUserID}</td>
                    </tr>
                    <tr id="gName">
                        <td>會員姓名：</td>
                        <td>${reserveOrder.generalUser.gName}</td>
                    </tr>
                    <tr id="ball">
                        <td>球類：</td>
                        <td>${reserveOrder.place.ball == 0 ? "籃球" : reserveOrder.place.ball == 1 ? "排球" : "羽球"}</td>
                    </tr>
                    <tr id="loc">
                        <td>地區：</td>
                        <td>${reserveOrder.court.loc}</td>
                    </tr>
                    <tr id="courtName">
                        <td>球館：</td>
                        <td>${reserveOrder.court.courtName}</td>
                    </tr>
                    <tr id="placeName">
                        <td>場地：</td>
                        <td>${reserveOrder.place.placeName}</td>
                    </tr>
                    <tr id="reserveDate">
                        <td>預約日期：</td>
                        <td>${reserveOrder.reserveDate}</td>
                    </tr>
                    <tr id="reserveTime">
                        <td>預約時段：</td>
                        <td>${reserveOrder.timeRef.reserveTime}</td>
                    </tr>
                    <tr id="orderNum">
                      <td>人數：</td>
                      <td>${reserveOrder.orderNum}&nbsp;人</td>
                    </tr>
                    <p id="line3"></p>
                    <tr class="totalcost">
                        <td id="total">總金額：</td>
                        <td id="totalcost">${reserveOrder.totalCost}&nbsp;元</td>
                    </tr>
                </tbody>
            </table>
            </div> 
			<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/reserveorder/reserveorder.do">
                <div>
                	<input type="hidden" name="action" value="">
                	<input type="hidden" name="reserveOrderID" value="${reserveOrder.reserveOrderID}">
                    <input type="submit" id="next1" value="前往付款" style="width:150px; height:44px;">
                </div>
            </FORM>
            
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