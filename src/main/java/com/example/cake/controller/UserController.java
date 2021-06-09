package com.example.cake.controller;

import com.example.cake.model.dto.UserDTO;
import com.example.cake.model.entity.StoreEntity;
import com.example.cake.model.entity.UserEntity;
import com.example.cake.service.UserService;
import com.example.cake.util.ControllerManage;
import com.example.cake.util.ErrorCodeList;
import com.example.cake.util.MainPath;
import com.example.cake.util.UserPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController extends ControllerManage implements UserPath, MainPath, ErrorCodeList {



    @Autowired
    UserService userService;
    @Autowired
    HttpSession session;

    @GetMapping("/login")
    public String login(Model model){

        setPage(model,LOGIN);
        return TEMPLATE;
    }

    @PostMapping("/login")
    public String doLogin(UserEntity userEntity,Model model){
        // userEntity를 검사하는 메소드 실행
        if(userService.checkLogin(userEntity)){ // 로그인 성공!
            userService.completeLogin(session,userEntity);
        }

        return REDIRECT+STORES;
    }

    @GetMapping("/join")
    public String join(Model model,
                       @RequestParam(value = "errCode",defaultValue = "0")int errCode){
        // 단순 JoinPage로 보내주기
        model.addAttribute("errCode",errCode);

        setPage(model,JOIN);
        return TEMPLATE;
    }

    @PostMapping("/join")
    public String doJoin( UserDTO userDTO){
        // UserEntity를 바탕으로 회원정보 넣기
        if(!userService.checkPw(userDTO)){// 패스워드가 다르다!
            return REDIRECT+JOIN+ERROR_QUERY_START+WRONG_PWCK;
        }else if(!userService.checkId(userDTO)){// 아이디가 중복됐다!
            return REDIRECT+JOIN+ERROR_QUERY_START+OVERLAPED_ID;
        }

        userService.tryJoin(userDTO);
        return REDIRECT+STORES;
    }

    @GetMapping("/logout")
    public String doLogout(){
        session.invalidate();
        return REDIRECT+STORES;
    }

    // mystore
    @GetMapping("/mystore")
    public String goMyStore(StoreEntity storeEntity,
                            Model model){
        // 이미 가게가 존재시?
        if(userService.checkStoreInfo(storeEntity)){
            model.addAttribute("storeInfo", userService.getStoreInfoByUpk(storeEntity));
        }

        model.addAttribute("u_pk",storeEntity.getU_pk());
        setPage(model,MYSTORE);
        return TEMPLATE;
    }
    @PostMapping("/mystore")
    public String doMyStore(StoreEntity storeEntity, @RequestParam(value = "file") MultipartFile file, HttpServletRequest request){
        // File을 집어넣고, storeEntity에 파일 이름,경로등을 저장하기
        storeEntity.setS_profile(userService.regitFile(file,storeEntity.getU_pk(),request.getSession().getServletContext().getRealPath("/img")));
        // 여기서 가게를 등록하는 SQL 호출
        userService.regitStore(storeEntity);
        return REDIRECT+STORES;
    }
}
