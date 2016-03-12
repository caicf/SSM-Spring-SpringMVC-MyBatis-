package com.huihua.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.huihua.model.User;
import com.huihua.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
   
    private UserService userService;  
      
    public UserService getUserService() {
		return userService;
	}
    @Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value="/showUser")  
    public String toIndex(HttpServletRequest request,Model model){  
        int userId = Integer.parseInt(request.getParameter("id"));  
        User user = this.userService.getUserById(userId);  
        model.addAttribute("user", user);  
        System.out.println("====");
        return "showUser";  
    }  
	
	@RequestMapping(value="/login")
	public String login() {
		System.out.println("====");
		return "showUser";
	}
	
}
