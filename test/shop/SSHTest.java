package shop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.itcast.shop.pojo.Category;
import cn.itcast.shop.service.impl.CategoryServiceImpl;
import cn.itcast.ssh.HibernateSessionFactory;

public class SSHTest {
		@Test
		public void hibernate(){
			System.out.println(HibernateSessionFactory.getConfiguration());
		}
		
		
		@Test
		public void springHibernate(){
			ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-*.xml");
			CategoryServiceImpl categoryServiceImpl= (CategoryServiceImpl) context.getBean("categoryServiceImpl");
			Category category = new Category("sss",false, 2);
			categoryServiceImpl.save(category);
		}
}
