<%@page import="com.pichill.owneruser.entity.OwnerUser"%>
<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ page import="com.pichill.court.*"%>
<%@ page import="com.pichill.place.*"%>
<%@ page import="java.util.Date" %>
    
 <%
//見com.emp.controller.EmpServlet.java第238行存入req的empVO物件 (此為輸入格式有錯誤時的empVO物件)
Court newCourt = (Court) request.getAttribute("newCourt");
%>   
    
<%
//Place place = (Place) session.getAttribute("place");
%>
    
<%
Court court = (Court) session.getAttribute("court");
// 寫死
// Integer courtID = 61000001;
// CourtService courtSvc = new CourtService();
// Court court = courtSvc.getOneCourt(courtID);
// pageContext.setAttribute("court",court);
%>    
<%
OwnerUser ownerUser = (OwnerUser) session.getAttribute("ownerUser");
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
					<li class="nav-item"><a href="<%=request.getContextPath()%>/contactus/contactus" class="nav-link">聯絡我們</a></li>
					<li class="nav-item"><a href="<%=request.getContextPath()%>/owneruser/ouserListOne.jsp" class="nav-link"> 
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
                            <button class="btn d-inline-flex align-items-center collapsed border-0"
                                data-bs-toggle="collapse" aria-expanded="false" data-bs-target="#contents-collapse"
                                aria-controls="contents-collapse">企業會員資料</button>
                        </li>
                        <li class="my-2">
                            <button class="btn d-inline-flex align-items-center collapsed border-0"
                                data-bs-toggle="collapse" aria-expanded="false" data-bs-target="#forms-collapse"
                                aria-controls="forms-collapse">申請上架球館</button>
                        </li>
                        <li class="my-2">
                            <button class="btn d-inline-flex align-items-center collapsed border-0"
                                data-bs-toggle="collapse" aria-expanded="false" data-bs-target="#forms-collapse"
                                aria-controls="forms-collapse">球館管理</button>
                        </li>
                        <br>
                        <li class="my-2">
                            <button class="btn d-inline-flex align-items-center collapsed border-0"
                                data-bs-toggle="collapse" aria-expanded="false" data-bs-target="#forms-collapse"
                                aria-controls="forms-collapse">登出</button>
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
			<form action="${pageContext.request.contextPath }/court/court.do"
			 METHOD="post"	enctype="multipart/form-data">
			
            
                <img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" width="20" height="20" alt="">
                <label for="courtName">場館名稱</label>
                <input type="text" id="court" name="courtName" 
                value="<%=(newCourt == null)? "" :newCourt.getCourtName()%>" size="45" required>
                <br><br>

                <img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" width="20" height="20" alt="">
                <label  for="time">開館時間</label>
                <input type="time" value="<%=(newCourt==null)? "07:00:00" : newCourt.getCourtOpenTime()%>"  min="09:00" max="18:00">

                <img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" width="20" height="20" alt="" style="position: relative; left: 15px;">
                <label style="position: relative; left: 15px;" for="time">閉館時間</label>
                <input type="time" value="<%=(newCourt==null)? "21:00:00" :newCourt.getCourtCloseTime()%>" style="position: relative; left: 15px;">
                <br><br>

                <img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" width="20" height="20" alt="">
                <label for="loc">區域</label>
                <input type="text" value="<%=(newCourt==null)? "" :newCourt.getLoc()%>" style="position: relative; left: 31px;">
                <font color="#FF0000" size="-1" nowrap="" style="position: relative;;left: 30px;">如:中正區</font>
                
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
                value="<%=(newCourt == null)? "" : newCourt.getCourtAddress()%>" style="width: 300px" required>
                <font color="#FF0000" size="-1" nowrap="" style="position: relative;left: 1px; ">包含鄉鎮區、路街道及門牌號等。</font><br><br>

                <img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" width="20" height="20" alt="">
                <label for="phone">場館電話</label>
                <input type="text" id="text" name="courtTelephone" value="<%=(newCourt == null)? "" : newCourt.getCourtTelephone()%>"  required>
                <font color="#FF0000" size="-1" nowrap="" style="position: relative;left: 1px;">包含區域碼 如:0212345678。</font>
                <br><br>

                <img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" width="20" height="20" alt="">
                <label for="courtRule" style="position: relative; ">場館須知</label><br><br>
                <input type="hidden" id="courtRule" name="courtRule" value="<%=(newCourt ==null)? "" :newCourt.getCourtRule()%>" >
                 <textarea name="CourtRule" id="courtRule" placeholder="Write something.."style="height:300px;width:600px;position: relative;left:23px;" required></textarea>
                
                <script type="text/javascript">
                	function changeText(){
                		document.getElementById().value=document.getElementById().value;
                	}
                </script>
                
                
                <br><br><br>
                

                <label for="courtPic" style="position: relative;left: 23px;">場館照片</label><br><br>
                	<input type="file" value="${newCourt.courtPic}"
					id="uploadImg" name="courtPic" onchange="preview()" multiple="multiple"
					class="form-control-file" />
					<div id="blob_holder">
					  <img src="#" width="300px" >
					</div>						
                <br>
            </form>
            
            <br><br><br>


            <!-------- 送出按鈕  ------->
            <input type="hidden" name="action" value="insert">
			<input type="submit" class="btn btn-primary btn-sm" value="送出新增" style="width: 150px; height: 44px;">

        </FORM>
        </main>
    </div>
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

<!--======================================= 新增場地 / 編輯 / 預覽 =======================================-->

            <script>
                $(document).ready(function () {
                    $("#addButton").click(function () {
                        var ball = $("#ball").val();
                        var placeName = $("#placeName").val();
                        var placeFee = $("#placeFee").val();

                        if (ball && itemName && placeFee) {
                            var newRow = "<tr>" +
                                "<td>" + ball + "</td>" +
                                "<td>" + placeName + "</td>" +
                                "<td>" + placeFee + "</td>" +
                                "<td><button class='deleteButton'>刪除</button></td>" +
                                "</tr>";

                            $("#itemTable tbody").append(newRow);

                            // 清空輸入欄位
                            $("#placeName, #placeFee").val("");
                        } else {
                            alert("請填寫完整資訊");
                        }
                    });
                    // 刪除按鈕的點擊事件處理
                    $(document).on("click", ".deleteButton", function () {
                        $(this).closest("tr").remove();
                    });
                });
            </script>


    <!----------------------------------------------- footer 區 ------------------------------------------------------->
    <footer class="footer">

        <div class="container">
            <header class="d-flex flex-wrap justify-content-center py-3">
                <a href="/"
                    class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
                    <img src="./pic/footerlogo.svg" alt="SVG" />
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