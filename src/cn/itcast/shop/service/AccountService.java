package cn.itcast.shop.service;
/**
 * 
 * @author 作者: 如今我已·剑指天涯
 * @Description:
 *创建时间:2016年2月11日上午9:13:53
 */
import java.util.List;

import org.omg.CORBA.PUBLIC_MEMBER;

import cn.itcast.shop.pojo.Account;


public interface AccountService extends BaseService<Account>{
		public Account login(Account account);
	
	
}
