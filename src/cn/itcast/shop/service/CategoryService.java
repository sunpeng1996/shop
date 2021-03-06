package cn.itcast.shop.service;

import java.util.List;

import cn.itcast.shop.pojo.Category;

public interface CategoryService extends BaseService<Category> {

	// 查询热点或者非热点类别
	public List<Category> queryByChot(boolean chot);
	
	// 根据类别名称查询类别信息
	public List<Category> queryByCtype(String ctype);
}
