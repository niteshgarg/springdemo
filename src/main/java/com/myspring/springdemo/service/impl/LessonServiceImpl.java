package com.myspring.springdemo.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspring.springdemo.controllers.form.AddLessonForm;
import com.myspring.springdemo.dao.LessonDao;
import com.myspring.springdemo.dao.UserDao;
import com.myspring.springdemo.domain.Lesson;
import com.myspring.springdemo.domain.User;
import com.myspring.springdemo.service.LessonService;

@Service("lessonService")
public class LessonServiceImpl implements LessonService {

	@Autowired
	private LessonDao lessonDao;

	@Autowired
	private UserDao userDao;

	@Override
	public Lesson saveLesson(AddLessonForm addLessonForm, String email) {
		Lesson lesson = new Lesson();
		lesson.setUser(userDao.getUserByEmail(email));
		lesson.setCreated(new Date());
		lesson.setUpdated(new Date());
		lesson.setLessonDescription(addLessonForm.getLessonDescription());
		lesson.setLessonName(addLessonForm.getLessonName());
		return lessonDao.save(lesson);
	}

	@Override
	public List<Lesson> getAllLessons(User user) {
		return lessonDao.getAllLessons(user);
	}
	
	public Lesson saveLesson(Lesson lesson) {
		return lessonDao.save(lesson);
	}

	public LessonDao getLessonDao() {
		return lessonDao;
	}

	public void setLessonDao(LessonDao lessonDao) {
		this.lessonDao = lessonDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public Lesson getLesson(long id) {
		return lessonDao.get(id);
	}

}
