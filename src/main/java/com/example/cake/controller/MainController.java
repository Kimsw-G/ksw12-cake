package com.example.cake.controller;

import com.example.cake.model.entity.StoreEntity;
import com.example.cake.service.MainService;
import com.example.cake.util.ControllerManage;
import com.example.cake.util.MainPath;
import com.example.cake.util.UserPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/main")
public class MainController extends ControllerManage implements UserPath, MainPath {


    @Autowired
    MainService mainService;
    @Resource
    HttpSession session;

    @GetMapping("/stores")
    public String goMain(Model model,
                       @RequestParam(value="search",defaultValue = "")String search){
        if(search.equals("")){
            mainService.setStoreInfo(model);
        }else {
            mainService.searchStoreInfo(model,search);
        }
        setPage(model,STORES);
        return TEMPLATE;
    }

    @GetMapping("store")
    public String goStoreDetail(Model model, StoreEntity storeEntity){
        // 해당 가게의 정보를 전부 가지고 오기
        System.out.println(storeEntity.getS_pk());
        mainService.setStoreInfoByPk(model,storeEntity);

        setPage(model,STORE);
        return TEMPLATE;
    }

}
