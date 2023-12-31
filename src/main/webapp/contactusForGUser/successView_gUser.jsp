<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Successfully</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/generaluser/CSS/bootstrap.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/generaluser/css2/css.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/generaluser/css2/guser.css">
</head>
<body>
	<header class="header">
		<div class="container">
			<header class="d-flex flex-wrap justify-content-center py-1">
				<a href="/"
					class="d-flex align-items-center mb-1 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
					<img
					src="<%=request.getContextPath()%>/generaluser/pic/headerlogo.svg"
					alt="SVG" />
				</a>

				<ul class="nav nav-pills">
					<li class="nav-item" id="head"><a
						href="<%=request.getContextPath()%>/homepage/main.jsp"
						class="nav-link">首頁</a></li>
					<li class="nav-item" id="head"><a
						href="<%=request.getContextPath()%>/announcement/announcementHome.jsp"
						class="nav-link">公告</a></li>
					<li class="nav-item" id="head"><a
						href="<%=request.getContextPath()%>/ginquirycourt/all_courtinfo.jsp"
						class="nav-link">場館資訊</a></li>
					<li class="nav-item" id="head"><a
						href="<%=request.getContextPath()%>/reserveorder/reserveOrder.jsp"
						class="nav-link">我要預約</a></li>
					<li class="nav-item" id="head"><a
						href="<%=request.getContextPath()%>/post/forum.html"
						class="nav-link">論壇</a></li>
					<li class="nav-item" id="head1"><a
						href="<%=request.getContextPath()%>/generaluser/guserListOne.jsp"
						class="nav-link"> <img
							src="<%=request.getContextPath()%>/generaluser/DBGifReader?gUserID=${generalUser.gUserID}"
							alt="SVG" class="rounded-circle" /> 會員中心
					</a></li>

				</ul>

			</header>
		</div>
	</header>
	<div class="main_content">
		<aside class="aside">
			<div class="parent_container">
				<h2 class="h6 pt-4 pb-3 mb-4 border-bottom" id="ah6">會員中心</h2>
				<nav class="small" id="toc">
					<li class="my-2"><a class="asidearea"
						href="<%=request.getContextPath()%>/generaluser/guserListOne.jsp">會員資料</a>
					</li>
					<li>&nbsp</li>
					<li class="my-2"><a class="asidearea"
						href="<%=request.getContextPath()%>/reserveorder/listOneOrder.jsp">球館預約紀錄</a>
					</li>
					<li>&nbsp</li>
					<li class="my-2"><a class="asidearea"
						href="<%=request.getContextPath()%>/contactUsForGUser/addContactUsForGUser.jsp">聯絡我們</a>
					</li>
					<li>&nbsp</li>
					<li class="my-2"><a class="asidearea"
						href="<%=request.getContextPath()%>/contactUsForGUser/listAllContactUsForGUser.jsp">聯絡我們紀錄</a>
					</li>
					<li>&nbsp</li>
					<li class="my-2">
						<form method="POST"
							action="<%=request.getContextPath()%>/logoutfg.do">
							<button class="asidearea">登出</button>
							<input type="hidden" name="action" value="logout">
						</form>
					</li>
					</ul>
				</nav>
			</div>

		</aside>
		<main class="main">
            <h2 class="h6 pt-4 pb-3 mb-4 border-bottom">感謝您提供寶貴的意見，我們將盡快回覆您</h2>
            <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/contactusForGUser/addContactUsForGUser.jsp" enctype="multipart/form-data" class="bararea">  
                <%-- <input type="hidden" name="action" value="getOne_For_Update">
				<input type="hidden" name="gUserID" value="${generalUser.gUserID}"> --%>
                <input type="submit" id="next" value="回首頁" style="width:150px; height:44px;">
                <br><br><br>
                <br><br>
            </form>
    </main>
		

		<footer class="footer">

			<div class="container">
				<header class="d-flex flex-wrap justify-content-center py-3">
					<a href="/"
						class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
						<img
						src="<%=request.getContextPath()%>/generaluser/pic/footerlogo.svg"
						alt="SVG" />
					</a>

					<ul class="nav nav-pillss">
						<li class="nav-item"><a
							href="<%=request.getContextPath()%>/homepage/termOfUse/termOfUse.jsp"
							class="nav-link">使用者條款</a></li>
						<li class="nav-item"><a href="#" class="nav-link"></a></li>
						<li class="nav-item"><a
							href="<%=request.getContextPath()%>/homepage/privacyPolicy/privacyPolicy.jsp"
							class="nav-link">隱私權政策</a></li>
						<li class="nav-item"><a href="#" class="nav-link"></a></li>
						<li class="nav-item"><a
							href="<%=request.getContextPath()%>/homepage/disclaimer/disclaimer.jsp"
							class="nav-link">免責條款</a></li>
						<li class="nav-item"><a href="#" class="nav-link"></a></li>
						<li class="nav-item"><a href="#" class="nav-link"></a></li>
					</ul>
				</header>
			</div>
		</footer>
</body>
</html>