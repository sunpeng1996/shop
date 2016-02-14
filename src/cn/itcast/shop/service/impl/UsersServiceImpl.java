package cn.itcast.shop.service.impl;

import java.util.List;

import cn.itcast.shop.pojo.Users;
import cn.itcast.shop.service.UsersService;

public class UsersServiceImpl extends BaseServiceImpl<Users> implements		UsersService {

	//用户登录的方法

	@SuppressWarnings("unused")
	public Users login(Users users) {
		@SuppressWarnings("unchecked")
		List<Users> usersList = hibernateTemplate.findByNamedParam(
				"FROM Users  u WHERE u.ulogin=:ulogin AND u.upass=:upass ",
				new String[] { "ulogin", "upass" },
				new Object[] { users.getUlogin(), users.getUpass() });
		System.out.println(usersList);
		return usersList.size()>0?usersList.get(0):null;
	}

}
