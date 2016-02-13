package cn.itcast.shop.listener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import cn.itcast.shop.pojo.Forder;

public class ShopHttpSessionListener implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent se) {
			//session一创建就创建购物车
			System.out.println("Session创建，购物车创建");
			se.getSession().setAttribute("forder", new Forder());

	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		//在这里可以计算最后一次登录的时间
	}

}
