package me.waiyan.bokmarc.controller;

import javax.servlet.http.HttpServletResponse;

import me.waiyan.bokmarc.model.Message;
import me.waiyan.bokmarc.model.User;
import me.waiyan.bokmarc.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class RegisterController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="register", method=RequestMethod.GET)
	public String register(){
		System.out.println("forward to register");
		return "forward:/resources/register.html";
	}
	
	/* after successfully registered, return a message json */
	@RequestMapping(value="/register", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Message processRegister(@RequestBody User user){
		System.out.println(user);
		userService.addUser(user);
		
		return new Message("Successfully registered, please login!");
	}
}
