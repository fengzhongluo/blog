package com.sparkstu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author zhangwei
 * @since 2018.11.06
 */
public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("登陆过滤器销毁");
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) arg0;
		HttpServletResponse resp = (HttpServletResponse) arg1;
		HttpSession session = req.getSession();
		// 获取请求路径
		String path = req.getRequestURI();
		// 获取session中作为判断的字段
		String username = (String) session.getAttribute("username");
		// 判断请求的 路径中是否包含了 登录页面的请求
		// 如果包含了，那么不过滤 继续执行操作
		if (path.indexOf("back/login") > -1) {
			arg2.doFilter(req, resp);
		} else {
			// 如不包含，那么就要判断 session中否有标志，如果没有标志，那么不让他看，让他去登录，反之执行操作！
			if (username == null || "".equals(username)) {
				resp.sendRedirect("/back/login");
			} else {
				arg2.doFilter(req, resp);
			}
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("登陆过滤器初始化");
	}

}
