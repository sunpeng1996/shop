package cn.itcast.shop.action;

import cn.itcast.shop.pojo.Forder;
import cn.itcast.shop.pojo.Status;
import cn.itcast.shop.pojo.Users;

public class ForderAction extends BaseAction<Forder> {

	public String cluFtotal(){
		System.out.println("----cluFtotal----");
		// 从session中拿到购物车
		Forder forder=(Forder) session.get("forder");
		forder.setFtotal(forderService.cluFtotal(forder));
		session.put("forder",forder);
		return "showCar";
	}
	
	public String save(){
		// 购物车的信息和,订单配送信息合并
		Forder forder=(Forder)session.get("forder");
		forder.setFemail(model.getFemail());
		forder.setFname(model.getFname());
		forder.setFphone(model.getFphone());
		forder.setFpost(model.getFpost());
		forder.setFremark(model.getFremark());
		forder.setUsers((Users)session.get("users"));
		Status status=new Status();
		status.setSid(1);
		forder.setStatus(status);
		// 购物车和购物项级联入库
		forderService.save(forder);
		//session.put("forder", forder);
		return "bank";
	}
}
