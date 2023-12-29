<%@page import="com.pichill.frontstage.place.service.PlaceServiceFront"%>
<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.pichill.court.Court"%>   
<%@ page import="java.util.List"%> 
<%@ page import="com.pichill.owneruser.entity.OwnerUser"%>
<%@ page import="com.pichill.frontstage.court.service.CourtServiceFront"%>
<%@ page import="com.pichill.place.Place"%>
<%
OwnerUser ownerUser = (OwnerUser) session.getAttribute("ownerUser");
System.out.println("ownerUser is " + ownerUser);
Integer oUserID = ownerUser.getoUserID();
System.out.println("oUser is " + oUserID);

%>
<%
//見com.emp.controller.EmpServlet.java第238行存入req的empVO物件 (此為輸入格式有錯誤時的empVO物件)
Court court = (Court) request.getAttribute("court");
CourtServiceFront courtSvcF = new CourtServiceFront();
Integer courtID = court.getCourtID();
System.out.println("courtID = " + courtID);
PlaceServiceFront placeSvcF = new PlaceServiceFront();
Place place = placeSvcF.getOnePlace(courtID);
List<Place> list = placeSvcF.getPlaceByCourt(courtID);
pageContext.setAttribute("list",list);
%>    
 
    
<!DOCTYPE html>
<html lang="zh-Hant">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>場館管理</title>

	<link rel="stylesheet" href="<%=request.getContextPath()%>/owneruser/css1/bootstrap.min.css" media="all" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/owneruser/CSS/css.css" media="all" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/owneruser/CSS/index3.css" media="all" />
   
