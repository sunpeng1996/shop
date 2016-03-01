package cn.itcast.shop.interceptor;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class CheckPrivilegeInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 7205114020105939381L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("------intercept------");
		ServletContext sc = (ServletContext) invocation.getInvocationContext()
				.get(StrutsStatics.SERVLET_CONTEXT);
		HttpServletRequest request = (HttpServletRequest) invocation
				.getInvocationContext().get(StrutsStatics.HTTP_REQUEST);

		// 1: 获取当前访问URL地址

		/*
		 * if(判断此URL地址是否要拦截器){ //把当前的URL地址,和 存储到数据库所有PURL比较，如果包含,则说明此请求是需要拦截的URL
		 * 
		 * if(判断操作员是否登录){ // 判断当前登录的用户是否有权限 if(拥有权限){ invocation.invoke();
		 * }else{ // 提示: 你没有此权限 return "alogin"; } }else{ // 提示,未登录 return
		 * "alogin"; }
		 * 
		 * }else{ //例如 注销(每个人都有)、购物功能(users),是不需要拦则直接放行 invocation.invoke() }
		 */
		// goodsAction_delete.action goodsAction_ goodsAction_delete
		String url = invocation.getProxy().getActionName();
		System.out.println("url--->" + url);
		List<String> purls = (List<String>) sc.getAttribute("purls");
		// 判断此URL是否需要拦截
		if (purls.contains(url)) {
			// 判断操作员是否登录
			Object o = invocation.getInvocationContext().getSession().get(
					"account");
			// 没有登录
			if (o == null) {
				request.setAttribute("error", "未登录");
				return "alogin";
			} else {
				// 验证当前的URL是否符合此操作员权限

				// 获取当前操作员的所有权限
				String[] allPurls = (String[]) invocation
						.getInvocationContext().getSession().get("allPurls");
				for (String temp : allPurls) {
					// 此url合法
					if (temp.equals(url)) {
						return invocation.invoke();
					}
				}
				request.setAttribute("error", "非法访问!");
				return "alogin";
			}
		} else {
			return invocation.invoke();
		}
	}

}
