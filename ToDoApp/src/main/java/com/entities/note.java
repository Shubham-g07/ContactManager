package com.entities;

import java.util.Date;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "notes")
public class note {
	
	@Id
	private int id;
	private String title;
	@Column(length = 1500)
	private String Content;
	private Date addedDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public Date getAddedDate() {
		return addedDate;
	}
	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}
	
	public note() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "note [id=" + id + ", title=" + title + ", Content=" + Content + ", addedDate=" + addedDate + "]";
	}
	
	public note(String title, String content, java.util.Date date) {
		super();
		this.id = new Random().nextInt(100000);
		this.title = title;
		Content = content;
		this.addedDate = (Date) date;
	}
}
