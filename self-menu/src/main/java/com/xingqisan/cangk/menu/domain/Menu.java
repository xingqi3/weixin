package com.xingqisan.cangk.menu.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "wx_menu")
public class Menu {

	@Id
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@GeneratedValue(generator = "uuid2")
	@Column(length = 36)
	private String id;
//	@JsonProperty("button")
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "menu_id")
	private List<SubMenu> subMenus;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<SubMenu> getSubMenus() {
		return subMenus;
	}

	public void setSubMenus(List<SubMenu> subMenus) {
		this.subMenus = subMenus;
	}

	@Override
	public String toString() {
		return "Menu [id=" + id + ", subMenus=" + subMenus + "]";
	}
}
