package com.pichill.announcementgetone.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pichill.announcementgetone.entity.AnnouncementGetOne;
import com.pichill.announcementgetone.service.AnnouncementGetOneService;
import com.pichill.backstage.announcement.entity.Announcement;
import com.pichill.backstage.announcement.service.AnnouncementServiceBack;

@SuppressWarnings("serial")
@MultipartConfig(fileSizeThreshold = 0 * 1024 * 1024, maxFileSize = 1 * 1024 * 1024, maxRequestSize = 10 * 1024 * 1024)
@WebServlet(name = "AnnouncementServlet", value = "/announcement/announcement.do")
public class AnnouncementGetOneServlet extends HttpServlet {
	private AnnouncementServiceBack annoSvcB;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		annoSvcB = new AnnouncementServiceBack();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, res);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		String action = req.getParameter("action");
		String forwardPath = "";
		switch (action) {
		// 使用者點擊單筆公告時顯示單筆給使用者看
		case "getOne_For_Display":
			forwardPath = getOneDisplay(req, res);
			break;
		// 來自index.jsp的請求
		// 預設list all列出所有公告給使用者看
		default:
			forwardPath = "/announcement/announcement.jsp";
		}

		res.setContentType("text/html; charset=UTF-8");
		RequestDispatcher dispatcher = req.getRequestDispatcher(forwardPath);
		dispatcher.forward(req, res);
	}

	private String getOneDisplay(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		Integer announceID = Integer.valueOf(req.getParameter("announceID"));
		String annoTitle = req.getParameter("annoTitle");

		Announcement announcement = annoSvcB.getOneAnnouncement(announceID);
//		AnnouncementGetOne announcementGetOneByAnnoTitle = annoGetOneSvc.getAnnouncementByAnnoTitle(annoTitle);

		req.setAttribute("announcement", announcement);
//		req.setAttribute("announcement", announcementGetOneByAnnoTitle);
		return "/announcement/announcement_single.jsp";
	}

//	private String getOneUpdate(HttpServletRequest req, HttpServletResponse res)  {
//		Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
//		req.setAttribute("errorMsgs", errorMsgs);
//		Integer announceID = Integer.valueOf(req.getParameter("announceID"));
//
//		Announcement announcement = annoSvcB.getOneAnnouncement(announceID);
//
//		req.setAttribute("announcement", announcement);
//		return "/announcementBack/set_announcement.jsp";
//	}

	// 沒有update 和insert(新增）以下可以先註解起來，等以後有再打開
