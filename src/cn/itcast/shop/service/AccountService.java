package cn.itcast.shop.service;

import java.util.List;

import cn.itcast.shop.pojo.Account;

public interface AccountService extends BaseService<Account> {
	
	// 定义自己独特的业务逻辑,登录
	public Account login(Account account);
}
