package com.example.cake.service;

import com.example.cake.dao.StoreDAO;
import com.example.cake.dao.UserDAO;
import com.example.cake.model.dto.UserDTO;
import com.example.cake.model.entity.StoreEntity;
import com.example.cake.model.entity.UserEntity;
import com.example.cake.util.UserPath;
import org.apache.commons.io.FilenameUtils;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;

@Service
public class UserService {

    @Autowired
    UserDAO userDAO;
    @Autowired
    StoreDAO storeDAO;

    // 로그인 검사하기
    public boolean checkLogin(UserEntity userEntity){
        return BCrypt.checkpw(userEntity.getU_pw(), userDAO.selectPasswordById(userEntity));
    }
    // 로그인 후 세션 적재
    public void completeLogin(HttpSession session, UserEntity userEntity){
        session.setAttribute("loginInfo",userDAO.selectUserInfoById(userEntity));
    }
    // 회원가입 하기
    public int tryJoin(UserDTO userDTO){
        userDTO.setU_type(0);
        // 권한 키 확인
        if(userDTO.getAuthKey().equals(UserPath.AUTH_KEY)) userDTO.setU_type(1);
        userDTO.setU_pw(BCrypt.hashpw(userDTO.getU_pw(),BCrypt.gensalt()));
        return userDAO.insertUserInfo(userDTO);
    }

    // 패스워드 일치검사
    public boolean checkPw(UserDTO userDTO){
        return userDTO.getU_pw().equals(userDTO.getU_pwck());
    }
    // 아이디 중복검사
    public boolean checkId(UserDTO userDTO){
        if(userDAO.selectIdCount(userDTO)==1) return false;
        return true;
    }

}
