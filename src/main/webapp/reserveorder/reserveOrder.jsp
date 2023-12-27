<%@ page contentType="text/html; charset=UTF-8" pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.pichill.reserveorder.entity.ReserveOrder"%>
<%@ page import="com.pichill.reserveorder.service.ReserveOrderService"%>
<%@ page import="com.pichill.generaluser.entity.*"%>
<%@ page import="com.pichill.generaluser.service.*"%>
<%@ page import="com.pichill.owneruser.entity.*"%>
<%@ page import="com.pichill.time.*"%>
<%@ page import="com.pichill.place.*"%>
<%@ page import="com.pichill.court.*"%>

<%
GeneralUser gUser = (GeneralUser) session.getAttribute("generalUser");
Integer gUserID = gUser.getgUserID();
// ReserveOrderService reserveOrderSvc = new ReserveOrderService();
// List<ReserveOrder> list = reserveOrderSvc.getgUserID(gUserID);
// pageContext.setAttribute("list",list);
pageContext.setAttribute("gUserID",gUserID);
%>
<% 
//從資料庫取出的reserveorder, 也可以是輸入格式有錯誤時的reserveorder物件
ReserveOrder reserveOrder = (ReserveOrder) request.getAttribute("reserveOrder");
 %>
<%--<%
//GeneralUser gUser = (GeneralUser) session.getAttribute("generalUser");
//Integer gUserID = gUser.getgUserID();
%>--%>

<%--<%
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
    
	<title>reserveOrder</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/generaluser/CSS/bootstrap.min.css">
  	<link rel="stylesheet" href="<%=request.getContextPath()%>/generaluser/css2/css.css">
  	<link rel="stylesheet" href="<%=request.getContextPath()%>/generaluser/css2/reserve.css">
  	
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
	
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
  		
      <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/reserveorder/reserveorder.do" class="choice" id="myForm">
            <br>
            <br><br>
            <!-- 選擇球類 -->
            <div class="col">
              <div class="col" id="choose">
                <label for="ball" id="ballLabel">選擇球類</label>
                <select class="form-select" id="ball" name="ball" onclick="updateRegions()">
<%-- 	                <c:forEach var="place" items="${placeSvc.all}"> --%>
<%-- 					  <option value="${reserveOrder.place.placeID}" ${(reserveOrder.param.placeID == reserveOrder.place.placeID)? 'selected':'' } >${reserveOrder.place.ball == 0 ? "籃球" : place.ball == 1 ? "排球" : "羽球"} --%>
<%-- 				    </c:forEach> --%>
                  <option value="0">籃球</option>
                  <option value="1">排球</option>
                  <option value="2">羽球</option>
                </select>
              </div>
              <br>
            <!-- 選擇地區 -->
            <div class="col">
              <div class="col" id="choose">
                <label for="loc" id="locLabel">選擇地區</label>
                <select class="form-select" id="loc" name="loc" disabled onclick="updateCourts()">
                <option value="">請先選擇球類</option>
<!--                   <option value="">松山區</option> -->
<!--                   <option>中正區</option> -->
<!--                   <option>中山區</option> -->
                </select>
              </div>
              <br>
            <!-- 選擇球館 -->
            <div class="col">
              <div class="col" id="choose">
                <label for="court" id="courtLabel">選擇球館</label>
                <select class="form-select" id="courtName" name="courtName" disabled onclick="updatePlaces()">
                <option value="">請先選擇地區</option>
<%--                 	<c:forEach var="court" items="${courtSvc.all}"> --%>
<%-- 				  	  <option value="${court.courtID}" ${(param.courtID==court.courtID)? 'selected':'' } >${court.courtName} --%>
<%-- 			    	</c:forEach> --%>
                </select>
              </div>
              <br>
              <!-- 選擇場地 -->
            <div class="col">
              <div class="col" id="choose">
                <label for="place" id="placeLabel">選擇場地</label>
                <select class="form-select" id="placeName" name="placeName" disabled>
                <option value="">請先選擇球館</option>
