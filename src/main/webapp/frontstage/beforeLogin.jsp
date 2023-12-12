<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>π Chill登入首頁</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/backEnd-Website/css/bootstrap.min.css">

    <style>
        *{
            box-sizing: border-box;
            font-family: "Noto Sans CJK TC", "Microsoft JhengHei", PingFang, STHeiti, sans-serif, serif;
        }
        body{
            margin: 0;
            padding: 0;
            overflow: visible;
        }

        /* LOGO */
        img{
            /* max-width: 100%; */
            width: 400px;
            height: 160px;
            position: absolute;
            left: 100px;
            top: 50px;
        }

        /* welcome */
        div.welcome{
            /* border: 1px solid yellow; */
            color:#FF9F1B;
            font-weight: bold;
            font-size: 50px;
            position: absolute;
            left: 100px;
            top: 210px;
        }
        /* 背景圖 */
        div.banner{
            /* border: 1px solid red; */
            width:100%;
            height:100vh;
            /* background-image: url('./pic/m_login.png'); */
            position: relative;
            right: 0px;
            /* z-index: 2; */
            }

        /* 一般會員按鈕 */
        input#genbtn{
            border: 5px solid #FFFFFF;
            width: 200px;
            height: 200px;
            border-radius:8px;
            position: absolute;
            left: 300px;
            top: 370px;
            font-size: 40px;
            font-weight: bold;
            color: #FFFFFF;
            background-color: #FF9F1B;
            opacity: .8;
        }
        input#genbtn:hover{
            color:#FF9F1B;
            background-color:#fff;
            border:5px #FF9F1B solid;
        }
        /* 企業會員按鈕 */
        input#ownbtn{
            border: 5px solid #FFFFFF;
            width: 200px;
            height: 200px;
            border-radius:8px;
            position: absolute;
            left: 750px;
            top: 370px;
            font-size: 40px;
            font-weight: bold;
            color: #FFFFFF;
            background-color: #207DCA;
            opacity: .8;
        }
        input#ownbtn:hover{
            color:#207DCA;
            background-color:#fff;
            border:5px #207DCA solid;
        }

        .all {
            /* background: #e5e5e5; */
            height: 100vh;
            background-image: url("<%=request.getContextPath()%>/backEnd-Website/pic/m_login.png");
            background-repeat: no-repeat;
            background-size: cover;
            background-position: center;
        }

    </style>
    
</head>
<body>
  <div class="all">
    <!-- <img src="./pic/m_login.png" height="1000" width="1000"> -->
  
    <div class="banner">
        <img src="<%=request.getContextPath()%>/backEnd-Website/pic/Group 460.png">
        <div class="welcome">
            <p>Welcome  to  π  CHILL !</p>
        </div>
        <form class="btn" enctype="multipart/form-data">
            <input type="submit" id="genbtn" value="一般&#13;&#10;會員" formaction="<%=request.getContextPath()%>/frontstage/generalUserFront/gUserLogin.jsp">
            <input type="submit" id="ownbtn" value="企業&#13;&#10;會員" formaction="<%=request.getContextPath()%>/frontstage/ownerUserFront/oUserLogin.jsp">
        </form>
    </div>
  </div>
</body>
</html>