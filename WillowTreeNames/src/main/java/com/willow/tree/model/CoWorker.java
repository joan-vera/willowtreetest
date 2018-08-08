package com.willow.tree.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class CoWorker {
	
	//@JsonIgnoreProperties(ignoreUnknown = true)
	@Id
	private String id; //4NCJTL13UkK0qEIAAcg4IQ
	private String type;//people
	private String slug;//; //joel-garrett
	private String jobTitle; //Senior Software Engineer
	private String firstName; //Joel
	private String lastName; //Garrett
	/* Assumption is that only one headshot is permitted at a time */
	@Access(AccessType.PROPERTY)
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="Id")
	private Headshot headshot;
	private SocialLinks [] socialLinks; //
	private boolean selected = false;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSlug() {
		return slug;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Headshot getHeadshot() {
		return headshot;
	}
	public void setHeadshot(Headshot headshot) {
		this.headshot = headshot;
	}
	public SocialLinks[] getSocialLinks() {
		return socialLinks;
	}
	public void setSocialLinks(SocialLinks[] socialLinks) {
		this.socialLinks = socialLinks;
	}
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
}
