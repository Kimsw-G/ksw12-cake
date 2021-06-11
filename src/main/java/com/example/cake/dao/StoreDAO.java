package com.example.cake.dao;

import com.example.cake.model.dto.MenuDTO;
import com.example.cake.model.entity.M_PictureEntity;
import com.example.cake.model.entity.MenuEntity;
import com.example.cake.model.entity.StoreEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StoreDAO {
    List<StoreEntity> selectAllStore();
    List<StoreEntity> selectAllStoreBySearch(String search);

    StoreEntity selectStoreByUPk(StoreEntity storeEntity);
    StoreEntity selectStoreBySPk(StoreEntity storeEntity);
    List<MenuDTO> selectMenusBySPk(StoreEntity storeEntity);
    List<M_PictureEntity> selectMenuPictureByMPk(MenuEntity menuEntity);

    int selectStoreDuple(StoreEntity entity);

    int selectSPkByUPk(StoreEntity storeEntity);

    int insertStoreInfo(StoreEntity entity);
    int updateStoreInfo(StoreEntity entity);

    int insertMenuInfo(MenuEntity entity);
    int deleteMenuInfo(MenuEntity entity);


}
