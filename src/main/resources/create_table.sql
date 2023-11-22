USE pichill;

-- DROP
-- SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS reserveOrder;
DROP TABLE IF EXISTS cart;
DROP TABLE IF EXISTS productPic;
DROP TABLE IF EXISTS productOrderList;
DROP TABLE IF EXISTS coupon;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS forumpic;
DROP TABLE IF EXISTS report;
DROP TABLE IF EXISTS `like`;
DROP TABLE IF EXISTS `comment`;
DROP TABLE IF EXISTS announcement;
DROP TABLE IF EXISTS contactUs;
DROP TABLE IF EXISTS post;
DROP TABLE IF EXISTS backAuthority;
DROP TABLE IF EXISTS productOrder;
DROP TABLE IF EXISTS place;
DROP TABLE IF EXISTS `time`;
DROP TABLE IF EXISTS court;
DROP TABLE IF EXISTS backFunction;
DROP TABLE IF EXISTS productType;
DROP TABLE IF EXISTS ownerUser;
DROP TABLE IF EXISTS manage;
DROP TABLE IF EXISTS generalUser;

-- CREATE

CREATE TABLE generalUser (
	gUserID int NOT NULL AUTO_INCREMENT,
    gName varchar(15) NOT NULL,
    gTelephone varchar(50) NOT NULL,
    gEmail varchar(100) NOT NULL,
    gAddress varchar(100) NOT NULL,
    `status` int NOT NULL,
    gGender int NOT NULL,
    gPassword varchar(50) NOT NULL,
    gIDNum char(10) NOT NULL,
    nicknameID varchar(50) DEFAULT NULL,
    piAmount int DEFAULT NULL,
    couponAmount int DEFAULT NULL,
    gPostAmount int DEFAULT NULL,
    commentAmount int DEFAULT NULL,
    gReportCnt int DEFAULT NULL,
    gRegistDate date NOT NULL,
    gLastLogTime timestamp NOT NULL,
    gBirth date NOT NULL,
    purchaseCnt int DEFAULT NULL,
    yoyakuCnt int DEFAULT NULL,
    gProfilePic longblob DEFAULT NULL,
    PRIMARY KEY (gUserID))
	AUTO_INCREMENT = 11000001;

CREATE TABLE manage (
	manageID int NOT NULL Auto_Increment,
    mName varchar (15) NOT NULL,
    mUserName varchar (50) NOT NULL,
    mPassword varchar (50) NOT NULL,
    mBirth date NOT NULL,
    mGender int NOT NULL,
    mTelephone varchar (50) NOT NULL,
    mEmgContact varchar (15) DEFAULT NULL,
    mEmgPhone varchar (50) DEFAULT NULL,
    mAddress varchar (100) NOT NULL,
    mHiredate date NOT NULL,
    mLastLogTime timestamp NOT NULL,
    mID char (10) NOT NULL,
    mEmail varchar (100) NOT NULL,
    mProfilePic longblob,
    Primary Key (manageID))
    Auto_Increment=13000001;

CREATE TABLE ownerUser(
oUserID int Not Null AUTO_INCREMENT,
oUserName varchar(50) Not Null,
oPassword varchar(50) Not Null,
oIDNum char(10) Not Null,
compiled varchar(50) Not Null,
oName varchar(15) Not Null,
oGender int Not Null,
oBirth date Not Null,
oTelephone varchar(50) Not Null,
oAddress varchar(100) Not Null,
oBankCode char(3) Not Null,
oBankAccount varchar(50) Not Null,
oProfilePic longblob,
oRegisterTime date Not Null,
oLastLogTime timestamp Not Null,
oPostAmount int,
oReportCnt int,
courtArriveCnt int,
couponArriveCnt int,
rsvdCnts int,
oEmail varchar(100) Not Null,
Primary Key (oUserID)  
)
AUTO_INCREMENT =  12000001;

CREATE TABLE productType (
 productTypeID INT NOT NULL,
 productType VARCHAR(50) NOT NULL,
 CONSTRAINT productType_id_pk PRIMARY KEY (productTypeID)
);

CREATE TABLE backFunction (
	backFunctionID int NOT NULL,
    backFunctionName varchar (50) NOT NULL,
    Primary Key (backFunctionID)
);

CREATE TABLE court(
courtID int Not Null AUTO_INCREMENT,
oUserID int Not Null,
manageID int,
courtOnTime timestamp Not Null,
courtApplyTime timestamp Not Null,
courtName varchar(50),
courtPic longblob,
courtTelephone varchar(50) Not Null,
courtAddress varchar(100) Not Null,
courtRule text,
lOC  varchar(50),
Primary Key (courtID),
FOREIGN KEY (oUserID) REFERENCES ownerUser(oUserID), 
FOREIGN KEY (manageID) REFERENCES manage (manageID) 
)
AUTO_INCREMENT = 61000001;

CREATE TABLE `time`(
timeID INT Not Null,
reserveTime varchar(50) Not Null,
courtID INT Not Null,
FOREIGN KEY (courtID) REFERENCES court (courtID),
primary key(timeID));


CREATE TABLE place(
placeID int Not Null AUTO_INCREMENT,
courtID int Not Null,
placeName varchar(30) Not Null,
placeFee int Not Null,
ball int Not Null,
Primary Key (placeID),
FOREIGN KEY (courtID) REFERENCES court(courtID)
)
AUTO_INCREMENT = 62000001;

CREATE TABLE productOrder (
 productOrderID INT NOT NULL AUTO_INCREMENT,
 gUserID INT NOT NULL,
 courtID INT NOT NULL,
 productOrderTime TIMESTAMP NOT NULL,
 consume TIMESTAMP NOT NULL,
 productShipTime TIMESTAMP NOT NULL,
 productArriveTime TIMESTAMP,
 productShipStatus INT NOT NULL,
 gUserPiCnt INT NOT NULL,
 Ordertotal INT NOT NULL,
 CONSTRAINT gUserID_generalUser_id_fk FOREIGN KEY (gUserID) REFERENCES generalUser (gUserID),
 CONSTRAINT courtID_court_id_fk FOREIGN KEY (courtID) REFERENCES court (courtID),
 CONSTRAINT productOrder_id_pk PRIMARY KEY (productOrderID)
)
AUTO_INCREMENT = 54000001;

CREATE TABLE backAuthority (
	backAuthorityID int NOT NULL Auto_Increment,
    manageID int NOT NULL,
    backFunctionID int NOT NULL,
    Primary Key (backAuthorityID),
    Foreign Key (manageID) REFERENCES manage (manageID),
    Foreign Key (backFunctionID) REFERENCES backFunction (backFunctionID) 
)
Auto_Increment=41000001;

