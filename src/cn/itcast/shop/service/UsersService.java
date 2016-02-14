package cn.itcast.shop.service;

import cn.itcast.shop.pojo.Users;

public interface UsersService extends BaseService<Users> {
		//用户登录方法
		public Users login(Users users);
}
