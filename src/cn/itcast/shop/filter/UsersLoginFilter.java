package cn.itcast.shop.filter;
/**
 * 过滤器
 */
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.ehcache.constructs.web.filter.Filter;

public class UsersLoginFilter extends Filter implements javax.servlet.Filter {

	@Override
	protected void doDestroy() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response,
			FilterChain chain) throws Throwable {
		//获取session中的用户信息，判断登录是否成功
		HttpServletRequest req  = (HttpServletRequest)request;
		
		System.out.println("拦截路径过滤器执行");
		
		if(req.getSession().getAttribute("user")!=null){
			//如果登陆成功，执行下一个过滤器（如果有），或者放行
				chain.doFilter(request, response);
		}else {
			request.setAttribute("error", "非法访问");
			//保留将要访问的url
			String url = req.getRequestURI();
			String param = req.getQueryString();
			
			StringBuffer goUrl = new StringBuffer();
			goUrl.append(url.substring(url.indexOf("/",1)));
			
			if (param!=null) {
				goUrl.append("?");
				goUrl.append(param);
			}
			// 把用户登录成功要去的地址保存在session中
			req.getSession().setAttribute("goUrl", goUrl);
			req.getRequestDispatcher("/login.jsp").forward(request, response);
		}

	}

	@Override
	protected void doInit() throws Exception {
		// TODO Auto-generated method stub

	}

}
