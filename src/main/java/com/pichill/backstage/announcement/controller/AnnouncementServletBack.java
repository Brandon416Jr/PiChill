package com.pichill.backstage.announcement.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pichill.backstage.announcement.entity.Announcement;
import com.pichill.backstage.announcement.service.AnnouncementServiceBack;




@MultipartConfig(fileSizeThreshold = 0 * 1024 * 1024, maxFileSize = 1 * 1024 * 1024, maxRequestSize = 10 * 1024 * 1024)
@WebServlet(name = "AnnouncementBServlet", value = "/announcement/announcementb.do")
public class AnnouncementServletBack extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		
		if(action != null){
			  action.hashCode(); 
			} else {
				System.out.println("action為空值");
			}
		switch (action) {
//		case "getOne_For_Display":
//			// // 來自index.jsp的請求
//			forwardPath = getOneDisplay(req, res);
//			break;
		case "getOne_For_Update":
			// 來自all_manage.jsp的請求
			forwardPath = getOneUpdate(req, res);
			break;
		case "update":
			// 來自set_manage.jsp的請求
			forwardPath = update(req, res);
			break;
		case "insert":
			// 來自new_manage.jsp的請求
			forwardPath = insert(req, res);
			break;
		default:
			forwardPath = "/backstage/announcementBack/all_announcement.jsp";
		}

		res.setContentType("text/html; charset=UTF-8");
		RequestDispatcher dispatcher = req.getRequestDispatcher(forwardPath);
		dispatcher.forward(req, res);
	}
	
	private String getOneUpdate(HttpServletRequest req, HttpServletResponse res)  {
//		Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
//		req.setAttribute("errorMsgs", errorMsgs);
		Integer announceID = Integer.valueOf(req.getParameter("announceID"));

		Announcement announcement = annoSvcB.getOneAnnouncement(announceID);

		req.setAttribute("announcement", announcement);
		return "/backstage/announcementBack/set_announcement.jsp";
	}
	
	private String update(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 錯誤處理
		List<String> errorMsgs = new ArrayList<>();
		req.setAttribute("errorMsgs", errorMsgs);

		/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
		Integer announceID = Integer.valueOf(req.getParameter("announceID"));
		Announcement announcement = annoSvcB.getOneAnnouncement(announceID);

		Integer manageID = Integer.valueOf(req.getParameter("manageID"));
		if (manageID != null) {
			manageID = Integer.valueOf(req.getParameter("manageID"));
		} else {
			errorMsgs.add("manageID cannot null!");
		}
		
//		Integer formID = Integer.valueOf(req.getParameter("formID"));
//		if (formID != null) {
//			formID = Integer.valueOf(req.getParameter("formID"));
//		} else {
//			errorMsgs.add("not null!");
//		}
		
		String annoTitle = req.getParameter("annoTitle");
		if (annoTitle != null) {
			annoTitle = req.getParameter("annoTitle");
		} else {
			errorMsgs.add("annoTitle cannot null!");
		}
		
		String annoContent = req.getParameter("annoContent");
		if (annoContent != null) {
			annoContent = req.getParameter("annoContent");
		} else {
			errorMsgs.add("annoContent cannot null!");
		}
		
		InputStream in = req.getPart("annoPic").getInputStream(); //從javax.servlet.http.Part物件取得上傳檔案的InputStream
		byte[] annoPic = null;
		if(in.available()!=0){
			annoPic = new byte[in.available()];
			in.read(annoPic);
			in.close();
		}  else {
			AnnouncementServiceBack annoSvcB = new AnnouncementServiceBack();
			annoPic = annoSvcB.getOneAnnouncement(announceID).getAnnoPic();
		}
		
//		Timestamp annoTime = java.sql.Timestamp.valueOf(req.getParameter("annoTime").trim());
//		if (req.getParameter("annoTime") != null) {
//			// 如果請求中有傳時間參數,使用該時間
//			annoTime = java.sql.Timestamp.valueOf(req.getParameter("annoTime").trim());
//		} else {
//			// 如果請求沒有傳時間參數,查詢資料庫中原有的時間
//			errorMsgs.add("not null!");
//		}
		
		Integer annoStatus = Integer.valueOf(req.getParameter("annoStatus"));
		if (annoStatus == null) {
			annoStatus = announcement.getAnnoStatus();
		} else {
			
		}
		
//		Announcement announcement = new Announcement();
		announcement.setAnnounceID(announceID);
		announcement.setManageID(manageID);
//		announcement.setFormID(formID);
		announcement.setAnnoTitle(annoTitle);
		announcement.setAnnoContent(annoContent);
		announcement.setAnnoPic(annoPic);
//		announcement.setAnnoTime(annoTime);
		announcement.setAnnoStatus(annoStatus);

		// Send the use back to the form, if there were errors
		if (!errorMsgs.isEmpty()) {
			req.setAttribute("announcement", announcement); // 含有輸入格式錯誤的manage物件,也存入req
			return "/backstage/announcementBack/set_announcement.jsp"; // 程式中斷
		}

		/*************************** 2.開始修改資料 *****************************************/
		annoSvcB.updateAnnouncement(announcement);
		req.setAttribute("announcement", annoSvcB.getOneAnnouncement(announceID));

		/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
		req.setAttribute("announcement", announcement); // 資料庫update成功後,正確的的manage物件,存入req
		return "/backstage/announcementBack/all_announcement.jsp";
	}
	
	private String insert(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 錯誤處理
		List<String> errorMsgs = new ArrayList<>();
		req.setAttribute("errorMsgs", errorMsgs);
		/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
		Integer manageID = Integer.valueOf(req.getParameter("manageID"));
		if (manageID != null) {
			manageID = Integer.valueOf(req.getParameter("manageID"));
		} else {
			errorMsgs.add("manageID not null!");
		}
		
		Integer formID = Integer.valueOf(req.getParameter("formID"));
		if (formID != null) {
			formID = Integer.valueOf(req.getParameter("formID"));
		} else {
			errorMsgs.add("formID not null!");
		}
		
		String annoTitle = req.getParameter("annoTitle");
		if (annoTitle != null) {
			annoTitle = req.getParameter("annoTitle");
		} else {
			errorMsgs.add("annoTitle not null!");
		}
		
		String annoContent = req.getParameter("annoContent");
		if (annoContent != null) {
			annoContent = req.getParameter("annoContent");
		} else {
			errorMsgs.add("annoContent not null!");
		}
		
		InputStream in = req.getPart("annoPic").getInputStream(); //從javax.servlet.http.Part物件取得上傳檔案的InputStream
		byte[] annoPic = null;
		if(in.available()!=0){
			annoPic = new byte[in.available()];
			in.read(annoPic);
			in.close();
		}  else errorMsgs.add("公告照片: 請上傳照片");
		
		Timestamp annoTime = null;
//		if (req.getParameter("annoTime") != null) {
//			// 如果請求中有傳時間參數,使用該時間
//			annoTime = java.sql.Timestamp.valueOf(req.getParameter("annoTime").trim());
//		} else {
//			// 如果請求沒有傳時間參數,查詢資料庫中原有的時間
//			errorMsgs.add("annoTime cannot null!");
//		}
//		
		Integer annoStatus = Integer.valueOf(req.getParameter("annoStatus"));
		if (annoStatus == null) {
			errorMsgs.add("表單狀態: 請選擇");
		}
		
		Announcement announcement = new Announcement();
		announcement.setManageID(manageID);
		announcement.setFormID(formID);
		announcement.setAnnoTitle(annoTitle);
		announcement.setAnnoContent(annoContent);
		announcement.setAnnoPic(annoPic);
		announcement.setAnnoTime(annoTime);
		announcement.setAnnoStatus(annoStatus);
		
		// Send the use back to the form, if there were errors
		if (!errorMsgs.isEmpty()) {
			req.setAttribute("announcement", announcement); // 含有輸入格式錯誤的empVO物件,也存入req
			return "/backstage/announcementBack/new_announcement.jsp";
		}

		/*************************** 2.開始新增資料 ***************************************/

		annoSvcB.insertAnnouncement(announcement);

		/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
		return "/backstage/announcementBack/all_announcement.jsp";
	}
}
