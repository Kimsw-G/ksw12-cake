package com.example.cake.controller;

import com.example.cake.util.ControllerManage;
import com.example.cake.util.MainPath;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class RootController extends ControllerManage implements MainPath {
    @RequestMapping("/")
    public String root(){
        return REDIRECT+STORES;
    }
}
