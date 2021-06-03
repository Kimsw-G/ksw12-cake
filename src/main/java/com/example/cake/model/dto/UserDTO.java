package com.example.cake.model.dto;

import com.example.cake.model.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDTO extends UserEntity {
    private String authKey;
    private String u_pwck;
}
