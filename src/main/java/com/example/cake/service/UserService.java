package com.example.cake.service;

import com.example.cake.dao.UserDAO;
import com.example.cake.model.dto.UserDTO;
import com.example.cake.model.entity.UserEntity;
import com.example.cake.util.UserPath;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserService {

    @Autowired
    UserDAO userDAO;

    // 로그인 검사하기
    public boolean checkLogin(UserEntity userEntity){
        return BCrypt.checkpw(userEntity.getU_pw(), userDAO.selectPasswordById(userEntity));
    }
    public void completeLogin(HttpSession session, UserEntity userEntity){
        session.setAttribute("loginInfo",userDAO.selectUserInfoById(userEntity));
    }

    // insert info and check auth
    public int tryJoin(UserDTO userDTO){
        userDTO.setU_type(0);
        if(userDTO.getAuthKey().equals(UserPath.AUTH_KEY)) userDTO.setU_type(1);
        userDTO.setU_pw(BCrypt.hashpw(userDTO.getU_pw(),BCrypt.gensalt()));
        return userDAO.insertUserInfo(userDTO);
    }

    // check pw == pwck?
    public boolean checkPw(UserDTO userDTO){
        return userDTO.getU_pw().equals(userDTO.getU_pwck());
    }
    // check duplicated id
    public boolean checkId(UserDTO userDTO){
        if(userDAO.selectIdCount(userDTO)==1) return false;
        return true;
    }
}
