package com.example.tutorial.DTO;

import java.math.BigInteger;

public class ResponseUpdateTutorDTO {
	BigInteger id;
	String title;
	String description;
	boolean published;
	
	public ResponseUpdateTutorDTO() {
		super();
	}
	
	public ResponseUpdateTutorDTO(BigInteger id, String title, String description, boolean published) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.published = published;
	}
	
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isPublished() {
		return published;
	}
	public void setPublished(boolean published) {
		this.published = published;
	}


}
