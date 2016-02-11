package cn.itcast.shop.service.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.itcast.shop.pojo.Account;
import cn.itcast.shop.service.AccountService;

public class AccountServiceImpl extends BaseServiceImpl<Account> implements AccountService {
	

		public Account login(Account account) {
			// TODO Auto-generated method stub
			@SuppressWarnings("unchecked")
			List<Account> accounts = hibernateTemplate.findByNamedParam(
					"FROM Account a where a.alogin=:alogin AND a.apass=:apass", 
					new String[]{"alogin","apass"}, new Object[]{account.getAlogin(),account.getApass()});
			return accounts!=null?accounts.get(0):null;
		}

}
