package cn.itcast.shop.service.impl;

import java.util.Set;

import cn.itcast.shop.pojo.Privilege;
import cn.itcast.shop.pojo.Role;
import cn.itcast.shop.service.RoleService;

public class RoleServiceImpl extends BaseServiceImpl<Role> implements
		RoleService {

	public String[] getRoleRid(Set<Role> roles) {
		String[] rids = new String[roles.size()];
		int i = 0;
		for (Role temp : roles) {
			rids[i++] = temp.getRid().toString();
		}
		return rids;
	}

}
