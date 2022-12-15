package com.uwc.spring.UWC.Controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uwc.spring.UWC.Dao.*;
import com.uwc.spring.UWC.Model.*;

@Controller
public class UserController extends BaseController{
	
	
	private UserDao userDao = new UserDao();
	
	
	@RequestMapping(value = {"/login"}, method =RequestMethod.GET)
	public ModelAndView login() {
		_modelAndView.setViewName("user/login");
		
		return _modelAndView;
	}
	
	@RequestMapping(value = {"/loginHandelling"}, method =RequestMethod.POST)
	public ModelAndView loginHandelling(@ModelAttribute User userModel, HttpServletRequest request) {
		User userAuthen = userDao.checkLogin(userModel);
		if(userAuthen != null) {
			_modelAndView.setViewName("user/index");
			HttpSession session = request.getSession();
			session.setAttribute("currentUser", userAuthen);
		}
		else {
			_modelAndView.setViewName("user/login");
			HttpSession session = request.getSession();
			session.setAttribute("fail_mess", "please check again");
		}
		
		return _modelAndView;
	}
	
	@RequestMapping(value = {"/profile"}, method =RequestMethod.GET)
	public ModelAndView profile(HttpServletRequest request) {
		_modelAndView.setViewName("user/profile");
		
		return _modelAndView;
	}
	
	@RequestMapping(value = {"/edit"}, method =RequestMethod.GET)
	public ModelAndView edit(HttpServletRequest request, @RequestParam int id) {
		_modelAndView.setViewName("user/index");
		return _modelAndView;
	}
	
	@RequestMapping(value = {"/logout"}, method =RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("currentUser");
		
		_modelAndView.setViewName("user/index");
		return _modelAndView;
	}
	
	
}
