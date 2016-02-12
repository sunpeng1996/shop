package cn.itcast.shop.listener;
/**
 * 监听器，用于完成项目启动时数据的初始化
 */
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.itcast.shop.service.CategoryService;

public class ShopServletContextListener implements ServletContextListener {
	
	private ApplicationContext context;
	
	private CategoryService  categoryService;

	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void contextInitialized(ServletContextEvent se) {
		//1.如果数据量不大，更新不频繁，可以存储到app缓存中，缺点：需要自己解决同步问题
		//2.数据量大，可以考虑使用hibernate二级缓存，hibernate自己提供了同步功能
		
		//spring的配置文件，项目启动时配置文件读取后也存储到了application内置对象中
		context = WebApplicationContextUtils.getWebApplicationContext(se.getServletContext());
		categoryService = (CategoryService) context.getBean("categoryService");
		//获取所有的类别，存储到app内置对象中
		se.getServletContext().setAttribute("categorys", categoryService.query());

	}

}
