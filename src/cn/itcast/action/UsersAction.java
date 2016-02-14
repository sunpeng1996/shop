package cn.itcast.action;

import cn.itcast.shop.pojo.Users;

/**
 * 
 * @author 作者: 如今我已·剑指天涯
 * @Description:用户Action
 *创建时间:2016年2月14日下午1:13:48
 */
@SuppressWarnings("serial")
public class UsersAction extends BaseAction<Users> {
		
		private String goUrl;
		
		public String getGoUrl() {
			return goUrl;
		}

		public void setGoUrl(String goUrl) {
			this.goUrl = goUrl;
		}



		public String login(){			 	
			 Users temp  = usersService.login(model);
			 if(temp==null){
				 //登录失败
				 request.put("error", "用户名或密码错误");
				 return "login";
			 }else {
				//登陆成功
				 session.put("users", temp);
				// 判断是正常登录还是非法登录, 正常登录跳转到首页,否则跳转到用户想要去的页面
				 if(session.get("goUrl")!=null){
					 goUrl = session.get("goUrl").toString();
					 return  "goUrl";
				 }else {
					 return "index";
				}		
			}
			
		}
	
}
