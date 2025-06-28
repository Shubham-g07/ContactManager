package com.spring.springMaven.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class myController {
	
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	@RequestMapping("/hello")
	public String helloworld() {
		return "helowWorld";
	}

	
	@RequestMapping("/myBook")
	public String returnParam(@RequestParam("BookName") String theBookName, Model model) {
		model.addAttribute("myBookName", theBookName);
		return "myView";
	}
	
}
