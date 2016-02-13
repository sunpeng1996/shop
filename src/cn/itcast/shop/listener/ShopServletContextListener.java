package cn.itcast.shop.listener;
/**
 * 监听器，用于完成项目启动时数据的初始化
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.itcast.shop.pojo.Category;
import cn.itcast.shop.pojo.Goods;
import cn.itcast.shop.service.CategoryService;
import cn.itcast.shop.service.GoodsService;
import cn.itcast.shop.util.ShopTimerTask;

public class ShopServletContextListener implements ServletContextListener {
	
	private ApplicationContext context;
	
	private CategoryService  categoryService;
	
	//private GoodsService goodsService;
	
	private ShopTimerTask shopTimerTask;

	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void contextInitialized(ServletContextEvent se) {
		//1.如果数据量不大，更新不频繁，可以存储到app缓存中，缺点：需要自己解决同步问题
		//2.数据量大，可以考虑使用hibernate二级缓存，hibernate自己提供了同步功能
		
		//spring的配置文件，项目启动时配置文件读取后也存储到了application内置对象中
		context = WebApplicationContextUtils.getWebApplicationContext(se.getServletContext());
		categoryService = (CategoryService) context.getBean("categoryService");
		//goodsService=(GoodsService) context.getBean("goodsService");
		//获取所有的类别，存储到app内置对象中
		se.getServletContext().setAttribute("categorys", categoryService.query());
		
		// 通过Spring配置文件,获取线程任务
		ShopTimerTask shopTimerTask = (ShopTimerTask) context.getBean("shopTimerTask");
		shopTimerTask.setApplication(se.getServletContext());
		//设置执行时间
		new Timer(true).schedule(shopTimerTask, 0, 1000*10*60);

	}

}
