package cn.itcast.shop.service.impl;

import java.util.List;

import cn.itcast.action.BaseAction;
import cn.itcast.shop.pojo.Forder;
import cn.itcast.shop.pojo.Sorder;
import cn.itcast.shop.service.ForderService;

public class ForderServiceImpl extends BaseServiceImpl<Forder> implements ForderService {

	//根据每一个购物项计算购物的总价格
	public double cluFtotal(Forder forder) {
			double ftotal = 0.0;
			for(Sorder sorder : forder.getSorders()){
					ftotal += sorder.getSprice()*sorder.getSnumber();
			}
			return ftotal;
	}

}
