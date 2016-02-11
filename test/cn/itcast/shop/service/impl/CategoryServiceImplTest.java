package cn.itcast.shop.service.impl;

import static org.junit.Assert.fail;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.shop.pojo.Category;
import cn.itcast.shop.service.CategoryService;

public class CategoryServiceImplTest {
	
	private static CategoryService categoryService=null;
	
	private static ClassPathXmlApplicationContext context = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("applicationContext-*.xml");
		categoryService=(CategoryService)context.getBean("categoryService");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		categoryService=null;
		context.destroy();
	}

	@Test
	public void testDelete() {
		categoryService.delete(1);
	}

	@Test
	public void testGet() {
		Category category=categoryService.get(1);
		System.out.println(category);
	}

	@Test
	public void testQuery() {
		for(Category temp:categoryService.query()){
			System.out.println(temp.getCtype());
			System.out.println(temp.getCid());
		}
	}

	@Test
	public void testSave() {
		Category category=new Category();
		category.setCtype("男士休闲");
		category.setChot(true);
		categoryService.save(category);
	}

	@Test
	public void testUpdate() {
		Category category=categoryService.get(1);
		category.setCtype("女士休闲");
		categoryService.update(category);
	}

}
