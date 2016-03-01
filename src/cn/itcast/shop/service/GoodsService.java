package cn.itcast.shop.service;

import java.util.List;

import cn.itcast.shop.pojo.Goods;

public interface GoodsService extends BaseService<Goods> {

	// 根据热点类别ID,查询推荐商品
	public List<Goods> queryGoodsByCid(int cid);
	
	// 根据商品名称查询
	public List<Goods> queryGoodsByGname(String gname);
}
