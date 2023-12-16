package com.pichill.forumlike.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.pichill.forumlike.service.ForumLikeService;
import com.pichill.forumlike.service.ForumLikeServiceImpl;

@WebServlet("/forumlike/forumlike.do")
public class ForumLikeServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application/json; charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
//		System.out.println(action);
		if ("likepost".equals(action)) {
			Integer postID = Integer.valueOf(req.getParameter("postID"));
//			System.out.println(postID);
			ForumLikeService likeSvc = new ForumLikeServiceImpl();
			Integer status = likeSvc.getLikeByPostIDAndUserID(postID, 11000001);
			Map<String, Integer> data = new HashMap<>();
			data.put("status", status);
			Gson gson = new Gson();
			String statusJson = gson.toJson(data);
			PrintWriter out = res.getWriter();
			out.print(statusJson);
			out.flush();
		}
		// if ("insert".equals(action)) {
//			Integer postID = Integer.valueOf(req.getParameter("postID"));
//			Integer gUserID =11000001; 
//			Integer likeStatus =Integer.valueOf(req.getParameter("likeStatus"));
//			ForumLike like = new ForumLike();
////		like.setPostID(postID);
//		like.setgUserID(gUserID);
//		like.setLikeStatus(likeStatus);
//		ForumLikeService likeSvc = new ForumLikeServiceImpl();
//		ForumLike addedLike = likeSvc.addLike(like);
//		String json = new Gson().toJson(addedLike);
//		PrintWriter out = res.getWriter();
//		out.print(json);
//		out.flush();
//		}
//		if ("update".equals(action)) {
//			Integer postID = Integer.valueOf(req.getParameter("postID"));
//			Integer gUserID = 11000001;
//			Integer likeStatus =Integer.valueOf(req.getParameter("likeStatus"));
//			ForumLike like = new ForumLike();
////		like.setPost(post);
//		like.setgUserID(gUserID);
//		like.setLikeStatus(likeStatus);
//		ForumLikeService likeSvc = new ForumLikeServiceImpl();
//		ForumLike updatedLike = likeSvc.addLike(like);
//		String json = new Gson().toJson(updatedLike);
//		PrintWriter out = res.getWriter();
//		out.print(json);
//		out.flush();
//		}
	}
}
