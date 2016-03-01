package cn.itcast.shop.service;

import java.util.List;

public interface BaseService<T> {

	public void save(T t);

	public void update(T t);

	public T get(int id);

	public List<T> query();

	public void delete(int id);
}
