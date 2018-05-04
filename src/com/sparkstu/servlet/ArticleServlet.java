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
 * Servlet implementation class ArticleServlet
 */
@WebServlet("/article")
public class ArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArticleService  service=new ArticleServiceImpl();
		String method=request.getParameter("method");
		if("all".equals(method)||"".equals(method)||null==method) {
			
			List<Object> list=service.getArticleList(); 
			request.setAttribute("list", list);
			request.getRequestDispatcher("/WEB-INF/front/home.jsp").forward(request, response);
			
		}else if("contents".equals(method)) {
			String id=request.getParameter("id"); //获取主键
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
			request.getRequestDispatcher("/WEB-INF/front/article.jsp").forward(request, response);
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
