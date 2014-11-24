package com.myspring.springdemo.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myspring.springdemo.controllers.form.AddLessonForm;
import com.myspring.springdemo.domain.Lesson;
import com.myspring.springdemo.service.LessonService;
import com.myspring.springdemo.service.UserService;

@Controller
public class LessonController {

	@Autowired
	private UserService userService;

	@Autowired
	private LessonService lessonService;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String prepareHome(ModelMap map, HttpServletRequest request) {

		/*
		 * SecurityLiveStreamForm liveStreamForm = new SecurityLiveStreamForm();
		 * map.addAttribute("securityLiveStreamForm", liveStreamForm);
		 */
		HttpSession session = request.getSession();

		if (null == session.getAttribute("email")) {		
			return "redirect:/registration.htm";
		}

		List<Lesson> list = lessonService.getAllLessons(userService
				.getUserByEmail(((String) session.getAttribute("email"))));
		session.setAttribute("lessonList", list);

		return "home";
	}

	@RequestMapping(value = "/showAddLessonForm", method = RequestMethod.GET)
	public ModelAndView showAddLessonForm(ModelMap map,
			HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("addLesson");

		AddLessonForm form = new AddLessonForm();
		modelAndView.addObject("addLessonForm", form);

		return modelAndView;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public LessonService getLessonService() {
		return lessonService;
	}

	public void setLessonService(LessonService lessonService) {
		this.lessonService = lessonService;
	}

	@RequestMapping(value = "/addLesson", method = RequestMethod.POST)
	public String addLesson(
			final RedirectAttributes redirectAttributes,
			@Valid @ModelAttribute("addLessonForm") AddLessonForm addLessonForm,
			BindingResult result, ModelMap map, HttpServletRequest request) {
		HttpSession session = request.getSession();

		if (result.hasErrors()) {
			return "addLesson";
		}

		lessonService.saveLesson(addLessonForm,
				((String) session.getAttribute("email")));

		return "redirect:/home.htm";

	}

	@RequestMapping(value = "/deleteLesson", method = RequestMethod.GET)
	public String deteleLesson(@RequestParam Long lessonId,
			HttpServletRequest request) {
		Lesson lesson = lessonService.getLesson(lessonId);

		lesson.setDeleted(true);
		lessonService.saveLesson(lesson);

		return "redirect:/home.htm";
	}
}
