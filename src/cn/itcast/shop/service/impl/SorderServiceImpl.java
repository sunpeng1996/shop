package cn.itcast.shop.service.impl;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Set;

import cn.itcast.shop.pojo.Forder;
import cn.itcast.shop.pojo.Sorder;
import cn.itcast.shop.service.SorderService;

public class SorderServiceImpl extends BaseServiceImpl<Sorder> implements
		SorderService {
	// 把购物项添加到购物车中,并且判断重复
	public Forder addSorder(Forder forder, Sorder sorder) {
		// 循环集合,判断是否有重复的购物项
		boolean isHave = false;
		Set<Sorder> sorders = forder.getSorders();
		for (Sorder temp : sorders) {
			if (temp.getGoods().getGid().equals(sorder.getGoods().getGid())) {
				temp.setSnumber(temp.getSnumber() + 1);
				isHave = true;
				break;
			}
		}
		// 没有重复购物项, 新增到购物车集合中
		if (!isHave) {
			// 也要把购物车添加到购物项中
			sorder.setForder(forder);
			sorders.add(sorder);
		}
		// forder.setSorders(sorders);
		return forder;
	}

	// 删除指定购物项
	public Forder removeSorder(Forder forder, int gid) {
		Set<Sorder> sorders = forder.getSorders();
		for (Sorder temp : sorders) {
			if (temp.getGoods().getGid().equals(gid)) {
				sorders.remove(temp);
				break;
			}
		}
		return forder;
	}
	
	public static void main(String[] args) {
		// 获取指定位置目录
		File file=new File("C:/logo");
		String[] names=file.list(new FilenameFilter() {
			public boolean accept(File arg0, String arg1) {
				return arg1.endsWith("gif");
			}
		});
		for(String temp:names){
			System.out.println(temp);
		}
	}
}
