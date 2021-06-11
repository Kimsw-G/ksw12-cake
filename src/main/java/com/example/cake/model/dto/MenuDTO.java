package com.example.cake.model.dto;

import com.example.cake.model.entity.M_PictureEntity;
import com.example.cake.model.entity.MenuEntity;
import lombok.Data;

import java.util.List;

@Data
public class MenuDTO extends MenuEntity {

    private List<M_PictureEntity> mp_pictures;
}
