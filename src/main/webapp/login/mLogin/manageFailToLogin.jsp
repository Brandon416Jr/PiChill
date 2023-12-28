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
	var basePath = "<%=request.getContextPath()%>"; 
		// 定期檢查是否可以解鎖
		var lockoutTime =
	<%=request.getAttribute("lockoutTime")%>
		;
		console.log("鎖定時間：" + lockoutTime);
		var delay = lockoutTime - new Date().getTime();
		function check() {
			if (delay > 0) {
				// 鎖定時間還沒到，停留在當前頁面
				delay = delay - 1000;
				setTimeout(check, 1000);
				console.log("延遲：" + delay);
			} else {
		
			    location.href = basePath + "/login/mLogin/manageLogin.jsp";
			  }
		}
		setInterval(function() {
			location.reload();

			lockoutTime =<%=request.getAttribute("lockoutTime")%>;
			delay = lockoutTime - new Date().getTime();

			check();

		}, 10000); 
	</script>

</body>
</html>