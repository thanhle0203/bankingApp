package com.thanhle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class HomePageController {
	@RequestMapping(value = "/home", method = RequestMethod.GET) 
	public String homePage() {
		return "homePageForm";
	}


	//@RequestMapping(value = "/users/signup", method = RequestMethod.GET) 
	//public String signupPage() {
		//return "signupForm";
	//}

}
