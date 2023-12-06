package com.pichill.backstage.post.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pichill.post.entity.Post;
import com.pichill.backstage.post.service.PostServiceBack;


@WebServlet(name = "PostBServlet", value="/post/postb.do")
public class PostServletBack extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

//		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求
//
//			List<String> errorMsgs = new LinkedList<String>();
//			// Store this set in the request scope, in case we need to
//			// send the ErrorPage view.
//			req.setAttribute("errorMsgs", errorMsgs);
//
//			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
//			String str = req.getParameter("postTitle");
//			if (str == null || str.isBlank()) {
//				errorMsgs.add("請輸入欲搜尋的標題");
//			}
//			// Send the use back to the form, if there were errors
//			if (!errorMsgs.isEmpty()) {
//				RequestDispatcher failureView = req.getRequestDispatcher("/post/post.jsp");
//				failureView.forward(req, res);
//				return;// 程式中斷
//			}

//				Integer empno = null;
//				try {
//					empno = Integer.valueOf(str);
//				} catch (Exception e) {
//					errorMsgs.add("員工編號格式不正確");
//				}
//				// Send the use back to the form, if there were errors
//				if (!errorMsgs.isEmpty()) {
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/emp/select_page.jsp");
//					failureView.forward(req, res);
//					return;//程式中斷
//				}

//			/*************************** 2.開始查詢資料 *****************************************/
//			PostService postSvc = new PostServiceImpl();
//			List<Post> post = postSvc.getPostByPostTitle(str);
//			if (post == null) {
//				errorMsgs.add("查無資料");
//			}
//			// Send the use back to the form, if there were errors
//			if (!errorMsgs.isEmpty()) {
//				RequestDispatcher failureView = req.getRequestDispatcher("/post/post.jsp");
//				failureView.forward(req, res);
//				return;// 程式中斷
//			}
//
//			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
//			req.setAttribute("postlist", post); // 資料庫取出的empVO物件,存入req
//			String url = "/post/listPost.jsp";
//			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
//			successView.forward(req, res);
//			System.out.println(post);
//		}

//		if ("getOne_For_Update".equals(action)) { // 來自listAllPost.jsp的請求
//
//			List<String> errorMsgs = new LinkedList<String>();
//			// Store this set in the request scope, in case we need to
//			// send the ErrorPage view.
//			req.setAttribute("errorMsgs", errorMsgs);
//
//			/*************************** 1.接收請求參數 ****************************************/
//			Integer postID = Integer.valueOf(req.getParameter("postID"));
//
//			/*************************** 2.開始查詢資料 ****************************************/
//			PostService postSvc = new PostServiceImpl();
//		    Post post = postSvc.getByPostID(postID);
//
//			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
//			req.setAttribute("post", post); // 資料庫取出的empVO物件,存入req
//			String url = "/post/update_post_input.jsp";
//			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
//			successView.forward(req, res);
//		}
//
//		if ("update".equals(action)) { // 來自update_emp_input.jsp的請求
//
//			List<String> errorMsgs = new LinkedList<String>();
//			// Store this set in the request scope, in case we need to
//			// send the ErrorPage view.
//			req.setAttribute("errorMsgs", errorMsgs);
//
//			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
//			Integer postID = Integer.valueOf(req.getParameter("postID").trim());
//
//			String postTitle = req.getParameter("postTitle");
//			String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
//			if (postTitle == null || postTitle.trim().length() == 0) {
//				errorMsgs.add("標題: 請勿空白");
//			} else if (!postTitle.trim().matches(enameReg)) { // 以下練習正則(規)表示式(regular-expression)
//				errorMsgs.add("標題: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
//			}
//			String postContent = req.getParameter("postContent").trim();
//			if (postContent == null || postContent.trim().length() == 0) {
//				errorMsgs.add("內文請勿空白");
//			}
//			Integer postType = Integer.parseInt(req.getParameter("postType"));
//
//			Post post = new Post();
//			post.setPostTitle(postTitle);
//			post.setPostContent(postContent);
//			post.setPostType(postType);
//
//			// Send the use back to the form, if there were errors
//			if (!errorMsgs.isEmpty()) {
//				req.setAttribute("post", post); // 含有輸入格式錯誤的empVO物件,也存入req
//				RequestDispatcher failureView = req.getRequestDispatcher("/post/update_post_input.jsp");
//				failureView.forward(req, res);
//				return; // 程式中斷
//			}
//
//			/*************************** 2.開始修改資料 *****************************************/
//			PostService postSvc = new PostServiceImpl();
//			post = postSvc.updatePost(post);
//
//			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
//			req.setAttribute("post", post); // 資料庫update成功後,正確的的empVO物件,存入req
//			String url = "/post/listAllPost.jsp";
//			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
//			successView.forward(req, res);
//		}
//
//		if ("insert".equals(action)) { // 來自addEmp.jsp的請求
////			System.out.println("insertinsertinsert");
//			List<String> errorMsgs = new LinkedList<String>();
//			// Store this set in the request scope, in case we need to
//			// send the ErrorPage view.
//			req.setAttribute("errorMsgs", errorMsgs);
//
//			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
//			String postTitle = req.getParameter("postTitle");
////			System.out.println(postTitle);
////				String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
//			if (postTitle == null || postTitle.trim().length() == 0) {
//				errorMsgs.add("標題 請勿空白");
//			}
////				} else if(!ename.trim().matches(enameReg)) { //以下練習正則(規)表示式(regular-expression)
////					errorMsgs.add("員工姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
////	            }
//
//				String postContent = req.getParameter("postContent").trim();
//				if (postContent == null || postContent.trim().length() == 0) {
//					errorMsgs.add("內容請勿空白");
//				}
//				Integer postType = Integer.parseInt(req.getParameter("postType"));
//
//				Post post = new Post();
//				post.setPostTitle(postTitle);
//				post.setPostContent(postContent);
//				post.setPostType(postType);
//
//				// Send the use back to the form, if there were errors
//				if (!errorMsgs.isEmpty()) { // 進來if代表至少一個欄位錯誤
//					req.setAttribute("post", post); // 含有輸入格式錯誤的empVO物件,也存入req(若有輸入錯誤，保存輸入的資料) "empno"看addEmp第6行
//					RequestDispatcher failureView = req.getRequestDispatcher("/post/addPost.jsp");
//					failureView.forward(req, res);
//					return;
//				}
//
//				/*************************** 2.開始新增資料 ***************************************/
//				PostService postSvc = new PostServiceImpl();
////				post = postSvc.addPost(postTitle,postContent,postType);
//				post = postSvc.addPost(post);
//
//				/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
//				String url = "/post/listAllPost.jsp";
////				req.setAttribute("post", post);
//				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
//				successView.forward(req, res);
//			}

			if ("delete".equals(action)) { // 來自listAllEmp.jsp

				List<String> errorMsgs1 = new LinkedList<String>();
				// Store this set in the request scope, in case we need to
				// send the ErrorPage view.
				req.setAttribute("errorMsgs", errorMsgs1);

				/*************************** 1.接收請求參數 ***************************************/
				Integer postID = Integer.valueOf(req.getParameter("postID"));

				/*************************** 2.開始刪除資料 ***************************************/
				PostServiceBack postSvcB = new PostServiceBack();
				postSvcB.deletePostBack(postID);

				/*************************** 3.刪除完成,準備轉交(Send the Success view) ***********/
				String url = "/backstage/postBack/all_post.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
				successView.forward(req, res);
			}
	}
}
