package cn.itcast.shop.pojo;

import java.io.File;

/**
 * 
 * @author 作者: 如今我已·剑指天涯
 * @Description:将文件上传所需要的属性封装
 *创建时间:2016年2月12日上午9:45:12
 */
public class GoodsFile {
	
	private File image;

	private String imageFileName;

	private String imageContentType;

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getImageContentType() {
		return imageContentType;
	}

	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}
	
}