//	private String update(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		// 錯誤處理
//		List<String> errorMsgs = new ArrayList<>();
//		req.setAttribute("errorMsgs", errorMsgs);
//
//		/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
//		Integer announceID = Integer.valueOf(req.getParameter("announceID"));
//
//		Integer manageID = Integer.valueOf(req.getParameter("manageID"));
//		if (manageID != null) {
//			manageID = Integer.valueOf(req.getParameter("manageID"));
//		} else {
//			errorMsgs.add("not null!");
//		}
//		
//		Integer formID = Integer.valueOf(req.getParameter("formID"));
//		if (formID != null) {
//			formID = Integer.valueOf(req.getParameter("formID"));
//		} else {
//			errorMsgs.add("not null!");
//		}
//		
//		String annoTitle = req.getParameter("annoTitle");
//		if (annoTitle != null) {
//			annoTitle = req.getParameter("annoTitle");
//		} else {
//			errorMsgs.add("not null!");
//		}
//		
//		String annoContent = req.getParameter("annoContent");
//		if (annoContent != null) {
//			annoContent = req.getParameter("annoContent");
//		} else {
//			errorMsgs.add("not null!");
//		}
//		
//		byte[] annoPic = null;
//		
//		Timestamp annoTime = java.sql.Timestamp.valueOf(req.getParameter("annoTime").trim());
//		if (req.getParameter("annoTime") != null) {
//			// 如果請求中有傳時間參數,使用該時間
//			annoTime = java.sql.Timestamp.valueOf(req.getParameter("annoTime").trim());
//		} else {
//			// 如果請求沒有傳時間參數,查詢資料庫中原有的時間
//			errorMsgs.add("not null!");
//		}
//		
//		Integer annoStatus = Integer.valueOf(req.getParameter("annoStatus"));
//		
//		Announcement announcement = new Announcement();
//		announcement.setAnnounceID(announceID);
//		announcement.setManageID(manageID);
//		announcement.setFormID(formID);
//		announcement.setAnnoTitle(annoTitle);
//		announcement.setAnnoContent(annoContent);
//		announcement.setAnnoPic(annoPic);
//		announcement.setAnnoTime(annoTime);
//		announcement.setAnnoStatus(annoStatus);
//
//		// Send the use back to the form, if there were errors
//		if (!errorMsgs.isEmpty()) {
//			req.setAttribute("announcement", announcement); // 含有輸入格式錯誤的manage物件,也存入req
//			return "/announcement/set_announcement.jsp"; // 程式中斷
//		}
//
//		/*************************** 2.開始修改資料 *****************************************/
//		annoGetOneSvc.updateAnnouncement(announcement);
//		req.setAttribute("announcement", annoGetOneSvc.getOneAnnouncement(announceID));
//
//		/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
//		req.setAttribute("announcement", announcement); // 資料庫update成功後,正確的的manage物件,存入req
//		return "/backstage/announcementBack/all_announcement.jsp";
//	}
//	
//	private String insert(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		// 錯誤處理
//		List<String> errorMsgs = new ArrayList<>();
//		req.setAttribute("errorMsgs", errorMsgs);
//		/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
//		Integer manageID = Integer.valueOf(req.getParameter("manageID"));
//		if (manageID != null) {
//			manageID = Integer.valueOf(req.getParameter("manageID"));
//		} else {
//			errorMsgs.add("not null!");
//		}
//		
//		Integer formID = Integer.valueOf(req.getParameter("formID"));
//		if (formID != null) {
//			formID = Integer.valueOf(req.getParameter("formID"));
//		} else {
//			errorMsgs.add("not null!");
//		}
//		
//		String annoTitle = req.getParameter("annoTitle");
//		if (annoTitle != null) {
//			annoTitle = req.getParameter("annoTitle");
//		} else {
//			errorMsgs.add("not null!");
//		}
//		
//		String annoContent = req.getParameter("annoContent");
//		if (annoContent != null) {
//			annoContent = req.getParameter("annoContent");
//		} else {
//			errorMsgs.add("not null!");
//		}
//		
//		byte[] annoPic = null;
//		
//		Timestamp annoTime = java.sql.Timestamp.valueOf(req.getParameter("annoTime").trim());
//		if (req.getParameter("annoTime") != null) {
//			// 如果請求中有傳時間參數,使用該時間
//			annoTime = java.sql.Timestamp.valueOf(req.getParameter("annoTime").trim());
//		} else {
//			// 如果請求沒有傳時間參數,查詢資料庫中原有的時間
//			errorMsgs.add("not null!");
//		}
//		
//		Integer annoStatus = Integer.valueOf(req.getParameter("annoStatus"));
//		
//		Announcement announcement = new Announcement();
//		announcement.setManageID(manageID);
//		announcement.setFormID(formID);
//		announcement.setAnnoTitle(annoTitle);
//		announcement.setAnnoContent(annoContent);
//		announcement.setAnnoPic(annoPic);
//		announcement.setAnnoTime(annoTime);
//		announcement.setAnnoStatus(annoStatus);
//		// Send the use back to the form, if there were errors
//		if (!errorMsgs.isEmpty()) {
//			req.setAttribute("announcement", announcement); // 含有輸入格式錯誤的empVO物件,也存入req
//			return "/backstage/announcementBack/new_announcement.jsp";
//		}
//
//		/*************************** 2.開始新增資料 ***************************************/
//
//		annoGetOneSvc.insertAnnouncement(announcement);
//
//		/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
//		return "/announcement/all_announcement.jsp";
//	}
}
