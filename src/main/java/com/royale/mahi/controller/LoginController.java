package com.royale.mahi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@RequestMapping(value = {"/"}, method = RequestMethod.GET)
	public String index() {
		return "login";
	}
	
	@RequestMapping(value = {"/top"}, method = RequestMethod.GET)
	public String top() {
		return "top";
	}
}
