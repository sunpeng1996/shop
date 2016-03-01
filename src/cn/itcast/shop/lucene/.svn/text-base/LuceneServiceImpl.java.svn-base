package cn.itcast.shop.lucene;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.index.TermEnum;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.aspectj.lang.JoinPoint;
import org.wltea.analyzer.lucene.IKQueryParser;

import cn.itcast.shop.pojo.Goods;
import cn.itcast.shop.pojo.KeyWord;

public class LuceneServiceImpl {

	private LuceneUtil luceneUtil = null;

	private DocumentUtil documentUtil = null;
	
	private HighlighterUtil highlighterUtil=null;
	
	public void setHighlighterUtil(HighlighterUtil highlighterUtil) {
		this.highlighterUtil = highlighterUtil;
	}

	public void setDocumentUtil(DocumentUtil documentUtil) {
		this.documentUtil = documentUtil;
	}

	public void setLuceneUtil(LuceneUtil luceneUtil) {
		this.luceneUtil = luceneUtil;
	}
	
	public List<KeyWord> getTermKey(String word){
		List<KeyWord> keyWords=new ArrayList<KeyWord>();
		IndexReader indexReader=luceneUtil.getIndexReader();
		try {
			// 查询所有Term 
			TermEnum termEnum=indexReader.terms();
			// 根据关键字过滤Term
			while(termEnum.next()){
				// 获取当前term,进行匹配
				Term temp=termEnum.term();
				// j    // abc
				// 按关键字进行匹配,符合条件的Term保留
				if(Pattern.matches(word + "(\\w|[\u4E00-\u9FA5])*", temp.text())){
					// 把term 追加到集合中
					KeyWord keyWord=new KeyWord();
					keyWord.setWord(temp.text());
					keyWord.setNum(termEnum.docFreq());
					keyWords.add(keyWord);
				}				
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
		// 添加到List集合中,返回给action
		return keyWords;
	}

	// 通知如果想获取切入点的数据,则要配置连接点
	public void saveGoods(JoinPoint joinPoint){
		// 获取连接点的所有参数
		this.save((Goods)joinPoint.getArgs()[0]);
	}
	
	public void save(Goods goods) {
		IndexWriter indexWriter = null;
		try {
			indexWriter = luceneUtil.getIndexWriter();
			indexWriter.addDocument(documentUtil.goodsToDocument(goods));
			indexWriter.commit();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void update(Goods goods) {
		IndexWriter indexWriter = null;
		try {
			indexWriter = luceneUtil.getIndexWriter();
			// 先通过term删除相应document文档对象,在插入新的document文档对象
			indexWriter.updateDocument(new Term("gid", goods.getGid()
					.toString()), documentUtil.goodsToDocument(goods));
			indexWriter.commit();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void delete(int gid) {
		IndexWriter indexWriter = null;
		try {
			indexWriter = luceneUtil.getIndexWriter();
			// 先通过term删除相应document文档对象,在插入新的document文档对象
			indexWriter.deleteDocuments(new Term("gid",gid + ""));
			indexWriter.commit();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public List<Goods> query(String gname) {
		List<Goods> goodsList=new ArrayList<Goods>();
		IndexSearcher indexSearcher=null;
		indexSearcher=luceneUtil.getIndexSearcher();
		Query query=null;
		try {
			query = IKQueryParser.parseMultiField(new String[]{"gname","gremark"},gname);
			// TopDocs: 存储 总记录数, 和 文档编号(ScoreDoc[])
			TopDocs topDoc=indexSearcher.search(query,100);
			System.out.println("命中的文档数为:" + topDoc.totalHits);
			// 通过文档编号获取doc文档对象
			ScoreDoc[] scoreDocs=topDoc.scoreDocs;
			for(int i=0;i<scoreDocs.length;i++){
				// ScoreDoc: 有文档的编号和文档的积分
				ScoreDoc temp=scoreDocs[i];
				System.out.println("当前文档的编号为:" + temp.doc + "积分为:" + temp.score);
				// 通过文档编号获取文档对象
				Document doc=indexSearcher.doc(temp.doc);
				// 给想要的字段设置高亮
				doc.getField("gname").setValue(highlighterUtil.setHTMLFormat(query, doc.get("gname"),15));
				doc.getField("gremark").setValue(highlighterUtil.setHTMLFormat(query, doc.get("gremark"),20));
				goodsList.add(documentUtil.documentToGoods(doc));
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return goodsList;
	}
}
