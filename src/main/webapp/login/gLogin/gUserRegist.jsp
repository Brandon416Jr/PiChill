<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.pichill.generaluser.entity.GeneralUser"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%
//見com.emp.controller.EmpServlet.java第238行存入req的empVO物件 (此為輸入格式有錯誤時的empVO物件)
GeneralUser generalUser = (GeneralUser) request.getAttribute("generalUser");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>一般會員註冊</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/backEnd-Website/vendor/bootstrap-4.1/bootstrap.min.css" />
<!-- Vendor CSS-->
<link
	href="<%=request.getContextPath()%>/backEnd-Website/vendor/animsition/animsition.min.css"
	rel="stylesheet" media="all" />
<link
	href="<%=request.getContextPath()%>/backEnd-Website/vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css"
	rel="stylesheet" media="all" />
<link
	href="<%=request.getContextPath()%>/backEnd-Website/vendor/wow/animate.css"
	rel="stylesheet" media="all" />
<link
	href="<%=request.getContextPath()%>/backEnd-Website/vendor/css-hamburgers/hamburgers.min.css"
	rel="stylesheet" media="all" />
<link
	href="<%=request.getContextPath()%>/backEnd-Website/vendor/slick/slick.css"
	rel="stylesheet" media="all" />
<link
	href="<%=request.getContextPath()%>/backEnd-Website/vendor/select2/select2.min.css"
	rel="stylesheet" media="all" />
<link
	href="<%=request.getContextPath()%>/backEnd-Website/vendor/perfect-scrollbar/perfect-scrollbar.css"
	rel="stylesheet" media="all" />
<!-- Main CSS-->
<link href="<%=request.getContextPath()%>/backEnd-Website/css/login.css"
	rel="stylesheet" media="all" />
<style type="text/css">
button.au-btn {
	/* border: 2px solid red; */
	background-color: #207DCA;
	/* margin: 5px; */
}

div.register {
	border: 1.5px solid red;
	height: auto;
}

.login-form {
	max-height: 360px;
	overflow-y: auto;
}

.city-select, .area-select {
	display: block;
}

.area-select {
	margin-top: 10px;
	margin-bottom: 10px;
	padding-top: 10px;
	border-top: 1px solid #ddd;
}

div.row div.col-1 input.btn {
	/* 	border: 1px solid red; */
	width: 150%;
	height: 40px;
	margin-bottom: 1px;
}

div.register-link {
	/* border: 1px solid green; */
	margin-top: 0;
}

div.pwd-see {
	display: flex;
	align-items: center;
}

label.pwd-see2 {
	margin-left: 5px;
}

div.modal {
	/* border: 2px solid red; */
	width: 80%;
	height: 80%;
	left: 10%;
	top: 10%;
}

div.modal-content {
	/* border: 2px solid black; */
	width: 100%;
	height: 100%;
	padding-top: 20px;
}

pre {
	/*   position: fixed; */
	/*   top: 0; */
	/*   left: 0; */
	/*   width: 100%; */
	/*   height: 100%; */
	/*   z-index: 999; */
	background: white;
	overflow-y: auto;
	margin-bottom: 0;
}

div.moralf {
/* 	border: 1px solid red;  */
	height: 165px;
	/* position: relative; */
/* 	position: absolute; */

}

button.agreeterm {
/* 	border: 1px solid purple;  */
	background-color: #207DCA;
	color: white;
	margin: 0;
	padding: 0;
	width: 75px;
	border-radius: 5px;
	
	position: absolute;
	right: 46.5%;
}

