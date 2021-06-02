package com.example.cake.controller;

import com.example.cake.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController extends ControllerManage{

    final static String STORES = "stores";

    @Autowired
    MainService mainService;

    @RequestMapping("/main")
    public String main(Model model){
        // 어떤 정보를 가져와야 할까요?
        // store에 넣어줄 table store의 정보를 가져오자


        mainService.setStoreInfo(model);
        setPage(model,STORES);
        return TEMPLATE;
    }

    @RequestMapping("/search")
    public String search(){

        return TEMPLATE;
    }
}
