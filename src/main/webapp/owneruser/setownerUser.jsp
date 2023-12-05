<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.pichill.owneruser.OwnerUser"%>

<%
//見com.emp.controller.EmpServlet.java第238行存入req的empVO物件 (此為輸入格式有錯誤時的empVO物件)
OwnerUser owneruser = (OwnerUser) request.getAttribute("owneruser");
%>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="BIG5">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>企業會員中心</title>
	<link 
	href="<%=request.getContextPath()%>/owneruser/css1/bootstrap.min.css"
	rel="stylesheet" >
	<link rel="stylesheet" href="./CSS/index3.css">
	<script src="./JS/bootstrap.min.js"></script>

	<style>
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
	</style>
</head>
<!----------------------------------------------- header 區 ------------------------------------------------------->
    <header class="header">
        <div class="container">
            <header class="d-flex flex-wrap justify-content-center py-1">
                <a href="/"
                    class="d-flex align-items-center mb-1 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
                    <img src="../pic/headerlogo.svg" alt="SVG" />
                </a>


                <ul class="nav nav-pills">
                    <li class="nav-item"><a href="#" class="nav-link">首頁</a></li>
                    <li class="nav-item"><a href="#" class="nav-link">通知</a></li>
                    <li class="nav-item"><a href="#" class="nav-link">預約管理系統</a></li>
                    <li class="nav-item"><a href="#" class="nav-link">論壇</a></li>
                    <li class="nav-item"><a href="#" class="nav-link">聯絡我們</a></li>
                    <li class="nav-item"><a href="#" class="nav-link">會員中心</a></li>
                    <li class="nav-item"><a href="#" class="nav-link"><img src="/pic/face.svg" alt="SVG" /> 會員中心</a>
                    </li>
                </ul>

                <!-- <label for="burger">☰</label>
              <input type="hidden" id="burger"> -->
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
                                aria-controls="forms-collapse" href="index4.html">申請上架球館</button>
                        </li>
                        <li class="my-2">
                            <button class="btn d-inline-flex align-items-center collapsed border-0"
                                data-bs-toggle="collapse" aria-expanded="false" data-bs-target="#forms-collapse"
                                aria-controls="forms-collapse">球館管理</button>

                        </li>
                        <li class="my-2">
                            <button class="btn d-inline-flex align-items-center collapsed border-0"
                                data-bs-toggle="collapse" aria-expanded="false" data-bs-target="#forms-collapse"
                                aria-controls="forms-collapse">申請優惠券上架</button>
                        </li>
                    </ul>
                </nav>
            </div>
        </aside>

        <!----------------------------------------------- main 區 ------------------------------------------------------->
        <main class="main">
            <br>
            <!--<br>
            <br> -->
            <h2>企業會員資料</h2>

            <br>
            <p>
                <span style="color:#FF0000;">前有<img src="pic/stR01.png" width="20" height="20" alt="">為必填項目</span>
            </p>

            <div class="phone1">
                <!-- 上傳圖片 -->
                <form method="post" enctype="multipart/form-data">
                    <div>
                        <input type="file" id="image_uploads" name="image_uploads" accept=".jpg, .jpeg, .png"
                        value="<%=(owneruser == null) ? "" : owneruser.getoProfilePic()%>"
                            style="height:200px;width:200px;position:absolute;">
                    </div>
                    <div class="preview"
                        style="float:left;background:#cccccc;height:200px;width: 200px;text-align:center;z-index:1;">
                        <p style="line-height: 200px;">未選擇任何檔案</p>
                    </div>
                </form>
            </div>
        

            <form action="/submit" method="post" enctype="multipart/form-data">
                <img src="pic/stR01.png" width="20" height="20" alt="">
                <label for="ousername">帳號：</label>
                <input type="text" id="username" name="oUserName" 
                value="<%=(owneruser == null) ? "happybo299" : owneruser.getoUserName()%>"
                required><br><br>


                <img src="pic/stR01.png" width="20" height="20">
                <label for="password">新密碼：</label>
                <input type="password" id="password" name="oPassword" 
                value="<%=(owneruser == null) ? "Jisoo2023" : owneruser.getoPassword()%>"
                required>
                <font color="#FF0000" size="-1" nowrap="">請輸入8~12字，須包含數字、大小寫英文字母</font><br><br>


             <!--   <img src="pic/stR01.png" width="20" height="20"> 
                <label for="confirm_password">再次輸入新密碼：</label>
                <input type="password" id="confirm_password" name="confirm_password" placeholder="需同上方密碼" required>
                <br><br>  -->

                <img src="pic/stR01.png" width="20" height="20" >
                <label for="compiled">統編：</label>
                <input type="text" id="tax_id" name="compiled" 
                value="<%=(owneruser == null) ? "93366340" : owneruser.getCompiled()%>"
                required><br><br>

                <img src="pic/stR01.png" width="20" height="20" >
                <label for="oName">場館負責人姓名:</label>
                <input type="text" id="phone" name="oName" 
                value="<%=(owneruser == null) ? "金元萱" : owneruser.getoName()%>"
                required><br><br>

                <tr>
                    <img src="pic/stR01.png" width="20" height="20" >
                    <td>性別：</td>
                    <td>
                        <!-- name 需相同，表示同一組單選，checked 為預設勾選選項 -->
                        <input type="radio" name="oGender" value="0" checked />男
                        <input type="radio" name="oGender" value="1" />女
                    </td>
                </tr><br><br>

                <img src="pic/stR01.png" width="20" height="20" alt="">
                <label for="oIDNum">場館負責人身分證字號:</label>
                <input type="text" id="oIDNum" name="oIDNum" 
                value="<%=(owneruser == null) ? "F220377768" : owneruser.getoIDNum()%>"
                placeholder="A123456789" required><br><br>

                <img src="pic/stR01.png" width="20" height="20" alt="">
                <label for="dob">出生年月日：</label>
                <input type="date" id="dob" name="dob" required><br><br>

                <img src="pic/stR01.png" width="20" height="20" alt="">
                <label for="oTelephone">連絡電話：</label>
                <input type="text" id="address" name="oTelephone" 
                value="<%=(owneruser == null) ? "02-89201106" : owneruser.getoTelephone()%>"
                required>
                <font color="#FF0000" size="-1" nowrap="">包含區域碼 如:02-12345678#000。</font>
                <br><br>

                <img src="pic/stR01.png" width="20" height="20" alt="">
                <label for="oAddress">連絡地址：</label>
                <input type="text" id="address" name="oAddress" 
                 value="<%=(owneruser == null) ? "臺北市信義區基隆路2段23號1樓" : owneruser.getoAddress()%>"
                required> <br><br>

                <img src="pic/stR01.png" width="20" height="20" alt="">
                <label for="oBankCode">銀行代號：</label>
                <input type="text" id="bank_branch" name="bank_branch" 
                value="<%=(owneruser == null) ? "081" : owneruser.getoAddress()%>"
                placeholder="如:012" required>
                <br><br>

                <img src="pic/stR01.png" width="20" height="20" alt="">
                <label for="oBankAccount">銀行帳號：</label>
                <input type="text" id="bank_account" name="bank_account" 
                value="<%=(owneruser == null) ? "081" : owneruser.getoBankAccount()%>"
                required><br><br>

                <img src="pic/stR01.png" width="20" height="20" alt="">
                <label for="oEmail">電子信箱：</label>
                <input type="oEmail" id="bank_account" name="oEmail" 
                value="<%=(owneruser == null) ? "happybo299@gmail.com" : owneruser.getoEmail()%>"
                required>
                <font color="#FF0000" size="-1" nowrap="">電子信箱格式範例: abc@yahoo.com.tw</font>

            </form>
            <br><br>
            <br>

            <!-------- 送出按鈕  ------->
            <input type="button" value="確認修改" name="按鈕名稱" style="width:150px; height:44px;">
            <input type="button" value="取消" name="按鈕名稱" style="width:150px; height:44px;">

        </main>
    </div>
    </div>


    <!-------- 上傳圖片  ------->
    <script>
        var input = document.getElementById('image_uploads');
        var preview = document.querySelector('.preview');

        input.style.opacity = 0;
        input.addEventListener('change', updateImageDisplay); function updateImageDisplay() {
            while (preview.firstChild) {
                preview.removeChild(preview.firstChild);
            }

            if (input.files.length === 0) {
                var para = document.createElement('p');
                para.textContent = '未選擇任何檔案';
                para.style = "line-height: 300px;";
                preview.appendChild(para);
            }
            else {
                var para = document.createElement('p');
                var image = document.createElement('img');
                image.src = window.URL.createObjectURL(input.files[0]);
                preview.appendChild(image);
                preview.appendChild(para);
            }
        }



    </script>



    <!----------------------------------------------- footer 區 ------------------------------------------------------->
    <footer class="footer">

        <div class="container">
            <header class="d-flex flex-wrap justify-content-center py-3">
                <a href="/"
                    class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
                    <img src="../pic/footerlogo.svg" alt="SVG" />
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

    
</body>

</html>