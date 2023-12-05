package com.pichill.contactus.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pichill.contactus.service.ContactUsService;

public class DBJPGReaderController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		res.setContentType("pic/contactuspic/jpg");
		ServletOutputStream out = res.getOutputStream();
		try {
			Integer manageID = Integer.valueOf(req.getParameter("formID"));
			ContactUsService contactUsService = new ContactusService();
			out.write(ContactUsService.getOneContactUs(formID).getformPic());
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
