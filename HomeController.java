package com.suman.shopping.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.suman.shopping.dao.UserDAO;
import com.suman.shopping.model.User;

@Controller
public class HomeController {
	/*@Autowired
	User user;
*/
	@Autowired
	private UserDAO userDAO;
	

	@RequestMapping("/")
	public String showHome() {
		return "index";
	}

	@RequestMapping("/home")
	public String ShowHome() {
		return "index";
	}

	@RequestMapping("/aboutus")
	public String showAboutUs() {
		return "aboutus";
	}

	@RequestMapping("/viewproducts")
	public String showView() {
		return "viewproducts";
	}

	@RequestMapping("/login")
	public String showLogin() {
		return "login";
	}

	@RequestMapping("/register")
	public ModelAndView ShowRegister() {
		ModelAndView mv = new ModelAndView("register");
		return mv;
	}
	@ModelAttribute
	public User returnObject() {
		return new User();
	}


	
	@RequestMapping(value = "/addus", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User user, BindingResult result, //ModelMap model
			HttpServletRequest request) {
/*
		model.addAttribute("name", user.getUsername());
		model.addAttribute("user_id", user.getUser_id());
		model.addAttribute("emailid", user.getEmailid());
		model.addAttribute("password", user.getPassword());
		model.addAttribute("phno", user.getPhno());

		
		
		
*/		System.out.println(user.getConfirmpassword());
		System.out.println(user.getPassword());
		ModelAndView mv = new ModelAndView("register");
		//user.setRole("ROLE_USER");
		
		if (user.getConfirmpassword().equals(user.getPassword())) {
			userDAO.saveOrUpdate(user);
}

		
		return "login";

	}
	
	
	/*
	\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\*/
	
	@RequestMapping("/validate")
	public ModelAndView checkUser(@RequestParam("ema1") String s1, @RequestParam("psd") String s2) {
		String message;
		ModelAndView mv;
		if (s1.equals("suman@gmail.com") && s2.equals("sa")) {
			message = "valid";
			mv = new ModelAndView("adminhome");
			mv.addObject("info", message);
		} else {
			message = "Entered details are In-valid,Please try again ";
			mv = new ModelAndView("login");
			mv.addObject("info", message);

		}
		return mv;
	}

	
	
	
	
	
	
	
	
	
	

}
