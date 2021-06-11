package com.example.cake.service;

import com.example.cake.dao.StoreDAO;
import com.example.cake.model.dto.MenuDTO;
import com.example.cake.model.entity.M_PictureEntity;
import com.example.cake.model.entity.MenuEntity;
import com.example.cake.model.entity.StoreEntity;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class StoreService {

    @Autowired
    StoreDAO storeDAO;

    // 해당 pk의 가게 정보가 있는지 검사
    public boolean checkStoreInfoByUPk(StoreEntity storeEntity){
        // 가게 정보가 있으면 true
        return 1==storeDAO.selectStoreDuple(storeEntity);
    }

    // 가게 정보 가지고오기
    public StoreEntity getStoreInfoByUpk(StoreEntity storeEntity){
        return storeDAO.selectStoreByUPk(storeEntity);
    }
    // 가게 등록하기
    public void registStore(StoreEntity storeEntity){
        // 이미 있다면?
        if(checkStoreInfoByUPk(storeEntity)){
            // 값이 있을시 값을 업데이트 한다
            storeDAO.updateStoreInfo(storeEntity);
        }// 없을시 값을 넣는다
        storeDAO.insertStoreInfo(storeEntity);
    }
    // 메뉴 정보 가져오기
    public List<MenuDTO> getMenuInfoBySPk(StoreEntity storeEntity){
        List<MenuDTO> list  = storeDAO.selectMenusBySPk(storeEntity);
        System.out.println(list.size());
        return list;
    }
    public List<M_PictureEntity> getMenuPictureByMPk(MenuEntity menuEntity){
        List<M_PictureEntity> list = storeDAO.selectMenuPictureByMPk(menuEntity);

        return list;
    }
    // 메뉴 등록하기
    public void registMenu(MenuEntity menuEntity){
        storeDAO.insertMenuInfo(menuEntity);
    }

    public int getSPkByUPk(StoreEntity storeEntity){
        return storeDAO.selectSPkByUPk(storeEntity);
    }


    // 파일 등록하기
    public void registFile(MultipartFile file, int u_pk, String path_){

        new File(path_+"/"+u_pk).mkdir();
        String _path = "";
        try{
            String ext = FilenameUtils.getExtension(file.getOriginalFilename());
            _path = "/"+u_pk;
            System.out.println(path_+_path);
            File dest = new File(String.format("%s%s/main.jpg",path_,_path));
            file.transferTo(dest);
        }catch (Exception e){
            e.printStackTrace();
            // 추후 이곳에 디폴트 이미지 경로 넣기
            _path = "";
        }
    }

}
