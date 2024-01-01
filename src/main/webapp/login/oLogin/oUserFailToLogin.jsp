<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>企業會員帳號鎖定</title>
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
	// 移除從request中獲取lockoutTime的代碼
	var basePath = "<%=request.getContextPath()%>"; 
	var lockoutTime = 10 * 1000; // 固定為10秒

	var delay = lockoutTime;

	function check() {

		if (delay > 0) {
			delay = delay - 1000;
			setTimeout(check, 1000);
		} else {
			location.href = basePath + "/login/oLogin/oUserLogin.jsp";
		}

	}

	setTimeout(check, 0); // 立即執行跳轉檢查
	</script>

</body>
</html>