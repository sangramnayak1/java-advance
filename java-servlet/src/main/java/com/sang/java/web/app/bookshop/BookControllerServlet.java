package com.sang.java.web.app.bookshop;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BookControllerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String bookType = req.getParameter("Type");

		BookModelService bs = new BookModelService();
		BookType bt = BookType.valueOf(bookType);

		List bookAvl = bs.getAvailableBooks(bt);

		req.setAttribute("brands", bookAvl);
		RequestDispatcher view = req.getRequestDispatcher("result.jsp");
		view.forward(req, resp);
	}
}
