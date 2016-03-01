package cn.itcast.shop.lucene;

import org.apache.lucene.search.Query;
import org.apache.lucene.search.highlight.Formatter;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.Scorer;
import org.apache.lucene.search.highlight.SimpleFragmenter;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;

public class HighlighterUtil {

	private Formatter formatter = null;

	private Scorer fragmentScorer = null;

	private Configuration configuration = null;

	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}

	public HighlighterUtil() {
		formatter = new SimpleHTMLFormatter("<font color='red'>", "</font>");
	}

	/*
	 * 参数1: 查询的query对象: 需要里面的查询关键字
	 * 
	 * 参数2: 被高亮字段, 与query中查询关键字相同的文字设置高亮
	 * 
	 * 参数: 高亮后的字符长度
	 * */
	public String setHTMLFormat(Query query, String text, int size) {
		fragmentScorer = new QueryScorer(query);
		Highlighter highlighter = new Highlighter(formatter, fragmentScorer);
		highlighter.setTextFragmenter(new SimpleFragmenter(20));
		String result=null;
		try {
			 result= highlighter.getBestFragment(configuration
					.getAnalyzer(), null, text);
			 if(result==null){
				 if(text.length()>size){
					 result=text.substring(0, size);
				 }else{
					 result=text;
				 }
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
