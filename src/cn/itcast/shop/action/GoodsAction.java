package cn.itcast.shop.action;

import java.util.ArrayList;
import java.util.List;

import cn.itcast.shop.pojo.Goods;
import cn.itcast.shop.pojo.GoodsFile;
import cn.itcast.shop.pojo.KeyWord;
/*
 * Action属于控制层: 获取数据,然后把数据给业务逻辑层
 * 
 * 需要把文件上传的功能,封装为一个模块, 调用即可(单例模式)
 * 
 * */
/*
 * 多例
 * */
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
	
	public String saveUI() {
		return "saveUI";
	}

	public String save() {
		String newName=fileUploadUtil.uploadFile(goodsFile.getImage(),goodsFile.getImageFileName());
		model.setGpic(newName);
		goodsService.save(model);
		return "queryUI";
	}
	
	public String search(){
		request.put("goodsList",luceneServiceImpl.query(model.getGname()));
		return "search";
	}
	
	public String update(){
		//判断是否上传了文件
		if(goodsFile==null){
			//说明文件没有上传
			goodsService.update(model);
		}else{
			// 删除原来文件
			fileUploadUtil.delete(model.getGpic());
			// 上传新文件
			String newName=fileUploadUtil.uploadFile(goodsFile.getImage(),goodsFile.getImageFileName());
			model.setGpic(newName);
			goodsService.update(model);
		}
		return "queryUI";
	}
	
	// 查询单个商品,返回到详细页面
	public String detail(){		
		request.put("goods",goodsService.get(model.getGid()));
		return "detail";
	}
	
	public String updateUI(){
		request.put("goods",goodsService.get(model.getGid()));
		return "updateUI";
	}
	
	public String queryUI(){
		return "queryUI";
	}
	
	public String query(){
		session.put("gname",model.getGname());
		request.put("goodsList",goodsService.queryGoodsByGname(model.getGname()));
		return "queryUI";
	}
	
	public String delete(){
		goodsService.delete(model.getGid());
		request.put("goodsList",goodsService.queryGoodsByGname((String)session.get("gname")));
		return "queryUI";
	}
}