CREATE TABLE post(
postID int NOT NULL Auto_Increment,
gUserID int DEFAULT NULL,
oUserID int DEFAULT NULL,
postTitle varchar(100) NOT NULL,
postContent text NOT NULL,
postType int NOT NULL,
postTime timestamp NOT NULL,
likeCnt int DEFAULT NULL,
Primary Key (postID),
CONSTRAINT POST_OUSERID_FK FOREIGN KEY (OUSERID) REFERENCES ownerUser (OUSERID),
CONSTRAINT POST_GUSERID_FK FOREIGN KEY (GUSERID) REFERENCES generalUser (GUSERID)
)
AUTO_INCREMENT = 31000001;

CREATE TABLE contactUs(
formID int Not Null AUTO_INCREMENT,
oUserID int,
gUserID int,
formPurpose varchar(100) Not Null,
formContent text Not Null,
formPic longblob,
formTime timestamp Not Null,
formStatus int Not Null,
formType int Not Null,
Primary Key (formID),
FOREIGN KEY (oUserID) REFERENCES ownerUser(oUserID),
FOREIGN KEY (gUserID) REFERENCES generalUser (gUserID) 
)
AUTO_INCREMENT =  22000001;

CREATE TABLE announcement(
announceID INT Not Null AUTO_INCREMENT,
manageID INT Not Null,
formID INT Not Null,
annoTitle varchar(100) Not Null,
annoContent text Not Null,
annoPic longblob,
annoTime timestamp Not Null,
annoStatus int Not Null,
constraint foreign key(formID) references contactUs (formID),
constraint foreign key(manageID) references manage (manageID),
primary key(announceID)
)
AUTO_INCREMENT = 21000001; 

CREATE TABLE `comment`(
commentID int NOT NULL AUTO_INCREMENT,
gUserID int NOT NULL,
postID int NOT NULL,
commentContent text NOT NULL,
commentTime timestamp NOT NULL,
Primary Key (commentID),
CONSTRAINT COMMENT_POSTID_FK FOREIGN KEY (POSTID) REFERENCES POST(POSTID),
CONSTRAINT COMMENT_GUSERID_FK FOREIGN KEY (GUSERID) REFERENCES generalUser (GUSERID)
)
AUTO_INCREMENT = 32000001;

CREATE TABLE `like`(
likeID int NOT NULL AUTO_INCREMENT,
gUserID int NOT NULL,
postID int NOT NULL,
Primary Key (likeID),
CONSTRAINT LIKE_POSTID_FK FOREIGN KEY (POSTID) REFERENCES POST(POSTID),
CONSTRAINT LIKE_GUSERID_FK FOREIGN KEY (GUSERID) REFERENCES generalUser (GUSERID)
)
AUTO_INCREMENT = 33000001;

CREATE TABLE report(
reportID int NOT NULL AUTO_INCREMENT,
manageID int DEFAULT NULL,
postID int DEFAULT NULL,
commentID int DEFAULT NULL,
reportTime timestamp NOT NULL,
reportStatus int NOT NULL,
reportType int NOT NULL,
Primary Key (reportID),
CONSTRAINT REPORT_COMMENTID_FK FOREIGN KEY (COMMENTID) REFERENCES `COMMENT`(COMMENTID),
CONSTRAINT REPORT_POSTID_FK FOREIGN KEY (POSTID) REFERENCES POST(POSTID),
CONSTRAINT REPORT_MANAGEID_FK FOREIGN KEY (MANAGEID) REFERENCES MANAGE(MANAGEID)
)
AUTO_INCREMENT = 34000001;

CREATE TABLE forumpic(
forumPicID int NOT NULL AUTO_INCREMENT,
postID int NOT NULL,
postPic LONGBLOB DEFAULT NULL,
picTime timestamp NOT NULL,
Primary Key (forumPicID),
CONSTRAINT FORUMPIC_POSTID_FK FOREIGN KEY (POSTID) REFERENCES POST(POSTID)
)
AUTO_INCREMENT = 35000001;

CREATE TABLE product (
 productID INT NOT NULL AUTO_INCREMENT,
 oUserID INT NOT NULL,
 manageID INT NOT NULL,
 courtID INT NOT NULL,
 productTypeID INT NOT NULL,
 productName VARCHAR(30) NOT NULL,
 productStatus INT NOT NULL,
 stock INT NOT NULL,
 productPic LONGBLOB,
 productOnCnt INT NOT NULL,
 productApplyTime TIMESTAMP NOT NULL,
 productOnTime TIMESTAMP NOT NULL,
 productPrice INT NOT NULL,
 productDescription TEXT NOT NULL,
 CONSTRAINT product_oUser_id_fk FOREIGN KEY (oUserID) REFERENCES ownerUser (oUserID),
 CONSTRAINT product_manage_id_fk FOREIGN KEY (manageID) REFERENCES manage (manageID),
 CONSTRAINT product_court_id_fk FOREIGN KEY (courtID) REFERENCES court (courtID),
 CONSTRAINT product_productType_id_fk FOREIGN KEY (productTypeID) REFERENCES productType (productTypeID),
 PRIMARY KEY (productID)
 )
 AUTO_INCREMENT = 51000001;
 
CREATE TABLE coupon (
 couponID INT NOT NULL AUTO_INCREMENT,
 productID INT NOT NULL,
 CONSTRAINT coupon_product_id_fk FOREIGN KEY (productID) REFERENCES product (productID),
 PRIMARY KEY (couponID)
 )
  AUTO_INCREMENT = 52000001;
  
CREATE TABLE productOrderList (
 productOrderListID INT NOT NULL AUTO_INCREMENT,
 productOrderID INT NOT NULL,
 productID INT NOT NULL,
 productPrice INT NOT NULL,
 productOnCnt INT NOT NULL,
 CONSTRAINT productOrderList_productOrder_id_fk FOREIGN KEY (productOrderID) REFERENCES productOrder (productOrderID),
 CONSTRAINT productOrderList_product_id_fk FOREIGN KEY (productID) REFERENCES product (productID),
 PRIMARY KEY (productOrderListID)
 )
 AUTO_INCREMENT = 53000001;

CREATE TABLE productPic (
 productPicID INT NOT NULL AUTO_INCREMENT,
 productID INT NOT NULL,
 productPic LONGBLOB,
 CONSTRAINT product_product_id_fk FOREIGN KEY (productID) REFERENCES product (productID),
 CONSTRAINT productPic_id_pk PRIMARY KEY (productPicID)
)
AUTO_INCREMENT = 55000001;

