package com.myspring.springdemo.service;

import java.util.List;

import com.myspring.springdemo.controllers.form.AddLessonForm;
import com.myspring.springdemo.domain.Lesson;
import com.myspring.springdemo.domain.User;

public interface LessonService {

	public Lesson saveLesson(AddLessonForm addLessonForm, String email);

	public List<Lesson> getAllLessons(User user);
	
	public Lesson getLesson(long id);
	
	public Lesson saveLesson(Lesson lesson);
}
