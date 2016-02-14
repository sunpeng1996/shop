package cn.itcast.action;

import cn.itcast.shop.pojo.Forder;
import cn.itcast.shop.pojo.Status;
import cn.itcast.shop.pojo.Users;

public class ForderAction extends BaseAction<Forder> {
	
	/**
	 * 购物订单入库
	 * 购物车与购物项级联入库实现
	 * @return
	 */
		public String save(){
			Forder forder = (Forder) session.get("forder");//获取session中的购物车
			forder.setFemail(model.getFemail());
			forder.setFname(model.getFname());
			forder.setFphone(model.getFphone());
			forder.setFpost(model.getFpost());
			forder.setFremark(model.getFremark());
			
			forder.setUsers((Users)session.get("users"));
			
			Status status = new Status();
			status.setSid(1);
			
			forder.setStatus(status);
			//购物车和购物项级联入库
			forderService.save(forder);
			return "bank";
			
		}

}
