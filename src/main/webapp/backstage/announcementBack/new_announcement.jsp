<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.pichill.backstage.announcement.entity.Announcement"%>

<%
//見com.emp.controller.EmpServlet.java第238行存入req的empVO物件 (此為輸入格式有錯誤時的empVO物件)
Announcement announcement = (Announcement) request.getAttribute("announcement");
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <title>新增公告</title>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/backEnd-Website/vendor/bootstrap-4.1/bootstrap.min.css" />
  <style type="text/css"></style>
  <!-- Vendor CSS-->
  <link href="<%=request.getContextPath()%>/backEnd-Website/vendor/animsition/animsition.min.css" rel="stylesheet" media="all" />
  <link href="<%=request.getContextPath()%>/backEnd-Website/vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet" media="all" />
  <link href="<%=request.getContextPath()%>/backEnd-Website/vendor/wow/animate.css" rel="stylesheet" media="all" />
  <link href="<%=request.getContextPath()%>/backEnd-Website/vendor/css-hamburgers/hamburgers.min.css" rel="stylesheet" media="all" />
  <link href="<%=request.getContextPath()%>/backEnd-Website/vendor/slick/slick.css" rel="stylesheet" media="all" />
  <link href="<%=request.getContextPath()%>/backEnd-Website/vendor/select2/select2.min.css" rel="stylesheet" media="all" />
  <link href="<%=request.getContextPath()%>/backEnd-Website/vendor/perfect-scrollbar/perfect-scrollbar.css" rel="stylesheet" media="all" />
  <!-- Main CSS-->
  <link href="<%=request.getContextPath()%>/backEnd-Website/css/main.css" rel="stylesheet" media="all" />
  <link rel="stylesheet" href="<%=request.getContextPath()%>/backEnd-Website/css/set.css" media="all" />
  <link rel="stylesheet" href="<%=request.getContextPath()%>/backEnd-Website/css/set_form.css" media="all" />
  <style></style>
