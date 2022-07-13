package com.solar.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ThirdLevelSubMenu {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String name;

	private String imageUrl;

	private String href;

	private int subMenuServicesId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public int getSubMenuServicesId() {
		return subMenuServicesId;
	}

	public void setSubMenuServicesId(int subMenuServicesId) {
		this.subMenuServicesId = subMenuServicesId;
	}

	@Override
	public String toString() {
		return "ThirdLevelSubMenu [id=" + id + ", name=" + name + ", imageUrl=" + imageUrl + ", href=" + href
				+ ", subMenuServicesId=" + subMenuServicesId + "]";
	}

}
