package cn.itcast.shop.action;

import cn.itcast.shop.pojo.Users;

public class UsersAction extends BaseAction<Users> {
	
	private String goUrl=null;
	
	public String getGoUrl() {
		System.out.println("---get---");
		return goUrl;
	}



	public void setGoUrl(String goUrl) {
		this.goUrl = goUrl;
	}



	public String login(){
		
		Users users=usersService.login(model);
		if(users==null){
			// 登录失败
			request.put("error","用户名密码错误");
			return "login";
		}else{
			// 登录成功
			session.put("users", users);
			// 是正常登录,被迫登录
			if(session.get("goUrl")!=null){
				goUrl=session.get("goUrl").toString();
				return "aa";
			}else{
				return "index";
			}
		}
	}
}
