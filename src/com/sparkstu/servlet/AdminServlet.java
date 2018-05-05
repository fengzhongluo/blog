package com.sparkstu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sparkstu.entity.Article;
import com.sparkstu.service.ArticleService;
import com.sparkstu.service.impl.ArticleServiceImpl;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("to");
		ArticleService service = new ArticleServiceImpl();
		if ("form".equals(method)) {

			request.getRequestDispatcher("/WEB-INF/admin/form.jsp").forward(request, response);
		} else if ("add".equals(method)) {
			String title = request.getParameter("title");
			String author = request.getParameter("author");
			String summary = request.getParameter("summary");
			String content = request.getParameter("content");
			String publishTime = request.getParameter("publishTime");
			String url = request.getParameter("url");
			String html = request.getParameter("html");
			String tags = request.getParameter("tags");
			String[] params = { title, author, summary, content, publishTime, url, html, tags };

			int id1=service.addArticle(params);
			
			//request.getRequestDispatcher("/WEB-INF/article?method=contents&id="+id).forward(request, response);
			request.getRequestDispatcher("/WEB-INF/admin/form.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/WEB-INF/admin/index.jsp").forward(request, response);
		}

		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
