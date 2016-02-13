package cn.itcast.shop.service.impl;

import java.util.Set;

import cn.itcast.shop.pojo.Forder;
import cn.itcast.shop.pojo.Sorder;
import cn.itcast.shop.service.SorderService;

public class SorderServiceImpl extends BaseServiceImpl<Sorder> implements SorderService {

	//把购物项添加到购物车中，并且判断重复
	public Forder addSorder(Forder forder, Sorder sorder) {
		//循环集合判断是否重复
		boolean isHave = false;
		Set<Sorder> sorders = forder.getSorders();
		for(Sorder temp : sorders){
			if(temp.getGoods().getGid().equals(sorder.getGoods().getGid())){
					temp.setSnumber(temp.getSnumber()+1);
					isHave = true;
					break;
			}
		}
		//没有重复的购物项，新增到购物车集合中
		if(!isHave){
				sorders.add(sorder);
		}
		//
		//forder.setSorders(sorders);
		return forder;
	}

	//删除指定购物项
	public Forder removeSorder(Forder forder, int gid) {
			for(Sorder sorder : forder.getSorders()){
				if(sorder.getGoods().getGid().equals(gid)){
						forder.getSorders().remove(sorder);
						break; 
				}
			}
		return forder;
	}

}
