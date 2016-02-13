package cn.itcast.shop.service;

import cn.itcast.shop.pojo.Forder;
import cn.itcast.shop.pojo.Sorder;

public interface SorderService extends BaseService<Sorder> {
	
	//把购物项添加到购物车中，并且判断重复
			public Forder addSorder(Forder forder,Sorder sorder);

			//删除指定购物项
			public Forder removeSorder(Forder forder,int gid);
}
