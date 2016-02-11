package cn.itcast.shop.service.impl;
/**
 * 用来实现公共的CRUD业务逻辑方法, 必须实现BaseService接口
 */
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.itcast.shop.service.BaseService;
@SuppressWarnings("unchecked")
public class BaseServiceImpl<T> implements BaseService<T> {
	
	protected HibernateTemplate hibernateTemplate;
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	private Class<T> clazz = null;
	
	//此构造方法只能通过子类调用
	public BaseServiceImpl () {
			//获取当前类的父类
			ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
			//获取父类中的参数类型
			clazz =(Class) type.getActualTypeArguments()[0];
	}
	
	public void save(T t) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(t);
	}

	public void update(T t) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(t);
	}

	public T get(int id) {
		// TODO Auto-generated method stub
		return hibernateTemplate.get(clazz, id);
	}


	public List<T> query() {
		// TODO Auto-generated method stub
		return hibernateTemplate.find("FROM "+clazz.getSimpleName());
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		Object o = hibernateTemplate.load(clazz, id);
		if(o!=null){
			hibernateTemplate.delete(o);
		}
	}

}
