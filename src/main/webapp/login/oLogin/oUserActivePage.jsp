<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>企業會員註冊成功尚未驗證</title>
<style>
body {
	background: url("<%=request.getContextPath()%>/backEnd-Website/pic/m_login.png") no-repeat center center fixed;
	-webkit-background-size: cover;
	-moz-background-size: cover;
	-o-background-size: cover;
	background-size: cover;
	position: relative;
	z-index: -100;
}

body, html {
	margin: 0;
	height: 100%;
	overflow: hidden;
}

div.all_place {
	position: absolute;
	top: 50%;
	left: 50%;
	text-align: center;
	transform: translate(-50%, -50%);
	/* border: 2px solid red; */
	background-color: black;
	opacity: 0.85;
	width: 55%;
	height: 21%;
	border-radius: 12.5px;
}

p.text {
	font-size: 18px;
	color: antiquewhite;
	text-align: center;
}

input.type {
	display: block;
	margin: 0 auto;
	background-color: orange;
	color: black;
	height: 36px;
	border-radius: 12.5px;
}

input.type:hover {
	color: #207DCA;
	background-color: azure;
}

input.type:active {
	color: red;
	background-color: azure;
}
</style>
</head>
<body>
	<div class="all_place">
		<p class="text">
			恭喜您，已經成功註冊<b>PiChill</b>會員，由於尚未驗證，因此還不能登入。 <br>
			請於十分鐘內至您註冊的信箱點選連結，便會帶您導入登入畫面。謝謝您的註冊!
		</p>
		<form action="${pageContext.request.contextPath }/owneruser/owneruserf.do">
			<input type="hidden" name="action" value="sendMailAgain" class="type"> <input
				type="submit" value="重新發送驗證連結" class="type">
		</form>
	</div>
</body>
</html>