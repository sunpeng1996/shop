package cn.itcast.shop.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Role entity. @author MyEclipse Persistence Tools
 */

public class Role implements java.io.Serializable {
	
	private static final long serialVersionUID = -7470672303246457856L;
	
	private Integer rid;
	private String rname;
	private String rdetail;
	private Set<Privilege> privileges = new HashSet<Privilege>();

	// Constructors

	public Set<Privilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(Set<Privilege> privileges) {
		this.privileges = privileges;
	}

	/** default constructor */
	public Role() {
	}

	// Property accessors

	public Integer getRid() {
		return this.rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public String getRname() {
		return this.rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getRdetail() {
		return this.rdetail;
	}

	public void setRdetail(String rdetail) {
		this.rdetail = rdetail;
	}
}