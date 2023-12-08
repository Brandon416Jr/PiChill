package com.pichill.post.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Time;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pichill.manage.service.ManageService;
import com.pichill.post.entity.Post;
import com.pichill.post.service.PostService;
import com.pichill.post.service.PostServiceImpl;
import com.google.gson.Gson;
import com.google.protobuf.Timestamp;

@WebServlet("/post/post.do")
@MultipartConfig(fileSizeThreshold = 0 * 1024 * 1024, maxFileSize = 1 * 1024 * 1024, maxRequestSize = 10 * 1024 * 1024)
public class PostServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

//======所有文章與編輯前========
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application/json; charset=UTF-8");
		doPost(req, res);
		String action = req.getParameter("action");
		
		String postIDString = req.getParameter("postID");
		Integer postID = null;

		if (postIDString != null && !postIDString.isEmpty()) {
			// 嘗試將非空字符串轉換為整數
			postID = Integer.valueOf(postIDString);
		}
		if (postID != null) {

			PostService postSvc = new PostServiceImpl();
			Post post = postSvc.getByPostID(postID);

			String json = new Gson().toJson(post);

			PrintWriter out = res.getWriter();
			out.print(json);
			out.flush();
		} else {
			PostService postSvc = new PostServiceImpl();
			String page = req.getParameter("page");
			// 空值的話回傳1
			int currentPage = (page == null) ? 1 : Integer.parseInt(page);
			List<Post> posts = postSvc.getAllPosts(currentPage);

			if (req.getSession().getAttribute("postPageQty") == null) {
				int postPageQty = postSvc.getPageTotal();
				req.getSession().setAttribute("postPageQty", postPageQty);
			}

			req.setAttribute("posts", posts);
			req.setAttribute("currentPage", currentPage);
			String json = new Gson().toJson(posts);

			PrintWriter out = res.getWriter();
			out.print(json);
			out.flush();
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application/json; charset=UTF-8");
		String action = req.getParameter("action");
		if ("insert".equals(action)) {

			String postTitle = req.getParameter("postTitle");
			String postContent = req.getParameter("postContent");
			Integer postType = Integer.parseInt(req.getParameter("discussType"));
			InputStream in = req.getPart("postPic").getInputStream(); // 從javax.servlet.http.Part物件取得上傳檔案的InputStream
			byte[] postPic = null;
			if (in.available() != 0) {
				postPic = new byte[in.available()];
				in.read(postPic);
				in.close();
			}
			Post post = new Post();
			post.setPostTitle(postTitle);
			post.setPostContent(postContent);
			post.setPostType(postType);
			post.setPostPic(postPic);
			PostService postSvc = new PostServiceImpl();
			Post addedPost = postSvc.addPost(post);
			String json = new Gson().toJson(addedPost);
			PrintWriter out = res.getWriter();
			out.print(json);
			out.flush();
		}
		if ("insert_group".equals(action)) {

			String postTitle = req.getParameter("postTitle");
			String postContent = req.getParameter("postContent");
			Integer postType = Integer.parseInt(req.getParameter("groupType"));
			InputStream in = req.getPart("postPic").getInputStream(); // 從javax.servlet.http.Part物件取得上傳檔案的InputStream
			byte[] postPic = null;
			if (in.available() != 0) {
				postPic = new byte[in.available()];
				in.read(postPic);
				in.close();
			}
			Post post = new Post();
			post.setPostTitle(postTitle);
			post.setPostContent(postContent);
			post.setPostType(postType);
			post.setPostPic(postPic);
			PostService postSvc = new PostServiceImpl();
			Post addedPost = postSvc.addPost(post);
			String json = new Gson().toJson(addedPost);
			PrintWriter out = res.getWriter();
			out.print(json);
			out.flush();
		}
		if ("delete".equals(action)) {
			PostService postSvc = new PostServiceImpl();
			Integer postID = Integer.valueOf(req.getParameter("postID"));

			postSvc.deletePost(postID);

			String json = "{\"message\": \"Post deleted successfully\"}";
			PrintWriter out = res.getWriter();
			out.print(json);
			out.flush();
		}
		if ("get_By_Title".equals(action)) {
			String postTitle = req.getParameter("postTitle");
			PostService postSvc = new PostServiceImpl();
			List<Post> posts = postSvc.getPostByPostTitle(postTitle);

			// 將搜尋結果轉為 JSON 格式並發送到前端
			String json = new Gson().toJson(posts);
			PrintWriter out = res.getWriter();
			out.print(json);
			out.flush();
		}
		if ("getOne_For_Update".equals(action)) { // 來自listAllPost.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ****************************************/
			Integer postID = Integer.valueOf(req.getParameter("postID"));

			/*************************** 2.開始查詢資料 ****************************************/
			PostService postSvc = new PostServiceImpl();
		    Post post = postSvc.getByPostID(postID);

			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
			String json = new Gson().toJson(post);

			PrintWriter out = res.getWriter();
			out.print(json);
			out.flush();
		}
		
	if ("update".equals(action)) { // 來自update_emp_input.jsp的請求
		
					List<String> errorMsgs = new LinkedList<String>();
					// Store this set in the request scope, in case we need to
					// send the ErrorPage view.
					req.setAttribute("errorMsgs", errorMsgs);
		
					/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
					Integer postID = Integer.valueOf(req.getParameter("postID").trim());
					System.out.println(postID);
					String postTitle = req.getParameter("postTitle");
					String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{1,10}$";
					if (postTitle == null || postTitle.trim().length() == 0) {
						errorMsgs.add("標題: 請勿空白");
					} else if (!postTitle.trim().matches(enameReg)) { // 以下練習正則(規)表示式(regular-expression)
						errorMsgs.add("標題: 只能是中、英文字母、數字和_ , 且長度必需在10個字以內");
					}
					String postContent = req.getParameter("postContent").trim();
					if (postContent == null || postContent.trim().length() == 0) {
						errorMsgs.add("內文請勿空白");
					}	
					System.out.println(postTitle);
					System.out.println(postContent);
					Post post = new Post();
					post.setPostID(postID);
					post.setPostTitle(postTitle);
					post.setPostContent(postContent);
					PostService postSvc = new PostServiceImpl();
					Post updatededPost = postSvc.updatePost(post);
					String json = new Gson().toJson(updatededPost);
					PrintWriter out = res.getWriter();
					out.print(json);
					out.flush();
				}
	}
}
