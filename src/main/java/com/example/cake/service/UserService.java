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

    // 해당 pk의 가게 정보가 있는지 검사
    public boolean checkStoreInfo(StoreEntity storeEntity){
        // 가게 정보가 있으면 true
        return 1==storeDAO.selectStoreDuple(storeEntity);
    }

    // 가게 정보 가지고오기
    public StoreEntity getStoreInfoByUpk(StoreEntity storeEntity){
        return storeDAO.selectStoreByUPk(storeEntity);
    }
    // 가게 등록하기
    public void regitStore(StoreEntity storeEntity){
        // 이미 있다면?
        if(checkStoreInfo(storeEntity)){
            // 값이 있을시 값을 업데이트 한다
            storeDAO.updateStoreInfo(storeEntity);
        }// 없을시 값을 넣는다
        storeDAO.insertStoreInfo(storeEntity);
    }
    
    // 파일 등록하기
    public String regitFile(MultipartFile file,int u_pk,String path_){

        new File(path_+"/"+u_pk).mkdir();
        String _path = "";
        try{
            String ext = FilenameUtils.getExtension(file.getOriginalFilename());
            _path = String.format("/%d/%d.%s",u_pk,u_pk,ext);
            System.out.println(path_+_path);
            File dest = new File(path_+_path);
            file.transferTo(dest);
        }catch (Exception e){
            e.printStackTrace();
            // 추후 이곳에 디폴트 이미지 경로 넣기
            _path = "";
        }finally {
            return _path;
        }
    }
}