button.agreeterm: hover {
/* 	border: 1px solid purple;  */
	background-color: orange;
/* 	color: white; */
/* 	margin: 0; */
/* 	padding: 0; */
/* 	width: 75px; */
/* 	border-radius: 5px; */
	
/* 	position: absolute; */
/* 	right: 46.5%; */
}
</style>
</head>
<body class="animsition">
	<div class="all">
		<!-- <img src="./pic/m_login.png" height="1000" width="1000"> -->
	</div>
	<div class="page-wrapper">
		<div class="page-content--bge5">
			<div class="container">
				<div class="login-wrap">
					<div class="login-content">
						<div class="login-logo">
							<a href="#"> <img
								src="<%=request.getContextPath()%>/backEnd-Website/pic/g_register.png"
								alt="CoolAdmin">
							</a>
						</div>
						<div class="login-form">
							<form
								action="${pageContext.request.contextPath }/generaluser/generaluserf.do"
								method="post" enctype="multipart/form-data">
								<div class="form-group">
									<label for="gUsername">帳號</label><font color=red>${errorMsgs.gUsername}</font>
									<input class="au-input au-input--full" type="text"
										name="gUsername" placeholder="請輸入帳號" id="gUsername"
										value="<%=(generalUser == null) ? "" : generalUser.getgUsername()%>">
								</div>
								<div class="form-group">
									<label>信箱</label><font color=red>${errorMsgs.gEmail}</font> <input
										class="au-input au-input--full" type="text" name="gEmail"
										placeholder="請輸入信箱"
										value="<%=(generalUser == null) ? "" : generalUser.getgEmail()%>">
								</div>
								<div class="form-group">
									<label>密碼</label><font color=red>${errorMsgs.gPassword}</font>
									<input class="au-input au-input--full" type="password"
										id="password" name="gPassword" placeholder="請輸入密碼"
										value="<%=(generalUser == null) ? "" : generalUser.getgPassword()%>">
									<div class="pwd-see">
										<input type="checkbox" id="togglePwd"> <label
											class="pwd-see2" for="togglePwd">顯示密碼</label>
									</div>
								</div>
								<div class="form-group">
									<label>再次確認密碼</label><font color=red>${errorMsgs.gPaaword2}</font>
									<input class="au-input au-input--full" type="password"
										id="password2" name="gPassword2" placeholder="請再次輸入密碼">
									<div class="pwd-see">
										<input type="checkbox" id="togglePwd2"> <label
											class="pwd-see2" for="togglePwd2">顯示密碼</label>
									</div>
								</div>
								<div class="form-group">
									<label>姓名</label><font color=red>${errorMsgs.gName}</font> <input
										class="au-input au-input--full" type="text" name="gName"
										placeholder="請輸入姓名"
										value="<%=(generalUser == null) ? "" : generalUser.getgName()%>">
								</div>
								<div class="form-group">
									<label>匿稱ID</label><font color=red>${errorMsgs.nicknameID}</font>
									<input class="au-input au-input--full" type="text"
										name="nicknameID" placeholder="請輸入暱稱ID"
										value="<%=(generalUser == null) ? "" : generalUser.getNicknameID()%>">
								</div>
								<div class="form-group">
									<label>電話</label><font color=red>${errorMsgs.gTelephone}</font>
									<input class="au-input au-input--full" type="text"
										name="gTelephone" placeholder="請輸入電話"
										value="<%=(generalUser == null) ? "" : generalUser.getgTelephone()%>">
								</div>
								<div class="form-group">
									<label>性別</label><font color=red>${errorMsgs.gGender}</font> <select
										class="au-input au-input--full" name="gGender">
										<option value="3">請選擇性別</option>
										<option value="0">男</option>
										<option value="1">女</option>
									</select>
								</div>
								<div class="form-group">
									<label>生日</label><font color=red>${errorMsgs.gBirth}</font> 
									<%
													Date today = new Date();
													SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
													String todayStr = sdf.format(today);
													%>
									<input
										class="au-input au-input--full" placeholder="請輸入生日" max="<%=todayStr%>"
										type="date" name="gBirth"
										value="<%=(generalUser == null) ? "" : generalUser.getgBirth()%>">

								</div>
								<div class=" form-group">

									<label for="text-input">聯絡地址</label><font color=red>${errorMsgs.gAddress}</font>

									<div class="city-select">
										<select class="au-input au-input--full" id="city" name="city"
											required>
											<option value="">請選擇縣市</option>
										</select>
									</div>
									<div class="area-select">
										<select class="au-input au-input--full" id="area" name="area"
											required>
											<option value="">請選擇鄉鎮市區</option>
										</select>
									</div>
									<input type="text" id="text-input" name="gAddress"
										placeholder="請輸入聯絡地址" class="form-control" />
								</div>
								<div class="form-group">
									<label>身分證</label><font color=red>${errorMsgs.gIDNum}</font> <input
										class="au-input au-input--full" type="text" name="gIDNum"
										placeholder="請輸入身分證"
										value="<%=(generalUser == null) ? "" : generalUser.getgIDNum()%>">
								</div>
								<div class="form-group">

									<label>註冊日期</label> <input class="au-input au-input--full"
										type="date" name="gRegistDate"
										value="<%=(generalUser == null) ? "" : generalUser.getgRegistDate()%>">

								</div>
								<div class="form-group">
									<label for="file-input">上傳大頭貼</label><font color=red>${errorMsgs.gProfilePic}</font>
									<input type="file" name="gProfilePic" onclick="previewImage()"
										multiple="multiple" onchange="hideContent('upFiles.errors');" value="${generalUser.gProfilePic }"
										class="form-control-file"><img id="imagePreview"
										src="#" alt="Preview" />
								</div>
								<div class="login-checkbox">
									<label onclick="showTerms()"> <input type="checkbox"
										name="agree" disabled>是否同意使用者條款
									</label><font color=red>${errorMsgs.agree}</font>
								</div>

								<div class="row form-group">
									<div class="col-1 col-md-8">
										<input type="hidden" name="action" value="insert"><input
											type="submit" class="btn btn-primary btn-sm" value="註冊">
										<i class="fa fa-dot-circle-o"></i>
									</div>
								</div>
							</form>
							<div class="register-link">
								<p>
									已經有帳號了嗎? <a
										href="${pageContext.request.contextPath }/login/gLogin/gUserLogin.jsp">登入</a>
								</p>
							</div>
						</div>
					</div>
					<div class="left-image">
						<img
							src="<%=request.getContextPath()%>/backEnd-Website/pic/Group 460.png" />
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="modal" id="termsModal">
		<div class="modal-content">
			<pre>
        【  使用者條款  】
        ●本會員服務條款所稱之「會員」，為依照本站所定之加入會員程序加入完成並通過認證者。
        ●當您使用本站服務時，即表示您同意及遵守本服務條款的規定事項及相關法律之規定。
        ●本站保留有審核加入會員資格之權利，另外已加入會員者，本站亦保留有解除其會員資格之權利。
        ●本會員服務條款之修訂，適用於所有會員，當本站修訂本服務條款時，將於本站上公告。
        會員
        ●使用本站所提供之會員服務時，於加入會員時所登錄之帳號及密碼使用之。
        ●會員須善盡帳號及密碼的使用與管理之責任。對於使用該會員之帳號及密碼(無關於會員本身或其他人)利用本站服務所造成或衍生之所有行為及結果，會員須自行負擔全部責任。
        ●會員之帳號及密碼遺失，或發現無故遭第三者盜用時，應立即通知本站連絡掛失，因未即時通知，導致本站無法有效防止及修改時，所造成的所有損失，會員應自負全責。
        ●每次結束使用本服務，執行會員之登出並關閉視窗，以確保您的會員權益。
        ●盜用第三者會員之帳號及密碼，導致第三者或本公司遭其他第三人或行政機關之調查或追訴時，第三者會員或本公司有權向您請求損害賠償，包括但不限於訴訟費用、律師費及商譽損失等。

        會員登錄資料
        ●會員登錄資料須提供您本人正確、最新及完整的資料。
        ●會員登錄資料不得有偽造、不實等之情事(EX如個人資料及信用卡資料)，一經發現本公司可拒絕其加入會員資格之權利。並得以暫停或終止其會員資格，若違反中華民國相關法律，亦將依法追究。
        ●會員基本資料(EX:住址，電話及其他登錄資料)有變更時，請不定期更新相關個人資料，確保其正確及完整性。若您提供的資料有錯誤或不符等現象，本網站有權暫停或終止您的帳號，並拒絕您繼續使用本服務。
        ●未經會員本人同意，本公司原則上不會將涉及個人隱私之資料開示給第三者，唯資料共用原則…等不在此限(請參閱本站「隱私權保護聲明」相關規定)。
        ●會員應妥善保管密碼，不可將密碼洩露或提供給他人知道或使用；以同一個會員身分證字號和密碼使用本服務所進行的所有行為，都將被認為是該會員本人和密碼持有人的行為。
        ●會員如果發現或懷疑有第三人使用其會員身分證字號或密碼，應該立即通知本公司，採取必要的防範措施。但上述通知不得解釋為本公司對會員負有任何形式之賠償或補償之責任或義務。

        使用行為
        1. 您使用本服務之一切行為必須符合當地或國際相關法令規範；對於使用者的一切行為，您須自行負擔全部責任。
        2. 您同意絕不為非法之目的或以非法方式使用本服務，與確實遵守中華民國相關法規及網際網路之國際慣例，並保證不得利用本服務從事侵害他人權益或違法之行為。
        3. 您於使用本站會員服務時應遵守以下限制：
          (1)有損他人人格或商標權、著作權等智慧財產權或其他權利內容。
          (2)使用違反公共秩序或善良風俗或其他不法之文字。
          (3)強烈政治、宗教色彩的偏激言論。
          (4)未經本公司許可，不得利用本服務或本網站所提供其他資源，包括但不限於圖文資料庫、編寫製作網頁之軟體等，從事任何商業交易行為，或招攬廣告商或贊助人。
          (5)其他違反本站「會員服務條款」的內容。

        本公司專有權利
        ●本服務所載，或本服務所連結之一切軟體或內容，或本公司之廣告商或合夥人所提供之內容，均受其著作權或其他專有權利或法律所保障。
        ●當您傳輸資料至本公司提供之服務時，您即同意此一資料為全開放性(任何人均可瀏覽)。您授權並許可本公司得以重製、修飾、改編或以其他形式使用該內容之全部或一部分，
        及利用該內容製作衍生著作。衍生著作之著作權悉歸本公司所有。
        ●本公司同意除依本使用條款約定，將前述您的資料及衍生著作置於本網站供網路使用者瀏覽，以及本公司所屬相關媒體外，絕不非法轉供其他直接營利目的或侵害您的權利之使用。
        ●所有網頁之頁面出現之廣告看板與活動訊息，所有權及經營權均為本公司所有，使用者除事先取得本公司同意外，不得自行使用所有訊息。
        ●會員同意並授權本網站，得為提供個人化服務或相關加值服務之目的，提供所需之會員資料給合作單位(第三者)做約定範圍內之運用，如會員不同意將其資料列於合作單位(第三者)產品或服務名單內，
        可通知本網站於名單中刪除其資料，並同時放棄其本網站以外之購物優惠或獲獎權利。
        ●同時為提供行銷、市場分析、統計或研究、或為提供會員個人化服務或加值服務之目的，會員同意本公司、或本公司之策略合作夥伴，得記錄、保存、並利用會員在本網站所留存或產生之資料及記錄，
        同時在不揭露各該資料之情形下得公開或使用統計資料。
        ●對於會員所登錄之個人資料，會員同意本網站得於合理之範圍內蒐集、處理、保存、傳遞及使用該等資料，
        以提供使用者其他資訊或服務、或作成會員統計資料、或進行關於網路行為之調查或行銷研究。

        終止授權
        您使用本服務之行為若有任何違反法令或本使用條款或危害本網站或第三者權益之虞時，本公司有權不經告知您，立即暫時或永久終止您使用本服務之授權。
        免責事項
        1.下列情形發生時，本網站有權可以停止、中斷提供本服務：
          (1)對本服務相關軟硬體設備進行更換、升級、保養或施工時。
          (2)發生突發性之電子通信設備故障時。
          (3)天災或其他不可抗力之因素致使本網站無法提供服務時。
        2.本公司對於使用者在使用本服務或使用本服務所致生之任何直接、間接、衍生之財產或非財產之損害，不負賠償責任。
        3.使用者對於上傳留言之文字、圖片及其它資料，應自行備份；本公司對於任何原因導致其內容全部或一部之滅失、毀損，不負任何責任。
        4.本公司對使用本服務之用途或所產生的結果，不負任何保證責任，亦不保證與本服務相關之軟體無缺失或會予以修正。
        5.對於您在本站中的所有言論、意見或行為僅代表您個人；不代表本公司的立場，本公司不負任何責任。本公司對於使用者所自稱之身分，不擔保其正確性。
        6.本公司無須對發生於本服務或透過本服務所涉及之任何恐嚇、誹謗、淫穢或其他一切不法行為對您或任何人負責。
        7.對於您透過本服務所購買或取得，或透過本公司之贊助者或廣告商所刊登、銷售或交付之任何貨品或服務，您應自行承擔其可能風險或依法向商品或服務提供者交涉求償，
        與本公司完全無關，本公司均不負任何責任。

        修改權
        ●當您開始使用本服務時，即表示您已充分閱讀、瞭解與同意接受本條款之內容。本公司有權於任何時間修改與變更本條款之內容，並將不個別通知會員，
        建議您定期查閱本服務條款。如您於本條款修改與變更後仍繼續使用本服務，則視為您已閱讀、瞭解與同意接受本條款修改或變更。
        ●本公司有權暫時或永久修改或中止提供本服務給您，您不得因此要求任何賠償。

        智慧財產權保護
        ●本網站所使用之軟體、程式及網站上所有內容，包括但不限於著作、圖片、檔案、資訊、資料、網站架構、網頁設計，均由本網站或其他權利人依法擁有其智慧財產權，
        包括但不限於商標權、專利權、著作權、營業秘密與專有技術等。
        ●任何人不得逕行使用、修改、重製、公開播送、改作、散布、發行、公開發表、進行還原工程、解編或反向組譯。如欲引用或轉載前述之軟體、程式或網站內容，
        必須依法取得本網站或其他權利人的事前書面同意。如有違反之情事，您應對本網站或其他權利人負損害賠償責任（包括但不限於訴訟費用及律師費用等）。

        其他規定
        ●本網站使用者條約，免責之內容，亦構成本使用條款之一部分。
        ●若因您使用本服務之任何行為，導致本公司遭第三人或行政機關之調查或追訴時，本公司有權向您請求損害賠償，包括但不限於訴訟費用、律師費及商譽損失等。

        本公司針對可預知之軟硬體維護工作，有可能導致系統中斷或是暫停者，將會於該狀況發生前，以適當之方式告知會員。

        會員身分終止與本公司通知之義務
        ●本公司具有更改各項服務內容或終止任一會員帳戶服務之權利。
        ●若會員決定終止本公司會員資格，可直接以電子郵件的方式通知本公司或是由本公司所提供之機制進行取消，本公司將儘快註銷您的會員資料。
        ●會員有通知取消本公司會員資格之義務，並自停止本公司會員身份之日起（以本公司電子郵件發出日期為準），喪失所有本服務所提供之優惠及權益。
        ●為避免惡意情事發生致使會員應享權益損失，當會員通知本公司停止會員身份時，本公司將再次以電子郵件確認無誤後，再進行註銷會員資格。
        【隱私權政策】
        為了讓您瞭解當您造訪我們的網站時，所享有關於個人資料（個人資料是指得以識別您的身分且未公開的資料，如姓名、地址、電子郵件地址或電話號碼）保護的權利，
        我們將逐項說明如下，若有任何意見或疑問，歡迎您與我們聯絡。

        隱私權政策適用範圍

        隱私權政策適用於您使用本網站服務時所提供的個人資料。您經由本網站所提供的連結點選進入其他網站時，您在該網站中不適用本網站的隱私權保護政策。
        我們在何種情況下蒐集您的資料
        ●本網站為了更準確的提供您服務或回覆您的問題，因而需要請您在下列情況下提供個人相關資料：
        1.當您要加入本網站會員以獲得我們的會員服務時
        2.當您要向本網站洽詢服務訊息時
        3.當您要參加我們所舉辦的活動，並採取線上報名時
        4.當您要向本網站索取服務時，不論該服務是有價或無價
        我們如何運用您所登錄的個人資料
        我們所收集的個人資料，主要用途是使我們得以更準確的提供產品或服務給客戶、滿足客戶的需求、或通知客戶有關本網站最新的產品與服務。
        我們亦可能為內部目的使用個人資料，例如：稽核、資料分析及研究等，以改進我們的產品、服務、網頁呈現方式、及與客戶的溝通管道。本網站在未經您同意前，
        絕不會將您所登錄的個人資訊揭露、租借或轉售給第三者，或是將您的資料使用於未事先告知您的其他用途。
        關於您個人資料的修改與刪除
        當您在本網站註冊成為會員後，您可以隨時利用您的ID和密碼更改或刪除您原先提供的資料，以確保其正確性。
        我們何時必須將您的資訊接露
        ●本網站不會在未經您同意的狀況下向任何人或公司出售或出借您的個人資料。但在某些情況下會有例外。這些狀況包括（但不限於）：
        1.當您在本網站的行為已違反本網站的服務條款，或可能損害或妨礙本網站權益，或您的行為已導致任何人遭受損害，只要我們相信揭露您的個人資料是為了辨識、聯絡或採取法律行動所必要者。
        2.司法單位或其他有權機關因公眾安全，要求本網站公開特定個人資料時，本網站將視司法單位合法正式的程序，以及對本網站所有使用者安全考量下做可能必要的配合時。

        關於COOKIE的使用
        本網站有可能在您的電腦設定並取用本網站COOKIES，以提供貼心便利的各項服務。COOKIE是網站伺服器用來和使用者瀏覽器進行溝通的一種技術，它可能在使用者的電腦中儲存某些資訊，
        但是使用者可以藉由瀏覽器的設定，取消或限制此項功能，此項功能的取消將會造成您不能正常使用本網站的部分主要功能。

        帳號及個人資料隱私保護
        ●為保障您的隱私及安全，您的帳號資料會用密碼保護。
        ●當您要編輯會員資料等部分擁有個人資料及隱私頁面時，本網站會要求您輸入帳號識別資料確認身分。
        ●為確保您的帳號及個人資料安全無虞，本網站除了致力推廣各項安全機制外，同時也請您務必要定期更新您的作業系統並注意防毒。

        隱私權條款的修改
        由於科技發展的迅速，相關法規訂定未臻完備，以及未來可能難以預見的環境變遷等因素，本網站將會視需要修改我們在網站上所提供的隱私權說明，以落實保障您隱私權之立意。
        當我們完成隱私權條款修改時，我們會立即將其刊登於本網站的網站中，並以醒目標示提醒您前往點選閱讀。
                        </pre>
			<div class="moralf">
				<button class="agreeterm" onclick="agreeTerms()">同意</button>
			</div>

		</div>
	</div>
	<%
	java.sql.Date gRegistDate = null;
	try {
		gRegistDate = java.sql.Date.valueOf(request.getParameter("gRegistDate").trim());
	} catch (Exception e) {
		gRegistDate = new java.sql.Date(System.currentTimeMillis());
	}
	%>

	<script>
