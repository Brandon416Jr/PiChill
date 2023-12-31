package com.pichill.manage.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.pichill.manage.service.ManageService;
//import com.pichill.manage.entity.Manage;

@WebServlet("/manage/DBJPGReader")
public class DBJPGReaderController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		res.setContentType("image/jpg");
		ServletOutputStream out = res.getOutputStream();

		try {
			Integer manageID = Integer.valueOf(req.getParameter("manageID"));
			ManageService manageService = new ManageService();
			byte[] b = manageService.getOneManage(manageID).getmProfilePic();
//			System.out.println(b);
//			if(b == null) {
//				System.out.println("ID:"+manageID);
//			}
			out.write(b);
		} catch (Exception e) {
//			e.printStackTrace();
			InputStream in = getServletContext().getResourceAsStream("/resources/NoData/noPic.jpg");
			if(in == null) {
			    throw new RuntimeException("Unable to find default picture"); 
			  }
			
			byte[] buf = new byte[in.available()];
			
			in.read(buf);
			out.write(buf);
			in.close();

		}
	}

}
