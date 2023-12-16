<%@ page contentType="text/html; charset=UTF-8" pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.pichill.reserveorder.entity.ReserveOrder"%>

<%
	//從資料庫取出的reserveorder, 也可以是輸入格式有錯誤時的reserveorder物件
    ReserveOrder reserveOrder = (ReserveOrder) request.getAttribute("reserveOrder");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
	<title>reserveOrder</title>
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
                          <a class="step2" href="">Step 2 : 確認預約明細</a>
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
    
    <%-- 錯誤表列 --%>
			<c:if test="${not empty errorMsgs}">
				<font style="color:red">請修正以下錯誤:</font>
				<ul>
					<c:forEach var="message" items="${errorMsgs}">
						<li style="color:red">${message}</li>
					</c:forEach>
				</ul>
			</c:if>
	<jsp:useBean id="generalUserSvc" scope="page" class="com.pichill.generaluser.service.GeneralUserService" />	
	<jsp:useBean id="ownerUserSvc" scope="page" class="com.pichill.owneruser.service.OwnerUserService" />	
      
      <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/reserveorder/reserveorder.do" enctype="multipart/form-data" class="choice">
            <br>
            <!-- 選擇一般會員編號 -->
            <div class="col">
              <div class="col" id="choose">
                <label for="country" id="label">選擇一般會員編號</label>
                <select class="form-select" id="ball" name="gUserID">
                <c:forEach var="generalUser" items="${generalUserSvc.all}" > 
		          <option value="${generalUser.gUserID}">${generalUser.gUserID}
		        </c:forEach> 
<!--                   <option value="11000001">11000001</option> -->
<!--                   <option value="11000002">11000002</option> -->
<!--                   <option value="11000003">11000003</option> -->
<!--                   <option value="11000004">11000004</option> -->
<!--                   <option value="11000005">11000005</option> -->
<!--                   <option value="11000006">11000006</option> -->
<!--                   <option value="11000007">11000007</option> -->
<!--                   <option value="11000008">11000008</option> -->
<!--                   <option value="11000009">11000009</option> -->
<!--                   <option value="11000010">11000010</option> -->
                </select>
              </div>
              <br>
            <!-- 選擇企業會員編號 -->
            <div class="col">
              <div class="col" id="choose">
                <label for="country" id="label">選擇企業會員編號</label>
                <select class="form-select" id="loc" name="oUserID">
                  <option value="12000001">12000001</option>
                  <option value="12000002">12000002</option>
                  <option value="12000003">12000003</option>
                  <option value="12000004">12000004</option>
                  <option value="12000005">12000005</option>
                  <option value="12000006">12000006</option>
                  <option value="12000007">12000007</option>
                  <option value="12000008">12000008</option>
                  <option value="12000009">12000009</option>
                  <option value="12000010">12000010</option>
                </select>
              </div>
              <br>
            
              <!-- 預約日期 -->
              <div class="col">
                <p for="reservedate" id="p">預約日期</p>
                <input type="date" id="reservedate" name="reservedate" value="<%=(reserveOrder == null) ? "2023-10-04" : reserveOrder.getReserveDate()%>">
              </div>
        
            <br>
            <!-- 預約時段 -->
            <div class="col">
              <div class="col" id="choose">
                <label for="country" id="label">預約時段</label>
                <select class="form-select" id="time" name="timeID" placeholder="請選擇時段">
                  <option value="0">00:00-01:00</option>
                  <option value="1">01:00-02:00</option>
                  <option value="2">02:00-03:00</option>
                  <option value="3">03:00-04:00</option>
                  <option value="4">04:00-05:00</option>
                  <option value="5">05:00-06:00</option>
                  <option value="6">06:00-07:00</option>
                  <option value="7">07:00-08:00</option>
                  <option value="8">08:00-09:00</option>
                  <option value="9">09:00-10:00</option>
                  <option value="10">10:00-11:00</option>
                  <option value="11">11:00-12:00</option>
                  <option value="12">12:00-13:00</option>
                  <option value="13">13:00-14:00</option>
                  <option value="14">14:00-15:00</option>
                  <option value="15">15:00-16:00</option>
                  <option value="16">16:00-17:00</option>
                  <option value="17">17:00-18:00</option>
                  <option value="18">18:00-19:00</option>
                  <option value="19">19:00-20:00</option>
                  <option value="20">20:00-21:00</option>
                  <option value="21">21:00-22:00</option>
                  <option value="22">22:00-23:00</option>
                  <option value="23">23:00-24:00</option>
                </select>
              </div>
            <br>
              <!-- 選擇場地 -->
            <div class="col">
              <div class="col" id="choose">
                <label for="country" id="label">選擇場地</label>
                <select class="form-select" id="place" name="placeID" required>
                  <option value="62000001">62000001</option>
                  <option value="62000002">62000002</option>
                  <option value="62000003">62000003</option>
                  <option value="62000004">62000004</option>
                  <option value="62000005">62000005</option>
                  <option value="62000006">62000006</option>
                  <option value="62000007">62000007</option>
                  <option value="62000008">62000008</option>
                  <option value="62000009">62000009</option>
                  <option value="62000010">62000010</option>
                </select>
              </div>
              <br>
            <!-- 下單時間 -->
<!--             <div class="col"> -->
<!--               <div class="col" id="choose" hidden> -->
<!--                 <label for="coupon" id="label">下單時間</label><br> -->
<%--                   <input type="text" id="orderTime" name="orderTime" value="${reserveOrder.orderTime}"> --%>
<!--               </div> -->
<!--             <br> -->
            <!-- 人數 -->
            <div class="col">
              <div class="col" id="choose">
                <label for="coupon" id="label">人數</label><br>
                  <input type="text" id="orderNum" name="orderNum" value="<%=(reserveOrder == null) ? "2" : reserveOrder.getOrderNum()%>" placeholder="請輸入預約人數">
              </div>
            <br>
            <!-- 訂單狀態 -->
            <div class="col">
              <div class="col" id="choose">
                <label for="country" id="label">訂單狀態</label>
                <select class="form-select" id="court" name="orderStatus" required>
                  <option value="0">訂單取消</option>
				  <option value="1">訂單成立</option>
				  <option value="2">訂單已完成</option>
                </select>
              </div>
              <br>
            <!-- 訂單總金額 -->  
            <div class="col">
              <div class="col" id="choose">
                <label for="coupon" id="label">訂單總金額</label><br>
                  <input type="text" id="totalCost" name="totalCost" value="<%=(reserveOrder == null) ? "1000" : reserveOrder.getTotalCost()%>" placeholder="請輸入金額">
              </div>
            <br>
            
            <input type="hidden" name="action" value="insert">
<%-- 			<input type="hidden" name="reserveOrderID" value="<%=reserveOrder.getReserveOrderID()%>"> --%>
            <input type="submit" id="next" value="新增" style="width:150px; height:44px;">&nbsp;
            <br><br>
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
</body>
</html>