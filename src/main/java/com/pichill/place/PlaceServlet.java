package com.pichill.place;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Time;
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

import com.pichill.court.Court;
import com.pichill.court.CourtService;
import com.pichill.place.*;

@MultipartConfig(fileSizeThreshold = 0 * 1024 * 1024, maxFileSize = 1 * 1024 * 1024, maxRequestSize = 10 * 1024 * 1024)
@WebServlet(name = "PlaceServlet", value = "/place/place.do")
public class PlaceServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
 
    private PlaceService placeService;
    public void init() throws ServletException {
		// TODO Auto-generated method stub
		placeService = new PlaceService();
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
//		case "getOne_For_Display":
//			// // 來自index.jsp的請求
//			forwardPath = getOneDisplay(req, res);
//			break;
		case "getOne_For_Update":
			// 來自all_court.jsp的請求
			forwardPath = getOneUpdate(req, res);
			break;
		case "update":
			// 來自set_court.jsp的請求
			forwardPath = update(req, res);
			break;
		case "insert":
			// 來自new_court.jsp的請求
			forwardPath = insert(req, res);
			break;
		default:
			forwardPath = "/owneruser/court/all_court.jsp";
		}

		res.setContentType("text/html; charset=UTF-8");
		RequestDispatcher dispatcher = req.getRequestDispatcher(forwardPath);
		dispatcher.forward(req, res);
	}
	
	private String getOneUpdate(HttpServletRequest req, HttpServletResponse res) {
		Integer placeID = Integer.valueOf(req.getParameter("placeID"));

		Place place = placeService.getOnePlace(placeID);

		req.setAttribute("place", place);
		return "/court/all_court.jsp";
	}
	
	
	//===========================更新==============================================	
	
	
		private String update(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
			// 錯誤處理
			List<String> errorMsgs = new ArrayList<>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			Integer placeID = Integer.valueOf(req.getParameter("placeID"));
			Integer courtID = Integer.valueOf(req.getParameter("courtID"));
			Integer placeFee = Integer.valueOf(req.getParameter("placeFee").trim());
			
			String placeName = req.getParameter("placeName");
			if (placeName == null || placeName.trim().isEmpty())
				errorMsgs.add("請輸入場地名稱");
			Integer ball = Integer.valueOf(req.getParameter("ball").trim());
			

			// 假如輸入格式錯誤的，備份選原使用者輸入過的資料
			Place place = new Place();
			place.setPlaceID(placeID);
			place.setCourtID(courtID);
			place.setPlaceName(placeName);
			place.setPlaceFee(placeFee);
			place.setBall(ball);
			
			place.toString();

			// ========================================================================改到這===============

			if (!errorMsgs.isEmpty()) {
				req.setAttribute("place", place); // 含有輸入格式錯誤的manage物件,也存入req
				return "/owneruser/court/set_court.jsp"; // 程式中斷
			}
			/*************************** 2.開始修改資料 *****************************************/

			placeService.updatePlace(place);
			req.setAttribute("place", placeService.getOnePlace(placeID));

			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			req.setAttribute("place", place); // 資料庫update成功後,正確的的empVO物件,存入req
			return "/owneruser/court/all_Court.jsp";
		}

		// ==============insert 資料========================
		private String insert(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
			// 錯誤處理
			List<String> errorMsgs = new ArrayList<>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
			Integer placeID = Integer.valueOf(req.getParameter("placeID"));
			Integer courtID = Integer.valueOf(req.getParameter("courtID"));
			Integer placeFee = Integer.valueOf(req.getParameter("placeFee").trim());
			
			String placeName = req.getParameter("placeName");
			if (placeName == null || placeName.trim().isEmpty())
				errorMsgs.add("請輸入場地名稱");
			Integer ball = Integer.valueOf(req.getParameter("ball").trim());
			

			// 假如輸入格式錯誤的，備份選原使用者輸入過的資料
			Place place = new Place();
			place.setPlaceID(placeID);
			place.setCourtID(courtID);
			place.setPlaceName(placeName);
			place.setPlaceFee(placeFee);
			place.setBall(ball);
			
			place.toString();

		
			place.toString();
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("place", place); // 含有輸入格式錯誤的empVO物件,也存入req
				return "owneruser/court/new_court.jsp";
			}
	// ========================================================================改到這===============

			/*************************** 2.開始新增資料 ***************************************/
			placeService.addPlace(place);

			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			return "/court/all_court.jsp";

		}
	
	
	
}
