package cn.itcast.shop.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

// Servlet---> Action(不依赖request.... )
public class AccountLoginFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// 获取session中用户信息,判断登录是否成功
		HttpServletRequest req = (HttpServletRequest) request;
		if (req.getSession().getAttribute("account") != null) {
			// 跳转到下一个过滤器(如果有) 最后跳转到目标页面
			chain.doFilter(request, response);
		} else {
			// 非法访问,
			request.setAttribute("error", "非法访问");
			req.getRequestDispatcher("/alogin.jsp").forward(request, response);
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
