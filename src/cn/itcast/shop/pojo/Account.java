package cn.itcast.shop.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Account entity. @author MyEclipse Persistence Tools
 */

public class Account implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 8313535712848623348L;
	private Integer aid;
	private String alogin;
	private String aname;
	private String apass;
	private Set<Role> roles;

	// Constructors

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	/** default constructor */
	public Account() {
	}

	/** full constructor */
	public Account(String alogin, String aname, String apass) {
		this.alogin = alogin;
		this.aname = aname;
		this.apass = apass;
	}

	// Property accessors

	public Integer getAid() {
		return this.aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public String getAlogin() {
		return this.alogin;
	}

	public void setAlogin(String alogin) {
		this.alogin = alogin;
	}

	public String getAname() {
		return this.aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getApass() {
		return this.apass;
	}

	public void setApass(String apass) {
		this.apass = apass;
	}

}