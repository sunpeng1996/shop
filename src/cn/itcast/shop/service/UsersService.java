package cn.itcast.shop.service;

import cn.itcast.shop.pojo.Users;

public interface UsersService extends BaseService<Users> {
	
	public Users login(Users users);

}
