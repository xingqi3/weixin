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
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name = "wx_sub_menu")
public class SubMenu {

	@Id
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@GeneratedValue(generator = "uuid2")
	@Column(length = 36)
	private String id;
	private String name;
	private String type;
	@Column(name = "`key`")
	private String key;
//	@JsonProperty("appid")
	private String appId;
//	@JsonProperty("pagepath")
	private String pagePath;
	private String url;
//	@JsonProperty("media_id")
	private String mediaId;
//	@JsonProperty("media_id")
	@Transient
	private boolean show;
	@Transient
	private boolean active;
//	@JsonProperty("sub_button")
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "parent_id")
	private List<SubMenu> subMenus;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getPagePath() {
		return pagePath;
	}

	public void setPagePath(String pagePath) {
		this.pagePath = pagePath;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public List<SubMenu> getSubMenus() {
		return subMenus;
	}

	public void setSubMenus(List<SubMenu> subMenus) {
		this.subMenus = subMenus;
	}

	public boolean isShow() {
		return show;
	}

	public void setShow(boolean show) {
		this.show = show;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "SubMenu [id=" + id + ", name=" + name + ", type=" + type + ", key=" + key + ", appId=" + appId
				+ ", pagePath=" + pagePath + ", url=" + url + ", mediaId=" + mediaId + ", show=" + show + ", active="
				+ active + ", subMenus=" + subMenus + "]";
	}
}
