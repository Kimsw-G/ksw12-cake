package com.example.cake.model;

import com.example.cake.model.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.io.Serializable;

@Getter
@Setter
@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION,proxyMode = ScopedProxyMode.TARGET_CLASS)
@ToString
public class LoginInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    private int u_pk;
    private String u_id;
    private int u_type;

    public void setInfo(UserEntity userEntity){
        this.setU_pk(userEntity.getU_pk());
        this.setU_id(userEntity.getU_id());
        this.setU_type(userEntity.getU_type());
    }
}
