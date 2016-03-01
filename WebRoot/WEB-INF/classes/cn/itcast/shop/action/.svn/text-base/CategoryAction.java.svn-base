package cn.itcast.shop.action;

import cn.itcast.shop.pojo.Category;

public class CategoryAction extends BaseAction<Category> {

	private static final long serialVersionUID = 2963249639192373287L;

	public String saveUI(){
		return "saveUI";
	}
	
	public String save(){
		categoryService.save(model);
		// 及时同步application内置对象中
		application.put("categorys", categoryService.query());
		return "queryUI";
	}
	
	public String queryUI(){
		return "queryUI";
	}
	
	public String query(){
		request.put("categorys",categoryService.queryByCtype(model.getCtype()));
		return "queryUI";
	}
	
	// 异步请求, 不需要返回跳转页面
	public void update(){
		categoryService.update(model);
	}
	
	// 异步请求, 不需要返回跳转页面
	public String delete(){
		categoryService.delete(model.getCid());
		return "queryUI";
	}
}
