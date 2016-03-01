package cn.itcast.shop.action;

import java.util.Map;

import org.apache.struts2.interceptor.ParameterAware;

import cn.itcast.shop.pojo.BackData;
import cn.itcast.shop.pojo.Forder;
import cn.itcast.shop.pojo.SendData;
import cn.itcast.shop.pojo.Users;
import cn.itcast.shop.util.DigestUtil;

public class PayAction extends BaseAction<SendData> implements ParameterAware {

	private static final long serialVersionUID = 7536829892486840140L;

	private final String keyValue = "w0P75wMZ203fr46r5i70V556WHFa94j14yW5J6vuh4yo3nRl5jsqF3c41677";

	private Map<String, String[]> paramters = null;

	public void setParameters(Map<String, String[]> parameters) {
		this.paramters = parameters;
	}

	public String submit() {
		// 1:获取所有的数据
		// 2:对数据进行追加并加密
		String paramJoin = onlinePayService.joinOnlinePayParam(model);
		String hmac = DigestUtil.hmacSign(paramJoin, keyValue);
		// 3:存储到request对象中,跳转
		// 把明文和密文都存储到request.setAttribute中
		request.put("sendData", model);
		request.put("hmac", hmac);
		return "reqpay";
	}

	public String success() throws Exception {
		// 1: 把 Paramters 数据拿出来放到了 BackData中
		BackData backData = onlinePayService.valueToBackData(paramters);
		String hmac = paramters.get("hmac")[0];
		// 2:对数据进行追加并加密
		String paramJoin = onlinePayService.joinOnlinePayParam(backData);
		String md5 = DigestUtil.hmacSign(paramJoin, keyValue);
		// 3: 加密的数据和传输过来的密文进行对比,如果true则说明数据未修改
		boolean isOK = md5.equals(hmac);
		// 数据为修改,且支付的状态为1 则说明支付成功
		if (isOK && backData.getR1_Code().equals("1")) {
			// 支付成功,发送邮件,编写成功信息
			Forder forder = (Forder) session.get("forder");
			Users users = (Users) session.get("users");
			shopEmaiUtill.sendMessage(forder, users);
			request.put("info", "订单" + forder.getFid() + "支付成功");
		} else {
			request.put("info", "订单失败!");
		}
		return "payResult";
	}
}
