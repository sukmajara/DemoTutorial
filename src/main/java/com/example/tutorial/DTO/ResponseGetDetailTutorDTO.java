package com.example.tutorial.DTO;

public class ResponseGetDetailTutorDTO {
	String title;
	String description;
	String published;
	
	public ResponseGetDetailTutorDTO() {
		super();
	}
	public ResponseGetDetailTutorDTO(String title, String description, String published) {
		super();
		this.title = title;
		this.description = description;
		this.published = published;
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
	public String getPublished() {
		return published;
	}
	public void setPublished(String published) {
		this.published = published;
	}
	
	
}
