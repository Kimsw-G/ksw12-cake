package com.example.cake.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController extends ControllerManage{


    final static String LOGIN = "login";
    final static String JOIN = "join";

    @GetMapping("/login")
    public String login(Model model){

        setPage(model,LOGIN);
        return TEMPLATE;
    }

    public String doLogin(){


        return "";
    }
}
