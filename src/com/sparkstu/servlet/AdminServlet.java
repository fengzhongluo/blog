package com.sparkstu.servlet;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

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
@WebServlet("/back/form")
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
		
		request.setCharacterEncoding("utf-8");
		
		String method = request.getParameter("to");
		String id = request.getParameter("id");

		
		
		
		ArticleService service = new ArticleServiceImpl();
		if ("form".equals(method)) {
			if("".equals(id)||id==null) {
				request.getRequestDispatcher("/WEB-INF/admin/form.jsp").forward(request, response);
				
			}else {
				String [] params= {id};
				
				Article article=null;
				try {
					article = service.getArticle(params);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IntrospectionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.setAttribute("article", article);
				request.getRequestDispatcher("/WEB-INF/admin/form.jsp").forward(request, response);
			}
			
			
			
		} else if ("add".equals(method)) {
			String title = request.getParameter("title");
			String author = request.getParameter("author");
			String summary = request.getParameter("summary");
			String content = request.getParameter("content");
			String publishTime = request.getParameter("publishTime");
			String url = request.getParameter("url");
			String html = request.getParameter("html");
			String tags = request.getParameter("tags");
			String coverUrl = request.getParameter("coverUrl");
			String[] params = {title, author, summary, content, publishTime, url, html, tags,coverUrl };

			int id1=service.addArticle(params);
			
			//request.getRequestDispatcher("/WEB-INF/article?method=contents&id="+id).forward(request, response);
			request.getRequestDispatcher("/WEB-INF/admin/form.jsp").forward(request, response);
		}else if ("edit".equals(method)) {
			
			String title = request.getParameter("title");
			String author = request.getParameter("author");
			String summary = request.getParameter("summary");
			String content = request.getParameter("content");
			String publishTime = request.getParameter("publishTime");
			String url = request.getParameter("url");
			String html = request.getParameter("html");
			String tags = request.getParameter("tags");
			String[] params = {  title, author, summary, content, publishTime, url, html, tags,id };

			service.editArticle(params);
			
			String[] params1 = {id};
			
			Article article=null;
			try {
				article = service.getArticle(params1);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IntrospectionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("article", article);			
			//request.getRequestDispatcher("/WEB-INF/article?method=contents&id="+id).forward(request, response);
			request.getRequestDispatcher("/WEB-INF/admin/form_edit.jsp").forward(request, response);
		}else if ("table-list".equals(method)) {
			
			List<Object> list=service.getArticleList(); 
			request.setAttribute("list", list);
			//request.getRequestDispatcher("/WEB-INF/article?method=contents&id="+id).forward(request, response);
			request.getRequestDispatcher("/WEB-INF/admin/table-list.jsp").forward(request, response);
		}else if ("form_edit".equals(method)) {
			String [] params= {id};
			
			Article article=null;
			try {
				article = service.getArticle(params);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IntrospectionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("article", article);			
			//request.getRequestDispatcher("/WEB-INF/article?method=contents&id="+id).forward(request, response);
			request.getRequestDispatcher("/WEB-INF/admin/form_edit.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/WEB-INF/admin/form.jsp").forward(request, response);
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
