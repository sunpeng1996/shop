package cn.itcast.shop.action;

import java.util.HashSet;
import java.util.Set;

import cn.itcast.shop.pojo.Privilege;
import cn.itcast.shop.pojo.Role;

public class RoleAction extends BaseAction<Role> {

	private static final long serialVersionUID = 8910879316634874830L;

	private int[] pid;

	public int[] getPid() {
		return pid;
	}

	public void setPid(int[] pid) {
		this.pid = pid;
	}

	public String saveUI() {
		// 跳转到添加角色页面
		return "saveUI";
	}

	public String queryUI() {
		// 跳转到查询角色页面
		return "queryUI";
	}

	public String save() {
		// 实现角色插入操作
		roleService.save(model);
		// 跳转到角色查询页面
		return "queryUI";
	}

	public String updateUI() {
		// 1: 查询当前角色信息
		Role role = roleService.get(model.getRid());
		// 保存角色信息,更新页面不但要授权还要更新角色
		request.put("role", role);
		// 2: 查询所有的权限信息,并且支持树状结构显示, 由于权限不会变化,所以可以存储到application中
		// 此操作已经放到application监听器中
		// request.put("privileges", privilegeService.getPrivilegeMenu());
		// 3: 获取当前角色的权限pid 是为了回显
		request.put("myUrl", privilegeService.getPrivilegePid(role.getPrivileges()));
		// 4: 跳转到角色更新页面
		return "updateUI";
	}

	public String update() {
		// 获取新的权限pid
		Set<Privilege> privileges = new HashSet<Privilege>();
		for (int i : pid) {
			Privilege privilege = new Privilege();
			privilege.setPid(i);
			privileges.add(privilege);
		}
		model.setPrivileges(privileges);
		roleService.update(model);
		return "queryUI";
	}

	public String query() {
		// 完成所有角色的查询, 如果模糊查询则自己写实现方法
		request.put("roles", roleService.query());
		return "queryUI";
	}
	
	public String delete(){
		// 完成所有角色的查询, 如果模糊查询则自己写实现方法
		roleService.delete(model.getRid());
		request.put("roles", roleService.query());
		return "queryUI";
	}
}
