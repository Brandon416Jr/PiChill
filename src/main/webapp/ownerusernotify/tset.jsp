<%@ page contentType="text/html; charset=UTF-8" pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<%@ page import="com.pichill.owneruser.entity.OwnerUser"%>
<%@ page import="com.pichill.reserveorder.entity.ReserveOrder"%>
<%@ page import="com.pichill.reserveorder.model.*"%>
<%@ page import="com.pichill.reserveorder.service.ReserveOrderService"%>
<%@ page import="com.pichill.owneruser.service.OwnerUserService"%>


 <%
  ReserveOrderService reserveOrderSvc = new ReserveOrderService();
     List<ReserveOrder> list = reserveOrderSvc.getAll();
     pageContext.setAttribute("list",list);
%> 
 <%
//  Integer oUserID = 12000001;
//  OwnerUserService ownerUserSvc = new OwnerUserService();
//  OwnerUser owneruser = ownerUserSvc.getOneOwnerUser(oUserID);
//  pageContext.setAttribute("ownerUser",ownerUser);
%> 



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>通知</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/owneruser/css1/bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/owneruser/CSS/css.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/owneruser/CSS/index3.css">
  
      <!---------------datatable------------------------>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">


    <!---------------lightbox ------------------------>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>


    <!----------------匯入jquery ------------------------>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>


    <style>
        /* 自訂 CSS 樣式 */
        td.text-center {
            text-align: center;
        }

        td:nth-child(1) {
            width: 30%;
        }
    </style>
  
  
  
  
  
</head>
<body>

 <!----------------------------------------------- header 區 ------------------------------------------------------->
   <header class="header">
		<div class="container">
			<header class="d-flex flex-wrap justify-content-center py-1">
				<a href="/"
					class="d-flex align-items-center mb-1 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
					<img src="<%=request.getContextPath()%>/owneruser/pic/headerlogo.svg" alt="SVG"/>
				</a>


				<ul class="nav nav-pills">
					<li class="nav-item"><a href="<%=request.getContextPath()%>/homepage/owneruserhome.jsp" class="nav-link">首頁</a></li>
					<li class="nav-item"><a href="<%=request.getContextPath()%>/ownerusernotify/notify.jsp" class="nav-link">通知</a></li>
					<li class="nav-item"><a href="<%=request.getContextPath()%>/post/forumowner.html" class="nav-link">論壇</a></li>
					<li class="nav-item"><a href="<%=request.getContextPath()%>/contactus/addContactUs.jsp" class="nav-link">聯絡我們</a></li>
					<li class="nav-item"><a href="#" class="nav-link"> 
					<img src="<%=request.getContextPath()%>/owneruser/DBGifReader?oUserID=${ownerUser.oUserID}"  alt="SVG" class="rounded-circle"/>企業會員中心</a></li>
				</ul>
			</header>
		</div>
	</header>
      
      
    <!----------------------------------------------- aside 區 ------------------------------------------------------->
    <div class="main_content">
    <aside class="aside">
        <div class="parent_container">
            <h2 class="h6 pt-4 pb-3 mb-4 border-bottom" id="ah6">通知</h2>
                <nav class="small" id="toc">
                    <ul class="list-unstyled">                       
                        <li>&nbsp</li>
                        	<li class="my-2">
							<button
								class="btn d-inline-flex align-items-center collapsed border-0"
								data-bs-toggle="collapse" aria-expanded="false"
								data-bs-target="#contents-collapse"
								aria-controls="contents-collapse">預約通知</button>
						</li>
                    </ul>
                </nav>
        </div>
    </aside>