CREATE TABLE cart (
	cartID int NOT NULL AUTO_INCREMENT,
    productID int NOT NULL,
    gUserID int NOT NULL,
    PRIMARY KEY (cartID),
	FOREIGN KEY (productID) REFERENCES product (productID),
	FOREIGN KEY (gUserID) REFERENCES generalUser (gUserID)
    )
	AUTO_INCREMENT = 56000001; 
    
CREATE TABLE reserveOrder (
	reserveOrderID int NOT NULL AUTO_INCREMENT,
    gUserID int NOT NULL,
    oUserID int NOT NULL,
    timeID int NOT NULL,
    placeID int NOT NULL,
    couponID int DEFAULT NULL,
    orderTime timestamp NOT NULL,
    orderNum int NOT NULL,
    orderStatus int DEFAULT NULL,
    totalCost int NOT NULL,
    PRIMARY KEY (reserveOrderID),
    FOREIGN KEY (gUserID) REFERENCES generalUser (gUserID),
    FOREIGN KEY (oUserID) REFERENCES ownerUser (oUserID),
    FOREIGN KEY (timeID) REFERENCES time (timeID),
    FOREIGN KEY (placeID) REFERENCES place (placeID),
    FOREIGN KEY (couponID) REFERENCES coupon (couponID)
    )
	AUTO_INCREMENT = 63000001; 
    
-- 開始塞資料 --

INSERT INTO ownerUser (oUserName, oPassword, oIDNum, compiled, oName, oGender, oBirth, oTelephone, oAddress, oBankCode, oBankAccount, oProfilePic, oRegisterTime, oLastLogTime, oPostAmount, oReportCnt, courtArriveCnt, couponArriveCnt, rsvdCnts, oEmail) 
VALUES
('yehshaa0106@gmail.com','LtaS845r','H212810987','09071688','葉夢華',1,'1990-01-06','0934862754','新北市新店區民權路98號6樓','808','95301246813579','','2023-11-11','2023-11-12',1,null,1,null,null,'yehshaa0106@gmail.com'),
('hemswort722@gmail.com','2ZJaYBux','W297306112','83066533','張雨靖',1,'1964-05-15','0970619727','新北市泰山區光仁街70號5樓','822','462540394827','','2023-11-01','2023-11-13',3,null,1,null,1,'hemsworth9722@gmail.com'),
('keaton8704@gmail.com','9TON8704aa','Z164863183','91058450','宋晤道',0,'1980-03-29','0937740662','臺北市中山區吉林路443號10樓','822','220930394514','','2023-10-01','2023-11-13',2,null,1,null,1,'keaton8704@gmail.com'),
('mcmann3737@gmail.com','s5S9bxmaMALL','E232077274','92749566','李亭筑',1,'1995-09-14','0915628544','臺北市大安區通化街11巷95號1樓','816','01912601297900','','2023-11-01','2023-11-13',2,null,1,null,1,'mcmann3737@gmail.com'),
('dupont7493@yahoo.com','8C2K7g96de','A145073499','38410905','林益靖',0,'1974-07-27','0916584578','臺北市中正區大崙街13號11樓','816','0139998697907','','2023-11-01','2023-11-13',2,null,1,null,null,'dupont7493@yahoo.com'),
('pitcher566@icloud.com','34468yB2eee','Y146926550','93121438','沈倫棟',0,'1962-09-19','0911064331','新北市五股區西雲路225巷6號6樓','008','112160068514','','2023-10-01','2023-10-13',1,null,1,null,1,'pitcher566@icloud.com'),
('aubrey3513@gmail.com','kN4Xw2bYOIA','R212397140','92738239','林偲方',1,'1985-06-07','0922637552','臺北市松山區民生東路5段248號1樓','012','590102014113','','2023-11-11','2023-10-13',1,null,1,null,1,'aubrey3513@gmail.com'),
('taylor7940@gmail.com','VALy9FdvKAG','L176088812','02151263','廖知英',0,'1969-12-02','0916930440','臺北市萬華區青年路112號1樓','013','063035001966','','2023-10-01','2023-11-14','1',null,1,null,null,'taylor7940@gmail.com'),
('jared9107@outlook.com','aa5656C82BN','A180954855','97499139','李吉折',0,'1976-08-09','0929535919','新北市新店區北新路2段177之3號2樓','013','072500057506','','2023-11-05','2023-11-13',1,null,1,null,1,'jared9107@outlook.com'),
('t9a9r7625@gmail.com','4k37g26m0626','K177535123','85161977','許英化',0,'1973-08-01','0927979251','新北市板橋區忠孝路177號1樓','017','21310144724','','2023-11-01','2023-11-13',3,null,2,null,1,'t9a9r7625@gmail.com');

INSERT INTO manage (mName, mUserName, mPassword, mBirth, mGender, mTelephone, mEmgContact, mEmgPhone, mAddress, mHiredate, mLastLogTime, mID, mEmail, mProfilePic)
VALUES ('羅裕鵬', 'Brandon416', 'xhfldici', '1998-04-16', 1, '0934833024', '羅福城', '0912156662', '新北市中和區永和路二段44號', '2022-04-11', '2023-07-22 22:14:18', 'G134583948', 'bowen4434@gmail.com', null),
		('林孝呈', 'AndyLin', 'ldjoedsk', '1989-09-26', 0, '0945642566', '連亭竹', '0934974098', '台中市北區建仁路八段414號', '2012-03-21', '2022-02-28 03:19:48', 'H236618827', 'evie3641@gmail.com', null),
        ('劉基鴻', 'Liu46', 'jildsidclf', '2001-02-06', 1, '0935673124', '劉邦彥', '0926600599', '臺南市龍崎區烏樹林88號', '2022-12-11', '2021-01-01 01:01:01', 'P223490356', 'eliana3815@gmail.com', null),
        ('陳晨威', 'Chenchen98', '18773kkdek', '1993-09-06', 1, '0938368335', '袁淑雨', '0971686190', '屏東縣屏東市安心十橫巷65號3樓', '2020-12-01', '2021-04-30 16:24:32', 'L213699602', 'peppernell6715@outlook.com', null),
        ('林立', 'Lin3u4k5', 'f2FLB72c', '1979-06-26', 1, '0928565076', '藍建翊', '0934378505', '臺北市中正區衡陽路71號8樓', '2022-04-11', '2023-05-03 05:53:11', 'F260681378', 'haskell4757@yahoo.com', null),
        ('許基宏', 'B948dllkcd', 'JzwbM8S8', '2007-08-02', 1, '0911720555', '馬採筑', '0987003632', '臺北市松山區市民大道５段30號之4', '2018-03-21', '2020-12-02 03:54:21', 'N238086961', 'roberts2515@gmail.com', null),
        ('林智勝', 'Bkdlel554', 'Xs33F38s', '1995-09-20', 1, '0956975066', '陳姣慧', '0937532364', '彰化縣社頭鄉員集路３段20號', '2023-04-30', '2021-03-14 23:23:34', 'U133209824', 'rodriguez4463@yahoo.com', null),
        ('陳金鋒', 'garyfarye', '58SH5yWFi', '1965-12-21', 1, '0913013129', '趙潔玉', '0958479177', '彰化縣彰化市彰南路２段65號', '2019-01-21', '2023-06-16 12:34:28', 'J151162996', 'nestor6451@gmail.com', null),
        ('王建民', 'treewang', 'U4ZHsuR2', '1985-06-09', 1, '0912949250', '錢慈鈞', '0926630312', '臺中市北屯區崇德二路１段70號10樓', '2018-05-14', '2023-11-14 14:55:58', 'G132564496', 'wilson4897@gmail.com', null),
        ('涂鴻欽', 'tutu0817', 'Lb4nLhYb', '1971-10-01', 1, '0915029956', '宋芝郁', '0989051613', '桃園市龍潭區天龍二巷2號之11', '2015-11-11', '2023-04-23 12:24:48', 'Q198019682', 'clementine1476@gmail.com', null);
        
        INSERT INTO generalUser 
