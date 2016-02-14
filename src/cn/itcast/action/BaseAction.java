package cn.itcast.action;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import cn.itcast.shop.service.AccountService;
import cn.itcast.shop.service.CategoryService;
import cn.itcast.shop.service.ForderService;
import cn.itcast.shop.service.GoodsService;
import cn.itcast.shop.service.SorderService;
import cn.itcast.shop.service.UsersService;
import cn.itcast.shop.util.FileUploadUtil;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 
 * @author 作者: 如今我已·剑指天涯
 * @Description:存放公共的功能
 *创建时间:2016年2月11日下午5:17:46
 */
public class BaseAction<T> extends ActionSupport implements ModelDriven<T>,RequestAware,SessionAware,ApplicationAware{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2144891980824722080L;
	
	protected AccountService accountService;

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}
	
	protected CategoryService categoryService;
		
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public GoodsService goodsService;
	
	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}
	
	protected FileUploadUtil fileUploadUtil;
		
	public void setFileUploadUtil(FileUploadUtil fileUploadUtil) {
		this.fileUploadUtil = fileUploadUtil;
	}
	
	protected SorderService sorderService;

	
	
	public void setSorderService(SorderService sorderService) {
		this.sorderService = sorderService;
	}

	protected ForderService forderService;
	
	

	public void setForderService(ForderService forderService) {
		this.forderService = forderService;
	}

	protected Map<String , Object> jsonMap = new HashMap<String, Object>();
 	
	
	public Map<String, Object> getJsonMap() {
		return jsonMap;
	}

	public void setJsonMap(Map<String, Object> jsonMap) {
		this.jsonMap = jsonMap;
	}

	protected UsersService usersService = null;
	
	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}
	
	
	
	
	
	protected T model = null;
	
	public T getModel() {
		return model;
	}
	
	public BaseAction() {
		try {
			//获得子类的直接父类
			ParameterizedType type = (ParameterizedType) this.getClass()
					.getGenericSuperclass();
			Class clazz = (Class) type.getActualTypeArguments()[0];
			model=(T)clazz.newInstance();
		} catch (Exception e) {
			new RuntimeException(e);
		}
	}
	
	protected Map<String, Object> request = null;
	protected Map<String, Object> session = null;
	protected Map<String, Object> application = null;

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public void setApplication(Map<String, Object> application) {
		this.application = application;
	}
	
	
	
	
}