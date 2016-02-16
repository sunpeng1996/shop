package cn.itcast.shop.service.impl;
/**
 * 封装支付数据的业务类
 */
import cn.itcast.shop.pojo.SendData;

public class OnlinePayService {

	public String joinOnlinePayParam(SendData sendData) {
		StringBuffer infoBuffer = new StringBuffer();
		infoBuffer.append(sendData.getP0_Cmd());
		infoBuffer.append(sendData.getP1_MerId());
		infoBuffer.append(sendData.getP2_Order());
		infoBuffer.append(sendData.getP3_Amt());
		infoBuffer.append(sendData.getP4_Cur());
		infoBuffer.append(sendData.getP5_Pid());
		infoBuffer.append(sendData.getP6_Pcat());
		infoBuffer.append(sendData.getP7_Pdesc());
		infoBuffer.append(sendData.getP8_Url());
		infoBuffer.append(sendData.getP9_SAF());
		infoBuffer.append(sendData.getPa_MP());
		infoBuffer.append(sendData.getPd_FrpId());
		infoBuffer.append(sendData.getPr_NeedResponse());
		return infoBuffer.toString();
	}
}
