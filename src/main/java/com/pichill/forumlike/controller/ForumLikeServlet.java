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
import com.google.gson.JsonObject;
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
			long likeCnt = likeSvc.getLikeCnt(postID);
			Map<String, Object> data = new HashMap<>();
			data.put("status", status);
			data.put("likeCnt", likeCnt);
			Gson gson = new Gson();
			String statusJson = gson.toJson(data);
			PrintWriter out = res.getWriter();
			out.print(statusJson);
			out.flush();
		}
		if ("showlike".equals(action)) {
			Integer postID = Integer.valueOf(req.getParameter("postID"));
//			System.out.println(postID);
			ForumLikeService likeSvc = new ForumLikeServiceImpl();
			Boolean status = likeSvc.getLikeByPostIDAndUserID2(postID, 11000001);
			Map<String, Object> data = new HashMap<>();
			data.put("status", status);
			Gson gson = new Gson();
			String statusJson = gson.toJson(data);
			PrintWriter out = res.getWriter();
			out.print(statusJson);
			out.flush();
		}
		if ("get_likeCnt".equals(action)) {
			Integer postID = Integer.valueOf(req.getParameter("postID"));
			ForumLikeService likeSvc = new ForumLikeServiceImpl();
			long likeCnt = likeSvc.getLikeCnt(postID);
			JsonObject jsonObject = new JsonObject();
		    jsonObject.addProperty("postID", postID);
		    jsonObject.addProperty("likeCnt", likeCnt);

		    String json = new Gson().toJson(jsonObject);

		    PrintWriter out = res.getWriter();
		    out.print(json);
		    out.flush();
		}
	}
}
