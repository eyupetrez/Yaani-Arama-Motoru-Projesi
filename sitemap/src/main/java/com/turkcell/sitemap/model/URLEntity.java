package com.turkcell.sitemap.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "URL")
public class URLEntity {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "Main_Url")
	private String url;
	
	@Column(name = "Url_Information")
	private String loc;
	
	@Column(name = "Domain_Name")
	private String domain_name;
	
	@Column(name = "Date")
	private String date;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDomain_name() {
		return domain_name;
	}

	public void setDomain_name(String domain_name) {
		this.domain_name = domain_name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	
}
