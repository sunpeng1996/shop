package cn.itcast.shop.util;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.junit.Test;

import cn.itcast.shop.pojo.Forder;
import cn.itcast.shop.pojo.Users;

/**
 * 邮件发送工具类
 * @author 孙鹏
 *
 */
public class MailUitls {
	/**
	 * 发送邮件的方法
	 */
	//测试方法
	@Test
	public  void testEmail() {
			Forder forder = new Forder();
			forder.setFid(11112222);
			forder.setFname("孙鹏");
			forder.setFtotal(12.0);
			Users users = new Users();
			users.setUname("孙鹏test");
			users.setUemail("aaa@shop.com");
			users.setUlogin("孙小鹏");
			sendMessage(forder, users);
			System.out.println("邮件已经发送成功，请注意查收");
	}
	
	public static void sendMessage(Forder forder, Users users) {
		// 1:创建会话
		Properties props = new Properties();
		 props.setProperty("mail.host", "localhost");
		 props.setProperty("mail.transport.protocol", "smtp");
		  props.setProperty("mail.smtp.auth", "true");
		  props.setProperty("mail.smtp.sendpartial", "true"); // for above problem
		  props.setProperty("mail.smtp.port", "25");//587 or 25
		  
	/*	
		 pops.put("mail.smtp.port", "25");   
		   
    // props.put("mail.smtp.starttls.enable", "true");
     props.put("mail.smtp.host", host);
    
     props.put("mail.debug", "true");  
    props.put("mail.transport.protocol", "smtps");
*/	
		Session session = Session.getInstance(props, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("serviceAdmin@shop.com", "111");
			}
			
		});
		// 2.创建邮件对象:
		Message message = new MimeMessage(session);
		// 设置发件人:
		try {
			message.setSubject("支付成功确认邮件");
			message.setContent("您好:" + users.getUlogin() + "订单" + forder.getFid()
					+ "金额" + forder.getFtotal() + "已经支付成功,我们会尽快配送",
					"text/html;charset=utf-8");
			// 发信人的地址
			message.setFrom(new InternetAddress("serviceAdmin@shop.com"));
			// 3: 发送邮件 传输对象
			message.addRecipient(RecipientType.TO, new InternetAddress(users.getUemail()));
			Transport.send(message);
		}catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
}
