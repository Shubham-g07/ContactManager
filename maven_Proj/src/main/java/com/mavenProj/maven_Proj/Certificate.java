package com.mavenProj.maven_Proj;

import javax.persistence.Embeddable;

@Embeddable
public class Certificate {
	private String courseName;
	
	private String duration;

	public Certificate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Certificate(String courseName, String duration) {
		super();
		this.courseName = courseName;
		this.duration = duration;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "Certificate [courseName=" + courseName + ", duration=" + duration + "]";
	}
	
	
}
