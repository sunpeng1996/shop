package cn.itcast.shop.service;

import java.util.List;

import cn.itcast.shop.pojo.Account;

/**
 * 
 * @author 作者: 如今我已·剑指天涯
 * @Description:父接口
 *创建时间:2016年2月11日上午9:35:46
 */

public interface BaseService<T> {
		
		public void save(T t);
		
		public void update(T t);
		
		public T get(int id);
		
		public List<T> query();
		
		public void delete(int id);
	
}

