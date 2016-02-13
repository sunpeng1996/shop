package cn.itcast.shop.service.impl;

import java.util.List;

import cn.itcast.shop.pojo.Account;
import cn.itcast.shop.pojo.Category;
import cn.itcast.shop.service.AccountService;
import cn.itcast.shop.service.CategoryService;

public class CategoryServiceImpl extends BaseServiceImpl<Category> implements CategoryService {

	//根据热点或者非热点查询类别
	@SuppressWarnings("unchecked")
	public List<Category> queryByChot(boolean chot) {
		return hibernateTemplate.findByNamedParam("FROM Category c WHERE c.chot=:chot", "chot", chot);
	}

	@SuppressWarnings("unchecked")
	public List<Category> query(String ctype) {
			return hibernateTemplate.find("FROM Category c ");
		
	}

	public List<Category> queryByCtype(String ctype) {
		// TODO Auto-generated method stub
		return null;
	}

		

}
