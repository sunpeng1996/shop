package cn.itcast.shop.service.impl;

import static org.junit.Assert.fail;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.shop.pojo.Account;
import cn.itcast.shop.service.AccountService;

public class AccountServiceImplTest {

	private static AccountService accountService = null;

	private static ClassPathXmlApplicationContext context = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("applicationContext-*.xml");
		accountService = (AccountService) context.getBean("accountService");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		accountService=null;
		context.destroy();
	}

	@Test
	public void testDelete() {
		accountService.delete(1);
	}

	@Test
	public void testGet() {
		Account account=accountService.get(1);
		System.out.println(account.getAlogin());
	}

	@Test
	public void testQuery() {
		for(Account account:accountService.query()){
			System.out.println(account.getAid());
			System.out.println(account.getAname());
			System.out.println(account.getAlogin());
			System.out.println(account.getApass());
		}
	}

	@Test
	public void testSave() {
		Account account=new Account();
		account.setAlogin("test");
		account.setAname("test2");
		account.setApass("test");
		accountService.save(account);
	}

	@Test
	public void testUpdate() {
		Account account=accountService.get(1);
		account.setAlogin("update test");
		accountService.update(account);
	}
	
	@Test
	public void testLogin() {
		Account account=new Account();
		account.setAlogin("test");
		account.setApass("test");
		Account temp=accountService.login(account);
		System.out.println(temp.getAname());
	}
	
	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("applicationContext-*.xml");
	}

}
