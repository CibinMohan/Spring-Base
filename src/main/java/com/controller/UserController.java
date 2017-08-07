package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dao.UserDao;
import com.domain.User;
import com.services.UserService;

@Controller
@RequestMapping("/*")
public class UserController {

@Autowired
UserService userService;	
@RequestMapping(value = "/addUser", method = RequestMethod.GET )
public ModelAndView getName()
{
	User user = new User();
	user.setUserName("YourName");

	ModelAndView mb = new ModelAndView("addUser", "user",user );
	return mb;
	}

@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
public ModelAndView listName(User user)
{
	System.out.println(user.getUserId()+"---"+user.getUserName()+"---"+user.getUserEmail()+"---");
	userService.persist(user);
	System.out.println("sv2");

	ModelAndView mb = new ModelAndView("viewUser", "userData", userService.getAll());
	return mb;
	}
}
