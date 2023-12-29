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

    <script src="<%=request.getContextPath()%>/JS/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<%--  	<link rel="stylesheet" href="<%=request.getContextPath()%>/ginquirycourt/courtinfo1.css"> --%>
    
   
    <link rel="stylesheet" href="<%=request.getContextPath()%>/generaluser/CSS/bootstrap.min.css">
<%--     <link rel="stylesheet" href="<%=request.getContextPath()%>/generaluser/css2/css.css"> --%>

    <link rel="stylesheet" href="<%=request.getContextPath()%>/ginquirycourt/courtinfo.css">


	<style>

		.card-image {
		  position: relative;
		  height: 50%;
		  overflow: hidden;
		}
		
		.card-image img {
		  width: 100px;
		  height: 100%;
		  object-fit: cover;
		  transition: transform 0.3s ease-in-out;
		}
		
		.card-details {
		  padding: 50px;
		  text-align: center;
		}
		
		.card-details h3 {
/* 		  margin-bottom: 10px; */
		  font-size: 18px;
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

<!----------------------------------------------- main 區 ------------------------------------------------------->
    <main class="main">
        <div class="row g-3">
            <h2 class="h6 pt-4 pb-3 mb-4 ">場館資訊</h2>
            <form class="bararea" enctype="multipart/form-data">
                <div class="col" id="research">
                    <label for="research">搜尋:</label>
                    <input type="text" id="research" name="research">
                    <div class="keyword">請輸入關鍵字 (例如: 桌球、板橋)</div><br>
                </div>

                <div class="col">
                    <div class="col" id="sort">
                      <label for="country">排序:</label>
                      <select  id="sortselect">
                        <option value="">所有</option>
                        <option>由近到遠</option>
                      </select>
                    </div>
                </div>
            </form>
            <br><br>
            <div class="row row-cols-1 row-cols-md-4 g-4" id="card">
            	

			    <div class="card">
			        <div class="card-image" id="venue1">
			        	<img src="<%=request.getContextPath()%>/ginquirycourt/img/1.jpg" alt="飛龍運動館" style="width:100%;height:140px;position: relative;top: 20px;">
			        </div>
			        <div class="card-details">
			        <h6 class="card-title"><font style="vertical-align: inherit; font-weight: bold;"><font style="vertical-align: inherit;">飛龍運動館</font></font></h6>
			        <a href="<%=request.getContextPath()%>/ginquirycourt/listOneCourt=61000001.jsp" class="btn btn-primary"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">GO!</font></font></a>
			        </div>
			    </div>
			    
	       		<div class="card">
			        <div class="card-image" id="venue1">
			        	<img src="<%=request.getContextPath()%>/ginquirycourt/img/2.jpg" alt="中正排球場" style="width:100%;height:140px;position: relative;top: 20px;">
			        </div>
			        <div class="card-details">
			        <h6 class="card-title"><font style="vertical-align: inherit; font-weight: bold;"><font style="vertical-align: inherit;">中正排球場</font></font></h6>
			        <a href="<%=request.getContextPath()%>/ginquirycourt/listOneCourt=61000002.jsp" class="btn btn-primary"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">GO!</font></font></a>
			        </div>
			    </div>
			    
	            <div class="card">
			        <div class="card-image" id="venue1">
			        	<img src="<%=request.getContextPath()%>/ginquirycourt/img/3.jpg" alt="奧特菲羽球館" style="width:100%;height:140px;position: relative;top: 20px;">
			        </div>
			        <div class="card-details">
			        <h6 class="card-title"><font style="vertical-align: inherit; font-weight: bold;"><font style="vertical-align: inherit;">奧特菲羽球館</font></font></h6>
			        <a href="<%=request.getContextPath()%>/ginquirycourt/listOneCourt=61000003.jsp" class="btn btn-primary"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">GO!</font></font></a>
			        </div>
			    </div>
			    
	            <div class="card">
			        <div class="card-image" id="venue1">
			        	<img src="<%=request.getContextPath()%>/ginquirycourt/img/4.jpg" alt="陽明籃球館" style="width:100%;height:140px;position: relative;top: 20px;">
			        </div>
			        <div class="card-details">
			        <h6 class="card-title"><font style="vertical-align: inherit; font-weight: bold;"><font style="vertical-align: inherit;">陽明籃球館</font></font></h6>
			        <a href="<%=request.getContextPath()%>/ginquirycourt/listOneCourt=61000004.jsp" class="btn btn-primary"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">GO!</font></font></a>
			        </div>
			    </div>   
			             
	            <br>
	            <div class="card">
			        <div class="card-image" id="venue1">
			        	<img src="<%=request.getContextPath()%>/ginquirycourt/img/5.jpg" alt="萬華活力球館" style="width:100%;height:140px;position: relative;top: 20px;">
			        </div>
			        <div class="card-details">
			        <h6 class="card-title"><font style="vertical-align: inherit; font-weight: bold;"><font style="vertical-align: inherit;">萬華活力球館</font></font></h6>
			        <a href="<%=request.getContextPath()%>/ginquirycourt/listOneCourt=61000005.jsp" class="btn btn-primary"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">GO!</font></font></a>
			        </div>
			    </div> 
			    
	             <div class="card">
			        <div class="card-image" id="venue1">
			        	<img src="<%=request.getContextPath()%>/ginquirycourt/img/6.jpg" alt="新生排球場" style="width:100%;height:140px;position: relative;top: 20px;">
			        </div>
			        <div class="card-details">
			        <h6 class="card-title"><font style="vertical-align: inherit; font-weight: bold;"><font style="vertical-align: inherit;">新生排球場</font></font></h6>
			        <a href="<%=request.getContextPath()%>/ginquirycourt/listOneCourt=61000006.jsp" class="btn btn-primary"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">GO!</font></font></a>
			        </div>
			    </div> 
			    
	             <div class="card">
			        <div class="card-image" id="venue1">
			        	<img src="<%=request.getContextPath()%>/ginquirycourt/img/7.jpg" alt="紅季羽球綜合館" style="width:100%;height:140px;position: relative;top: 20px;">
			        </div>
			        <div class="card-details">
				        <h6 class="card-title"><font style="vertical-align: inherit; font-weight: bold;"><font style="vertical-align: inherit;">紅季羽球綜合館</font></font></h6>
				        <a href="<%=request.getContextPath()%>/ginquirycourt/listOneCourt=61000007.jsp" class="btn btn-primary"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">GO!</font></font></a>
				    </div>
			     </div>
			     
	             <div class="card">
			        <div class="card-image" id="venue1">
			        	<img src="<%=request.getContextPath()%>/ginquirycourt/img/8.jpg" alt="TFK羽球館" style="width:100%;height:140px;position: relative;top: 20px;">
			        </div>
			        <div class="card-details">
			        <h6 class="card-title"><font style="vertical-align: inherit; font-weight: bold;"><font style="vertical-align: inherit;">TFK羽球館</font></font></h6>
			        <a href="<%=request.getContextPath()%>/ginquirycourt/listOneCourt=61000008.jsp" class="btn btn-primary"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">GO!</font></font></a>
			     </div>
			     
			     <br>
	             <div class="card">
			        <div class="card-image" id="venue1">
			        	<img src="<%=request.getContextPath()%>/ginquirycourt/img/9.jpg" alt="BOS運動館" style="width:100%;height:140px;position: relative;top: 20px;">
			        </div>
			        <div class="card-details">
			        <h6 class="card-title"><font style="vertical-align: inherit; font-weight: bold;"><font style="vertical-align: inherit;">BOS運動館</font></font></h6>
			        <a href="<%=request.getContextPath()%>/ginquirycourt/listOneCourt=61000009.jsp" class="btn btn-primary"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">GO!</font></font></a>
			     </div>            
	             <div class="card">
			        <div class="card-image" id="venue1">
			        	<img src="<%=request.getContextPath()%>/ginquirycourt/img/10.jpg" alt="艾特極運動生活館" style="width:100%;height:140px;position: relative;top: 20px;">
			        </div>
			        <div class="card-details">
			        <h6 class="card-title"><font style="vertical-align: inherit; font-weight: bold;"><font style="vertical-align: inherit;">艾特極運動生活館</font></font></h6>
			        <a href="<%=request.getContextPath()%>/ginquirycourt/listOneCourt=61000010.jsp" class="btn btn-primary"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">GO!</font></font></a>
			     </div>            
	            
      
           </div>

            <div>
                <ul class="pagination">
                    <li class="page-item">
                        <a class="page-link" href="#" aria-label="以前的">
                            <span aria-hidden="true"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">«</font></font></span>
                        </a>
                    </li>
                    <li class="page-item"><a class="page-link" href="#"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">1</font></font></a></li>
<!--                     <li class="page-item"><a class="page-link" href="#"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">2</font></font></a></li> -->

                    <li class="page-item">
                        <a class="page-link" href="#" aria-label="下一個">
                            <span aria-hidden="true"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">»</font></font></span>
                        </a>
                    </li>
                </ul>
            </div>
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