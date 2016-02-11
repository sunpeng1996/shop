package cn.itcast.action;

import cn.itcast.shop.pojo.Goods;

/**
 * 
 * @author 作者: 如今我已·剑指天涯
 * @Description:商品action
 *创建时间:2016年2月11日下午9:22:14
 */
public class GoodsAction extends BaseAction<Goods> {
	
		public String  save() {
			goodsService.save(model);
			return "main";
		}
}
