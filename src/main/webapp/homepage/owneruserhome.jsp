<%@ page contentType="text/html; charset=UTF-8" pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.pichill.owneruser.entity.*"%>
    
   
<%
//從資料庫取出的owneruser, 也可以是輸入格式有錯誤時的owneruser物件
OwnerUser oUser = (OwnerUser) session.getAttribute("ownerUser");
System.out.println("oUser = " + oUser);
Integer oUserID = oUser.getoUserID();
System.out.println("oUser is" + oUserID);
%> 
    
    
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>企業會員首頁</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/owneruser/CSS/style.css">
	
	<link rel="stylesheet" href="<%=request.getContextPath()%>/owneruser/css1/bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/owneruser/CSS/css.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/owneruser/CSS/index3.css">
	
    <style type="text/css">
        .jumbotron {
            padding: 4rem 2rem;
            margin-bottom: 2rem;
            background-color: #DAE4F4;
            border-radius: .3rem;
        	}
       .btn {
	    	background: #FF9F1B;
	    	color: white;
	    	padding: 9px 26px;
	    	border-radius: 20px;
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
                    <img src="<%=request.getContextPath()%>/generaluser/pic/headerlogo.svg" alt="SVG" />
                </a>


                <ul class="nav nav-pills">
                    <li class="nav-item"><a href="<%=request.getContextPath()%>/homepage/owneruserhome.jsp" class="nav-link">首頁</a></li>
                    <li class="nav-item"><a href="<%=request.getContextPath()%>/ownerusernotify/notify.jsp" class="nav-link">通知</a></li>
                    <li class="nav-item"><a href="#" class="nav-link">論壇</a></li>
                    <li class="nav-item"><a href="#" class="nav-link">聯絡我們</a></li>
                    <li class="nav-item"><a href="<%=request.getContextPath()%>/owneruser/owneruser.jsp" class="nav-link"><img src = "<%=request.getContextPath()%>/owneruser/DBGifReader?oUserID=${ownerUser.oUserID}" alt="SVG" class="rounded-circle"/>會員中心</a></li>
              	</ul>
                

            </header>
        </div>
    </header>
 <!---------------------- 中間區域1 ------------------------->
    <section id='intro'>
        <div class="jumbotron">
            <div class="container">
                <div class='row'>
                    <div class='col-md-12'>

                        <h1>企業會員您好</h1>
                        <p>想更加有效化利用球館?&emsp;想讓更多人看見自己?</p>
                        <a class='btn' href="<%=request.getContextPath()%>/court/new_court.jsp">上架球館</a>

                    </div>
                </div>
            </div>
        </div>
    </section>

    <br>



    <!---------------------- 中間區域2 ------------------------->
    <div class="wrap">
        <!-- item 1  -->
        <div class="item">
            <div class="pic">
                <img
                    src="https://plus.unsplash.com/premium_photo-1661414415246-3e502e2fb241?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D">
            </div>
            <div class="txt">
                <h2>成為π Chill 企業會員的好處</h2>
                <P>π Chill為您提供上架場館的平台</P>
                <p>從管理線上預約、金流支付、到推廣活動</p>
                <p>π Chill能做得比您想像的更多</p>
            </div>
        </div>

        <!-- item 2  -->
        <div class="item">
            <div class="txt">
                <h2>場地不被看見?</h2>
                <p>為您提供場地亮相的機會!</p>
            </div>
            <div class="pic">
                <img
                    src="https://images.unsplash.com/photo-1577416412292-747c6607f055?auto=format&fit=crop&q=80&w=2070&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D">
            </div>
        </div>

        <!-- item 3  -->
        <div class="item">
            <div class="pic">
                <img
                    src="https://images.unsplash.com/photo-1553729459-efe14ef6055d?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D">
            </div>
            <div class="txt">
                <h2>增加場館營收</h2>
                <p>顧客預約場館，立即線上線上支付</p>
                <p>顧客經營者不怕收不到錢</p>
            </div>
        </div>
        <!-- item 4  -->
        <div class="item">
            <div class="txt">
                <h2>和消費者總有距離...</h2>
                <p>我們提供論壇區</p>
                <p>增加彼此互動，可以隨時發布貼文</p>
            </div>
            <div class="pic">
                <img
                    src="https://images.unsplash.com/photo-1513757378314-e46255f6ed16?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D">
            </div>
        </div>
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