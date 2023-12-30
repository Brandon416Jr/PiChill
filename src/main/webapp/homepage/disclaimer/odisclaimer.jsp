<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.pichill.owneruser.entity.OwnerUser"%>
<%@ page import="java.util.*" %>
<%@ page import="com.pichill.court.Court"%>
<%@ page import="com.pichill.frontstage.court.service.CourtServiceFront"%>

<%
OwnerUser ownerUser = (OwnerUser) session.getAttribute("ownerUser");
System.out.println("ownerUser is " + ownerUser);
Integer oUserID = ownerUser.getoUserID();
System.out.println("oUser is " + oUserID);
CourtServiceFront courtSvcF = new CourtServiceFront();
List<Court> list = courtSvcF.getoUserID(oUserID);
pageContext.setAttribute("list",list);
pageContext.setAttribute("oUserID",oUserID);

%>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>免責條款</title>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/owneruser/css1/bootstrap.min.css">
   <link rel="stylesheet" href="<%=request.getContextPath()%>/owneruser/CSS/index3.css">
   <link rel="stylesheet" href="<%=request.getContextPath()%>/owneruser/CSS/css.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/disclaimer.css">
 
</head>

<body>
  <!----------------------------------------------- header 區 ------------------------------------------------------->
  <header class="header">
    <div class="container">
      <header class="d-flex flex-wrap justify-content-center py-1">
        <a href="/" class="d-flex align-items-center mb-1 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
          <img src="<%=request.getContextPath()%>/owneruser/pic/headerlogo.svg" alt="SVG"/>
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

  <!----------------------------------------------- main 區 ------------------------------------------------------->
  <div class="disclaimer">

    <h1 class="headline">πChill場館之責任免除及授權條款</h1>
    
    <div class="container">
      <div class="row">
        <div class="col-md-10-col-md-push-1">
        
            <li class="termList">一、當您在πChill訂課頁面上按下訂課確認的同時，您即同意對於每一堂課程內容和相關的活動設施，承擔相當程度的風險和危險。為使您能獲准參與並使用πChill所提供的各項課程和設施，您同意：</li>
              <ol class="sub">
                <li>由您個人在進行各項課程和使用設施時所造成的傷害，將自行負責。</li>
                <li>您同意所有的參與πChill的相關人員，包括但不限於場館經營者各場館經營者、管理人、經理人及其所有員工、人員，皆不對您個人的財產負保管之責。此外，在場館之經營者、管理人、經理人及其所有員工、人員不具重大過失之情況下，保證不對πChill合作的各場館經營者、管理人、經理人及其所有員工、人員，因您參與課程或使用設施而遭受的人身或財產上損害進行起訴，並於此免除其損害賠償責任。</li>
                <li>保證您個人不具有任何藥物或健康狀況，無不適合參與課程或使用設施之情形， 亦無任何醫療人員禁止您參與本網站上各場館所提供之課程或設施。</li>
              </ol> 
            <li class="termList">二、您清楚的知悉並了解πChill頁面上所列示的所有課程皆為健身、體適能課程，您明白在從事該等課程之前，預先的諮詢相關醫療人員、各場館之經營者、管理人、課程人員並遵從其建議，係您個人之責任。</li>
            <li class="termList">三、您同意遵守各場館之約款及規則，並確實遵守各場館人員或指導員的各種指導。</li>
            <li class="termList">四、您同意使用πChill參與各項課程的過程中，可能會有受拍照、攝錄影音之可能，對於該等內容，您同意πChill將為著作權人及相關智慧財產權人，得將您該等影音、照片以實體與數位方式重製、改作、編輯、公開口述、公開演出、公開上映、公開傳輸或以其他方式加以利用，並得對第三人進行授權，供第三人使用。</li>
            <li class="termList">五、您同意本條款所指之場館，係包含現在及未來加入17FIT的所有課程提供者。</li>
              <p class="thankyou">
                πChill 感謝您的加入。
              </p>
        </div>
      </div>
    </div>
  </div>
  <!----------------------------------------------- footer 區 ------------------------------------------------------->
  <footer class="footer">

    <div class="container">
      <header class="d-flex flex-wrap justify-content-center py-3">
        <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
          <img src="<%=request.getContextPath()%>/owneruser/pic/footerlogo.svg" alt="SVG"/>
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

  <script src="./JS/bootstrap.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>