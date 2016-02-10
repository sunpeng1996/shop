package cn.itcast.action;

import cn.itcast.shop.service.impl.CategoryServiceImpl;

public class TestAction {
	
	private CategoryServiceImpl categoryServiceImpl;
		
	public void setCategoryServiceImpl(CategoryServiceImpl categoryServiceImpl) {
		this.categoryServiceImpl = categoryServiceImpl;
	}

	public String test() {
			System.out.println("-----testAction_____");
			System.out.println(categoryServiceImpl);
			return "success";
	}
}
