package cn.itcast.shop.service;

import java.util.List;

import cn.itcast.shop.pojo.Goods;

/**
 * 
 * @author 作者: 如今我已·剑指天涯
 * @Description:接口
 *创建时间:2016年2月11日下午9:18:47
 */
public interface GoodsService extends BaseService<Goods>{
		public List<Goods> queryGoodsByCid(int cid);		
}
