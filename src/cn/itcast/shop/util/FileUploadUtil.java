package cn.itcast.shop.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

/**
 * 
 * @author 作者: 如今我已·剑指天涯
 * @Description:文件上传工具类
 *创建时间:2016年2月12日上午9:56:53
 */
public class FileUploadUtil {

	private String filePath = null;

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	private String getExt(String fileName) {
		return fileName.substring(fileName.lastIndexOf(".") + 1);
	}

	private String createFileName(String fileName) {
		return UUID.randomUUID().toString() + "." + getExt(fileName);
	}
	
	public String uploadFile(File file,String fileName,String path){
		if(path!=null){
			filePath=path;
		}
		return this.uploadFile(file, fileName);
	}

	// 上传文件,返回新文件名
	public String uploadFile(File file, String fileName) {
		// 生成新的文件名
		String newName = createFileName(fileName);
		// 文件上传
		InputStream input = null;
		OutputStream output = null;
		try {
			input = new FileInputStream(file);
			output = new FileOutputStream(filePath + "/" + newName);
			byte[] b = new byte[1024];
			int length = 0;
			while ((length = input.read(b)) != -1) {
				output.write(b, 0, length);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				input.close();
			} catch (Exception e) {
				throw new RuntimeException(e);
			} finally {
				try {
					output.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		}
		return newName;
	}

	public void delete(String fileName){
			new File(fileName).delete();
	}

	// 2: 获取给定路径的所有文件名,支持过滤
	public String[] getFileName(String path){
			File file=new File(path);
			//这里用到了一个过滤器
			return file.list(new FilenameFilter() {
				public boolean accept(File dir, String name) {
					return name.endsWith(".gif")?true:false;
				}
			});	
	}
	
	
}

