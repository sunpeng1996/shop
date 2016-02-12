package cn.itcast.shop.service;

import java.util.List;

import cn.itcast.shop.pojo.Category;

public interface CategoryService extends BaseService<Category>{
	
	/**
	 * 查询热点或者非热点类别
	 * @param chot
	 * @return
	 */
	public List<Category> queryByChot(boolean chot);
	
}
