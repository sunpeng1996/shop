package cn.itcast.shop.service.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.itcast.shop.service.BaseService;

@SuppressWarnings("unchecked")
public class BaseServiceImpl<T> implements BaseService<T> {

	protected HibernateTemplate hibernateTemplate=null;
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	private Class<T> clazz=null;
	
	public BaseServiceImpl(){
		// 获取当前类的父类
		ParameterizedType type=(ParameterizedType)this.getClass().getGenericSuperclass();
		clazz=(Class)type.getActualTypeArguments()[0];
		System.out.println(clazz);
	}
	
	public static void main(String[] args) {
		AccountServiceImpl accountImpl=new AccountServiceImpl();
	}
	
	public void delete(int id) {
		// TODO Auto-generated method stub
		Object o=hibernateTemplate.get(clazz, id);
		if(o!=null){
			hibernateTemplate.delete(o);
		}
	}

	public T get(int id) {
		// TODO Auto-generated method stub Integer
		return hibernateTemplate.get(clazz, id);
	}

	public List<T> query() {
		// TODO Auto-generated method stub
		return hibernateTemplate.find("FROM " + clazz.getSimpleName());
	}

	public void save(T t) {

		// TODO Auto-generated method stub
		hibernateTemplate.save(t);
	}

	public void update(T t) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(t);
	}

}
