<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>使用者條款</title>
     <link rel="stylesheet" href="./css.css">
     <link rel="stylesheet" href="<%=request.getContextPath()%>/generaluser/CSS/bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/generaluser/css2/css.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/generaluser/css2/guser.css">
  <link rel="stylesheet" href="./termOfUse.css">
</head>

<body>
  <!----------------------------------------------- header 區 ------------------------------------------------------->
  <header class="header">
    <div class="container">
      <header class="d-flex flex-wrap justify-content-center py-1">
        <a href="/" class="d-flex align-items-center mb-1 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
          <img src="<%=request.getContextPath()%>/image/headerlogo.svg" alt="SVG" />
        </a>


        <ul class="nav nav-pills">
          <li class="nav-item"><a href="#" class="nav-link">首頁</a></li>
          <li class="nav-item"><a href="<%=request.getContextPath()%>/announcement/announcementHome.jsp" class="nav-link">公告</a></li>
          <li class="nav-item"><a href="#" class="nav-link">場館資訊</a></li>
          <li class="nav-item"><a href="#" class="nav-link">我要預約</a></li>
          <li class="nav-item"><a href="#" class="nav-link">論壇</a></li>
          <li class="nav-item"><a href="#" class="nav-link"><img src="<%=request.getContextPath()%>/image/face.svg" alt="SVG" />
              會員中心</a></li>
        </ul>


      </header>
    </div>
  </header>
  <!----------------------------------------------- aside 區 ------------------------------------------------------->
  <!----------------------------------------------- main 區 ------------------------------------------------------->
  <div class="userPolicy">

    <h1 class="headline">πChill使用者條款</h1>
    <div class="introText">
      <p class="introText">非常歡迎您光臨πChill（以下簡稱本網站），為了讓您能夠安心的使用本網站的各項服務與資訊，特此向您說明本網站的隱私權保護政策，以保障您的權益，請您詳閱下列內容：
        當您完成本網站註冊時並登入，即視為已知悉、並且同意本服務條款的所有約定：</p>
    </div>
    <div class="container">
      <div class="row">
        <div class="col-md-10 col-md-push-1">
          <ol class="termList">
            <li style="list-style-type: none;">
              <p>定義:</p>
              <p>πChill網站管理系統：簡稱-本系統。</p>
              <p>πChill網站：簡稱-本網站。</p>
              <p>πChill INC.：簡稱-本公司。</p>
              <p>πChill網站及後台管理系統：簡稱-本平台。</p>
            </li>
          </ol>

          <ol class="termList">
            <li class="termList">一、認知與接受條款
              <ol>
                <li>
                  當您完成本網站會員註冊手續、或開始使用本服務時，即表示已閱讀、瞭解並同意接受本服務條款之所有內容，並完全接受本服務現有與未來衍生的服務項目及內容。本公司有權於任何時間修改或變更本服務條款之內容，修改後的服務條款內容將公佈網站上，本公司將不會個別通知您，建議您隨時注意該等修改或變更。您於任何修改或變更後繼續使用本服務時，視為您已閱讀、瞭解並同意接受該等修改或變更。若不同意上述的服務條款修訂或更新方式，或不接受本服務條款的其他任一約定，您應立即停止使用本服務。
                </li>
                <li>
                  若您為未滿二十歲或無完全行為能力，除應符合上述規定外，請於您的法定代理人或監護人閱讀、瞭解並同意本政策及其後修改、變更後之所有內容後，方得使用或繼續使用本網站，否則請立即停止使用本網站。當您使用或繼續使用本網站時，即表示您的法定代理人或監護人已閱讀、瞭解並同意接受本政策及其後修改、變更之所有內容。
                </li>
                <li>您及本公司雙方同意，使用本服務之所有內容包括意思表示等，原則上皆以電子文件做為表示方式。</li>
                <li>當您完成註冊手續時，即代表您已同時授權本公司得依照本服務條款及隱私權政策對您及您所導入的所有資料進行蒐集、處理及利用。此外，您亦保證您所導入之會員資料係經由合法方式獲得。</li>
                <li>請注意！如拒絕提供各項必要之資料，將可能導致無法完整的享受本系統之服務或完全無法使用本系統之服務。</li>
              </ol>
            <li class="termList">二、一般條款:
              <ol>
                <li>
                  為確保所有交易程序的正確完成，您必須保證在本系統登記的個人/營業/匯款/信用卡等相關資料與事實相符，如有變動，應自行至-我的帳戶/系統後台管理介面修改。如有任何疑問，請與πChill客服聯繫(來信請至：service@piChill.com)
                </li>
                <li>您所登錄之個人/營業資料，除了應提供本平台註冊會員或與結帳資訊相關者，本公司應負相關之保密義務，不會任意洩漏或提供給第三人。</li>
                <li>註冊後應妥善保管在本網站設定之帳號與密碼，所有使用該註冊帳號登入系統之任何行為，本系統/平台皆視為帳號與密碼持有人之行為。</li>
                <li>本公司或場館端若知悉您的帳號密碼確係遭他人冒用時，將立即暫停該帳號之使用(含該帳號所生交易之處理)。</li>
                <li>如果您洩漏自己的個人資料、密碼或付款資料，並使得第三人有使用的機會時，您必須就第三人的行為負全部責任。</li>
                <li>在下列情況下，本公司有權查看或提供本平台任何使用者的個人資料給有權機關、或主張其權利受侵害並提出適當證明之第三人：
                  <ul class="sub">
                    <li>依法令規定、或依司法機關或其他有權機關的命令；</li>
                    <li>為執行本約定條款、或使用者違反約定條款；</li>
                    <li>為維護本平台之正常運作及安全；</li>
                    <li>為保護本平台、其他使用者、或其他第三人的合法權益；</li>
                  </ul>
                </li>
                <li>本平台所上架之所有課程/服務皆由各營業人所提供，故交易行為係存在於營業人與使用者之間，本平台僅提供營業人與使用者之間的線上預約、交易平台與付款機制。</li>
                <li>相關課程、商品或服務之品質及售後服務，由提供各該課程或服務的營業人負責，但本公司承諾全力協助使用者解決關於因為線上消費所產生之疑問或爭議。</li>
                <li>
                  您一旦於本平台或對本系統進行線上消費或匯款儲值，即表示願意購買本平台上的各場館課程/服務或本公司之營運軟體服務，並願遵守相關規則。系統消費方案及異動得以月為單位，於通知本公司客服人員後，進行異動。當您的資料(如地址、電話、銀行帳號)有變更時，應立即上線修正您所留存之資料，不得以資料不符為理由，否認訂購行為或拒絕付款；亦不得因未即時更新相關資料導致軟體服務被停用，要求本公司賠償。消費完成後，於消費期間內亦不得要求退款(消費期間請參照本公司業務報價、軟體服務刷卡消費頁面或各店家課程或服務說明頁面)。若您註冊兩組或以上帳號而進行消費時，亦不得因重複消費而主張退款。當本平台之系統服務或服務規則有重大變更時，將發送電子郵件通知已購買本系統服務之使用者，請注意相關訊息並盡速至網站內查閱相關異動，以確保您的權益。此外，本公司保有變更收費方式、收費方案、各系統方案內含功能之權利，並保有接受您訂單與否的權利，相關收費標準請參照本公司業務或客服人員提供之文件及後台資訊。
                </li>
                <li>
                  所有在本平台所進行的線上消費，應同意以本平台所紀錄之電子交易資料為準，如有糾紛，並以該電子交易資料為認定標準。您如果發現交易資料不正確，應立即通知本平台客服人員。若因您未即時發見交易資料不正確而受有損失時，本平台除依平台客服程序協助外，不負任何賠償責任。
                </li>
                <li>本平台在發生下列情形之一時，可以停止、中斷提供服務；停止或中斷服務時，原則上本平台將先通知會員，惟緊急時刻不在此限：
                  <ul  class="sub">
                    <li>對本平台的電子通信設備，進行必要的保養及施工</li>
                    <li>發生突發性的電子通信設備故障； 由於本平台所申請的電子通信服務被停止，致使提供服務發生困難；由於天災等不可抗力之因素，致使本平台無法提供服務。</li>
                    <li>場館購買之點數不足以支付系統方案或系統功能消費時。</li>
                  </ul>
                </li>
                <li>終止或停止帳戶：
                  <ul class="sub">
                    <li >
                      您同意πChill得在任何時間因任何理由、無理由、而單方的終止、移除或廢止您在πChill網站上的會員帳戶，或任何由您所上傳至本網站之資料內容（或其任何部分）。πChill也可能在任何時間且在告知或未告知的情況下，單方的停止提供進入πChill網站的權利（或其任何部分）。您同意πChill就前述之部分或全部網站或帳戶功能的停止或暫停係有效的，且同意πChill對於此類停止或暫停之行為，不須對您或任何第三人負任何法律上責任。
                    </li>
                    <li >
                      πChill完全不同意任何智慧財產權之侵害行為出現在本網站上，從而，對於πChill會員，一旦被舉發為智慧財產權之侵害者，πChill將立即移除該會員所提交之任何內容，並保留終止該會員進入πChill網站之權利。任何被懷疑是詐欺、辱罵或者任何其他的違法行為，皆可能被πChill終止您進入πChill網站之權利並轉請有關司法單位法辦。除上述之措施外，πChill亦可能依照其法律上固有之權利，採取其他公平適當之措施。
                    </li>
                  </ul>
                </li>
                <li>本公司保留隨時修改本使用條款之權利，修改後的使用條款將公佈在本網站上，除前述9.之電子郵件外，將不另外個別通知使用者。使用者應同意遵守修改後之約定條款。</li>
              </ol>
            </li>
            <li class="termList">三、系統使用條款
              <p>當您使用本系統並開通本網站線上預約功能時，即代表您擁有以下權利並願意遵守以下義務：</p>

              <ol>
                <li>開通本網站線上預約功能時，請先確實了解本系統功能之操作方式。包括但不限於：營業時間之設定、課程/服務名額之設定、停課/取消服務通知之發送、課程/服務注意事項、收款及轉帳方式&hellip;等等。
                </li>
                <li>為達線上預約課程/服務之精準性，請確實更新課表/服務時間，以免錯失商機。</li>
                <li>
                  於課程/服務進行前，應對預約會員進行身分核對，並確實透過本系統進行收款、結帳。所有方案皆為刷卡付款後方可進行預約，但針對單次課程/服務銷售類型，採取現場付款制者。若因未即時收款致生任何消費糾紛，請場館另行與預約會員聯繫付款或退款。本公司不負任何賠償責任。請務必注意系統相關設定或提示，避免造成損失。
                </li>
                <li>
                  各營業人保證，於課程/服務進行期間提供其營業場所內符合法定安全標準及指示說明之器材、設備項目及活動空間，供線上預約之會員使用。並確保營業場所及服務人員具有相關合法之營業執照，及其他經政府機關核准之資格認證資料。
                </li>
                <li>對於所有個別磋商之合作條件，特別是協議價格，雙方皆應盡保密義務，並應將個別磋商之電子郵件或相關電子紀錄留底為憑。</li>
                <li>營業人所累計之線上交易款項，原則上將於刷卡完成後七日於後台自動列為可提領金額，請各營業人至後台進行提領，本公司將於申請提領後<span
                    style="color: #0024fb">30天內</span>將累計款項扣除匯款、金流交易手續費(目前為總交易金額的3%)及本系統使用費後，匯入營業人於本系統所設定之銀行帳戶內。例外則係當消費者、持卡人或具法律上合理理由之第三人，因任何情況而對該筆交易有所申訴時，該筆交易之款項將暫時無法匯款。
                </li>
                <li>πChill將於確實收訖系統使用費後，定期開立發票予各營業人，請務必於系統後台確認收件地址之正確。各營業人若依法須開立收據或發票者，請另行開立予消費者，恕πChill無法代開發票。</li>
              </ol>
            </li>
            <li class="termList">四、會員預約
              <p>πChill線上預約係以以下兩種方式進行：</p>

              <ol>
                <li>
                  無場館方案之會員：透過πChill網站查找課程/服務場館或其評價，針對特定課程或服務進行單次的線上預約。請注意：單次預約於預約時並不需要付款，而係於抵達場館進行消費時，依照實際的消費金額現場付款。或者，依照各方案價格進行刷卡消費後，直接進行線上預約。此外，請務必注意各場館的課程/服務取消政策，各場館可能依照不同的取消條件及爽約狀況收取課程或服務費用。
                </li>
                <li>已有場館方案之會員：場館由系統完成方案指派後，會員得於「我的帳戶」確認方案資格後，依照方案內容進行線上預約。</li>
                <li>會員於線上預約各場館之課程或服務時，請務必確認相關消費條件與資格，到場後亦務必遵循各場館之內部規範，以確保您消費之權益。</li>
                <li>本網站僅供課程或服務之線上預約，任何課程或服務所生之法律關係，皆存在於使用者與場館之間。πChill客服僅就系統功能或相關電子紀錄做查詢及協助。</li>
              </ol>
            </li>
            <li class="termList">五、行銷方案及EDM行銷
              <ol>
                <li>本公司為達本平台店家聯合行銷之目的，得將課程服務包裝為各類行銷方案或施以各種優惠措施以加強行銷導客之效果。</li>
                <li>您同意πChill得不定期發送電子報或商品訊息(EDM)至會員所登錄的電子信箱帳號。當會員收到訊息後表示拒絕接受行銷時，πChill將停止繼續發送行銷訊息。</li>
              </ol>
            </li>
            <li class="termList">六、使用者的守法義務及承諾
              <p>
                會員承諾絕不為任何非法目的或以任何非法方式使用本服務，並承諾遵守中華民國相關法規及一切使用網際網路之國際慣例。會員若係中華民國以外之使用者，並同意遵守所屬國家或地域之法令。會員同意並保證不得利用本服務從事侵害他人權益或違法之行為，包括但不限於：允許非您本人以外之任何第三人(包含本網站之其他會員)使用被場館規範禁止轉讓的課程；公布或傳送任何誹謗、侮辱、具威脅性、攻擊性、不雅、猥褻、不實、違反公共秩序或善良風俗或其他不法之文字、圖片或任何形式的檔案；違反依法律或契約所應負之保密及注意義務；
              </p>

              <ol>
                <li>冒用他人名義而註冊、登入或使用本服務及其它特定服務；</li>
                <li>傳輸或散佈電腦病毒；</li>
                <li>從事未經πChill事前授權的商業行為；</li>
                <li>從事不法交易行為或張貼任何虛假不實、引人犯罪或侵害他人權利等訊息；</li>
                <li>刊載、傳輸、發送垃圾郵件、連鎖信、違法或未經πChill許可之多層次傳銷訊息及廣告等；或儲存任何侵害他人智慧財產權或違反法令之資料；</li>
                <li>對本服務其他用戶或第三人產生困擾、不悅或違反一般網路禮節致生反感之行為。</li>
                <li>偽造或變造訊息信號、來源或以任何方式乾擾或妨害傳輸來源之行為。</li>
                <li>
                  干擾、妨害、侵害或中斷本服務及其它特定服務或該服務器或連結之網絡，違反或不遵行連結至本服務及其它特定服務之相關需求、程序、政策或規則等，包括但不限於：使用任何設備、硬件、軟件或刻意規避πChill之排除自動搜尋之標頭（robot
                  exclusion headers）。</li>
                <li>其他不符本服務所提供的使用目的之行為或πChill有正當理由認為不適當之行為。</li>
              </ol>
            </li>
            <li class="termList">七、責任之限制與排除
              <ol>
                <li>本服務所提供之各項功能，均依該功能當時之現況提供使用，πChill對於其效能、速度、完整性、可靠性、安全性、正確性等，皆不負擔任何明示或默示之擔保責任。</li>
                <li>
                  πChill並不保證本服務之網頁、伺服器、網域等所傳送的電子郵件或其內容不會含有電腦病毒等有害物；亦不保證郵件、檔案或資料之傳輸儲存均正確無誤不會斷線和出錯等，因各該郵件、檔案或資料傳送或儲存失敗、遺失或錯誤等所致之損害，πChill不負賠償責任。
                </li>
              </ol>
            </li>
            <li class="termList">八、πChill隱私權政策
              <p>關於會員的註冊以及其他特定資料依πChill「隱私權政策」受到保護與規範。您了解當您使用本服務時，您同意πChill依據「隱私權政策」進行您個人資料的蒐集、處理及利用，請您詳細閱讀並瞭解改政策之內容。
              </p>
            </li>
            <li class="termList">九、損害賠償
              <p>因違反本契約內容、合作宗旨或法律而致本公司受損害時，應依相關法律負損害賠償責任，包括但不限於，損害賠償、律師費等一切損害、成本及支出。於紛爭妥適協商解決前，本公司得暫停匯款作業。</p>
            </li>
            <li class="termList">十、智慧財產權的保護
              <ol>
                <li>
                  πChill所使用之軟體或程式、網站上所有內容，包括但不限於著作、圖片、檔案、資訊、資料、網站架構、網站畫面的安排、網頁設計，均由πChill或其他權利人依法擁有其智慧財產權，包括但不限於商標權、專利權、著作權、營業秘密與專有技術等。任何人不得逕自使用、修改、重製、公開播送、改作、散布、發行、公開發表、進行還原工程、解編或反向組譯。若會員欲引用或轉載前述軟體、程式或網站內容，必須依法取得πChill或其他權利人的事前書面同意。尊重智慧財產權是會員應盡的義務，如有違反，會員應對πChill負損害賠償責任（包括但不限於訴訟費用及律師費用等）。
                </li>
                <li>在尊重他人智慧財產權之原則下，會員同意在使用πChill之服務時，不做侵害他人智慧財產權之行為。</li>
                <li>若會員有涉及侵權之情事，πChill可暫停全部或部份之服務，或逕自以取消會員帳號之方式處理。</li>
                <li>若有發現智慧財產權遭侵害之情事，請將所遭侵權之情形及聯絡方式，並附具真實陳述及擁有合法智慧財產權之聲明，以下列方式聯絡πChill： 以電子郵件（E-mail）寄送至：
                  service@piChill.com</li>
              </ol>
            </li>
            <li class="termList">十一、會員對πChill之授權
              <ol class="sub">
                <li>
                  您同意使用πChill網站時，可能會有上傳照片及影音之可能，對於該等內容，您同意πChill將與您同為著作權人及相關智慧財產權人，得將您該等影音、照片以實體與數位方式重製、改作、編輯、公開口述、公開演出、公開上映、公開傳輸或以其他方式加以利用，並得對第三人進行授權，供第三人使用。
                </li>
                <li>
                  對於會員上載、傳送、輸入或提供之資料，會員同意πChill網站得於合理之範圍內蒐集、處理、保存、傳遞及使用該等資料，以提供使用者其他資訊或服務、或作成會員統計資料、或進行關於網路行為之調查或研究，或為任何之合法使用。若會員無合法權利得授權他人使用、修改、重製、公開播送、改作、散布、發行、公開發表某資料，並將前述權利轉授權第三人，請勿擅自將該資料上載、傳送、輸入或提供至πChill。任何資料一經會員上載、傳送、輸入或提供至πChill時，視為會員已允許πChill無條件使用、修改、重製、公開播送、改作、散布、發行、公開發表該等資料，並得將前述權利轉授權他人，會員對此絕無異議。會員並應保證πChill使用、修改、重製、公開播送、改作、散布、發行、公開發表、轉授權該等資料，不致侵害任何第三人之智慧財產權，否則應對πChill負損害賠償責任（包括但不限於訴訟費用及律師費用等）。
                </li>
              </ol>
            </li>
            <li class="termList">十二、特別授權事項
              <p>
                因使用本服務所提供之網路交易或活動，可能須透過宅配或貨運業者始能完成貨品（或贈品等）之配送或取回，因此，會員同意並授權πChill得視該次網路交易或活動之需求及目的，將由會員所提供且為配送所必要之個人資料（如收件人姓名、配送地址、連絡電話等），提供予宅配貨運業者及相關配合之廠商，以利完成該次貨品（或贈品等）之配送、取回。
              </p>
            </li>
            <li class="termList">十三、準據法與管轄法院
              <p>
                本服務條款之解釋與適用，以及與本服務條款有關或使用者與本公司間因交易行為而產生之爭議或糾紛，應依照中華民國法律予以處理，並以台灣台北地方法院為第一審管轄法院，但若法律對於管轄法院另有強制規定者，仍應依其規定。
              </p>
            </li>
            <li class="termList">十四、其他
              <p>本公司未行使或執行本服務條款任何權利或規定，不構成前述權利或行使權之放棄。</p>
            </li>
          </ol>
        </div>
      </div>
    </div>
  </div>
  <!----------------------------------------------- footer 區 ------------------------------------------------------->
  <footer class="footer">

    <div class="container">
      <header class="d-flex flex-wrap justify-content-center py-3">
        <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
          <img src="<%=request.getContextPath()%>/image/footerlogo.svg" alt="SVG" />
        </a>

        <ul class="nav nav-pillss">
          <li class="nav-item"><a href="#" class="nav-link">使用者條款</a></li>
          <li class="nav-item"><a href="<%=request.getContextPath()%>/homepage/privacyPolicy/privacyPolicy.jsp" class="nav-link">隱私權政策</a></li>
          <li class="nav-item"><a href="<%=request.getContextPath()%>/homepage/disclaimer/disclaimer.jsp" class="nav-link">免責條款</a></li>
        </ul>
      </header>
    </div>
  </footer>

  <script src="<%=request.getContextPath()%>/JS/bootstrap.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>