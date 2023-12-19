package com.pichill.backstage.comment.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pichill.backstage.comment.service.CommentServiceBack;
import com.pichill.backstage.owneruser.service.OwnerUserServiceBack;
import com.pichill.backstage.post.service.PostServiceBack;
import com.pichill.comment.entity.Comment;
import com.pichill.post.entity.Post;

@WebServlet(name = "CommentBServlet", value="/comment/commentb.do")
public class CommentServletBack extends HttpServlet {
	private CommentServiceBack commentSvcB;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		commentSvcB = new CommentServiceBack();
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		if ("getOne_For_Update".equals(action)) { // 來自listAllPost.jsp的請求

			Integer commentID = Integer.valueOf(req.getParameter("commentID"));
			
			Comment comment = commentSvcB.getOneComment(commentID);

			req.setAttribute("comment", comment); // 資料庫取出的empVO物件,存入req
			String url = "/backstage/commentBack/set_comment.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
			successView.forward(req, res);
		}

			if ("delete".equals(action)) { // 來自listAllEmp.jsp

				List<String> errorMsgs1 = new LinkedList<String>();
				// Store this set in the request scope, in case we need to
				// send the ErrorPage view.
				req.setAttribute("errorMsgs", errorMsgs1);

				/*************************** 1.接收請求參數 ***************************************/
				Integer commentID = Integer.valueOf(req.getParameter("commentID"));

				/*************************** 2.開始刪除資料 ***************************************/
				CommentServiceBack commentSvcB = new CommentServiceBack();
				commentSvcB.deleteCommentBack(commentID);

				/*************************** 3.刪除完成,準備轉交(Send the Success view) ***********/
				String url = "/backstage/commentBack/all_comment.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
				successView.forward(req, res);
			}
	}
}
