package com.example.cake.controller;

import com.example.cake.model.LoginInfo;
import com.example.cake.model.dto.UserDTO;
import com.example.cake.model.entity.UserEntity;
import com.example.cake.service.UserService;
import com.example.cake.util.ControllerManage;
import com.example.cake.util.MainPath;
import com.example.cake.util.UserPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/user")
public class UserController extends ControllerManage implements UserPath, MainPath {



    @Autowired
    UserService userService;
    @Resource
    LoginInfo loginInfo;

    @GetMapping("/login")
    public String login(Model model){

        setPage(model,LOGIN);
        return TEMPLATE;
    }

    @PostMapping("/login")
    public String doLogin(UserEntity userEntity,Model model){
        // userEntity를 검사하는 메소드 실행
        if(userService.checkLogin(userEntity)){ // 로그인 성공!
            userService.completeLogin(loginInfo,userEntity,model);
        }

        return REDIRECT+STORES;
    }

    @GetMapping("/join")
    public String join(Model model){
        // 단순 JoinPage로 보내주기

        setPage(model,JOIN);
        return TEMPLATE;
    }

    @PostMapping("/join")
    public String doJoin( UserDTO userDTO,Model model){
        // UserEntity를 바탕으로 회원정보 넣기
        if(userService.checkPw(userDTO)){
            userService.tryJoin(userDTO);
            return REDIRECT+STORES;
        }
        String errMsg = "패스워드가 다릅니다!";
        return REDIRECT+JOIN;
    }
}
