package com.pichill.contactus.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pichill.contactus.service.ContactUsService;

@WebServlet("/contactus/DBGifReader")
public class DBGifReaderController extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		res.setContentType("image/gif");
		ServletOutputStream out = res.getOutputStream();

		try {
			Integer formID = Integer.valueOf(req.getParameter("formID"));
			ContactUsService contactusSvc = new ContactUsService();
			out.write(contactusSvc.getOneContactUs(formID).getformPic());
		} catch (Exception e) {
			InputStream in = getServletContext().getResourceAsStream("/resources/NoData/nopic.jpg");
			byte[] buf = new byte[in.available()];
			in.read(buf);
			out.write(buf);
			in.close();

		}
	}
}
