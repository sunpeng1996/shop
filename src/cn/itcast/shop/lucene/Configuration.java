package cn.itcast.shop.lucene;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.wltea.analyzer.lucene.IKAnalyzer;

/*
 * 
 * Lucene业务逻辑类: CRUD
 * 
 * Lucene工具类  indexWriter indexSearch
 * 
 * Lucene配置: 索引库 分词器
 * 
 * */
public class Configuration {


	private Analyzer analyzer=null;
	
	private Directory directory=null;
	
	public Analyzer getAnalyzer() {
		return analyzer;
	}

	public Directory getDirectory() {
		return directory;
	}

	private String dirPath=null;
	
	public void setDirPath(String dirPath) {
		this.dirPath = dirPath;
	}

	public void init(){
		try {
			analyzer=new IKAnalyzer(true);
			directory=FSDirectory.open(new File(dirPath));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
}