(gName, gTelephone, gEmail, gAddress, `status`, gGender, gPassword, gIDNum, nicknameID, piAmount,
 couponAmount, gPostAmount, commentAmount, gReportCnt, gRegistDate, gLastLogTime, gBirth, purchaseCnt, yoyakuCnt, gProfilePic)
VALUES
('劉晉歆', '0988059202', 'carlisle1306@gmail.com', '臺北市中山區新生北路3段40號6樓', 0, 0, 'v3PBw9Rs', 'P130192176', NULL, NULL,
 NULL, NULL, NULL, NULL, '2023-10-01', '2023-10-02 13:14:07', '1983-07-26', NULL, NULL, NULL),
 
('林姣穎', '0930913444', 'cooper5402@yahoo.com', '新竹縣竹北市科大一路4號', 0, 1, '55MS44Ya', 'C290779191', NULL, NULL,
 NULL, 2, 3, NULL, '2023-10-02', '2023-10-03 14:15:08', '1995-08-06', NULL, 2, NULL),
 
('李致青', '0988059202', 'carlisle1306@gmail.com', '新竹市東區寶山路12號', 0, 1, 'r27AVQDC', 'D180414511', NULL, NULL,
 NULL, 3, 4, NULL, '2023-10-03', '2023-10-04 09:16:08', '1965-03-21', NULL, NULL, NULL),
 
('黃中聖', '0937407568', 'theresa748@hotmail.com', '新竹市東區建華街18號12樓之6', 0, 0, '657ZtNT6', 'Y259903223', NULL, NULL,
 NULL, 5, 6, NULL, '2023-10-04', '2023-10-05 10:20:07', '1990-02-07', NULL, 1, NULL),
 
('余希曄', '0935380497', 'douglas9733@outlook.com', '桃園市桃園區廈門街6號4樓', 0, 0, '8g53Ldt7', 'W109676387', NULL, NULL,
 NULL, NULL, NULL, NULL, '2023-10-05', '2023-10-08 18:14:07', '1969-03-25', NULL, NULL, NULL),
 
('宋育芬', '0933796202', 'benton6712@yahoo.com', '苗栗縣銅鑼鄉文化街76號', 0, 1, 'YWWX5EZc', 'X237775000', NULL, NULL,
 NULL, NULL, 7, NULL, '2023-11-01', '2023-11-02 17:14:07', '1974-02-21', NULL, 2, NULL),
 
('連英銘', '0920868484', 'ramos9575@icloud.com', '高雄市彌陀區舊港路西二巷61號', 0, 0, 'CkFKZf7Z', 'U194853244', NULL, NULL,
 NULL, 8, NULL, NULL, '2023-09-09', '2023-10-28 07:07:07', '1986-01-01', NULL, 5, NULL),
 
('陳寒潤', '0914017754', 'rick1143@gmail.com', '新北市淡水區淡金路4段71號', 0, 0, '3tfBt2H7', 'K187673603', NULL, NULL,
 NULL, NULL, NULL, NULL, '2023-10-25', '2023-11-05 08:35:00', '2001-01-22', NULL, 3, NULL),
 
('程塵鋒', '0926980679', 'walton2133@hotmail.com', '桃園市龜山區光路龍田三巷66號', 0, 0, 'vka86eS9', 'K193834185', NULL, NULL,
 NULL, 3, 10, NULL, '2023-10-01', '2023-10-02 03:14:07', '1964-10-05', NULL, 6, NULL),
 
('江玲靜', '0910205546', 'julie1276@yahoo.com', '臺北市萬華區環河南路2段55號', 0, 1, '822akHY5', 'N205937588', NULL, NULL,
 NULL, NULL, 20, NULL, '2023-10-01', '2023-10-02 03:14:07', '1983-11-05', NULL, 3, NULL);
 
 INSERT INTO productType (productTypeID, productType)
 VALUES (0, '球具'),
	    (1, '運動用品'), 
        (2, '優惠券');
        
INSERT INTO backFunction (backFunctionID, backFunctionName)
VALUES (1, '員工管理'),
    	(2, '一般會員管理'),
        (3, '企業會員管理'),
		(4, '最新消息管理'),
		(5, '論壇管理'),
        (6, '球館管理'),
        (7, '預約管理'),
        (8, '商城管理');
        
