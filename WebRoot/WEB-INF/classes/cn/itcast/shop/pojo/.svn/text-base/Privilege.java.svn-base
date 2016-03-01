package cn.itcast.shop.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Privilege entity. @author MyEclipse Persistence Tools
 */

public class Privilege implements java.io.Serializable {

	private static final long serialVersionUID = -3096838392822714616L;

	private Integer pid;
	 // 权限菜单的名称
	private String pname;
	// 权限菜单对应URL地址
	private String purl;
	// 此权限菜单是否要显示在左边
	private Boolean isleft;
	/* 自关联生成的 privilege, 用来存储当前权限对象的父对象*/
	private Privilege privilege;
	/* 自关联生成 set, 用于存储当前 权限菜单 子菜单 */
	private Set<Privilege> children;
	// 权限所赋予角色
	//private Set<Role> roles = new HashSet<Role>(0);

	// Constructors

	public Set<Privilege> getChildren() {
		return children;
	}


	public void setChildren(Set<Privilege> children) {
		this.children = children;
	}


	/** default constructor */
	public Privilege() {
	}


	// Property accessors

	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Privilege getPrivilege() {
		return this.privilege;
	}

	public void setPrivilege(Privilege privilege) {
		this.privilege = privilege;
	}

	public String getPname() {
		return this.pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPurl() {
		return this.purl;
	}

	public void setPurl(String purl) {
		this.purl = purl;
	}

	public Boolean getIsleft() {
		return this.isleft;
	}

	public void setIsleft(Boolean isleft) {
		this.isleft = isleft;
	}
}