<!----------------------------------------------- main 區 ------------------------------------------------------->
        <main class="main">
            <br>
            <!--<br>
            <br> -->
            <h2 class="h6 pt-4 pb-3 mb-4 border-bottom">預約消息通知</h2>
            
            <br><br>

            <table id="emailTable" class="display">
                <thead>
                    <tr>
                        <th class="text-center">訊息日期</th> 
                        <th class="text-center">訂單編號</th>
                        <th class="text-center">預約日期</th>
                        <th class="text-center">預約時間</th>
                        <th class="text-center">場次/地別</th>
                        <th class="text-center">預約人數</th>
                        <th class="text-center">預約人姓名</th>
                        <th class="text-center">預約人電話</th>
                        <th class="text-center">查看</th>
                    </tr>
                </thead>
                
                <c:forEach var="reserveOrder" items="${list}" >
                <tbody>
                    <!-- 表格內容 -->
                    <tr>
                    	<td class="text-center">${reserveOrder.orderTime}</td>
                        <td class="text-center">${reserveOrder.reserveOrderID}</td>
                        <td class="text-center">${reserveOrder.reserveDate}</td>
                        <td class="text-center">${reserveOrder.timeID}</td>
                        <td class="text-center">${reserveOrder.placeID}</td>
                        <td class="text-center">${reserveOrder.orderNum}</td>
                        <td class="text-center">${reserveOrder.gUserID}</td>
                        <td class="text-center">${generalUser.gName}</td>
                        <td class="text-center">${generalUser.gTelephone}</td>
                        <td class="text-center">
                            <a href="#emailContentA" data-lightbox="email1" data-title1="信件內容">
                                <i class="fa-solid fa-magnifying-glass" data-email-id="1"></i>
                                <!-- 使用 Font Awesome 圖示 -->
                            </a>
                        </td>
                    </tr>
                
                   
               
               
                    </c:forEach>
                    <!-- 更多的表格內容 -->
                </tbody>
            </table>

            <!-- Lightbox 的內容 -->
            <div id="emailContentA" style="display: none;">
                <p>發送時間：2023-11-21 10:00 AM</p>
                <p>信件主旨：信件主旨範例</p>
                <p>信件內容：這裡是信件的內容...</p>
            </div>
            <div id="emailContentB" style="display: none;">
                <p>發送時間：2023-11-23 14:00 AM</p>
                <p>信件主旨：信件主旨範例</p>
                <p>信件內容：這裡是信件的內容...</p>
            </div>
            <div id="emailContentC" style="display: none;">
                <p>發送時間：2023-11-24 15:00 AM</p>
                <p>信件主旨：信件主旨範例</p>
                <p>信件內容：這裡是信件的內容...</p>
            </div>
            <div id="emailContentD" style="display: none;">
                <p>發送時間：2023-11-27 10:00 AM</p>
                <p>信件主旨：信件主旨範例</p>
                <p>信件內容：這裡是信件的內容...</p>
            </div>
            <div id="emailContentE" style="display: none;">
                <p>發送時間：2023-11-27 10:00 AM</p>
                <p>信件主旨：信件主旨範例</p>
                <p>信件內容：這裡是信件的內容...</p>
            </div>

            <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
            <script src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.js"></script>

        </main>
    </div>
    </div>
    <script>
        $(document).ready(function () {
            // 初始化 DataTables
            $('#emailTable').DataTable({
                "paging": true, // 顯示分頁
                "pageLength": 10, // 每頁顯示10筆資料
                "order": [], // 預設排序設定
                "columnDefs": [{
                    "targets": 'text-center',
                    "className": 'text-center'
                }] // 設定所有欄位文字置中
            });

            // 查看回覆按鈕事件
            $('#emailTable tbody').on('click', 'i.fa-magnifying-glass', function () {
                var emailId = $(this).data('email-id');
                var lightboxName = 'email' + emailId;
                $('#myModal').css('display', 'block');

                // 顯示相對應的 Lightbox 內容
                $('[data-lightbox="' + lightboxName + '"]').click();
            });

            // 關閉模態視窗
            $('.close').click(function () {
                $('#myModal').css('display', 'none');
            });

            // 點擊視窗外區域，關閉模態視窗
            $(window).click(function (e) {
                if (e.target.id === 'myModal') {
                    $('#myModal').css('display', 'none');
                }
            });
        });

    </script>

    <!----------------------------------------------- footer 區 ------------------------------------------------------->
    <footer class="footer">

        <div class="container">
            <header class="d-flex flex-wrap justify-content-center py-3">
                <a href="/"
                    class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
                    <img src="<%=request.getContextPath()%>/owneruser/pic/footerlogo.svg" alt="SVG"/>
                </a>

                <ul class="nav nav-pills">
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


</body>

</html>