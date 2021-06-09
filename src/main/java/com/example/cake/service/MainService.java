package com.example.cake.service;

import com.example.cake.dao.StoreDAO;
import com.example.cake.dao.UserDAO;
import com.example.cake.model.entity.StoreEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Collections;
import java.util.List;

@Service
public class MainService {

    @Autowired
    UserDAO userDAO;
    @Autowired
    StoreDAO storeDAO;

    // stores에서 가게들의 정보 가져오기
    public void setStoreInfo(Model model){
        setStoreInfoMaster(model,storeDAO.selectAllStore());
    }
    public void searchStoreInfo(Model model,String search){
        setStoreInfoMaster(model,storeDAO.selectAllStoreBySearch(search));
    }
    public void setStoreInfoMaster(Model model, List<StoreEntity> list){
        Collections.shuffle(list);
        model.addAttribute("storeList",list);
    }
    // store에서 해당 s_pk에 해당하는 가게의 정보 가져오기
    public void setStoreInfoByPk(Model model,StoreEntity storeEntity){
        model.addAttribute("store",storeDAO.selectStoreBySPk(storeEntity));
    }
}
