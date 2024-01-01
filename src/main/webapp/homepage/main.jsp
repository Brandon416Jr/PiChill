<%@ page contentType="text/html; charset=UTF-8" pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.pichill.generaluser.entity.*"%>

<%
//從資料庫取出的owneruser, 也可以是輸入格式有錯誤時的owneruser物件
GeneralUser gUser = (GeneralUser) session.getAttribute("generalUser");
System.out.println("gUser = " + gUser);
// Integer gUserID = gUser.getgUserID();
// System.out.println("gUser is" + gUserID);
%> 
<%
//從資料庫取出的generaluser, 也可以是輸入格式有錯誤時的generaluser物件
GeneralUser generalUser = (GeneralUser) request.getAttribute("generalUser");
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<title>main</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/generaluser/CSS/bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/generaluser/css2/css.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/generaluser/css2/guser.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/generaluser/css2/main.css">
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
            <div class="row row-cols-1 row-cols-md-1 g-1" id="card">
                <div class="col">
                  <div class="card h-100">
						 <img src="<%=request.getContextPath()%>/generaluser/pic/31000009.jpg" class="card-img-top" alt="jpg">
                    <div class="card-body">
                      <h6 class="card-title"><font style="vertical-align: inherit; font-weight: bold;"><font style="vertical-align: inherit;">揪團文章</font></font></h6>
                      <p class="card-text"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"></font><font style="vertical-align: inherit;"></font></font></p>
                      <a href="http://localhost:8081/PiChill/post/forum.html?postID=31000009" class="btn1 btn-primary"><font style="vertical-align: inherit;"><font style="vertical-align: inherit; font-weight: bold; font-size: 14px;">揪Me!</font></font></a>
                    </div>
                  </div>
                </div>
                <div></div>
                <div></div>
                <div></div>
                <div class="col">
                  <div class="card h-100">
						<img src="<%=request.getContextPath()%>/generaluser/pic/31000006.jpg" class="card-img-top" alt="jpg">
                    <div class="card-body">
                        <h6 class="card-title"><font style="vertical-align: inherit; font-weight: bold;"><font style="vertical-align: inherit;">揪團文章</font></font></h6>
                      <p class="card-text"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"></font></font></p>
                      <a href="http://localhost:8081/PiChill/post/forum.html?postID=31000006" class="btn1 btn-primary"><font style="vertical-align: inherit;"><font style="vertical-align: inherit; font-weight: bold; font-size: 14px;">揪Me!</font></font></a>
                    </div>
                  </div>
                </div>
            </div>
        </aside>
      
    <!----------------------------------------------- main 區 ------------------------------------------------------->
    <main class="main">
        <!------ 幻燈片 ------>
        <div id="carouselExampleInterval" class="carousel slide" data-bs-ride="carousel">
            <div class="carousel-inner">
            <div class="carousel-item active" data-bs-interval="2000">
            	<img src="<%=request.getContextPath()%>/generaluser/pic/basketball3.jpg" alt="First slide" width="823" height="300">
            </div>
            <div class="carousel-item" data-bs-interval="2000">
                <img src="<%=request.getContextPath()%>/generaluser/pic/badminton.jpg" alt="Second slide" width="823" height="300">
            </div>
            <div class="carousel-item" data-bs-interval="2000">
                <img src="<%=request.getContextPath()%>/generaluser/pic/volleyball.jpg" alt="Third slide" width="823" height="300">
            </div>
            </div>

            <button class="carousel-control-prev" type="button"
            data-bs-target="#carouselExampleInterval"
            data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden"><font style="vertical-align: inherit"><font style="vertical-align: inherit">以前的</font></font></span>
            </button>

            <button class="carousel-control-next" type="button"
            data-bs-target="#carouselExampleInterval"
            data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden"><font style="vertical-align: inherit"><font style="vertical-align: inherit">下一個</font></font></span>
            </button>
        </div>


        <div class="news">
            <div class="newbor">
            <p class="fresh">公告</p>
                <div class="texts">
                    <br>
                    <span class="text">BOS運動館&emsp;&emsp;羽球場地費用調整價格,使用者反映失衡...</span><a class="see" href="<%=request.getContextPath()%>/homepage/announcement_single.jsp" _blank>> see more</a>
                    <p class="line">&emsp;&emsp;———————————————————————————————————————————</p>
                    <span class="text">陽明籃球館&emsp;&emsp;全國羽球排名賽5月在臺中舉行...</span><a class="see" href="" _blank>> see more</a>
                    <p class="line">&emsp;&emsp;———————————————————————————————————————————</p>
                    <span class="text">TFK羽球館&emsp;&emsp;夏日排球營即將開跑 報名從速...</span><a class="see" href="" _blank>> see more</a>
                    <p class="line">&emsp;&emsp;———————————————————————————————————————————</p>
                    <span class="text">飛龍運動館&emsp;&emsp;臺北市政府體育局啟用新建籃球場...</span><a class="see" href="" _blank>> see more</a><br><br>
                    <br><br>
                    <input type="submit" id="more" value="查看更多" style="width:150px; height:44px;">
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
              <li class="nav-item"><a href="<%=request.getContextPath()%>/homepage/termOfUse/termOfUse.jsp" class="nav-link">使用者條款</a></li>
              <li class="nav-item"><a href="#" class="nav-link"></a></li>
              <li class="nav-item"><a href="<%=request.getContextPath()%>/homepage/privacyPolicy/privacyPolicy.jsp" class="nav-link">隱私權政策</a></li>
              <li class="nav-item"><a href="#" class="nav-link"></a></li>
              <li class="nav-item"><a href="<%=request.getContextPath()%>/homepage/disclaimer/disclaimer.jsp" class="nav-link">免責條款</a></li>
              <li class="nav-item"><a href="#" class="nav-link"></a></li>
              <li class="nav-item"><a href="#" class="nav-link"></a></li>
            </ul>
          </header>
        </div>
      </footer>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>