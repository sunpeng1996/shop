package cn.itcast.shop.util;
/**
 * 定时器类，用于同步
 * 用来维护首页商品更新的线程,可以把它放到Spring容器中,对线程的工具类实现依赖注入
 */
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import javax.servlet.ServletContext;

import cn.itcast.shop.pojo.Category;
import cn.itcast.shop.pojo.Goods;
import cn.itcast.shop.service.CategoryService;
import cn.itcast.shop.service.GoodsService;

public class ShopTimerTask extends TimerTask {

	
		private CategoryService  categoryService = null;
		
		private GoodsService goodsService = null ;
		
		// 此对象是web容器的内置对象,不能通过Spring依赖注入,Spring容器也没有
		private ServletContext application=null;
		
		public void setCategoryService(CategoryService categoryService) {
			this.categoryService = categoryService;
		}

		public void setGoodsService(GoodsService goodsService) {
			this.goodsService = goodsService;
		}

		public void setApplication(ServletContext application) {
			this.application = application;
		}
		
		
		@Override
		public void run() {
		//实现线程定时同步
		// TODO Auto-generated method stub
		//根据热点类别，查询出类别的推荐商品_______大集合，用于装热点类别推荐商品:
		System.out.println("---run----");
		List<List<Goods>> bigList = new ArrayList<List<Goods>>();
		
		for (Category temp : categoryService.queryByChot(true)) {
			 	//根据每一个热点类别，查询各自的推荐商品
				bigList.add(goodsService.queryGoodsByCid(temp.getCid()));
		}
		
		application.setAttribute("bigList", bigList);
		
	}

}