<%-- 	                <c:forEach var="place" items="${placeSvc.all}"> --%>
<%-- 					  <option value="${place.placeID}" ${(param.placeID==place.placeID)? 'selected':'' } >${place.placeName} --%>
<%-- 				    </c:forEach> --%>
                </select>
              </div>
              <br>
            <!-- 預約日期 -->
              <div class="col">
                <p for="reservedate" id="p">預約日期</p>
                <input type="date" id="reserveDate" name="reserveDate" value="${reserveOrder.reserveDate}">
              </div>
        
            <br>
            <!-- 預約時段 -->
            <div class="col">
              <div class="col" id="choose">
                <label for="time" id="label">預約時段</label>
                <select class="form-select" id="timeID" name="timeID" placeholder="請選擇預約時段">
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
<%-- 	                <c:forEach var="time" items="${timeSvc.all}"> --%>
<%-- 					  <option value="${time.timeID}" ${(param.timeID==time.timeID)? 'selected':'' } >${time.reserveTime} --%>
<%-- 				    </c:forEach> --%>
                </select>
              </div>
            <br>
            <!-- 人數 -->
            <div class="col">
              <div class="col" id="choose">
                <label for="orderNum" id="label">人數</label><br>
                  <input type="text" id="orderNum" name="orderNum" placeholder="請輸入預約人數" value="${reserveOrder.orderNum}">
              </div>
            <br>
            <!-- 總金額(這頁不顯示) -->
            <div class="col" hidden>
              <div class="col" id="choose">
                <label for="totalCost" id="label">總金額</label><br>
                  <input type="text" id="totalCost" name="totalCost" value="${reserveOrder.place.placeFee}">
              </div>
            </div>  
            <br>
            
            <input type="hidden" name="action" value="insert">
<%-- 			<input type="hidden" name="reserveOrderID" value="<%=reserveOrder.getReserveOrderID()%>"> --%>
            <input type="submit" id="next" value="下一步" style="width:150px; height:44px;">&nbsp;
            <input type="reset" id="next" value="取消" style="width:150px; height:44px;" onclick="resetForm()">
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
      
// ========================================================================================== //    
<script>
function updateRegions() {
  // 獲取球類選擇框的值
  var selectedBall = document.getElementById("ball").value;

  // 獲取地區選擇框
  var locSelect = document.getElementById("loc");

  // 清空地區選擇框的選項
  locSelect.innerHTML = "";

  // 根據球類選擇框的值動態添加地區選項
  if (selectedBall === "0") {
    // 如果是籃球，只有北投區和南港區可以選
    addOption(locSelect, "北投區");
    addOption(locSelect, "南港區");
  } else if (selectedBall === "1") {
    // 如果是排球，可以添加其他地區的選項
    addOption(locSelect, "中正區");
    addOption(locSelect, "萬華區");
    addOption(locSelect, "中山區");
    addOption(locSelect, "內湖區");
  } else if (selectedBall === "2") {
    // 如果是羽球，可以添加其他地區的選項
    addOption(locSelect, "大安區");
    addOption(locSelect, "大同區");
    addOption(locSelect, "中山區");
    addOption(locSelect, "信義區");
  }

  // 啟用地區選擇框
  locSelect.disabled = false;
}

function addOption(select, value) {
  var option = document.createElement("option");
  option.value = value;
  option.text = value;
  select.add(option);
  console.log("aaa");
}

