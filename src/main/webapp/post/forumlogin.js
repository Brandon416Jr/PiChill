//
//	//======登入重導======

$(document).ready(function() {
    // 在這裡附加事件處理程序

    $("#create-post-button").on("click", Userlogin);
    $('.task_add2').on("click", Userlogin);
    $('#send_report2').on("click", Userlogin);
    $('#send_report').on("click", Userlogin);
    $('#send_report3').on("click", Userlogin);
    $("#exampleModal5").on("click", "#likecol", Userlogin);
    $("#exampleModal6").on("click", "#likecol", Userlogin);
});
	function Userlogin() {
	 if ($('#userID').val() === "null") { 
        console.log($('#userID').val());
        var confirmation = window.confirm("您尚未登入，是否跳轉到登入頁面？");
        if (confirmation) {
            window.location.href = "http://localhost:8081/PiChill/login/gLogin/gUserLogin.jsp";       
        } else {
        }
    }
    if ($('#userStatus').val() === "2") { 
        var confirmation = alert("您的帳號遭停權，暫時無法使用該功能");
    }
	}

