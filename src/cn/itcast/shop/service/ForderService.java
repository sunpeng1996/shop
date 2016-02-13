package cn.itcast.shop.service;

import cn.itcast.shop.pojo.Forder;
import cn.itcast.shop.pojo.Sorder;

public interface ForderService extends BaseService<Forder> {

		public double cluFtotal(Forder forder);
		
}
