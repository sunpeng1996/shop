package cn.itcast.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.itcast.shop.pojo.Forder;
import cn.itcast.shop.pojo.SendData;
import cn.itcast.shop.pojo.Users;
import cn.itcast.shop.util.DigestUtil;
import cn.itcast.shop.util.MailUitls;

/**
 * 
 * @author 作者: 如今我已·剑指天涯
 * @Description:支付的Action
 *创建时间:2016年2月16日上午9:02:27
 */
public class PayAction extends BaseAction<SendData> {
	
	private final String keyValue = "w0P75wMZ203fr46r5i70V556WHFa94j14yW5J6vuh4yo3nRl5jsqF3c41677";
	
		public String submit(){			
			// 1:获取所有的数据
			// 2:对数据进行追加并加密
			String paramJoin =onlinePayService.joinOnlinePayParam(model);
			String hmac = DigestUtil.hmacSign(paramJoin, keyValue);
			// 3:存储到request对象中,跳转
			// 把明文和密文都存储到request.setAttribute中
			request.put("sendData", model);
			request.put("hmac", hmac);
			return "reqpay";
		}
		
		public String success()throws Exception {
			HttpServletRequest req=ServletActionContext.getRequest();
			String p1_MerId = "10000940764"; 
			String r0_Cmd = formatString(req.getParameter("r0_Cmd")); 
			String r1_Code = formatString(req.getParameter("r1_Code"));
			String r2_TrxId = formatString(req.getParameter("r2_TrxId"));
			String r3_Amt = formatString(req.getParameter("r3_Amt"));
			String r4_Cur = formatString(req.getParameter("r4_Cur"));
			String r5_Pid = new String(formatString(
					req.getParameter("r5_Pid")).getBytes("iso-8859-1"),
					"UTF-8");
			String r6_Order = formatString(req.getParameter("r6_Order"));
			String r7_Uid = formatString(req.getParameter("r7_Uid"));
			String r8_MP = new String(formatString(
					req.getParameter("r8_MP")).getBytes("iso-8859-1"),
					"UTF-8");
			String r9_BType = formatString(req.getParameter("r9_BType"));
			String hmac = formatString(req.getParameter("hmac"));
//			System.out.println(req.getParameter("r0_Cmd"));
//			System.out.println(request.get("r0_Cmd"));
//			System.out.println(request.get("r1_Code"));
//			System.out.println(request.get("r2_TrxId"));
//			System.out.println(request.get("r3_Amt"));
			StringBuffer infoBuffer = new StringBuffer();
			infoBuffer.append(p1_MerId);
			infoBuffer.append(r0_Cmd);
			infoBuffer.append(r1_Code);
			infoBuffer.append(r2_TrxId);
			infoBuffer.append(r3_Amt);
			infoBuffer.append(r4_Cur);
			infoBuffer.append(r5_Pid);
			infoBuffer.append(r6_Order);
			infoBuffer.append(r7_Uid);
			infoBuffer.append(r8_MP);
			infoBuffer.append(r9_BType);
			String md5 = DigestUtil.hmacSign(infoBuffer.toString(), keyValue);
			boolean isOK = md5.equals(hmac);
			System.out.println("--->" + isOK);
			System.out.println("--->" + r1_Code);
			if (isOK && r1_Code.equals("1")) {
				// 支付成功,发送邮件,编写成功信息
				Forder forder = (Forder) session.get("forder");
				Users users = (Users) session.get("users");
				//邮件这块有问题
				MailUitls.sendMessage(forder, users);
				req.setAttribute("info", "订单" + forder.getFid() + "支付成功");
			} else {
				// 支付失败,编写失败信息
				req.setAttribute("info", "订单失败!");
			}
			return "payResult";
		}
		
		String formatString(String text) {
			if (text == null) {
				return "";
			}
			return text;
		}
	}
