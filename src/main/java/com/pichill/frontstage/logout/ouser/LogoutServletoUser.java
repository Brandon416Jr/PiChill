package com.pichill.frontstage.logout.ouser;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pichill.frontstage.owneruser.service.OwnerUserServiceFront;
import com.pichill.manage.service.ManageService;

@WebServlet(name = "LogoutServletoUser", value = "/logoutfo.do")
public class LogoutServletoUser extends HttpServlet {
	private OwnerUserServiceFront oUserSvcF;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		oUserSvcF = new OwnerUserServiceFront();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		String action = req.getParameter("action");
		String forwardPath = "";
		if(action != null){
			  action.hashCode(); 
			} else {
				System.out.println("action為空值");
			}
		switch (action) {
		case "logout":
			forwardPath = logout(req, res);
			break;
		default:
			forwardPath = "/homepage/owneruserhome.jsp"; //改成前台企業會員的首頁
		}

		res.setContentType("text/html; charset=UTF-8");
		RequestDispatcher dispatcher = req.getRequestDispatcher(forwardPath);
		dispatcher.forward(req, res);
		

	}
	
	private String logout(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
        if (session != null) {
            session.invalidate(); // 登出，终止session
            System.out.println("成功登出");
        }

        res.setHeader("Cache-Control","no-cache"); 
        res.setHeader("Pragma","no-cache");
        res.setDateHeader ("Expires", 0);
        
        return "/login/oLogin/oUserLogin.jsp";
	}


}
