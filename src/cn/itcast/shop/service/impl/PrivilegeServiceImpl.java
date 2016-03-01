package cn.itcast.shop.service.impl;

import java.util.List;
import java.util.Set;

import cn.itcast.shop.pojo.Privilege;
import cn.itcast.shop.service.PrivilegeService;

public class PrivilegeServiceImpl extends BaseServiceImpl<Privilege> implements
		PrivilegeService {
	// 获取 purl
	public String[] getPrivilegePid(Set<Privilege> privileges) {
		String[] purls = new String[privileges.size()];
		int i = 0;
		for (Privilege temp : privileges) {
			purls[i++] = temp.getPurl();
		}
		return purls;
	}

	@SuppressWarnings("unchecked")
	public List<Privilege> getPrivilegeMenu() {
		// TODO Auto-generated method stub
		return hibernateTemplate.find("FROM Privilege p WHERE p.privilege is null");
	}

	@SuppressWarnings("unchecked")
	public List<String> getPrivilegeUrl() {
		return hibernateTemplate.find("SELECT p.purl FROM Privilege p WHERE p.privilege IS NOT NULL");
	}
}
