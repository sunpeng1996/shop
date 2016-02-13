package cn.itcast.shop.pojo;

import java.sql.Timestamp;

/**
 * Goods entity. @author MyEclipse Persistence Tools
 */

public class Goods implements java.io.Serializable {

	// Fields

	private Integer gid;
	private String gname;
	private Double gprice;
	private String gpic;
	private String gremark;
	private String gxremark;
	private Timestamp gdate;
	private Boolean gcommend;
	private Boolean gopen;
	private Category category;
	
	
	// Constructors

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	/** default constructor */
	public Goods() {
	}

	/** minimal constructor */
	public Goods(Timestamp gdate) {
		this.gdate = gdate;
	}


	// Property accessors

	public Integer getGid() {
		return this.gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public String getGname() {
		return this.gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public Double getGprice() {
		return this.gprice;
	}

	public void setGprice(Double gprice) {
		this.gprice = gprice;
	}

	public String getGpic() {
		return this.gpic;
	}

	public void setGpic(String gpic) {
		this.gpic = gpic;
	}

	public String getGremark() {
		return this.gremark;
	}

	public void setGremark(String gremark) {
		this.gremark = gremark;
	}

	public String getGxremark() {
		return this.gxremark;
	}

	public void setGxremark(String gxremark) {
		this.gxremark = gxremark;
	}

	public Timestamp getGdate() {
		return this.gdate;
	}

	public void setGdate(Timestamp gdate) {
		this.gdate = gdate;
	}

	public Boolean getGcommend() {
		return this.gcommend;
	}

	public void setGcommend(Boolean gcommend) {
		this.gcommend = gcommend;
	}

	public Boolean getGopen() {
		return this.gopen;
	}

	public void setGopen(Boolean gopen) {
		this.gopen = gopen;
	}


}