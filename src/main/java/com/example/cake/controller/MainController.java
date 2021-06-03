package com.example.cake.controller;

import com.example.cake.model.LoginInfo;
import com.example.cake.service.MainService;
import com.example.cake.util.ControllerManage;
import com.example.cake.util.MainPath;
import com.example.cake.util.UserPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/main")
public class MainController extends ControllerManage implements UserPath, MainPath {


    @Autowired
    MainService mainService;
    @Resource
    LoginInfo loginInfo;

    @RequestMapping("/stores")
    public String main(Model model){
        // 어떤 정보를 가져와야 할까요?
        // store에 넣어줄 table store의 정보를 가져오자


//        mainService.setStoreInfo(model);
        setPage(model,STORES);
        return TEMPLATE;
    }

    @RequestMapping("/search")
    public String search(){

        return TEMPLATE;
    }
}
