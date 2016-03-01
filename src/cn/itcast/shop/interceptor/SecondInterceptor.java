package cn.itcast.shop.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class SecondInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = -203917530261463423L;

	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("second in-------->");
		// 跳转到下一个拦截器拦截器,如果没有则跳转到指定的Action
		String result = invocation.invoke();
		System.out.println(result);		
		System.out.println("second out-------->");
		return result;
	}

}
