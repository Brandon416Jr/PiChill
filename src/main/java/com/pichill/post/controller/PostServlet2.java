package com.pichill.post.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.google.gson.Gson;
import com.pichill.post.entity.Post;
import com.pichill.post.service.PostService;
import com.pichill.post.service.PostServiceImpl;

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
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		//======顯示推撥========
		if("get_Type2".equals(action)) {
		PostService postSvc = new PostServiceImpl();
		List<Post> typeTwoPosts = postSvc.getTypeTwo();

		Gson gson = new Gson();
		String jsonResult = gson.toJson(typeTwoPosts);
		PrintWriter out = res.getWriter();
		out.print(jsonResult);
		System.out.println("Json===="+jsonResult);
		out.flush();
		}
		//====新增討論文章========
		if ("insert".equals(action)) {
			String postTitle = req.getParameter("postTitle");
			String postContent = req.getParameter("postContent");
			Integer postType = Integer.parseInt(req.getParameter("discussType"));
			Part part = req.getPart("postPic");
			byte[] postPic = null;
			if (part != null && part.getSize() > 0) {
				try (InputStream in = part.getInputStream()) {
					ByteArrayOutputStream buffer = new ByteArrayOutputStream();
					int nRead;
					byte[] data = new byte[1024];

					while ((nRead = in.read(data, 0, data.length)) != -1) {
						buffer.write(data, 0, nRead);
					}

					postPic = buffer.toByteArray();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			Integer likeCnt = 0;
			Integer commentCnt = 0;
			Post post = new Post();
			post.setPostTitle(postTitle);
			post.setPostContent(postContent);
			post.setPostType(postType);
			post.setPostPic(postPic);
			post.setLikeCnt(likeCnt);
			post.setCommentCnt(commentCnt);
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
			Part part = req.getPart("postPic");
			byte[] postPic = null;
			if (part != null && part.getSize() > 0) {
				try (InputStream in = part.getInputStream()) {
					ByteArrayOutputStream buffer = new ByteArrayOutputStream();
					int nRead;
					byte[] data = new byte[1024];

					while ((nRead = in.read(data, 0, data.length)) != -1) {
						buffer.write(data, 0, nRead);
					}

					postPic = buffer.toByteArray();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			Integer likeCnt = 0;
			Integer commentCnt = 0;
			Post post = new Post();
			post.setPostTitle(postTitle);
			post.setPostContent(postContent);
			post.setPostType(postType);
			post.setPostPic(postPic);
			post.setLikeCnt(likeCnt);
			post.setCommentCnt(commentCnt);
			PostService postSvc = new PostServiceImpl();
			Post addedPost = postSvc.addPost(post);
			String json = new Gson().toJson(addedPost);
			PrintWriter out = res.getWriter();
			out.print(json);
			out.flush();
		}
		if ("insert_promote".equals(action)) {

			String postTitle = req.getParameter("postTitle");
			String postContent = req.getParameter("postContent");
			Integer postType = 2;
			Post post = new Post();
			post.setPostTitle(postTitle);
			post.setPostContent(postContent);
			post.setPostType(postType);
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
		if ("get_By_gUserID".equals(action)) {
			Integer gUserID = Integer.valueOf(req.getParameter("gUserID"));
			PostService postSvc = new PostServiceImpl();
			List<Post> posts = postSvc.getBygUserID(11000001);

			// 將搜尋結果轉為 JSON 格式並發送到前端
			String json = new Gson().toJson(posts);
			PrintWriter out = res.getWriter();
			out.print(json);
			out.flush();
		}
		if ("get_By_postID".equals(action)) {
			Integer postID = Integer.valueOf(req.getParameter("postID"));
			PostService postSvc = new PostServiceImpl();
			Post post = postSvc.getByPostID(postID);
			// 將搜尋結果轉為 JSON 格式並發送到前端
			String json = new Gson().toJson(post);
			PrintWriter out = res.getWriter();
//			System.out.println("json = " + json);
			out.print(json);
			out.flush();
		}

		if ("get_By_Type".equals(action)) {
			Integer postType = Integer.valueOf(req.getParameter("postType"));
			PostService postSvc = new PostServiceImpl();
			List<Post> posts = postSvc.getPostByPostType(postType);

			// 將搜尋結果轉為 JSON 格式並發送到前端
			String json = new Gson().toJson(posts);
			PrintWriter out = res.getWriter();
			out.print(json);
			out.flush();
		}
		if ("get_By_Comment".equals(action)) {

			PostService postSvc = new PostServiceImpl();
			List<Post> posts = postSvc.getByCommentCnt();

			// 將搜尋結果轉為 JSON 格式並發送到前端
			String json = new Gson().toJson(posts);
			PrintWriter out = res.getWriter();
			out.print(json);
			out.flush();
		}

		if ("getOne_For_Update".equals(action)) { // 來自listAllPost.jsp的請求

			/*************************** 1.接收請求參數 ****************************************/
			Integer postID = Integer.valueOf(req.getParameter("postID"));

			/*************************** 2.開始查詢資料 ****************************************/
			PostService postSvc = new PostServiceImpl();
			Post post = postSvc.getByPostID(postID);

			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
			String json = new Gson().toJson(post);
			PrintWriter out = res.getWriter();
			out.print(json);
			System.out.println("post======" + json);
			out.flush();
		}

		if ("update".equals(action)) { // 來自update_emp_input.jsp的請求
			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			Integer postID = Integer.valueOf(req.getParameter("postID").trim());
			String postTitle = req.getParameter("postTitle");
			String postContent = req.getParameter("postContent").trim();
			Part part = req.getPart("postPic");
			byte[] postPic = null;
			if (part != null && part.getSize() > 0) {
				try (InputStream in = part.getInputStream()) {
					ByteArrayOutputStream buffer = new ByteArrayOutputStream();
					int nRead;
					byte[] data = new byte[1024];

					while ((nRead = in.read(data, 0, data.length)) != -1) {
						buffer.write(data, 0, nRead);
					}

					postPic = buffer.toByteArray();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			Post post = new Post();
			post.setPostID(postID);
			post.setPostTitle(postTitle);
			post.setPostContent(postContent);
			post.setPostPic(postPic);
			PostService postSvc = new PostServiceImpl();
			Post updatedPost = postSvc.updatePost(post);
			String json = new Gson().toJson(updatedPost);
			PrintWriter out = res.getWriter();
			out.print(json);
			out.flush();
		}
		if ("update_promote".equals(action)) { // 來自update_emp_input.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			Integer postID = Integer.valueOf(req.getParameter("postID").trim());
			String postTitle = req.getParameter("postTitle");
			String postContent = req.getParameter("postContent").trim();
			Post post = new Post();
			post.setPostID(postID);
			post.setPostTitle(postTitle);
			post.setPostContent(postContent);
			PostService postSvc = new PostServiceImpl();
			Post updatedPost = postSvc.updatePost(post);
			String json = new Gson().toJson(updatedPost);
			PrintWriter out = res.getWriter();
			out.print(json);
			out.flush();
		}
		if ("update_likeCnt".equals(action)) {
			Integer postID = Integer.valueOf(req.getParameter("postID").trim());
			Integer likeCnt = Integer.valueOf(req.getParameter("likeCnt").trim());
			Post post = new Post();
			post.setPostID(postID);
			post.setLikeCnt(likeCnt);
			PostService postSvc = new PostServiceImpl();
			int updatedLike = postSvc.updateLike(postID, likeCnt);
			System.out.println("=========++++++++" + updatedLike);
			String json = new Gson().toJson(updatedLike);
			PrintWriter out = res.getWriter();
			out.print(json);
			out.flush();
		}
		if ("update_commentCnt".equals(action)) {
			Integer postID = Integer.valueOf(req.getParameter("postID").trim());
			Integer commentCnt = Integer.valueOf(req.getParameter("commentCnt").trim());
			Post post = new Post();
			post.setPostID(postID);
			post.setCommentCnt(commentCnt);
			PostService postSvc = new PostServiceImpl();
			int updatedComment = postSvc.updateComment(postID, commentCnt);
//		System.out.println("=========++++++++"+updatedComment);
			String json = new Gson().toJson(updatedComment);
			PrintWriter out = res.getWriter();
			out.print(json);
			out.flush();
		}
	}
}
