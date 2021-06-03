package com.example.cake.dao;

import com.example.cake.model.entity.StoreEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StoreDAO {
    List<StoreEntity> selectAllStore();
    List<StoreEntity> selectAllStoreBySearch(String search);
}
