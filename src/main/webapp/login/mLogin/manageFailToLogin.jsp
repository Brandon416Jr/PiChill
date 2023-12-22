<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>管理員帳號被鎖定</title>
<style>
html, body {
	margin: 0;
	padding: 0;
	height: 100%;
	overflow: hidden;
}

.src {
	width: 100%;
	height: 100%;
	object-fit: cover;
}

p {
	position: absolute;
	top: 0;
	left: 50%;
	transform: translateX(-50%);
	white-space: nowrap;
	font-size: 30px;
	color: red;
}
</style>
</head>
<body>

	<img src="<%=request.getContextPath()%>/backEnd-Website/pic/404.jpg"
		alt="404" class="src">
	<p id="lockMessage">由於你輸入多次錯誤帳號密碼，帳號已被鎖住，請10分鐘以後再進行登入。</p>

	<script>
// 定期檢查是否可以解鎖
var lockoutTime = <%=request.getAttribute("lockoutTime")%>;
setInterval(function() {
    if (new Date().getTime() >  lockoutTime) {
        // 鎖定時間已經結束，重新導向到登入頁面
        window.location.href = "<%=request.getContextPath()%>
		/login/mLogin/manageLogin.jsp";
					}
				}, 10000); // 每秒檢查一次
	</script>

</body>
</html>