package com.uwc.spring.UWC.Controller;

import java.util.*;
import java.sql.Date;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.uwc.spring.UWC.Dao.*;
import com.uwc.spring.UWC.Model.User;

@Controller
public class HomeController extends BaseController{
	
	private UserDao userDao = new UserDao();
	private TaskDao taskDao = new TaskDao();
	
	@RequestMapping(value = {"/",  "/index"}, method =RequestMethod.GET)
	public ModelAndView index() {
		_modelAndView.setViewName("user/index");
		
		
		
		List<User> ls = userDao.getAllUser();
		_modelAndView.addObject("allUser", ls);
		
		return _modelAndView;
	}
	
	
}
