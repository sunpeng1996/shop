package cn.itcast.shop.lucene;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Index;
import org.apache.lucene.document.Field.Store;

import cn.itcast.shop.pojo.Goods;

public class DocumentUtil {

	public Goods documentToGoods(Document doc) {
		Goods goods = new Goods();
		goods.setGid(Integer.parseInt(doc.get("gid")));
		goods.setGname(doc.get("gname"));
		goods.setGpic(doc.get("gpic"));
		goods.setGprice(Double.parseDouble(doc.get("gprice")));
		goods.setGremark(doc.get("gremark"));
		return goods;
	}

	public Document goodsToDocument(Goods goods) {
		Document doc = new Document();
		doc.add(new Field("gid", goods.getGid().toString(), Store.YES,
						Index.NOT_ANALYZED));
		doc.add(new Field("gname", goods.getGname(), Store.YES, Index.ANALYZED));
		doc.add(new Field("gprice", goods.getGprice().toString(), Store.YES,
				Index.NO));
		doc.add(new Field("gpic", goods.getGpic(), Store.YES,Index.NO));
		doc.add(new Field("gremark", goods.getGremark(),Store.YES,Index.ANALYZED));
		return doc;
	}
}
