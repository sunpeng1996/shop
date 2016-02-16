package cn.itcast.shop.util;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import cn.itcast.shop.pojo.Forder;
import cn.itcast.shop.pojo.Users;

public class ShopEmaiUtill {

	public void sendMessage(Forder forder, Users users) {
		// 1:创建会话
		Properties pops = new Properties();
		pops.setProperty("mail.host", "localhost");
		Session session = Session.getDefaultInstance(pops);
		// 设置session debug模式
		session.setDebug(true);
		// 2: 创建邮件对象
		Message mes = new MimeMessage(session);
		try {
			mes.setSubject("支付成功确认邮件");
			mes.setContent("您好:" + users.getUlogin() + "订单" + forder.getFid()
					+ "金额" + forder.getFtotal() + "已经支付成功,我们会尽快配送",
					"text/html;charset=utf-8");
			// 发信人的地址
			mes.setFrom(new InternetAddress("service@shop.com"));
			// 3: 发送邮件 传输对象
			Transport transPort = session.getTransport();
			// 发送信息配置
			transPort.connect("smtp.sina.com", 25, "service@shop.com", "111");
			// 配置收件人的地址
			transPort.sendMessage(mes, new Address[] { new InternetAddress(
					users.getUemail()) });
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
