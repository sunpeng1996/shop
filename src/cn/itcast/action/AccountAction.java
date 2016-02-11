package cn.itcast.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.itcast.shop.pojo.Account;
import cn.itcast.shop.service.AccountService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AccountAction extends BaseAction<Account>{
	

	public String save(){
		accountService.save(model);
		return "main";
	}
	
	public String query(){
		List<Account> accounts = accountService.query();
		ActionContext.getContext().put("accounts", accounts);
		return "queryAccount";
	}
	
	public String delete(){
		//删除指定数据
		accountService.delete(model.getAid());
		//删除完毕，查询剩余的数据
		List<Account> accounts = accountService.query();
		//ActionContext.getContext().put("accounts", accounts);
		ServletActionContext.getRequest().setAttribute("accounts", accounts);
		return "queryAccount";
	}
	
	public String get(){
		Account temp = accountService.get(model.getAid());
	//	ActionContext.getContext().put("temp", temp);
		ServletActionContext.getRequest().setAttribute("account", temp);
		return "updateAccount";
	}
	
	
	public String update(){
		accountService.update(model);
		return "main";
	}

	
}
