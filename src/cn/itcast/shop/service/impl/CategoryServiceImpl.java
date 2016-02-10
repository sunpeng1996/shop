package cn.itcast.shop.service.impl;

import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.itcast.shop.pojo.Category;

public class CategoryServiceImpl {
	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public void save(Category category) {
		 hibernateTemplate.save(category);
	}
}
