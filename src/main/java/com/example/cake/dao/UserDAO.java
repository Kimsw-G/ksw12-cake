package com.example.cake.dao;

import com.example.cake.model.entity.StoreEntity;
import com.example.cake.model.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDAO {

    List<StoreEntity> selectAllStore();
    String selectPasswordById(UserEntity entity);
    UserEntity selectUserInfoById(UserEntity entity);
    int insertUserInfo(UserEntity entity);
}
