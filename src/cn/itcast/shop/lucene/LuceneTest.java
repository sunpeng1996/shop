package cn.itcast.shop.lucene;

import java.io.IOException;

import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.index.TermEnum;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.shop.pojo.Goods;
import cn.itcast.shop.pojo.KeyWord;
import cn.itcast.shop.service.GoodsService;

public class LuceneTest {

	private static Configuration configuration = null;
	
	private static LuceneUtil luceneUtil=null;
	
	private static LuceneServiceImpl luceneServiceImpl=null;
	
	private static GoodsService goodsService=null;

	private static ClassPathXmlApplicationContext context = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("applicationContext-*.xml");
		configuration = (Configuration) context.getBean("configuration");
		luceneUtil = (LuceneUtil) context.getBean("luceneUtil");
		luceneServiceImpl=(LuceneServiceImpl)context.getBean("luceneServiceImpl");
		goodsService=(GoodsService)context.getBean("goodsService");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		configuration=null;
		context.destroy();
	}

	@Test
	public void testConfiguration(){
		System.out.println(configuration.getAnalyzer());
		System.out.println(configuration.getDirectory());
	}
	
	@Test
	public void testLuceneUtil(){
		System.out.println(luceneUtil.getIndexSearcher());
		System.out.println(luceneUtil.getIndexWriter());
		System.out.println(luceneUtil.getIndexSearcher());
		System.out.println(luceneUtil.getIndexWriter());
	}
	
	@Test
	public void testLuceneService_save(){
		Goods goods=new Goods();
		goods.setGid(200);
		goods.setGname("test");
		goods.setGprice(14.56);
		goods.setGpic("1.jpg");
		goods.setGremark("这里hello介绍");
		luceneServiceImpl.save(goods);
	}
	
	@Test
	public void testLuceneService_update(){
		Goods goods=new Goods();
		goods.setGid(100);
		goods.setGname("test2");
		goods.setGprice(32.56);
		goods.setGpic("2.jpg");
		goods.setGremark("这里简单介绍2");
		luceneServiceImpl.update(goods);
	}
	
	@Test
	public void testLuceneService_delete(){
		luceneServiceImpl.delete(100);
	}
	
	@Test
	public void testLuceneService_query(){
		for(Goods goods:luceneServiceImpl.query("这里是简单介绍")){
			System.out.println(goods.getGid());
			System.out.println(goods.getGname());
			System.out.println(goods.getGremark());
		}
	}
	
	@Test
	public void testGoodsServiceImpl_save(){
		Goods goods=new Goods();
		goods.setGid(200);
		goods.setGname("test");
		goods.setGprice(14.56);
		goods.setGpic("1.jpg");
		goods.setGremark("这里hello介绍");
		goodsService.save(goods);
	}
	
	@Test
	public void testIndexReader(){
		IndexReader indexReader=luceneUtil.getIndexReader();
		try {
			TermEnum termEnum=indexReader.terms();
			while(termEnum.next()){
				Term term=termEnum.term();
				System.out.println("key:" + term.field());
				System.out.println("value:" + term.text());
				System.out.println("此term的结果数为:" + termEnum.docFreq());
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	@Test
	public void testKeyWord(){
		for(KeyWord temp:luceneServiceImpl.getTermKey("t")){
			System.out.println(temp.getWord());
			System.out.println(temp.getNum());
		}
	}
	
	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("applicationContext-*.xml");
	}
}
