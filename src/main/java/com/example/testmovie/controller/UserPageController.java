package com.example.testmovie.controller;

import com.example.testmovie.DAO.User;
import com.example.testmovie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/movie/user")
public class UserPageController {
    @Autowired
    private UserService userService;

    @RequestMapping("/userManage")
    public String userManage(Model model){
        model.addAttribute("users", userService.getAll());
        return "user/user_manage";
    }

    @RequestMapping("/home")
    public String user(Model model){
        model.addAttribute("user",userService.getUserById(new Long(1)));
        return "user/user";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(){
        return "login";
    }

    @RequestMapping(value = "/register")
    public String registerPage(){
        return "register";
    }
}
