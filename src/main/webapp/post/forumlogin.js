//
//	//======登入重導======
//$(document).ready(function() {
//    // 在這裡附加事件處理程序
//    $("#create-post-button").on("click", Userlogin);
//    $('#send_report2').click(Userlogin);
//    $('#send_report').click(Userlogin);
//    $('#send_report3').click(Userlogin);
//    $("#exampleModal5").on("click", "#likecol", Userlogin);
//    $("#exampleModal6").on("click", "#likecol", Userlogin);
//});
//	function Userlogin() {
//		if (!isUserLoggedIn()) {
//			var confirmation = window.confirm("您尚未登入，是否跳轉到登入頁面？");
//			if (confirmation) {
//				window.location.href = "${request.getContextPath()}/login/gLogin/gUserLogin.jsp";
//			} else {
//				console.log("觸發");
//				$("#exampleModal").modal("hide");
//			}
//		}
//	}
//		function isUserLoggedIn() {
//		var user = sessionStorage.getItem("gUsername"); // 假設你在 session 或 localStorage 中存儲了用戶信息
//		return user !== null;
//	}
