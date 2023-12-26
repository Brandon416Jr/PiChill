package com.pichill.post.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pichill.generaluser.entity.GeneralUser;
import com.pichill.generaluser.service.GeneralUserService;
import com.pichill.owneruser.entity.OwnerUser;
import com.pichill.owneruser.service.OwnerUserService;
import com.pichill.post.entity.Post;
import com.pichill.post.service.PostService;
import com.pichill.post.service.PostServiceImpl;
import com.pichill.reserveorder.entity.ReserveOrder;
import com.pichill.reserveorder.service.ReserveOrderService;

@WebServlet("/post/post.do")
@MultipartConfig(fileSizeThreshold = 0 * 1024 * 1024, maxFileSize = 1 * 1024 * 1024, maxRequestSize = 10 * 1024 * 1024)
public class PostServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

//======所有文章與編輯前========
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application/json; charset=UTF-8");
		String action = req.getParameter("action");
		if ("getOne_For_Update".equals(action)) {

			Integer postID = Integer.valueOf(req.getParameter("postID"));
			System.out.println(postID);

			PostService postSvc = new PostServiceImpl();
			Post post = postSvc.getByPostID(postID);
			Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
			String json = gson.toJson(post);
			PrintWriter out = res.getWriter();
			out.print(json);
			out.flush();
		} else {

			PostService postSvc = new PostServiceImpl();
			List<Post> posts = postSvc.getAll();
			GeneralUserService generalSvc = new GeneralUserService();
			List<GeneralUser>gUsers = new ArrayList();
			for (Post post:posts) {
				gUsers.add(post.getGeneralUser());
			}
			
			Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
			List<Object> combinedList = new ArrayList<>();
			for (Post post : posts) {
			    Map<String, Object> postData = new HashMap<>();
			    postData.put("post", post);
			    postData.put("generalUser", post.getGeneralUser());
			    combinedList.add(postData);
			}
			String json = gson.toJson(combinedList);
			PrintWriter out = res.getWriter();
			out.print(json);
			System.out.println(json);
			out.flush();
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application/json; charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		//======放session值(guser)======
		if("getUser".equals(action)){
		HttpSession session = req.getSession();
		GeneralUser generalUser2 = (GeneralUser)session.getAttribute("generalUser");
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String json = gson.toJson(generalUser2);
		PrintWriter out = res.getWriter();
		out.print(json);
		out.flush();
		}
		//======放session值(ouser)======
				if("getoUser".equals(action)){
				HttpSession session = req.getSession();
				OwnerUser ownerUser2 = (OwnerUser)session.getAttribute("OwnerUser");
//				System.out.println("GGGGGGG=="+generalUs2);
				Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
				String json = gson.toJson(ownerUser2);
				PrintWriter out = res.getWriter();
				out.print(json);
				out.flush();
				}
		// ====新增討論文章========
		if ("insert".equals(action)) {
			Integer gUserID = Integer.valueOf(req.getParameter("gUserID"));
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
			GeneralUserService gUserSVC = new GeneralUserService();
			GeneralUser generalUser = gUserSVC.getOneGeneralUser(gUserID);
			Post post = new Post();
			post.setGeneralUser(generalUser);
			post.setPostTitle(postTitle);
			post.setPostContent(postContent);
			post.setPostType(postType);
			post.setPostPic(postPic);
			post.setLikeCnt(likeCnt);
			post.setCommentCnt(commentCnt);
			PostService postSvc = new PostServiceImpl();
			Post addedPost = postSvc.addPost(post);
			Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
			String json = gson.toJson(addedPost);

			PrintWriter out = res.getWriter();
			out.print(json);
			out.flush();
			
			Integer gPostAmount = post.getGeneralUser().getgPostAmount();
			gPostAmount += 1;
			generalUser.setgPostAmount(gPostAmount);
			generalUser = gUserSVC.updateByPostAmount(gUserID, gPostAmount);
		}
		// ====得到預約編號bygUser=========
		if ("get_order".equals(action)) {
			ReserveOrderService reserveOrderSVC = new ReserveOrderService();
//			Hibernate.initialize(court.getReserveOrder());
			List<ReserveOrder> reserveOrderList = reserveOrderSVC.getgUserID(11000001);
			System.out.println("RRRRRRR" + reserveOrderList);
		    List<Map<String, Object>> resultList = new ArrayList<>();

			for (ReserveOrder reserveOrder : reserveOrderList) {
				String courtName = reserveOrder.getCourt().getCourtName();
				Integer ball = reserveOrder.getPlace().getBall();
				Integer fee = reserveOrder.getPlace().getPlaceFee();
				String time = reserveOrder.getTimeRef().getReserveTime();
				 Date reserveDate = reserveOrder.getReserveDate();
				System.out.println("場地名稱: " + courtName);
				
				 Map<String, Object> orderMap = new HashMap<>();
			        orderMap.put("courtName", courtName);
			        orderMap.put("ball", ball);
			        orderMap.put("fee", fee);
			        orderMap.put("time",time);
			        orderMap.put("reserveDate", reserveDate);

			        resultList.add(orderMap);
			}
			Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
			String json = gson.toJson(resultList);
			PrintWriter out = res.getWriter();
			out.print(json);
			System.out.println("json===" + json);
			out.flush();
		}
		if ("insert_group".equals(action)) {
			Integer gUserID = Integer.valueOf(req.getParameter("gUserID"));
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
			GeneralUserService gUserSVC = new GeneralUserService();
			GeneralUser generalUser = gUserSVC.getOneGeneralUser(gUserID);
			Post post = new Post();
			post.setGeneralUser(generalUser);
			post.setPostTitle(postTitle);
			post.setPostContent(postContent);
			post.setPostType(postType);
			post.setPostPic(postPic);
			post.setLikeCnt(likeCnt);
			post.setCommentCnt(commentCnt);
			PostService postSvc = new PostServiceImpl();
			Post addedPost = postSvc.addPost(post);

			Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
			String json = gson.toJson(addedPost);

			PrintWriter out = res.getWriter();
			out.print(json);
			out.flush();
			
			Integer gPostAmount = post.getGeneralUser().getgPostAmount();
			gPostAmount += 1;
			generalUser.setgPostAmount(gPostAmount);
			generalUser = gUserSVC.updateByPostAmount(gUserID, gPostAmount);
		}
		if ("insert_promote".equals(action)) {
			Integer oUserID = Integer.valueOf(req.getParameter("oUserID"));
			String postTitle = req.getParameter("postTitle");
			String postContent = req.getParameter("postContent");
			Integer postType = 2;
			OwnerUserService oUserSVC = new OwnerUserService();
			OwnerUser ownerUser = oUserSVC.getOneOwnerUser(oUserID);

			Post post = new Post();
			post.setOwnerUser(ownerUser);
			post.setPostTitle(postTitle);
			post.setPostContent(postContent);
			post.setPostType(postType);
			PostService postSvc = new PostServiceImpl();
			Post addedPost = postSvc.addPost(post);
			Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
			String json = gson.toJson(addedPost);

			PrintWriter out = res.getWriter();
			out.print(json);
			out.flush();
			
			Integer oPostAmount = post.getOwnerUser().getoPostAmount();
			oPostAmount += 1;
			ownerUser.setoPostAmount(oPostAmount);
			ownerUser = oUserSVC.updateByoPostAmount(12000001, oPostAmount);
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
			Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
			String json = gson.toJson(posts);
			PrintWriter out = res.getWriter();
			out.print(json);
			out.flush();
		}
		if ("get_By_gUserID".equals(action)) {
			Integer gUserID = Integer.valueOf(req.getParameter("gUserID"));
			PostService postSvc = new PostServiceImpl();
			List<Post> posts = postSvc.getBygUserID(gUserID);

			// 將搜尋結果轉為 JSON 格式並發送到前端
			Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
			String json = gson.toJson(posts);
			PrintWriter out = res.getWriter();
			out.print(json);
			out.flush();
		}
		if ("get_By_postID".equals(action)) {
			Integer postID = Integer.valueOf(req.getParameter("postID"));
			PostService postSvc = new PostServiceImpl();
			Post post = postSvc.getByPostID(postID);
			// 將搜尋結果轉為 JSON 格式並發送到前端
			Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
			String json = gson.toJson(post);
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
			Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
			String json = gson.toJson(posts);
			PrintWriter out = res.getWriter();
			out.print(json);
			out.flush();
		}
		if ("get_By_Comment".equals(action)) {

			PostService postSvc = new PostServiceImpl();
			List<Post> posts = postSvc.getByCommentCnt();

			// 將搜尋結果轉為 JSON 格式並發送到前端
			Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
			String json = gson.toJson(posts);
			PrintWriter out = res.getWriter();
			out.print(json);
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
