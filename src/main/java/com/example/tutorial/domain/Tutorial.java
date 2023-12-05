package com.example.tutorial.domain;

import java.io.Serializable;
import java.math.BigInteger;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tutorials")
public class Tutorial implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2256786507252392556L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	BigInteger id;
	@Column(name="description", nullable = false)
	String description;
	@Column(name="title", nullable = false)
	String title;
	@Column(name="published", nullable = false)
	boolean published;
	
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public boolean isPublished() {
		return published;
	}
	public void setPublished(boolean published) {
		this.published = published;
	}
	
	
}
