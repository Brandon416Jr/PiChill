package com.pichill.like.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.pichill.like.entity.Like;
import com.pichill.like.service.LikeService;
import com.pichill.like.service.LikeServiceImpl;

@WebServlet("/like/like.do")
public class LikeServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application/json; charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		if ("insert".equals(action)) {
			Integer postID = Integer.valueOf(req.getParameter("postID"));
			Integer gUserID =11000001; 
			Integer likeStatus =Integer.valueOf(req.getParameter("likeStatus"));
			Like like = new Like();
//		like.setPostID(postID);
		like.setgUserID(gUserID);
		like.setLikeStatus(likeStatus);
		LikeService likeSvc = new LikeServiceImpl();
		Like addedLike = likeSvc.addLike(like);
		String json = new Gson().toJson(addedLike);
		PrintWriter out = res.getWriter();
		out.print(json);
		out.flush();
		}
		if ("update".equals(action)) {
			Integer postID = Integer.valueOf(req.getParameter("postID"));
			Integer gUserID = 11000001;
			Integer likeStatus =Integer.valueOf(req.getParameter("likeStatus"));
			Like like = new Like();
//		like.setPost(post);
		like.setgUserID(gUserID);
		like.setLikeStatus(likeStatus);
		LikeService likeSvc = new LikeServiceImpl();
		Like updatedLike = likeSvc.addLike(like);
		String json = new Gson().toJson(updatedLike);
		PrintWriter out = res.getWriter();
		out.print(json);
		out.flush();
		}
	}
}
