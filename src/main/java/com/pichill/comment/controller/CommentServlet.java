package com.pichill.comment.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.pichill.comment.entity.Comment;
import com.pichill.comment.service.CommentService;
import com.pichill.comment.service.CommentServiceImpl;
import com.pichill.generaluser.entity.GeneralUser;
import com.pichill.generaluser.service.GeneralUserService;
import com.pichill.post.entity.Post;
import com.pichill.post.service.PostService;
import com.pichill.post.service.PostServiceImpl;

@WebServlet("/comment/comment.do")
public class CommentServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
		res.setContentType("application/json; charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		if ("list_All".equals(action)) {
			Integer postID = Integer.valueOf(req.getParameter("postID"));
			CommentService commentSvc = new CommentServiceImpl();
			List<Comment> comments = commentSvc.getAllComments(postID);
			List<GeneralUser> gUsers = new ArrayList();
			for (Comment comment : comments) {
				gUsers.add(comment.getGeneralUser());
			}
			  Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
				List<Object> combinedList = new ArrayList<>();
				for (Comment comment : comments) {
					Map<String, Object> postData = new HashMap<>();
					postData.put("comment", comment);
					postData.put("generalUser", comment.getGeneralUser());
					combinedList.add(postData);
				}  
			  String json = gson.toJson( combinedList);
			PrintWriter out = res.getWriter();
			out.print(json);
			out.flush();

		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application/json; charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
//		if("list_All".equals(action)) {
//			CommentService commentSvc = new CommentServiceImpl();
//			 List<Comment> comments = commentSvc.getAllComments();
//			String json = new Gson().toJson(comments);
//			PrintWriter out = res.getWriter();
//			out.print(json);
//			out.flush();
//		}
		if ("insert".equals(action)) {
			String commentContent = req.getParameter("commentContent");
			Integer gUserID = Integer.valueOf(req.getParameter("gUserID"));
			Integer postID = Integer.valueOf(req.getParameter("postID"));
			GeneralUserService generalUserService = new GeneralUserService();
			GeneralUser generalUser = generalUserService.getOneGeneralUser(gUserID);
			Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
			String jsonGeneralUser = gson.toJson(generalUser);
			PostService postSVC = new PostServiceImpl();
			Post post = postSVC.getByPostID(postID);
			Comment comment = new Comment();
			comment.setCommentContent(commentContent);
			comment.setGeneralUser(generalUser);
			comment.setPost(post);
			CommentService commentSvc = new CommentServiceImpl();
			Comment addedComment = commentSvc.addComment(comment);
			long commentCnt = commentSvc.getCommentCnt(postID);
			String jsonResponse = "{\"generalUser\":" + jsonGeneralUser +",\"addedComment\":" + gson.toJson(addedComment) + ",\"commentCnt\":" + commentCnt + "}";
			PrintWriter out = res.getWriter();
			System.out.println("sss"+jsonGeneralUser);
			out.print(jsonResponse);
//			out.print(commentCntJson);
			System.out.println(jsonResponse);
			out.flush();
			
			Integer CommentAmount = comment.getGeneralUser().getCommentAmount();
			CommentAmount += 1;
			generalUser.setCommentAmount(CommentAmount);
			generalUser = generalUserService.updateByCommentAmount(11000001, CommentAmount);
		}
		if ("delete".equals(action)) {
//			System.out.println("=================");
//			System.out.println("Action is 'delete'");
			Integer postID = Integer.valueOf(req.getParameter("postID"));
			Integer commentID = Integer.valueOf(req.getParameter("commentID"));
//			System.out.println("commentID=" + commentID);
			CommentService commentSvc = new CommentServiceImpl();
			commentSvc.delete(commentID);
			long commentCnt = commentSvc.getCommentCnt(postID);
			JsonObject jsonResponse = new JsonObject();
			jsonResponse.addProperty("commentCnt", commentCnt);
			PrintWriter out = res.getWriter();
			out.print(jsonResponse);
			out.flush();
//			String json = "{\"message\": \"Comment deleted successfully\"}";
//			PrintWriter out = res.getWriter();
//			out.print(json);
//			out.flush();
		}
		if ("getOne_For_update".equals(action)) {
			Integer commentID = Integer.valueOf(req.getParameter("commentID"));
			CommentService commentSvc = new CommentServiceImpl();
			Comment comment = commentSvc.getByCommentID(commentID);
			String json = new Gson().toJson(comment);

			PrintWriter out = res.getWriter();
			out.print(json);
			out.flush();
		}
		if ("update".equals(action)) {
			Integer commentID = Integer.valueOf(req.getParameter("commentID"));
			String commentContent = req.getParameter("commentContent");
			Comment comment = new Comment();
			comment.setCommentID(commentID);
			comment.setCommentContent(commentContent);
			CommentService commentSvc = new CommentServiceImpl();
			Comment updatedComment = commentSvc.updateComment(comment);
			String json = new Gson().toJson(updatedComment);
			PrintWriter out = res.getWriter();
			out.print(json);
			out.flush();
		}
	}
}
