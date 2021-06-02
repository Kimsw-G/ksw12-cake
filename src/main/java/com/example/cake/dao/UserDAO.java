package com.example.cake.dao;

import com.example.cake.model.StoreEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDAO {

    List<StoreEntity> selectAllStore();
}
