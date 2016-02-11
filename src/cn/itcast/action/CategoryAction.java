package cn.itcast.action;

import cn.itcast.shop.pojo.Category;

/**
 * 
 * @author 作者: 如今我已·剑指天涯
 * @Description:类别模块action
 *创建时间:2016年2月11日下午5:55:18
 */
public class CategoryAction extends BaseAction<Category> {
		public String save(){
			categoryService.save(model);
			return "main";
		}
}
