<%@page import="com.pichill.owneruser.entity.OwnerUser"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="com.pichill.court.*"%>
<%@ page import="com.pichill.place.*"%>
<%@ page import="java.util.Date" %>
    
 <%
//見com.emp.controller.EmpServlet.java第238行存入req的empVO物件 (此為輸入格式有錯誤時的empVO物件)
Court court = (Court) request.getAttribute("court");
%>   
    

    

<%
OwnerUser ownerUser = (OwnerUser) session.getAttribute("ownerUser");
System.out.println(ownerUser);
%> 

    
<!DOCTYPE html>
<html lang="zh-Hant">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>企業會員-申請上架球館</title>
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
        .phone1 {
		width: 200px;
		height: 200px;
		background-image: url('img_flowers.jpg');
		background-repeat: no-repeat;
		background-size: contain;
		/* border: 1px solid red; */
		position: absolute;
		right: 100px;
		/* z-index: -1; */
		}
		input[type="courtAddress"] {
	  	cursor: pointer;
	  	width: 450px;
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
                    <img src="<%=request.getContextPath()%>/owneruser/pic/headerlogo.svg" alt="SVG" />
                </a>

			    <ul class="nav nav-pills">
			     <li class="nav-item"><a href="<%=request.getContextPath()%>/homepage/owneruserhome.jsp" class="nav-link">首頁</a></li>
			     <li class="nav-item"><a href="<%=request.getContextPath()%>/ownerusernotify/notify.jsp" class="nav-link">通知</a></li>
			     <li class="nav-item"><a href="<%=request.getContextPath()%>/post/forumowner.html" class="nav-link">論壇</a></li>
			     <li class="nav-item"><a href="<%=request.getContextPath()%>/contactus/addContactUs.jsp" class="nav-link">聯絡我們</a></li>
			     <li class="nav-item"><a href="<%=request.getContextPath()%>/testoUser/ouserlistOne.jsp" class="nav-link"> 
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
                         	<form method="POST" action="<%=request.getContextPath()%>/testoUser/ouserlistOne.jsp"> 
                            	<button class="btn d-inline-flex align-items-center collapsed border-0">企業會員資料</button>
                        	</form>
                        </li>
                        <li class="my-2">
                        	<form method="POST" action="<%=request.getContextPath()%>/testCourt/new_court.jsp"> 
                            	<button class="btn d-inline-flex align-items-center collapsed border-0">申請上架球館</button>
                        	</form>
                        </li>
                        <li class="my-2">
                        	<form method="POST" action="<%=request.getContextPath()%>/testCourt/new_place.jsp">
                        		<button class="btn d-inline-flex align-items-center collapsed border-0">申請上架場地</button>
                            </form> 
                        </li>                        
                        <li class="my-2">
                            <form method="POST" action="<%=request.getContextPath()%>/testCourt/all_court.jsp"> 
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
                <h2 class="h6 pt-4 pb-3 mb-4 border-bottom">申請上架球館</h2>
                <!-- <form action="/action_page.php"> -->
        
        	<div>
                <span style="color:#FF0000;  position: relative;left: 250px;">前有
                <img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" width="20" height="20" alt="">為必填項目</span>
       		</div>
           		<br>
           		
			<div class="error">
				<%-- 錯誤表列 --%>
					<c:if test="${not empty errorMsgs}">
						<font style="color: red">請修正以下錯誤:</font>
						  <ul style="list-style-type: none">
							<c:forEach var="message" items="${errorMsgs}">
								<li style="color: red">${message}</li>
							</c:forEach>
						  </ul>
					</c:if>
			</div>
						
			<br>
			<form action="${pageContext.request.contextPath }/court/courtf.do"
			 METHOD="post"	enctype="multipart/form-data">
			
            
                <img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" width="20" height="20" alt="">
                <label for="courtName">場館名稱</label>
                <input type="text" id="court" name="courtName" 
                value="<%=(court == null)? "" :court.getCourtName()%>" size="45" required>
                <br><br>

                <img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" width="20" height="20" alt="">
                <label  for="time">開館時間</label>
                <input type="time" value="<%=(court==null)? "09:00:00" : court.getCourtOpenTime()%>"  min="09:00" max="18:00" name="courtOpenTime">

                <img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" width="20" height="20" alt="" style="position: relative; left: 15px;">
                <label style="position: relative; left: 15px;" for="time">閉館時間</label>
                <input type="time" value="<%=(court==null)? "21:00:00" :court.getCourtCloseTime()%>" style="position: relative; left: 15px;" name="courtCloseTime">
                <br><br>

                <img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" width="20" height="20" alt="">
                <label for="loc">區域</label>
                <input type="text" value="<%=(court==null)? "" :court.getLoc()%>" style="position: relative; left: 31px;" name="loc">
                <font color="#FF0000" size="-1"  style="position: relative;;left: 30px;">如:中正區</font>
                
<!--                 <select style="position: relative; left: 31px;"> -->
<!--                     <option>請選擇場館區域</option> -->
<!--                     <option>中正區</option> -->
<!--                     <option>大同區</option> -->
<!--                     <option>中山區</option> -->
<!--                     <option>松山區</option> -->
<!--                     <option>大安區</option> -->
<!--                     <option>萬華區</option> -->
<!--                     <option>信義區</option> -->
<!--                     <option>士林區</option> -->
<!--                     <option>北投區</option> -->
<!--                     <option>內湖區</option> -->
<!--                     <option>南港區</option> -->
<!--                     <option>文山區</option> -->
<!--                 </select> -->
                <br>
                <br>
                
                <img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" width="20" height="20" alt="">
                <label for="tax_id">場館地址</label>
                <input type="text" id="tax_id" name="courtAddress" 
                value="<%=(court == null)? "" : court.getCourtAddress()%>" style="width: 300px" required>
                <font color="#FF0000" size="-1" style="position: relative;left: 1px; ">包含鄉鎮區、路街道及門牌號等。</font><br><br>

                <img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" width="20" height="20" alt="">
                <label for="phone">場館電話</label>
                <input type="text" id="text" name="courtTelephone" value="<%=(court == null)? "" : court.getCourtTelephone()%>"  required>
<!--                 <font color="#FF0000" size="-1" nowrap="" style="position: relative;left: 1px;">包含區域碼 如:0212345678。</font> -->
                <br><br>

                <img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" width="20" height="20" alt="">
                <label for="courtRule" style="position: relative; ">場館須知</label><br><br>
<%--                 <input type="hidden" id="courtRule" name="courtRule" value="<%=(court ==null)? "" :court.getCourtRule()%>" > --%>
                 <textarea name="CourtRule" id="courtRule" placeholder="Write something.."style="height:300px;width:600px;position: relative;left:23px;" required><%=(court == null) ? "請輸入內文" : court.getCourtRule()%></textarea>
                
                <script type="text/javascript">
                	function changeText(){
                		document.getElementById().value=document.getElementById().value;
                	}
                </script>
                
                
                <br><br><br>
                

                <label for="courtPic" style="position: relative;left: 23px;">場館照片</label><br><br>
                	<input type="file" value="${court.courtPic}"
					id="uploadImg" name="courtPic" onchange="preview()" multiple="multiple"
					class="form-control-file" />
					<div id="blob_holder">
					  <img src="#" width="300px" >
					</div>						
                <br>
                
                
            <!-------- 送出按鈕  ------->
            <input type="hidden" name="action" value="insert">
			<input type="submit"  value="送出新增" style="width: 150px; height: 44px;">

                 
                
            </form>
            
            <br><br><br>


        </main>
    </div>

    
  <!--======================================= 照片上傳 / 預覽 =======================================-->
    <script>
    function preview() {

		var fileInput = document.getElementById('uploadImg');
		var file = fileInput.files[0];

		var reader = new FileReader();

		reader.onload = function() {
			document.getElementById('blob_holder').innerHTML = '<img src="' + reader.result + '" width="300px"/>';
		};

		if (file) {
			reader.readAsDataURL(file);
		}

	}
	</script>




    <!----------------------------------------------- footer 區 ------------------------------------------------------->
    <footer class="footer">

        <div class="container">
            <header class="d-flex flex-wrap justify-content-center py-3">
                 <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
              		<img src = "<%=request.getContextPath()%>/generaluser/pic/footerlogo.svg" alt="SVG"/>     
            	</a>

                <ul class="nav nav-pills">
                    <li class="nav-item"><a href="<%=request.getContextPath()%>/homepage/termOfUse/otermOfUse.jsp" class="nav-link">使用者條款</a></li>
                    <li class="nav-item"><a href="#" class="nav-link"></a></li>
                    <li class="nav-item"><a href="<%=request.getContextPath()%>/homepage/privacyPolicy/oprivacyPolicy.jsp" class="nav-link">隱私權政策</a></li>
                    <li class="nav-item"><a href="#" class="nav-link"></a></li>
                    <li class="nav-item"><a href="<%=request.getContextPath()%>/homepage/disclaimer/odisclaimer.jsp" class="nav-link">免責條款</a></li>
                    <li class="nav-item"><a href="#" class="nav-link"></a></li>
                    <li class="nav-item"><a href="#" class="nav-link"></a></li>
                </ul>
            </header>
        </div>
    </footer>

    <script src="<%=request.getContextPath()%>/JS/bootstrap.min.js"></script>

</body>

</html>