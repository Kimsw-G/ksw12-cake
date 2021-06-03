package com.example.cake.util;

import org.springframework.ui.Model;

public class ControllerManage {
    final static public String TEMPLATE = "template";

    final static public String REDIRECT = "redirect:";
    final static public String FORWARD = "forward:";

    protected void setPage(Model model,String page){
        model.addAttribute("page",page);
    }
}
