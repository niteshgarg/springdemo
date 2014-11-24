package com.myspring.springdemo.controllers.form;

import org.hibernate.validator.constraints.NotEmpty;

public class AddLessonForm {

	@NotEmpty(message = "Lesson Name must not be empty")
	private String lessonName;

	private String lessonDescription;

	public String getLessonName() {
		return lessonName;
	}

	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}

	public String getLessonDescription() {
		return lessonDescription;
	}

	public void setLessonDescription(String lessonDescription) {
		this.lessonDescription = lessonDescription;
	}

}
