package com.pichill.backstage.owneruser.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pichill.backstage.owneruser.service.OwnerUserServiceBack;
@WebServlet("/owneruser/DBJPGReader")
public class DBJPGReaderController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		res.setContentType("image/jpg");
		ServletOutputStream out = res.getOutputStream();

		try {
			Integer oUserID = Integer.valueOf(req.getParameter("oUserID"));
			OwnerUserServiceBack oUserSvcB = new OwnerUserServiceBack();
			out.write(oUserSvcB.getOneOwnerUser(oUserID).getoProfilePic());
		} catch (Exception e) {
			e.printStackTrace();
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
