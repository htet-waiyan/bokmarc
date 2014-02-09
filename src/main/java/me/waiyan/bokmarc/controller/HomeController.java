package me.waiyan.bokmarc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index(){
		System.out.println("Forwarding to index");
		return "forward:/resources/index.html";
	}
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String home(){
		System.out.println("Forwarding to home");
		return "forward:/resources/templates/home.html";
	}
}
