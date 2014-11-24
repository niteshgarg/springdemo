package com.myspring.springdemo.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.myspring.springdemo.dao.LessonDao;
import com.myspring.springdemo.domain.Lesson;
import com.myspring.springdemo.domain.User;
import com.myspring.springdemo.util.FrontFlipUtil;

@Repository("lessonDao")
public class LessonDaoImpl extends GenericDaoImpl<Lesson, Long> implements
		LessonDao {

	private static final Logger logger = Logger.getLogger(LessonDaoImpl.class);

	public LessonDaoImpl() {
		super(Lesson.class);
	}

	@Override
	public void saveLesson(Lesson lesson) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(lesson);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			logger.fatal("Lesson: " + lesson + " "
					+ FrontFlipUtil.getExceptionDescriptionString(e));
			throw e;
		} finally {
			session.flush();
			session.close();
		}
	}

	@Override
	public List<Lesson> getAllLessons(User user) {
		Session session = null;
		List<Lesson> lessons = null;
		long userId = 0;
		try {
			if (null != user) {
				userId = user.getUserId();
			}

			session = getSessionFactory().openSession();
			String queryString = "from Lesson where user_id = :user_id and deleted=:deleted";
			Query query = session.createQuery(queryString);
			query.setLong("user_id", userId);
			query.setBoolean("deleted", false);
			lessons = query.list();
		} catch (Exception e) {
			logger.fatal(FrontFlipUtil.getExceptionDescriptionString(e));
			throw e;
		} finally {
			session.close();
		}
		return lessons;
	}

}
