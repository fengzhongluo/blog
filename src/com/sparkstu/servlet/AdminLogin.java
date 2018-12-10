package com.sparkstu.servlet;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.security.MessageDigest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.Md5Crypt;

import com.sparkstu.entity.Article;
import com.sparkstu.entity.User;
import com.sparkstu.service.ArticleService;
import com.sparkstu.service.LoginService;
import com.sparkstu.service.impl.ArticleServiceImpl;
import com.sparkstu.service.impl.LoginServiceImpl;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/login")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if (username != null && (!"".equals(username)) && password != null && (!"".equals(password))) {
			String passToMD5 = DigestUtils.md5Hex(password);
			String[] params = { username, passToMD5 };
			LoginService service = new LoginServiceImpl();
			User user = null;
			try {
				user = service.verificationUser(params);
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
			if (user != null) {
				response.setContentType("text/html;charset=UTF-8");
				// 使用request对象的getSession()获取session，如果session不存在则创建一个
				HttpSession session = request.getSession();
				// 将数据存储到session中
				session.setAttribute("username", user.getUsername());
				// 获取session的Id
				String sessionId = session.getId();
				// 判断session是不是新创建的
				if (session.isNew()) {
					response.getWriter().print("session创建成功，session的id是：" + sessionId);
				} else {
					response.getWriter().print("服务器已经存在该session了，session的id是：" + sessionId);
				}
				request.getRequestDispatcher("/WEB-INF/admin/form.jsp").forward(request, response);
			} else {
				request.setAttribute("flag","用户名或密码错误");
				request.getRequestDispatcher("/WEB-INF/admin/login.jsp").forward(request, response);
			}

		} else {
			request.getRequestDispatcher("/WEB-INF/admin/login.jsp").forward(request, response);
		}

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
