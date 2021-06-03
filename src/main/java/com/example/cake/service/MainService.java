package com.example.cake.service;

import com.example.cake.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class MainService {

    @Autowired
    UserDAO userDAO;

    public void setStoreInfo(Model model){
        
        model.addAttribute("storeList",userDAO.selectAllStore());
    }
}
