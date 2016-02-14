package cn.itcast.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.struts2.ServletActionContext;

import cn.itcast.shop.pojo.Forder;
import cn.itcast.shop.pojo.Sorder;

@SuppressWarnings("serial")
public class SorderAction extends BaseAction<Sorder> {
	
		//把订单项添加到购物车中
		public String addSorder() throws IOException{
				//拿到session中的购物车
				Forder forder = (Forder) session.get("forder");
				
				forder = sorderService.addSorder(forder, model);
				//完成计算总价
				forder.setFtotal(forderService.cluFtotal(forder));
				//把订单项添加到购物车中				
				//把购物车重新放到session中
				session.put("forder",forder);	
				//乱码问题没解决
				//ServletActionContext.getRequest().setCharacterEncoding("utf-8");
				//ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
				return "showCar";
				
		}
		
		//删除购物项
		public String removeSorder(){
			//删除指定购物项
			int gid = model.getGoods().getGid();			
			Forder forder = (Forder) session.get("forder");			
			forder = sorderService.removeSorder(forder, gid);
			//重新计算总价格
			forder.setFtotal(forderService.cluFtotal(forder));
			//新的购物车存储到session中
			session.put("forder", forder);
			//返回json格式
			jsonMap.put("ftotal", forder.getFtotal());//把要返回的数据存储到map中，配置文件会指定把map返回
			System.out.println("返回json格式、、、、");
			return "json1";
		}
	
}
