package cn.itcast.shop.action;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import cn.itcast.shop.lucene.LuceneServiceImpl;
import cn.itcast.shop.service.AccountService;
import cn.itcast.shop.service.CategoryService;
import cn.itcast.shop.service.ForderService;
import cn.itcast.shop.service.GoodsService;
import cn.itcast.shop.service.PrivilegeService;
import cn.itcast.shop.service.RoleService;
import cn.itcast.shop.service.SorderService;
import cn.itcast.shop.service.UsersService;
import cn.itcast.shop.service.impl.OnlinePayService;
import cn.itcast.shop.util.FileUploadUtil;
import cn.itcast.shop.util.ShopEmaiUtill;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/*
 * 此Action存储公共代码:
 * 
 * ModelDriven<Account>,RequestAware,SessionAware,ApplicationAware
 * 
 * 包括业务逻辑类
 * 
 * */
@SuppressWarnings("unchecked")
public class BaseAction<T> extends ActionSupport implements ModelDriven<T>,
		RequestAware, SessionAware, ApplicationAware {

	protected Map<String, Object> jsonMap = new HashMap<String, Object>();

	public Map<String, Object> getJsonMap() {
		return jsonMap;
	}

	public void setJsonMap(Map<String, Object> jsonMap) {
		this.jsonMap = jsonMap;
	}

	private static final long serialVersionUID = -6788612224756222880L;

	protected T model = null;

	protected Map<String, Object> request = null;

	protected Map<String, Object> session = null;

	protected Map<String, Object> application = null;

	protected AccountService accountService = null;

	protected CategoryService categoryService = null;

	protected GoodsService goodsService = null;

	protected FileUploadUtil fileUploadUtil = null;

	protected SorderService sorderService = null;

	protected ForderService forderService = null;

	protected UsersService usersService = null;

	protected OnlinePayService onlinePayService = null;

	protected ShopEmaiUtill shopEmaiUtill = null;
	
	protected LuceneServiceImpl luceneServiceImpl=null;
	
	protected RoleService roleService=null;
	
	protected PrivilegeService privilegeService=null;
	
	public void setPrivilegeService(PrivilegeService privilegeService) {
		this.privilegeService = privilegeService;
	}
	
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public void setLuceneServiceImpl(LuceneServiceImpl luceneServiceImpl) {
		this.luceneServiceImpl = luceneServiceImpl;
	}

	public void setShopEmaiUtill(ShopEmaiUtill shopEmaiUtill) {
		this.shopEmaiUtill = shopEmaiUtill;
	}

	public void setOnlinePayService(OnlinePayService onlinePayService) {
		this.onlinePayService = onlinePayService;
	}

	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}

	public void setForderService(ForderService forderService) {
		this.forderService = forderService;
	}

	public void setSorderService(SorderService sorderService) {
		this.sorderService = sorderService;
	}

	public void setFileUploadUtil(FileUploadUtil fileUploadUtil) {
		this.fileUploadUtil = fileUploadUtil;
	}

	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	public BaseAction() {
		try {
			ParameterizedType type = (ParameterizedType) this.getClass()
					.getGenericSuperclass();
			Class clazz = (Class) type.getActualTypeArguments()[0];
			model = (T) clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// 创建action之后,拦截器调用此方法
	public T getModel() {
		// TODO Auto-generated method stub
		return model;
	}

	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}

	public void setApplication(Map<String, Object> application) {
		// TODO Auto-generated method stub
		this.application = application;
	}

	public void setRequest(Map<String, Object> request) {
		// TODO Auto-generated method stub
		this.request = request;
	}

}
