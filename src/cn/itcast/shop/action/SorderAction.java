package cn.itcast.shop.action;

import cn.itcast.shop.pojo.Forder;
import cn.itcast.shop.pojo.Sorder;

/* 购物项的action 
 * 
 * 由于我们设计：所有业务逻辑类都放到baseAction中
 * 
 * 我们可以在SorderAction完成添加购物项的操作,和计算总价格的操作
 * 
 * 也可以在ForderAction完成添加购物项的操作,和计算总价格的操作
 * 
 * 按照严格的做法. 不同的实体请求,要交给不同action来
 * 
 * 则先跳转 sorderAction 完成添加购物项的功能,
 * 
 * 在跳转ForderAction 完成计算总价的功能,最后到shopCar.jsp显示结果
 * */
public class SorderAction extends BaseAction<Sorder> {

	//	private Sorder sorder;
	 // 把购物项添加到购物车中
	public String addSorder(){
		// 拿到session中的forder
		Forder forder=(Forder)session.get("forder");
		// 把购物项添加到购物车中
		forder=sorderService.addSorder(forder,model);
		// 计算购物总价格
		forder.setFtotal(forderService.cluFtotal(forder));
		// 添加购物项, 然后重新放入session中
		session.put("forder",forder);
		// 跳转ForderAction 完成计算总价的功能,最后到shopCar.jsp显示结果
		System.out.println("---showCar---");
		return "showCar";
	}
	
	public String removeSorder(){
		int gid=model.getGoods().getGid();
		Forder forder=(Forder) session.get("forder");
		// 删除指定购物项
		forder=sorderService.removeSorder(forder, gid);
		// 计算新的总价格
		forder.setFtotal(forderService.cluFtotal(forder));
		// 新的购物车存储到session中
		session.put("forder", forder);
		// 把要返回的数据,存储到map中, 配置文件会指定把map返回
		jsonMap.put("ftotal", forder.getFtotal());
		// 返回json格式
		System.out.println("json demo");
		return "json1";
	}
}
