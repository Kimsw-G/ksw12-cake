package com.example.cake.controller;

import com.example.cake.model.dto.MenuDTO;
import com.example.cake.model.entity.StoreEntity;
import com.example.cake.service.StoreService;
import com.example.cake.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/store")
public class StoreController extends ControllerManage implements StorePath, ErrorCodeList {

    @Autowired
    StoreService storeService;
    @Autowired
    HttpSession session;

    // mystore
    @GetMapping("/mystore")
    public String goMyStore(StoreEntity storeEntity,//u_pk 가져옴!
                            Model model){
        // 이미 가게가 존재시?
        if(storeService.checkStoreInfoByUPk(storeEntity)){
            model.addAttribute("storeInfo", storeService.getStoreInfoByUpk(storeEntity));
        }

        model.addAttribute("u_pk",storeEntity.getU_pk());
        setPage(model,MYSTORE);
        return TEMPLATE;
    }
    @PostMapping("/mystore")
    public String doMyStore(StoreEntity storeEntity,
                            @RequestParam(value = "file") MultipartFile file, HttpServletRequest request){
        // file 저장.
        // TODO : 서버에 넣을때 추후 경로 변경 필요
        storeService.registFile(file,storeEntity.getU_pk(),
                request.getSession().getServletContext().getRealPath("/img"));
        // 가게 등록
        storeService.registStore(storeEntity);
        return REDIRECT+MainPath.STORES;
    }

    @GetMapping("/mymenu")
    public String goMyMenu(StoreEntity storeEntity, // u_pk 가져옴
                           Model model){
        if(storeService.checkStoreInfoByUPk(storeEntity))
        storeEntity.setS_pk(storeService.getSPkByUPk(storeEntity));
        List<MenuDTO> list = storeService.getMenuInfoBySPk(storeEntity);
        for (MenuDTO dto:
             list) {
            dto.setMp_pictures(storeService.getMenuPictureByMPk(dto));
        }
        System.out.println(list.get(0).getM_pk());

        model.addAttribute("menuInfo",list);
        model.addAttribute("s_pk",storeService.getSPkByUPk(storeEntity));

        setPage(model,MYMENU);
        return TEMPLATE;
    }

    @PostMapping("/mymenu")
    public String doMyMenu(StoreEntity storeEntity){


        return REDIRECT+MYMENU;
    }
}
