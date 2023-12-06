package com.pichill.post.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pichill.post.entity.Post;
import com.pichill.post.service.PostService;
import com.pichill.post.service.PostServiceImpl;
import com.google.gson.Gson;
import com.google.protobuf.Timestamp;

@WebServlet("/post/post.do")
public class PostServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

//======所有文章與編輯前========
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application/json; charset=UTF-8");
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
			List<Post> posts = postSvc.getAllPosts();

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
//        java.sql.Timestamp postTime=java.sql.Timestamp.valueOf(req.getParameter("postTime"));
//System.out.println(postTitle);
//System.out.println(postContent);
			Post post = new Post();
			post.setPostTitle(postTitle);
			post.setPostContent(postContent);
			post.setPostType(postType);
//        post.setPostTime(postTime);

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

//			String json = "{\"message\": \"Post deleted successfully\"}";
//			PrintWriter out = res.getWriter();
//			out.print(json);
//			out.flush();
		}
		if("get_By_Title".equals(action)) {
			String postTitle = req.getParameter("postTitle");
			PostService postSvc = new PostServiceImpl();
			List<Post> posts = postSvc.getPostByPostTitle(postTitle);

			// 將搜尋結果轉為 JSON 格式並發送到前端
			String json = new Gson().toJson(posts);
			PrintWriter out = res.getWriter();
			out.print(json);
			out.flush();
		}
		}
	}

	// =======標題搜尋===========
	private void getByTitle(HttpServletRequest req, HttpServletResponse res, String postTitle) throws IOException {

//======新增========
	protected void addPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

	}

//=========修改=========
	protected void doPut(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application/json; charset=UTF-8");

		String postID = req.getParameter("postID");
		String postTitle = req.getParameter("postTitle");
		String postContent = req.getParameter("postContent");

		Post post = new Post();
		post.setPostTitle(postTitle);
		post.setPostContent(postContent);

		Post updatedPost = new Post();
		// 設定更新後的文章內容等屬性

		PostService postSvc = new PostServiceImpl();
		postSvc.updatePost(updatedPost);

		String json = "{\"message\": \"Post updated successfully\"}";
		PrintWriter out = res.getWriter();
		out.print(json);
		out.flush();
	}

//=======刪除======
	protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		res.setContentType("application/json; charset=UTF-8");

	}
}
