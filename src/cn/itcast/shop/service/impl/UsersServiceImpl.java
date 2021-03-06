package cn.itcast.shop.service.impl;

import java.util.List;

import cn.itcast.shop.pojo.Users;
import cn.itcast.shop.service.UsersService;

public class UsersServiceImpl extends BaseServiceImpl<Users> implements
		UsersService {

	@SuppressWarnings("unchecked")
	public Users login(Users users) {
		List<Users> usersList=hibernateTemplate.findByNamedParam(
				"FROM Users WHERE ulogin=:ulogin AND upass=:upass",
				new String[] { "ulogin", "upass" }, new Object[] {
						users.getUlogin(), users.getUpass() });
		System.out.println(usersList);
		return usersList.size()>0?usersList.get(0):null;
	}
}
