package cn.itcast.shop.service.impl;

import java.util.List;

import cn.itcast.shop.pojo.Category;
import cn.itcast.shop.service.CategoryService;

public class CategoryServiceImpl extends BaseServiceImpl<Category> implements CategoryService {

	@SuppressWarnings("unchecked")
	public List<Category> queryByChot(boolean chot) {
		return hibernateTemplate.findByNamedParam("FROM Category c WHERE c.chot=:chot","chot", chot);
	}
	
	@SuppressWarnings("unchecked")
	public List<Category> queryByCtype(String ctype){
		return hibernateTemplate.findByNamedParam("FROM Category c WHERE c.ctype LIKE :ctype","ctype","%" + ctype + "%");
	}

}
