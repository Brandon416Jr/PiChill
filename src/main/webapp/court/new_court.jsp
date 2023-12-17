<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ page import="com.pichill.court.Court"%>
<%@ page import="com.pichill.place.Place"%>
    
<%
//見com.emp.controller.EmpServlet.java第238行存入req的empVO物件 (此為輸入格式有錯誤時的empVO物件)
Court court = (Court) request.getAttribute("court");
Place place = (Place) request.getAttribute("place");
%>
    
    
    
<!DOCTYPE html>
<html lang="zh-Hant">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Pichill企業會員-申請上架球館</title>
   <link rel="stylesheet" href="<%=request.getContextPath()%>/owneruser/css1/bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/owneruser/CSS/css.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/owneruser/CSS/index3.css">
	
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
                    <li class="nav-item"><a href="#" class="nav-link">首頁</a></li>
                    <li class="nav-item"><a href="#" class="nav-link">通知</a></li>
                    <li class="nav-item"><a href="#" class="nav-link">預約管理系統</a></li>
                    <li class="nav-item"><a href="#" class="nav-link">論壇</a></li>
                    <li class="nav-item"><a href="#" class="nav-link">聯絡我們</a></li>
                    <li class="nav-item"><a href="#" class="nav-link"><img src="./pic/face.svg" alt="SVG" />企業會員中心</a>
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
        
        
        
                <span style="color:#FF0000;  position: relative;left: 250px;">前有
                <img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" width="20" height="20" alt="">為必填項目</span>
           		<br>
           <%-- 錯誤表列 --%>
			<c:if test="${not empty errorMsgs}">
				<font style="color:red">請修正以下錯誤:</font>
				<ul>
					<c:forEach var="message" items="${errorMsgs}">
						<li style="color:red">${message}</li>
					</c:forEach>
				</ul>
			</c:if>
			<br>
			<FORM ACTION="${pageContext.request.contextPath }/court/court.do" METHOD="post"
							enctype="multipart/form-data">
			
            <form action="/submit" method="post" enctype="multipart/form-data" style="width: 800px;">
                <img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" width="20" height="20" alt="">
                <label for="courtName">場館名稱</label>
                <input type="text" id="court" name="courtName" 
                value="<%=(court==null)? "" :court.getcourtName()%>" size="45" required>
                <br><br>

                <img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" width="20" height="20" alt="">
                <label  for="time">開館時間</label>
                <input type="time" value="<%=(court==null)? "07:00:00" :court.getcourtOpenTime()%>"  min="09:00" max="18:00">

                <img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" width="20" height="20" alt="" style="position: relative; left: 15px;">
                <label style="position: relative; left: 15px;" for="time">閉館時間</label>
                <input type="time" value="<%=(court==null)? "21:00:00" :court.getcourtCloseTime()%>" style="position: relative; left: 15px;">
                <br><br>

                <img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" width="20" height="20" alt="">
                <label for="loc">區域</label>
                <input type="text" value="<%=(court==null)? "" :court.getloc()%>" style="position: relative; left: 31px;">
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
                value="<%=(court==null)? "" :court.getcourtAddress()%>" required>
                <font color="#FF0000" size="-1" nowrap="" style="position: relative;left: 1px;">包含鄉鎮區、路街道及門牌號等。</font><br><br>

                <img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" width="20" height="20" alt="">
                <label for="phone">場館電話</label>
                <input type="tel" id="phone" name="phone" value="<%=(court==null)? "" :court.getcourtTelephone()%>"  required>
                <font color="#FF0000" size="-1" nowrap="" style="position: relative;left: 1px;">包含區域碼 如:0212345678。</font>
                <br><br>

                <img src="<%=request.getContextPath()%>/owneruser/pic/stR01.png" width="20" height="20" alt="">
                <label for="courtRule" style="position: relative; left: 23px;">場館須知</label><br><br>
                <input type="text" id="courtRule" name="courtRule" value="<%=(court==null)? "" :court.getcourtRule()%>" required
                 placeholder="Write something.."style="height:300px;width:600px;position: relative;left:23px;"></textarea>
                <br><br><br>

                <label for="courtPic" style="position: relative;left: 23px;">場館照片</label><br><br>
                <form action="/somewhere/to/upload" enctype="multipart/form-data">
	                <input type="file" id="progressbarTWInput" accept="image/gif, image/jpeg, image/png" style="position: relative;left: 23px;"/>
	                <br><br>
	                <img id="preview_progressbarTW_img" src="#" 
	                value="<%=court.getcourtPic()%>"
                	style="height: 300px;position:relative;left: 23px;"/>
                </form>
            </form>
            <br><br><br>



<!--             <label for="placeFee" style="position: relative;left: 23px;" >請輸入各時段之費用( 每時段以一小時計)</label><br><br> -->
<!--             <form id="addItemForm"  style="width: 850px;position: relative;left: 23px;"> -->
<!--                 <label for="courtType">場地類型：</label> -->
<!--                 <select id="ball" name="ball"> -->
<!--                     <option value="0">籃球場</option> -->
<!--                     <option value="1">排球場</option> -->
<!--                     <option value="2">羽球場</option> -->
                    
<!--                 </select> -->

<!--                 <label for="itemName">名稱:</label> -->
<%--                 <input type="text" id="itemName" value="<%=(place==null)? "022562622" :court.getplaceName()%>" name="placeName" style="width: 100px;" placeholder="如A、B、甲、乙" > --%>
<!--                 <font color="#000000" size="-2" nowrap="">一次填寫一個名稱</font> -->

<!--                 <label for="price" style="position: relative;left: 20px;">價格:</label> -->
<!--                 <input type="text" id="placeFee" name="placeFee"  style="width: 120px; position: relative;left: 20px;" placeholder="請輸入價格"> -->
<!--                 <font color="#FF0000" size="-1" nowrap=""  style="position: relative;left: 20px;">小時/元</font> -->

<!--                 <button type="button" id="addButton"  style="position: relative;left: 30px;">新增</button> -->
<!--             </form> -->
<!--             <br> -->

<!--             <label  for="placeFee" style="position: relative;left: 23px;">場地列表</label><br><br> -->

            <div class="itemTable" style="width: 480px;position: relative;left: 24px; background-color: #DAE4F4;">
                <table id="itemTable">
                    <thead>
                        <tr>
                            <th>場地類型</th>
                            <th>名稱</th>
                            <th>價格</th>
                            <th>操作</th>
                        </tr>
                    </thead>
                    <tbody></tbody>
                </table>
            </div>

            <script>
                $(document).ready(function () {
                    $("#addButton").click(function () {
                        var courtType = $("#courtType").val();
                        var itemName = $("#itemName").val();
                        var price = $("#price").val();

                        if (courtType && itemName && placeFee) {
                            var newRow = "<tr>" +
                                "<td>" + courtType + "</td>" +
                                "<td>" + itemName + "</td>" +
                                "<td>" + placeFee + "</td>" +
                                "<td><button class='deleteButton'>刪除</button></td>" +
                                "</tr>";

                            $("#itemTable tbody").append(newRow);

                            // 清空輸入欄位
                            $("#itemName, #price").val("");
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



            <br><br><br><br><br>

            <!-------- 送出按鈕  ------->
            <input type="hidden" name="action" value="update">
			<input type="hidden" name="courtID" value="<%=court.getCourtID()%>">
			<input type="button" value="確認修改" name="按鈕名稱" style="width: 150px; height: 44px;"> 
        </FORM>
        </main>
    </div>
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