package cn.itcast.shop.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import cn.itcast.shop.pojo.Forder;

public class ShopHttpSessionListener implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent se) {
		// 创建一个购物车,并且把购物车存储session中
		System.out.println("-----create----");
		se.getSession().setAttribute("forder", new Forder());
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		// 插入最有登录时间
	}

}
