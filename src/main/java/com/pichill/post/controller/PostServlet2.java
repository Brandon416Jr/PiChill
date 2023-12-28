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
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
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
		doPost(req, res);
		if ("getOne_For_Update".equals(action)) {

			Integer postID = Integer.valueOf(req.getParameter("postID"));
//			System.out.println(postID);
			PostService postSvc = new PostServiceImpl();
			Post post = postSvc.getByPostID(postID);
			ReserveOrder ro = post.getReserveOrder();
			String courtName = ro.getCourt().getCourtName();
			Integer ball = ro.getPlace().getBall();
			Integer fee = ro.getPlace().getPlaceFee();
			String time = ro.getTimeRef().getReserveTime();
			Date reserveDate = ro.getReserveDate();

			JsonObject jsonResult = new JsonObject();
			jsonResult.addProperty("courtName", courtName);
			jsonResult.addProperty("fee", fee);
			jsonResult.addProperty("ball", ball);
			jsonResult.addProperty("time", time);
			jsonResult.addProperty("reserveDate", reserveDate.toString()); // Convert Date to String

			// Include the post object using Gson with @Expose annotation
			Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
			JsonElement postJsonElement = gson.toJsonTree(post);
			jsonResult.add("post", postJsonElement);

			// Send the JSON response to the client directly
			PrintWriter out = res.getWriter();
			gson.toJson(jsonResult, out);
			out.flush();
		} else {

			PostService postSvc = new PostServiceImpl();
			List<Post> posts = postSvc.getAll();
			List<GeneralUser> gUsers = new ArrayList();
			List<OwnerUser> oUsers = new ArrayList();
			List<ReserveOrder> ro = new ArrayList();
			for (Post post : posts) {
				gUsers.add(post.getGeneralUser());
				oUsers.add(post.getOwnerUser());
				ro.add(post.getReserveOrder());
			}

			Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
			List<Object> combinedList = new ArrayList<>();
			for (Post post : posts) {
				Map<String, Object> postData = new HashMap<>();
				postData.put("post", post);
				postData.put("generalUser", post.getGeneralUser());
				postData.put("ownerUser", post.getOwnerUser());
				ReserveOrder reserveOrder = post.getReserveOrder();
				if (reserveOrder != null) {
					postData.put("courtName", reserveOrder.getCourt().getCourtName());
					postData.put("ball", reserveOrder.getPlace().getBall());
					postData.put("placeFee", reserveOrder.getPlace().getPlaceFee());
					postData.put("reserveTime", reserveOrder.getTimeRef().getReserveTime());
					postData.put("reserveDate", reserveOrder.getReserveDate());
				}

				combinedList.add(postData);
			}
			String json = gson.toJson(combinedList);
			PrintWriter out = res.getWriter();
			out.print(json);
//			System.out.println(json);
			out.flush();
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application/json; charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		// ======放session值(guser)======
		if ("getUser".equals(action)) {
			HttpSession session = req.getSession();
			GeneralUser generalUser2 = (GeneralUser) session.getAttribute("generalUser");
			Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
			String json = gson.toJson(generalUser2);
			PrintWriter out = res.getWriter();
			out.print(json);
			out.flush();
		}
		// ======放session值(ouser)======
		if ("getoUser".equals(action)) {
			HttpSession session = req.getSession();
			OwnerUser ownerUser2 = (OwnerUser) session.getAttribute("OwnerUser");
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
			Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
			String jsonGeneralUser = gson.toJson(generalUser);
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

			String jsonAddedPost = gson.toJson(addedPost);
//			System.out.println("JJJJ" +jsonGeneralUser+"GGGG"+ jsonAddedPost);
			PrintWriter out = res.getWriter();
			out.print("{\"generalUser\":" + jsonGeneralUser + ",\"addedPost\":" + jsonAddedPost + "}");
			out.flush();

			Integer gPostAmount = post.getGeneralUser().getgPostAmount();
			gPostAmount += 1;
			generalUser.setgPostAmount(gPostAmount);
			generalUser = gUserSVC.updateByPostAmount(gUserID, gPostAmount);
		}
		// ====得到預約編號bygUser=========
		if ("get_order".equals(action)) {
			Integer gUserID = Integer.valueOf(req.getParameter("gUserID"));
			ReserveOrderService reserveOrderSVC = new ReserveOrderService();
//			Hibernate.initialize(court.getReserveOrder());
			List<ReserveOrder> reserveOrderList = reserveOrderSVC.getgUserID(gUserID);
//			System.out.println("RRRRRRR" + reserveOrderList);
			List<Map<String, Object>> resultList = new ArrayList<>();

			for (ReserveOrder reserveOrder : reserveOrderList) {
				Integer reserveOrderID = reserveOrder.getReserveOrderID();
				String courtName = reserveOrder.getCourt().getCourtName();
				Integer ball = reserveOrder.getPlace().getBall();
				Integer fee = reserveOrder.getPlace().getPlaceFee();
				String time = reserveOrder.getTimeRef().getReserveTime();
				Date reserveDate = reserveOrder.getReserveDate();
//				System.out.println("場地名稱: " + courtName);

				Map<String, Object> orderMap = new HashMap<>();
				orderMap.put("reserveOrderID", reserveOrderID);
				orderMap.put("courtName", courtName);
				orderMap.put("ball", ball);
				orderMap.put("fee", fee);
				orderMap.put("time", time);
				orderMap.put("reserveDate", reserveDate);

				resultList.add(orderMap);
			}
			Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setDateFormat("yyyy-MM-dd EEE")
					.create();
			String json = gson.toJson(resultList);
			PrintWriter out = res.getWriter();
			out.print(json);
			System.out.println("json===" + json);
			out.flush();
		}
		if ("insert_group".equals(action)) {
			Integer reserveOrderID = Integer.valueOf(req.getParameter("reserveOrderID"));
			ReserveOrderService roSVC = new ReserveOrderService();
			ReserveOrder ro = roSVC.getOneReserveOrder(reserveOrderID);
			 JsonObject roJson = new JsonObject();
			    roJson.addProperty("courtName", ro.getCourt().getCourtName());
			    roJson.addProperty("ball", ro.getPlace().getBall());
			    roJson.addProperty("fee", ro.getPlace().getPlaceFee());
			    roJson.addProperty("time", ro.getTimeRef().getReserveTime());
			    roJson.addProperty("reserveDate", ro.getReserveDate().toString());

			    // 将 "roJson" JSON 对象转换为字符串
			    Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
			    String jsonRo = gson.toJson(roJson);
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
			String jsonGeneralUser = gson.toJson(generalUser);
			Post post = new Post();
			post.setGeneralUser(generalUser);
			post.setReserveOrder(ro);
			post.setPostTitle(postTitle);
			post.setPostContent(postContent);
			post.setPostType(postType);
			post.setPostPic(postPic);
			post.setLikeCnt(likeCnt);
			post.setCommentCnt(commentCnt);
			PostService postSvc = new PostServiceImpl();
			Post addedPost = postSvc.addPost(post);

			String jsonAddedPost = gson.toJson(addedPost);
//			System.out.println("JJJJ" +jsonGeneralUser+"GGGG"+ jsonAddedPost);
			PrintWriter out = res.getWriter();
			out.print("{\"generalUser\":" + jsonGeneralUser + ",\"ro\":" + jsonRo + ",\"addedPost\":" + jsonAddedPost
					+ "}");
			out.flush();
//System.out.println("jjjjj"+jsonRo);
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
			Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
			String jsonOwnerUser = gson.toJson(ownerUser);
			Post post = new Post();
			post.setOwnerUser(ownerUser);
			post.setPostTitle(postTitle);
			post.setPostContent(postContent);
			post.setPostType(postType);
			PostService postSvc = new PostServiceImpl();
			Post addedPost = postSvc.addPost(post);
			String jsonAddedPost = gson.toJson(addedPost);
//			System.out.println("JJJJ" +jsonOwnerUser+"GGGG"+ jsonAddedPost);
			PrintWriter out = res.getWriter();
			out.print("{\"generalUser\":" + jsonOwnerUser + ",\"addedPost\":" + jsonAddedPost + "}");
			out.flush();

			Integer oPostAmount = post.getOwnerUser().getoPostAmount();
			oPostAmount += 1;
			ownerUser.setoPostAmount(oPostAmount);
			ownerUser = oUserSVC.updateByoPostAmount(oUserID, oPostAmount);
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
			List<GeneralUser> gUsers = new ArrayList();
			// 將搜尋結果轉為 JSON 格式並發送到前端
			for (Post post : posts) {
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
//			System.out.println(json);
			out.flush();
		}
		if ("get_By_gUserID".equals(action)) {
			Integer gUserID = Integer.valueOf(req.getParameter("gUserID"));
			PostService postSvc = new PostServiceImpl();
			List<Post> posts = postSvc.getBygUserID(gUserID);
			HttpSession session = req.getSession();
			GeneralUser gUser = (GeneralUser) session.getAttribute("generalUser");
			Map<String, Object> responseData = new HashMap<>();
			responseData.put("gUser", gUser);
			responseData.put("posts", posts);
			Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
			String json = gson.toJson(responseData);

			PrintWriter out = res.getWriter();
//			    System.out.println("KKK"+json);
			out.print(json);
			out.flush();
		}
		if ("get_By_postID".equals(action)) {
			Integer postID = Integer.valueOf(req.getParameter("postID"));
			PostService postSvc = new PostServiceImpl();
			Post post = postSvc.getByPostID(postID);
			
			ReserveOrder ro = post.getReserveOrder();
			// 將搜尋結果轉為 JSON 格式並發送到前端
			JsonObject roJson = new JsonObject();
		    roJson.addProperty("courtName", ro.getCourt().getCourtName());
		    roJson.addProperty("ball", ro.getPlace().getBall());
		    roJson.addProperty("fee", ro.getPlace().getPlaceFee());
		    roJson.addProperty("time", ro.getTimeRef().getReserveTime());
		    roJson.addProperty("reserveDate", ro.getReserveDate().toString());
		    
			GeneralUser generalUser = post.getGeneralUser();
			Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
			String jsonGeneralUser = gson.toJson(generalUser);
			String jsonAddedPost = gson.toJson(post);
			String jsonRo = gson.toJson(roJson);
			PrintWriter out = res.getWriter();
//			System.out.println("json = " + json);
			JsonObject outputJson = new JsonObject();
		    outputJson.add("generalUser", new JsonParser().parse(jsonGeneralUser));
		    outputJson.add("addedPost", new JsonParser().parse(jsonAddedPost));
		    outputJson.add("reserveOrder", new JsonParser().parse(jsonRo));
		    
		    out.print(outputJson.toString());
		    out.flush();
		}

		if ("get_By_Type".equals(action)) {
			Integer postType = Integer.valueOf(req.getParameter("postType"));
			PostService postSvc = new PostServiceImpl();
			List<Post> posts = postSvc.getPostByPostType(postType);
			List<GeneralUser> gUsers = new ArrayList();
			// 將搜尋結果轉為 JSON 格式並發送到前端
			for (Post post : posts) {
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
//			System.out.println(json);
			out.flush();
		}
		if ("get_By_Comment".equals(action)) {

			PostService postSvc = new PostServiceImpl();
			List<Post> posts = postSvc.getByCommentCnt();

			List<GeneralUser> gUsers = new ArrayList();
			// 將搜尋結果轉為 JSON 格式並發送到前端
			for (Post post : posts) {
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
			System.out.println("JJJJ" + json);
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