function showTerms() {
  $("#termsModal").modal("show");  
}
function agreeTerms() {
	  $("#termsModal").modal("hide");
	  $("input[name=agree]").prop("disabled", false); 
	  $("input[name=agree]").prop("checked", true);
	}
</script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script>
// 	$(document).ready(function() {

		
// 		var timeout;
// 		$('#gUsername').on('input', function() {
// 		    clearTimeout(timeout);
// 		    timeout = setTimeout(function() {
// 		        var gUsername = $('#gUsername').val();
// 		        var gUsernameReg = "^[a-zA-Z0-9]{8,12}$";
// 		        if (gUsername !== "") {
// 		        	if (!gUsername.trim().match(gUsernameReg)) {
// 		                $("#accountExistsMessage").text("不符合帳號格式");
// 		                $("#accountExistsMessage").css("color", "red");
// 		            } else {
// 				            $.ajax({
<%-- 				                url: "<%=request.getContextPath()%>/generaluser/generaluserf.do?action=checkAccount", --%>
// 				                method: "POST",
// 				                data: { "gUsername": gUsername },
// 				                success: function(data) {
// 				                    console.log("ttt");
// 				                    if (data.exists) {
// 				                        $("#accountExistsMessage").text("此帳號已存在");
// 				                        $("#accountExistsMessage").css("color", "red");
// 				                    } else {
// 				                        $("#accountExistsMessage").text("此帳號可使用");
// 				                        $("#accountExistsMessage").css("color", "blue");
// 				                    }
// 				                },
// 				                error: function() {
// 				                    $("#accountExistsMessage").text("檢查帳號有錯誤");
// 				                }
// 				            });
// 		              }      
// 		        } else {
// 		            $("#accountExistsMessage").text('');
// 		        }
// 		    }, 500); // 500毫秒延遲
// 		});
		
