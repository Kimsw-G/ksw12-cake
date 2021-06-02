package com.example.cake.controller;

import org.springframework.ui.Model;

public class ControllerManage {
    final static public String TEMPLATE = "template";

    protected void setPage(Model model,String page){
        model.addAttribute("page",page);
    }
}
