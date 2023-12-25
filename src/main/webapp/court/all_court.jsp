<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<%@ page import="com.pichill.court.Court"%>
<%@ page import="com.pichill.court.CourtDAO"%>
<%@ page import="com.pichill.court.CourtDAOImpl"%>
<%@ page import="com.pichill.court.CourtService"%>
<%@ page import="com.pichill.place.Place"%>
<%@ page import="com.pichill.owneruser.*"%>
<%@ page import="java.util.*" %>
<%-- 此頁練習採用 EL 的寫法取值 --%>


 <%
// OwnerUser ownerUser = (OwnerUser) session.getAttribute("ownerUser");
// // 寫死
// Integer oUserID = 12000001;
// OwnerUserService ownerUserSvc = new OwnerUserService();
// OwnerUser ownerUser = ownerUserSvc.getOneOwnerUser(oUserID);
// pageContext.setAttribute("ownerUser",ownerUser);
%>


<%
CourtService courtService = new CourtService();
List<Map> list = courtService.getAll();
pageContext.setAttribute("list", list);
%>


<!DOCTYPE html>
<html lang="zh-Hant">

<head>
<meta charset="utf-8" />
<title>球館管理</title>
 <meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet" href="<%=request.getContextPath()%>/owneruser/css1/bootstrap.min.css">
   <link rel="stylesheet" href="<%=request.getContextPath()%>/owneruser/CSS/index3.css">
   <link rel="stylesheet" href="<%=request.getContextPath()%>/owneruser/CSS/css.css">
   
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
         table#table-1 {
		background-color: #207DCA;
	/*     border: 2px solid black; */
	    text-align: center;
	  }
	  table#table-1 h4 {
	    color: red;
	    display: block;
	    margin-bottom: 1px;
	  }
	  h3 {
	    color: blck;
	  }
	  h4 {
	    color: blue;
	    display: inline;
	  }
	   table {
		width: 1650px;
		background-color: white;
		margin-top: 5px;
		margin-bottom: 5px;
	  }
	  table, th, td {
	    border: 1px solid #207DCA;
	  }
	  th, td {
	    padding: 5px;
	    text-align: center;
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
                    <li class="nav-item"><a href="#" class="nav-link">首頁</a></li>
                    <li class="nav-item"><a href="#" class="nav-link">通知</a></li>
                    <li class="nav-item"><a href="#" class="nav-link">預約管理系統</a></li>
                    <li class="nav-item"><a href="#" class="nav-link">論壇</a></li>
                    <li class="nav-item"><a href="#" class="nav-link">聯絡我們</a></li>
                    <li class="nav-item"><a href="#" class="nav-link"><img src="<%=request.getContextPath()%>/owneruser/DBGifReader?oUserID=${ownerUser.oUserID}"  alt="SVG" class="rounded-circle"/>企業會員中心</a></li>
                    </li>
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
                            <button class="btn d-inline-flex align-items-center collapsed border-0"
                                data-bs-toggle="collapse" aria-expanded="false" data-bs-target="#contents-collapse"
                                aria-controls="contents-collapse"
                                href="<%=request.getContextPath()%>/owneruser/owneruser/set_owneruser.jsp"
                                >企業會員資料</button>
                        </li>
                        <li class="my-2">
                            <button class="btn d-inline-flex align-items-center collapsed border-0"
                                data-bs-toggle="collapse" aria-expanded="false" data-bs-target="#forms-collapse"
                                aria-controls="forms-collapse"
                                href="<%=request.getContextPath()%>/owneruser/court/new_court.jsp"
                                >申請上架球館</button>
                        </li>
                        <li class="my-2">
                            <button class="btn d-inline-flex align-items-center collapsed border-0"
                                data-bs-toggle="collapse" aria-expanded="false" data-bs-target="#forms-collapse"
                                aria-controls="forms-collapse" 
                                href="<%=request.getContextPath()%>/owneruser/court/all_court.jsp"
                                >球館管理</button>
                        </li>
                        <br>
                        <li class="my-2">
                            <button class="btn d-inline-flex align-items-center collapsed border-0"
                                data-bs-toggle="collapse" aria-expanded="false" data-bs-target="#forms-collapse"
                                aria-controls="forms-collapse" href="#">登出</button>
                        </li>
                    </ul>
                </nav>
            </div>
        </aside>
       
       
       
       <!----------------------------------------------- main 區 ------------------------------------------------------->
    <main class="main">
        <!--     <h4>此頁練習採用 EL 的寫法取值:</h4> -->
	   	<h3 >球館管理</h3>
	<!--    <table id="table-1"> -->
	<!-- 	<tr><td> -->
			 
	<%-- 		 <h4><a href="select_page.jsp"><img src="<%=request.getContextPath()%>/image/logo.png" width="200" height="80" border="0">  回首頁</a></h4> --%>
	<!-- 	</td></tr> -->
	<!-- 	</table> -->

	  <table>
		<tr>
			<th>球館編號</th>
			<th>企業會員編號</th>
<!-- 			<th>管理員編號</th> -->
			<th>球館名稱</th>
			<th>球館電話</th>
			<th>地區</th>
			<th>球館地址</th>
<!-- 			<th>球館須知</th> -->
			<th>球館圖片</th>
			<th>開館時間</th>
			<th>閉館時間</th>
			<th>申請上架時間</th>
			<th>上架時間</th>
			<th>申請狀態</th>
			<th>場地名稱</th>
			<th>場地費用</th>
			<th>球類</th>
			<th>修改</th>
		</tr>
	
		<c:forEach var="court" items="${list}" >
		
			<tr>
				<td>${court.courtID}</td>
				<td>${court.oUserID}</td>
<%-- 			<td>${court.manageID}</td> --%>
				<td style="width:100px">${court.courtName}</td>
				<td>${court.courtTelephone}</td>				
				<td style="width:80px">${court.loc}</td>
				<td style="width:180px">${court.courtAddress}</td>
<%-- 				<td style="width:480px">${court.courtRule}</td> --%>
				<td>${court.courtPic}</td>
				<td>${court.courtOpenTime}</td>
				<td>${court.courtCloseTime}</td>
				<td style="width:100px">${court.courtApplyTime}</td>				
				<td style="width:100px">${court.courtOnTime}</td>
				<td style="width:60px">${court.courtApplyStatus}</td>
       			<td>${court.placeName}</td>
       			<td>${court.placeFee}</td>
       			<td>${court.ball}</td>
			
				<td>
				  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/court/court.do" style="margin-bottom: 0px;">
				     <input type="submit" value="修改">
				     <input type="hidden" name="courtID"  value="${court.courtID}">
				     <input type="hidden" name="action"	value="getOne_For_Update">
				  </FORM>
				</td>
			</tr>
		</c:forEach>
	  </table>
   </main>
   </div>	 
    
 
<%-- <%@ include file="page2.file" %> --%>
	<script>
		var script = document.createElement("script");

		script.src = "https://code.jquery.com/jquery-3.4.1.min.js";

		script.type = "text/javascript";

// 		document.getElementsByTagName("head")[0].appendChild(script);
	</script>
        
        <!----------------------------------------------- footer 區 ------------------------------------------------------->
    <footer class="footer">

        <div class="container">
            <header class="d-flex flex-wrap justify-content-center py-3">
                <a href="/"
                    class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
                    <img src = "<%=request.getContextPath()%>/owneruser/pic/footerlogo.svg" alt="SVG"/>
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

    <script src="<%=request.getContextPath()%>/JS/bootstrap.min.js"></script>
</body>

</html>