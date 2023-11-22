package com.pichill.post.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pichill.post.entity.Post;
import com.pichill.post.service.PostService;
import com.pichill.post.service.PostServiceImpl;

@WebServlet
public class PostServlet extends HttpServlet {

	private PostService postService;

	@Override
	public void init() throws ServletException {
		postService = new PostServiceImpl();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		req.setCharacterEncoding("UTF-8");
//		String action = req.getParameter("action");
//		String forwardPath = "";
//		switch (action) {
//		case "getAll":
//			forwardPath = getAllPosts(req, res);
//			break;
//		case "compositeQuery":
//			forwardPath = getCompositePostsQuery(req, res);
//			break;
//		default:
//			forwardPath = "/index.jsp";
//		}
//
//		res.setContentType("text/html; charset=UTF-8");
//		RequestDispatcher dispatcher = req.getRequestDispatcher(forwardPath);
//		dispatcher.forward(req, res);
//	}

//	private String getAllPosts(HttpServletRequest req, HttpServletResponse res) {
//		String page = req.getParameter("page");
//		int currentPage = (page == null) ? 1 : Integer.parseInt(page);
//
//		List<Post> postList = postService.getAllPosts(currentPage);
//
//		if (req.getSession().getAttribute("postPageQty") == null) {
//			int postPageQty = postService.getPageTotal();
//			req.getSession().setAttribute("postPageQty", postPageQty);
//		}
//
//		req.setAttribute("postList", postList);
//		req.setAttribute("currentPage", currentPage);
//
//		return "/post/listAllposts.jsp";
//	}
//
//	private String getCompositePostsQuery(HttpServletRequest req, HttpServletResponse res) {
//		Map<String, String[]> map = req.getParameterMap();
//
//		if (map != null) {
//			List<Post> postList = postService.getPostsByCompositeQuery(map);
//			req.setAttribute("postList", postList);
//		} else {
//			return "/index.jsp";
//		}
//		return "/post/listCompositeQueryPosts.jsp";
//	}

}
