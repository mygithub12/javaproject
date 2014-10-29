package com.java.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;


@Entity
public class Item {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	
	@Lob
	@Column(length=Integer.MAX_VALUE)
	private String description;
	private Date date;
	
	@Column(length=1000)
	private String link;
	
	@ManyToOne
	@JoinColumn
	private Blog blogs;
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public Blog getBlogs() {
		return blogs;
	}
	public void setBlogs(Blog blogs) {
		this.blogs = blogs;
	}

}
