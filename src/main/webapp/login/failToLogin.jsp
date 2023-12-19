<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>

<p id="lockMessage">帳號已被鎖定，請稍候再試。</p>

<script>
// 定期檢查是否可以解鎖
var lockoutTime = <%= request.getAttribute("lockoutTime") %>;
setInterval(function() {
    if (new Date().getTime() >  lockoutTime) {
        // 鎖定時間已經結束，重新導向到登入頁面
        window.location.href = "/login/mLogin/manageLogin";
    }
}, 1000); // 每秒檢查一次
</script>

</body>
</html>