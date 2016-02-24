package cn.itcast.action;

import java.util.List;

import cn.itcast.shop.pojo.Goods;
import cn.itcast.shop.pojo.GoodsFile;
import cn.itcast.shop.pojo.KeyWord;

/**
 * 
 * @author 作者: 如今我已·剑指天涯
 * @Description:商品action
 *创建时间:2016年2月11日下午9:22:14
 */
public class GoodsAction extends BaseAction<Goods> {
	
		private GoodsFile goodsFile;
		
		private List<KeyWord> keyWords=null;
		
		public List<KeyWord> getKeyWords() {
			return keyWords;
		}

		private String q;

		public String getQ() {
			return q;
		}

		public void setQ(String q) {
			this.q = q;
		}
		
	
		public GoodsFile getGoodsFile() {
			return goodsFile;
		}

		public void setGoodsFile(GoodsFile goodsFile) {
			this.goodsFile = goodsFile;
		}
		
		public String auto(){
			System.out.println(q);
			keyWords=luceneServiceImpl.getTermKey(q);
			return "json";
		}
		
		public String search(){
			request.put("goodsList",luceneServiceImpl.query(model.getGname()));
			return "search";
		}
		

		public String  save() {
			String newFileName = fileUploadUtil.uploadFile(goodsFile.getImage(), goodsFile.getImageFileName());
			//将新的文件名称保存到数据库
			model.setGpic(newFileName);
			goodsService.save(model);
			return "main";
		}
		
		//查询所有商品
		public String query(){
				session.put("gname",model.getGname());
				request.put("goodsList", goodsService.queryByGname(model.getGname()));
				return "query";
		}
		
		public String update(){
			//判断是否上传了文件
			if (goodsFile==null) {
					//如果没有上传文件
					goodsService.update(model);
			}else {
				//删除原来上传的文件
				fileUploadUtil.delete(model.getGpic());
				// 上传新文件
				String newName=fileUploadUtil.uploadFile(goodsFile.getImage(),goodsFile.getImageFileName());
				model.setGpic(newName);
				goodsService.update(model);
			}
			return "query";
		}
		
		//查询单个商品返回到详细页面
		public String detail(){
			request.put("goods", goodsService.get(model.getGid()));
			return "detail";
		}
		
		public String get(){
			request.put("goods",goodsService.get(model.getGid()));
			return "update";
		}
		
		
		public String delete(){
			goodsService.delete(model.getGid());
			request.put("goodsList",goodsService.queryByGname((String)session.get("gname")));
			return "query";
		}
}
