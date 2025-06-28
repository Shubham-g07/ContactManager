package com.mapping_tables;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Question {
	
	@Id
	@Column(name = "question_Id")
	private int qId;
	
	private String question;
	
	// here after mappedby we use another property to fetch data
	// by default the data fetching is happened by lazy loading
	// lazy loading :- the data loads when you call the getters and setters of the method
	// here if we dosen't get the asnwers then the DB dosen't load the answers 
	// if we want answers to get load when we make the object of the Question class
	// then use Eager loading 
	// it loads the data if we don't call it's getters or setters 
	
	@OneToMany(mappedBy = "question", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private List<Answer> answers;
	
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getqId() {
		return qId;
	}
	public void setqId(int qId) {
		this.qId = qId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}

	public List<Answer> getAnswers() {
		return answers;
	}
	
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	
	public Question(int qId, String question, List<Answer> answers) {
		super();
		this.qId = qId;
		this.question = question;
		this.answers = answers;
	}

	@Override
	public String toString() {
		return "Question [qId=" + this.qId + ", question=" + this.question + ", answers=" + this.answers + "]";
	}
	
	

	
}
