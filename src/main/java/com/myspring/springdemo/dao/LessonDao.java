package com.myspring.springdemo.dao;

import java.util.List;

import com.myspring.springdemo.domain.Lesson;
import com.myspring.springdemo.domain.User;

public interface LessonDao extends GenericDao<Lesson, Long> {

	public void saveLesson(Lesson lesson);

	public List<Lesson> getAllLessons(User user);

}