INSERT INTO court (oUserID, manageID, courtOnTime, courtApplyTime, courtName, courtPic, courtTelephone, courtAddress, courtRule, loc)
VALUES
(12000001,13000001,'2023-11-11','2023-11-10','飛龍運動館','','022562622','臺北市大安區通化街11巷95號1樓','本場館禁止吸菸、飲食、喝酒，不可私下教學。
禁止燃放鞭炮、酗酒、鬥毆、夜宿及任何妨礙公共安全秩序、違反公序良俗或妨害風化之行為。
個人貴重物品、財物請自行妥善保管，若遺失本館恕不負責。
禁止攜帶雨具及寵物進入中心，輔助盲人同胞的導盲犬不在此限。
患有高血壓、糖尿病、心臟病、傳染病、飯後一小時內、血壓過低、酒後、嚴重睡眠不足時或其他任何身體不適者，禁止使用本設備。
若因使用不當造成設備/器材毀損，本中心有權要求損壞賠償。
未經同意禁止使用館內插座，如因活動或租借場地，需先付費後方能使用。
本須知如有未盡事宜，得另行增列、修訂之，並以現場公告或服務人員說明為準。','大安區'),
(12000002,13000001,'2023-11-11','2023-11-10','中正排球場','場地租借使用規範
1.使用本場地須穿著運動服裝、運動鞋(不得穿著涼鞋、皮鞋、高跟鞋)
2.本場地嚴禁吸菸、喝酒、吃檳榔、飲食及嚼食口香糖。
3.禁止攜帶寵物及雨具進入。
4.有任何不適宜從事場地運動之相關症狀或疾病者，謝絕使用
5.禁止隨行兒童於場地內奔跑嬉戲。
6.凡私人物品應自行保管。
7.排球網不可調整，如擅自調整造成設備/耗材損壞，租借人須照價賠償。
8.備有洗手間、製冰機(僅供冰敷)及飲水機。
9.租借單位須於租借時段內完成進退場，時間屆止，租借單位須立即離場
10.本場館亦開放包場辦理比賽、夏令營、冬令營等活動，費用另計，請洽本場地人員。','022749049','臺北市中正區大崙街11號1樓','','中正區'),
(12000003,13000002,'2023-11-11','2023-11-08','奧特菲羽球館','','028756853','臺北市大同區民生西路169號','Safety warning
1.請使用者考量自身身體狀況，如有可能造成意外或傷害，建議不要使用此場地。
2.私人物品自行保管；物品遺失本館恕不負責。
3.請勿吸菸、吐痰或檳榔汁、丟棄垃圾或煙蒂、燃放鞭炮、酗酒、鬥毆、夜宿及任何妨礙公共安全秩序、違反公序良俗或妨害風化之行為。
4.使用本場地進行活動時應遵守安全規定，管理人員得隨時制止使用者具有安全顧慮之行為，如不聽制止，本館得強制使用者離開場地。
5.敬請共同維護環境清潔暨愛惜各項設施，如蓄意破壞(如使用明火及其他危險物品)，一經查獲，依法究辦，並照價賠償。
6.球具（羽球及羽球拍）請自備，如須租借或購買請洽服務台。
7.禁止攜帶寵物及雨具、違禁品、毒品、槍械、爆裂物進入球場。
8.禁止隨行兒童於場地內嬉戲奔跑。
9.未經本館許可禁止拍攝、張貼、懸掛海報、旗幟、標語等。
10.應穿著運動服裝及運動鞋（羽球鞋），禁止穿著皮鞋、高跟鞋、拖鞋、黑底膠鞋等不合規定之鞋類進入活動場區，以避免損壞地面或受傷。
11.羽球架應由場館人員操作，未經許可請勿擅自操作使用，以防止危險發生或機器損壞。','大同區'),
(12000004,13000004,'2023-11-11','2023-11-08','陽明籃球館','','024103975','臺北市北投區義理街2號','本館使用須知:
◾使用完畢後借用單位須自行恢復場地原狀；場地及設備如有損壞，則照價賠償
◾本館禁止飲食、吸菸、喝酒、吃檳榔及嚼食口香糖。
◾禁止攜帶寵物(法令另有規定者，不在此限)及雨具進入。
◾若有以下情形之一，禁止使用本設備：（1）患有傳染性疾病者。（2）飯後一小時內、血壓過低、酒後、嚴重睡眠不足時或其他任何身體不適者。（3）患有高血壓、糖尿病、心臟病等，於生理或心理狀態不適宜入場使用之情形者。
◾必須穿著運動服裝及運動鞋進入場地，禁止穿著拖鞋、皮鞋、高跟鞋、木屐或其他不合場地使用規定之鞋類進入。
◾應於場地租借時間內使用，如非租用時間禁止擅自進入使用。
◾使用館內場地時，請注意使用時間，勿超時佔用，尊重下一位使用者的權利。
◾個人貴重物品、財務請自行妥善保管，若遺失本館恕不負責。
◾未經許可，禁止照相、攝影、錄音、張貼或懸掛海報、旗幟、標語等。
◾館內插座不提供給個人使用。 如因活動或租借場地，需先付費後方能使用。
◾場內設施請愛惜使用，嚴禁攜帶刀片、利器等異物入場以免破壞場地設施，不得隨意移動籃球框架等球場設施。如不當使用或蓄意破壞而造成設施毀損時，應負損害賠償責任。
◾本須知如有未盡事宜，得另行增列、修訂之，並以現場公告或工作人員說明為準。若未能配合管理者，現場工作人員將有權令其離場，以維護其他使用者的安全。','北投區'),
(12000005,13000007,'2023-11-11','2023-11-01','萬華活力球館','','024103975','臺北市萬華區青年路112號1樓','本館場地為綜合型比賽場地，租借單位需自行場佈及場復，另為維護場地設備正常使用及提供乾淨舒適的環境。
本館禁止飲食、吸菸、喝酒、吃檳榔及嚼食口香糖。
使用者應依各場館（地）屬性，穿著合適之服裝、使用安全無虞之運 動用具入場，並評估自身狀況，如有不宜運動之相關症候或法定傳染病者謝絕使用。
使用者自身財物等應自行保管，本場不負保管責任。
如遇場館（地）無法使用等情事，本場得隨時暫停使用或另行公告。
違反本規範經勸導仍不改善，本館得立即中止使用權利並令其離場，不得異議，並不得要求退還已繳之費用，因此衍生之損害，本場並得請求損害賠償，情節重大者，依法究辦。
本規範如有未盡事宜，本館得隨時修正之，經場長核定並報府備查後公告實施。','萬華區'),
(12000006,13000007,'2023-11-12','2023-11-10','新生排球場','','022596660','臺北市中山區復興北路344號3樓','球場使用須知:
（一） 嚴禁攜帶寵物、吸菸、飲酒、嚼食檳榔、口香糖及隨地丟棄垃圾或其他廢棄物。
（二） 嚴禁使用明火、燃放爆竹煙火等易損傷場地及火災之行為。
（三） 禁止各種車輛及損壞場地之器材入場。
（四） 嚴禁具危險性及妨礙他人活動之行為。
（五） 私人物品應自行保管，本所不負保管之責。
（六） 非經本所許可，不得於場內設置廣告及設攤。
（七） 如有違反上述規定，本所得禁止其使用並言詞勸導，若不服勸導者，必要時請警察機關協助處理。','中山區'),
(12000007,13000005,'2023-11-10','2023-11-10','紅季羽球綜合館','','022502684','臺北市中山區新生北路3段19巷19號1樓','使用須知:
(1)本館禁止使用火把、爆竹或其他危險物品之行為。
(2)本館不可私下教學。
(3)運動場區禁止飲食（飲用水除外）、吸煙、飲用含酒精類之飲品、嚼食檳榔或口香糖。
(4)未經本館核准，禁止使用或移動場內相關設備（含電源插座）。
(5)未經本場核准，禁止從事商業行為或置放廣告物。
(6)違反本規範經勸導仍不改善，本館得立即中止使用權利並令其離場，不得異議，並不得要求退還已繳之費用
(7)','中山區'),
(12000008,13000004,'2023-11-09','2023-11-10','TFK羽球館','','022781469','臺北市信義區林口街117號1樓 ','使用規範
1.患有傳染病、心臟病、急性骨骼運動傷害、惡性腫瘤及多發性硬化症、癲癇症、意識不清及未經控制之高血壓及糖尿病者，不可從事羽球等激烈運動。
2.進入本場地地板活動者，需著運動鞋(羽球鞋)，以維護地板品質。
3.使用本場地各項器材設備時應遵守安全規定，教練或指導員得以隨時制止使用者具有安全顧慮之行為，如不聽制止，本館得強制使用者離開本場地之權利。
4.嚴禁吸煙、喝酒、嚼食檳榔、口香糖、攜帶寵物(法令另有規定者除外)、雨具及攜帶任何食品進入館內。
5.公共場所私人物品須自行保管，若有遺失自行負責。
6.未經許可禁止張貼海報、旗幟、標語等。
7.未經申請核准者，不得進行私人教學。
8.違反本規範經勸導仍不改善，本場得立即中止使用權利並令其離場，不得異議，並不得要求退還已繳之費用','信義區'),
(12000009,13000008,'2023-11-13','2023-11-11','BOS運動館','','022362377','臺北市內湖區港墘路221巷39之1號 ','使用規定：
1、 進入本球場運動，須穿著運動服及膠底運動鞋，鞋底必須乾淨。
2、 禁止穿著硬底皮鞋或高跟鞋等，會損壞地板之鞋類進入。
3、 球場內禁止穿著拖鞋及打赤膊，以維護球場禮節及乾淨，並嚴禁攜帶動物及違禁品進入球場。
4、 本球場除飲用水外，禁止攜帶任何食物及飲料進入，並嚴禁嚼食口香糖、檳榔，以維護場內清潔。
5、 飲用水須用運動水壺或寶特瓶盛裝，並注意飲用，避免大量濺濕地板造成危險。
6、 本球場嚴禁止燭火，或燃放鞭炮、燃仙女棒、施放煙火等違反公共安全之行為。
7、 借用本球場辦理活動須鋪設防護地墊，並注意音量不得影響教學，如有違反情事，借用單位（人）應負相關責任。
8、 借用本球場如需其他設施及器材設備（含照明、影音視訊及空調等）須事先按規定借用。並於使用後回復原狀，如有損壞須照價賠償。
9、 本球場禁止塗鴉、劃線，未經許可不得增設標誌、擺設攤位、張貼或懸掛宣傳物品。
10、 嚴禁在體育館舞台上打球、對牆拍球。 ','南港區'),
(12000010,13000006,'2023-11-11','2023-11-08','艾特極運動生活館','','022577103','臺北市內湖區東湖路43巷16之1號1樓','艾特極運動生活館使用須知:
(一) 禁止寵物、車輛及攜帶危險物品進入。
(二) 禁止腳踏車、直排輪、滑板車等可能危害使用者安全之各項設備進入(輪椅不在此限)。
(三) 請勿偕同幼兒或寵物(導盲犬不在此限)進入球場奔跑嬉戲
(四) 請穿著合適之運動服裝及運動鞋。
(五) 請愛惜使用各項運動設施，如有毀損破壞者，除照價賠償外並以破壞公物處理。
(六) 禁止違反法律及善良風俗之行為。
(七) 本場地禁止燃放爆竹煙火
(八) 禁止球場內亂丟紙屑、果皮、瓶罐、口香糖、菸蒂及其他廢棄物，球場內不得飲酒、 抽菸、喧嘩、打架等違反社會秩序及任何有礙安全的行為，以免造成髒亂或發生危險。
(九) 進入本場地地板活動者，需著運動鞋，以維護場地品質。
(十) 本須知如有未盡事宜，得隨時修正之。','內湖區');

INSERT INTO time(timeID,reserveTime,courtID) 
 VALUES (0,"00:00-01:00",61000006),
		(1,"01:00-02:00",61000006),
        (2,"02:00-03:00",61000003),
		(3,"03:00-04:00",61000001),
		(4,"04:00-05:00",61000008),
		(5,"05:00-06:00",61000009),
        (6,"06:00-07:00",61000006),
        (7,"07:00-09:00",61000003),
		(8,"08:00-09:00",61000001),
		(9,"09:00-10:00",61000008),
		(10,"10:00-11:00",61000009),
        (11,"11:00-12:00",61000006),
        (12,"12:00-13:00",61000003),
		(13,"13:00-14:00",61000001),
		(14,"14:00-15:00",61000008),
		(15,"15:00-16:00",61000009),
        (16,"16:00-17:00",61000006),
        (17,"17:00-18:00",61000003),
		(18,"18:00-19:00",61000001),
		(19,"19:00-20:00",61000008),
		(20,"20:00-21:00",61000009),
        (21,"21:00-22:00",61000006),
        (22,"22:00-23:00",61000003),
		(23,"23:00-00:00",61000001);
        
INSERT INTO place (courtID, placeName, placeFee, ball)
VALUES 
(61000001,'飛龍運動館',450,2),
(61000002,'中正排球場',4500,1),
(61000003,'奧特菲羽球館',350,2),
(61000004,'陽明籃球館',5500,0),
(61000005,'萬華活力球館',1800,1),
(61000006,'新生排球場',1200,1),
(61000007,'紅季羽球綜合館',290,2),
(61000008,'TFK羽球館',300,2),
(61000009,'BOS運動館',3000,0),
(61000010,'艾特極運動生活館',2000,1);

INSERT INTO productOrder
(gUserID, courtID, productOrderTime, consume, productShipTime, productArriveTime, productShipStatus, gUserPiCnt, Ordertotal)
VALUES
(11000001, 61000001, '2023-10-02 16:30:00', '2023-10-02 17:30:00', '2023-10-03 10:00:00', '2023-10-05 12:00:00', 1, 1, 300),
(11000002, 61000002, '2023-10-02 18:15:00', '2023-10-02 19:30:00', '2023-10-03 12:00:00', '2023-10-05 14:30:00', 1, 2, 500),
(11000003, 61000003, '2023-10-02 20:00:00', '2023-10-02 21:15:00', '2023-10-03 14:00:00', '2023-10-05 16:30:00', 1, 5, 0),
(11000004, 61000004, '2023-10-02 22:30:00', '2023-10-02 23:45:00', '2023-10-03 16:00:00', '2023-10-05 18:30:00', 1, 3, 700),
(11000005, 61000005, '2023-10-02 23:59:59', '2023-10-03 01:00:00', '2023-10-03 18:30:00', '2023-10-05 20:45:00', 1, 2, 350),
(11000006, 61000006, '2023-10-03 02:15:00', '2023-10-03 03:30:00', '2023-10-03 20:00:00', '2023-10-05 22:00:00', 1, 1, 0),
(11000007, 61000007, '2023-10-03 04:30:00', '2023-10-03 05:45:00', '2023-10-03 22:30:00', '2023-10-06 00:30:00', 1, 2, 450),
(11000008, 61000008, '2023-10-03 06:00:00', '2023-10-03 07:15:00', '2023-10-03 23:59:59', '2023-10-06 02:15:00', 1, 1, 150),
(11000009, 61000009, '2023-10-03 08:30:00', '2023-10-03 09:45:00', '2023-10-04 02:30:00', '2023-10-06 04:30:00', 1, 4, 0),
(11000010, 61000010, '2023-10-03 10:45:00', '2023-10-03 12:00:00', '2023-10-04 04:00:00', '2023-10-06 06:00:00', 1, 1, 800);

INSERT INTO backAuthority (manageID, backFunctionID)
VALUES (13000001, 1),
		(13000002, 2),
        (13000003, 3),
        (13000004, 4),
        (13000005, 5),
        (13000006, 6),
        (13000007, 7),
        (13000008, 8),
        (13000009, 1),
        (13000010, 2);
        
INSERT INTO post (gUserID,oUserID,postTitle,postContent,postType,postTime,likeCnt) VALUES
(11000001,NULL,'我是標題','我是內文',0,'2022-01-01 12:00:00',99),
(11000004,NULL,'我是標題','我是內文',0,'2022-02-01 12:00:00',99),
(NULL,12000001,'我是標題','我是內文',2,'2022-11-10 12:00:00',99),
(11000008,NULL,'我是標題','我是內文',0,'2022-11-20 12:00:00',99),
(11000006,NULL,'我是標題','我是內文',0,'2022-12-25 12:00:00',99),
(11000007,NULL,'我是標題','我是內文',1,'2023-01-21 12:00:00',99),
(NULL,12000008,'我是標題','我是內文',2,'2023-05-03 12:00:00',666),
(11000003,NULL,'我是標題','我是內文',0,'2023-07-27 12:00:00',88),
(11000010,NULL,'我是標題','我是內文',1,'2023-10-13 12:00:00',66),
(11000001,NULL,'我是標題','我是內文',0,'2023-11-08 12:00:00',99);

INSERT INTO contactUs (oUserID, gUserID, formPurpose, formContent, formPic, formTime, formStatus, formType)
VALUES
(12000001,null,'關於上架球館問題','一次只能上架一座球館嗎?','','2023-11-13 12:05:13', 0, 0),
(null,11000001,'忘記密碼','我沒有收到確認信件!','','2023-11-13 12:30:43', 1, 0),
(12000008,null,'如何申請販售優惠券?','如何申請販售優惠券?','','2023-11-13 15:34:27', 0, 0),
(12000009,null,'如何申請販售優惠券?','如何申請販售優惠券?','','2023-11-13 15:34:13', 1, 0),
(null,11000008,'如何預約場館?','如何預約中正區的排球場?','','2023-11-13 09:30:55', 0, 0),
(12000004,null,'無法查看當日預約名單!','當日預約名單顯示不存在!','','2023-11-14 09:32:55', 0, 0),
(12000007,null,'活動請協助公告','活動請協助公告，如圖','','2023-11-14 09:30:55', 1, 0),
(null,11000010,'如何查看已預約紀錄?','如何查看已預約紀錄?','','2023-11-14 19:50:45', 0, 0),
(null,11000004,'沒有收到預約信件','沒有收到預約信件','','2023-11-14 21:30:04', 0, 0),
(null,11000005,'購買票券怎麼使用?','購買票券怎麼使用?','','2023-11-14 22:30:48', 1, 0);

INSERT INTO announcement(manageID, formID, annoTitle,annoContent,annoPic,annoTime, annoStatus) 
VALUES (13000001, 22000001, "優惠時段","10點到12點",null,'2023-11-09 13:30:00', 0),
	   (13000002, 22000002, "一起來運動","攜伴參加",null,'2023-10-05 16:10:00', 0),
       (13000003, 22000003, "讓你雙腳動起來","一起來跑步",null,'2022-09-21 10:00:00', 0),
       (13000004, 22000004, "飛奔健康人生","一周五日訓練",null,'2023-04-13 08:30:00', 0),
       (13000005, 22000005, "籃球3對3","開放報名",null,'2023-06-09 12:30:00', 0),
       (13000006, 22000006, "優惠時段","10點到12點",null,'2023-11-09 13:30:00', 0),
	   (13000007, 22000007, "一起來運動","攜伴參加",null,'2023-10-05 16:10:00', 0),
       (13000008, 22000008, "讓你雙腳動起來","一起來跑步",null,'2022-09-21 10:00:00', 0),
       (13000009, 22000009, "飛奔健康人生","一周五日訓練",null,'2023-04-13 08:30:00', 0),
       (13000010, 22000010, "籃球3對3","開放報名",null,'2023-06-09 12:30:00', 0);
       
INSERT INTO `comment` (gUserID,postID,commentContent,commentTime) VALUES
(11000004,31000004,'我是留言','2022-11-21 10:10:10'),
(11000009,31000005,'我是留言','2022-12-27 10:10:10'),
(11000005,31000003,'我是留言','2022-11-13 10:10:10'),
(11000010,31000010,'我是留言','2023-11-10 10:10:10'),
(11000003,31000007,'我是留言','2023-05-04 10:10:10'),
(11000003,31000007,'我是留言','2023-05-04 10:10:10'),
(11000001,31000005,'我是留言','2022-12-28 10:10:10'),
(11000001,31000008,'我是留言','2023-08-01 10:10:10'),
(11000008,31000002,'我是留言','2022-02-03 10:10:10'),
(11000007,31000001,'我是留言','2022-10-10 10:10:10');

INSERT INTO `like` (gUserID,postID) VALUES 
(11000001,31000001),
(11000001,31000002),
(11000006,31000003),
(11000008,31000004),
(11000003,31000005),
(11000004,31000001),
(11000002,31000001),
(11000002,31000005),
(11000001,31000008),
(11000010,31000001);

INSERT INTO report (manageID,postID,commentID,reportTime,reportStatus,reportType) VALUES
(13000001,NULL,32000001,'2023-7-7 07:00:00',0,4),
(13000003,NULL,32000002,'2023-7-7 07:00:00',1,0),
(13000005,NULL,32000005,'2023-7-7 07:00:00',0,4),
(13000006,31000008,NULL,'2023-7-7 07:00:00',0,2),
(13000008,NULL,32000009,'2023-7-7 07:00:00',0,3),
(13000010,31000010,NULL,'2023-7-7 07:00:00',1,2),
(13000001,31000010,NULL,'2023-7-7 07:00:00',1,4),
(13000002,31000003,NULL,'2023-7-7 07:00:00',0,3),
(13000002,31000004,NULL,'2023-7-7 07:00:00',0,5),
(13000001,NULL,32000006,'2023-7-7 07:00:00',1,1);

INSERT INTO forumpic (postID,postPic,picTime) VALUES
(31000003,NULL,'2023-11-11 11:00:00'),
(31000006,NULL,'2023-11-11 11:00:00'),
(31000009,NULL,'2023-11-11 11:00:00'),
(31000004,NULL,'2023-11-11 11:00:00'),
(31000005,NULL,'2023-11-11 11:00:00'),
(31000008,NULL,'2023-11-11 11:00:00'),
(31000010,NULL,'2023-11-11 11:00:00'),
(31000002,NULL,'2023-11-11 11:00:00'),
(31000001,NULL,'2023-11-11 11:00:00'),
(31000007,NULL,'2023-11-11 11:00:00');


INSERT INTO product
(oUserID, manageID, courtID, productTypeID, productName, productStatus, stock, productPic, productOnCnt, productApplyTime,
 productOnTime, productPrice, productDescription)
VALUES
(12000001, 13000001, 61000001, 0, 'Wilson 排球', 1, 99, NULL, 66,
'2023-10-01', '2023-10-02 13:14:07', 300, 'Wilson牌排球，不幸遇難漂流到無人島的話很好用'),
(12000002, 13000002, 61000002, 1, 'Nike 篮球', 1, 50, NULL, 30,
'2023-10-01', '2023-10-02 14:30:15', 500, 'Nike牌籃球，適合室內和室外使用'),
(12000003, 13000003, 61000003, 2, '折扣券 A', 1, 100, NULL, 80,
'2023-10-01', '2023-10-02 15:45:22', 0, '商品折扣券，適用於特定商品'),
(12000004, 13000004, 61000004, 1, 'Adidas 跑鞋', 1, 30, NULL, 20,
'2023-10-01', '2023-10-02 18:30:00', 700, 'Adidas牌跑鞋，舒適適合長時間運動'),
(12000005, 13000005, 61000005, 0, 'Spalding 籃球', 1, 80, NULL, 40,
'2023-10-01', '2023-10-02 19:45:30', 350, 'Spalding牌籃球，專業比賽用'),
(12000006, 13000006, 61000006, 2, '折扣券 B', 1, 120, NULL, 100,
'2023-10-01', '2023-10-02 21:00:45', 0, '商品折扣券，全站通用'),
(12000007, 13000007, 61000007, 1, 'Mizuno 羽毛球拍', 1, 25, NULL, 15,
'2023-10-01', '2023-10-02 22:15:00', 450, 'Mizuno牌羽毛球拍，輕便好握'),
(12000008, 13000008, 61000008, 0, 'Yonex 羽毛球', 1, 60, NULL, 35,
'2023-10-01', '2023-10-02 23:30:15', 150, 'Yonex牌羽毛球，耐用好打'),
(12000009, 13000009, 61000009, 2, '折扣券 C', 1, 150, NULL, 120,
'2023-10-02', '2023-10-03 10:45:30', 0, '商品折扣券，滿額送'),
(12000010, 13000010, 61000010, 1, 'Under Armour 運動褲', 1, 40, NULL, 25,
'2023-10-02', '2023-10-03 12:00:45', 800, 'Under Armour牌運動褲，透氣舒適');

INSERT INTO coupon
(productID)
VALUES
(51000001),
(51000002),
(51000003),
(51000004),
(51000005),
(51000006),
(51000007),
(51000008),
(51000009),
(51000010);


INSERT INTO productOrderList
(productOrderID, productID, productPrice, productOnCnt)
VALUES
(54000001, 51000001, 300, 2),
(54000002, 51000002, 500, 1),
(54000003, 51000003, 50, 5),
(54000004, 51000004, 700, 3),
(54000005, 51000005, 350, 2),
(54000006, 51000006, 4000, 1),
(54000007, 51000007, 450, 2),
(54000008, 51000008, 150, 1),
(54000009, 51000009, 10000, 4),
(54000010, 51000010, 800, 1);

INSERT INTO productPic
(productID, productPic)
VALUES
(51000001, NULL),
(51000002, NULL),
(51000003, NULL),
(51000004, NULL),
(51000005, NULL),
(51000006, NULL),
(51000007, NULL),
(51000008, NULL),
(51000009, NULL),
(51000010, NULL);

INSERT INTO cart (productID, gUserID)
VALUES
(51000001, 11000001), (51000002, 11000002), (51000003, 11000003), (51000004, 11000004), (51000005, 11000005),
(51000006, 11000006), (51000007, 11000007), (51000008, 11000008), (51000009, 11000009), (51000010, 11000010);

INSERT INTO reserveOrder 
(gUserID, oUserID, timeID, placeID, couponID, orderTime, orderNum, orderStatus, totalCost)
VALUES
(11000001, 12000001, 9, 62000001, 52000001, '2023-10-02 08:18:00', 2, 1, 1000), 
(11000002, 12000002, 10, 62000002, 52000002, '2023-10-03 09:24:45', 3, 1, 1500), 
(11000003, 12000003, 13, 62000003, 52000003, '2023-10-04 10:40:35', 5, 1, 2500), 
(11000004, 12000004, 14, 62000004, 52000004, '2023-10-05 11:44:38', 5, 1, 2500), 
(11000005, 12000005, 15, 62000005, 52000005, '2023-10-06 12:34:26', 4, 1, 2000),
(11000006, 12000006, 16, 62000006, 52000006, '2023-11-07 12:17:24', 4, 1, 2000),
(11000007, 12000007, 18, 62000007, 52000007, '2023-11-08 13:46:28', 3, 1, 1500), 
(11000008, 12000008, 19, 62000008, 52000008, '2023-11-09 13:57:55', 2, 1, 1000), 
(11000009, 12000009, 20, 62000009, 52000009, '2023-11-10 15:25:35', 1, 1, 500), 
(11000010, 12000010, 11, 62000010, 52000010, '2023-11-02 16:14:07', 1, 1, 500);
