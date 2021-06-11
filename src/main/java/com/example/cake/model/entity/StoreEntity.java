package com.example.cake.model.entity;

import lombok.Data;

@Data
public class StoreEntity {
    
    private int s_pk;
    private String s_name;
    private String s_loc;
    private String s_time;
    private String s_ctnt;
    private int u_pk;
}
