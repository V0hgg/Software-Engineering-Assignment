package com.uwc.spring.UWC.Controller;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.uwc.spring.UWC.Model.*;

@Controller
public class BaseController {
	public ModelAndView _modelAndView = new ModelAndView();
	
	@PostConstruct
	public ModelAndView Init() {
		_modelAndView.addObject("user", new User());
		return _modelAndView;
		
		
		
	}
}

