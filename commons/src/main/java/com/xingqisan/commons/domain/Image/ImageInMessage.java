package com.xingqisan.commons.domain.Image;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xingqisan.commons.domain.InMessage;

@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImageInMessage extends InMessage {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XmlElement(name = "PicUrl")
	@JsonProperty("PicUrl")
	private String picUrl;
	@XmlElement(name = "MediaId")
	@JsonProperty("MediaId")
	private String mediaId;
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public String getMediaId() {
		return mediaId;
	}
	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
	protected ImageInMessage(String type) {
		super(type);
		
	}
	@Override
	public String toString() {
		return "ImageInMessage [picUrl=" + picUrl + ", mediaId=" + mediaId + ", getToUserName()=" + getToUserName()
				+ ", getFromUserName()=" + getFromUserName() + ", getCreateType()=" + getCreateType()
				+ ", getMsgType()=" + getMsgType() + ", getMsgId()=" + getMsgId() + "]";
	}
	
}