// 		var memberemailInput = $("#memberemail");
// 	    var errorMsgMemberEmail = $("font[color='red']");

// 	     // 監聽輸入框的輸入事件
// 	     gUsernameInput.on('input', function() {
// 	        // 獲取輸入框的值
// 	        var inputValue = gUsernameInput.val();

// 	        // 如果輸入框中有文字，清除錯誤訊息
// 	        if (inputValue.trim() !== "") {
// 	            errorMsggUsername.text('');
// 	        }
// 	    });
	</script>
	<script>
		$(document)
				.ready(
						function() {

							//第一層選單
							$
									.ajax({
										url : 'https://raw.githubusercontent.com/donma/TaiwanAddressCityAreaRoadChineseEnglishJSON/master/CityCountyData.json',
										type : "get",
										dataType : "json",
										success : function(data) {
											$
													.each(
															data,
															function(key, value) {
																console.log(
																		key,
																		value)
																$('#city')
																		.append(
																				'<option value="'+data[key].CityName+'">'
																						+ data[key].CityName
																						+ '</option>')
															})
										},
										error : function(data) {
											alert("fail");
										}
									});

							//第二層選單
							$("#city")
									.change(
											function() {
												cityvalue = $("#city").val(); //取值
												$("#area").empty(); //清空上次的值
												$("#area").css("display",
														"inline"); //顯現
												$
														.ajax({
															url : 'https://raw.githubusercontent.com/donma/TaiwanAddressCityAreaRoadChineseEnglishJSON/master/CityCountyData.json',
															type : "get",
															dataType : "json",
															success : function(
																	data) {

																// 																eachval = data[cityvalue].AreaList; //鄉鎮
																eachval = [];
																for (let i = 0; i < data.length; i++) {
																	if (data[i].CityName == cityvalue) {
																		eachval = data[i].AreaList;
																	}
																}

																$
																		.each(
																				eachval,
																				function(
																						key,
																						value) {
																					$(
																							'#area')
																							.append(
																									'<option value="'+eachval[key].AreaName+'">'
																											+ eachval[key].AreaName
																											+ '</option>')
																				});
															},
															error : function() {
																alert("fail");
															}
														});
											});

							//選完後跳出選擇值
							$("#area")
									.change(
											function() {
												cityvalue = $("#city").val(); //縣市
												areavalue = $("#area").val(); //鄉鎮

												$
														.ajax({
															url : 'https://raw.githubusercontent.com/donma/TaiwanAddressCityAreaRoadChineseEnglishJSON/master/CityCountyData.json',
															type : "get",
															dataType : "json",
															success : function(
																	data) {
																alert(data[cityvalue].CityName
																		+ "-"
																		+ data[cityvalue].AreaList[areavalue].AreaName);
															},
															error : function() {
																alert("fail");
															}

														});
											})

						});
	</script>
	<script>
		var registerDate = document.getElementsByName("registerDate")[0];

		// 構建當前日期,格式為 yyyy-mm-dd
		var today = new Date().toISOString().slice(0, 10);

		// 為註冊日期欄位賦值  
		registerDate.value = today;
	</script>
	<script>
		const password = document.getElementById('password');
		const toggle = document.getElementById('togglePwd');

		toggle.addEventListener('change', function() {
			if (this.checked) {
				password.type = 'text';
			} else {
				password.type = 'password';
			}
		});

		const password2 = document.getElementById('password2');
		const toggle2 = document.getElementById('togglePwd2');

		toggle2.addEventListener('change', function() {
			if (this.checked) {
				password2.type = 'text';
			} else {
				password2.type = 'password';
			}
		});
	</script>
	<script>
	function preview() {

		var fileInput = document.getElementById('uploadImg');
		var file = fileInput.files[0];

		var reader = new FileReader();

		reader.onload = function() {
			document.getElementById('blob_holder').innerHTML = '<img src="' + reader.result + '" width="100px"/>';
		};

		if (file) {
			reader.readAsDataURL(file);
		}

	}
	</script>
	<!-- Jquery JS-->
	<script
		src="<%=request.getContextPath()%>/backEnd-Website/vendor/jquery-3.2.1.min.js"></script>
	<!-- proper.min.js first, then bootstrap.min.js -->
	<script
		src="<%=request.getContextPath()%>/backEnd-Website/vendor/bootstrap-4.1/popper.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/backEnd-Website/vendor/bootstrap-4.1/bootstrap.min.js"></script>
	<!-- Vendor JS       -->
	<script
		src="<%=request.getContextPath()%>/backEnd-Website/vendor/slick/slick.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/backEnd-Website/vendor/wow/wow.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/backEnd-Website/vendor/animsition/animsition.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/backEnd-Website/vendor/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/backEnd-Website/vendor/counter-up/jquery.waypoints.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/backEnd-Website/vendor/counter-up/jquery.counterup.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/backEnd-Website/vendor/circle-progress/circle-progress.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/backEnd-Website/vendor/perfect-scrollbar/perfect-scrollbar.js"></script>
	<script
		src="<%=request.getContextPath()%>/backEnd-Website/vendor/chartjs/Chart.bundle.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/backEnd-Website/vendor/select2/select2.min.js"></script>
	<!-- Main JS-->
	<script src="<%=request.getContextPath()%>/backEnd-Website/js/main.js"></script>
</body>
</html>