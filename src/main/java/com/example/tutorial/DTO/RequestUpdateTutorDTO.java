package com.example.tutorial.DTO;

public class RequestUpdateTutorDTO {
	String Title;
	String description;
	boolean published;
	
	public RequestUpdateTutorDTO() {
		super();
	}
	public RequestUpdateTutorDTO(String title, String description, boolean published) {
		super();
		Title = title;
		this.description = description;
		this.published = published;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
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
