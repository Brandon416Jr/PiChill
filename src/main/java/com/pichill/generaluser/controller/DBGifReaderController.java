package com.pichill.generaluser.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pichill.generaluser.service.GeneralUserService;

@WebServlet("/generaluser/DBGifReader")
public class DBGifReaderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		res.setContentType("image/gif");
		ServletOutputStream out = res.getOutputStream();

		try {
			Integer gUserID = Integer.valueOf(req.getParameter("gUserID"));
			GeneralUserService generaluserSvc = new GeneralUserService();
			out.write(generaluserSvc.getOneGeneralUser(gUserID).getgProfilePic());
		} catch (Exception e) {
			InputStream in = getServletContext().getResourceAsStream("/resources/NoData/nopic.jpg");
			byte[] buf = new byte[in.available()];
			in.read(buf);
			out.write(buf);
			in.close();

		}
	}
}
