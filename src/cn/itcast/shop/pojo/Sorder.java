package cn.itcast.shop.pojo;

/**
 * Sorder entity. @author MyEclipse Persistence Tools
 */

public class Sorder implements java.io.Serializable {

	private static final long serialVersionUID = -7873671947655278703L;
	private Integer sid;
	private String sname;
	private Double sprice;
	private Integer snumber;
	private Goods goods;
	private Forder forder;

	public Forder getForder() {
		return forder;
	}

	public void setForder(Forder forder) {
		this.forder = forder;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	/** default constructor */
	public Sorder() {
	}

	/** minimal constructor */
	public Sorder(Integer snumber) {
		this.snumber = snumber;
	}

	// Property accessors

	public Integer getSid() {
		return this.sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getSname() {
		return this.sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Double getSprice() {
		return this.sprice;
	}

	public void setSprice(Double sprice) {
		this.sprice = sprice;
	}

	public Integer getSnumber() {
		return this.snumber;
	}

	public void setSnumber(Integer snumber) {
		this.snumber = snumber;
	}

}