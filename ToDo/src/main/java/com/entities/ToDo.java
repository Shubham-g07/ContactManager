package com.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ToDo {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int todoId;
private String todoTitle;
private String todoContent;
private Date date;
public ToDo(String todoTitle, String todoContent, Date date) {
	super();
	this.todoTitle = todoTitle;
	this.todoContent = todoContent;
	this.date = date;
}
public String getTodoTitle() {
	return todoTitle;
}
public void setTodoTitle(String todoTitle) {
	this.todoTitle = todoTitle;
}
public String getTodoContent() {
	return todoContent;
}
public void setTodoContent(String todoContent) {
	this.todoContent = todoContent;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
@Override
public String toString() {
	return this.getTodoTitle() + ":" + this.getTodoContent();
}
public ToDo() {
	super();
	// TODO Auto-generated constructor stub
}





}