<!----------------匯入jquery ------------------------>
    <script src="<%=request.getContextPath()%>https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous">
    </script>

    <style>
        img.preview {
            width: 200px;
        }

        ul {
            list-style: none;
            margin: 0;
            padding: 0;
        }

        ul>li {
            display: inline-block;
            vertical-align: top;
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
										<li class="nav-item"><a href="<%=request.getContextPath()%>/owneruser/owneruser.jsp" class="nav-link">  
					<img src="<%=request.getContextPath()%>/owneruser/DBGifReader?oUserID=${ownerUser.oUserID}"  alt="SVG" class="rounded-circle"/>企業會員中心</a></li>
				</ul>

            </header>
        </div>
    </header>
  <!----------------------------------------------- aside 區 ------------------------------------------------------->
    <div class="main_content">
        <aside class="aside">
            <div class="parent_container">
                <h2 class="h6 pt-4 pb-3 mb-4 border-bottom">企業會員中心</h2>
                <nav class="small" id="toc">
                   <ul class="list-unstyled">
                        <li class="my-2">
                         	<form method="POST" action="<%=request.getContextPath()%>/owneruser/owneruser.jsp"> 
                            	<button class="btn d-inline-flex align-items-center collapsed border-0">企業會員資料</button>
                        	</form>
                        </li>
                        <li class="my-2">
                        	<form method="POST" action="<%=request.getContextPath()%>/court/new_court.jsp"> 
                            	<button class="btn d-inline-flex align-items-center collapsed border-0">申請上架球館</button>
                        	</form>
                        </li>
                        <li class="my-2">
                        	<form method="POST" action="<%=request.getContextPath()%>/place/new_place.jsp">
                        		<button class="btn d-inline-flex align-items-center collapsed border-0">申請上架場地</button>
                            </form> 
                        </li>                        
                        <li class="my-2">
                            <form method="POST" action="<%=request.getContextPath()%>/court/all_court.jsp"> 
                            	<button class="btn d-inline-flex align-items-center collapsed border-0">球館管理</button>
                        	</form>
                        </li>
                        <br>
						<li class="my-2">
							<form method="POST" action="<%=request.getContextPath()%>/logoutfo.do"> 
								<button class="btn btn-danger">登出</button>
								<input type="hidden" name="action" value="logout">
							</form>
						</li>
                    </ul>
                </nav>
            </div>
        </aside>

<!----------------------------------------------- main 區 ------------------------------------------------------->
        <main class="main">
            <!-- <div class="row g-3"> -->
                <h2 class="h6 pt-4 pb-3 mb-4 border-bottom">修改球館資訊</h2>
                <!-- <form action="/action_page.php"> -->
        
                <span style="color:#FF0000;  position: relative;left: 250px;">前有
                <img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" width="20" height="20" alt="">為必填項目</span>
<!--             </p> --><br><br>

            <form action="<%=request.getContextPath()%>/court/courtf.do" method="post" enctype="multipart/form-data" style="width: 800px;">
                <img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" width="20" height="20" alt="">
                <label for="courtName">場館名稱</label>
                <input type="text" id="court" name="courtName" 
                value="<%=court.getCourtName()%>" size="45" required>
                <br><br>

                <img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" width="20" height="20" alt="">
                <label  for="time">開館時間</label>
                <input type="time" name="courtOpenTime" value="<%=court.getCourtOpenTime()%>"  min="07:00" max="22:00">

                <img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" width="20" height="20" alt="" style="position: relative; left: 15px;">
                <label style="position: relative; left: 15px;" for="time">閉館時間</label>
                <input type="time"name="courtCloseTime"  value="<%=court.getCourtCloseTime()%>" min="07:00" max="22:00" style="position: relative; left: 15px;"><br><br>

                <img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" width="20" height="20" alt="">
                <label for="loc">區域</label>
                <select name="loc" style="position: relative; left: 31px;">
                    <option>請選擇場館區域</option>
                    <option>中正區</option>
                    <option>大同區</option>
                    <option>中山區</option>
                    <option>松山區</option>
                    <option>大安區</option>
                    <option>萬華區</option>
                    <option>信義區</option>
                    <option>士林區</option>
                    <option>北投區</option>
                    <option>內湖區</option>
                    <option>南港區</option>
                    <option>文山區</option>
                </select>
                <br>
                <br>
                
                <img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" width="20" height="20" alt="">
                <label for="tax_id">場館地址</label>
                <input type="text"  id="tax_id" name="courtAddress" 
                value="<%=court.getCourtAddress()%>" required>
                <font color="#FF0000" size="-1" >包含鄉鎮區、路街道及門牌號等。</font><br><br>

                <img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" width="20" height="20" alt="">
                <label for="phone">場館電話</label>
                <input type="text" id="phone" name="courtTelephone" 
                value="<%=court.getCourtTelephone()%>"  required>
                <font color="#FF0000" size="-1" >包含區域碼 如:02-12345678。</font><br><br>

                <label for="courtRule" style="position: relative; left: 23px;">場館須知</label><br><br>
                <textarea id="subject" name="courtRule"   placeholder="Write something.."style="height:300px;width:600px;position: relative;left:23px;"><%=court.getCourtRule()%></textarea>
                <br><br><br>

                <label for="courtPic" style="position: relative;left: 23px;">場館照片</label><br><br>
                
                <input type="file" name="courtPic" id="picture" onchange="preview()" accept="image/gif, image/jpeg, image/png" style="position: relative;left: 23px;" onclick="previewImage()" class="form-control-file" />
                <br><br>
                <img id="picture"  
                src="<%=request.getContextPath()%>/court/DBJPGReader?courtID=${court.courtID}"
                style="height: 300px;position:relative;left: 23px;"/>

            

				<div>
				<input type="hidden" name="action" value="update">
				<input type="hidden" name="courtID" value="<%=court.getCourtID()%>">
				<input type="submit" value="修改" style="width: 150px; height: 44px;"> 
				</div>
				
            </form>
            <br>

            <label  for="placeFee" style="position: relative;left: 23px;">場地列表</label><br><br>

            <div class="itemTable" style="width: 480px;position: relative;left: 24px; background-color: #DAE4F4;">
                <table id="itemTable">
                    <thead>
                        <tr>
                            <th>場地類型</th>
                            <th>名稱</th>
                            <th>價格</th>
                            
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="place" items="${list}" >
		
			<tr>
		
				<td>${place.placeName}</td>
				<td>${place.placeFee}</td>
				<td>${place.ball}</td>
	
				
			</tr>
		</c:forEach>
                    
                    </tbody>
                </table>
            </div>


         



            <br><br><br><br><br>

            

        </main>
    </div>
   
    <script>
        //------------場館圖片 -------------------
        $("#progressbarTWInput").change(function () {
            readURL(this);
        });

        function readURL(input) {
            if (input.files && input.files[0]) {

                var reader = new FileReader();

                reader.onload = function (e) {

                    $("#preview_progressbarTW_img").attr('src', e.target.result);

                }
                reader.readAsDataURL(input.files[0]);
            }
        }

    </script>



    <!----------------------------------------------- footer 區 ------------------------------------------------------->
    <footer class="footer">

        <div class="container">
            <header class="d-flex flex-wrap justify-content-center py-3">
                 <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
              		<img src ="<%=request.getContextPath()%>/generaluser/pic/footerlogo.svg" alt="SVG"/>     
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
	<script>
	function preview() {

		  var fileInput = $('#picture');
		  var file = fileInput[0].files[0];

		  if(file) { 
		    $("#preview").attr('src', window.URL.createObjectURL(file));
		    $("#blob_holder").hide(); // 隱藏原圖
		  } else {
		    $("#preview").attr('src', "#");  
		    $("#blob_holder").show(); // 顯示原圖
		  }

		}
	</script>
    <script src="<%=request.getContextPath()%>/owneruser/JS/bootstrap.min.js"></script>
</body>

</html>