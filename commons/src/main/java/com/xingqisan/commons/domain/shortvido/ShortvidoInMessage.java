package com.xingqisan.commons.domain.shortvido;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xingqisan.commons.domain.InMessage;

@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class ShortvidoInMessage extends InMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XmlElement(name = "MediaId")
	@JsonProperty("MediaId")
	private String mediaId;
	@XmlElement(name = "ThumbMediaId")
	@JsonProperty("ThumbMediaId")
	private String thumbMediaId;

	protected ShortvidoInMessage(String type) {
		super(type);
		// TODO Auto-generated constructor stub
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getThumbMediaId() {
		return thumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}

	public static long getSerialversionuid() {
		return getSerialversionuid();
	}

	@Override
	public String toString() {
		return "ShortvidoInMessage [mediaId=" + mediaId + ", thumbMediaId=" + thumbMediaId + ", getToUserName()="
				+ getToUserName() + ", getFromUserName()=" + getFromUserName() + ", getCreateType()=" + getCreateType()
				+ ", getMsgType()=" + getMsgType() + ", getMsgId()=" + getMsgId() + "]";
	}
	
}
