package cn.itcast.shop.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import cn.itcast.shop.pojo.Goods;
import cn.itcast.shop.service.GoodsService;

public class GoodsServiceImpl extends BaseServiceImpl<Goods> implements GoodsService {

	@SuppressWarnings("unchecked")
	/*
	 * 回调: Spring只负责事务, 而不负责hibernate的持久化
	 * 
	 * 如果有些功能hibernateTemplate,没有提供(分页) 则可以使用回调的技术(session)来解决
	 */
	public List<Goods> queryGoodsByCid(final int cid) {
		
	/*	return hibernateTemplate.findByNamedParam
					("FROM Goods g WHERE g.gcommend=true AND g.gopen=true AND g.category.cid=:cid ORDER BY g.gdate DESC "
								, "cid", cid);*/
			return 	hibernateTemplate.execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
					return session.createQuery("FROM Goods g WHERE g.gcommend=true AND"
						+ " g.gopen=true AND g.category.cid=:cid ORDER BY g.gdate DESC ")
						.setInteger("cid", cid)
						.setFirstResult(0)
						.setMaxResults(3)
						.list();
			}			
		});
	}

	

}
