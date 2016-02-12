package cn.itcast.action;

import cn.itcast.shop.pojo.Goods;
import cn.itcast.shop.pojo.GoodsFile;

/**
 * 
 * @author 作者: 如今我已·剑指天涯
 * @Description:商品action
 *创建时间:2016年2月11日下午9:22:14
 */
public class GoodsAction extends BaseAction<Goods> {
	
		private GoodsFile goodsFile;
	
		public GoodsFile getGoodsFile() {
			return goodsFile;
		}

		public void setGoodsFile(GoodsFile goodsFile) {
			this.goodsFile = goodsFile;
		}

		public String  save() {
			String newFileName = fileUploadUtil.uploadFile(goodsFile.getImage(), goodsFile.getImageFileName());
			//将新的文件名称保存到数据库
			model.setGpic(newFileName);
			goodsService.save(model);
			return "main";
		}
}
