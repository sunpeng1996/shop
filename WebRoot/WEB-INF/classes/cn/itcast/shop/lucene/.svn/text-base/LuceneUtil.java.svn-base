package cn.itcast.shop.lucene;

import java.io.IOException;

import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriter.MaxFieldLength;
import org.apache.lucene.search.IndexSearcher;

/*
 * 封装了indexWriter,indexSearch
 * */

public class LuceneUtil {

	private IndexWriter indexWriter=null;
	
	private IndexSearcher indexSearcher=null;
	// 查询所有的Terms
	private IndexReader indexReader=null;
	
	public IndexReader getIndexReader() {
		if(indexReader==null){
			synchronized (this) {
				if(indexReader==null){
					try {
						indexReader=IndexReader.open(configuration.getDirectory());
					} catch (IOException e) {
						throw new RuntimeException(e);
					}
				}
			}
		}
		return indexReader;
	}

	private Configuration configuration=null;

	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}

	// indexWriter做了操作则原来的indexSearch 不能读取到新数据,必须销毁
	public IndexWriter getIndexWriter() {
		closeIndexSearcher(indexSearcher);
		indexSearcher=null;
		closeIndexReader(indexReader);
		indexReader=null;
		return indexWriter;
	}

	public IndexSearcher getIndexSearcher() {
		if(indexSearcher==null){
			synchronized (this) {
				if(indexSearcher==null){
					try {
						indexSearcher=new IndexSearcher(configuration.getDirectory());
					} catch (IOException e) {
						throw new RuntimeException(e);
					}
				}
			}
		}
		return indexSearcher;
	}
	
	
	
	public void closeIndexWriter(IndexWriter indexWriter){
		if(indexWriter!=null){
			try {
				// 优化term
				indexWriter.optimize();
				// 关闭indexWriter
				indexWriter.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	public void closeIndexSearcher(IndexSearcher indexSearcher){
		if(indexSearcher!=null){
			try {
				indexSearcher.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	public void closeIndexReader(IndexReader indexReader){
		if(indexReader!=null){
			try {
				indexReader.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	public void init(){
		try {
			indexWriter=new IndexWriter(configuration.getDirectory(), configuration.getAnalyzer(),MaxFieldLength.LIMITED);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void destory(){
		closeIndexWriter(indexWriter);
	}
}