</head>
<body class="animsition">
  <div class="page-wrapper">
    <!-- HEADER MOBILE-->
    <header class="header-mobile d-block d-lg-none">
      <div class="header-mobile__bar" style="background-color: #207dca">
        <div class="container-fluid">
          <div class="header-mobile-inner">
            <a class="logo" href="index.html">
              <img src="./pic/pi_chill_text.png" alt="chill" style="height: 80px" />
            </a>
            <button class="hamburger hamburger--slider" type="button">
              <span class="hamburger-box">
                <span class="hamburger-inner"></span>
              </span>
            </button>
          </div>
        </div>
      </div>
      <nav class="navbar-mobile">
        <div class="container-fluid">
          <ul class="navbar-mobile__list list-unstyled">
            <li class="has-sub">
              <a class="js-arrow" href="#">
                <i class="fas fa-tachometer-alt"></i>員工管理</a>
              <ul class="list-styled navbar__sub-list js-sub-list">
                <li>
                  <a href="all_manage.html">所有員工資料</a>
                </li>
                <li>
                  <a href="new_manage.html">新增員工資料</a>
                </li>
              </ul>
            </li>
            <li class="has-sub">
              <a class="js-arrow" href="#">
                <i class="fas fa-tachometer-alt"></i>一般會員管理</a>
              <ul class="list-styled navbar__sub-list js-sub-list">
                <li>
                  <a href="all_gUser.html">所有會員資料</a>
                </li>
                <li>
                  <a href="new_gUser.html">新增會員資料</a>
                </li>
              </ul>
            </li>
            <li class="has-sub">
              <a class="js-arrow" href="#">
                <i class="fas fa-tachometer-alt"></i>企業會員管理</a>
              <ul class="list-styled navbar__sub-list js-sub-list">
                <li>
                  <a href="all_oUser.html">所有會員資料</a>
                </li>
                <li>
                  <a href="new_oUser.html">新增會員資料</a>
                </li>
              </ul>
            </li>
            <li class="has-sub">
              <a class="js-arrow" href="#">
                <i class="fas fa-tachometer-alt"></i>最新消息管理</a>
              <ul class="list-styled navbar__sub-list js-sub-list">
                <li>
                  <a href="form.html">表單管理</a>
                </li>
                <li>
                  <a href="all_announce.html">公告管理</a>
                </li>
                <li>
                  <a href="#">新增公告</a>
                </li>
              </ul>
            </li>
            <li class="has-sub">
              <a class="js-arrow" href="#">
                <i class="fas fa-tachometer-alt"></i>論壇管理</a>
              <ul class="list-styled navbar__sub-list js-sub-list">
                <li>
                  <a href="all_post.html">所有文章</a>
                </li>
                <li>
                  <a href="all_comment.html">所有留言</a>
                </li>
                <li>
                  <a href="report.html">檢舉管理</a>
                </li>
              </ul>
            </li>
            <li class="has-sub">
              <a class="js-arrow" href="#">
                <i class="fas fa-tachometer-alt"></i>球館管理</a>
              <ul class="list-styled navbar__sub-list js-sub-list">
                <li>
                  <a href="all_court.html">所有球館</a>
                </li>
                <li>
                  <a href="all_place.html">所有場地</a>
                </li>
              </ul>
            </li>
            <li class="has-sub">
              <a href="order.html">
                <i class="fas fa-tachometer-alt"></i>預約管理</a>
            </li>
            <li class="has-sub">
              <a class="js-arrow" href="#">
                <i class="fas fa-tachometer-alt"></i>商城管理</a>
              <ul class="list-styled navbar__sub-list js-sub-list">
                <li>
                  <a href="product.html">商品管理</a>
                </li>
                <li>
                  <a href="new_product.html">新增商品</a>
                </li>
                <li>
                  <a href="product_order.html">訂單管理</a>
                </li>
              </ul>
            </li>
          </ul>
        </div>
      </nav>
    </header>
    <!-- END HEADER MOBILE-->

    <!-- MENU SIDEBAR-->
    <aside class="menu-sidebar d-none d-lg-block">
      <!-- <div class="logo">
                <a href="#">
                    <img class="logo_l" src="./pic/pi_chill_text.png"/>
                </a>
            </div> -->
      <div class="menu-sidebar__content js-scrollbar1">
        <nav class="navbar-sidebar">
          <ul class="list-unstyled navbar__list">
            <li class="has-sub">
              <a class="js-arrow" href="#">
                <i class="fas fa-tachometer-alt"></i>員工管理</a>
              <ul class="list-unstyled navbar__sub-list js-sub-list">
                <li>
                  <a href="all_manage.html">所有員工資料</a>
                </li>
                <li>
                  <a href="new_manage.html">新增員工資料</a>
                </li>
              </ul>
            </li>
            <li class="has-sub">
              <a class="js-arrow" href="#">
                <i class="fas fa-tachometer-alt"></i>一般會員管理</a>
              <ul class="list-unstyled navbar__sub-list js-sub-list">
                <li>
                  <a href="all_gUser.html">所有會員資料</a>
                </li>
                <li>
                  <a href="new_gUser.html">新增會員資料</a>
                </li>
              </ul>
            </li>
            <li class="has-sub">
              <a class="js-arrow" href="#">
                <i class="fas fa-tachometer-alt"></i>企業會員管理</a>
              <ul class="list-unstyled navbar__sub-list js-sub-list">
                <li>
                  <a href="all_oUser.html">所有會員資料</a>
                </li>
                <li>
                  <a href="new_oUser.html">新增會員資料</a>
                </li>
              </ul>
            </li>
            <li class="has-sub">
              <a class="js-arrow" href="#">
                <i class="fas fa-tachometer-alt"></i>最新消息管理</a>
              <ul class="list-unstyled navbar__sub-list js-sub-list">
                <li>
                  <a href="form.html">表單管理</a>
                </li>
                <li>
                  <a href="all_announce.html">公告管理</a>
                </li>
                <li>
                  <a href="#">新增公告</a>
                </li>
              </ul>
            </li>
            <li class="has-sub">
              <a class="js-arrow" href="#">
                <i class="fas fa-tachometer-alt"></i>論壇管理</a>
              <ul class="list-unstyled navbar__sub-list js-sub-list">
                <li>
                  <a href="all_post.html">所有文章</a>
                </li>
                <li>
                  <a href="all_comment.html">所有留言</a>
                </li>
                <li>
                  <a href="report.html">檢舉管理</a>
                </li>
              </ul>
            </li>
            <li class="has-sub">
              <a class="js-arrow" href="#">
                <i class="fas fa-tachometer-alt"></i>球館管理</a>
              <ul class="list-unstyled navbar__sub-list js-sub-list">
                <li>
                  <a href="all_court.html">所有球館</a>
                </li>
                <li>
                  <a href="all_place.html">所有場地</a>
                </li>
              </ul>
            </li>
            <li class="has-sub">
              <a href="order.html">
                <i class="fas fa-tachometer-alt"></i>預約管理</a>
            </li>
            <li class="has-sub">
              <a class="js-arrow" href="#">
                <i class="fas fa-tachometer-alt"></i>商城管理</a>
              <ul class="list-styled navbar__sub-list js-sub-list">
                <li>
                  <a href="product.html">商品管理</a>
                </li>
                <li>
                  <a href="new_product.html">新增商品</a>
                </li>
                <li>
                  <a href="product_order.html">訂單管理</a>
                </li>
              </ul>
            </li>
          </ul>
        </nav>
      </div>
    </aside>
    <!-- END MENU SIDEBAR-->

    <!-- PAGE CONTAINER-->
    <div class="page-container">
      <!-- HEADER DESKTOP-->
      <header class="header-desktop">
        <div class="section__content section__content--p30">
          <div class="container-fluid">
            <div class="header-wrap">
              <div class="header-logo">
                <a href="index.html"><img class="img-logo" href="index.html" src="<%=request.getContextPath()%>/image/bigLogo.png" alt="" /></a>
              </div>
              <form class="form-header" action="#" method="POST">
                <input class="au-input au-input--xl" type="text" name="search" placeholder="搜尋" />
                <button class="au-btn--submit" type="submit">
                  <i class="zmdi zmdi-search" style="font-size: 15px">送出</i>
                </button>
              </form>
              <div class="header-button">
                <div class="account-wrap">
                  <div class="account-item clearfix js-item-menu">
                    <div class="image">
                      <img src="<%=request.getContextPath()%>/image/Group 115.png" alt="使用者頭像" />
                    </div>
                    <div class="content">
                      <a class="js-acc-btn" href="#">管理員羅裕鵬，您好</a>
                    </div>
                    <div class="account-dropdown js-dropdown">
                      <div class="info clearfix">
                        <div class="image">
                          <a href="#">
                            <img src="<%=request.getContextPath()%>/image/Group 115.png" alt="John Doe" />
                          </a>
                        </div>
                        <div class="content">
                          <h5 class="name">
                            <a href="my_data.html">羅裕鵬</a>
                          </h5>
                          <span class="email">brandon416jr@gmail.com</span>
                        </div>
                      </div>
                      <div class="account-dropdown__footer">
                        <a href="#"> <i class="zmdi zmdi-power"></i>登出</a>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </header>
      <!-- END HEADER DESKTOP-->
    </div>

    <div class="main-content">
      <div class="section__content2 section__content--p30">
        <div class="container-fluid2">
          <div class="card">
            <div class="card-header">
              <strong>新增公告</strong>
              <h4>
								<a
									href="<%=request.getContextPath()%>/backstage/announcementBack/all_announcement.jsp"><img
									src="<%=request.getContextPath()%>/image/smallLogo.png" width="20" height="20" border="0">回所有公告</a>
							</h4>
            </div>
            
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
            <form action="announcementb.do" method="post" enctype="multipart/form-data" class="form-horizontal">
            <div class="card-body">
              <div class="row">
                <div class="col-lg-12">
                  <div class="card-body card-block">
                      <div class="row form-group">
                        <div class="col col-md-3">
                          <label for="text-input" class="form-control-label">管理員編號</label>
                        </div>
                        <div class="col-10 col-md-8">
                          <input type="text" id="text-input" name="manageID" placeholder="請輸入管理員編號"
                          value="<%=announcement.getManageID()%>"
                            class="form-control" />
                          <!-- <small class="form-text text-muted">This is a help text</small> -->
                        </div>
                      </div>
                      <div class="row form-group">
                        <div class="col col-md-3">
                          <label for="text-input" class="form-control-label">表單編號</label>
                        </div>
                        <div class="col-10 col-md-8">
                          <input type="text" id="text-input" name="formID" placeholder="請輸入表單編號" value="<%=announcement.getFormID()%>"
                            class="form-control" />
                          <!-- <small class="form-text text-muted">This is a help text</small> -->
                        </div>
                      </div>
                      <div class="row form-group">
                        <div class="col col-md-3">
                          <label for="text-input" class="form-control-label">標題</label>
                        </div>
                        <div class="col-10 col-md-8">
                          <input type="text" id="text-input" name="annoTitle" placeholder="請輸入標題" value="<%=announcement.getAnnoTitle()%>"
                            class="form-control" />
                          <!-- <small class="form-text text-muted">This is a help text</small> -->
                        </div>
                      </div>
                      <div class="row form-group">
                        <div class="col col-md-3">
                          <label for="text-input" class="form-control-label">內文</label>
                        </div>
                        <div class="textbox col-10 col-md-8">
                          <textarea name="textarea-input" id="annoContent" rows="9" placeholder="請輸入內文" 
                            class="form-control"><%=announcement.getAnnoContent()%>"</textarea>
                          <!-- <input type="text" id="text-input" disabled="" name="text-input" placeholder="rfrfrfr" class="form-control"> -->
                          <!-- <small class="form-text text-muted">This is a help text</small> -->
                        </div>
                      </div>
                      <div class="row form-group">
                        <div class="col col-md-3">
                          <label for="file-input" class="form-control-label">圖片</label>
                        </div>
                        <div class="col-10 col-md-8">
                          <input type="file" id="file-input" name="annoPic"
														onclick="previewImage()" multiple="multiple"
														onchange="hideContent('upFiles.errors');"
														class="form-control-file" /> <img id="imagePreview"
														src="#" alt="Preview" />
                        </div>
                      </div>
                      <div class="row form-group">
                        <div class="col col-md-3">
                          <label for="text-input" class="form-control-label">時間</label>
                        </div>
                        <div class="col-10 col-md-8">
                          <input type="text" id="text-input" name="annoTime" placeholder="時間" value="<%=announcement.getAnnoTime()%>" class="form-control" />
                          <!-- <small class="form-text text-muted">This is a help text</small> -->
                        </div>
                      </div>
                      <div class="row form-group">
                        <div class="col col-md-3">
                          <label for="selectLg" class="form-control-label">公告狀態</label>
                        </div>
                        <div class="col-10 col-md-8">
                          <select name="annoStatus" id="selectLm" class="form-control-sm form-control">
                            <option value="0">未公告</option>
                            <option value="1">已公告</option>
                          </select>
                        </div>
                      </div>
                    <div class="row form-group">
											<div class="col-1 col-md-8">
												<input type="hidden" name="action" value="insert"> <input
													type="submit" class="btn btn-primary btn-sm" value="送出新增">
												<i class="fa fa-dot-circle-o"></i>
											</div>
										</div>
                  </div>
                </div>
              </div>
            </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>

  <!-- <script>
      const textbox = document.querySelector('.textbox .form-control');
        textbox.addEventListener('input', (e) => {
        e.target.style.height = 'auto';
        e.target.style.height = e.target.scrollHeight + 'px';
      });
    </script> -->
  <script src="<%=request.getContextPath()%>/backEnd-Website/js/pic_uplaod.js"></script>
  <!-- Jquery JS-->
  <script src="<%=request.getContextPath()%>/backEnd-Website/vendor/jquery-3.2.1.min.js"></script>
  <!-- proper.min.js first, then bootstrap.min.js -->
  <script src="<%=request.getContextPath()%>/backEnd-Website/vendor/bootstrap-4.1/popper.min.js"></script>
  <script src="<%=request.getContextPath()%>/backEnd-Website/vendor/bootstrap-4.1/bootstrap.min.js"></script>
  <!-- Vendor JS       -->
  <script src="<%=request.getContextPath()%>/backEnd-Website/vendor/slick/slick.min.js"></script>
  <script src="<%=request.getContextPath()%>/backEnd-Website/vendor/wow/wow.min.js"></script>
  <script src="<%=request.getContextPath()%>/backEnd-Website/vendor/animsition/animsition.min.js"></script>
  <script src="<%=request.getContextPath()%>/backEnd-Website/vendor/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
  <script src="<%=request.getContextPath()%>/backEnd-Website/vendor/counter-up/jquery.waypoints.min.js"></script>
  <script src="<%=request.getContextPath()%>/backEnd-Website/vendor/counter-up/jquery.counterup.min.js"></script>
  <script src="<%=request.getContextPath()%>/backEnd-Website/vendor/circle-progress/circle-progress.min.js"></script>
  <script src="<%=request.getContextPath()%>/backEnd-Website/vendor/perfect-scrollbar/perfect-scrollbar.js"></script>
  <script src="<%=request.getContextPath()%>/backEnd-Website/vendor/chartjs/Chart.bundle.min.js"></script>
  <script src="<%=request.getContextPath()%>/backEnd-Website/vendor/select2/select2.min.js"></script>
  <!-- Main JS-->
  <script src="<%=request.getContextPath()%>/backEnd-Website/js/main.js"></script>
</body>
</html>