// ========================================================================================== //
function updateCourts() {
  // 獲取地區選擇框的值
  var selectedLoc = document.getElementById("loc").value;

  // 獲取球館選擇框
  var courtSelect = document.getElementById("courtName");

  // 清空球館選擇框的選項
  courtSelect.innerHTML = "";

  // 獲取球類選擇框的值
  var selectedBall = document.getElementById("ball").value;

  // 根據地區選擇框的值動態添加球館選項
  if (selectedLoc === "大安區") {
    // 如果是北投區，只有陽明籃球館可以選
    addOption1(courtSelect, "飛龍運動館");
  } else if (selectedLoc === "中正區") {
    addOption1(courtSelect, "中正排球場");
  }else if (selectedLoc === "北投區") {
    addOption1(courtSelect, "陽明籃球館");
  }else if (selectedLoc === "大同區") {
    addOption1(courtSelect, "奧特菲羽球館");
  }else if (selectedLoc === "萬華區") {
    addOption1(courtSelect, "萬華活力球館");
  }else if (selectedLoc === "信義區") {
    addOption1(courtSelect, "TFK羽球館");
  }else if (selectedLoc === "南港區") {
    addOption1(courtSelect, "BOS運動館");
  }else if (selectedLoc === "內湖區") {
    addOption1(courtSelect, "艾特極運動生活館");
  }else if (selectedLoc === "中山區" && selectedBall === "1") {
    addOption1(courtSelect, "新生排球場");
  }else if (selectedLoc === "中山區" && selectedBall === "2") {
    addOption1(courtSelect, "紅季羽球綜合館");
  }
  

  // 啟用球館選擇框
  courtSelect.disabled = false;
}

function addOption1(select, value) {
  var option = document.createElement("option");
  option.value = value;
  option.text = value;
  select.add(option);
  console.log("bbb");
}

// =============================================================================== //

function updatePlaces() {
  // 獲取球館選擇框的值
  var selectedCourt = document.getElementById("courtName").value;

// 獲取場地選擇框
  var placeSelect = document.getElementById("placeName");

 // 獲取地區選擇框的值
 var selectedLoc = document.getElementById("loc").value;

 // 獲取球類選擇框的值
 var selectedBall = document.getElementById("ball").value;

// 清空場地選擇框的選項
  placeSelect.innerHTML = "";


// 根據球館的值動態添加場地選項

if (selectedCourt === "飛龍運動館") {
    // 如果是飛龍運動館，只有A場地可選
  addOption2(placeSelect, "A場地");
} else if(selectedCourt === "中正排球場") {
  addOption2(placeSelect, "B場地");
}else if(selectedCourt === "奧特菲羽球館") {
  addOption2(placeSelect, "C場地");
}else if(selectedCourt === "陽明籃球館") {
  addOption2(placeSelect, "D場地");
}else if(selectedCourt === "萬華活力球館") {
  addOption2(placeSelect, "E場地");
}else if(selectedCourt === "新生排球場") {
  addOption2(placeSelect, "A場地");
}else if(selectedCourt === "紅季羽球綜合館") {
  addOption2(placeSelect, "B場地");
}else if(selectedCourt === "TFK羽球館") {
  addOption2(placeSelect, "C場地");
}else if(selectedCourt === "BOS運動館") {
  addOption2(placeSelect, "D場地");
}else if(selectedCourt === "艾特極運動生活館") {
  addOption2(placeSelect, "E場地");
}


  // 啟用場地選擇框
  placeSelect.disabled = false;

}

function addOption2(select, value) {
  var option = document.createElement("option");
  option.value = value;
  option.text = value;
  select.add(option);
  console.log("ccc");
}

$(document).ready(function() {
  $("#next").on("click", function() {
    // 獲取所有需要的值
    var selectedBall = $("#ball").val();
    var selectedLoc = $("#loc").val();
    var selectedCourt = $("#courtName").val();
    var selectedPlace = $("#placeName").val();
    var reserveDate = $("#reserveDate").val();
    var selectedTime = $("#timeID").val();
    var orderNum = $("#orderNum").val();
    var totalCost = $("#totalCost").val();

    // 使用 AJAX 發送 POST 請求
    $.ajax({
      action: "insert",
      type: "POST",
      url: "http://localhost:8081/PiChill/reserveorder/reserveorder.do",  // 你的後端端點
      data: {
        "ball": selectedBall,
        "loc": selectedLoc,
        "courtName": selectedCourt,
        "placeName": selectedPlace,
        "reserveDate": reserveDate,
        "timeID": selectedTime,
        "orderNum": orderNum,
        "totalCost": totalCost
      },
      dataType: "json",
      success: function(response) {
        // 處理成功回應
        console.log("訂單新增成功！");
      },
      error: function(error) {
        // 處理錯誤回應
        console.error("發生錯誤: ", error);
      }
    });
  });
});

</script>

</body>
</html>