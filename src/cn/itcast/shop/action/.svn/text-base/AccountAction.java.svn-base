package cn.itcast.shop.action;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cn.itcast.shop.pojo.Account;
import cn.itcast.shop.pojo.Role;

import com.opensymphony.xwork2.ActionContext;

/*
 * 1: 基本所有的Action都需要用到 request session application 内置对象
 * 
 * 通过它们存储数据,交给前台页面显示,Struts提供了AOP+IOC的方式,在运行的时候自动注入
 * 
 * 2: 前台所有的数据名次,必须要 对象.属性   这样做耦合很高, 我们可以实现一个接口,来解耦
 * 
 * */
public class AccountAction extends BaseAction<Account> {

	private static final long serialVersionUID = -4577220364888244047L;

	private int[] rid;

	public int[] getRid() {
		return rid;
	}

	public void setRid(int[] rid) {
		this.rid = rid;
	}

	public String exit() {
		// 移除操作登录保存在session中的信息
		session.remove("account");
		// 跳转到登录页面
		return "alogin";
	}

	public String saveUI() {
		return "saveUI";
	}

	public String save() {
		accountService.save(model);
		return "queryUI";
	}

	public String login() {
		Account account = accountService.login(model);
		if (account != null) {
			session.put("account", account);
			// 拿到当前操作员,所有权限pid account-->role--->privilege
			
			// 用来临时存储权限pid
			List<String> strList=new ArrayList<String>();
			// 拿到所有的角色ID
			for(Role role:account.getRoles()){
				  // 获取当前角色rid,所有权限
				  String[] temp=privilegeService.getPrivilegePid(role.getPrivileges());
				  // 先把字符串数组转为集合,然后把集合追加到strList中
				  strList.addAll(Arrays.asList(temp));
			}
			String[] allPurls=strList.toArray(new String[strList.size()]);
			session.put("allPurls",allPurls);
			return "aindex";
		} else {
			request.put("error", "登录失败!");
			return "alogin";
		}
	}

	public String queryUI() {
		return "queryUI";
	}

	public String query() {
		List<Account> accounts = accountService.query();
		// 查询的数据,如果能存储request中,就不要存储到session中
		request.put("accounts", accounts);
		ActionContext.getContext().getSession();
		return "queryUI";
	}

	public String updateUI() {
		Account account = accountService.get(model.getAid());
		request.put("account", account);
		// 拿到自身拥有的角色rid,为了回显
		request.put("accountRid", roleService.getRoleRid(account.getRoles()));
		// 查询所有角色
		request.put("roles", roleService.query());
		return "updateUI";
	}

	public String delete() {
		// 删除指定数据
		accountService.delete(model.getAid());
		// 删除完毕,查询剩余的数据
		List<Account> accounts = accountService.query();
		// 查询的数据,如果能存储request中,就不要存储到session中
		request.put("accounts", accounts);
		return "queryUI";
	}

	public String update() {
		// 更新当前操作员,角色数据
		Set<Role> roles = new HashSet<Role>();
		for (int temp : rid) {
			Role role = new Role();
			role.setRid(temp);
			roles.add(role);
		}
		model.setRoles(roles);
		accountService.update(model);
		return "queryUI";
	}

}
