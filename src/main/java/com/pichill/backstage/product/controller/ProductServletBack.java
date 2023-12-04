package com.pichill.backstage.product.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
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
import com.pichill.backstage.product.service.ProductServiceBack;
import com.pichill.manage.entity.Manage;
import com.pichill.manage.service.ManageService;
import com.pichill.product.entity.Product;


@MultipartConfig(fileSizeThreshold = 0 * 1024 * 1024, maxFileSize = 1 * 1024 * 1024, maxRequestSize = 10 * 1024 * 1024)
@WebServlet(name = "ProductBServlet", value = "/product/productb.do")
public class ProductServletBack extends HttpServlet {
	private ProductServiceBack productSvcB;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		productSvcB = new ProductServiceBack();
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
			forwardPath = "/backstage/productBack/all_manage.jsp";
		}

		res.setContentType("text/html; charset=UTF-8");
		RequestDispatcher dispatcher = req.getRequestDispatcher(forwardPath);
		dispatcher.forward(req, res);
	}
	
	private String getOneUpdate(HttpServletRequest req, HttpServletResponse res)  {
//		Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
//		req.setAttribute("errorMsgs", errorMsgs);
		Integer productID = Integer.valueOf(req.getParameter("productID"));

		Product product = productSvcB.getOneProduct(productID);
	
		req.setAttribute("product", product);
		return "/backstage/productBack/set_product.jsp";
	}
	
	private String update(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 錯誤處理
		List<String> errorMsgs = new ArrayList<>();
		req.setAttribute("errorMsgs", errorMsgs);

		/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
		Integer productID = Integer.valueOf(req.getParameter("productID"));
		
		Integer oUserID = Integer.valueOf(req.getParameter("oUserID"));
		if (oUserID != null) {
			oUserID = Integer.valueOf(req.getParameter("oUserID"));
		} else {
			errorMsgs.add("not null!");
		}
		
		Integer manageID = Integer.valueOf(req.getParameter("manageID"));
		if (manageID != null) {
			manageID = Integer.valueOf(req.getParameter("manageID"));
		} else {
			errorMsgs.add("not null!");
		}
		
		Integer courtID = Integer.valueOf(req.getParameter("courtID"));
		if (courtID != null) {
			courtID = Integer.valueOf(req.getParameter("courtID"));
		} else {
			errorMsgs.add("not null!");
		}
		
		Integer productTypeID = Integer.valueOf(req.getParameter("productTypeID"));
		if (productTypeID != null) {
			productTypeID = Integer.valueOf(req.getParameter("productTypeID"));
		} else {
			errorMsgs.add("not null!");
		}
		
		String productName = req.getParameter("productName ");
		if (productName  != null) {
			productName  = req.getParameter("productName ");
		} else {
			errorMsgs.add("not null!");
		}
		
		Integer productStatus = Integer.valueOf(req.getParameter("productStatus"));
		
		Integer productApplyStatus = Integer.valueOf(req.getParameter("productApplyStatus"));
		
		Integer stock = Integer.valueOf(req.getParameter("stock"));
		if (stock != null) {
			stock = Integer.valueOf(req.getParameter("stock"));
		} else {
			errorMsgs.add("not null!");
		}
		
		byte[] productPic = null;
		
		Integer productOnCnt = Integer.valueOf(req.getParameter("productOnCnt"));
		if (productOnCnt != null) {
			productOnCnt = Integer.valueOf(req.getParameter("productOnCnt"));
		} else {
			errorMsgs.add("not null!");
		}
		
		Timestamp productApplyTime = java.sql.Timestamp.valueOf(req.getParameter("productApplyTime").trim());
		if (req.getParameter("productApplyTime") != null) {
			// 如果請求中有傳時間參數,使用該時間
			productApplyTime = java.sql.Timestamp.valueOf(req.getParameter("productApplyTime").trim());
		} else {
			// 如果請求沒有傳時間參數,查詢資料庫中原有的時間
			errorMsgs.add("not null!");
		}
		
		Timestamp productOnTime = java.sql.Timestamp.valueOf(req.getParameter("productOnTime").trim());
		if (req.getParameter("productOnTime") != null) {
			// 如果請求中有傳時間參數,使用該時間
			productOnTime = java.sql.Timestamp.valueOf(req.getParameter("productOnTime").trim());
		} else {
			// 如果請求沒有傳時間參數,查詢資料庫中原有的時間
			errorMsgs.add("not null!");
		}
		
		Integer productPrice = Integer.valueOf(req.getParameter("productPrice"));
		if (productPrice != null) {
			productPrice = Integer.valueOf(req.getParameter("productPrice"));
		} else {
			errorMsgs.add("not null!");
		}
		
		String productDescription = req.getParameter("productDescription ");
		if (productDescription  != null) {
			productDescription  = req.getParameter("productDescription");
		} else {
			errorMsgs.add("not null!");
		}
		
		Product product = new Product();
		product.setProductID(productID);
		product.setoUserID(oUserID);
		product.setManageID(manageID);
		product.setCourtID(courtID);
		product.setProductTypeID(productTypeID);
		product.setProductName(productName);
		product.setProductStatus(productStatus);
		product.setProductApplyStatus(productApplyStatus);
		product.setStock(stock);	
		product.setProductPic(productPic);
		product.setProductOnCnt(productOnCnt);
		product.setProductApplyTime(productApplyTime);
		product.setProductOnTime(productOnTime);
		product.setProductPrice(productPrice);
		product.setProductDescription(productDescription);

		// Send the use back to the form, if there were errors
		if (!errorMsgs.isEmpty()) {
			req.setAttribute("product", product); // 含有輸入格式錯誤的manage物件,也存入req
			return "/backstage/productBack/set_product.jsp"; // 程式中斷
		}

		/*************************** 2.開始修改資料 *****************************************/
		productSvcB.updateProduct(product);
		req.setAttribute("product", productSvcB.getOneProduct(productID));

		/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
		req.setAttribute("product", product); // 資料庫update成功後,正確的的manage物件,存入req
		return "/backstage/productBack/all_product.jsp";
	}
	
	private String insert(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 錯誤處理
		List<String> errorMsgs = new ArrayList<>();
		req.setAttribute("errorMsgs", errorMsgs);
		/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
		Integer oUserID = Integer.valueOf(req.getParameter("oUserID"));
		if (oUserID != null) {
			oUserID = Integer.valueOf(req.getParameter("oUserID"));
		} else {
			errorMsgs.add("請輸入企業會員編號!");
		}
		
		Integer manageID = Integer.valueOf(req.getParameter("manageID"));
		if (manageID != null) {
			manageID = Integer.valueOf(req.getParameter("manageID"));
		} else {
			errorMsgs.add("請輸入管理員編號!");
		}
		
		Integer courtID = Integer.valueOf(req.getParameter("courtID"));
		if (courtID != null) {
			courtID = Integer.valueOf(req.getParameter("courtID"));
		} else {
			errorMsgs.add("請輸入球館編號!");
		}
		
		Integer productTypeID = Integer.valueOf(req.getParameter("productTypeID"));
		if (productTypeID != null) {
			productTypeID = Integer.valueOf(req.getParameter("productTypeID"));
		} else {
			errorMsgs.add("請選擇商品種類編號!");
		}
		
		String productName = req.getParameter("productName ");
		if (productName  != null) {
			productName  = req.getParameter("productName ");
		} else {
			errorMsgs.add("請輸入商品名稱!");
		}
		
		Integer productStatus = Integer.valueOf(req.getParameter("productStatus"));
		
		Integer productApplyStatus = Integer.valueOf(req.getParameter("productApplyStatus"));
		
		Integer stock = Integer.valueOf(req.getParameter("stock"));
		if (stock != null) {
			stock = Integer.valueOf(req.getParameter("stock"));
		} else {
			errorMsgs.add("請輸入商品庫存!");
		}
		
		byte[] productPic = null;
		
		Integer productOnCnt = Integer.valueOf(req.getParameter("productOnCnt"));
		if (productOnCnt != null) {
			productOnCnt = Integer.valueOf(req.getParameter("productOnCnt"));
		} else {
			errorMsgs.add("請輸入上架數量!");
		}
		
		Timestamp productApplyTime = java.sql.Timestamp.valueOf(req.getParameter("productApplyTime").trim());
		if (req.getParameter("productApplyTime") != null) {
			// 如果請求中有傳時間參數,使用該時間
			productApplyTime = java.sql.Timestamp.valueOf(req.getParameter("productApplyTime").trim());
		} else {
			// 如果請求沒有傳時間參數,查詢資料庫中原有的時間
			errorMsgs.add("not null!");
		}
		
		Timestamp productOnTime = java.sql.Timestamp.valueOf(req.getParameter("productOnTime").trim());
		if (req.getParameter("productOnTime") != null) {
			// 如果請求中有傳時間參數,使用該時間
			productOnTime = java.sql.Timestamp.valueOf(req.getParameter("productOnTime").trim());
		} else {
			// 如果請求沒有傳時間參數,查詢資料庫中原有的時間
			errorMsgs.add("not null!");
		}
		
		Integer productPrice = Integer.valueOf(req.getParameter("productPrice"));
		if (productPrice != null) {
			productPrice = Integer.valueOf(req.getParameter("productPrice"));
		} else {
			errorMsgs.add("請輸入商品價格!");
		}
		
		String productDescription = req.getParameter("productDescription ");
		if (productDescription  != null) {
			productDescription  = req.getParameter("productDescription");
		} else {
			errorMsgs.add("請輸入商品敘述!");
		}
		
		Product product = new Product();
		product.setoUserID(oUserID);
		product.setManageID(manageID);
		product.setCourtID(courtID);
		product.setProductTypeID(productTypeID);
		product.setProductName(productName);
		product.setProductStatus(productStatus);
		product.setProductApplyStatus(productApplyStatus);
		product.setStock(stock);	
		product.setProductPic(productPic);
		product.setProductOnCnt(productOnCnt);
		product.setProductApplyTime(productApplyTime);
		product.setProductOnTime(productOnTime);
		product.setProductPrice(productPrice);
		product.setProductDescription(productDescription);
		// Send the use back to the form, if there were errors
		if (!errorMsgs.isEmpty()) {
			req.setAttribute("product", product); // 含有輸入格式錯誤的empVO物件,也存入req
			return "/backstage/productBack/new_product.jsp";
		}

		/*************************** 2.開始新增資料 ***************************************/

		productSvcB.insertProduct(product);

		/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
		return "/backstage/productBack/all_product.jsp";
	}
}
