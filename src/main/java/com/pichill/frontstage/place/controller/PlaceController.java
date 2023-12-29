package com.pichill.frontstage.place.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pichill.court.Court;
import com.pichill.frontstage.court.service.CourtServiceFront;
import com.pichill.frontstage.place.service.PlaceServiceFront;
import com.pichill.owneruser.entity.OwnerUser;
import com.pichill.place.Place;

@WebServlet("/place/placef.do")
public class PlaceController extends HttpServlet {
private PlaceServiceFront placeSvcF;
	
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		placeSvcF = new PlaceServiceFront();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Enter CourtServletFront doGet");
		doPost(req, res);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		String action = req.getParameter("action");
		System.out.println(action);
//		System.out.println(req.getParameterMap().toString());	
		String forwardPath = "";
		if(action != null){
			  action.hashCode(); 
			} else {
				System.out.println("action為空值");
//				action = "default";
			}
		
		switch (action) {
		case "insert":
			forwardPath = insert(req, res);
			break;
		default:
			forwardPath = "/testCourt/all_court.jsp";
		}

		res.setContentType("text/html; charset=UTF-8");
		RequestDispatcher dispatcher = req.getRequestDispatcher(forwardPath);
		dispatcher.forward(req, res);
	}
	
	private String insert(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 錯誤處理
		List<String> errorMsgs = new ArrayList<>();
		req.setAttribute("errorMsgs", errorMsgs);
		System.out.println("進來insert了");

		/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
		HttpSession session = req.getSession();
		OwnerUser ownerUser = (OwnerUser)session.getAttribute("ownerUser");
		Integer oUserID = ownerUser.getoUserID();
//		CourtServiceFront courtSvcF = new CourtServiceFront();
//		List<Court> court = courtSvcF.getoUserID(oUserID);
//		req.setAttribute("court", court);
//		Court court = new Court();
//		Integer courtID = Integer.valueOf(req.getParameter("courtID"));
//		court.setCourtID(courtID);
		
		String placeName = req.getParameter("placeName");
		
		Integer placeFee = Integer.valueOf(req.getParameter("placeFee"));
		
		Integer ball = Integer.valueOf(req.getParameter("ball"));
		
		Place place = new Place();
//		place.setCourt(court);
		place.setBall(ball);
		place.setPlaceFee(placeFee);
		place.setPlaceName(placeName);

		// Send the use back to the form, if there were errors
		if (!errorMsgs.isEmpty()) {
			req.setAttribute("place", place); // 含有輸入格式錯誤的manage物件,也存入req
			return "/testCourt/new_place.jsp"; // 程式中斷
		}

		/*************************** 2.開始修改資料 *****************************************/
		System.out.println("place:"+place.toString());
		placeSvcF.insertPlaceAll(place);

		/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
		req.setAttribute("place", place); // 資料庫update成功後,正確的的manage物件,存入req
		return "/testCourt/all_court.jsp";
	}
}
